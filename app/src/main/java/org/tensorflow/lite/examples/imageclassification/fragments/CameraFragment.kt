package org.tensorflow.lite.examples.imageclassification.fragments

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.graphics.Bitmap
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.camera.core.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import org.tensorflow.lite.examples.imageclassification.ImageClassifierHelper
import org.tensorflow.lite.examples.imageclassification.R
import org.tensorflow.lite.examples.imageclassification.databinding.FragmentCameraBinding
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import org.tensorflow.lite.examples.imageclassification.MainViewModel
import android.speech.tts.TextToSpeech
import androidx.camera.lifecycle.ProcessCameraProvider
import org.tensorflow.lite.task.vision.classifier.Classifications
import java.util.Locale

class CameraFragment : Fragment(), ImageClassifierHelper.ClassifierListener {

    companion object {
        private const val TAG = "Image Classifier"
    }

    private var _fragmentCameraBinding: FragmentCameraBinding? = null
    private val fragmentCameraBinding
        get() = _fragmentCameraBinding!!

    private lateinit var imageClassifierHelper: ImageClassifierHelper
    private lateinit var bitmapBuffer: Bitmap
    private val classificationResultsAdapter by lazy {
        ClassificationResultsAdapter().apply {
            updateAdapterSize(imageClassifierHelper.maxResults)
        }
    }
    private var preview: Preview? = null
    private var imageAnalyzer: ImageAnalysis? = null
    private var camera: Camera? = null
    private var cameraProvider: ProcessCameraProvider? = null

    private lateinit var cameraExecutor: ExecutorService

    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var textToSpeech: TextToSpeech
    private val sentence = mutableListOf<String>()

    override fun onResume() {
        super.onResume()

        if (!PermissionsFragment.hasPermissions(requireContext())) {
            Navigation.findNavController(requireActivity(), R.id.fragment_container)
                .navigate(CameraFragmentDirections.actionCameraToPermissions())
        }
    }

    override fun onDestroyView() {
        _fragmentCameraBinding = null
        super.onDestroyView()

        cameraExecutor.shutdown()
        textToSpeech.shutdown()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _fragmentCameraBinding = FragmentCameraBinding.inflate(inflater, container, false)
        return fragmentCameraBinding.root
    }

    @SuppressLint("MissingPermission")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageClassifierHelper =
            ImageClassifierHelper(context = requireContext(), imageClassifierListener = this)

        with(fragmentCameraBinding.recyclerviewResults) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = classificationResultsAdapter
        }

        cameraExecutor = Executors.newSingleThreadExecutor()

        fragmentCameraBinding.viewFinder.post {
            setUpCamera()
        }

        initBottomSheetControls()

        fragmentCameraBinding.addWordButton.setOnClickListener {
            addCurrentWordToSentence()
        }

        fragmentCameraBinding.sendQueryButton.setOnClickListener {
            sendQueryToGPT()
        }

        // Observe the sentenceLiveData from ViewModel
        viewModel.sentenceLiveData.observe(viewLifecycleOwner, Observer { sentence ->
            fragmentCameraBinding.bottomSheetLayout.currentSentenceTextView.text = sentence
        })

        // Initialize TextToSpeech
        textToSpeech = TextToSpeech(requireContext()) { status ->
            if (status != TextToSpeech.ERROR) {
                textToSpeech.language = Locale("tr")
            }
        }
    }

    private fun sendQueryToGPT() {
        viewModel.getGPTResponse(textToSpeech, sentence)
    }

    private fun addCurrentWordToSentence() {
        val currentWord = classificationResultsAdapter.getCurrentWord()
        if (currentWord != null) {
            sentence.add(currentWord)
            updateSentenceTextView()
        } else {
            Log.d(TAG, "No current word available")
        }
    }

    private fun updateSentenceTextView() {
        fragmentCameraBinding.bottomSheetLayout.currentSentenceTextView.text = sentence.joinToString(" ")
    }

    private fun setUpCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext())
        cameraProviderFuture.addListener(
            {
                cameraProvider = cameraProviderFuture.get()
                bindCameraUseCases()
            },
            ContextCompat.getMainExecutor(requireContext())
        )
    }

    private fun initBottomSheetControls() {
        // Initialize your bottom sheet controls here if you have any
    }

    private fun updateControlsUi() {
        imageClassifierHelper.clearImageClassifier()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        imageAnalyzer?.targetRotation = fragmentCameraBinding.viewFinder.display.rotation
    }

    @SuppressLint("UnsafeOptInUsageError")
    private fun bindCameraUseCases() {
        val cameraProvider =
            cameraProvider ?: throw IllegalStateException("Camera initialization failed.")

        val cameraSelector =
            CameraSelector.Builder().requireLensFacing(CameraSelector.LENS_FACING_BACK).build()

        preview =
            Preview.Builder()
                .setTargetAspectRatio(AspectRatio.RATIO_4_3)
                .setTargetRotation(fragmentCameraBinding.viewFinder.display.rotation)
                .build()

        imageAnalyzer =
            ImageAnalysis.Builder()
                .setTargetAspectRatio(AspectRatio.RATIO_4_3)
                .setTargetRotation(fragmentCameraBinding.viewFinder.display.rotation)
                .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                .setOutputImageFormat(ImageAnalysis.OUTPUT_IMAGE_FORMAT_RGBA_8888)
                .build()
                .also {
                    it.setAnalyzer(cameraExecutor) { image ->
                        if (!::bitmapBuffer.isInitialized) {
                            bitmapBuffer = Bitmap.createBitmap(
                                image.width,
                                image.height,
                                Bitmap.Config.ARGB_8888
                            )
                        }
                        classifyImage(image)
                    }
                }

        cameraProvider.unbindAll()

        try {
            camera = cameraProvider.bindToLifecycle(this, cameraSelector, preview, imageAnalyzer)
            preview?.setSurfaceProvider(fragmentCameraBinding.viewFinder.surfaceProvider)
        } catch (exc: Exception) {
            Log.e(TAG, "Use case binding failed", exc)
        }
    }

    private fun getScreenOrientation(): Int {
        val outMetrics = DisplayMetrics()

        val display: Display?
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
            display = requireActivity().display
            display?.getRealMetrics(outMetrics)
        } else {
            @Suppress("DEPRECATION")
            display = requireActivity().windowManager.defaultDisplay
            @Suppress("DEPRECATION")
            display.getMetrics(outMetrics)
        }

        return display?.rotation ?: 0
    }

    private fun classifyImage(image: ImageProxy) {
        image.use { bitmapBuffer.copyPixelsFromBuffer(image.planes[0].buffer) }
        imageClassifierHelper.classify(bitmapBuffer, getScreenOrientation())
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onError(error: String) {
        activity?.runOnUiThread {
            Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
            classificationResultsAdapter.updateResults(null)
            classificationResultsAdapter.notifyDataSetChanged()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onResults(
        results: List<Classifications>?,
        inferenceTime: Long
    ) {
        activity?.runOnUiThread {
            classificationResultsAdapter.updateResults(results)
            classificationResultsAdapter.notifyDataSetChanged()
        }
    }
}