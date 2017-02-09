// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PhoneParams.java

package com.google.vr.cardboard;


// Referenced classes of package com.google.vr.cardboard:
//            PhoneParams

static class yPpi
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

    (String s, String s1, String s2, String s3, int i, int j)
    {
        manufacturer = s;
        device = s1;
        model = s2;
        hardware = s3;
        xPpi = i;
        yPpi = j;
    }
}
