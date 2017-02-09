// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UiLayer.java

package com.google.vr.cardboard;

import android.view.View;

// Referenced classes of package com.google.vr.cardboard:
//            UiLayer

class this._cls0
    implements android.view.ckListener
{

    public void onClick(View view)
    {
        Runnable runnable;
        if((runnable = UiLayer.access$200(UiLayer.this)) != null)
            runnable.run();
    }

    final UiLayer this$0;

    ()
    {
        this$0 = UiLayer.this;
        super();
    }
}
