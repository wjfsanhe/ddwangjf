// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UserPrefs.java

package com.google.vr.ndk.base;


// Referenced classes of package com.google.vr.ndk.base:
//            GvrApi

public class UserPrefs
{
    public static abstract class ControllerHandedness
    {

        public static final int RIGHT_HANDED = 0;
        public static final int LEFT_HANDED = 1;

        public ControllerHandedness()
        {
        }
    }


    UserPrefs(long l)
    {
        nativeUserPrefs = l;
    }

    public int getControllerHandedness()
    {
        return GvrApi.nativeUserPrefsGetControllerHandedness(nativeUserPrefs);
    }

    public boolean getPerformanceMonitoringEnabled()
    {
        return false;
    }

    private static final String TAG = com/google/vr/ndk/base/UserPrefs.getSimpleName();
    private final long nativeUserPrefs;

}
