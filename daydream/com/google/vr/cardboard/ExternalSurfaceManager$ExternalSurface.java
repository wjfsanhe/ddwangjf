// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ExternalSurfaceManager.java

package com.google.vr.cardboard;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.view.Surface;
import com.google.vr.ndk.base.GvrApi;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.google.vr.cardboard:
//            ExternalSurfaceManager

private static class transformMatrix
{

    void maybeAttachToCurrentGLContext()
    {
        if(isAttached)
            return;
        GLES20.glGenTextures(1, glTextureId, 0);
        if(surfaceTexture == null)
        {
            surfaceTexture = new SurfaceTexture(glTextureId[0]);
            surfaceTexture.setOnFrameAvailableListener(new android.graphics.SurfaceTexture.OnFrameAvailableListener() {

                public void onFrameAvailable(SurfaceTexture surfacetexture)
                {
                    hasNewFrame.set(true);
                    if(callback != null)
                        callback.postOnFrameAvailable();
                }

                final ExternalSurfaceManager.ExternalSurface this$0;

            
            {
                this$0 = ExternalSurfaceManager.ExternalSurface.this;
                super();
            }
            });
            surface = new Surface(surfaceTexture);
        } else
        {
            surfaceTexture.attachToGLContext(glTextureId[0]);
        }
        isAttached = true;
        if(callback != null)
            callback.postOnAvailable(surface);
    }

    void maybeDetachFromCurrentGLContext()
    {
        if(!isAttached)
        {
            return;
        } else
        {
            surfaceTexture.detachFromGLContext();
            isAttached = false;
            return;
        }
    }

    void updateSurfaceTexture(GvrApi gvrapi)
    {
        if(!isAttached)
            return;
        boolean flag;
        if(flag = hasNewFrame.getAndSet(false))
        {
            surfaceTexture.updateTexImage();
            surfaceTexture.getTransformMatrix(transformMatrix);
            long l = surfaceTexture.getTimestamp();
            gvrapi.updateSurfaceReprojectionThread(id, glTextureId[0], l, transformMatrix);
        }
    }

    Surface getSurface()
    {
        return surface;
    }

    void shutdown(GvrApi gvrapi)
    {
        if(released.getAndSet(true))
            return;
        if(surfaceTexture != null)
        {
            surfaceTexture.release();
            surfaceTexture = null;
            surface = null;
        }
        gvrapi.updateSurfaceReprojectionThread(id, 0, 0L, transformMatrix);
    }

    private final int id;
    private final allback callback;
    private final float transformMatrix[] = new float[16];
    private final AtomicBoolean hasNewFrame = new AtomicBoolean(false);
    private final AtomicBoolean released = new AtomicBoolean(false);
    private final int glTextureId[] = new int[1];
    private volatile SurfaceTexture surfaceTexture;
    private volatile Surface surface;
    private boolean isAttached;




    allback(int i, allback allback)
    {
        isAttached = false;
        id = i;
        callback = allback;
        Matrix.setIdentityM(transformMatrix, 0);
    }
}
