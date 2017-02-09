// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BufferSpec.java

package com.google.vr.ndk.base;

import android.graphics.Point;
import android.util.Log;

// Referenced classes of package com.google.vr.ndk.base:
//            GvrApi

public class BufferSpec
{
    public static abstract class DepthStencilFormat
    {

        public static final int NONE = 255;
        public static final int DEPTH_16 = 0;
        public static final int DEPTH_24 = 1;
        public static final int DEPTH_24_STENCIL_8 = 2;
        public static final int DEPTH_32_F = 3;
        public static final int DEPTH_32_F_STENCIL_8 = 4;
        public static final int STENCIL_8 = 5;
        public static final int NUM_FORMATS = 6;

        public DepthStencilFormat()
        {
        }
    }

    public static abstract class ColorFormat
    {

        public static final int RGBA_8888 = 0;
        public static final int RGB_565 = 1;
        public static final int NUM_FORMATS = 2;

        public ColorFormat()
        {
        }
    }


    BufferSpec(long l)
    {
        nativeBufferSpec = l;
    }

    protected void finalize()
        throws Throwable
    {
        if(nativeBufferSpec != 0L)
        {
            Log.w(TAG, "BufferSpec.shutdown() should be called to ensure resource cleanup");
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
        if(nativeBufferSpec != 0L)
        {
            GvrApi.nativeBufferSpecDestroy(nativeBufferSpec);
            nativeBufferSpec = 0L;
        }
    }

    public void getSize(Point point)
    {
        GvrApi.nativeBufferSpecGetSize(nativeBufferSpec, point);
    }

    public void setSize(Point point)
    {
        GvrApi.nativeBufferSpecSetSize(nativeBufferSpec, point.x, point.y);
    }

    public int getSamples()
    {
        return GvrApi.nativeBufferSpecGetSamples(nativeBufferSpec);
    }

    public void setSamples(int i)
    {
        GvrApi.nativeBufferSpecSetSamples(nativeBufferSpec, i);
    }

    public void setColorFormat(int i)
    {
        if(!isValidColorFormat(i))
        {
            throw new IllegalArgumentException("Invalid color format.");
        } else
        {
            GvrApi.nativeBufferSpecSetColorFormat(nativeBufferSpec, i);
            return;
        }
    }

    public void setDepthStencilFormat(int i)
    {
        if(!isValidDepthStencilFormat(i))
        {
            throw new IllegalArgumentException("Invalid depth-stencil format.");
        } else
        {
            GvrApi.nativeBufferSpecSetDepthStencilFormat(nativeBufferSpec, i);
            return;
        }
    }

    public static boolean isValidColorFormat(int i)
    {
        return i >= 0 && i < 2;
    }

    public static boolean isValidDepthStencilFormat(int i)
    {
        return i == 255 || i >= 0 && i < 6;
    }

    private static final String TAG = com/google/vr/ndk/base/BufferSpec.getSimpleName();
    long nativeBufferSpec;

}
