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

class this._cls1
    implements Runnable
{

    public void run()
    {
        String s;
        try
        {
            activity.startIntentSenderForResult(pendingIntent.getIntentSender(), requestCode, null, 0, 0, 0);
            return;
        }
        catch(android.content.dIntentException dintentexception)
        {
            Log.e(DaydreamApi.access$200(), (new StringBuilder(43 + String.valueOf(s = String.valueOf(dintentexception)).length())).append("Exception while starting next VR activity: ").append(s).toString());
        }
    }

    final ss._cls200 this$1;

    tionCallbacks.Stub()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/google/vr/ndk/base/DaydreamApi$6

/* anonymous class */
    class DaydreamApi._cls6 extends com.google.vr.vrcore.common.api.ITransitionCallbacks.Stub
    {

        public void onTransitionComplete()
        {
            activity.runOnUiThread(new DaydreamApi._cls6._cls1());
        }

        final Activity val$activity;
        final PendingIntent val$pendingIntent;
        final int val$requestCode;

            
            {
                activity = activity1;
                pendingIntent = pendingintent;
                requestCode = i;
                super();
            }
    }

}
