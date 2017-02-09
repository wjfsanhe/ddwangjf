// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GvrSurfaceView.java

package com.google.vr.ndk.base;

import android.opengl.GLSurfaceView;
import android.util.Log;
import javax.microedition.khronos.egl.*;

// Referenced classes of package com.google.vr.ndk.base:
//            GvrSurfaceView

private static class 
    implements android.opengl.Factory
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

    private ()
    {
    }

}
