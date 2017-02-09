// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DaydreamApi.java

package com.google.vr.ndk.base;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.vr.vrcore.common.api.IVrCoreSdkService;
import java.util.ArrayList;

// Referenced classes of package com.google.vr.ndk.base:
//            DaydreamApi

class this._cls0
    implements ServiceConnection
{

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        DaydreamApi.access$002(DaydreamApi.this, com.google.vr.vrcore.common.api.ice.Stub.asInterface(ibinder));
        try
        {
            DaydreamApi.access$102(DaydreamApi.this, DaydreamApi.access$000(DaydreamApi.this).getDaydreamManager());
        }
        catch(RemoteException _ex)
        {
            Log.e(DaydreamApi.access$200(), "RemoteException in onServiceConnected");
        }
        if(DaydreamApi.access$100(DaydreamApi.this) == null)
            Log.w(DaydreamApi.access$200(), "Daydream service component unavailable.");
        ArrayList arraylist;
        int i = (arraylist = (ArrayList)DaydreamApi.access$300(DaydreamApi.this)).size();
        int j = 0;
        Object obj = null;
        while(j < i) 
        {
            j++;
            Runnable runnable;
            (runnable = (Runnable)arraylist.get(j)).run();
        }
        DaydreamApi.access$300(DaydreamApi.this).clear();
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        DaydreamApi.access$002(DaydreamApi.this, null);
    }

    final DaydreamApi this$0;

    reSdkService.Stub()
    {
        this$0 = DaydreamApi.this;
        super();
    }
}
