// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrParamsProvider.java

package com.google.vr.cardboard;

import com.google.vr.vrcore.nano.SdkConfiguration;
import com.google.vrtoolkit.cardboard.proto.nano.*;

public interface VrParamsProvider
{

    public abstract com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams readDeviceParams();

    public abstract boolean writeDeviceParams(com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams deviceparams);

    public abstract com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams readPhoneParams();

    public abstract com.google.common.logging.nano.Vr.VREvent.SdkConfigurationParams readSdkConfigurationParams(com.google.vr.vrcore.nano.SdkConfiguration.SdkConfigurationRequest sdkconfigurationrequest);

    public abstract com.google.vrtoolkit.cardboard.proto.nano.Preferences.UserPrefs readUserPrefs();

    public abstract boolean updateUserPrefs(com.google.vrtoolkit.cardboard.proto.nano.Preferences.UserPrefs userprefs);

    public abstract void close();
}
