// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrCoreSdkClient.java

package com.google.vr.ndk.base;

import android.app.*;
import android.content.*;
import android.os.*;
import android.util.Log;
import com.google.vr.cardboard.R;
import com.google.vr.cardboard.UiUtils;
import com.google.vr.vrcore.base.api.VrCoreNotAvailableException;
import com.google.vr.vrcore.base.api.VrCoreUtils;
import com.google.vr.vrcore.common.api.*;
import java.lang.ref.WeakReference;

// Referenced classes of package com.google.vr.ndk.base:
//            DaydreamUtilsWrapper, FadeOverlayView, GvrApi

class VrCoreSdkClient
{
    private static final class DaydreamListenerImpl extends com.google.vr.vrcore.common.api.IDaydreamListener.Stub
    {

        final void resetSafeguards()
        {
            safeguardHandler.removeCallbacksAndMessages(null);
        }

        public final int getTargetApiVersion()
            throws RemoteException
        {
            return 10;
        }

        public final HeadTrackingState requestStopTracking()
            throws RemoteException
        {
            GvrApi gvrapi;
            if((gvrapi = (GvrApi)gvrApiWeak.get()) == null)
            {
                Log.w("VrCoreSdkClient", "Invalid requestStopTracking() call: GvrApi no longer valid");
                return null;
            }
            byte abyte0[] = gvrapi.pauseTrackingGetState();
            rescheduleSafeguard(1, 3000L);
            if(abyte0 != null)
                return new HeadTrackingState(abyte0);
            else
                return null;
        }

        public final void applyFade(int i, long l)
        {
            applyFadeImpl(i, l);
        }

        public final void recenterHeadTracking()
            throws RemoteException
        {
            GvrApi gvrapi;
            if((gvrapi = (GvrApi)gvrApiWeak.get()) == null)
            {
                Log.w("VrCoreSdkClient", "Invalid recenterHeadTracking() call: GvrApi no longer valid");
                return;
            } else
            {
                gvrapi.recenterTracking();
                return;
            }
        }

        public final void dumpDebugData()
            throws RemoteException
        {
            GvrApi gvrapi;
            if((gvrapi = (GvrApi)gvrApiWeak.get()) == null)
            {
                Log.w("VrCoreSdkClient", "Invalid dumpDebugData() call: GvrApi no longer valid");
                return;
            } else
            {
                gvrapi.dumpDebugData();
                return;
            }
        }

        public final void resumeHeadTracking(HeadTrackingState headtrackingstate)
        {
            resumeHeadTrackingImpl(headtrackingstate);
        }

        private final void resumeHeadTrackingImpl(HeadTrackingState headtrackingstate)
        {
            GvrApi gvrapi;
            if((gvrapi = (GvrApi)gvrApiWeak.get()) == null)
            {
                Log.w("VrCoreSdkClient", "Invalid resumeHeadTracking() call: GvrApi no longer valid");
                return;
            } else
            {
                cancelSafeguard(1);
                VrCoreSdkClient.resumeTracking(gvrapi, headtrackingstate);
                return;
            }
        }

        private final void applyFadeImpl(final int fadeType, final long durationMillis)
        {
            final FadeOverlayView fadeOverlayView;
            if((fadeOverlayView = (FadeOverlayView)fadeOverlayViewWeak.get()) == null)
                return;
            cancelSafeguard(2);
            fadeOverlayView.post(new Runnable() {

                public void run()
                {
                    fadeOverlayView.startFade(fadeType, durationMillis);
                }

                final FadeOverlayView val$fadeOverlayView;
                final int val$fadeType;
                final long val$durationMillis;

                
                {
                    fadeOverlayView = fadeoverlayview;
                    fadeType = i;
                    durationMillis = l;
                    super();
                }
            });
            if(fadeType == 2)
                rescheduleSafeguard(2, durationMillis + 3500L);
        }

        private final void cancelSafeguard(int i)
        {
            safeguardHandler.removeMessages(i);
        }

        private final void rescheduleSafeguard(int i, long l)
        {
            cancelSafeguard(i);
            safeguardHandler.sendEmptyMessageDelayed(i, l);
        }

        private static final long TRACKING_SAFEGUARD_DELAY_MILLIS = 3000L;
        private static final long FADE_SAFEGUARD_DELAY_MILLIS = 3500L;
        private static final int MSG_TRACKING_RESUME_SAFEGUARD = 1;
        private static final int MSG_FADE_IN_SAFEGUARD = 2;
        private final WeakReference gvrApiWeak;
        private final WeakReference fadeOverlayViewWeak;
        private final Handler safeguardHandler = new Handler() {

            public void handleMessage(Message message)
            {
                switch(message.what)
                {
                case 2: // '\002'
                    Log.w("VrCoreSdkClient", "Forcing fade in: VrCore unresponsive");
                    applyFadeImpl(1, 350L);
                    return;

                case 1: // '\001'
                    Log.w("VrCoreSdkClient", "Forcing tracking resume: VrCore unresponsive");
                    resumeHeadTrackingImpl(null);
                    return;
                }
                super.handleMessage(message);
            }

            final DaydreamListenerImpl this$0;

                
                {
                    this$0 = DaydreamListenerImpl.this;
                    super();
                }
        };



