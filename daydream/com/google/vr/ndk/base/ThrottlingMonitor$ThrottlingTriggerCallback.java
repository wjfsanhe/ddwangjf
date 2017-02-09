// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ThrottlingMonitor.java

package com.google.vr.ndk.base;

import android.os.Handler;
import com.google.vr.vrcore.performance.api.IThrottlingTriggerCallback;

// Referenced classes of package com.google.vr.ndk.base:
//            ThrottlingMonitor

private static class handler extends com.google.vr.vrcore.performance.api.ining
{

    public void onTriggerActivated(final float temperature, final long timeRemaining)
    {
        if(handler == null)
        {
            trigger.ratureEvent(temperature, timeRemaining);
            return;
        } else
        {
            handler.post(new Runnable() {

                public void run()
                {
                    trigger.onTemperatureEvent(temperature, timeRemaining);
                }

                final float val$temperature;
                final long val$timeRemaining;
                final ThrottlingMonitor.ThrottlingTriggerCallback this$0;

            
            {
                this$0 = ThrottlingMonitor.ThrottlingTriggerCallback.this;
                temperature = f;
                timeRemaining = l;
                super();
            }
            });
            return;
        }
    }

    private final _cls1.val.timeRemaining trigger;
    private final Handler handler;


    public _cls1.val.timeRemaining(_cls1.val.timeRemaining timeremaining, Handler handler1)
    {
        trigger = timeremaining;
        handler = handler1;
    }
}
