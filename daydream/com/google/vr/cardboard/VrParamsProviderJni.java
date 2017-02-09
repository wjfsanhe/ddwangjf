// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrParamsProviderJni.java

package com.google.vr.cardboard;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.vr.ndk.base.SdkConfigurationReader;
import com.google.vrtoolkit.cardboard.proto.nano.*;

// Referenced classes of package com.google.vr.cardboard:
//            DisplayUtils, VrParamsProvider, VrParamsProviderFactory

public class VrParamsProviderJni
{

    public VrParamsProviderJni()
    {
    }

    public static void setDisplayOverride(Display display)
    {
        displayMetricsOverride = display == null ? null : DisplayUtils.getDisplayMetricsLandscape(display);
    }

    private static byte[] readDeviceParams(Context context)
    {
        VrParamsProvider vrparamsprovider;
        com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams deviceparams = (vrparamsprovider = VrParamsProviderFactory.create(context)).readDeviceParams();
        vrparamsprovider.close();
        if(deviceparams == null)
            return null;
        else
            return MessageNano.toByteArray(deviceparams);
    }

    private static byte[] readSdkConfigurationParams(Context context)
    {
        return MessageNano.toByteArray(SdkConfigurationReader.getParams(context));
    }

    private static boolean writeDeviceParams(Context context, byte abyte0[])
    {
        VrParamsProvider vrparamsprovider = VrParamsProviderFactory.create(context);
        boolean flag;
        com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams deviceparams = abyte0 == null ? null : (com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams)MessageNano.mergeFrom(new com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams(), abyte0);
        flag = vrparamsprovider.writeDeviceParams(deviceparams);
        vrparamsprovider.close();
        return flag;
        InvalidProtocolBufferNanoException invalidprotocolbuffernanoexception;
        invalidprotocolbuffernanoexception;
        String s;
        Log.w("VrParamsProviderJni", (new StringBuilder(31 + String.valueOf(s = String.valueOf(invalidprotocolbuffernanoexception)).length())).append("Error parsing protocol buffer: ").append(s).toString());
        vrparamsprovider.close();
        return false;
        Exception exception;
        exception;
        vrparamsprovider.close();
        throw exception;
    }

    private static void readPhoneParams(Context context, long l)
    {
        if(context == null)
        {
            Log.w("VrParamsProviderJni", "Missing context for phone params lookup. Results may be invalid.");
            updateNativePhoneParamsPointer(l, Resources.getSystem().getDisplayMetrics());
            return;
        }
        DisplayMetrics displaymetrics = getDisplayMetrics(context);
        VrParamsProvider vrparamsprovider;
        com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams phoneparams = (vrparamsprovider = VrParamsProviderFactory.create(context)).readPhoneParams();
        vrparamsprovider.close();
        if(phoneparams != null)
        {
            if(phoneparams.hasXPpi())
                displaymetrics.xdpi = phoneparams.getXPpi();
            if(phoneparams.hasYPpi())
                displaymetrics.ydpi = phoneparams.getYPpi();
        }
        updateNativePhoneParamsPointer(l, displaymetrics);
    }

    private static byte[] readUserPrefs(Context context)
    {
        VrParamsProvider vrparamsprovider;
        com.google.vrtoolkit.cardboard.proto.nano.Preferences.UserPrefs userprefs = (vrparamsprovider = VrParamsProviderFactory.create(context)).readUserPrefs();
        vrparamsprovider.close();
        if(userprefs == null)
            return null;
        else
            return MessageNano.toByteArray(userprefs);
    }

    private static DisplayMetrics getDisplayMetrics(Context context)
    {
        DisplayMetrics displaymetrics;
        WindowManager windowmanager;
        Display display;
        if((displaymetrics = displayMetricsOverride) != null)
            return displaymetrics;
        else
            return DisplayUtils.getDisplayMetricsLandscape(display = (windowmanager = (WindowManager)context.getSystemService("window")).getDefaultDisplay());
    }

    private static void updateNativePhoneParamsPointer(long l, DisplayMetrics displaymetrics)
    {
        nativeUpdateNativePhoneParamsPointer(l, displaymetrics.widthPixels, displaymetrics.heightPixels, displaymetrics.xdpi, displaymetrics.ydpi);
    }

    private static native void nativeUpdateNativePhoneParamsPointer(long l, int i, int j, float f, float f1);

    private static final String TAG = "VrParamsProviderJni";
    private static volatile DisplayMetrics displayMetricsOverride = null;

}
