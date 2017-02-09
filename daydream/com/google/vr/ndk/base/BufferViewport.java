// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BufferViewport.java

package com.google.vr.ndk.base;

import android.graphics.RectF;
import android.util.Log;

// Referenced classes of package com.google.vr.ndk.base:
//            GvrApi

public class BufferViewport
{
    public static abstract class Reprojection
    {

        public static final int NONE = 0;
        public static final int FULL = 1;

        public Reprojection()
        {
        }
    }

    public static abstract class EyeType
    {

        public static final int LEFT = 0;
        public static final int RIGHT = 1;

        public EyeType()
        {
        }
    }


    BufferViewport(long l)
    {
        nativeBufferViewport = l;
    }

    public boolean equals(Object obj)
    {
        if(!(obj instanceof BufferViewport))
        {
            return false;
        } else
        {
            BufferViewport bufferviewport = (BufferViewport)obj;
            return GvrApi.nativeBufferViewportEqual(nativeBufferViewport, bufferviewport.nativeBufferViewport);
        }
    }

    protected void finalize()
        throws Throwable
    {
        if(nativeBufferViewport != 0L)
        {
            Log.w(TAG, "BufferViewport.shutdown() should be called to ensure resource cleanup");
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
        if(nativeBufferViewport != 0L)
        {
            GvrApi.nativeBufferViewportDestroy(nativeBufferViewport);
            nativeBufferViewport = 0L;
        }
    }

    public void getSourceUv(RectF rectf)
    {
        GvrApi.nativeBufferViewportGetSourceUv(nativeBufferViewport, rectf);
    }

    public void setSourceUv(RectF rectf)
    {
        GvrApi.nativeBufferViewportSetSourceUv(nativeBufferViewport, rectf.left, rectf.top, rectf.right, rectf.bottom);
    }

    public void getSourceFov(RectF rectf)
    {
        GvrApi.nativeBufferViewportGetSourceFov(nativeBufferViewport, rectf);
    }

    public void setSourceFov(RectF rectf)
    {
        GvrApi.nativeBufferViewportSetSourceFov(nativeBufferViewport, rectf.left, rectf.top, rectf.right, rectf.bottom);
    }

    public void getTransform(float af[])
    {
        GvrApi.nativeBufferViewportGetTransform(nativeBufferViewport, af);
    }

    public void setTransform(float af[])
    {
        GvrApi.nativeBufferViewportSetTransform(nativeBufferViewport, af);
    }

    public int getTargetEye()
    {
        return GvrApi.nativeBufferViewportGetTargetEye(nativeBufferViewport);
    }

    public void setTargetEye(int i)
    {
        GvrApi.nativeBufferViewportSetTargetEye(nativeBufferViewport, i);
    }

    public int getSourceBufferIndex()
    {
        return GvrApi.nativeBufferViewportGetSourceBufferIndex(nativeBufferViewport);
    }

    public void setSourceBufferIndex(int i)
    {
        GvrApi.nativeBufferViewportSetSourceBufferIndex(nativeBufferViewport, i);
    }

    public int getExternalSurfaceId()
    {
        return GvrApi.nativeBufferViewportGetExternalSurfaceId(nativeBufferViewport);
    }

    public void setExternalSurfaceId(int i)
    {
        GvrApi.nativeBufferViewportSetExternalSurfaceId(nativeBufferViewport, i);
    }

    public int getReprojection()
    {
        return GvrApi.nativeBufferViewportGetReprojection(nativeBufferViewport);
    }

    public void setReprojection(int i)
    {
        GvrApi.nativeBufferViewportSetReprojection(nativeBufferViewport, i);
    }

    private static final String TAG = com/google/vr/ndk/base/BufferViewport.getSimpleName();
    long nativeBufferViewport;
    public static final int EXTERNAL_SURFACE_ID_NONE = -1;
    public static final int BUFFER_INDEX_EXTERNAL_SURFACE = -1;

}
