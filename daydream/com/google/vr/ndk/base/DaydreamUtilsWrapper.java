// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DaydreamUtilsWrapper.java

package com.google.vr.ndk.base;

import android.app.Activity;
import android.content.Context;
import com.google.vr.cardboard.ContextUtils;
import com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice;

// Referenced classes of package com.google.vr.ndk.base:
//            DaydreamUtils

public class DaydreamUtilsWrapper
{

    public DaydreamUtilsWrapper()
    {
    }

    public boolean isDaydreamActivity(Activity activity)
    {
        return isDaydreamComponent(activity);
    }

    public boolean isDaydreamComponent(Context context)
    {
        return getComponentDaydreamCompatibility(context) != 0;
    }

    public boolean isDaydreamRequiredActivity(Activity activity)
    {
        return isDaydreamRequiredComponent(activity);
    }

    public boolean isDaydreamRequiredComponent(Context context)
    {
        return getComponentDaydreamCompatibility(context) == 2;
    }

    public int getActivityDaydreamCompatibility(Activity activity)
    {
        return DaydreamUtils.getComponentDaydreamCompatibility(activity, activity.getComponentName());
    }

    public int getComponentDaydreamCompatibility(Context context)
    {
        android.content.ComponentName componentname;
        if((componentname = ContextUtils.getComponentName(context)) != null)
            return DaydreamUtils.getComponentDaydreamCompatibility(context, componentname);
        else
            return 0;
    }

    public boolean isDaydreamPhone(Context context)
    {
        return DaydreamUtils.isDaydreamPhone(context);
    }

    public boolean isDaydreamViewer(com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams deviceparams)
    {
        return DaydreamUtils.isDaydreamViewer(deviceparams);
    }
}
