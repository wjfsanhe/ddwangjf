// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DaydreamApi.java

package com.google.vr.ndk.base;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.util.Log;
import com.google.vr.vrcore.common.api.ITransitionCallbacks;

// Referenced classes of package com.google.vr.ndk.base:
//            DaydreamApi

class s.Stub extends com.google.vr.vrcore.common.api.lbacks.Stub
{

    public void onTransitionComplete()
    {
        val$activity.runOnUiThread(new Runnable() {

            public void run()
            {
                String s;
                try
                {
                    activity.startIntentSenderForResult(pendingIntent.getIntentSender(), requestCode, null, 0, 0, 0);
                    return;
                }
                catch(android.content.IntentSender.SendIntentException sendintentexception)
                {
                    Log.e(DaydreamApi.access$200(), (new StringBuilder(43 + String.valueOf(s = String.valueOf(sendintentexception)).length())).append("Exception while starting next VR activity: ").append(s).toString());
                }
            }

            final DaydreamApi._cls6 this$1;

            
            {
                this$1 = DaydreamApi._cls6.this;
                super();
            }
        });
    }

    final Activity val$activity;
    final PendingIntent val$pendingIntent;
    final int val$requestCode;

    _cls1.this._cls1(int i)
    {
        val$activity = activity1;
        val$pendingIntent = pendingintent;
        val$requestCode = i;
        super();
    }
}
