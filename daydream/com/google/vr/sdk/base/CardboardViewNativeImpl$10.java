// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CardboardViewNativeImpl.java

package com.google.vr.sdk.base;

import com.google.vr.ndk.base.GvrApi;

// Referenced classes of package com.google.vr.sdk.base:
//            CardboardViewNativeImpl

class this._cls0
    implements Runnable
{

    public void run()
    {
        CardboardViewNativeImpl.access$1300(CardboardViewNativeImpl.this).reconnectSensors();
    }

    final CardboardViewNativeImpl this$0;

    ()
    {
        this.this$0 = CardboardViewNativeImpl.this;
        super();
    }
}
