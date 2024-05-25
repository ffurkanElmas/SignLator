package org.tensorflow.lite.examples.imageclassification;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0002+,BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0005J\u0006\u0010\'\u001a\u00020#J\u0010\u0010(\u001a\u00020)2\u0006\u0010&\u001a\u00020\u0005H\u0002J\b\u0010*\u001a\u00020#H\u0002R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006-"}, d2 = {"Lorg/tensorflow/lite/examples/imageclassification/ImageClassifierHelper;", "", "threshold", "", "numThreads", "", "maxResults", "currentDelegate", "currentModel", "context", "Landroid/content/Context;", "imageClassifierListener", "Lorg/tensorflow/lite/examples/imageclassification/ImageClassifierHelper$ClassifierListener;", "(FIIIILandroid/content/Context;Lorg/tensorflow/lite/examples/imageclassification/ImageClassifierHelper$ClassifierListener;)V", "getContext", "()Landroid/content/Context;", "getCurrentDelegate", "()I", "setCurrentDelegate", "(I)V", "getCurrentModel", "setCurrentModel", "imageClassifier", "Lorg/tensorflow/lite/task/vision/classifier/ImageClassifier;", "getImageClassifierListener", "()Lorg/tensorflow/lite/examples/imageclassification/ImageClassifierHelper$ClassifierListener;", "getMaxResults", "setMaxResults", "getNumThreads", "setNumThreads", "getThreshold", "()F", "setThreshold", "(F)V", "classify", "", "image", "Landroid/graphics/Bitmap;", "rotation", "clearImageClassifier", "getOrientationFromRotation", "Lorg/tensorflow/lite/task/core/vision/ImageProcessingOptions$Orientation;", "setupImageClassifier", "ClassifierListener", "Companion", "app_debug"})
public final class ImageClassifierHelper {
    private float threshold;
    private int numThreads;
    private int maxResults;
    private int currentDelegate;
    private int currentModel;
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.Nullable
    private final org.tensorflow.lite.examples.imageclassification.ImageClassifierHelper.ClassifierListener imageClassifierListener = null;
    private org.tensorflow.lite.task.vision.classifier.ImageClassifier imageClassifier;
    @org.jetbrains.annotations.NotNull
    public static final org.tensorflow.lite.examples.imageclassification.ImageClassifierHelper.Companion Companion = null;
    public static final int DELEGATE_CPU = 0;
    public static final int DELEGATE_GPU = 1;
    public static final int DELEGATE_NNAPI = 2;
    public static final int MODEL_MOBILENETV1 = 0;
    public static final int MODEL_EFFICIENTNETV0 = 1;
    public static final int MODEL_EFFICIENTNETV1 = 2;
    public static final int MODEL_EFFICIENTNETV2 = 3;
    private static final java.lang.String TAG = "ImageClassifierHelper";
    
    public ImageClassifierHelper(float threshold, int numThreads, int maxResults, int currentDelegate, int currentModel, @org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    org.tensorflow.lite.examples.imageclassification.ImageClassifierHelper.ClassifierListener imageClassifierListener) {
        super();
    }
    
    public final float getThreshold() {
        return 0.0F;
    }
    
    public final void setThreshold(float p0) {
    }
    
    public final int getNumThreads() {
        return 0;
    }
    
    public final void setNumThreads(int p0) {
    }
    
    public final int getMaxResults() {
        return 0;
    }
    
    public final void setMaxResults(int p0) {
    }
    
    public final int getCurrentDelegate() {
        return 0;
    }
    
    public final void setCurrentDelegate(int p0) {
    }
    
    public final int getCurrentModel() {
        return 0;
    }
    
    public final void setCurrentModel(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final org.tensorflow.lite.examples.imageclassification.ImageClassifierHelper.ClassifierListener getImageClassifierListener() {
        return null;
    }
    
    public final void clearImageClassifier() {
    }
    
    private final void setupImageClassifier() {
    }
    
    public final void classify(@org.jetbrains.annotations.NotNull
    android.graphics.Bitmap image, int rotation) {
    }
    
    private final org.tensorflow.lite.task.core.vision.ImageProcessingOptions.Orientation getOrientationFromRotation(int rotation) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lorg/tensorflow/lite/examples/imageclassification/ImageClassifierHelper$ClassifierListener;", "", "onError", "", "error", "", "onResults", "results", "", "Lorg/tensorflow/lite/task/vision/classifier/Classifications;", "inferenceTime", "", "app_debug"})
    public static abstract interface ClassifierListener {
        
        public abstract void onError(@org.jetbrains.annotations.NotNull
        java.lang.String error);
        
        public abstract void onResults(@org.jetbrains.annotations.Nullable
        java.util.List<? extends org.tensorflow.lite.task.vision.classifier.Classifications> results, long inferenceTime);
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lorg/tensorflow/lite/examples/imageclassification/ImageClassifierHelper$Companion;", "", "()V", "DELEGATE_CPU", "", "DELEGATE_GPU", "DELEGATE_NNAPI", "MODEL_EFFICIENTNETV0", "MODEL_EFFICIENTNETV1", "MODEL_EFFICIENTNETV2", "MODEL_MOBILENETV1", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}