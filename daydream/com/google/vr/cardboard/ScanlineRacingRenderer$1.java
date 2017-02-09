// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ScanlineRacingRenderer.java

package com.google.vr.cardboard;

import android.view.SurfaceHolder;
import com.google.vr.ndk.base.GvrSurfaceView;

// Referenced classes of package com.google.vr.cardboard:
//            ScanlineRacingRenderer

class val.surfaceHeightPixels
    implements Runnable
{

    public void run()
    {
        if(val$surfaceWidthPixels > 0 && val$surfaceHeightPixels > 0)
        {
            ScanlineRacingRenderer.access$000(ScanlineRacingRenderer.this).getHolder().setFixedSize(val$surfaceWidthPixels, val$surfaceHeightPixels);
            return;
        } else
        {
            ScanlineRacingRenderer.access$000(ScanlineRacingRenderer.this).getHolder().setSizeFromLayout();
            return;
        }
    }

    final int val$surfaceWidthPixels;
    final int val$surfaceHeightPixels;
    final ScanlineRacingRenderer this$0;

    ()
    {
        this$0 = final_scanlineracingrenderer;
        val$surfaceWidthPixels = i;
        val$surfaceHeightPixels = I.this;
        super();
    }
}
