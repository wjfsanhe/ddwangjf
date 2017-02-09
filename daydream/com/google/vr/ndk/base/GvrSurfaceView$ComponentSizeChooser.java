// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GvrSurfaceView.java

package com.google.vr.ndk.base;

import javax.microedition.khronos.egl.*;

// Referenced classes of package com.google.vr.ndk.base:
//            GvrSurfaceView

private class mStencilSize extends mStencilSize
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

    public (GvrSurfaceView gvrsurfaceview, int i, int j, int k, int l, int i1, int j1)
    {
        super(gvrsurfaceview, new int[] {
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
