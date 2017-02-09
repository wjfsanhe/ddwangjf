// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PackageUtils.java

package com.google.vr.cardboard;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

public class PackageUtils
{

    public PackageUtils()
    {
    }

    public static boolean isGooglePackage(String s)
    {
        return s != null && s.startsWith("com.google.");
    }

    public static boolean isSystemPackage(Context context, String s)
    {
        ApplicationInfo applicationinfo;
        int i;
        return ((i = (applicationinfo = context.getPackageManager().getApplicationInfo(s, 0)) == null ? 0 : applicationinfo.flags) & 1) != 0 || (i & 0x80) != 0;
        JVM INSTR pop ;
        return false;
    }

    private static final String GOOGLE_PACKAGE_PREFIX = "com.google.";
}
