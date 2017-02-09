// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VideoTexture.java

package com.google.vr.sdk.widgets.video;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.util.Log;

public class VideoTexture
{
    private class UpdateSurfaceListener
        implements android.graphics.SurfaceTexture.OnFrameAvailableListener
    {

        public void onFrameAvailable(SurfaceTexture surfaceTexture)
        {
            synchronized(VideoTexture.this)
            {
                needUpdateTexture = true;
            }
            if(newFrameListener != null)
                newFrameListener.onNewFrame();
        }

        final VideoTexture this$0;

        private UpdateSurfaceListener()
        {
            this$0 = VideoTexture.this;
            super();
        }

    }

    public static interface OnNewFrameListener
    {

        public abstract void onNewFrame();
    }


    public VideoTexture()
    {
        needUpdateTexture = false;
    }

    public void init()
    {
        if(surfaceTexture != null)
        {
            Log.w(TAG, "Texture is already initialized");
            return;
        } else
        {
            GLES20.glGenTextures(1, textureHandle, 0);
            surfaceTexture = new SurfaceTexture(textureHandle[0]);
            surfaceTexture.setOnFrameAvailableListener(new UpdateSurfaceListener());
            GLES20.glBindTexture(36197, textureHandle[0]);
            return;
        }
    }

    public void setOnNewFrameListener(OnNewFrameListener newFrameListener)
    {
        this.newFrameListener = newFrameListener;
    }

    public synchronized void updateTexture()
    {
        if(needUpdateTexture)
        {
            if(surfaceTexture != null)
                surfaceTexture.updateTexImage();
            needUpdateTexture = false;
        }
    }

    public SurfaceTexture getSurfaceTexture()
    {
        return surfaceTexture;
    }

    public boolean getIsTextureSet()
    {
        return surfaceTexture != null;
    }

    public int getTextureId()
    {
        return textureHandle[0];
    }

    public long getTimestamp()
    {
        return surfaceTexture.getTimestamp();
    }

    public synchronized void release()
    {
        if(surfaceTexture != null)
        {
            surfaceTexture.release();
            GLES20.glDeleteTextures(1, textureHandle, 0);
            surfaceTexture = null;
        }
    }

    private static final String TAG = com/google/vr/sdk/widgets/video/VideoTexture.getSimpleName();
    private static final boolean DEBUG = false;
    private SurfaceTexture surfaceTexture;
    private final int textureHandle[] = new int[1];
    private boolean needUpdateTexture;
    private OnNewFrameListener newFrameListener;



}
