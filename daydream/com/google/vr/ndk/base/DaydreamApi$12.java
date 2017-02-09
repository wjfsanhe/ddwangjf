// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DaydreamApi.java

package com.google.vr.ndk.base;

import android.content.Context;

// Referenced classes of package com.google.vr.ndk.base:
//            DaydreamApi

class this._cls0
    implements Runnable
{

    public void run()
    {
        DaydreamApi.access$600(DaydreamApi.this).unbindService(DaydreamApi.access$500(DaydreamApi.this));
        DaydreamApi.access$002(DaydreamApi.this, null);
    }

    final DaydreamApi this$0;

    ()
    {
        this$0 = DaydreamApi.this;
        super();
    }
}
