// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrWidgetRenderer.java

package com.google.vr.sdk.widgets.common;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.Log;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public abstract class VrWidgetRenderer
    implements android.opengl.GLSurfaceView.Renderer
{
    private class SetStereoModeRequest
        implements ApiRequest
    {

        public void execute()
        {
            nativeSetStereoMode(nativeRenderer, stereoMode);
        }

        public final boolean stereoMode;
        final VrWidgetRenderer this$0;

        public SetStereoModeRequest(boolean stereoMode)
        {
            this$0 = VrWidgetRenderer.this;
            super();
            this.stereoMode = stereoMode;
        }
    }

    protected static interface ApiRequest
    {

        public abstract void execute();
    }

    public static interface GLThreadScheduler
    {

        public abstract void queueGlThreadEvent(Runnable runnable);
    }


    protected VrWidgetRenderer(Context context, GLThreadScheduler glThreadScheduler, float xMetersPerPixel, float yMetersPerPixel, int screenRotation)
    {
        tmpHeadAngles = new float[2];
        this.context = context;
        this.glThreadScheduler = glThreadScheduler;
        this.xMetersPerPixel = xMetersPerPixel;
        this.yMetersPerPixel = yMetersPerPixel;
        this.screenRotation = screenRotation;
    }

    public void setStereoMode(boolean stereoMode)
    {
        lastSetStereoModeRequest = new SetStereoModeRequest(stereoMode);
        postApiRequestToGlThread(lastSetStereoModeRequest);
    }

    public void onSurfaceCreated(GL10 gl, EGLConfig config)
    {
        if(nativeRenderer != 0L)
            nativeDestroy(nativeRenderer);
        nativeRenderer = nativeCreate(getClass().getClassLoader(), context.getApplicationContext(), currentYaw);
        if(lastSetStereoModeRequest != null)
            executeApiRequestOnGlThread(lastSetStereoModeRequest);
    }

    public void onSurfaceChanged(GL10 gl, int w, int h)
    {
        nativeResize(nativeRenderer, w, h, xMetersPerPixel, yMetersPerPixel, screenRotation);
    }

    public void onDrawFrame(GL10 gl)
    {
        if(nativeRenderer != 0L)
            nativeRenderFrame(nativeRenderer);
    }

    public void updateCurrentYaw()
    {
        getHeadRotation(tmpHeadAngles);
        currentYaw = tmpHeadAngles[0];
    }

    protected long getNativeRenderer()
    {
        return nativeRenderer;
    }

    public void shutdown()
    {
        if(nativeRenderer != 0L)
        {
            nativeDestroy(nativeRenderer);
            nativeRenderer = 0L;
        }
    }

    public void onPanningEvent(float translationPixelX, float translationPixelY)
    {
        if(nativeRenderer != 0L)
            nativeOnPanningEvent(nativeRenderer, translationPixelX, translationPixelY);
    }

    public void getHeadRotation(float yawAndPitch[])
    {
        if(nativeRenderer != 0L)
            nativeGetHeadRotation(nativeRenderer, yawAndPitch);
    }

    protected void onViewDetach()
    {
    }

    public void onPause()
    {
        if(nativeRenderer != 0L)
            nativeOnPause(nativeRenderer);
    }

    public void onResume()
    {
        if(nativeRenderer != 0L)
            nativeOnResume(nativeRenderer);
    }

    protected void postApiRequestToGlThread(final ApiRequest apiRequest)
    {
        glThreadScheduler.queueGlThreadEvent(new Runnable() {

            public void run()
            {
                executeApiRequestOnGlThread(apiRequest);
            }

            final ApiRequest val$apiRequest;
            final VrWidgetRenderer this$0;

            
            {
                this.this$0 = VrWidgetRenderer.this;
                apiRequest = apirequest;
                super();
            }
        });
    }

    protected void executeApiRequestOnGlThread(ApiRequest apiRequest)
    {
        if(disableRenderingForTesting)
        {
            Log.i(TAG, "disableRenderingForTesting");
            return;
        }
        if(nativeRenderer == 0L)
            Log.i(TAG, "Native renderer has just been destroyed. Dropping request.");
        else
            apiRequest.execute();
    }

    public Bundle onSaveInstanceState()
    {
        updateCurrentYaw();
        Bundle bundle = new Bundle();
        bundle.putFloat("currentYaw", currentYaw);
        return bundle;
    }

    protected void onRestoreInstanceState(Bundle state)
    {
        Bundle bundle = state;
        currentYaw = bundle.getFloat("currentYaw");
    }

    protected abstract long nativeCreate(ClassLoader classloader, Context context1, float f);

    protected abstract void nativeResize(long l, int i, int j, float f, float f1, int k);

    protected abstract void nativeDestroy(long l);

    protected abstract void nativeRenderFrame(long l);

    protected abstract void nativeSetStereoMode(long l, boolean flag);

    protected abstract void nativeOnPause(long l);

    protected abstract void nativeOnResume(long l);

    protected abstract void nativeOnPanningEvent(long l, float f, float f1);

    protected abstract void nativeGetHeadRotation(long l, float af[]);

    private static final String TAG = com/google/vr/sdk/widgets/common/VrWidgetRenderer.getSimpleName();
    protected static final boolean DEBUG = false;
    private static final String STATE_KEY_CURRENT_YAW = "currentYaw";
    private long nativeRenderer;
    private final Context context;
    private float xMetersPerPixel;
    private float yMetersPerPixel;
    public static boolean disableRenderingForTesting;
    private final int screenRotation;
    private final GLThreadScheduler glThreadScheduler;
    private volatile SetStereoModeRequest lastSetStereoModeRequest;
    private float tmpHeadAngles[];
    private float currentYaw;


}
