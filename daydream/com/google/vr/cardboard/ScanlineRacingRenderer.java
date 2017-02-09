// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ScanlineRacingRenderer.java

package com.google.vr.cardboard;

import android.graphics.Point;
import android.opengl.GLSurfaceView;
import android.os.Process;
import android.view.SurfaceHolder;
import com.google.vr.ndk.base.*;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

// Referenced classes of package com.google.vr.cardboard:
//            AndroidNCompat, ExternalSurfaceManager, ThreadUtils

public class ScanlineRacingRenderer
    implements android.opengl.GLSurfaceView.Renderer
{

    public ScanlineRacingRenderer(GvrApi gvrapi)
    {
        if(gvrapi == null)
        {
            throw new IllegalArgumentException("GvrApi must be supplied for proper scanline rendering");
        } else
        {
            gvrApi = gvrapi;
            surfaceManager = new ExternalSurfaceManager(gvrapi);
            return;
        }
    }

    public com.google.vr.ndk.base.GvrLayout.ExternalSurfaceManager getExternalSurfaceManager()
    {
        return surfaceManager;
    }

    public void setSurfaceView(GvrSurfaceView gvrsurfaceview)
    {
        if(gvrsurfaceview == null)
        {
            throw new IllegalArgumentException("GvrSurfaceView must be supplied for proper scanline rendering");
        } else
        {
            gvrSurfaceView = gvrsurfaceview;
            return;
        }
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eglconfig)
    {
        Thread.currentThread().setPriority(10);
        AndroidNCompat.setVrThread(Process.myTid());
        gvrApi.onSurfaceCreatedReprojectionThread();
    }

    public void onSurfaceChanged(GL10 gl10, int i, int j)
    {
        surfaceManager.consumerAttachToCurrentGLContext();
    }

    public void onDrawFrame(GL10 gl10)
    {
        surfaceManager.consumerUpdateManagedSurfaces();
        Point point;
        if((point = gvrApi.renderReprojectionThread()) != null)
            setSurfaceSize(point.x, point.y);
    }

    public void onDestroySurface()
    {
        onPause();
    }

    public void setSurfaceSize(final int surfaceWidthPixels, final int surfaceHeightPixels)
    {
        ThreadUtils.runOnUiThread(new Runnable() {

            public void run()
            {
                if(surfaceWidthPixels > 0 && surfaceHeightPixels > 0)
                {
                    gvrSurfaceView.getHolder().setFixedSize(surfaceWidthPixels, surfaceHeightPixels);
                    return;
                } else
                {
                    gvrSurfaceView.getHolder().setSizeFromLayout();
                    return;
                }
            }

            final int val$surfaceWidthPixels;
            final int val$surfaceHeightPixels;
            final ScanlineRacingRenderer this$0;

            
            {
                this$0 = ScanlineRacingRenderer.this;
                surfaceWidthPixels = i;
                surfaceHeightPixels = j;
                super();
            }
        });
    }

    public void onPause()
    {
        gvrApi.onPauseReprojectionThread();
        surfaceManager.consumerDetachFromCurrentGLContext();
    }

    public void shutdown()
    {
        surfaceManager.shutdown();
    }

    private static final String TAG = "ScanlineRacingRenderer";
    private final GvrApi gvrApi;
    private final ExternalSurfaceManager surfaceManager;
    private GvrSurfaceView gvrSurfaceView;

}
