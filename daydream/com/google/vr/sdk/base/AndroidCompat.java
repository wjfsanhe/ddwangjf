// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AndroidCompat.java

package com.google.vr.sdk.base;

import android.app.Activity;
import com.google.vr.cardboard.AndroidNCompat;

public final class AndroidCompat
{

    public static boolean setVrModeEnabled(Activity activity, boolean enabled)
    {
        return AndroidNCompat.setVrModeEnabled(activity, enabled, 1);
    }

    public static boolean trySetVrModeEnabled(Activity activity, boolean enabled)
    {
        return AndroidNCompat.setVrModeEnabled(activity, enabled, 0);
    }

    public static void setSustainedPerformanceMode(Activity activity, boolean enabled)
    {
        AndroidNCompat.setSustainedPerformanceMode(activity, enabled);
    }

    private AndroidCompat()
    {
    }
}
