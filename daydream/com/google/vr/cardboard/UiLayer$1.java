// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UiLayer.java

package com.google.vr.cardboard;


// Referenced classes of package com.google.vr.cardboard:
//            UiLayer, UiUtils

class this._cls0
    implements Runnable
{

    public void run()
    {
        UiUtils.launchOrInstallCardboard(UiLayer.access$000(UiLayer.this));
    }

    final UiLayer this$0;

    ()
    {
        this$0 = UiLayer.this;
        super();
    }
}
