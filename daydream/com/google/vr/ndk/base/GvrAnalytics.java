// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GvrAnalytics.java

package com.google.vr.ndk.base;

import android.util.Log;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.vrtoolkit.cardboard.proto.nano.Analytics;

// Referenced classes of package com.google.vr.ndk.base:
//            GvrApi

public class GvrAnalytics
{

    GvrAnalytics(long l)
    {
        nativeAnalytics = l;
    }

    public com.google.vrtoolkit.cardboard.proto.nano.Analytics.AnalyticsSample querySample()
    {
        byte abyte0[];
        if((abyte0 = GvrApi.nativeAnalyticsGetSample(nativeAnalytics)) == null)
            return null;
        return com.google.vrtoolkit.cardboard.proto.nano.Analytics.AnalyticsSample.parseFrom(abyte0);
        InvalidProtocolBufferNanoException invalidprotocolbuffernanoexception;
        invalidprotocolbuffernanoexception;
        String s;
        Log.e("GvrAnalytics", (new StringBuilder(31 + String.valueOf(s = String.valueOf(invalidprotocolbuffernanoexception)).length())).append("error parsing AnalyticsSample: ").append(s).toString());
        return null;
    }

    private static final String TAG = "GvrAnalytics";
    private final long nativeAnalytics;
}
