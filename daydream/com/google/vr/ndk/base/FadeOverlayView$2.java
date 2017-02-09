// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FadeOverlayView.java

package com.google.vr.ndk.base;

import android.os.*;

// Referenced classes of package com.google.vr.ndk.base:
//            FadeOverlayView

class this._cls0 extends Handler
{

    public void handleMessage(Message message)
    {
        if(message.what == 0x49c1485)
        {
            startFade(1, 350L);
            return;
        } else
        {
            super.handleMessage(message);
            return;
        }
    }

    final FadeOverlayView this$0;

    (Looper looper)
    {
        this$0 = FadeOverlayView.this;
        super(looper);
    }
}
