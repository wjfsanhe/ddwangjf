// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AndroidCompat.java

package com.google.vr.ndk.base;

import android.app.Activity;
import com.google.vr.cardboard.AndroidNCompat;

public final class AndroidCompat
{

    public static boolean setVrModeEnabled(Activity activity, boolean flag)
    {
        return AndroidNCompat.setVrModeEnabled(activity, flag);
    }

    public static void setSustainedPerformanceMode(Activity activity, boolean flag)
    {
        AndroidNCompat.setSustainedPerformanceMode(activity, flag);
    }

    private AndroidCompat()
    {
    }
}
