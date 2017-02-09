// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LegacyVrParamsProvider.java

package com.google.vr.cardboard;

import com.google.vr.vrcore.nano.SdkConfiguration;
import com.google.vrtoolkit.cardboard.proto.nano.*;

// Referenced classes of package com.google.vr.cardboard:
//            ConfigUtils, PhoneParams, VrParamsProvider

public final class LegacyVrParamsProvider
    implements VrParamsProvider
{

    public LegacyVrParamsProvider()
    {
    }

    public final com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams readDeviceParams()
    {
        return ConfigUtils.readDeviceParamsFromExternalStorage();
    }

    public final boolean writeDeviceParams(com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams deviceparams)
    {
        if(deviceparams == null)
            return ConfigUtils.removeDeviceParamsFromExternalStorage();
        else
            return ConfigUtils.writeDeviceParamsToExternalStorage(deviceparams);
    }

    public final com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams readPhoneParams()
    {
        com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams phoneparams;
        if((phoneparams = ConfigUtils.readPhoneParamsFromExternalStorage()) == null)
            phoneparams = com.google.vr.cardboard.PhoneParams.getPpiOverride();
        return phoneparams;
    }

    public final com.google.vrtoolkit.cardboard.proto.nano.Preferences.UserPrefs readUserPrefs()
    {
        return null;
    }

    public final boolean updateUserPrefs(com.google.vrtoolkit.cardboard.proto.nano.Preferences.UserPrefs userprefs)
    {
        return false;
    }

    public final com.google.common.logging.nano.Vr.VREvent.SdkConfigurationParams readSdkConfigurationParams(com.google.vr.vrcore.nano.SdkConfiguration.SdkConfigurationRequest sdkconfigurationrequest)
    {
        return null;
    }

    public final void close()
    {
    }

    private static final String TAG = com/google/vr/cardboard/LegacyVrParamsProvider.getSimpleName();

}
