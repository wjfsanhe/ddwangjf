// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GvrSurfaceView.java

package com.google.vr.ndk.base;


// Referenced classes of package com.google.vr.ndk.base:
//            GvrSurfaceView

private static class 
{

    public synchronized void threadExiting( )
    {
        (, true);
        notifyAll();
    }

    public void releaseEglContextLocked( )
    {
        notifyAll();
    }

    private static final String TAG = "GLThreadManager";

    private ()
    {
    }

}
