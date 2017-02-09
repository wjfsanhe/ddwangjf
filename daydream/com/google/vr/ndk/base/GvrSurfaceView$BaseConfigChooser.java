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

private abstract class filterConfigSpec
    implements android.opengl.Chooser
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
        if(GvrSurfaceView.access$200(GvrSurfaceView.this) != 2 && GvrSurfaceView.access$200(GvrSurfaceView.this) != 3)
            return ai;
        int i;
        int ai1[] = new int[(i = ai.length) + 2];
        System.arraycopy(ai, 0, ai1, 0, i - 1);
        ai1[i - 1] = 12352;
        if(GvrSurfaceView.access$200(GvrSurfaceView.this) == 2)
            ai1[i] = 4;
        else
            ai1[i] = 64;
        ai1[i + 1] = 12344;
        return ai1;
    }

    protected int mConfigSpec[];
    final GvrSurfaceView this$0;

    public (int ai[])
    {
        this$0 = GvrSurfaceView.this;
        super();
        mConfigSpec = filterConfigSpec(ai);
    }
}
