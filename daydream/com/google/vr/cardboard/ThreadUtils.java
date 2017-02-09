// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ThreadUtils.java

package com.google.vr.cardboard;

import android.os.Handler;
import android.os.Looper;

public class ThreadUtils
{

    public ThreadUtils()
    {
    }

    public static void runOnUiThread(Runnable runnable)
    {
        if(runningOnUiThread())
        {
            runnable.run();
            return;
        } else
        {
            uiHandler.post(runnable);
            return;
        }
    }

    public static void postOnUiThread(Runnable runnable)
    {
        uiHandler.post(runnable);
    }

    public static boolean runningOnUiThread()
    {
        return uiHandler.getLooper() == Looper.myLooper();
    }

    public static void assertOnUiThread()
    {
    }

    public static void throwIfNotOnUiThread()
    {
        if(!runningOnUiThread())
            throw new IllegalStateException("Call was not made on the UI thread.");
        else
            return;
    }

    public static Handler getUiThreadHandler()
    {
        return uiHandler;
    }

    private static final Handler uiHandler = new Handler(Looper.getMainLooper());
    static final boolean $assertionsDisabled;

}
