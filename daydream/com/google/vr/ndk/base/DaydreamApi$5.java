// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DaydreamApi.java

package com.google.vr.ndk.base;

import android.os.RemoteException;
import android.util.Log;
import com.google.vr.vrcore.common.api.IDaydreamManager;

// Referenced classes of package com.google.vr.ndk.base:
//            DaydreamApi

class this._cls0
    implements Runnable
{

    public void run()
    {
        if(DaydreamApi.access$100(DaydreamApi.this) == null)
        {
            Log.e(DaydreamApi.access$200(), "Can't launch VR homescreen via DaydreamManager. Giving up trying to leave current VR activity...");
            return;
        }
        if(DaydreamApi.access$100(DaydreamApi.this).launchVrHome())
            return;
        String s;
        try
        {
            Log.e(DaydreamApi.access$200(), "There is no VR homescreen installed.");
            return;
        }
        catch(RemoteException remoteexception)
        {
            Log.e(DaydreamApi.access$200(), (new StringBuilder(47 + String.valueOf(s = String.valueOf(remoteexception)).length())).append("RemoteException while launching VR homescreen: ").append(s).toString());
        }
        return;
    }

    final DaydreamApi this$0;

    reamManager()
    {
        this$0 = DaydreamApi.this;
        super();
    }
}
