// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DaydreamApi.java

package com.google.vr.ndk.base;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.os.RemoteException;
import android.util.Log;
import com.google.vr.vrcore.common.api.IDaydreamManager;

// Referenced classes of package com.google.vr.ndk.base:
//            DaydreamApi

class val.component
    implements Runnable
{

    public void run()
    {
        if(DaydreamApi.access$100(DaydreamApi.this) != null)
        {
            try
            {
                DaydreamApi.access$100(DaydreamApi.this).launchInVr(val$pendingIntent, val$component);
                return;
            }
            catch(RemoteException remoteexception)
            {
                Log.e(DaydreamApi.access$200(), "RemoteException while launching PendingIntent in VR.", remoteexception);
            }
            return;
        }
        Log.w(DaydreamApi.access$200(), "Can't launch PendingIntent via DaydreamManager: not available.");
        try
        {
            val$pendingIntent.send();
            return;
        }
        catch(Exception exception)
        {
            Log.e(DaydreamApi.access$200(), "Couldn't launch PendingIntent: ", exception);
        }
    }

    final PendingIntent val$pendingIntent;
    final ComponentName val$component;
    final DaydreamApi this$0;

    reamManager()
    {
        this$0 = final_daydreamapi;
        val$pendingIntent = pendingintent;
        val$component = ComponentName.this;
        super();
    }
}
