// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrPanoramaRenderer.java

package com.google.vr.sdk.widgets.pano;

import android.content.Context;
import android.graphics.Bitmap;
import com.google.vr.sdk.widgets.common.VrEventListener;
import com.google.vr.sdk.widgets.common.VrWidgetRenderer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

// Referenced classes of package com.google.vr.sdk.widgets.pano:
//            VrPanoramaView

class VrPanoramaRenderer extends VrWidgetRenderer
{
    private class LoadImageFromByteArrayRequest
        implements com.google.vr.sdk.widgets.common.VrWidgetRenderer.ApiRequest
    {

        public void execute()
        {
            nativeLoadImageFromByteArray(getNativeRenderer(), jpegImageData, options, eventListener);
        }

        public final byte jpegImageData[];
        public final VrPanoramaView.Options options;
        public final VrEventListener eventListener;
        final VrPanoramaRenderer this$0;

        public LoadImageFromByteArrayRequest(byte jpegImageData[], VrPanoramaView.Options options, VrEventListener eventListener)
        {
            this$0 = VrPanoramaRenderer.this;
            super();
            this.jpegImageData = jpegImageData;
            this.options = options;
            this.eventListener = eventListener;
        }
    }

    private class LoadBitmapRequest
        implements com.google.vr.sdk.widgets.common.VrWidgetRenderer.ApiRequest
    {

        public void execute()
        {
            nativeLoadImageFromBitmap(getNativeRenderer(), bitmap, options, eventListener);
        }

        public final Bitmap bitmap;
        public final VrPanoramaView.Options options;
        public final VrEventListener eventListener;
        final VrPanoramaRenderer this$0;

        public LoadBitmapRequest(Bitmap bitmap, VrPanoramaView.Options options, VrEventListener eventListener)
        {
            this$0 = VrPanoramaRenderer.this;
            super();
            this.bitmap = bitmap;
            this.options = options;
            this.eventListener = eventListener;
        }
    }


    public VrPanoramaRenderer(Context context, com.google.vr.sdk.widgets.common.VrWidgetRenderer.GLThreadScheduler glThreadScheduler, float xMetersPerPixel, float yMetersPerPixel, int screenRotation)
    {
        super(context, glThreadScheduler, xMetersPerPixel, yMetersPerPixel, screenRotation);
        System.loadLibrary("panorenderer");
    }

    public void loadImageFromBitmap(Bitmap bitmap, VrPanoramaView.Options options, VrEventListener eventListener)
    {
        lastLoadImageRequest = new LoadBitmapRequest(bitmap, options, eventListener);
        postApiRequestToGlThread(lastLoadImageRequest);
    }

    public void loadImageFromByteArray(byte jpegImageData[], VrPanoramaView.Options options, VrEventListener eventListener)
    {
        lastLoadImageRequest = new LoadImageFromByteArrayRequest(jpegImageData, options, eventListener);
        postApiRequestToGlThread(lastLoadImageRequest);
    }

    public void onSurfaceCreated(GL10 gl, EGLConfig config)
    {
        super.onSurfaceCreated(gl, config);
        if(lastLoadImageRequest != null)
            executeApiRequestOnGlThread(lastLoadImageRequest);
    }

    protected native long nativeCreate(ClassLoader classloader, Context context, float f);

    protected native void nativeResize(long l, int i, int j, float f, float f1, int k);

    protected native void nativeDestroy(long l);

    protected native void nativeRenderFrame(long l);

    protected native void nativeSetStereoMode(long l, boolean flag);

    protected native void nativeOnPause(long l);

    protected native void nativeOnResume(long l);

    protected native void nativeOnPanningEvent(long l, float f, float f1);

    protected native void nativeGetHeadRotation(long l, float af[]);

    private native void nativeLoadImageFromBitmap(long l, Bitmap bitmap, VrPanoramaView.Options options, VrEventListener vreventlistener);

    private native void nativeLoadImageFromByteArray(long l, byte abyte0[], VrPanoramaView.Options options, VrEventListener vreventlistener);

    private static final String TAG = com/google/vr/sdk/widgets/pano/VrPanoramaRenderer.getSimpleName();
    private static final boolean DEBUG = false;
    private volatile com.google.vr.sdk.widgets.common.VrWidgetRenderer.ApiRequest lastLoadImageRequest;





}
