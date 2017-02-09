// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DaydreamApi.java

package com.google.vr.ndk.base;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.vr.vrcore.common.api.IVrCoreSdkService;

// Referenced classes of package com.google.vr.ndk.base:
//            DaydreamApi

class val.componentName
    implements Runnable
{

    public void run()
    {
        try
        {
            Bundle bundle;
            (bundle = new Bundle()).putBoolean("OPTION_INHIBIT_SYSTEM_BUTTONS", val$shouldInhibit);
            if(!DaydreamApi.access$000(DaydreamApi.this).setClientOptions(val$componentName, bundle))
                Log.w(DaydreamApi.access$200(), "Failed to set client options to inhibit system button.");
            return;
        }
        catch(RemoteException remoteexception)
        {
            Log.e(DaydreamApi.access$200(), "RemoteException while setting client options.", remoteexception);
        }
    }

    final boolean val$shouldInhibit;
    final ComponentName val$componentName;
    final DaydreamApi this$0;

    reSdkService()
    {
        this$0 = final_daydreamapi;
        val$shouldInhibit = flag;
        val$componentName = ComponentName.this;
        super();
    }
}
