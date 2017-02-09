// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BuildUtils.java

package com.google.vr.vrcore.base.api;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;

// Referenced classes of package com.google.vr.vrcore.base.api:
//            SignatureUtils

public class BuildUtils
{

    public BuildUtils()
    {
    }

    public static boolean isDebugBuild(Context context)
    {
        if(isDebug != null)
            return isDebug.booleanValue();
        else
            return computeIsDebugBuild(context);
    }

    public static synchronized void setIsDebugBuild(boolean flag)
    {
        isDebug = Boolean.valueOf(flag);
    }

    private static synchronized boolean computeIsDebugBuild(Context context)
    {
        PackageManager packagemanager;
        if(isDebug == null)
            try
            {
                isDebug = Boolean.valueOf(SignatureUtils.verifySignature((packagemanager = context.getPackageManager()).getPackageInfo(context.getPackageName(), 64), new Signature[] {
                    SignatureUtils.BLAZE_DEBUG_SIGNATURE, SignatureUtils.ANDROID_DEBUG_SIGNATURE, SignatureUtils.VRCORE_DEBUG_SIGNATURE
                }));
            }
            catch(android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
            {
                throw new IllegalStateException("Unable to find self package info", namenotfoundexception);
            }
        return isDebug.booleanValue();
    }

    private static volatile Boolean isDebug;
}
