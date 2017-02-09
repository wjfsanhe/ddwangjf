// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GvrLayout.java

package com.google.vr.ndk.base;

import android.app.PendingIntent;
import android.app.Presentation;
import android.content.Context;
import android.content.res.Configuration;
import android.hardware.display.DisplayManager;
import android.opengl.GLSurfaceView;
import android.os.*;
import android.util.AttributeSet;
import android.util.Log;
import android.view.*;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.vr.cardboard.*;
import java.util.*;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.google.vr.ndk.base:
//            CardboardEmulator, DaydreamTouchListener, DaydreamUtilsWrapper, FadeOverlayView, 
//            GvrApi, GvrUiLayout, TraceCompat, VrCoreSdkClient, 
//            GvrSurfaceView

public class GvrLayout extends FrameLayout
{
    private static class PresentationHelper
        implements android.hardware.display.DisplayManager.DisplayListener
    {

        public boolean isPresenting()
        {
            return presentation != null && presentation.isShowing();
        }

        public void onPause()
        {
            displayManager.unregisterDisplayListener(this);
        }

        public void onResume()
        {
            externalDisplayName = DisplayUtils.getExternalDisplayName(context);
            if(externalDisplayName == null)
            {
                setDisplay(null);
                return;
            }
            displayManager.registerDisplayListener(this, null);
            Display display = null;
            Display adisplay[];
            int i = (adisplay = displayManager.getDisplays()).length;
            int j = 0;
            do
            {
                if(j >= i)
                    break;
                Display display1 = adisplay[j];
                if(isValidExternalDisplay(display1))
                {
                    display = display1;
                    break;
                }
                j++;
            } while(true);
            setDisplay(display);
        }

        public void shutdown()
        {
            displayManager.unregisterDisplayListener(this);
            if(presentation != null)
            {
                presentation.cancel();
                presentation = null;
                PresentationListener presentationlistener;
                for(Iterator iterator = listeners.iterator(); iterator.hasNext(); (presentationlistener = (PresentationListener)iterator.next()).onPresentationStopped());
            }
        }

        public void onDetachedFromWindow()
        {
            displayManager.unregisterDisplayListener(this);
            setDisplay(null);
        }

        public void addListener(PresentationListener presentationlistener)
        {
            if(listeners.contains(presentationlistener))
                return;
            listeners.add(presentationlistener);
            if(presentation != null)
                presentationlistener.onPresentationStarted(presentation.getDisplay());
        }

        public void onDisplayAdded(int i)
        {
            Display display = displayManager.getDisplay(i);
            if(isValidExternalDisplay(display))
                setDisplay(display);
        }

        public void onDisplayRemoved(int i)
        {
            if(presentation != null && presentation.getDisplay().getDisplayId() == i)
                setDisplay(null);
        }

        public void onDisplayChanged(int i)
        {
        }

        private void setDisplay(Display display)
        {
            Presentation presentation1;
label0:
            {
                Display display1 = presentation == null ? null : presentation.getDisplay();
                if(!hasCurrentPresentationExpired() && DisplayUtils.isSameDisplay(display, display1))
                    return;
                presentation1 = presentation;
                if(presentation != null)
                {
                    presentation.dismiss();
                    presentation = null;
                }
                detachViewFromParent(view);
                if(display != null)
                {
                    presentation = GvrLayout.sOptionalPresentationFactory == null ? new Presentation(context, display) : GvrLayout.sOptionalPresentationFactory.create(context, display);
                    presentation.addContentView(view, layout);
                    try
                    {
                        presentation.show();
                        break label0;
                    }
                    catch(android.view.WindowManager.InvalidDisplayException invaliddisplayexception)
                    {
                        String s;
                        Log.e("GvrLayout", (new StringBuilder(57 + String.valueOf(s = String.valueOf(invaliddisplayexception)).length())).append("Attaching Cardboard View to the external display failed: ").append(s).toString());
                        presentation.cancel();
                        presentation = null;
                        detachViewFromParent(view);
                    }
                }
                originalParent.addView(view, 0);
            }
            displaySynchronizer.setDisplay(presentation == null ? DisplayUtils.getDefaultDisplay(context) : presentation.getDisplay());
            if(presentation1 != null)
            {
                PresentationListener presentationlistener;
                for(Iterator iterator = listeners.iterator(); iterator.hasNext(); (presentationlistener = (PresentationListener)iterator.next()).onPresentationStopped());
            }
            if(presentation != null)
            {
                PresentationListener presentationlistener1;
                for(Iterator iterator1 = listeners.iterator(); iterator1.hasNext(); (presentationlistener1 = (PresentationListener)iterator1.next()).onPresentationStarted(presentation.getDisplay()));
            }
        }

        private static void detachViewFromParent(View view1)
        {
            ViewGroup viewgroup;
            if((viewgroup = (ViewGroup)view1.getParent()) != null)
                viewgroup.removeView(view1);
        }

        private boolean isValidExternalDisplay(Display display)
        {
            return display != null && display.isValid() && display.getName().equals(externalDisplayName);
        }

        private boolean hasCurrentPresentationExpired()
        {
            if(presentation == null)
                return false;
            return !presentation.isShowing() || !presentation.getDisplay().isValid();
        }

        private final android.widget.RelativeLayout.LayoutParams layout = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        private final Context context;
        private final DisplayManager displayManager;
        private final DisplaySynchronizer displaySynchronizer;
        private final FrameLayout originalParent;
        private final View view;
        private final List listeners = new ArrayList();
        private String externalDisplayName;
        private Presentation presentation;

        PresentationHelper(Context context1, FrameLayout framelayout, View view1, DisplaySynchronizer displaysynchronizer, String s)
        {
            context = context1;
            originalParent = framelayout;
            view = view1;
            displaySynchronizer = displaysynchronizer;
            externalDisplayName = s;
            displayManager = (DisplayManager)context1.getSystemService("display");
        }
    }

