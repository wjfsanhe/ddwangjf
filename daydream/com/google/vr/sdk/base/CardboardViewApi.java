// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CardboardViewApi.java

package com.google.vr.sdk.base;

import android.view.MotionEvent;
import android.view.View;
import com.google.vr.ndk.base.GvrSurfaceView;

// Referenced classes of package com.google.vr.sdk.base:
//            GvrView, HeadTransform, Eye, HeadMountedDisplay, 
//            GvrViewerParams, ScreenParams

public interface CardboardViewApi
{

    public abstract void setRenderer(GvrView.Renderer renderer);

    public abstract void setRenderer(GvrView.StereoRenderer stereorenderer);

    public abstract void getCurrentEyeParams(HeadTransform headtransform, Eye eye, Eye eye1, Eye eye2, Eye eye3, Eye eye4);

    public abstract void setStereoModeEnabled(boolean flag);

    public abstract boolean getStereoModeEnabled();

    public abstract boolean setAsyncReprojectionEnabled(boolean flag);

    public abstract boolean getAsyncReprojectionEnabled();

    public abstract void setOnCloseButtonListener(Runnable runnable);

    public abstract HeadMountedDisplay getHeadMountedDisplay();

    public abstract void setNeckModelEnabled(boolean flag);

    public abstract float getNeckModelFactor();

    public abstract void setNeckModelFactor(float f);

    public abstract void resetHeadTracker();

    public abstract void recenterHeadTracker();

    public abstract void updateGvrViewerParams(GvrViewerParams gvrviewerparams);

    public abstract GvrViewerParams getGvrViewerParams();

    public abstract void updateScreenParams(ScreenParams screenparams);

    public abstract ScreenParams getScreenParams();

    public abstract float getInterpupillaryDistance();

    public abstract void setDistortionCorrectionEnabled(boolean flag);

    public abstract boolean getDistortionCorrectionEnabled();

    public abstract void undistortTexture(int i);

    public abstract void setDistortionCorrectionScale(float f);

    public abstract void setMultisampling(int i);

    public abstract void setDepthStencilFormat(int i);

    public abstract void onResume();

    public abstract void onPause();

    public abstract void shutdown();

    public abstract boolean onTouchEvent(MotionEvent motionevent);

    public abstract void setOnCardboardBackListener(Runnable runnable);

    public abstract void setOnCardboardTriggerListener(Runnable runnable);

    public abstract void enableCardboardTriggerEmulation();

    public abstract void setTransitionViewEnabled(boolean flag);

    public abstract void setOnTransitionViewDoneListener(Runnable runnable);

    public abstract View getRootView();

    public abstract GvrSurfaceView getGvrSurfaceView();
}
