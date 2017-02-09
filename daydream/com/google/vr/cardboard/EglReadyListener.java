// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   EglReadyListener.java

package com.google.vr.cardboard;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;

public class EglReadyListener
{

    public EglReadyListener()
    {
    }

    public void onEglReady()
    {
        eglContext = ((EGL10)EGLContext.getEGL()).eglGetCurrentContext();
        if(monitor != null)
        {
            synchronized(monitor)
            {
                monitor.notifyAll();
            }
            return;
        } else
        {
            return;
        }
    }

    public EGLContext getEGLContext()
    {
        return eglContext;
    }

    public void setMonitor(Object obj)
    {
        if(monitor != null)
        {
            throw new RuntimeException("EglReadyListener must be configured only once.");
        } else
        {
            monitor = obj;
            return;
        }
    }

    private volatile EGLContext eglContext;
    private volatile Object monitor;
}
