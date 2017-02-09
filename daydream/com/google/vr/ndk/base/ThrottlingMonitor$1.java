// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ThrottlingMonitor.java

package com.google.vr.ndk.base;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.vr.vrcore.performance.api.IPerformanceService;
import java.util.ArrayList;

// Referenced classes of package com.google.vr.ndk.base:
//            ThrottlingMonitor

class this._cls0
    implements ServiceConnection
{

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        ArrayList arraylist = new ArrayList();
        synchronized(ThrottlingMonitor.access$000(ThrottlingMonitor.this))
        {
            ThrottlingMonitor.access$102(ThrottlingMonitor.this, com.google.vr.vrcore.performance.api.Stub.asInterface(ibinder));
            arraylist.addAll(ThrottlingMonitor.access$200(ThrottlingMonitor.this));
            ThrottlingMonitor.access$200(ThrottlingMonitor.this).clear();
            ThrottlingMonitor.access$000(ThrottlingMonitor.this).notifyAll();
        }
        ArrayList arraylist1;
        int i = (arraylist1 = (ArrayList)arraylist).size();
        int j = 0;
        Object obj1 = null;
        while(j < i) 
        {
            j++;
            tupCallback tupcallback;
            (tupcallback = (tupCallback)arraylist1.get(j)).onInitialized();
        }
    }