    private static class AsyncReprojectionSurfaceView extends GvrSurfaceView
    {

        public void setRenderer(ScanlineRacingRenderer scanlineracingrenderer)
        {
            scanlineRacingRenderer = scanlineracingrenderer;
            super.setRenderer(scanlineracingrenderer);
        }

        public void surfaceDestroyed(SurfaceHolder surfaceholder)
        {
            if(!isDetachedFromWindow() && scanlineRacingRenderer != null)
            {
                final CountDownLatch destroySurfaceLatch = new CountDownLatch(1);
                queueEvent(new Runnable() {

                    public void run()
                    {
                        scanlineRacingRenderer.onDestroySurface();
                        destroySurfaceLatch.countDown();
                    }

                    final CountDownLatch val$destroySurfaceLatch;
                    final AsyncReprojectionSurfaceView this$0;

                
                {
                    this$0 = AsyncReprojectionSurfaceView.this;
                    destroySurfaceLatch = countdownlatch;
                    super();
                }
                });
                try
                {
                    destroySurfaceLatch.await();
                }
                catch(InterruptedException interruptedexception)
                {
                    Log.e("GvrLayout", "Interrupted during surface destroyed: ", interruptedexception);
                }
            }
            super.surfaceDestroyed(surfaceholder);
        }

        private ScanlineRacingRenderer scanlineRacingRenderer;


        AsyncReprojectionSurfaceView(Context context)
        {
            super(context);
        }
    }

    static interface PresentationFactory
    {

        public abstract Presentation create(Context context, Display display);
    }

    public static interface PresentationListener
    {

        public abstract void onPresentationStarted(Display display);

        public abstract void onPresentationStopped();
    }

    public static interface ExternalSurfaceManager
    {

        public abstract int createExternalSurface();

        public abstract int createExternalSurface(ExternalSurfaceListener externalsurfacelistener, Handler handler);

        public abstract void releaseExternalSurface(int i);

        public abstract Surface getSurface(int i);

        public abstract int getSurfaceCount();
    }

    public static interface ExternalSurfaceListener
    {

        public abstract void onSurfaceAvailable(Surface surface);

        public abstract void onFrameAvailable();
    }


    public GvrLayout(Context context)
    {
        super(context);
        isResumed = false;
        videoSurfaceId = -1;
        stereoModeEnabled = true;
        showRenderingViewsRunnable = new Runnable() {

            public void run()
            {
                updateRenderingViewsVisibility(0);
            }

            final GvrLayout this$0;

            
            {
                this$0 = GvrLayout.this;
                super();
            }
        };
        android.app.Activity activity;
        if((activity = ContextUtils.getActivity(context)) == null)
        {
            throw new IllegalArgumentException("An Activity Context is required for VR functionality.");
        } else
        {
            init(null, null, null, null, null);
            return;
        }
    }

