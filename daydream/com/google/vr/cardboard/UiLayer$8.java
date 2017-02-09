// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UiLayer.java

package com.google.vr.cardboard;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

// Referenced classes of package com.google.vr.cardboard:
//            R, UiLayer

class val.scale
    implements Runnable
{

    public void run()
    {
        android.widget.yout.LayoutParams layoutparams = (android.widget.yout.LayoutParams)UiLayer.access$800(UiLayer.this).getLayoutParams();
        int i;
        int j = (int)((float)(i = (int)UiLayer.access$000(UiLayer.this).getResources().getDimension(ignment_marker_height)) * val$scale);
        if(layoutparams.getRule(15) == -1)
            layoutparams.width = j;
        else
            layoutparams.height = j;
        UiLayer.access$800(UiLayer.this).setLayoutParams(layoutparams);
    }

    final float val$scale;
    final UiLayer this$0;

    utParams()
    {
        this$0 = final_uilayer;
        val$scale = F.this;
        super();
    }
}
