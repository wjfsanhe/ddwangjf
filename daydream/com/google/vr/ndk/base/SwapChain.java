// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SwapChain.java

package com.google.vr.ndk.base;

import android.graphics.Point;
import android.util.Log;

// Referenced classes of package com.google.vr.ndk.base:
//            Frame, GvrApi

public class SwapChain
{

    SwapChain(long l)
    {
        nativeSwapChain = l;
        frames[0] = new Frame();
        frames[1] = new Frame();
        currentFrame = 0;
    }

    protected void finalize()
        throws Throwable
    {
        if(nativeSwapChain != 0L)
        {
            Log.w(TAG, "SwapChain.shutdown() should be called to ensure resource cleanup");
            shutdown();
        }
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public Frame acquireFrame()
    {
        if(frames[0].getNativeFrame() != 0L || frames[1].getNativeFrame() != 0L)
            throw new RuntimeException("Previous frame not submitted");
        currentFrame = (currentFrame + 1) % 2;
        long l;
        if((l = GvrApi.nativeSwapChainAcquireFrame(nativeSwapChain)) == 0L)
        {
            return null;
        } else
        {
            frames[currentFrame].setNativeFrame(l);
            return frames[currentFrame];
        }
    }

    public int getBufferCount()
    {
        return GvrApi.nativeSwapChainGetBufferCount(nativeSwapChain);
    }

    public void getBufferSize(int i, Point point)
    {
        GvrApi.nativeSwapChainGetBufferSize(nativeSwapChain, i, point);
    }

    public void resizeBuffer(int i, Point point)
    {
        GvrApi.nativeSwapChainResizeBuffer(nativeSwapChain, i, point.x, point.y);
    }

    public void shutdown()
    {
        if(nativeSwapChain != 0L)
        {
            GvrApi.nativeSwapChainDestroy(nativeSwapChain);
            nativeSwapChain = 0L;
        }
    }

    private static final String TAG = com/google/vr/ndk/base/SwapChain.getSimpleName();
    private long nativeSwapChain;
    private final Frame frames[] = new Frame[2];
    private int currentFrame;

}