    public GvrLayout(Context context, AttributeSet attributeset, int i, int j)
    {
        super(context, attributeset, i, j);
        isResumed = false;
        videoSurfaceId = -1;
        stereoModeEnabled = true;
        showRenderingViewsRunnable = new _cls1();
        android.app.Activity activity;
        if((activity = ContextUtils.getActivity(context)) == null)
        {
            throw new IllegalArgumentException("An Activity Context is required for VR functionality.");
        } else
        {
            init(null, null, null, null, null);
            return;
        }
    }

    public GvrLayout(VrContextWrapper vrcontextwrapper)
    {
        super(vrcontextwrapper);
        isResumed = false;
        videoSurfaceId = -1;
        stereoModeEnabled = true;
        showRenderingViewsRunnable = new _cls1();
        init(null, null, null, null, null);
    }

    GvrLayout(Context context, GvrApi gvrapi, DisplaySynchronizer displaysynchronizer, EglReadyListener eglreadylistener, FadeOverlayView fadeoverlayview, DaydreamUtilsWrapper daydreamutilswrapper)
    {
        super(context);
        isResumed = false;
        videoSurfaceId = -1;
        stereoModeEnabled = true;
        showRenderingViewsRunnable = new _cls1();
        init(gvrapi, displaysynchronizer, eglreadylistener, fadeoverlayview, daydreamutilswrapper);
    }

    private void init(GvrApi gvrapi, DisplaySynchronizer displaysynchronizer, EglReadyListener eglreadylistener, FadeOverlayView fadeoverlayview, DaydreamUtilsWrapper daydreamutilswrapper)
    {
        TraceCompat.beginSection("GvrLayout.init");
        displaysynchronizer = displaysynchronizer == null ? GvrApi.createDefaultDisplaySynchronizer(getContext()) : displaysynchronizer;
        eglreadylistener = eglreadylistener == null ? new EglReadyListener() : eglreadylistener;
        gvrapi = gvrapi == null ? new GvrApi(getContext(), displaysynchronizer) : gvrapi;
        daydreamutilswrapper = daydreamutilswrapper == null ? new DaydreamUtilsWrapper() : daydreamutilswrapper;
        daydreamUtils = daydreamutilswrapper;
        presentationLayout = new FrameLayout(getContext());
        uiLayout = new GvrUiLayout(getContext());
        gvrApi = gvrapi;
        displaySynchronizer = displaysynchronizer;
        eglReadyListener = eglreadylistener;
        presentationHelper = tryCreatePresentationHelper();
        addView(presentationLayout, 0);
        addView(uiLayout, 1);
        updateUiLayout();
        boolean flag;
        if(flag = daydreamutilswrapper.isDaydreamPhone(getContext()))
        {
            daydreamTouchListener = createDaydreamTouchListener();
            uiLayout.setOnTouchListener(daydreamTouchListener);
        }
        int i;
        boolean flag1 = (i = daydreamutilswrapper.getComponentDaydreamCompatibility(getContext())) != 0;
        boolean flag2 = i == 2;
        boolean flag3;
        if(flag3 = flag || flag2)
        {
            if(flag1)
            {
                fadeOverlayView = fadeoverlayview == null ? new FadeOverlayView(getContext()) : fadeoverlayview;
                addView(fadeOverlayView, 2);
            }
            vrCoreSdkClient = createVrCoreSdkClient(getContext(), gvrapi, daydreamutilswrapper, fadeOverlayView);
        }
        TraceCompat.endSection();
        return;
        Exception exception;
        exception;
        TraceCompat.endSection();
        throw exception;
    }

    public GvrUiLayout getUiLayout()
    {
        return uiLayout;
    }

    public void onWindowVisibilityChanged(int i)
    {
        super.onWindowVisibilityChanged(i);
        updateFadeVisibility();
    }

    public void onPause()
    {
        TraceCompat.beginSection("GvrLayout.onPause");
        gvrApi.pause();
        if(scanlineRacingView != null)
        {
            scanlineRacingView.queueEvent(new Runnable() {

                public void run()
                {
                    scanlineRacingRenderer.onPause();
                }

                final GvrLayout this$0;

            
            {
                this$0 = GvrLayout.this;
                super();
            }
            });
            scanlineRacingView.onPause();
        }
        if(presentationHelper != null)
            presentationHelper.onPause();
        displaySynchronizer.onPause();
        if(vrCoreSdkClient != null)
            vrCoreSdkClient.onPause();
        if(cardboardEmulator != null)
            cardboardEmulator.onPause();
        isResumed = false;
        updateFadeVisibility();
        TraceCompat.endSection();
        return;
        Exception exception;
        exception;
        TraceCompat.endSection();
        throw exception;
    }

