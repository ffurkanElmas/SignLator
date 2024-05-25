package org.tensorflow.lite.examples.imageclassification;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rJ\u001a\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0011"}, d2 = {"Lorg/tensorflow/lite/examples/imageclassification/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "sentenceLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "getSentenceLiveData", "()Landroidx/lifecycle/MutableLiveData;", "getGPTResponse", "", "textToSpeech", "Landroid/speech/tts/TextToSpeech;", "words", "", "say", "response", "Companion", "app_debug"})
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.String> sentenceLiveData = null;
    @org.jetbrains.annotations.NotNull
    public static final org.tensorflow.lite.examples.imageclassification.MainViewModel.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String CHAT_GPT_API_KEY = "sk-proj-VJlE520PjWijaqlE07TyT3BlbkFJ9FM8cQ5C81xLdQp6poNS";
    
    @javax.inject.Inject
    public MainViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getSentenceLiveData() {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {com.aallam.openai.api.BetaOpenAI.class})
    public final void getGPTResponse(@org.jetbrains.annotations.NotNull
    android.speech.tts.TextToSpeech textToSpeech, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> words) {
    }
    
    private final void say(android.speech.tts.TextToSpeech textToSpeech, java.lang.String response) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lorg/tensorflow/lite/examples/imageclassification/MainViewModel$Companion;", "", "()V", "CHAT_GPT_API_KEY", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}