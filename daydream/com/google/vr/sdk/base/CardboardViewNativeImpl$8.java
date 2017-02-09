// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CardboardViewNativeImpl.java

package com.google.vr.sdk.base;


// Referenced classes of package com.google.vr.sdk.base:
//            CardboardViewNativeImpl, GvrViewerParams

class val.newParams
    implements Runnable
{

    public void run()
    {
        CardboardViewNativeImpl.access$1000(CardboardViewNativeImpl.this, CardboardViewNativeImpl.access$100(CardboardViewNativeImpl.this), val$newParams.toByteArray());
    }

    final GvrViewerParams val$newParams;
    final CardboardViewNativeImpl this$0;

    ()
    {
        this.this$0 = this$0;
        val$newParams = GvrViewerParams.this;
        super();
    }
}
