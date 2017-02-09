// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrVideoRenderer.java

package com.google.vr.sdk.widgets.video;

import android.content.Context;
import android.os.SystemClock;
import com.google.vr.sdk.widgets.common.VrWidgetRenderer;
import com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

// Referenced classes of package com.google.vr.sdk.widgets.video:
//            VrVideoPlayer

class VrVideoRenderer extends VrWidgetRenderer
{
    private class LoadVideoRequest
        implements com.google.vr.sdk.widgets.common.VrWidgetRenderer.ApiRequest
    {

        public void execute()
        {
            nativeSetSphericalMetadata(getNativeRenderer(), com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass.SphericalMetadata.toByteArray(metadata));
            nativeSetVideoTexture(getNativeRenderer(), player.bindTexture());
        }

        private final com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass.SphericalMetadata metadata;
        final VrVideoRenderer this$0;

        public LoadVideoRequest(com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass.SphericalMetadata metadata)
        {
            this$0 = VrVideoRenderer.this;
            super();
            this.metadata = metadata;
        }
    }


    public VrVideoRenderer(VrVideoPlayer player, Context context, com.google.vr.sdk.widgets.common.VrWidgetRenderer.GLThreadScheduler glThreadScheduler, float xMetersPerPixel, float yMetersPerPixel, int screenRotation)
    {
        super(context, glThreadScheduler, xMetersPerPixel, yMetersPerPixel, screenRotation);
        this.player = player;
        System.loadLibrary("pano_video_renderer");
    }

    public void setSphericalMetadata(com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass.SphericalMetadata metadata)
    {
        lastVideoRequest = new LoadVideoRequest(metadata);
        postApiRequestToGlThread(lastVideoRequest);
    }

    public void onDrawFrame(GL10 gl)
    {
        if(player.prepareFrame())
        {
            if(player.getCameraRotationMatrix() != null)
                nativeSetCameraRotation(getNativeRenderer(), player.getCameraRotationMatrix());
            super.onDrawFrame(gl);
        }
        if(lastFrameTimeMs == 0L)
            lastFrameTimeMs = SystemClock.elapsedRealtime();
        elapsedFramesSinceMeasurement++;
    }

    public void shutdown()
    {
        player.shutdown();
        super.shutdown();
    }

    protected void onViewDetach()
    {
        player.onViewDetach();
    }

    public void onSurfaceCreated(GL10 gl, EGLConfig config)
    {
        super.onSurfaceCreated(gl, config);
        if(lastVideoRequest != null)
            executeApiRequestOnGlThread(lastVideoRequest);
    }

    float getCurrentFramerate()
    {
        return frameRate;
    }

    protected native long nativeCreate(ClassLoader classloader, Context context, float f);

    protected native void nativeResize(long l, int i, int j, float f, float f1, int k);

    protected native void nativeRenderFrame(long l);

    protected native void nativeSetStereoMode(long l, boolean flag);

    protected native void nativeDestroy(long l);

    protected native void nativeOnPause(long l);

    protected native void nativeOnResume(long l);

    protected native void nativeOnPanningEvent(long l, float f, float f1);

    protected native void nativeGetHeadRotation(long l, float af[]);

    private native void nativeSetSphericalMetadata(long l, byte abyte0[]);

    private native long nativeSetVideoTexture(long l, int ai[]);

    private native void nativeSetCameraRotation(long l, float af[]);

    private static final String TAG = com/google/vr/sdk/widgets/video/VrVideoRenderer.getSimpleName();
    private static final boolean DEBUG = false;
    private VrVideoPlayer player;
    private com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass.SphericalMetadata metadata;
    private float frameRate;
    private int elapsedFramesSinceMeasurement;
    private long lastFrameTimeMs;
    private volatile LoadVideoRequest lastVideoRequest;






}