    public void onResume()
    {
        TraceCompat.beginSection("GvrLayout.onResume");
        gvrApi.resume();
        if(daydreamTouchListener != null)
            daydreamTouchListener.refreshViewerProfile();
        displaySynchronizer.onResume();
        if(presentationHelper != null)
            presentationHelper.onResume();
        if(scanlineRacingView != null)
            scanlineRacingView.onResume();
        if(vrCoreSdkClient != null)
            vrCoreSdkClient.onResume();
        if(cardboardEmulator != null && gvrApi.getViewerType() == 1)
            cardboardEmulator.onResume();
        isResumed = true;
        updateFadeVisibility();
        updateUiLayout();
        TraceCompat.endSection();
        return;
        Exception exception;
        exception;
        TraceCompat.endSection();
        throw exception;
    }

    public void shutdown()
    {
        TraceCompat.beginSection("GvrLayout.shutdown");
        displaySynchronizer.shutdown();
        if(daydreamTouchListener != null)
            daydreamTouchListener.shutdown();
        removeView(presentationLayout);
        removeView(uiLayout);
        if(scanlineRacingRenderer != null)
        {
            scanlineRacingRenderer.shutdown();
            scanlineRacingRenderer = null;
        }
        scanlineRacingView = null;
        presentationView = null;
        if(presentationHelper != null)
        {
            presentationHelper.shutdown();
            presentationHelper = null;
        }
        if(vrCoreSdkClient != null)
        {
            vrCoreSdkClient.onPause();
            vrCoreSdkClient = null;
        }
        if(cardboardEmulator != null)
        {
            cardboardEmulator.onPause();
            cardboardEmulator = null;
        }
        if(gvrApi != null)
        {
            gvrApi.shutdown();
            gvrApi = null;
        }
        TraceCompat.endSection();
        return;
        Exception exception;
        exception;
        TraceCompat.endSection();
        throw exception;
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if(presentationHelper != null)
            presentationHelper.onDetachedFromWindow();
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        displaySynchronizer.onConfigurationChanged();
    }

    public void setPresentationView(View view)
    {
        if(presentationView != null)
            presentationLayout.removeView(presentationView);
        presentationLayout.addView(view, 0);
        presentationView = view;
    }

    public void setFixedPresentationSurfaceSize(int i, int j)
    {
        gvrApi.setSurfaceSize(i, j);
    }

    public boolean enableAsyncReprojectionVideoSurface(ExternalSurfaceListener externalsurfacelistener, Handler handler, boolean flag)
    {
        if(!daydreamUtils.isDaydreamPhone(getContext()))
        {
            Log.e("GvrLayout", "Only Daydream devices support async reprojection. Cannot enable video Surface.");
            return false;
        }
        if(scanlineRacingView != null)
        {
            Log.e("GvrLayout", "Async reprojection is already enabled. Cannot call enableAsyncReprojectionVideoSurface after calling setAsyncReprojectionEnabled.");
            return false;
        }
        if(gvrApi.usingVrDisplayService())
        {
            Log.e("GvrLayout", "Async reprojection video is not supported on this device.");
            return false;
        } else
        {
            isAsyncReprojectionVideoEnabled = true;
            isAsyncReprojectionUsingProtectedBuffers = flag;
            scanlineRacingRenderer = new ScanlineRacingRenderer(gvrApi);
            ExternalSurfaceManager externalsurfacemanager = scanlineRacingRenderer.getExternalSurfaceManager();
            videoSurfaceId = externalsurfacemanager.createExternalSurface(externalsurfacelistener, handler);
            return true;
        }
    }

