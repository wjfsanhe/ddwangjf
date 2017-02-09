// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DaydreamUtils.java

package com.google.vr.ndk.base;

import android.content.*;
import android.content.pm.*;
import android.util.Log;
import com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice;
import java.util.Iterator;
import java.util.List;

public class DaydreamUtils
{

    public static boolean isDaydreamPhone(Context var0)
    {
        Log.e("wangjf", "call isDaydreamPhone ");
        return true;
    }

    public static boolean isDaydreamViewer(com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams var0)
    {
        return var0 != null && var0.daydreamInternal != null;
    }

    public static int getComponentDaydreamCompatibility(Context var0, ComponentName var1)
    {
        return getComponentDaydreamCompatibility(var0, var0.getPackageManager(), var1);
    }

    static void setIsDaydreamPhoneForTesting(boolean var0)
    {
        sDaydreamPhoneOverrideForTesting = var0;
    }

    static int getComponentDaydreamCompatibility(Context var0, PackageManager var1, ComponentName var2)
    {
        Intent var3;
        (var3 = new Intent()).setPackage(var2.getPackageName());
        var3.addCategory("com.google.intent.category.DAYDREAM");
        if(!canResolveIntent(var1, var2, var3))
        {
            return 0;
        } else
        {
            Intent var4;
            (var4 = new Intent()).setPackage(var2.getPackageName());
            var4.addCategory("com.google.intent.category.CARDBOARD");
            return canResolveIntent(var1, var2, var4) ? 1 : 2;
        }
    }

    private static boolean canResolveIntent(PackageManager var0, ComponentName var1, Intent var2)
    {
label0:
        {
            List var3;
            if((var3 = var0.queryIntentActivities(var2, 128)) == null)
                break label0;
            Iterator var4 = var3.iterator();
            ResolveInfo var5;
            do
                if(!var4.hasNext())
                    break label0;
            while((var5 = (ResolveInfo)var4.next()) == null || var5.activityInfo == null || var5.activityInfo.name == null || !var5.activityInfo.name.equals(var1.getClassName()));
            return true;
        }
        return false;
    }

    protected DaydreamUtils()
    {
    }

    private static final String TAG = "wangjf";
    static final String INTENT_CATEGORY_DAYDREAM = "com.google.intent.category.DAYDREAM";
    static final String INTENT_CATEGORY_CARDBOARD = "com.google.intent.category.CARDBOARD";
    public static final int DAYDREAM_NOT_SUPPORTED = 0;
    public static final int DAYDREAM_OPTIONAL = 1;
    public static final int DAYDREAM_REQUIRED = 2;
    private static boolean sDaydreamPhoneOverrideForTesting;
}
