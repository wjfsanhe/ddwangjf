// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ControllerListenerOptions.java

package com.google.vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;

public class ControllerListenerOptions
    implements Parcelable
{

    public ControllerListenerOptions()
    {
        enableOrientation = true;
        enableTouch = true;
    }

    protected ControllerListenerOptions(Parcel parcel)
    {
        readFromParcel(parcel);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(enableOrientation ? 1 : 0);
        parcel.writeInt(enableGyro ? 1 : 0);
        parcel.writeInt(enableAccel ? 1 : 0);
        parcel.writeInt(enableTouch ? 1 : 0);
        parcel.writeInt(enableGestures ? 1 : 0);
    }

    public void readFromParcel(Parcel parcel)
    {
        enableOrientation = parcel.readInt() != 0;
        enableGyro = parcel.readInt() != 0;
        enableAccel = parcel.readInt() != 0;
        enableTouch = parcel.readInt() != 0;
        enableGestures = parcel.readInt() != 0;
    }

    public String toString()
    {
        return String.format(Locale.US, "ori=%b, gyro=%b, accel=%b, touch=%b, gestures=%b", new Object[] {
            Boolean.valueOf(enableOrientation), Boolean.valueOf(enableGyro), Boolean.valueOf(enableAccel), Boolean.valueOf(enableTouch), Boolean.valueOf(enableGestures)
        });
    }

    public boolean enableOrientation;
    public boolean enableGyro;
    public boolean enableAccel;
    public boolean enableTouch;
    public boolean enableGestures;
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final ControllerListenerOptions createFromParcel(Parcel parcel)
        {
            return new ControllerListenerOptions(parcel);
        }

        public final ControllerListenerOptions[] newArray(int i)
        {
            return new ControllerListenerOptions[i];
        }

        public final volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

    };

}
