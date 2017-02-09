// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DaydreamApi.java

package com.google.vr.ndk.base;

import android.os.RemoteException;
import android.util.Log;
import com.google.vr.vrcore.common.api.IDaydreamManager;
import com.google.vr.vrcore.common.api.ITransitionCallbacks;

// Referenced classes of package com.google.vr.ndk.base:
//            DaydreamApi

class sitionCallbacks
    implements Runnable
{

    public void run()
    {
        boolean flag = false;
        if(DaydreamApi.access$100(DaydreamApi.this) != null)
            try
            {
                flag = DaydreamApi.access$100(DaydreamApi.this).launchVrTransition(val$callbacks);
            }
            catch(RemoteException remoteexception)
            {
                Log.e(DaydreamApi.access$200(), "RemoteException while launching VR transition: ", remoteexception);
            }
        if(!flag)
        {
            Log.w(DaydreamApi.access$200(), "Can't launch callbacks via DaydreamManager, sending manually");
            try
            {
                val$callbacks.onTransitionComplete();
                return;
            }
            catch(RemoteException _ex) { }
        }
    }

    final ITransitionCallbacks val$callbacks;
    final DaydreamApi this$0;

    sitionCallbacks()
    {
        this$0 = final_daydreamapi;
        val$callbacks = ITransitionCallbacks.this;
        super();
    }
}
