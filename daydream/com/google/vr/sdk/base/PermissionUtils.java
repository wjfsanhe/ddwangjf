// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PermissionUtils.java

package com.google.vr.sdk.base;

import android.Manifest;
import android.content.Context;
import android.os.Process;

public class PermissionUtils
{

    public PermissionUtils()
    {
    }

    public static boolean hasPermission(Context context, String permission)
    {
        if(context == null || permission == null)
            return false;
        else
            return context.checkPermission(permission, Process.myPid(), Process.myUid()) == 0;
    }

    public static boolean hasStoragePermission(Context context)
    {
        return hasPermission(context, "android.permission.READ_EXTERNAL_STORAGE") && hasPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    public static boolean hasCameraPermission(Context context)
    {
        return hasPermission(context, "android.permission.CAMERA");
    }
}
