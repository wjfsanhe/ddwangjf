// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MutableEglConfigChooser.java

package com.google.vr.cardboard;

import android.opengl.GLSurfaceView;
import javax.microedition.khronos.egl.*;

public class MutableEglConfigChooser
    implements android.opengl.GLSurfaceView.EGLConfigChooser
{

    public MutableEglConfigChooser()
    {
        forceMutableBuffer = true;
    }

    public MutableEglConfigChooser(boolean flag)
    {
        forceMutableBuffer = true;
        forceMutableBuffer = flag;
    }

    public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay egldisplay)
    {
        int ai[] = {
            12324, 8, 12323, 8, 12322, 8, 12321, 0, 12325, 0, 
            12326, 0, 12352, 64, 12339, 4100, 12344
        };
        int ai1[] = new int[1];
        if(!egl10.eglChooseConfig(egldisplay, ai, null, 0, ai1) && forceMutableBuffer)
            throw new IllegalArgumentException("eglChooseConfig failed");
        ai[15] = 4;
        if(!egl10.eglChooseConfig(egldisplay, ai, null, 0, ai1))
            throw new IllegalArgumentException("eglChooseConfig failed");
        int i;
        if((i = ai1[0]) <= 0)
            throw new IllegalArgumentException("No configs match configSpec");
        EGLConfig aeglconfig[] = new EGLConfig[i];
        if(!egl10.eglChooseConfig(egldisplay, ai, aeglconfig, i, ai1))
            throw new IllegalArgumentException("eglChooseConfig#2 failed");
        EGLConfig eglconfig;
        if((eglconfig = chooseConfig(egl10, egldisplay, aeglconfig, forceMutableBuffer)) == null)
            throw new IllegalArgumentException("No config chosen");
        else
            return eglconfig;
    }

    private static EGLConfig chooseConfig(EGL10 egl10, EGLDisplay egldisplay, EGLConfig aeglconfig[], boolean flag)
    {
        EGLConfig aeglconfig1[];
        int i = (aeglconfig1 = aeglconfig).length;
        for(int j = 0; j < i; j++)
        {
            EGLConfig eglconfig = aeglconfig1[j];
            int k = findConfigAttrib(egl10, egldisplay, eglconfig, 12325, 0);
            int l = findConfigAttrib(egl10, egldisplay, eglconfig, 12326, 0);
            int i1 = findConfigAttrib(egl10, egldisplay, eglconfig, 12324, 0);
            int j1 = findConfigAttrib(egl10, egldisplay, eglconfig, 12323, 0);
            int k1 = findConfigAttrib(egl10, egldisplay, eglconfig, 12322, 0);
            int l1 = findConfigAttrib(egl10, egldisplay, eglconfig, 12339, 0);
            if(i1 == 8 && j1 == 8 && k1 == 8 && k == 0 && l == 0 && (!flag || (l1 & 0x1000) != 0))
                return eglconfig;
        }

        return null;
    }

    private static int findConfigAttrib(EGL10 egl10, EGLDisplay egldisplay, EGLConfig eglconfig, int i, int j)
    {
        int ai[] = new int[1];
        if(egl10.eglGetConfigAttrib(egldisplay, eglconfig, i, ai))
            return ai[0];
        else
            return j;
    }

    private static final int EGL_MUTABLE_RENDER_BUFFER_BIT = 4096;
    private static final int EGL_OPENGL_ES3_BIT_KHR = 64;
    private boolean forceMutableBuffer;
}