    public boolean setAsyncReprojectionEnabled(boolean flag)
    {
        if(Looper.getMainLooper() != Looper.myLooper())
            throw new IllegalStateException("setAsyncReprojectionEnabled may only be called from the UI thread");
        if(scanlineRacingView != null && !flag)
            throw new UnsupportedOperationException("Async reprojection cannot be disabled once enabled");
        if(flag && !daydreamUtils.isDaydreamPhone(getContext()))
            return false;
        boolean flag1 = gvrApi.setAsyncReprojectionEnabled(flag);
        if(flag)
            if(flag1)
            {
                if(!gvrApi.usingVrDisplayService())
                    addScanlineRacingView();
            } else
            {
                Log.e("GvrLayout", "Failed to initialize async reprojection, unsupported device.");
                isAsyncReprojectionVideoEnabled = false;
                scanlineRacingRenderer = null;
            }
        return flag1;
    }

    public boolean enableCardboardTriggerEmulation(Runnable runnable)
    {
        if(runnable == null)
            throw new IllegalArgumentException("The Cardboard trigger listener must not be null.");
        if(cardboardEmulator != null)
            return true;
        if(!daydreamUtils.isDaydreamPhone(getContext()))
        {
            return false;
        } else
        {
            cardboardEmulator = new CardboardEmulator(getContext(), runnable);
            return true;
        }
    }

    private void addScanlineRacingView()
    {
        if(scanlineRacingView != null)
            return;
        eglFactory = new EglFactory();
        eglFactory.setUsePriorityContext(true);
        eglFactory.setUseProtectedBuffers(isAsyncReprojectionUsingProtectedBuffers);
        eglFactory.setEGLContextClientVersion(2);
        scanlineRacingView = new AsyncReprojectionSurfaceView(getContext());
        scanlineRacingView.setEGLContextClientVersion(2);
        scanlineRacingView.setEGLConfigChooser(new MutableEglConfigChooser());
        scanlineRacingView.setZOrderMediaOverlay(true);
        scanlineRacingView.setEGLContextFactory(eglFactory);
        scanlineRacingView.setEGLWindowSurfaceFactory(eglFactory);
        if(!stereoModeEnabled)
        {
            Log.w("GvrLayout", "Disabling stereo mode with async reprojection enabled may not work properly.");
            scanlineRacingView.setVisibility(8);
        }
        if(scanlineRacingRenderer == null)
            scanlineRacingRenderer = new ScanlineRacingRenderer(gvrApi);
        scanlineRacingRenderer.setSurfaceView(scanlineRacingView);
        scanlineRacingView.setRenderer(scanlineRacingRenderer);
        scanlineRacingView.setSwapMode(1);
        presentationLayout.addView(scanlineRacingView, 0);
    }

    public int getAsyncReprojectionVideoSurfaceId()
    {
        if(!isAsyncReprojectionVideoEnabled)
            Log.w("GvrLayout", "Async reprojection video is not enabled. Did you call enableAsyncReprojectionVideoSurface()?");
        return videoSurfaceId;
    }

    public Surface getAsyncReprojectionVideoSurface()
    {
        if(!isAsyncReprojectionVideoEnabled)
        {
            Log.w("GvrLayout", "Async reprojection video is not enabled. Did you call enableAsyncReprojectionVideoSurface()?");
            return null;
        }
        if(scanlineRacingView == null)
            Log.w("GvrLayout", "No async reprojection view has been set. Cannot get async reprojection managed Surfaces. Have you called setAsyncReprojectionEnabled()?");
        return scanlineRacingRenderer.getExternalSurfaceManager().getSurface(videoSurfaceId);
    }

    public GvrApi getGvrApi()
    {
        return gvrApi;
    }

    public void addPresentationListener(PresentationListener presentationlistener)
    {
        if(presentationHelper != null)
            presentationHelper.addListener(presentationlistener);
    }

    protected VrCoreSdkClient createVrCoreSdkClient(Context context, GvrApi gvrapi, DaydreamUtilsWrapper daydreamutilswrapper, FadeOverlayView fadeoverlayview)
    {
        android.content.ComponentName componentname = ContextUtils.getComponentName(context);
        Runnable runnable = new Runnable() {

            public void run()
            {
                uiLayout.invokeCloseButtonListener();
            }

            final GvrLayout this$0;

            
            {
                this$0 = GvrLayout.this;
                super();
            }
        };
        return new VrCoreSdkClient(context, gvrapi, componentname, daydreamutilswrapper, runnable, fadeoverlayview);
    }

    public void launchInVr(PendingIntent pendingintent)
    {
        if(vrCoreSdkClient == null || !vrCoreSdkClient.launchInVr(pendingintent))
            try
            {
                pendingintent.send();
                return;
            }
            catch(Exception exception)
            {
                Log.e("GvrLayout", "Error launching PendingIntent.", exception);
            }
    }

