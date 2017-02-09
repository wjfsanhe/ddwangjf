// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GvrLayout.java

package com.google.vr.ndk.base;

import com.google.vr.cardboard.ScanlineRacingRenderer;

// Referenced classes of package com.google.vr.ndk.base:
//            GvrLayout

class this._cls0
    implements Runnable
{

    public void run()
    {
        GvrLayout.access$100(GvrLayout.this).onPause();
    }

    final GvrLayout this$0;

    ingRenderer()
    {
        this$0 = GvrLayout.this;
        super();
    }
}
