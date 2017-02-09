// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrSettingsProviderContract.java

package com.google.vr.cardboard;

import android.net.Uri;

public class VrSettingsProviderContract
{

    public VrSettingsProviderContract()
    {
    }

    public static Uri createUri(String s, String s1)
    {
        String s2 = String.valueOf("content://");
        return Uri.parse((new StringBuilder(1 + String.valueOf(s2).length() + String.valueOf(s).length() + String.valueOf(s1).length())).append(s2).append(s).append("/").append(s1).toString());
    }

    public static final String VRCORE_AUTHORITY = "com.google.vr.vrcore.settings";
    public static final String PROVIDER_INTENT_ACTION = "android.content.action.VR_SETTINGS_PROVIDER";
    public static final String DEVICE_PARAMS_SETTING = "device_params";
    public static final String PHONE_PARAMS_SETTING = "phone_params";
    public static final String DAYDREAM_SETUP_COMPLETED = "daydream_setup";
    public static final String SDK_CONFIGURATION_PARAMS_SETTING = "sdk_configuration_params";
    public static final String USER_PREFS_SETTING = "user_prefs";
    public static final String SETTING_VALUE_KEY = "value";
}
