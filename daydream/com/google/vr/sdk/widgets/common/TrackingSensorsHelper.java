// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TrackingSensorsHelper.java

package com.google.vr.sdk.widgets.common;

import android.content.pm.PackageManager;

public class TrackingSensorsHelper
{

    public TrackingSensorsHelper(PackageManager packageManager)
    {
        this.packageManager = packageManager;
    }

    public boolean areTrackingSensorsAvailable()
    {
        if(pretendSensorsAreAvailableForTesting)
            return true;
        if(enableTouchTracking)
            return false;
        else
            return packageManager.hasSystemFeature("android.hardware.sensor.gyroscope") && packageManager.hasSystemFeature("android.hardware.sensor.accelerometer");
    }

    public boolean showStereoModeButtonForTesting()
    {
        return showStereoModeButtonForTesting;
    }

    public static boolean pretendSensorsAreAvailableForTesting = false;
    public static boolean enableTouchTracking = false;
    public static boolean showStereoModeButtonForTesting = false;
    PackageManager packageManager;

}
