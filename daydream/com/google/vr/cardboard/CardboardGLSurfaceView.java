// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CardboardGLSurfaceView.java

package com.google.vr.cardboard;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import com.google.vr.ndk.base.GvrSurfaceView;
import java.util.ArrayList;

// Referenced classes of package com.google.vr.cardboard:
//            EglFactory

public class CardboardGLSurfaceView extends GvrSurfaceView
{
    public static interface DetachListener
    {

        public abstract void onSurfaceViewDetachedFromWindow();
    }


    public CardboardGLSurfaceView(Context context, DetachListener detachlistener)
    {
        super(context);
        listener = detachlistener;
        eglFactory = new EglFactory();
        setEGLContextFactory(eglFactory);
        setEGLWindowSurfaceFactory(eglFactory);
    }

    public CardboardGLSurfaceView(Context context, AttributeSet attributeset, DetachListener detachlistener)
    {
        super(context, attributeset);
        listener = detachlistener;
        eglFactory = new EglFactory();
        setEGLContextFactory(eglFactory);
        setEGLWindowSurfaceFactory(eglFactory);
    }

    public void onPause()
    {
        if(isRendererSet)
            super.onPause();
    }

    public void onResume()
    {
        if(isRendererSet)
            super.onResume();
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        isDetached = false;
        if(eventQueueWhileDetached != null)
        {
            ArrayList arraylist;
            int i = (arraylist = (ArrayList)eventQueueWhileDetached).size();
            int j = 0;
            Object obj = null;
            while(j < i) 
            {
                j++;
                Runnable runnable = (Runnable)arraylist.get(j);
                super.queueEvent(runnable);
            }
            eventQueueWhileDetached.clear();
        }
    }

    protected void onDetachedFromWindow()
    {
        if(isRendererSet && listener != null)
            listener.onSurfaceViewDetachedFromWindow();
        super.onDetachedFromWindow();
        isDetached = true;
    }

    public void setRenderer(android.opengl.GLSurfaceView.Renderer renderer)
    {
        super.setRenderer(renderer);
        isRendererSet = true;
    }

    public void setEGLContextClientVersion(int i)
    {
        super.setEGLContextClientVersion(i);
        eglFactory.setEGLContextClientVersion(i);
    }

    public void queueEvent(Runnable runnable)
    {
        if(!isRendererSet)
        {
            runnable.run();
            return;
        }
        if(isDetached)
        {
            if(eventQueueWhileDetached == null)
                eventQueueWhileDetached = new ArrayList();
            eventQueueWhileDetached.add(runnable);
            return;
        } else
        {
            super.queueEvent(runnable);
            return;
        }
    }

    public boolean isDetached()
    {
        return isDetached;
    }

    private static final String TAG = com/google/vr/cardboard/CardboardGLSurfaceView.getSimpleName();
    private final DetachListener listener;
    private boolean isRendererSet;
    private boolean isDetached;
    private ArrayList eventQueueWhileDetached;
    private final EglFactory eglFactory;

}
