// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GvrLayout.java

package com.google.vr.ndk.base;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.SurfaceHolder;
import com.google.vr.cardboard.ScanlineRacingRenderer;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.google.vr.ndk.base:
//            GvrSurfaceView, GvrLayout

private static class _cls1.val.destroySurfaceLatch extends GvrSurfaceView
{

    public void setRenderer(ScanlineRacingRenderer scanlineracingrenderer)
    {
        scanlineRacingRenderer = scanlineracingrenderer;
        super.setRenderer(scanlineracingrenderer);
    }
