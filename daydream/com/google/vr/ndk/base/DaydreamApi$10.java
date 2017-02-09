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

class val.deviceParams
    implements Runnable
{

    public void run()
    {
        if(DaydreamApi.access$400(DaydreamApi.this) < 11)
        {
            String s;
            int i;
            Log.e(DaydreamApi.access$200(), (new StringBuilder(11 + String.valueOf(s = String.valueOf("Can't handle insertion of phone into headset: VrCore API too old. Need: 11, found: ")).length())).append(s).append(i = DaydreamApi.access$400(DaydreamApi.this)).toString());
            return;
        }
        if(DaydreamApi.access$100(DaydreamApi.this) == null)
        {
            Log.e(DaydreamApi.access$200(), "Can't handle insertion of phone into headset: no DaydreamManager.");
            return;
        }
        try
        {
            DaydreamApi.access$100(DaydreamApi.this).handleInsertionIntoHeadset(val$deviceParams);
            return;
        }
        catch(SecurityException securityexception)
        {
            Log.e(DaydreamApi.access$200(), "SecurityException when notifying phone insertion. Check that the calling app is in the system image (must have the SYSTEM flag in package manager).", securityexception);
            return;
        }
        catch(RemoteException remoteexception)
        {
            Log.e(DaydreamApi.access$200(), "RemoteException while notifying phone insertion.", remoteexception);
        }
    }

    final byte val$deviceParams[];
    final DaydreamApi this$0;

    eamManager()
    {
        this$0 = final_daydreamapi;
        val$deviceParams = _5B_B.this;
        super();
    }
}
