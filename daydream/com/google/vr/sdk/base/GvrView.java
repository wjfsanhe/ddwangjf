// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GvrView.java

package com.google.vr.sdk.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.google.vr.cardboard.ContextUtils;
import com.google.vr.ndk.base.GvrSurfaceView;
import javax.microedition.khronos.egl.EGLConfig;

// Referenced classes of package com.google.vr.sdk.base:
//            CardboardViewApi, ImplementationSelector, HeadTransform, Eye, 
//            HeadMountedDisplay, GvrViewerParams, ScreenParams, Viewport

public class GvrView extends FrameLayout
{
    public static interface StereoRenderer
    {

        public abstract void onNewFrame(HeadTransform headtransform);

        public abstract void onDrawEye(Eye eye);

        public abstract void onFinishFrame(Viewport viewport);

        public abstract void onSurfaceChanged(int i, int j);

        public abstract void onSurfaceCreated(EGLConfig eglconfig);

        public abstract void onRendererShutdown();
    }

    public static interface Renderer
    {

        public abstract void onDrawFrame(HeadTransform headtransform, Eye eye, Eye eye1);

        public abstract void onFinishFrame(Viewport viewport);

        public abstract void onSurfaceChanged(int i, int j);

        public abstract void onSurfaceCreated(EGLConfig eglconfig);

        public abstract void onRendererShutdown();
    }


    public GvrView(Context context)
    {
        super(context);
        init(context);
    }

