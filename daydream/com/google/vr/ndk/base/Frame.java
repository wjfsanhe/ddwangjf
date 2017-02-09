// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Frame.java

package com.google.vr.ndk.base;

import android.graphics.Point;
import android.util.Log;

// Referenced classes of package com.google.vr.ndk.base:
//            BufferViewportList, GvrApi

public class Frame
{

    Frame()
    {
        nativeFrame = 0L;
    }

    protected void finalize()
        throws Throwable
    {
        if(nativeFrame != 0L)
            Log.w(TAG, "Frame finalized before it was submitted");
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public void bindBuffer(int i)
    {
        checkAccess();
        GvrApi.nativeFrameBindBuffer(nativeFrame, i);
    }

    public void unbind()
    {
        checkAccess();
        GvrApi.nativeFrameUnbind(nativeFrame);
    }

    public int getFramebufferObject(int i)
    {
        checkAccess();
        return GvrApi.nativeFrameGetFramebufferObject(nativeFrame, i);
    }

    public void getBufferSize(int i, Point point)
    {
        checkAccess();
        GvrApi.nativeFrameGetBufferSize(nativeFrame, i, point);
    }

    public void submit(BufferViewportList bufferviewportlist, float af[])
    {
        checkAccess();
        GvrApi.nativeFrameSubmit(nativeFrame, bufferviewportlist.nativeBufferViewportList, af);
        nativeFrame = 0L;
    }

    void setNativeFrame(long l)
    {
        nativeFrame = l;
    }

    long getNativeFrame()
    {
        return nativeFrame;
    }

    private void checkAccess()
    {
        if(nativeFrame == 0L)
            throw new RuntimeException("Frame was reused after submission");
        else
            return;
    }

    private static final String TAG = com/google/vr/ndk/base/Frame.getSimpleName();
    private long nativeFrame;

}