        DaydreamListenerImpl(GvrApi gvrapi, FadeOverlayView fadeoverlayview)
        {
            gvrApiWeak = new WeakReference(gvrapi);
            fadeOverlayViewWeak = new WeakReference(fadeoverlayview);
        }
    }


    public VrCoreSdkClient(Context context1, GvrApi gvrapi, ComponentName componentname, DaydreamUtilsWrapper daydreamutilswrapper, Runnable runnable, FadeOverlayView fadeoverlayview)
    {
        isEnabled = true;
        context = context1;
        gvrApi = gvrapi;
        componentName = componentname;
        daydreamUtils = daydreamutilswrapper;
        closeVrRunnable = runnable;
        fadeOverlayView = fadeoverlayview;
        daydreamListener = new DaydreamListenerImpl(gvrapi, fadeoverlayview);
        shouldBind = hasCompatibleSdkService(context1);
        gvrapi.setIgnoreManualTrackerPauseResume(true);
    }

    IDaydreamManager getDaydreamManager()
    {
        return daydreamManager;
    }

    HeadTrackingState getHeadTrackingState()
    {
        return new HeadTrackingState();
    }

    public boolean onResume()
    {
        isResumed = true;
        if(!isEnabled)
            return false;
        else
            return doBind();
    }

    public void onPause()
    {
        isResumed = false;
        daydreamListener.resetSafeguards();
        if(isEnabled)
            doUnbind();
    }

    public void setEnabled(boolean flag)
    {
        if(isEnabled == flag)
            return;
        isEnabled = flag;
        gvrApi.setIgnoreManualTrackerPauseResume(flag);
        if(isResumed)
        {
            if(isEnabled)
            {
                doBind();
                return;
            }
            doUnbind();
        }
    }

    public boolean launchInVr(PendingIntent pendingintent)
    {
        if(daydreamManager != null)
        {
            String s;
            try
            {
                daydreamManager.deprecatedLaunchInVr(pendingintent);
            }
            catch(RemoteException remoteexception)
            {
                Log.w("VrCoreSdkClient", (new StringBuilder(28 + String.valueOf(s = String.valueOf(remoteexception)).length())).append("Failed to launch app in VR: ").append(s).toString());
            }
            return true;
        } else
        {
            return false;
        }
    }

    private boolean doBind()
    {
        if(isBound)
            return true;
        if(shouldBind)
        {
            Intent intent;
            (intent = new Intent("com.google.vr.vrcore.BIND_SDK_SERVICE")).setPackage("com.google.vr.vrcore");
            isBound = context.bindService(intent, serviceConnection, 1);
        }
        if(!isBound)
            handleBindFailed();
        return isBound;
    }

    private void doUnbind()
    {
        if(isResumed)
            resumeTracking(null);
        else
            gvrApi.pauseTrackingGetState();
        if(!isBound)
            return;
        if(daydreamManager != null)
        {
            String s;
            try
            {
                daydreamManager.unregisterListener(componentName);
            }
            catch(RemoteException remoteexception)
            {
                Log.w("VrCoreSdkClient", (new StringBuilder(40 + String.valueOf(s = String.valueOf(remoteexception)).length())).append("Failed to unregister Daydream listener: ").append(s).toString());
            }
            daydreamManager = null;
        }
        vrCoreSdkService = null;
        context.unbindService(serviceConnection);
        isBound = false;
    }

    private void handleBindFailed()
    {
        doUnbind();
        warnIfIncompatibleClient();
    }

    private void handleNoDaydreamManager()
    {
        doUnbind();
        warnIfIncompatibleClient();
    }

    private void handlePrepareVrFailed()
    {
        doUnbind();
        closeVrRunnable.run();
    }

    private void warnIfIncompatibleClient()
    {
        if(!daydreamUtils.isDaydreamPhone(context) && daydreamUtils.isDaydreamRequiredComponent(context) && !ActivityManager.isRunningInTestHarness())
        {
            if(helpCenterDialog != null)
            {
                helpCenterDialog.show();
                return;
            }
            helpCenterDialog = UiUtils.showDaydreamHelpCenterDialog(context, com.google.vr.cardboard.R.string.dialog_title_incompatible_phone, com.google.vr.cardboard.R.string.dialog_message_incompatible_phone, closeVrRunnable);
        }
    }

