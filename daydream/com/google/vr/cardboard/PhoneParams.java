// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PhoneParams.java

package com.google.vr.cardboard;

import android.os.Build;
import android.util.Log;
import com.google.protobuf.nano.MessageNano;
import com.google.vrtoolkit.cardboard.proto.nano.Phone;
import java.util.*;

// Referenced classes of package com.google.vr.cardboard:
//            ConfigUtils

public class PhoneParams
{
    static class PpiOverride
    {

        boolean isMatching(String s, String s1, String s2, String s3)
        {
            return (manufacturer == null || manufacturer.equals(s)) && (device == null || device.equals(s1)) && (model == null || model.equals(s2)) && (hardware == null || hardware.equals(s3));
        }

        String manufacturer;
        String device;
        String model;
        String hardware;
        int xPpi;
        int yPpi;

        PpiOverride(String s, String s1, String s2, String s3, int i, int j)
        {
            manufacturer = s;
            device = s1;
            model = s2;
            hardware = s3;
            xPpi = i;
            yPpi = j;
        }
    }


    private PhoneParams()
    {
    }

    static boolean getPpiOverride(List list, String s, String s1, String s2, String s3, com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams phoneparams)
    {
        PpiOverride ppioverride;
        for(Iterator iterator = list.iterator(); iterator.hasNext();)
            if((ppioverride = (PpiOverride)iterator.next()).isMatching(s, s1, s2, s3))
            {
                Log.d(TAG, String.format("Found override: {MANUFACTURER=%s, DEVICE=%s, MODEL=%s, HARDWARE=%s} : x_ppi=%d, y_ppi=%d", new Object[] {
                    ppioverride.manufacturer, ppioverride.device, ppioverride.model, ppioverride.hardware, Integer.valueOf(ppioverride.xPpi), Integer.valueOf(ppioverride.yPpi)
                }));
                phoneparams.setXPpi(ppioverride.xPpi);
                phoneparams.setYPpi(ppioverride.yPpi);
                return true;
            }

        return false;
    }

    static void registerOverridesInternal(List list, String s, String s1, String s2, String s3)
    {
        com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams phoneparams;
        com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams phoneparams1 = (phoneparams = ConfigUtils.readPhoneParamsFromExternalStorage()) != null ? phoneparams.clone() : new com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams();
        if(getPpiOverride(list, s, s1, s2, s3, phoneparams1) && !MessageNano.messageNanoEquals(phoneparams, phoneparams1))
        {
            Log.i(TAG, "Applying phone param override.");
            ConfigUtils.writePhoneParamsToExternalStorage(phoneparams1);
        }
    }

    public static void registerOverrides()
    {
        registerOverridesInternal(PPI_OVERRIDES, Build.MANUFACTURER, Build.DEVICE, Build.MODEL, Build.HARDWARE);
    }

    public static com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams getPpiOverride()
    {
        com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams phoneparams = new com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams();
        if(getPpiOverride(PPI_OVERRIDES, Build.MANUFACTURER, Build.DEVICE, Build.MODEL, Build.HARDWARE, phoneparams))
            return phoneparams;
        else
            return null;
    }

    private static final boolean DEBUG = false;
    private static final String TAG = com/google/vr/cardboard/PhoneParams.getSimpleName();
    private static final List PPI_OVERRIDES = Arrays.asList(new PpiOverride[] {
        new PpiOverride("Micromax", null, "4560MMX", null, 217, 217), new PpiOverride("HTC", "endeavoru", "HTC One X", null, 312, 312), new PpiOverride("samsung", null, "SM-G920P", null, 575, 575), new PpiOverride("samsung", null, "SM-G930", null, 581, 580), new PpiOverride("samsung", null, "SM-G9300", null, 581, 580), new PpiOverride("samsung", null, "SM-G930A", null, 581, 580), new PpiOverride("samsung", null, "SM-G930F", null, 581, 580), new PpiOverride("samsung", null, "SM-G930P", null, 581, 580), new PpiOverride("samsung", null, "SM-G930R4", null, 581, 580), new PpiOverride("samsung", null, "SM-G930T", null, 581, 580), 
        new PpiOverride("samsung", null, "SM-G930V", null, 581, 580), new PpiOverride("samsung", null, "SM-G930W8", null, 581, 580), new PpiOverride("samsung", null, "SM-N915FY", null, 541, 541), new PpiOverride("samsung", null, "SM-N915A", null, 541, 541), new PpiOverride("samsung", null, "SM-N915T", null, 541, 541), new PpiOverride("samsung", null, "SM-N915K", null, 541, 541), new PpiOverride("samsung", null, "SM-N915T", null, 541, 541), new PpiOverride("samsung", null, "SM-N915G", null, 541, 541), new PpiOverride("samsung", null, "SM-N915D", null, 541, 541), new PpiOverride("BLU", "BLU", "Studio 5.0 HD LTE", "qcom", 294, 294), 
        new PpiOverride("OnePlus", "A0001", "A0001", "bacon", 401, 401), new PpiOverride("THL", "THL", "thl 5000", "mt6592", 441, 441)
    });

}
