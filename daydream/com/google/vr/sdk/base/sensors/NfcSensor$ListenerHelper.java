// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   NfcSensor.java

package com.google.vr.sdk.base.sensors;

import android.os.Handler;
import com.google.vr.sdk.base.GvrViewerParams;

// Referenced classes of package com.google.vr.sdk.base.sensors:
//            NfcSensor

private static class handler
    implements istener
{

    public istener getListener()
    {
        return listener;
    }

    public void onInsertedIntoGvrViewer(final GvrViewerParams viewerParams)
    {
        handler.post(new Runnable() {

            public void run()
            {
                listener.onInsertedIntoGvrViewer(viewerParams);
            }

            final GvrViewerParams val$viewerParams;
            final NfcSensor.ListenerHelper this$0;

            
            {
                this.this$0 = NfcSensor.ListenerHelper.this;
                viewerParams = gvrviewerparams;
                super();
            }
        });
    }

    public void onRemovedFromGvrViewer()
    {
        handler.post(new Runnable() {

            public void run()
            {
                listener.onRemovedFromGvrViewer();
            }

            final NfcSensor.ListenerHelper this$0;

            
            {
                this.this$0 = NfcSensor.ListenerHelper.this;
                super();
            }
        });
    }

    private istener listener;
    private Handler handler;


    public istener(istener listener, Handler handler)
    {
        this.listener = listener;
        this.handler = handler;
    }
}
