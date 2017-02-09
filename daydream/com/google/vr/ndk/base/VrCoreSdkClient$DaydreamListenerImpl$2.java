// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrCoreSdkClient.java

package com.google.vr.ndk.base;


// Referenced classes of package com.google.vr.ndk.base:
//            FadeOverlayView, VrCoreSdkClient

class val.durationMillis
    implements Runnable
{

    public void run()
    {
        val$fadeOverlayView.startFade(val$fadeType, val$durationMillis);
    }

    final FadeOverlayView val$fadeOverlayView;
    final int val$fadeType;
    final long val$durationMillis;

    (long l)
    {
        val$fadeOverlayView = fadeoverlayview;
        val$fadeType = i;
        val$durationMillis = l;
        super();
    }
}