    public void setStereoModeEnabled(boolean flag)
    {
        if(stereoModeEnabled == flag)
            return;
        stereoModeEnabled = flag;
        uiLayout.setEnabled(flag);
        if(vrCoreSdkClient != null)
            vrCoreSdkClient.setEnabled(flag);
        if(fadeOverlayView != null)
            fadeOverlayView.setEnabled(flag);
        if(daydreamTouchListener != null)
            daydreamTouchListener.setEnabled(flag);
        updateRenderingViewsVisibility(0);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if(presentationView != null && isPresenting() && presentationView.dispatchTouchEvent(motionevent))
            return true;
        else
            return super.onTouchEvent(motionevent);
    }

    public boolean isPresenting()
    {
        return presentationView != null && presentationHelper != null && presentationHelper.isPresenting();
    }

    static void setPresentationFactory(PresentationFactory presentationfactory)
    {
        sOptionalPresentationFactory = presentationfactory;
    }

    VrCoreSdkClient getVrCoreSdkClient()
    {
        return vrCoreSdkClient;
    }

    FadeOverlayView getFadeOverlayView()
    {
        return fadeOverlayView;
    }

    DaydreamTouchListener createDaydreamTouchListener()
    {
        return new DaydreamTouchListener(getContext(), gvrApi);
    }

    private PresentationHelper tryCreatePresentationHelper()
    {
        if(android.os.Build.VERSION.SDK_INT <= 16)
            return null;
        String s;
        if((s = DisplayUtils.getExternalDisplayName(getContext())) == null)
        {
            Log.e("GvrLayout", "HDMI display name could not be found, disabling external presentation support");
            return null;
        } else
        {
            return new PresentationHelper(getContext(), this, presentationLayout, displaySynchronizer, s);
        }
    }

    private void updateRenderingViewsVisibility(int i)
    {
        if(presentationView != null)
            presentationView.setVisibility(stereoModeEnabled ? i : 0);
        if(scanlineRacingView != null)
            scanlineRacingView.setVisibility(stereoModeEnabled ? i : 8);
    }

    private void updateFadeVisibility()
    {
        boolean flag = getWindowVisibility() == 0;
        if(fadeOverlayView != null)
        {
            if(flag && isResumed)
            {
                fadeOverlayView.onVisible();
                removeCallbacks(showRenderingViewsRunnable);
                postDelayed(showRenderingViewsRunnable, 50L);
                return;
            }
            if(!flag && !isResumed)
            {
                fadeOverlayView.onInvisible();
                updateRenderingViewsVisibility(4);
                removeCallbacks(showRenderingViewsRunnable);
            }
        }
    }

    private void updateUiLayout()
    {
        boolean flag = gvrApi.getViewerType() == 1;
        uiLayout.setDaydreamModeEnabled(flag);
    }

    private static final String TAG = "GvrLayout";
    private static final boolean DEBUG = false;
    private static final int EXTERNAL_PRESENTATION_MIN_API = 16;
    private static final boolean CONTEXT_SHARING_ENABLED = false;
    private static final int SHOW_RENDERING_VIEWS_DELAY_FOR_FADE = 50;
    private static PresentationFactory sOptionalPresentationFactory = null;
    private DaydreamUtilsWrapper daydreamUtils;
    private FrameLayout presentationLayout;
    private GvrUiLayout uiLayout;
    private DisplaySynchronizer displaySynchronizer;
    private View presentationView;
    private boolean isAsyncReprojectionVideoEnabled;
    private boolean isAsyncReprojectionUsingProtectedBuffers;
    private AsyncReprojectionSurfaceView scanlineRacingView;
    private ScanlineRacingRenderer scanlineRacingRenderer;
    private EglReadyListener eglReadyListener;
    private EglFactory eglFactory;
    private FadeOverlayView fadeOverlayView;
    private PresentationHelper presentationHelper;
    private VrCoreSdkClient vrCoreSdkClient;
    private DaydreamTouchListener daydreamTouchListener;
    private CardboardEmulator cardboardEmulator;
    private GvrApi gvrApi;
    private boolean isResumed;
    private int videoSurfaceId;
    private boolean stereoModeEnabled;
    private final Runnable showRenderingViewsRunnable;





}