    public GvrView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(context);
    }

    public void setRenderer(Renderer renderer)
    {
        if(renderer == null)
        {
            throw new IllegalArgumentException("Renderer must not be null");
        } else
        {
            cardboardViewApi.setRenderer(renderer);
            return;
        }
    }

    public void setRenderer(StereoRenderer renderer)
    {
        if(renderer == null)
        {
            throw new IllegalArgumentException("StereoRenderer must not be null");
        } else
        {
            cardboardViewApi.setRenderer(renderer);
            return;
        }
    }

    public void getCurrentEyeParams(HeadTransform head, Eye leftEye, Eye rightEye, Eye monocular, Eye leftEyeNoDistortionCorrection, Eye rightEyeNoDistortionCorrection)
    {
        cardboardViewApi.getCurrentEyeParams(head, leftEye, rightEye, monocular, leftEyeNoDistortionCorrection, rightEyeNoDistortionCorrection);
    }

    public void setStereoModeEnabled(boolean enabled)
    {
        cardboardViewApi.setStereoModeEnabled(enabled);
    }

    public boolean getStereoModeEnabled()
    {
        return cardboardViewApi.getStereoModeEnabled();
    }

    public boolean setAsyncReprojectionEnabled(boolean enabled)
    {
        return cardboardViewApi.setAsyncReprojectionEnabled(enabled);
    }

    public boolean getAsyncReprojectionEnabled()
    {
        return cardboardViewApi.getAsyncReprojectionEnabled();
    }

    public void setOnCloseButtonListener(Runnable listener)
    {
        cardboardViewApi.setOnCloseButtonListener(listener);
    }

    public void setTransitionViewEnabled(boolean enabled)
    {
        cardboardViewApi.setTransitionViewEnabled(enabled);
    }

    public void setOnTransitionViewDoneListener(Runnable listener)
    {
        cardboardViewApi.setOnTransitionViewDoneListener(listener);
    }

    public HeadMountedDisplay getHeadMountedDisplay()
    {
        return cardboardViewApi.getHeadMountedDisplay();
    }

    public void setNeckModelEnabled(boolean enabled)
    {
        cardboardViewApi.setNeckModelEnabled(enabled);
    }

    public float getNeckModelFactor()
    {
        return cardboardViewApi.getNeckModelFactor();
    }

    public void setNeckModelFactor(float factor)
    {
        cardboardViewApi.setNeckModelFactor(factor);
    }

    /**
     * @deprecated Method resetHeadTracker is deprecated
     */

    public void resetHeadTracker()
    {
        cardboardViewApi.resetHeadTracker();
    }

    public void recenterHeadTracker()
    {
        cardboardViewApi.recenterHeadTracker();
    }

    public void updateGvrViewerParams(GvrViewerParams gvrViewerParams)
    {
        cardboardViewApi.updateGvrViewerParams(gvrViewerParams);
    }

    public GvrViewerParams getGvrViewerParams()
    {
        return cardboardViewApi.getGvrViewerParams();
    }

    public void updateScreenParams(ScreenParams screenParams)
    {
        cardboardViewApi.updateScreenParams(screenParams);
    }

    public ScreenParams getScreenParams()
    {
        return cardboardViewApi.getScreenParams();
    }

    public float getInterpupillaryDistance()
    {
        return cardboardViewApi.getInterpupillaryDistance();
    }

    public void setDistortionCorrectionEnabled(boolean enabled)
    {
        cardboardViewApi.setDistortionCorrectionEnabled(enabled);
    }

    public boolean getDistortionCorrectionEnabled()
    {
        return cardboardViewApi.getDistortionCorrectionEnabled();
    }

    /**
     * @deprecated Method undistortTexture is deprecated
     */

    public void undistortTexture(int inputTexture)
    {
        cardboardViewApi.undistortTexture(inputTexture);
    }

    public void setDistortionCorrectionScale(float scale)
    {
        cardboardViewApi.setDistortionCorrectionScale(scale);
    }

    public void setMultisampling(int numSamples)
    {
        cardboardViewApi.setMultisampling(numSamples);
    }

    public void setDepthStencilFormat(int format)
    {
        cardboardViewApi.setDepthStencilFormat(format);
    }

    public void onResume()
    {
        cardboardViewApi.onResume();
    }

    public void onPause()
    {
        cardboardViewApi.onPause();
    }

    public void shutdown()
    {
        cardboardViewApi.shutdown();
    }

    public boolean onTouchEvent(MotionEvent e)
    {
        if(cardboardViewApi.onTouchEvent(e))
            return true;
        else
            return super.onTouchEvent(e);
    }

    public void setOnCardboardBackListener(Runnable listener)
    {
        cardboardViewApi.setOnCardboardBackListener(listener);
    }

    public void setOnCardboardTriggerListener(Runnable listener)
    {
        cardboardViewApi.setOnCardboardTriggerListener(listener);
    }

    public void enableCardboardTriggerEmulation()
    {
        cardboardViewApi.enableCardboardTriggerEmulation();
    }

    public void queueEvent(Runnable r)
    {
        cardboardViewApi.getGvrSurfaceView().queueEvent(r);
    }

    public void setEGLConfigChooser(int redSize, int greenSize, int blueSize, int alphaSize, int depthSize, int stencilSize)
    {
        cardboardViewApi.getGvrSurfaceView().setEGLConfigChooser(redSize, greenSize, blueSize, alphaSize, depthSize, stencilSize);
    }

    public void setEGLContextClientVersion(int version)
    {
        cardboardViewApi.getGvrSurfaceView().setEGLContextClientVersion(version);
    }

    private void init(Context context)
    {
        if(isInEditMode())
            return;
        if(!ContextUtils.canGetActivity(context))
        {
            throw new IllegalArgumentException("An Activity Context is required for VR functionality.");
        } else
        {
            cardboardViewApi = ImplementationSelector.createCardboardViewApi(context);
            addView(cardboardViewApi.getRootView(), 0);
            GvrSurfaceView gvrSurfaceView = cardboardViewApi.getGvrSurfaceView();
            gvrSurfaceView.setEGLContextClientVersion(2);
            gvrSurfaceView.setPreserveEGLContextOnPause(true);
            return;
        }
    }

    private CardboardViewApi cardboardViewApi;
}
