// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DaydreamApi.java

package com.google.vr.ndk.base;

import android.app.PendingIntent;
import android.os.RemoteException;
import android.util.Log;
import com.google.vr.vrcore.common.api.IDaydreamManager;

// Referenced classes of package com.google.vr.ndk.base:
//            DaydreamApi

class val.intent
    implements Runnable
{

    public void run()
    {
        if(DaydreamApi.access$100(DaydreamApi.this) == null)
        {
            Log.w(DaydreamApi.access$200(), "Can't register/unregister daydream intent: no DaydreamManager.");
            return;
        }
        try
        {
            if(val$intent != null)
            {
                DaydreamApi.access$100(DaydreamApi.this).registerDaydreamIntent(val$intent);
            } else
            {
                DaydreamApi.access$100(DaydreamApi.this).unregisterDaydreamIntent();
                return;
            }
        }
        catch(RemoteException remoteexception)
        {
            Log.e(DaydreamApi.access$200(), "Error when attempting to register/unregister daydream intent: ", remoteexception);
        }
    }

    final PendingIntent val$intent;
    final DaydreamApi this$0;

    reamManager()
    {
        this$0 = final_daydreamapi;
        val$intent = PendingIntent.this;
        super();
    }
}
