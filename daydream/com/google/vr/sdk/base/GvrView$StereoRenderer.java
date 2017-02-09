// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GvrView.java

package com.google.vr.sdk.base;

import javax.microedition.khronos.egl.EGLConfig;

// Referenced classes of package com.google.vr.sdk.base:
//            GvrView, HeadTransform, Eye, Viewport

public static interface 
{

    public abstract void onNewFrame(HeadTransform headtransform);

    public abstract void onDrawEye(Eye eye);

    public abstract void onFinishFrame(Viewport viewport);

    public abstract void onSurfaceChanged(int i, int j);

    public abstract void onSurfaceCreated(EGLConfig eglconfig);

    public abstract void onRendererShutdown();
}
