// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VideoTexture.java

package com.google.vr.sdk.widgets.video;

import android.graphics.SurfaceTexture;

// Referenced classes of package com.google.vr.sdk.widgets.video:
//            VideoTexture

private class this._cls0
    implements android.graphics.ener
{

    public void onFrameAvailable(SurfaceTexture surfaceTexture)
    {
        synchronized(VideoTexture.this)
        {
            VideoTexture.access$102(VideoTexture.this, true);
        }
        if(VideoTexture.access$200(VideoTexture.this) != null)
            VideoTexture.access$200(VideoTexture.this).ewFrame();
    }

    final VideoTexture this$0;

    private ()
    {
        this$0 = VideoTexture.this;
        super();
    }

}
