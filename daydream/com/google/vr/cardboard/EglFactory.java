// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   EglFactory.java

package com.google.vr.cardboard;

import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.Log;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.*;

public class EglFactory
    implements android.opengl.GLSurfaceView.EGLContextFactory, android.opengl.GLSurfaceView.EGLWindowSurfaceFactory
{

    public EglFactory()
    {
        usePriority = false;
        useProtected = false;
        eglContextClientVersion = 2;
        sharedContext = EGL10.EGL_NO_CONTEXT;
    }

    public void setUsePriorityContext(boolean flag)
    {
        usePriority = flag;
    }

    public void setUseProtectedBuffers(boolean flag)
    {
        if(flag && android.os.Build.VERSION.SDK_INT < 17)
        {
            throw new RuntimeException("Protected buffer support requires EGL 1.4, available only on Jelly Bean MR1 and later.");
        } else
        {
            useProtected = flag;
            return;
        }
    }

    public void setSharedContext(EGLContext eglcontext)
    {
        sharedContext = eglcontext;
    }

    public EGLContext createContext(EGL10 egl10, EGLDisplay egldisplay, EGLConfig eglconfig)
    {
        IntBuffer intbuffer;
        (intbuffer = IntBuffer.allocate(8)).put(12440);
        intbuffer.put(eglContextClientVersion);
        if(usePriority)
        {
            intbuffer.put(12544);
            intbuffer.put(12545);
        }
        if(useProtected && supportsProtectedContent(egl10, egldisplay))
        {
            intbuffer.put(12992);
            intbuffer.put(1);
        }
        for(; intbuffer.hasRemaining(); intbuffer.put(12344));
        EGLContext eglcontext;
        if(((eglcontext = egl10.eglCreateContext(egldisplay, eglconfig, sharedContext, intbuffer.array())) == null || eglcontext == EGL10.EGL_NO_CONTEXT) && eglContextClientVersion > 2)
        {
            int i;
            Log.w("GvrEglFactory", (new StringBuilder(75)).append("Failed to create EGL context with version ").append(i = eglContextClientVersion).append(", will try 2").toString());
            intbuffer.array()[1] = 2;
            eglcontext = egl10.eglCreateContext(egldisplay, eglconfig, sharedContext, intbuffer.array());
        }
        return eglcontext;
    }

    public void destroyContext(EGL10 egl10, EGLDisplay egldisplay, EGLContext eglcontext)
    {
        egl10.eglDestroyContext(egldisplay, eglcontext);
    }

    public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay egldisplay, EGLConfig eglconfig, Object obj)
    {
        EGLSurface eglsurface = null;
        int ai[] = null;
        if(useProtected && supportsProtectedContent(egl10, egldisplay))
            ai = (new int[] {
                12992, 1, 12344
            });
        try
        {
            eglsurface = egl10.eglCreateWindowSurface(egldisplay, eglconfig, obj, ai);
        }
        catch(IllegalArgumentException illegalargumentexception)
        {
            Log.e("GvrEglFactory", "eglCreateWindowSurface", illegalargumentexception);
        }
        return eglsurface;
    }

    public void destroySurface(EGL10 egl10, EGLDisplay egldisplay, EGLSurface eglsurface)
    {
        egl10.eglDestroySurface(egldisplay, eglsurface);
    }

    public void setEGLContextClientVersion(int i)
    {
        eglContextClientVersion = i;
    }

    private boolean supportsProtectedContent(EGL10 egl10, EGLDisplay egldisplay)
    {
        String s;
        return (s = egl10.eglQueryString(egldisplay, 12373)).contains("EGL_EXT_protected_content");
    }

    private static final String TAG = "GvrEglFactory";
    private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
    private static final int EGL_CONTEXT_PRIORITY_LEVEL = 12544;
    private static final int EGL_CONTEXT_PRIORITY_HIGH = 12545;
    private static final int EGL_PROTECTED_CONTENT_EXT = 12992;
    private static final int MIN_REQUIRED_CONTEXT_CLIENT_VERSION = 2;
    private boolean usePriority;
    private boolean useProtected;
    private int eglContextClientVersion;
    private EGLContext sharedContext;
}
