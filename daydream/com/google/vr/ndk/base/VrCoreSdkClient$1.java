// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrCoreSdkClient.java

package com.google.vr.ndk.base;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.vr.vrcore.common.api.*;

// Referenced classes of package com.google.vr.ndk.base:
//            VrCoreSdkClient

class this._cls0
    implements ServiceConnection
{

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        IVrCoreSdkService ivrcoresdkservice = com.google.vr.vrcore.common.api.Stub.asInterface(ibinder);
        try
        {
            if(!ivrcoresdkservice.initialize(10))
            {
                Log.e("VrCoreSdkClient", "Failed to initialize VrCore SDK Service.");
                VrCoreSdkClient.access$000(VrCoreSdkClient.this);
                return;
            }
        }
        catch(RemoteException remoteexception)
        {
            String s;
            Log.w("VrCoreSdkClient", (new StringBuilder(41 + String.valueOf(s = String.valueOf(remoteexception)).length())).append("Failed to initialize VrCore SDK Service: ").append(s).toString());
            VrCoreSdkClient.access$000(VrCoreSdkClient.this);
            return;
        }
        VrCoreSdkClient.access$102(VrCoreSdkClient.this, ivrcoresdkservice);
        try
        {
            VrCoreSdkClient.access$202(VrCoreSdkClient.this, VrCoreSdkClient.access$100(VrCoreSdkClient.this).getDaydreamManager());
            if(VrCoreSdkClient.access$200(VrCoreSdkClient.this) == null)
            {
                Log.w("VrCoreSdkClient", "Failed to obtain DaydreamManager from VrCore SDK Service.");
                VrCoreSdkClient.access$300(VrCoreSdkClient.this);
                return;
            }
        }
        catch(RemoteException remoteexception1)
        {
            String s1;
            Log.w("VrCoreSdkClient", (new StringBuilder(57 + String.valueOf(s1 = String.valueOf(remoteexception1)).length())).append("Failed to obtain DaydreamManager from VrCore SDK Service:").append(s1).toString());
            VrCoreSdkClient.access$300(VrCoreSdkClient.this);
            return;
        }
        VrCoreSdkClient.access$200(VrCoreSdkClient.this).registerListener(VrCoreSdkClient.access$400(VrCoreSdkClient.this), VrCoreSdkClient.access$500(VrCoreSdkClient.this));
        HeadTrackingState headtrackingstate = null;
        HeadTrackingState headtrackingstate1;
        int i;
        headtrackingstate1 = getHeadTrackingState();
        if((i = VrCoreSdkClient.access$200(VrCoreSdkClient.this).prepareVr(VrCoreSdkClient.access$400(VrCoreSdkClient.this), headtrackingstate1)) != 2)
            break MISSING_BLOCK_LABEL_294;
        Log.e("VrCoreSdkClient", "Daydream VR preparation failed, closing VR session.");
        VrCoreSdkClient.access$600(VrCoreSdkClient.this);
        VrCoreSdkClient.access$700(VrCoreSdkClient.this, null);
        return;
        if(i == 0)
            headtrackingstate = headtrackingstate1;
        VrCoreSdkClient.access$700(VrCoreSdkClient.this, headtrackingstate);
        return;
        RemoteException remoteexception2;
        remoteexception2;
        String s2;
        Log.w("VrCoreSdkClient", (new StringBuilder(61 + String.valueOf(s2 = String.valueOf(remoteexception2)).length())).append("Error while registering listener with the VrCore SDK Service:").append(s2).toString());
        VrCoreSdkClient.access$700(VrCoreSdkClient.this, null);
        return;
        Exception exception;
        exception;
        VrCoreSdkClient.access$700(VrCoreSdkClient.this, null);
        throw exception;
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        VrCoreSdkClient.access$102(VrCoreSdkClient.this, null);
        VrCoreSdkClient.access$202(VrCoreSdkClient.this, null);
    }

    final VrCoreSdkClient this$0;

    kService.Stub()
    {
        this$0 = VrCoreSdkClient.this;
        super();
    }
}