    private void resumeTracking(HeadTrackingState headtrackingstate)
    {
        resumeTracking(gvrApi, headtrackingstate);
        if(fadeOverlayView != null)
            fadeOverlayView.flushAutoFade(200L);
    }

    private static void resumeTracking(GvrApi gvrapi, HeadTrackingState headtrackingstate)
    {
        gvrapi.resumeTrackingSetState(headtrackingstate == null || headtrackingstate.isEmpty() ? null : headtrackingstate.getData());
    }

    private static boolean hasCompatibleSdkService(Context context1)
    {
        int i;
        if((i = VrCoreUtils.getVrCoreClientApiVersion(context1)) >= 5)
            return true;
        try
        {
            Log.w("VrCoreSdkClient", String.format("VrCore service obsolete, GVR SDK requires API %d but found API %d.", new Object[] {
                Integer.valueOf(5), Integer.valueOf(i)
            }));
        }
        catch(VrCoreNotAvailableException _ex) { }
        return false;
    }

    private static final String TAG = "VrCoreSdkClient";
    private static final boolean DEBUG = false;
    static final int MIN_VRCORE_API_VERSION = 5;
    static final int TARGET_VRCORE_API_VERSION = 10;
    private static final int FADE_FLUSH_DELAY_FOR_TRACKING_STABILIZATION_MILLIS = 200;
    private final Context context;
    private final GvrApi gvrApi;
    private final ComponentName componentName;
    private final DaydreamUtilsWrapper daydreamUtils;
    private final Runnable closeVrRunnable;
    private final FadeOverlayView fadeOverlayView;
    private final DaydreamListenerImpl daydreamListener;
    private final boolean shouldBind;
    private boolean isBound;
    private boolean isResumed;
    private boolean isEnabled;
    private IVrCoreSdkService vrCoreSdkService;
    private IDaydreamManager daydreamManager;
    private AlertDialog helpCenterDialog;
    private final ServiceConnection serviceConnection = new ServiceConnection() {

        public void onServiceConnected(ComponentName componentname1, IBinder ibinder)
        {
            IVrCoreSdkService ivrcoresdkservice = com.google.vr.vrcore.common.api.IVrCoreSdkService.Stub.asInterface(ibinder);
            try
            {
                if(!ivrcoresdkservice.initialize(10))
                {
                    Log.e("VrCoreSdkClient", "Failed to initialize VrCore SDK Service.");
                    handleBindFailed();
                    return;
                }
            }
            catch(RemoteException remoteexception)
            {
                String s;
                Log.w("VrCoreSdkClient", (new StringBuilder(41 + String.valueOf(s = String.valueOf(remoteexception)).length())).append("Failed to initialize VrCore SDK Service: ").append(s).toString());
                handleBindFailed();
                return;
            }
            vrCoreSdkService = ivrcoresdkservice;
            try
            {
                daydreamManager = vrCoreSdkService.getDaydreamManager();
                if(daydreamManager == null)
                {
                    Log.w("VrCoreSdkClient", "Failed to obtain DaydreamManager from VrCore SDK Service.");
                    handleNoDaydreamManager();
                    return;
                }
            }
            catch(RemoteException remoteexception1)
            {
                String s1;
                Log.w("VrCoreSdkClient", (new StringBuilder(57 + String.valueOf(s1 = String.valueOf(remoteexception1)).length())).append("Failed to obtain DaydreamManager from VrCore SDK Service:").append(s1).toString());
                handleNoDaydreamManager();
                return;
            }
            daydreamManager.registerListener(componentName, daydreamListener);
            HeadTrackingState headtrackingstate = null;
            HeadTrackingState headtrackingstate1;
            int i;
            headtrackingstate1 = getHeadTrackingState();
            if((i = daydreamManager.prepareVr(componentName, headtrackingstate1)) != 2)
                break MISSING_BLOCK_LABEL_294;
            Log.e("VrCoreSdkClient", "Daydream VR preparation failed, closing VR session.");
            handlePrepareVrFailed();
            resumeTracking(null);
            return;
            if(i == 0)
                headtrackingstate = headtrackingstate1;
            resumeTracking(headtrackingstate);
            return;
            RemoteException remoteexception2;
            remoteexception2;
            String s2;
            Log.w("VrCoreSdkClient", (new StringBuilder(61 + String.valueOf(s2 = String.valueOf(remoteexception2)).length())).append("Error while registering listener with the VrCore SDK Service:").append(s2).toString());
            resumeTracking(null);
            return;
            Exception exception;
            exception;
            resumeTracking(null);
            throw exception;
        }

        public void onServiceDisconnected(ComponentName componentname1)
        {
            vrCoreSdkService = null;
            daydreamManager = null;
        }

        final VrCoreSdkClient this$0;

            
            {
                this$0 = VrCoreSdkClient.this;
                super();
            }
    };











}
