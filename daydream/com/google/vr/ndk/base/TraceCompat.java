// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TraceCompat.java

package com.google.vr.ndk.base;

import android.os.Build;
import android.os.Trace;

class TraceCompat
{

    TraceCompat()
    {
    }

    static void beginSection(String s)
    {
        if(android.os.Build.VERSION.SDK_INT >= 18)
            Trace.beginSection(s);
    }

    static void endSection()
    {
        if(android.os.Build.VERSION.SDK_INT >= 18)
            Trace.endSection();
    }
}
