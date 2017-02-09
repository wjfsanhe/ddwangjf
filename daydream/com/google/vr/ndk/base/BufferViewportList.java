// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BufferViewportList.java

package com.google.vr.ndk.base;

import android.util.Log;

// Referenced classes of package com.google.vr.ndk.base:
//            BufferViewport, GvrApi

public class BufferViewportList
{

    BufferViewportList(long l)
    {
        nativeBufferViewportList = l;
    }

    protected void finalize()
        throws Throwable
    {
        if(nativeBufferViewportList != 0L)
        {
            Log.w(TAG, "BufferViewportList.shutdown() should be called to ensure resource cleanup");
            shutdown();
        }
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public void shutdown()
    {
        if(nativeBufferViewportList != 0L)
        {
            GvrApi.nativeBufferViewportListDestroy(nativeBufferViewportList);
            nativeBufferViewportList = 0L;
        }
    }

    public void get(int i, BufferViewport bufferviewport)
    {
        GvrApi.nativeBufferViewportListGetItem(nativeBufferViewportList, i, bufferviewport.nativeBufferViewport);
    }

    public void set(int i, BufferViewport bufferviewport)
    {
        GvrApi.nativeBufferViewportListSetItem(nativeBufferViewportList, i, bufferviewport.nativeBufferViewport);
    }

    public int size()
    {
        return GvrApi.nativeBufferViewportListGetSize(nativeBufferViewportList);
    }

    private static final String TAG = com/google/vr/ndk/base/BufferViewportList.getSimpleName();
    long nativeBufferViewportList;

}
