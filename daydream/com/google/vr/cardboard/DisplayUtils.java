// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DisplayUtils.java

package com.google.vr.cardboard;

import android.content.Context;
import android.content.res.Resources;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.vrtoolkit.cardboard.proto.nano.Phone;

public class DisplayUtils
{

    public DisplayUtils()
    {
    }

    public static Display getDefaultDisplay(Context context)
    {
        WindowManager windowmanager;
        return (windowmanager = (WindowManager)context.getSystemService("window")).getDefaultDisplay();
    }

    public static DisplayMetrics getDisplayMetricsLandscape(Display display)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        if(android.os.Build.VERSION.SDK_INT >= 17)
            display.getRealMetrics(displaymetrics);
        else
            display.getMetrics(displaymetrics);
        if(displaymetrics.widthPixels < displaymetrics.heightPixels)
        {
            int i = displaymetrics.widthPixels;
            displaymetrics.widthPixels = displaymetrics.heightPixels;
            displaymetrics.heightPixels = i;
        }
        float f = displaymetrics.xdpi;
        displaymetrics.xdpi = displaymetrics.ydpi;
        displaymetrics.ydpi = f;
        return displaymetrics;
    }

    public static DisplayMetrics getDisplayMetricsLandscapeWithOverride(Display display, com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams phoneparams)
    {
        DisplayMetrics displaymetrics = getDisplayMetricsLandscape(display);
        if(phoneparams != null)
        {
            if(phoneparams.hasXPpi())
                displaymetrics.xdpi = phoneparams.getXPpi();
            if(phoneparams.hasYPpi())
                displaymetrics.ydpi = phoneparams.getYPpi();
        }
        return displaymetrics;
    }

    public static float getBorderSizeMeters(com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams phoneparams)
    {
        if(phoneparams != null && phoneparams.hasBottomBezelHeight())
            return phoneparams.getBottomBezelHeight();
        else
            return 0.003F;
    }

    public static float getMetersPerPixelFromDotsPerInch(float f)
    {
        return 0.0254F / f;
    }

    public static String getExternalDisplayName(Context context)
    {
        Resources resources;
        int i = (resources = context.getResources()).getIdentifier("display_manager_hdmi_display_name", "string", "android");
        return resources.getString(i);
        JVM INSTR pop ;
        return null;
    }

    public static boolean hasExternalDisplay(Context context)
    {
        if(android.os.Build.VERSION.SDK_INT <= 16)
            return false;
        String s;
        if((s = getExternalDisplayName(context)) == null)
            return false;
        DisplayManager displaymanager;
        Display adisplay[];
        int i = (adisplay = (displaymanager = (DisplayManager)context.getSystemService("display")).getDisplays()).length;
        for(int j = 0; j < i; j++)
        {
            Display display;
            if((display = adisplay[j]).getName().equals(s))
                return true;
        }

        return false;
    }

    public static boolean isSameDisplay(Display display, Display display1)
    {
        if(display == display1)
            return true;
        if(display == null || display1 == null)
            return false;
        if(display.getDisplayId() != display1.getDisplayId() || display.getFlags() != display1.getFlags() || display.isValid() != display1.isValid() || !display.getName().equals(display1.getName()))
        {
            return false;
        } else
        {
            DisplayMetrics displaymetrics = new DisplayMetrics();
            DisplayMetrics displaymetrics1 = new DisplayMetrics();
            display.getMetrics(displaymetrics);
            display1.getMetrics(displaymetrics1);
            return displaymetrics.equals(displaymetrics1);
        }
    }

    public static final String EXTERNAL_DISPLAY_RESOURCE_NAME = "display_manager_hdmi_display_name";
    private static final float METERS_PER_INCH = 0.0254F;
    private static final float DEFAULT_BORDER_SIZE_METERS = 0.003F;
}
