package org.tensorflow.lite.examples.imageclassification.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.tensorflow.lite.examples.imageclassification.databinding.ItemClassificationResultBinding
import org.tensorflow.lite.support.label.Category
import org.tensorflow.lite.task.vision.classifier.Classifications
import kotlin.math.min

class ClassificationResultsAdapter :
    RecyclerView.Adapter<ClassificationResultsAdapter.ViewHolder>() {
    companion object {
        private const val NO_VALUE = "--"
    }

    private var categories: MutableList<Category?> = mutableListOf()
    private var adapterSize: Int = 0

    fun updateResults(listClassifications: List<Classifications>?) {
        categories = MutableList(adapterSize) { null }
        listClassifications?.let { it ->
            if (it.isNotEmpty()) {
                val sortedCategories = it[0].categories.sortedBy { it?.index }
                val min = min(sortedCategories.size, categories.size)
                for (i in 0 until min) {
                    categories[i] = sortedCategories[i]
                }
            }
        }
    }

    fun updateAdapterSize(size: Int) {
        adapterSize = size
    }

    fun getCurrentWord(): String? {
        return categories.firstOrNull()?.label?.let { label ->
            when (label) {
                "0" -> "Ben"
                "1" -> "Sen"
                "2" -> "Merhaba"
                "3" -> "Güle Güle"
                "4" -> "A"
                "5" -> "B"
                else -> label
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemClassificationResultBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        categories[position].let { category ->
            holder.bind(category?.label, category?.score)
        }
    }

    override fun getItemCount(): Int = categories.size

    inner class ViewHolder(private val binding: ItemClassificationResultBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(label: String?, score: Float?) {
            with(binding) {
                var modifiedLabel = label
                when (modifiedLabel) {
                    "0" -> modifiedLabel = "Ben"
                    "1" -> modifiedLabel = "Sen"
                    "2" -> modifiedLabel = "Merhaba"
                    "3" -> modifiedLabel = "Güle Güle"
                    "4" -> modifiedLabel = "A"
                    "5" -> modifiedLabel = "B"
                }
                tvLabel.text = modifiedLabel ?: NO_VALUE
                tvScore.text = if (score != null) String.format("%.2f", score) else NO_VALUE
            }
        }
    }
}