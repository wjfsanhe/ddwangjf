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

private class this._cls0
    implements android.opengl.Factory
{

    public EGLContext createContext(EGL10 egl10, EGLDisplay egldisplay, EGLConfig eglconfig)
    {
        int ai[] = {
            12440, GvrSurfaceView.access$200(GvrSurfaceView.this), 12344
        };
        return egl10.eglCreateContext(egldisplay, eglconfig, EGL10.EGL_NO_CONTEXT, GvrSurfaceView.access$200(GvrSurfaceView.this) == 0 ? null : ai);
    }

    public void destroyContext(EGL10 egl10, EGLDisplay egldisplay, EGLContext eglcontext)
    {
        if(!egl10.eglDestroyContext(egldisplay, eglcontext))
        {
            String s;
            String s1;
            Log.e("DefaultContextFactory", (new StringBuilder(18 + String.valueOf(s = String.valueOf(egldisplay)).length() + String.valueOf(s1 = String.valueOf(eglcontext)).length())).append("display:").append(s).append(" context: ").append(s1).toString());
            ption("eglDestroyContex", egl10.eglGetError());
        }
    }

    private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
    final GvrSurfaceView this$0;

    private A()
    {
        this$0 = GvrSurfaceView.this;
        super();
    }

}
