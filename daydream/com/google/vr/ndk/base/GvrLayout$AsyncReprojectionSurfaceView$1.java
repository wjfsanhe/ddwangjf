// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GvrLayout.java

package com.google.vr.ndk.base;

import com.google.vr.cardboard.ScanlineRacingRenderer;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.google.vr.ndk.base:
//            GvrLayout

class val.destroySurfaceLatch
    implements Runnable
{

    public void run()
    {
        cess._mth300(this._cls0.this).onDestroySurface();
        val$destroySurfaceLatch.countDown();
    }

    final CountDownLatch val$destroySurfaceLatch;
    final val.destroySurfaceLatch this$0;

    ()
    {
        this$0 = final_;
        val$destroySurfaceLatch = CountDownLatch.this;
        super();
    }
}
