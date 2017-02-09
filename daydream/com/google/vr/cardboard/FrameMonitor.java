// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FrameMonitor.java

package com.google.vr.cardboard;

import android.view.Choreographer;

// Referenced classes of package com.google.vr.cardboard:
//            ThreadUtils

public class FrameMonitor
    implements android.view.Choreographer.FrameCallback
{

    public FrameMonitor(android.view.Choreographer.FrameCallback framecallback)
    {
        this(Choreographer.getInstance(), framecallback);
    }

    public FrameMonitor(Choreographer choreographer1, android.view.Choreographer.FrameCallback framecallback)
    {
        ThreadUtils.assertOnUiThread();
        callback = framecallback;
        choreographer = choreographer1;
        choreographer1.postFrameCallback(this);
    }

    public void onPause()
    {
        if(isPaused)
        {
            return;
        } else
        {
            choreographer.removeFrameCallback(this);
            isPaused = true;
            return;
        }
    }

    public void onResume()
    {
        if(!isPaused)
        {
            return;
        } else
        {
            isPaused = false;
            choreographer.postFrameCallback(this);
            return;
        }
    }

    public void doFrame(long l)
    {
        choreographer.postFrameCallback(this);
        callback.doFrame(l);
    }

    private final Choreographer choreographer;
    private final android.view.Choreographer.FrameCallback callback;
    private boolean isPaused;
    static final boolean $assertionsDisabled;

}
