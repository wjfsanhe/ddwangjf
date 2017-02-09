// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GvrSurfaceView.java

package com.google.vr.ndk.base;

import android.content.Context;
import android.opengl.*;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.google.vr.cardboard.EglFactory;
import com.google.vr.cardboard.EglReadyListener;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.*;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

// Referenced classes of package com.google.vr.ndk.base:
//            TraceCompat

public class GvrSurfaceView extends SurfaceView
    implements android.view.SurfaceHolder.Callback2
{
    static class LogWriter extends Writer
    {

        public void close()
        {
            flushBuilder();
        }

        public void flush()
        {
            flushBuilder();
        }

        public void write(char ac[], int i, int j)
        {
            for(int k = 0; k < j; k++)
            {
                char c;
                if((c = ac[i + k]) == '\n')
                    flushBuilder();
                else
                    mBuilder.append(c);
            }

        }

        private void flushBuilder()
        {
            if(mBuilder.length() > 0)
            {
                Log.v("GvrSurfaceView", mBuilder.toString());
                mBuilder.delete(0, mBuilder.length());
            }
        }

        private StringBuilder mBuilder;

        LogWriter()
        {
            mBuilder = new StringBuilder();
        }
    }

    static class GLThread extends Thread
    {
        private static class GLThreadManager
        {

            public synchronized void threadExiting(GLThread glthread)
            {
                glthread.mExited = true;
                notifyAll();
            }

            public void releaseEglContextLocked(GLThread glthread)
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
                mGLThreadManager.releaseEglContextLocked(this);
            }
        }

        private void guardedRun()
            throws InterruptedException
        {
            mEglHelper = new EglHelper(mGvrSurfaceViewWeakRef);
            mHaveEglContext = false;
            mHaveEglSurface = false;
            mWantRenderNotification = false;
            GL10 gl10;
            boolean flag;
            boolean flag1;
            boolean flag2;
            boolean flag3;
            boolean flag4;
            boolean flag5;
            boolean flag6;
            boolean flag7;
            boolean flag8;
            int i;
            int j;
            int k;
            gl10 = null;
            flag = false;
            flag1 = false;
            flag2 = false;
            flag3 = false;
            flag4 = false;
            flag5 = false;
            flag6 = false;
            flag7 = false;
            flag8 = false;
            i = 0;
            j = 0;
            k = 0;
            Runnable runnable = null;
_L4:
            Object obj = mGLThreadManager;
            JVM INSTR monitorenter ;
_L2:
            if(mShouldExit)
            {
                synchronized(mGLThreadManager)
                {
                    stopEglSurfaceLocked();
                    stopEglContextLocked();
                }
                return;
            }
label0:
            {
                if(!mEventQueue.isEmpty())
                {
                    runnable = (Runnable)mEventQueue.remove(0);
                    break label0;
                }
                boolean flag9 = false;
                if(mPaused != mRequestPaused)
                {
                    flag9 = mRequestPaused;
                    mPaused = mRequestPaused;
                    mGLThreadManager.notifyAll();
                }
                if(mShouldReleaseEglContext)
                {
                    stopEglSurfaceLocked();
                    stopEglContextLocked();
                    mShouldReleaseEglContext = false;
                    flag7 = true;
                }
                if(flag3)
                {
                    stopEglSurfaceLocked();
                    stopEglContextLocked();
                    flag3 = false;
                }
                if(flag9 && mHaveEglSurface)
                    stopEglSurfaceLocked();
                GvrSurfaceView gvrsurfaceview;
                boolean flag10;
                if(flag9 && mHaveEglContext && !(flag10 = (gvrsurfaceview = (GvrSurfaceView)mGvrSurfaceViewWeakRef.get()) != null ? gvrsurfaceview.mPreserveEGLContextOnPause : false))
                    stopEglContextLocked();
                if(!mHasSurface && !mWaitingForSurface)
                {
                    if(mHaveEglSurface)
                        stopEglSurfaceLocked();
                    mWaitingForSurface = true;
                    mSurfaceIsBad = false;
                    mGLThreadManager.notifyAll();
                }
                if(mHasSurface && mWaitingForSurface)
                {
                    mWaitingForSurface = false;
                    mGLThreadManager.notifyAll();
                }
                if(flag6)
                {
                    mWantRenderNotification = false;
                    flag6 = false;
                    mRenderComplete = true;
                    mGLThreadManager.notifyAll();
                }
                if(readyToDraw())
                {
                    if(!mHaveEglContext)
                        if(flag7)
                        {
                            flag7 = false;
                        } else
                        {
                            try
                            {
                                mEglHelper.start();
                            }
                            catch(RuntimeException runtimeexception)
                            {
                                mGLThreadManager.releaseEglContextLocked(this);
                                throw runtimeexception;
                            }
                            mHaveEglContext = true;
                            flag = true;
                            mGLThreadManager.notifyAll();
                        }
                    if(mHaveEglContext && !mHaveEglSurface)
                    {
                        mHaveEglSurface = true;
                        flag1 = true;
                        flag2 = true;
                        flag4 = true;
                    }
                    if(mHaveEglSurface)
                    {
                        if(mSizeChanged)
                        {
                            flag4 = true;
                            j = mWidth;
                            k = mHeight;
                            mWantRenderNotification = true;
                            flag1 = true;
                            mSizeChanged = false;
                        }
                        mRequestRender = false;
                        mGLThreadManager.notifyAll();
                        if(mWantRenderNotification)
                            flag5 = true;
                        flag8 = mRequestedSwapMode != i;
                        i = mRequestedSwapMode;
                        break label0;
                    }
                }
                mGLThreadManager.wait();
            }
            if(true) goto _L2; else goto _L1
_L1:
            obj;
            JVM INSTR monitorexit ;
              goto _L3
            Exception exception1;
            exception1;
            throw exception1;
_L3:
            if(runnable == null)
                break MISSING_BLOCK_LABEL_590;
            runnable.run();
            runnable = null;
              goto _L4
label1:
            {
                if(!flag1)
                    break MISSING_BLOCK_LABEL_682;
                if(mEglHelper.createSurface())
                {
                    synchronized(mGLThreadManager)
                    {
                        mFinishedCreatingEglSurface = true;
                        mGLThreadManager.notifyAll();
                    }
                    break label1;
                }
                synchronized(mGLThreadManager)
                {
                    mFinishedCreatingEglSurface = true;
                    mSurfaceIsBad = true;
                    mGLThreadManager.notifyAll();
                }
            }
            if(true) goto _L4; else goto _L5
_L5:
            flag1 = false;
            i = 0;
            if(flag2)
            {
                gl10 = (GL10)mEglHelper.createGL();
                flag2 = false;
            }
            if(!flag)
                break MISSING_BLOCK_LABEL_760;
            if((glthreadmanager1 = (GvrSurfaceView)mGvrSurfaceViewWeakRef.get()) == null)
                break MISSING_BLOCK_LABEL_758;
            TraceCompat.beginSection("onSurfaceCreated");
            ((GvrSurfaceView) (glthreadmanager1)).mRenderer.onSurfaceCreated(gl10, mEglHelper.mEglConfig);
            TraceCompat.endSection();
            break MISSING_BLOCK_LABEL_758;
            Exception exception4;
            exception4;
            TraceCompat.endSection();
            throw exception4;
            flag = false;
            if(!flag4)
                break MISSING_BLOCK_LABEL_818;
            if((glthreadmanager1 = (GvrSurfaceView)mGvrSurfaceViewWeakRef.get()) == null)
                break MISSING_BLOCK_LABEL_815;
            TraceCompat.beginSection("onSurfaceChanged");
            ((GvrSurfaceView) (glthreadmanager1)).mRenderer.onSurfaceChanged(gl10, j, k);
            TraceCompat.endSection();
            break MISSING_BLOCK_LABEL_815;
            Exception exception5;
            exception5;
            TraceCompat.endSection();
            throw exception5;
            flag4 = false;
            if(flag8)
            {
                mEglHelper.setEglSurfaceAttrib(12422, i != 1 ? 12420 : 12421);
                mEglHelper.setEglSurfaceAttrib(12620, i != 1 ? 0 : 1);
            }
            if((glthreadmanager1 = (GvrSurfaceView)mGvrSurfaceViewWeakRef.get()) == null)
                break MISSING_BLOCK_LABEL_915;
            TraceCompat.beginSection("onDrawFrame");
            ((GvrSurfaceView) (glthreadmanager1)).mRenderer.onDrawFrame(gl10);
            TraceCompat.endSection();
            break MISSING_BLOCK_LABEL_915;
            Exception exception6;
            exception6;
            TraceCompat.endSection();
            throw exception6;
            int l;
            if(flag8 || i == 0)
                switch(l = mEglHelper.swap())
                {
                case 12288: 
                    break;

                case 12302: 
                    flag3 = true;
                    break;

                default:
                    EglHelper.logEglErrorAsWarning("GLThread", "eglSwapBuffers", l);
                    if(i != 0)
                        break;
                    synchronized(mGLThreadManager)
                    {
                        mSurfaceIsBad = true;
                        mGLThreadManager.notifyAll();
                    }
                    break;
                }
            if(!flag5) goto _L4; else goto _L6
_L6:
            flag6 = true;
            flag5 = false;
              goto _L4
            Exception exception8;
            exception8;
            synchronized(mGLThreadManager)
            {
                stopEglSurfaceLocked();
                stopEglContextLocked();
            }
            throw exception8;
        }

        public boolean ableToDraw()
        {
            return mHaveEglContext && mHaveEglSurface && readyToDraw();
        }

        private boolean readyToDraw()
        {
            GvrSurfaceView gvrsurfaceview;
            EglReadyListener eglreadylistener;
            boolean flag = (eglreadylistener = (gvrsurfaceview = (GvrSurfaceView)mGvrSurfaceViewWeakRef.get()) != null ? gvrsurfaceview.mAppContextListener : null) == null || eglreadylistener.getEGLContext() != null;
            return !mPaused && flag && mHasSurface && !mSurfaceIsBad && mWidth > 0 && mHeight > 0 && (mRequestRender || mRenderMode == 1);
        }

        public void setRenderMode(int i)
        {
            if(i < 0 || i > 1)
                throw new IllegalArgumentException("renderMode");
            synchronized(mGLThreadManager)
            {
                mRenderMode = i;
                mGLThreadManager.notifyAll();
            }
        }

        public void setSwapMode(int i)
        {
            if(i < 0 || i > 2)
                throw new IllegalArgumentException("swapMode");
            synchronized(mGLThreadManager)
            {
                mRequestedSwapMode = i;
                mGLThreadManager.notifyAll();
            }
        }

        public int getRenderMode()
        {
            GLThreadManager glthreadmanager = mGLThreadManager;
            JVM INSTR monitorenter ;
            return mRenderMode;
            Exception exception;
            exception;
            throw exception;
        }

        public int getSwapMode()
        {
            GLThreadManager glthreadmanager = mGLThreadManager;
            JVM INSTR monitorenter ;
            return mRequestedSwapMode;
            Exception exception;
            exception;
            throw exception;
        }

        public void requestRender()
        {
            synchronized(mGLThreadManager)
            {
                mRequestRender = true;
                mGLThreadManager.notifyAll();
            }
        }

        public void requestRenderAndWait()
        {
label0:
            {
                synchronized(mGLThreadManager)
                {
                    if(Thread.currentThread() != this)
                        break label0;
                }
                return;
            }
            mWantRenderNotification = true;
            mRequestRender = true;
            mRenderComplete = false;
            mGLThreadManager.notifyAll();
            while(!mExited && !mPaused && !mRenderComplete && ableToDraw()) 
                try
                {
                    mGLThreadManager.wait();
                }
                catch(InterruptedException _ex)
                {
                    Thread.currentThread().interrupt();
                }
            glthreadmanager;
            JVM INSTR monitorexit ;
        }

        public void surfaceCreated()
        {
            synchronized(mGLThreadManager)
            {
                mHasSurface = true;
                mFinishedCreatingEglSurface = false;
                mGLThreadManager.notifyAll();
                while(mWaitingForSurface && !mFinishedCreatingEglSurface && !mExited) 
                    try
                    {
                        mGLThreadManager.wait();
                    }
                    catch(InterruptedException _ex)
                    {
                        Thread.currentThread().interrupt();
                    }
            }
        }

        public void surfaceDestroyed()
        {
            synchronized(mGLThreadManager)
            {
                mHasSurface = false;
                mGLThreadManager.notifyAll();
                while(!mWaitingForSurface && !mExited) 
                    try
                    {
                        mGLThreadManager.wait();
                    }
                    catch(InterruptedException _ex)
                    {
                        Thread.currentThread().interrupt();
                    }
            }
        }

        public void onPause()
        {
            synchronized(mGLThreadManager)
            {
                mRequestPaused = true;
                mGLThreadManager.notifyAll();
                while(!mExited && !mPaused) 
                    try
                    {
                        mGLThreadManager.wait();
                    }
                    catch(InterruptedException _ex)
                    {
                        Thread.currentThread().interrupt();
                    }
            }
        }

        public void onResume()
        {
            synchronized(mGLThreadManager)
            {
                mRequestPaused = false;
                mRequestRender = true;
                mRenderComplete = false;
                mGLThreadManager.notifyAll();
                while(!mExited && mPaused && !mRenderComplete) 
                    try
                    {
                        mGLThreadManager.wait();
                    }
                    catch(InterruptedException _ex)
                    {
                        Thread.currentThread().interrupt();
                    }
            }
        }

        public void onWindowResize(int i, int j)
        {
label0:
            {
                synchronized(mGLThreadManager)
                {
                    mWidth = i;
                    mHeight = j;
                    mSizeChanged = true;
                    mRequestRender = true;
                    mRenderComplete = false;
                    if(Thread.currentThread() != this)
                        break label0;
                }
                return;
            }
            mGLThreadManager.notifyAll();
            while(!mExited && !mPaused && !mRenderComplete && ableToDraw()) 
                try
                {
                    mGLThreadManager.wait();
                }
                catch(InterruptedException _ex)
                {
                    Thread.currentThread().interrupt();
                }
            glthreadmanager;
            JVM INSTR monitorexit ;
        }

        public void requestExitAndWait()
        {
            synchronized(mGLThreadManager)
            {
                mShouldExit = true;
                mGLThreadManager.notifyAll();
                while(!mExited) 
                    try
                    {
                        mGLThreadManager.wait();
                    }
                    catch(InterruptedException _ex)
                    {
                        Thread.currentThread().interrupt();
                    }
            }
        }

        public void requestReleaseEglContextLocked()
        {
            mShouldReleaseEglContext = true;
            mGLThreadManager.notifyAll();
        }

        public void queueEvent(Runnable runnable)
        {
            if(runnable == null)
                throw new IllegalArgumentException("r must not be null");
            synchronized(mGLThreadManager)
            {
                mEventQueue.add(runnable);
                mGLThreadManager.notifyAll();
            }
        }

        private boolean mShouldExit;
        private boolean mExited;
        private boolean mRequestPaused;
        private boolean mPaused;
        private boolean mHasSurface;
        private boolean mSurfaceIsBad;
        private boolean mWaitingForSurface;
        private boolean mHaveEglContext;
        private boolean mHaveEglSurface;
        private boolean mFinishedCreatingEglSurface;
        private boolean mShouldReleaseEglContext;
        private int mWidth;
        private int mHeight;
        private int mRenderMode;
        private int mRequestedSwapMode;
        private boolean mRequestRender;
        private boolean mWantRenderNotification;
        private boolean mRenderComplete;
        private ArrayList mEventQueue;
        private boolean mSizeChanged;
        private EglHelper mEglHelper;
        private WeakReference mGvrSurfaceViewWeakRef;
        private final GLThreadManager mGLThreadManager = new GLThreadManager();


        GLThread(WeakReference weakreference)
        {
            mEventQueue = new ArrayList();
            mSizeChanged = true;
            mWidth = 0;
            mHeight = 0;
            mRequestRender = true;
            mRenderMode = 1;
            mRequestedSwapMode = 0;
            mWantRenderNotification = false;
            mGvrSurfaceViewWeakRef = weakreference;
            GvrSurfaceView gvrsurfaceview;
            if((gvrsurfaceview = (GvrSurfaceView)weakreference.get()) != null && gvrsurfaceview.mAppContextListener != null)
                gvrsurfaceview.mAppContextListener.setMonitor(mGLThreadManager);
        }
    }

    private static class EglHelper
    {

        public void start()
        {
            mEgl = (EGL10)EGLContext.getEGL();
            mEglDisplay = mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if(mEglDisplay == EGL10.EGL_NO_DISPLAY)
                throw new RuntimeException("eglGetDisplay failed");
            int ai[] = new int[2];
            if(!mEgl.eglInitialize(mEglDisplay, ai))
                throw new RuntimeException("eglInitialize failed");
            GvrSurfaceView gvrsurfaceview;
            if((gvrsurfaceview = (GvrSurfaceView)mGvrSurfaceViewWeakRef.get()) == null)
            {
                mEglConfig = null;
                mEglContext = null;
            } else
            {
                EGLContext eglcontext;
                if(gvrsurfaceview.mAppContextListener != null)
                    if((eglcontext = gvrsurfaceview.mAppContextListener.getEGLContext()) == null || eglcontext == EGL10.EGL_NO_CONTEXT)
                        throwEglException("Unable to obtain application's OpenGL context.");
                    else
                        ((EglFactory)gvrsurfaceview.mEGLContextFactory).setSharedContext(eglcontext);
                mEglConfig = gvrsurfaceview.mEGLConfigChooser.chooseConfig(mEgl, mEglDisplay);
                mEglContext = gvrsurfaceview.mEGLContextFactory.createContext(mEgl, mEglDisplay, mEglConfig);
            }
            if(mEglContext == null || mEglContext == EGL10.EGL_NO_CONTEXT)
            {
                mEglContext = null;
                throwEglException("createContext");
            }
            mEglSurface = null;
        }

        public boolean createSurface()
        {
            if(mEgl == null)
                throw new RuntimeException("egl not initialized");
            if(mEglDisplay == null)
                throw new RuntimeException("eglDisplay not initialized");
            if(mEglConfig == null)
                throw new RuntimeException("mEglConfig not initialized");
            destroySurfaceImp();
            GvrSurfaceView gvrsurfaceview;
            if((gvrsurfaceview = (GvrSurfaceView)mGvrSurfaceViewWeakRef.get()) != null)
                mEglSurface = gvrsurfaceview.mEGLWindowSurfaceFactory.createWindowSurface(mEgl, mEglDisplay, mEglConfig, gvrsurfaceview.getHolder());
            else
                mEglSurface = null;
            if(mEglSurface == null || mEglSurface == EGL10.EGL_NO_SURFACE)
            {
                int i;
                if((i = mEgl.eglGetError()) == 12299)
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                return false;
            }
            if(!mEgl.eglMakeCurrent(mEglDisplay, mEglSurface, mEglSurface, mEglContext))
            {
                logEglErrorAsWarning("EGLHelper", "eglMakeCurrent", mEgl.eglGetError());
                return false;
            } else
            {
                return true;
            }
        }

        GL createGL()
        {
            GL gl = mEglContext.getGL();
            GvrSurfaceView gvrsurfaceview;
            if((gvrsurfaceview = (GvrSurfaceView)mGvrSurfaceViewWeakRef.get()) != null)
            {
                if(gvrsurfaceview.mGLWrapper != null)
                    gl = gvrsurfaceview.mGLWrapper.wrap(gl);
                if((gvrsurfaceview.mDebugFlags & 3) != 0)
                {
                    int i = 0;
                    LogWriter logwriter = null;
                    if((gvrsurfaceview.mDebugFlags & 1) != 0)
                        i = 1;
                    if((gvrsurfaceview.mDebugFlags & 2) != 0)
                        logwriter = new LogWriter();
                    gl = GLDebugHelper.wrap(gl, i, logwriter);
                }
            }
            return gl;
        }

        public int swap()
        {
            if(!mEgl.eglSwapBuffers(mEglDisplay, mEglSurface))
                return mEgl.eglGetError();
            else
                return 12288;
        }

        public void destroySurface()
        {
            destroySurfaceImp();
        }

        public void setEglSurfaceAttrib(int i, int j)
        {
            if(android.os.Build.VERSION.SDK_INT < 17)
            {
                Log.e("EglHelper", "Cannot call eglSurfaceAttrib. API version is too low.");
                return;
            }
            android.opengl.EGLDisplay egldisplay = EGL14.eglGetCurrentDisplay();
            android.opengl.EGLSurface eglsurface = EGL14.eglGetCurrentSurface(12377);
            boolean flag;
            if(!(flag = EGL14.eglSurfaceAttrib(egldisplay, eglsurface, i, j)))
                Log.e("EglHelper", (new StringBuilder(66)).append("eglSurfaceAttrib() failed. attribute=").append(i).append(" value=").append(j).toString());
        }

        private void destroySurfaceImp()
        {
            if(mEglSurface != null && mEglSurface != EGL10.EGL_NO_SURFACE)
            {
                mEgl.eglMakeCurrent(mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                GvrSurfaceView gvrsurfaceview;
                if((gvrsurfaceview = (GvrSurfaceView)mGvrSurfaceViewWeakRef.get()) != null)
                    gvrsurfaceview.mEGLWindowSurfaceFactory.destroySurface(mEgl, mEglDisplay, mEglSurface);
                mEglSurface = null;
            }
        }

        public void finish()
        {
            if(mEglContext != null)
            {
                GvrSurfaceView gvrsurfaceview;
                if((gvrsurfaceview = (GvrSurfaceView)mGvrSurfaceViewWeakRef.get()) != null)
                    gvrsurfaceview.mEGLContextFactory.destroyContext(mEgl, mEglDisplay, mEglContext);
                mEglContext = null;
            }
            if(mEglDisplay != null)
            {
                mEgl.eglTerminate(mEglDisplay);
                mEglDisplay = null;
            }
        }

        private void throwEglException(String s)
        {
            throwEglException(s, mEgl.eglGetError());
        }

        public static void throwEglException(String s, int i)
        {
            String s1 = formatEglError(s, i);
            throw new RuntimeException(s1);
        }

        public static void logEglErrorAsWarning(String s, String s1, int i)
        {
            Log.w(s, formatEglError(s1, i));
        }

        public static String formatEglError(String s, int i)
        {
            String s1 = String.valueOf(getErrorString(i));
            return (new StringBuilder(9 + String.valueOf(s).length() + String.valueOf(s1).length())).append(s).append(" failed: ").append(s1).toString();
        }

        private static String getHex(int i)
        {
            "0x";
            String s = String.valueOf(Integer.toHexString(i));
            s;
            if(s.length() == 0) goto _L2; else goto _L1
_L1:
            concat();
            return;
_L2:
            JVM INSTR pop ;
            JVM INSTR new #52  <Class String>;
            JVM INSTR dup_x1 ;
            JVM INSTR swap ;
            String();
            return;
        }

        private static String getErrorString(int i)
        {
            switch(i)
            {
            case 12288: 
                return "EGL_SUCCESS";

            case 12289: 
                return "EGL_NOT_INITIALIZED";

            case 12290: 
                return "EGL_BAD_ACCESS";

            case 12291: 
                return "EGL_BAD_ALLOC";

            case 12292: 
                return "EGL_BAD_ATTRIBUTE";

            case 12293: 
                return "EGL_BAD_CONFIG";

            case 12294: 
                return "EGL_BAD_CONTEXT";

            case 12295: 
                return "EGL_BAD_CURRENT_SURFACE";

            case 12296: 
                return "EGL_BAD_DISPLAY";

            case 12297: 
                return "EGL_BAD_MATCH";

            case 12298: 
                return "EGL_BAD_NATIVE_PIXMAP";

            case 12299: 
                return "EGL_BAD_NATIVE_WINDOW";

            case 12300: 
                return "EGL_BAD_PARAMETER";

            case 12301: 
                return "EGL_BAD_SURFACE";

            case 12302: 
                return "EGL_CONTEXT_LOST";
            }
            return getHex(i);
        }

        public static final int EGL_FRONT_BUFFER_AUTO_REFRESH = 12620;
        private WeakReference mGvrSurfaceViewWeakRef;
        EGL10 mEgl;
        EGLDisplay mEglDisplay;
        EGLSurface mEglSurface;
        EGLConfig mEglConfig;
        EGLContext mEglContext;

        public EglHelper(WeakReference weakreference)
        {
            mGvrSurfaceViewWeakRef = weakreference;
        }
    }

    private class SimpleEGLConfigChooser extends ComponentSizeChooser
    {

        public SimpleEGLConfigChooser(boolean flag)
        {
            super(8, 8, 8, 0, flag ? 16 : 0, 0);
        }
    }

    private class ComponentSizeChooser extends BaseConfigChooser
    {

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay egldisplay, EGLConfig aeglconfig[])
        {
            EGLConfig aeglconfig1[];
            int i = (aeglconfig1 = aeglconfig).length;
            for(int j = 0; j < i; j++)
            {
                EGLConfig eglconfig = aeglconfig1[j];
                int k = findConfigAttrib(egl10, egldisplay, eglconfig, 12325, 0);
                int l = findConfigAttrib(egl10, egldisplay, eglconfig, 12326, 0);
                if(k < mDepthSize || l < mStencilSize)
                    continue;
                int i1 = findConfigAttrib(egl10, egldisplay, eglconfig, 12324, 0);
                int j1 = findConfigAttrib(egl10, egldisplay, eglconfig, 12323, 0);
                int k1 = findConfigAttrib(egl10, egldisplay, eglconfig, 12322, 0);
                int l1 = findConfigAttrib(egl10, egldisplay, eglconfig, 12321, 0);
                if(i1 == mRedSize && j1 == mGreenSize && k1 == mBlueSize && l1 == mAlphaSize)
                    return eglconfig;
            }

            return null;
        }

        private int findConfigAttrib(EGL10 egl10, EGLDisplay egldisplay, EGLConfig eglconfig, int i, int j)
        {
            if(egl10.eglGetConfigAttrib(egldisplay, eglconfig, i, mValue))
                return mValue[0];
            else
                return j;
        }

        private int mValue[];
        protected int mRedSize;
        protected int mGreenSize;
        protected int mBlueSize;
        protected int mAlphaSize;
        protected int mDepthSize;
        protected int mStencilSize;

        public ComponentSizeChooser(int i, int j, int k, int l, int i1, int j1)
        {
            super(new int[] {
                12324, i, 12323, j, 12322, k, 12321, l, 12325, i1, 
                12326, j1, 12344
            });
            mValue = new int[1];
            mRedSize = i;
            mGreenSize = j;
            mBlueSize = k;
            mAlphaSize = l;
            mDepthSize = i1;
            mStencilSize = j1;
        }
    }

    private abstract class BaseConfigChooser
        implements android.opengl.GLSurfaceView.EGLConfigChooser
    {

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay egldisplay)
        {
            int ai[] = new int[1];
            if(!egl10.eglChooseConfig(egldisplay, mConfigSpec, null, 0, ai))
            {
                for(int i = 1; i < mConfigSpec.length; i++)
                    if(mConfigSpec[i - 1] == 12352 && mConfigSpec[i] == 64)
                    {
                        Log.w("GvrSurfaceView", "Failed to choose GLES 3 config, will try 2.");
                        mConfigSpec[i] = 4;
                        return chooseConfig(egl10, egldisplay);
                    }

                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int j;
            if((j = ai[0]) <= 0)
                throw new IllegalArgumentException("No configs match configSpec");
            EGLConfig aeglconfig[] = new EGLConfig[j];
            if(!egl10.eglChooseConfig(egldisplay, mConfigSpec, aeglconfig, j, ai))
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            EGLConfig eglconfig;
            if((eglconfig = chooseConfig(egl10, egldisplay, aeglconfig)) == null)
                throw new IllegalArgumentException("No config chosen");
            else
                return eglconfig;
        }

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay egldisplay, EGLConfig aeglconfig[]);

        private int[] filterConfigSpec(int ai[])
        {
            if(mEGLContextClientVersion != 2 && mEGLContextClientVersion != 3)
                return ai;
            int i;
            int ai1[] = new int[(i = ai.length) + 2];
            System.arraycopy(ai, 0, ai1, 0, i - 1);
            ai1[i - 1] = 12352;
            if(mEGLContextClientVersion == 2)
                ai1[i] = 4;
            else
                ai1[i] = 64;
            ai1[i + 1] = 12344;
            return ai1;
        }

        protected int mConfigSpec[];
        final GvrSurfaceView this$0;

        public BaseConfigChooser(int ai[])
        {
            this$0 = GvrSurfaceView.this;
            super();
            mConfigSpec = filterConfigSpec(ai);
        }
    }

    private static class DefaultWindowSurfaceFactory
        implements android.opengl.GLSurfaceView.EGLWindowSurfaceFactory
    {

        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay egldisplay, EGLConfig eglconfig, Object obj)
        {
            EGLSurface eglsurface = null;
            try
            {
                eglsurface = egl10.eglCreateWindowSurface(egldisplay, eglconfig, obj, null);
            }
            catch(IllegalArgumentException illegalargumentexception)
            {
                Log.e("GvrSurfaceView", "eglCreateWindowSurface", illegalargumentexception);
            }
            return eglsurface;
        }

        public void destroySurface(EGL10 egl10, EGLDisplay egldisplay, EGLSurface eglsurface)
        {
            egl10.eglDestroySurface(egldisplay, eglsurface);
        }

        private DefaultWindowSurfaceFactory()
        {
        }

    }

    private class DefaultContextFactory
        implements android.opengl.GLSurfaceView.EGLContextFactory
    {

        public EGLContext createContext(EGL10 egl10, EGLDisplay egldisplay, EGLConfig eglconfig)
        {
            int ai[] = {
                12440, mEGLContextClientVersion, 12344
            };
            return egl10.eglCreateContext(egldisplay, eglconfig, EGL10.EGL_NO_CONTEXT, mEGLContextClientVersion == 0 ? null : ai);
        }

        public void destroyContext(EGL10 egl10, EGLDisplay egldisplay, EGLContext eglcontext)
        {
            if(!egl10.eglDestroyContext(egldisplay, eglcontext))
            {
                String s;
                String s1;
                Log.e("DefaultContextFactory", (new StringBuilder(18 + String.valueOf(s = String.valueOf(egldisplay)).length() + String.valueOf(s1 = String.valueOf(eglcontext)).length())).append("display:").append(s).append(" context: ").append(s1).toString());
                EglHelper.throwEglException("eglDestroyContex", egl10.eglGetError());
            }
        }

        private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
        final GvrSurfaceView this$0;

        private DefaultContextFactory()
        {
            this$0 = GvrSurfaceView.this;
            super();
        }

    }

    public static interface GLWrapper
    {

        public abstract GL wrap(GL gl);
    }


    public GvrSurfaceView(Context context)
    {
        super(context);
        mThisWeakRef = new WeakReference(this);
        init();
    }

    public GvrSurfaceView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mThisWeakRef = new WeakReference(this);
        init();
    }

    protected void finalize()
        throws Throwable
    {
        if(mGLThread != null)
            mGLThread.requestExitAndWait();
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    private void init()
    {
        SurfaceHolder surfaceholder;
        (surfaceholder = getHolder()).addCallback(this);
    }

    public void setGLWrapper(GLWrapper glwrapper)
    {
        mGLWrapper = glwrapper;
    }

    public void setDebugFlags(int i)
    {
        mDebugFlags = i;
    }

    public int getDebugFlags()
    {
        return mDebugFlags;
    }

    public void setPreserveEGLContextOnPause(boolean flag)
    {
        mPreserveEGLContextOnPause = flag;
    }

    public boolean getPreserveEGLContextOnPause()
    {
        return mPreserveEGLContextOnPause;
    }

    public void setRenderer(android.opengl.GLSurfaceView.Renderer renderer)
    {
        checkRenderThreadState();
        if(mEGLConfigChooser == null)
            mEGLConfigChooser = new SimpleEGLConfigChooser(true);
        if(mEGLContextFactory == null)
            mEGLContextFactory = new DefaultContextFactory();
        if(mEGLWindowSurfaceFactory == null)
            mEGLWindowSurfaceFactory = new DefaultWindowSurfaceFactory();
        mRenderer = renderer;
        mGLThread = new GLThread(mThisWeakRef);
        mGLThread.start();
    }

    public void setEglReadyListener(EglReadyListener eglreadylistener)
    {
        mAppContextListener = eglreadylistener;
    }

    public void setEGLContextFactory(android.opengl.GLSurfaceView.EGLContextFactory eglcontextfactory)
    {
        checkRenderThreadState();
        mEGLContextFactory = eglcontextfactory;
    }

    public void setEGLWindowSurfaceFactory(android.opengl.GLSurfaceView.EGLWindowSurfaceFactory eglwindowsurfacefactory)
    {
        checkRenderThreadState();
        mEGLWindowSurfaceFactory = eglwindowsurfacefactory;
    }

    public void setEGLConfigChooser(android.opengl.GLSurfaceView.EGLConfigChooser eglconfigchooser)
    {
        checkRenderThreadState();
        mEGLConfigChooser = eglconfigchooser;
    }

    public void setEGLConfigChooser(boolean flag)
    {
        setEGLConfigChooser(((android.opengl.GLSurfaceView.EGLConfigChooser) (new SimpleEGLConfigChooser(flag))));
    }

    public void setEGLConfigChooser(int i, int j, int k, int l, int i1, int j1)
    {
        setEGLConfigChooser(((android.opengl.GLSurfaceView.EGLConfigChooser) (new ComponentSizeChooser(i, j, k, l, i1, j1))));
    }

    public void setEGLContextClientVersion(int i)
    {
        checkRenderThreadState();
        mEGLContextClientVersion = i;
    }

    public void setRenderMode(int i)
    {
        mGLThread.setRenderMode(i);
    }

    public int getRenderMode()
    {
        return mGLThread.getRenderMode();
    }

    public void requestRender()
    {
        mGLThread.requestRender();
    }

    public void setSwapMode(int i)
    {
        if(i == 1 && android.os.Build.VERSION.SDK_INT < 17)
        {
            Log.e("GvrSurfaceView", "setSwapMode(SWAPMODE_SINGLE) requires Jellybean MR1 (EGL14 dependency)");
            return;
        } else
        {
            mGLThread.setSwapMode(i);
            return;
        }
    }

    public void setPreserveGlThreadOnDetachedFromWindow(boolean flag)
    {
        checkRenderThreadState();
        mPreserveGlThreadOnDetachedFromWindow = flag;
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        mGLThread.surfaceCreated();
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        mGLThread.surfaceDestroyed();
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
    {
        mGLThread.onWindowResize(j, k);
    }

    public void surfaceRedrawNeeded(SurfaceHolder surfaceholder)
    {
        mGLThread.requestRenderAndWait();
    }

    public void onPause()
    {
        mGLThread.onPause();
    }

    public void onResume()
    {
        mGLThread.onResume();
    }

    public void queueEvent(Runnable runnable)
    {
        mGLThread.queueEvent(runnable);
    }

    public void requestExitAndWait()
    {
        mGLThread.requestExitAndWait();
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if(mDetached && mRenderer != null && !mPreserveGlThreadOnDetachedFromWindow)
        {
            int i = 1;
            int j = 0;
            if(mGLThread != null)
            {
                i = mGLThread.getRenderMode();
                j = mGLThread.getSwapMode();
            }
            mGLThread = new GLThread(mThisWeakRef);
            if(i != 1)
                mGLThread.setRenderMode(i);
            if(j != 0)
                mGLThread.setSwapMode(j);
            mGLThread.start();
        }
        mDetached = false;
    }

    protected void onDetachedFromWindow()
    {
        if(mGLThread != null && !mPreserveGlThreadOnDetachedFromWindow)
            requestExitAndWait();
        mDetached = true;
        super.onDetachedFromWindow();
    }

    protected boolean isDetachedFromWindow()
    {
        return mDetached;
    }

    private void checkRenderThreadState()
    {
        if(mGLThread != null)
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        else
            return;
    }

    private static final String TAG = "GvrSurfaceView";
    private static final boolean LOG_ATTACH_DETACH = false;
    private static final boolean LOG_THREADS = false;
    private static final boolean LOG_PAUSE_RESUME = false;
    private static final boolean LOG_SURFACE = false;
    private static final boolean LOG_RENDERER = false;
    private static final boolean LOG_RENDERER_DRAW_FRAME = false;
    private static final boolean LOG_EGL = false;
    public static final int RENDERMODE_WHEN_DIRTY = 0;
    public static final int RENDERMODE_CONTINUOUSLY = 1;
    public static final int SWAPMODE_QUEUED = 0;
    public static final int SWAPMODE_SINGLE = 1;
    public static final int SWAPMODE_MANUAL = 2;
    public static final int DEBUG_CHECK_GL_ERROR = 1;
    public static final int DEBUG_LOG_GL_CALLS = 2;
    private final WeakReference mThisWeakRef;
    private GLThread mGLThread;
    private android.opengl.GLSurfaceView.Renderer mRenderer;
    private boolean mDetached;
    private android.opengl.GLSurfaceView.EGLConfigChooser mEGLConfigChooser;
    private android.opengl.GLSurfaceView.EGLContextFactory mEGLContextFactory;
    private android.opengl.GLSurfaceView.EGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
    private GLWrapper mGLWrapper;
    private int mDebugFlags;
    private int mEGLContextClientVersion;
    private boolean mPreserveEGLContextOnPause;
    private boolean mPreserveGlThreadOnDetachedFromWindow;
    private EglReadyListener mAppContextListener;









}
