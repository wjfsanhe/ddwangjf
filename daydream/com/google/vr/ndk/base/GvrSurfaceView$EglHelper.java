// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GvrSurfaceView.java

package com.google.vr.ndk.base;

import android.opengl.*;
import android.os.Build;
import android.util.Log;
import com.google.vr.cardboard.EglFactory;
import com.google.vr.cardboard.EglReadyListener;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.*;
import javax.microedition.khronos.opengles.GL;

// Referenced classes of package com.google.vr.ndk.base:
//            GvrSurfaceView

private static class mGvrSurfaceViewWeakRef
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
            if(GvrSurfaceView.access$300(gvrsurfaceview) != null)
                if((eglcontext = GvrSurfaceView.access$300(gvrsurfaceview).getEGLContext()) == null || eglcontext == EGL10.EGL_NO_CONTEXT)
                    throwEglException("Unable to obtain application's OpenGL context.");
                else
                    ((EglFactory)GvrSurfaceView.access$400(gvrsurfaceview)).setSharedContext(eglcontext);
            mEglConfig = GvrSurfaceView.access$500(gvrsurfaceview).chooseConfig(mEgl, mEglDisplay);
            mEglContext = GvrSurfaceView.access$400(gvrsurfaceview).createContext(mEgl, mEglDisplay, mEglConfig);
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
            mEglSurface = GvrSurfaceView.access$600(gvrsurfaceview).createWindowSurface(mEgl, mEglDisplay, mEglConfig, gvrsurfaceview.getHolder());
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
            if(GvrSurfaceView.access$700(gvrsurfaceview) != null)
                gl = GvrSurfaceView.access$700(gvrsurfaceview).wrap(gl);
            if((GvrSurfaceView.access$800(gvrsurfaceview) & 3) != 0)
            {
                int i = 0;
                  = null;
                if((GvrSurfaceView.access$800(gvrsurfaceview) & 1) != 0)
                    i = 1;
                if((GvrSurfaceView.access$800(gvrsurfaceview) & 2) != 0)
                     = new <init>();
                gl = GLDebugHelper.wrap(gl, i, );
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
        if(android.os.w.EglHelper < 17)
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
                GvrSurfaceView.access$600(gvrsurfaceview).destroySurface(mEgl, mEglDisplay, mEglSurface);
            mEglSurface = null;
        }
    }

    public void finish()
    {
        if(mEglContext != null)
        {
            GvrSurfaceView gvrsurfaceview;
            if((gvrsurfaceview = (GvrSurfaceView)mGvrSurfaceViewWeakRef.get()) != null)
                GvrSurfaceView.access$400(gvrsurfaceview).destroyContext(mEgl, mEglDisplay, mEglContext);
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

    public tory(WeakReference weakreference)
    {
        mGvrSurfaceViewWeakRef = weakreference;
    }
}
