// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrCoreSdkClient.java

package com.google.vr.ndk.base;

import android.os.*;
import android.util.Log;
import com.google.vr.vrcore.common.api.HeadTrackingState;
import com.google.vr.vrcore.common.api.IDaydreamListener;
import java.lang.ref.WeakReference;

// Referenced classes of package com.google.vr.ndk.base:
//            FadeOverlayView, GvrApi, VrCoreSdkClient

private static final class fadeOverlayViewWeak extends com.google.vr.vrcore.common.api.ayViewWeak
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
            VrCoreSdkClient.access$1000(gvrapi, headtrackingstate);
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

        final VrCoreSdkClient.DaydreamListenerImpl this$0;

            
            {
                this$0 = VrCoreSdkClient.DaydreamListenerImpl.this;
                super();
            }
    };



    _cls1.this._cls0(GvrApi gvrapi, FadeOverlayView fadeoverlayview)
    {
        gvrApiWeak = new WeakReference(gvrapi);
        fadeOverlayViewWeak = new WeakReference(fadeoverlayview);
    }
}
