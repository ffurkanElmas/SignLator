package org.tensorflow.lite.examples.imageclassification.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0001KB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020(H\u0003J\u0010\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020(H\u0002J\u0010\u00100\u001a\u00020(2\u0006\u00101\u001a\u000202H\u0016J$\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010;\u001a\u00020(H\u0016J\u0010\u0010<\u001a\u00020(2\u0006\u0010=\u001a\u00020\u001fH\u0017J \u0010>\u001a\u00020(2\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010@2\u0006\u0010B\u001a\u00020CH\u0017J\b\u0010D\u001a\u00020(H\u0016J\u001a\u0010E\u001a\u00020(2\u0006\u0010F\u001a\u0002042\b\u00109\u001a\u0004\u0018\u00010:H\u0017J\b\u0010G\u001a\u00020(H\u0002J\b\u0010H\u001a\u00020(H\u0002J\b\u0010I\u001a\u00020(H\u0002J\b\u0010J\u001a\u00020(H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010\u0013\u001a\u0004\b$\u0010%\u00a8\u0006L"}, d2 = {"Lorg/tensorflow/lite/examples/imageclassification/fragments/CameraFragment;", "Landroidx/fragment/app/Fragment;", "Lorg/tensorflow/lite/examples/imageclassification/ImageClassifierHelper$ClassifierListener;", "()V", "_fragmentCameraBinding", "Lorg/tensorflow/lite/examples/imageclassification/databinding/FragmentCameraBinding;", "bitmapBuffer", "Landroid/graphics/Bitmap;", "camera", "Landroidx/camera/core/Camera;", "cameraExecutor", "Ljava/util/concurrent/ExecutorService;", "cameraProvider", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "classificationResultsAdapter", "Lorg/tensorflow/lite/examples/imageclassification/fragments/ClassificationResultsAdapter;", "getClassificationResultsAdapter", "()Lorg/tensorflow/lite/examples/imageclassification/fragments/ClassificationResultsAdapter;", "classificationResultsAdapter$delegate", "Lkotlin/Lazy;", "fragmentCameraBinding", "getFragmentCameraBinding", "()Lorg/tensorflow/lite/examples/imageclassification/databinding/FragmentCameraBinding;", "imageAnalyzer", "Landroidx/camera/core/ImageAnalysis;", "imageClassifierHelper", "Lorg/tensorflow/lite/examples/imageclassification/ImageClassifierHelper;", "preview", "Landroidx/camera/core/Preview;", "sentence", "", "", "textToSpeech", "Landroid/speech/tts/TextToSpeech;", "viewModel", "Lorg/tensorflow/lite/examples/imageclassification/MainViewModel;", "getViewModel", "()Lorg/tensorflow/lite/examples/imageclassification/MainViewModel;", "viewModel$delegate", "addCurrentWordToSentence", "", "bindCameraUseCases", "classifyImage", "image", "Landroidx/camera/core/ImageProxy;", "getScreenOrientation", "", "initBottomSheetControls", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onError", "error", "onResults", "results", "", "Lorg/tensorflow/lite/task/vision/classifier/Classifications;", "inferenceTime", "", "onResume", "onViewCreated", "view", "sendQueryToGPT", "setUpCamera", "updateControlsUi", "updateSentenceTextView", "Companion", "app_debug"})
public final class CameraFragment extends androidx.fragment.app.Fragment implements org.tensorflow.lite.examples.imageclassification.ImageClassifierHelper.ClassifierListener {
    @org.jetbrains.annotations.NotNull
    public static final org.tensorflow.lite.examples.imageclassification.fragments.CameraFragment.Companion Companion = null;
    private static final java.lang.String TAG = "Image Classifier";
    private org.tensorflow.lite.examples.imageclassification.databinding.FragmentCameraBinding _fragmentCameraBinding;
    private org.tensorflow.lite.examples.imageclassification.ImageClassifierHelper imageClassifierHelper;
    private android.graphics.Bitmap bitmapBuffer;
    private final kotlin.Lazy classificationResultsAdapter$delegate = null;
    private androidx.camera.core.Preview preview;
    private androidx.camera.core.ImageAnalysis imageAnalyzer;
    private androidx.camera.core.Camera camera;
    private androidx.camera.lifecycle.ProcessCameraProvider cameraProvider;
    private java.util.concurrent.ExecutorService cameraExecutor;
    private final kotlin.Lazy viewModel$delegate = null;
    private android.speech.tts.TextToSpeech textToSpeech;
    private final java.util.List<java.lang.String> sentence = null;
    
    public CameraFragment() {
        super();
    }
    
    private final org.tensorflow.lite.examples.imageclassification.databinding.FragmentCameraBinding getFragmentCameraBinding() {
        return null;
    }
    
    private final org.tensorflow.lite.examples.imageclassification.fragments.ClassificationResultsAdapter getClassificationResultsAdapter() {
        return null;
    }
    
    private final org.tensorflow.lite.examples.imageclassification.MainViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override
    public void onResume() {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void sendQueryToGPT() {
    }
    
    private final void addCurrentWordToSentence() {
    }
    
    private final void updateSentenceTextView() {
    }
    
    private final void setUpCamera() {
    }
    
    private final void initBottomSheetControls() {
    }
    
    private final void updateControlsUi() {
    }
    
    @java.lang.Override
    public void onConfigurationChanged(@org.jetbrains.annotations.NotNull
    android.content.res.Configuration newConfig) {
    }
    
    @android.annotation.SuppressLint(value = {"UnsafeOptInUsageError"})
    private final void bindCameraUseCases() {
    }
    
    private final int getScreenOrientation() {
        return 0;
    }
    
    private final void classifyImage(androidx.camera.core.ImageProxy image) {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    @java.lang.Override
    public void onError(@org.jetbrains.annotations.NotNull
    java.lang.String error) {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    @java.lang.Override
    public void onResults(@org.jetbrains.annotations.Nullable
    java.util.List<? extends org.tensorflow.lite.task.vision.classifier.Classifications> results, long inferenceTime) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lorg/tensorflow/lite/examples/imageclassification/fragments/CameraFragment$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}