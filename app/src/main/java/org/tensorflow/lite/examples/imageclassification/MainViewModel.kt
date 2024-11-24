package org.tensorflow.lite.examples.imageclassification

import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aallam.openai.api.BetaOpenAI
import com.aallam.openai.api.chat.*
import com.aallam.openai.api.model.ModelId
import com.aallam.openai.client.OpenAI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.tensorflow.lite.examples.imageclassification.TAG
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    val sentenceLiveData = MutableLiveData<String>()

    @OptIn(BetaOpenAI::class)
    fun getGPTResponse(textToSpeech: TextToSpeech, words: List<String>) {
        viewModelScope.launch {
            val openAI = OpenAI(CHAT_GPT_API_KEY)
            val prompt = "By only using these words, make a normal sentence: ${words.joinToString(" ")}"

            try {
                val chatCompletionRequest = ChatCompletionRequest(
                    model = ModelId("gpt-3.5-turbo"),
                    messages = listOf(
                        ChatMessage(
                            role = ChatRole.User,
                            content = prompt
                        )
                    )
                )

                val completion: ChatCompletion = openAI.chatCompletion(chatCompletionRequest)
                val response = completion.choices.first().message?.content

                // Update LiveData to reflect the response
                sentenceLiveData.postValue(response)

                // Speak the response using text to speech
                say(textToSpeech, response)
            } catch (e: Exception) {
                Log.d(TAG, "getGPTResponse: ERROR: ${e.message ?: ""}")
            }
        }
    }

    private fun say(textToSpeech: TextToSpeech, response: String?) {
        textToSpeech.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
            override fun onRangeStart(utteranceId: String?, start: Int, end: Int, frame: Int) {
                super.onRangeStart(utteranceId, start, end, frame)
            }

            override fun onStart(p0: String?) {}

            override fun onDone(p0: String?) {}

            override fun onError(p0: String?) {}
        })

        textToSpeech.speak(
            response,
            TextToSpeech.QUEUE_FLUSH,
            null,
            "utterance_id"
        )
    }

    companion object {
        const val CHAT_GPT_API_KEY = ""
    }
}
