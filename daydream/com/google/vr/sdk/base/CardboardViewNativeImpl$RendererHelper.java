// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CardboardViewNativeImpl.java

package com.google.vr.sdk.base;

import android.opengl.*;
import android.os.Trace;
import android.util.Log;
import com.google.vr.ndk.base.GvrLayout;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.*;
import javax.microedition.khronos.opengles.GL10;

// Referenced classes of package com.google.vr.sdk.base:
//            CardboardViewNativeImpl, GvrView, ScreenParams, HeadTransform, 
//            Eye

private class stereoMode
    implements android.opengl.rHelper
{

    public void setRenderer(stereoMode renderer)
    {
        this.renderer = renderer;
        CardboardViewNativeImpl.access$1600(CardboardViewNativeImpl.this, CardboardViewNativeImpl.access$100(CardboardViewNativeImpl.this), renderer);
    }

    public void setRenderer(this._cls0 stereoRenderer)
    {
        this.stereoRenderer = stereoRenderer;
        CardboardViewNativeImpl.access$1700(CardboardViewNativeImpl.this, CardboardViewNativeImpl.access$100(CardboardViewNativeImpl.this), stereoRenderer);
    }

    public void setScreenParams(ScreenParams screenParams)
    {
        this.screenParams = screenParams;
    }

    public void shutdown()
    {
        CardboardViewNativeImpl.access$2300(CardboardViewNativeImpl.this, new Runnable() {

            public void run()
            {
                if((renderer != null || stereoRenderer != null) && surfaceCreated)
                {
                    surfaceCreated = false;
                    callOnRendererShutdown();
                }
                CardboardViewNativeImpl.access$2200(this$0).countDown();
            }

            final CardboardViewNativeImpl.RendererHelper this$1;

            
            {
                this.this$1 = CardboardViewNativeImpl.RendererHelper.this;
                super();
            }
        });
    }

    public void setStereoModeEnabled(final boolean enabled)
    {
        CardboardViewNativeImpl.access$2400(CardboardViewNativeImpl.this);
        CardboardViewNativeImpl.access$2500(CardboardViewNativeImpl.this).setStereoModeEnabled(enabled);
        CardboardViewNativeImpl.access$2300(CardboardViewNativeImpl.this, new Runnable() {

            public void run()
            {
                if(stereoMode == enabled)
                    return;
                stereoMode = enabled;
                CardboardViewNativeImpl.access$2700(this$0, CardboardViewNativeImpl.access$100(this$0), enabled);
                if(!EGL10.EGL_NO_SURFACE.equals(((EGL10)EGLContext.getEGL()).eglGetCurrentSurface(12377)))
                    onSurfaceChanged((GL10)null, screenParams.getWidth(), screenParams.getHeight());
            }

            final boolean val$enabled;
            final CardboardViewNativeImpl.RendererHelper this$1;

            
            {
                this.this$1 = CardboardViewNativeImpl.RendererHelper.this;
                enabled = flag;
                super();
            }
        });
    }

    public void getCurrentEyeParams(final HeadTransform head, final Eye leftEye, final Eye rightEye, final Eye monocular, final Eye leftEyeNoDistortionCorrection, final Eye rightEyeNoDistortionCorrection)
    {
        final CountDownLatch finished;
        CardboardViewNativeImpl.access$2400(CardboardViewNativeImpl.this);
        finished = new CountDownLatch(1);
        CardboardViewNativeImpl.access$2300(CardboardViewNativeImpl.this, new Runnable() {

            public void run()
            {
                CardboardViewNativeImpl.access$2900(this$0, CardboardViewNativeImpl.access$100(this$0), head, leftEye, rightEye, monocular, leftEyeNoDistortionCorrection, rightEyeNoDistortionCorrection);
                finished.countDown();
            }

            final HeadTransform val$head;
            final Eye val$leftEye;
            final Eye val$rightEye;
            final Eye val$monocular;
            final Eye val$leftEyeNoDistortionCorrection;
            final Eye val$rightEyeNoDistortionCorrection;
            final CountDownLatch val$finished;
            final CardboardViewNativeImpl.RendererHelper this$1;

            
            {
                this.this$1 = CardboardViewNativeImpl.RendererHelper.this;
                head = headtransform;
                leftEye = eye;
                rightEye = eye1;
                monocular = eye2;
                leftEyeNoDistortionCorrection = eye3;
                rightEyeNoDistortionCorrection = eye4;
                finished = countdownlatch;
                super();
            }
        });
        finished.await();
        break MISSING_BLOCK_LABEL_92;
        InterruptedException e;
        e;
        CardboardViewNativeImpl.access$3000();
        "Interrupted while reading frame params: ";
        String s = String.valueOf(e.toString());
        s;
        if(s.length() == 0) goto _L2; else goto _L1
_L1:
        concat();
          goto _L3
_L2:
        JVM INSTR pop ;
        JVM INSTR new #141 <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
_L3:
        Log.e();
        JVM INSTR pop ;
    }

    public void onDrawFrame(GL10 gl)
    {
        if(renderer == null && stereoRenderer == null || !surfaceCreated)
        {
            return;
        } else
        {
            Trace.beginSection("Render");
            CardboardViewNativeImpl.access$3100(CardboardViewNativeImpl.this, CardboardViewNativeImpl.access$100(CardboardViewNativeImpl.this));
            Trace.endSection();
            EGL14.eglSwapInterval(eglDisplay, 1);
            return;
        }
    }

    public void onSurfaceChanged(GL10 gl, int width, int height)
    {
        if(renderer == null && stereoRenderer == null || !surfaceCreated)
            return;
        if(stereoMode && (width != screenParams.getWidth() || height != screenParams.getHeight()))
        {
            int i;
            int j;
            if(!invalidSurfaceSizeWarningShown)
                Log.e(CardboardViewNativeImpl.access$3000(), (new StringBuilder(134)).append("Surface size ").append(width).append("x").append(height).append(" does not match the expected screen size ").append(i = screenParams.getWidth()).append("x").append(j = screenParams.getHeight()).append(". Stereo rendering might feel off.").toString());
            invalidSurfaceSizeWarningShown = true;
        } else
        {
            invalidSurfaceSizeWarningShown = false;
        }
        CardboardViewNativeImpl.access$3200(CardboardViewNativeImpl.this, CardboardViewNativeImpl.access$100(CardboardViewNativeImpl.this), width, height);
        callOnSurfaceChanged(width, height);
    }

    private void callOnSurfaceCreated(EGLConfig config)
    {
        CardboardViewNativeImpl.access$3300(CardboardViewNativeImpl.this, CardboardViewNativeImpl.access$100(CardboardViewNativeImpl.this));
        if(renderer != null)
            renderer.renderer(config);
        else
        if(stereoRenderer != null)
            stereoRenderer.(config);
    }

    public void onSurfaceCreated(GL10 gl, EGLConfig config)
    {
        if(renderer == null && stereoRenderer == null)
        {
            return;
        } else
        {
            surfaceCreated = true;
            eglDisplay = EGL14.eglGetCurrentDisplay();
            callOnSurfaceCreated(config);
            return;
        }
    }

    private void callOnSurfaceChanged(int width, int height)
    {
        if(renderer != null)
            renderer.renderer(width, height);
        else
        if(stereoRenderer != null)
            if(stereoMode)
                stereoRenderer.(width / 2, height);
            else
                stereoRenderer.(width, height);
    }

    private void callOnRendererShutdown()
    {
        if(renderer != null)
            renderer.renderer();
        else
        if(stereoRenderer != null)
            stereoRenderer.wn();
    }

    private wn renderer;
    private wn stereoRenderer;
    private ScreenParams screenParams;
    private boolean stereoMode;
    private boolean surfaceCreated;
    private boolean invalidSurfaceSizeWarningShown;
    private EGLDisplay eglDisplay;
    final CardboardViewNativeImpl this$0;









    public _cls1.this._cls1()
    {
        this$0 = CardboardViewNativeImpl.this;
        super();
        screenParams = new ScreenParams(getScreenParams());
        stereoMode = CardboardViewNativeImpl.access$1500(CardboardViewNativeImpl.this);
    }
}
