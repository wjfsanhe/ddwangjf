// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UiLayer.java

package com.google.vr.cardboard;


// Referenced classes of package com.google.vr.cardboard:
//            TransitionView, UiLayer

class val.enabled
    implements Runnable
{

    public void run()
    {
        if(!val$enabled && UiLayer.access$700(UiLayer.this) == null)
        {
            return;
        } else
        {
            UiLayer.access$900(UiLayer.this).setVisibility(UiLayer.access$300(val$enabled));
            return;
        }
    }

    final boolean val$enabled;
    final UiLayer this$0;

    View()
    {
        this$0 = final_uilayer;
        val$enabled = Z.this;
        super();
    }
}
