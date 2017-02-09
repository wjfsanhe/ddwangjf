// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CardboardViewNativeImpl.java

package com.google.vr.sdk.base;


// Referenced classes of package com.google.vr.sdk.base:
//            CardboardViewNativeImpl, ScreenParams

class val.screenParams
    implements Runnable
{

    public void run()
    {
        CardboardViewNativeImpl.access$1100(CardboardViewNativeImpl.this).setScreenParams(val$screenParams);
        CardboardViewNativeImpl.access$1200(CardboardViewNativeImpl.this, CardboardViewNativeImpl.access$100(CardboardViewNativeImpl.this), val$screenParams.getWidth(), val$screenParams.getHeight(), val$screenParams.getWidthMeters() / (float)val$screenParams.getWidth(), val$screenParams.getHeightMeters() / (float)val$screenParams.getHeight(), val$screenParams.getBorderSizeMeters());
    }

    final ScreenParams val$screenParams;
    final CardboardViewNativeImpl this$0;

    ndererHelper()
    {
        this.this$0 = this$0;
        val$screenParams = ScreenParams.this;
        super();
    }
}
