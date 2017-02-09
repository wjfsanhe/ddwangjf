// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ExternalSurfaceManager.java

package com.google.vr.cardboard;

import android.os.Handler;
import android.view.Surface;
import com.google.vr.ndk.base.GvrLayout;

// Referenced classes of package com.google.vr.cardboard:
//            ExternalSurfaceManager

private static class handler
{

    public void postOnAvailable(final Surface surface)
    {
        handler.post(new Runnable() {

            public void run()
            {
                listener.onSurfaceAvailable(surface);
            }

            final Surface val$surface;
            final ExternalSurfaceManager.ExternalSurfaceCallback this$0;

            
            {
                this$0 = ExternalSurfaceManager.ExternalSurfaceCallback.this;
                surface = surface1;
                super();
            }
        });
    }

    public void postOnFrameAvailable()
    {
        handler.post(frameAvailableRunnable);
    }

    private final com.google.vr.ndk.base..frameAvailableRunnable listener;
    private final Handler handler;
    private final Runnable frameAvailableRunnable = new Runnable() {

        public void run()
        {
            listener.onFrameAvailable();
        }

        final ExternalSurfaceManager.ExternalSurfaceCallback this$0;

            
            {
                this$0 = ExternalSurfaceManager.ExternalSurfaceCallback.this;
                super();
            }
    };


    public _cls1.this._cls0(com.google.vr.ndk.base. , Handler handler1)
    {
        listener = ;
        handler = handler1;
    }
}
