// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CardboardViewNativeImpl.java

package com.google.vr.sdk.base;

import android.content.Context;
import android.opengl.*;
import android.os.Trace;
import android.util.Log;
import android.view.*;
import com.google.vr.cardboard.*;
import com.google.vr.ndk.base.*;
import java.lang.reflect.Field;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.*;
import javax.microedition.khronos.opengles.GL10;

// Referenced classes of package com.google.vr.sdk.base:
//            CardboardViewApi, GvrView, HeadMountedDisplayManager, HeadMountedDisplay, 
//            GvrViewerParams, ScreenParams, HeadTransform, Eye

public class CardboardViewNativeImpl
    implements com.google.vr.cardboard.CardboardGLSurfaceView.DetachListener, CardboardViewApi
{
    private class RendererHelper
        implements android.opengl.GLSurfaceView.Renderer
    {

        public void setRenderer(GvrView.Renderer renderer)
        {
            this.renderer = renderer;
            nativeSetRenderer(nativeCardboardView, renderer);
        }

        public void setRenderer(GvrView.StereoRenderer stereoRenderer)
        {
            this.stereoRenderer = stereoRenderer;
            nativeSetStereoRenderer(nativeCardboardView, stereoRenderer);
        }

        public void setScreenParams(ScreenParams screenParams)
        {
            this.screenParams = screenParams;
        }

        public void shutdown()
        {
            queueEvent(new Runnable() {

                public void run()
                {
                    if((renderer != null || stereoRenderer != null) && surfaceCreated)
                    {
                        surfaceCreated = false;
                        callOnRendererShutdown();
                    }
                    shutdownLatch.countDown();
                }

                final RendererHelper this$1;

                
                {
                    this.this$1 = RendererHelper.this;
                    super();
                }
            });
        }

        public void setStereoModeEnabled(final boolean enabled)
        {
            checkNativeCardboardView();
            gvrLayout.setStereoModeEnabled(enabled);
            queueEvent(new Runnable() {

                public void run()
                {
                    if(stereoMode == enabled)
                        return;
                    stereoMode = enabled;
                    nativeSetStereoModeEnabled(nativeCardboardView, enabled);
                    if(!EGL10.EGL_NO_SURFACE.equals(((EGL10)EGLContext.getEGL()).eglGetCurrentSurface(12377)))
                        onSurfaceChanged((GL10)null, screenParams.getWidth(), screenParams.getHeight());
                }

                final boolean val$enabled;
                final RendererHelper this$1;

                
                {
                    this.this$1 = RendererHelper.this;
                    enabled = flag;
                    super();
                }
            });
        }

        public void getCurrentEyeParams(final HeadTransform head, final Eye leftEye, final Eye rightEye, final Eye monocular, final Eye leftEyeNoDistortionCorrection, final Eye rightEyeNoDistortionCorrection)
        {
            final CountDownLatch finished;
            checkNativeCardboardView();
            finished = new CountDownLatch(1);
            queueEvent(new Runnable() {

                public void run()
                {
                    nativeGetCurrentEyeParams(nativeCardboardView, head, leftEye, rightEye, monocular, leftEyeNoDistortionCorrection, rightEyeNoDistortionCorrection);
                    finished.countDown();
                }

                final HeadTransform val$head;
                final Eye val$leftEye;
                final Eye val$rightEye;
                final Eye val$monocular;
                final Eye val$leftEyeNoDistortionCorrection;
                final Eye val$rightEyeNoDistortionCorrection;
                final CountDownLatch val$finished;
                final RendererHelper this$1;

                
                {
                    this.this$1 = RendererHelper.this;
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
            CardboardViewNativeImpl.TAG;
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
                nativeOnDrawFrame(nativeCardboardView);
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
                    Log.e(CardboardViewNativeImpl.TAG, (new StringBuilder(134)).append("Surface size ").append(width).append("x").append(height).append(" does not match the expected screen size ").append(i = screenParams.getWidth()).append("x").append(j = screenParams.getHeight()).append(". Stereo rendering might feel off.").toString());
                invalidSurfaceSizeWarningShown = true;
            } else
            {
                invalidSurfaceSizeWarningShown = false;
            }
            nativeOnSurfaceChanged(nativeCardboardView, width, height);
            callOnSurfaceChanged(width, height);
        }

        private void callOnSurfaceCreated(EGLConfig config)
        {
            nativeOnSurfaceCreated(nativeCardboardView);
            if(renderer != null)
                renderer.onSurfaceCreated(config);
            else
            if(stereoRenderer != null)
                stereoRenderer.onSurfaceCreated(config);
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
                renderer.onSurfaceChanged(width, height);
            else
            if(stereoRenderer != null)
                if(stereoMode)
                    stereoRenderer.onSurfaceChanged(width / 2, height);
                else
                    stereoRenderer.onSurfaceChanged(width, height);
        }

        private void callOnRendererShutdown()
        {
            if(renderer != null)
                renderer.onRendererShutdown();
            else
            if(stereoRenderer != null)
                stereoRenderer.onRendererShutdown();
        }

        private GvrView.Renderer renderer;
        private GvrView.StereoRenderer stereoRenderer;
        private ScreenParams screenParams;
        private boolean stereoMode;
        private boolean surfaceCreated;
        private boolean invalidSurfaceSizeWarningShown;
        private EGLDisplay eglDisplay;
        final CardboardViewNativeImpl this$0;









        public RendererHelper()
        {
            this$0 = CardboardViewNativeImpl.this;
            super();
            screenParams = new ScreenParams(getScreenParams());
            stereoMode = CardboardViewNativeImpl.this.stereoMode;
        }
    }

    private class PresentationListener
        implements com.google.vr.ndk.base.GvrLayout.PresentationListener
    {

        public void onPresentationStarted(Display display)
        {
            originalParams = getScreenParams();
            ScreenParams newParams = new ScreenParams(display);
            updateScreenParams(newParams);
            reconnectSensors();
        }

        public void onPresentationStopped()
        {
            if(originalParams != null)
                updateScreenParams(originalParams);
        }

        ScreenParams originalParams;
        final CardboardViewNativeImpl this$0;

        private PresentationListener()
        {
            this$0 = CardboardViewNativeImpl.this;
            super();
        }

    }


    public CardboardViewNativeImpl(Context context)
    {
        String nativeLibrary;
        cardboardTriggerCount = 0;
        stereoMode = true;
        distortionCorrectionEnabled = true;
        this.context = context;
        hmdManager = new HeadMountedDisplayManager(context);
        try
        {
            String proxyClassName = String.valueOf(getClass().getPackage().getName()).concat(".NativeProxy");
            Class proxyClass = Class.forName(proxyClassName);
            Field proxyLibField = proxyClass.getDeclaredField("PROXY_LIBRARY");
            nativeLibrary = (String)proxyLibField.get(null);
        }
        catch(Exception e)
        {
            Log.d(TAG, "NativeProxy not found");
            nativeLibrary = "gvr";
        }
        TAG;
        "Loading native library ";
        String s = String.valueOf(nativeLibrary);
        s;
        if(s.length() == 0) goto _L2; else goto _L1
_L1:
        concat();
          goto _L3
_L2:
        JVM INSTR pop ;
        JVM INSTR new #128 <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
_L3:
        Log.d();
        JVM INSTR pop ;
        System.loadLibrary(nativeLibrary);
        Log.d(TAG, "Native library loaded");
        nativeSetApplicationState(getClass().getClassLoader(), context.getApplicationContext());
        glSurfaceView = new CardboardGLSurfaceView(context, this);
        gvrLayout = new GvrLayout(context);
        gvrLayout.setPresentationView(glSurfaceView);
        gvrLayout.addPresentationListener(new PresentationListener());
        rendererHelper = new RendererHelper();
        uiLayout = gvrLayout.getUiLayout();
        gvrApi = gvrLayout.getGvrApi();
        nativeCardboardView = nativeInit(gvrApi.getNativeGvrContext());
        return;
    }

    protected void finalize()
        throws Throwable
    {
        if(nativeCardboardView != 0L)
        {
            Log.w(TAG, "GvrView.shutdown() should be called to ensure resource cleanup");
            nativeDestroy(nativeCardboardView);
        }
        super.finalize();
        break MISSING_BLOCK_LABEL_41;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public void onSurfaceViewDetachedFromWindow()
    {
        if(shutdownLatch != null)
            break MISSING_BLOCK_LABEL_81;
        shutdownLatch = new CountDownLatch(1);
        rendererHelper.shutdown();
        shutdownLatch.await();
        break MISSING_BLOCK_LABEL_76;
        InterruptedException e;
        e;
        TAG;
        "Interrupted during shutdown: ";
        String s = String.valueOf(e.toString());
        s;
        if(s.length() == 0) goto _L2; else goto _L1
_L1:
        concat();
          goto _L3
_L2:
        JVM INSTR pop ;
        JVM INSTR new #128 <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
_L3:
        Log.e();
        JVM INSTR pop ;
        shutdownLatch = null;
    }

    public void setRenderer(GvrView.Renderer renderer)
    {
        rendererHelper.setRenderer(renderer);
        glSurfaceView.setRenderer(rendererHelper);
    }

    public void setRenderer(GvrView.StereoRenderer renderer)
    {
        rendererHelper.setRenderer(renderer);
        glSurfaceView.setRenderer(rendererHelper);
    }

    public void getCurrentEyeParams(HeadTransform head, Eye leftEye, Eye rightEye, Eye monocular, Eye leftEyeNoDistortionCorrection, Eye rightEyeNoDistortionCorrection)
    {
        rendererHelper.getCurrentEyeParams(head, leftEye, rightEye, monocular, leftEyeNoDistortionCorrection, rightEyeNoDistortionCorrection);
    }

    public void setStereoModeEnabled(boolean enabled)
    {
        stereoMode = enabled;
        rendererHelper.setStereoModeEnabled(enabled);
    }

    public boolean getStereoModeEnabled()
    {
        return stereoMode;
    }

    public boolean setAsyncReprojectionEnabled(boolean enable)
    {
        return gvrLayout.setAsyncReprojectionEnabled(enable);
    }

    public boolean getAsyncReprojectionEnabled()
    {
        return gvrLayout.getGvrApi().getAsyncReprojectionEnabled();
    }

    public void setOnCloseButtonListener(Runnable listener)
    {
        uiLayout.setCloseButtonListener(listener);
    }

    public void setTransitionViewEnabled(boolean enabled)
    {
        uiLayout.setTransitionViewEnabled(enabled);
        updateTransitionListener();
    }

    public void setOnTransitionViewDoneListener(Runnable listener)
    {
        transitionDoneListener = listener;
        updateTransitionListener();
    }

    private void updateTransitionListener()
    {
        if(uiLayout.getUiLayer().getTransitionViewEnabled())
            uiLayout.getUiLayer().setTransitionViewListener(new com.google.vr.cardboard.TransitionView.TransitionListener() {

                public void onTransitionDone()
                {
                    if(nativeCardboardView != 0L)
                        nativeLogEvent(nativeCardboardView, 2002);
                    if(transitionDoneListener != null)
                        ThreadUtils.runOnUiThread(transitionDoneListener);
                }

                public void onSwitchViewer()
                {
                    if(nativeCardboardView != 0L)
                        nativeLogEvent(nativeCardboardView, 2003);
                }

                final CardboardViewNativeImpl this$0;

            
            {
                this.this$0 = CardboardViewNativeImpl.this;
                super();
            }
            });
        else
            uiLayout.getUiLayer().setTransitionViewListener(null);
    }

    public HeadMountedDisplay getHeadMountedDisplay()
    {
        return hmdManager.getHeadMountedDisplay();
    }

    public void setNeckModelEnabled(boolean enabled)
    {
        nativeSetNeckModelEnabled(nativeCardboardView, enabled);
    }

    public float getNeckModelFactor()
    {
        return nativeGetNeckModelFactor(nativeCardboardView);
    }

    public void setNeckModelFactor(float factor)
    {
        nativeSetNeckModelFactor(nativeCardboardView, factor);
    }

    public void resetHeadTracker()
    {
        gvrApi.resetTracking();
    }

    public void recenterHeadTracker()
    {
        gvrApi.recenterTracking();
    }

    public void updateGvrViewerParams(GvrViewerParams gvrDeviceParams)
    {
        if(hmdManager.updateGvrViewerParams(gvrDeviceParams))
            setGvrViewerParams(getGvrViewerParams());
    }

    public GvrViewerParams getGvrViewerParams()
    {
        return hmdManager.getHeadMountedDisplay().getGvrViewerParams();
    }

    public void updateScreenParams(ScreenParams screenParams)
    {
        if(hmdManager.updateScreenParams(screenParams))
            setScreenParams(getScreenParams());
    }

    public ScreenParams getScreenParams()
    {
        return hmdManager.getHeadMountedDisplay().getScreenParams();
    }

    public float getInterpupillaryDistance()
    {
        return getGvrViewerParams().getInterLensDistance();
    }

    public void setDistortionCorrectionEnabled(final boolean enabled)
    {
        checkNativeCardboardView();
        distortionCorrectionEnabled = enabled;
        queueEvent(new Runnable() {

            public void run()
            {
                nativeSetDistortionCorrectionEnabled(nativeCardboardView, enabled);
            }

            final boolean val$enabled;
            final CardboardViewNativeImpl this$0;

            
            {
                this.this$0 = CardboardViewNativeImpl.this;
                enabled = flag;
                super();
            }
        });
    }

    public boolean getDistortionCorrectionEnabled()
    {
        return distortionCorrectionEnabled;
    }

    public void undistortTexture(final int inputTexture)
    {
        checkNativeCardboardView();
        queueEvent(new Runnable() {

            public void run()
            {
                nativeUndistortTexture(nativeCardboardView, inputTexture);
            }

            final int val$inputTexture;
            final CardboardViewNativeImpl this$0;

            
            {
                this.this$0 = CardboardViewNativeImpl.this;
                inputTexture = i;
                super();
            }
        });
    }

    public void setDistortionCorrectionScale(final float scale)
    {
        checkNativeCardboardView();
        queueEvent(new Runnable() {

            public void run()
            {
                nativeSetDistortionCorrectionScale(nativeCardboardView, scale);
            }

            final float val$scale;
            final CardboardViewNativeImpl this$0;

            
            {
                this.this$0 = CardboardViewNativeImpl.this;
                scale = f;
                super();
            }
        });
    }

    public void setMultisampling(final int numSamples)
    {
        checkNativeCardboardView();
        queueEvent(new Runnable() {

            public void run()
            {
                nativeSetMultisampling(nativeCardboardView, numSamples);
            }

            final int val$numSamples;
            final CardboardViewNativeImpl this$0;

            
            {
                this.this$0 = CardboardViewNativeImpl.this;
                numSamples = i;
                super();
            }
        });
    }

    public void setDepthStencilFormat(final int format)
    {
        checkNativeCardboardView();
        if(!BufferSpec.isValidDepthStencilFormat(format))
        {
            throw new IllegalArgumentException("Invalid depth-stencil format.");
        } else
        {
            queueEvent(new Runnable() {

                public void run()
                {
                    nativeSetDepthStencilFormat(nativeCardboardView, format);
                }

                final int val$format;
                final CardboardViewNativeImpl this$0;

            
            {
                this.this$0 = CardboardViewNativeImpl.this;
                format = i;
                super();
            }
            });
            return;
        }
    }

    public void onResume()
    {
        checkNativeCardboardView();
        gvrLayout.onResume();
        glSurfaceView.onResume();
        hmdManager.onResume();
        setScreenParams(getScreenParams());
        setGvrViewerParams(getGvrViewerParams());
        gvrApi.resumeTracking();
    }

    public void onPause()
    {
        checkNativeCardboardView();
        gvrApi.pauseTracking();
        hmdManager.onPause();
        glSurfaceView.onPause();
        gvrLayout.onPause();
    }

    public void shutdown()
    {
        if(nativeCardboardView != 0L)
        {
            gvrLayout.shutdown();
            nativeDestroy(nativeCardboardView);
            nativeCardboardView = 0L;
        }
    }

    public boolean onTouchEvent(MotionEvent e)
    {
        if(e.getActionMasked() == 0 && cardboardTriggerListener != null)
        {
            onCardboardTrigger();
            return true;
        } else
        {
            return false;
        }
    }

    public void setOnCardboardTriggerListener(Runnable listener)
    {
        cardboardTriggerListener = listener;
    }

    public void enableCardboardTriggerEmulation()
    {
        gvrLayout.enableCardboardTriggerEmulation(new Runnable() {

            public void run()
            {
                onCardboardTrigger();
            }

            final CardboardViewNativeImpl this$0;

            
            {
                this.this$0 = CardboardViewNativeImpl.this;
                super();
            }
        });
    }

    public void setOnCardboardBackListener(Runnable listener)
    {
        cardboardBackListener = listener;
    }

    public View getRootView()
    {
        return gvrLayout;
    }

    public GvrSurfaceView getGvrSurfaceView()
    {
        return glSurfaceView;
    }

    private void runOnCardboardBackListener()
    {
        Runnable listener = cardboardBackListener;
        if(listener != null)
            ThreadUtils.runOnUiThread(listener);
    }

    private void onCardboardTrigger()
    {
        Runnable listener = cardboardTriggerListener;
        if(listener != null)
            ThreadUtils.runOnUiThread(listener);
    }

    private void onCardboardBack()
    {
        runOnCardboardBackListener();
    }

    private void queueEvent(Runnable r)
    {
        glSurfaceView.queueEvent(r);
    }

    private void setGvrViewerParams(final GvrViewerParams newParams)
    {
        GvrViewerParams deviceParams = new GvrViewerParams(newParams);
        uiLayout.setViewerName(deviceParams.getModel());
        queueEvent(new Runnable() {

            public void run()
            {
                nativeSetGvrViewerParams(nativeCardboardView, newParams.toByteArray());
            }

            final GvrViewerParams val$newParams;
            final CardboardViewNativeImpl this$0;

            
            {
                this.this$0 = CardboardViewNativeImpl.this;
                newParams = gvrviewerparams;
                super();
            }
        });
    }

    private void setScreenParams(ScreenParams newParams)
    {
        final ScreenParams screenParams = new ScreenParams(newParams);
        queueEvent(new Runnable() {

            public void run()
            {
                rendererHelper.setScreenParams(screenParams);
                nativeSetScreenParams(nativeCardboardView, screenParams.getWidth(), screenParams.getHeight(), screenParams.getWidthMeters() / (float)screenParams.getWidth(), screenParams.getHeightMeters() / (float)screenParams.getHeight(), screenParams.getBorderSizeMeters());
            }

            final ScreenParams val$screenParams;
            final CardboardViewNativeImpl this$0;

            
            {
                this.this$0 = CardboardViewNativeImpl.this;
                screenParams = screenparams;
                super();
            }
        });
    }

    private void reconnectSensors()
    {
        queueEvent(new Runnable() {

            public void run()
            {
                gvrApi.reconnectSensors();
            }

            final CardboardViewNativeImpl this$0;

            
            {
                this.this$0 = CardboardViewNativeImpl.this;
                super();
            }
        });
    }

    private void checkNativeCardboardView()
    {
        if(nativeCardboardView == 0L)
            throw new IllegalStateException("GvrView has already been shut down.");
        else
            return;
    }

    private static Display getDefaultDisplay(Context context)
    {
        WindowManager windowManager = (WindowManager)context.getSystemService("window");
        return windowManager.getDefaultDisplay();
    }

    private static native long nativeSetApplicationState(ClassLoader classloader, Context context1);

    private native long nativeInit(long l);

    private native void nativeDestroy(long l);

    private native void nativeSetRenderer(long l, GvrView.Renderer renderer);

    private native void nativeSetStereoRenderer(long l, GvrView.StereoRenderer stereorenderer);

    private native void nativeOnSurfaceCreated(long l);

    private native void nativeOnSurfaceChanged(long l, int i, int j);

    private native void nativeOnDrawFrame(long l);

    private native void nativeGetCurrentEyeParams(long l, HeadTransform headtransform, Eye eye, Eye eye1, Eye eye2, Eye eye3, 
            Eye eye4);

    private native void nativeSetNeckModelEnabled(long l, boolean flag);

    private native float nativeGetNeckModelFactor(long l);

    private native void nativeSetNeckModelFactor(long l, float f);

    private native void nativeSetGvrViewerParams(long l, byte abyte0[]);

    private native void nativeSetScreenParams(long l, int i, int j, float f, float f1, float f2);

    private native void nativeSetStereoModeEnabled(long l, boolean flag);

    private native void nativeSetDistortionCorrectionEnabled(long l, boolean flag);

    private native void nativeSetDistortionCorrectionScale(long l, float f);

    private native void nativeSetMultisampling(long l, int i);

    private native void nativeSetDepthStencilFormat(long l, int i);

    private native void nativeUndistortTexture(long l, int i);

    private native void nativeLogEvent(long l, int i);

    private static final String TAG = com/google/vr/sdk/base/CardboardViewNativeImpl.getSimpleName();
    private final RendererHelper rendererHelper;
    private final HeadMountedDisplayManager hmdManager;
    private CountDownLatch shutdownLatch;
    private int cardboardTriggerCount;
    private volatile Runnable cardboardTriggerListener;
    private volatile Runnable cardboardBackListener;
    private Runnable transitionDoneListener;
    private final CardboardGLSurfaceView glSurfaceView;
    private final GvrLayout gvrLayout;
    private final GvrUiLayout uiLayout;
    private final GvrApi gvrApi;
    private final Context context;
    private boolean stereoMode;
    private volatile boolean distortionCorrectionEnabled;
    private long nativeCardboardView;




























}
