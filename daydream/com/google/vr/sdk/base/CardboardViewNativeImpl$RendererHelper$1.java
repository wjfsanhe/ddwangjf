// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CardboardViewNativeImpl.java

package com.google.vr.sdk.base;

import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.google.vr.sdk.base:
//            CardboardViewNativeImpl, GvrView

class this._cls1
    implements Runnable
{

    public void run()
    {
        if((cess._mth1800(this._cls1.this) != null || cess._mth1900(this._cls1.this) != null) && cess._mth2000(this._cls1.this))
        {
            cess._mth2002(this._cls1.this, false);
            cess._mth2100(this._cls1.this);
        }
        CardboardViewNativeImpl.access$2200(_fld0).countDown();
    }

    final is._cls0 this$1;

    ()
    {
        this.this$1 = this._cls1.this;
        super();
    }
}
