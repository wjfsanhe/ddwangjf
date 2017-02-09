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
        if(DaydreamApi.access$400(DaydreamApi.this) < 11)
        {
            String s;
            int i;
            Log.e(DaydreamApi.access$200(), (new StringBuilder(11 + String.valueOf(s = String.valueOf("Can't handle removal of phone from headset: VrCore API too old. Need: 11, found: ")).length())).append(s).append(i = DaydreamApi.access$400(DaydreamApi.this)).toString());
            return;
        }
        if(DaydreamApi.access$100(DaydreamApi.this) == null)
        {
            Log.e(DaydreamApi.access$200(), "Can't handle removal of phone from headset: no DaydreamManager.");
            return;
        }
        try
        {
            DaydreamApi.access$100(DaydreamApi.this).handleRemovalFromHeadset();
            return;
        }
        catch(SecurityException securityexception)
        {
            Log.e(DaydreamApi.access$200(), "SecurityException when notifying phone removal. Check that the calling app is in the system image (must have the SYSTEM flag in package manager).", securityexception);
            return;
        }
        catch(RemoteException remoteexception)
        {
            Log.e(DaydreamApi.access$200(), "RemoteException while notifying phone removal.", remoteexception);
        }
    }

    final DaydreamApi this$0;

    eamManager()
    {
        this$0 = DaydreamApi.this;
        super();
    }
}
