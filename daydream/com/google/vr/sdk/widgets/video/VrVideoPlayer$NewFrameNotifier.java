// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrVideoPlayer.java

package com.google.vr.sdk.widgets.video;

import android.os.Handler;
import android.os.Looper;

// Referenced classes of package com.google.vr.sdk.widgets.video:
//            VrVideoPlayer, VideoTexture, VrVideoEventListener

private class mainHandler
    implements , Runnable
{

    public void onNewFrame()
    {
        mainHandler.post(this);
    }

    public void run()
    {
        if(VrVideoPlayer.access$100(VrVideoPlayer.this) != null)
            VrVideoPlayer.access$100(VrVideoPlayer.this).onNewFrame();
    }

    private Handler mainHandler;
    final VrVideoPlayer this$0;

    private ()
    {
        this$0 = VrVideoPlayer.this;
        super();
        mainHandler = new Handler(Looper.getMainLooper());
    }

}
