// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SdkConfigurationReader.java

package com.google.vr.ndk.base;

import android.content.Context;
import android.util.Log;
import com.google.vr.cardboard.VrParamsProvider;
import com.google.vr.cardboard.VrParamsProviderFactory;
import com.google.vr.vrcore.nano.SdkConfiguration;

public class SdkConfigurationReader
{

    public SdkConfigurationReader()
    {
    }

    public static com.google.common.logging.nano.Vr.VREvent.SdkConfigurationParams getParams(Context context)
    {
        /*<invalid signature>*/java.lang.Object local = com/google/vr/ndk/base/SdkConfigurationReader;
        JVM INSTR monitorenter ;
        if(sParams != null)
            return sParams;
        local;
        JVM INSTR monitorexit ;
          goto _L1
        Exception exception;
        exception;
        throw exception;
_L1:
        VrParamsProvider vrparamsprovider;
        com.google.common.logging.nano.Vr.VREvent.SdkConfigurationParams sdkconfigurationparams = readParamsFromProvider(vrparamsprovider = VrParamsProviderFactory.create(context));
        synchronized(com/google/vr/ndk/base/SdkConfigurationReader)
        {
            sParams = sdkconfigurationparams;
        }
        vrparamsprovider.close();
        return sParams;
    }

    private static com.google.common.logging.nano.Vr.VREvent.SdkConfigurationParams readParamsFromProvider(VrParamsProvider vrparamsprovider)
    {
        com.google.vr.vrcore.nano.SdkConfiguration.SdkConfigurationRequest sdkconfigurationrequest;
        (sdkconfigurationrequest = new com.google.vr.vrcore.nano.SdkConfiguration.SdkConfigurationRequest()).requestedParams = REQUESTED_PARAMS;
        sdkconfigurationrequest.sdkVersion = "1.20.0";
        com.google.common.logging.nano.Vr.VREvent.SdkConfigurationParams sdkconfigurationparams;
        String s;
        if((sdkconfigurationparams = vrparamsprovider.readSdkConfigurationParams(sdkconfigurationrequest)) == null)
        {
            Log.w(TAG, "VrParamsProvider returned null params, using defaults.");
            sdkconfigurationparams = DEFAULT_PARAMS;
        } else
        {
            Log.d(TAG, (new StringBuilder(38 + String.valueOf(s = String.valueOf(sdkconfigurationparams)).length())).append("Fetched params from VrParamsProvider: ").append(s).toString());
        }
        return sdkconfigurationparams;
    }

    private static final String TAG = com/google/vr/ndk/base/SdkConfigurationReader.getSimpleName();
    static final com.google.common.logging.nano.Vr.VREvent.SdkConfigurationParams REQUESTED_PARAMS;
    static com.google.common.logging.nano.Vr.VREvent.SdkConfigurationParams sParams;
    public static final com.google.common.logging.nano.Vr.VREvent.SdkConfigurationParams DEFAULT_PARAMS;

    static 
    {
        (REQUESTED_PARAMS = new com.google.common.logging.nano.Vr.VREvent.SdkConfigurationParams()).useSystemClockForSensorTimestamps = Boolean.valueOf(true);
        REQUESTED_PARAMS.useMagnetometerInSensorFusion = Boolean.valueOf(true);
        REQUESTED_PARAMS.allowDynamicLibraryLoading = Boolean.valueOf(true);
        REQUESTED_PARAMS.cpuLateLatchingEnabled = Boolean.valueOf(true);
        REQUESTED_PARAMS.daydreamImageAlignment = Integer.valueOf(1);
        REQUESTED_PARAMS.asyncReprojectionConfig = new com.google.common.logging.nano.Vr.VREvent.SdkConfigurationParams.AsyncReprojectionConfig();
        REQUESTED_PARAMS.useOnlineMagnetometerCalibration = Boolean.valueOf(true);
        (DEFAULT_PARAMS = new com.google.common.logging.nano.Vr.VREvent.SdkConfigurationParams()).useSystemClockForSensorTimestamps = Boolean.valueOf(false);
        DEFAULT_PARAMS.useMagnetometerInSensorFusion = Boolean.valueOf(false);
        DEFAULT_PARAMS.allowDynamicLibraryLoading = Boolean.valueOf(false);
        DEFAULT_PARAMS.cpuLateLatchingEnabled = Boolean.valueOf(false);
        DEFAULT_PARAMS.daydreamImageAlignment = Integer.valueOf(3);
        DEFAULT_PARAMS.asyncReprojectionConfig = null;
        DEFAULT_PARAMS.useOnlineMagnetometerCalibration = Boolean.valueOf(false);
    }
}
