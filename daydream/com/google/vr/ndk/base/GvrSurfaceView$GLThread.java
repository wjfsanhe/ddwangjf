// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GvrSurfaceView.java

package com.google.vr.ndk.base;

import android.opengl.GLSurfaceView;
import com.google.vr.cardboard.EglReadyListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;

// Referenced classes of package com.google.vr.ndk.base:
//            GvrSurfaceView, TraceCompat

static class mGLThreadManager extends Thread
{
    private static class GLThreadManager
    {

        public synchronized void threadExiting(GvrSurfaceView.GLThread glthread)
        {
            glthread.mExited = true;
            notifyAll();
        }

        public void releaseEglContextLocked(GvrSurfaceView.GLThread glthread)
        {
            notifyAll();
        }

        private static final String TAG = "GLThreadManager";

        private GLThreadManager()
        {
        }

    }


    public void run()
    {
        Exception exception;
        long l;
        setName((new StringBuilder(29)).append("GLThread ").append(l = getId()).toString());
        try
        {
            guardedRun();
        }
        catch(InterruptedException _ex)
        {
            mGLThreadManager.threadExiting(this);
            return;
        }
        finally
        {
            mGLThreadManager.threadExiting(this);
        }
        mGLThreadManager.threadExiting(this);
        return;
        throw exception;
    }

    private void stopEglSurfaceLocked()
    {
        if(mHaveEglSurface)
        {
            mHaveEglSurface = false;
            mEglHelper.destroySurface();
        }
    }

    private void stopEglContextLocked()
    {
        if(mHaveEglContext)
        {
            mEglHelper.finish();
            mHaveEglContext = false;
            mGLThreadManager.