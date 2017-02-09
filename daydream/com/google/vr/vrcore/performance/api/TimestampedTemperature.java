// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TimestampedTemperature.java

package com.google.vr.vrcore.performance.api;

import android.os.Parcel;
import android.os.Parcelable;

public class TimestampedTemperature
    implements Parcelable
{

    public TimestampedTemperature()
    {
    }

    public TimestampedTemperature(Parcel parcel)
    {
        readFromParcel(parcel);
    }

    public void set(long l, float f)
    {
        timestamp = l;
        temperature = f;
    }

    public void set(TimestampedTemperature timestampedtemperature)
    {
        set(timestampedtemperature.timestamp, timestampedtemperature.temperature);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        int j = parcel.dataPosition();
        parcel.writeInt(16);
        parcel.writeLong(timestamp);
        parcel.writeFloat(temperature);
        if(parcel.dataPosition() - j != 16)
            throw new IllegalStateException("Parcelable implemented incorrectly, PARCEL_SIZE must include the size of each parcelled field.");
        else
            return;
    }

    public void readFromParcel(Parcel parcel)
    {
        int i = parcel.dataPosition();
        int j = parcel.readInt();
        timestamp = parcel.readLong();
        temperature = parcel.readFloat();
        parcel.setDataPosition(i + j);
    }

    private static final int PARCEL_SIZE = 16;
    public long timestamp;
    public float temperature;
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final TimestampedTemperature createFromParcel(Parcel parcel)
        {
            return new TimestampedTemperature(parcel);
        }

        public final TimestampedTemperature[] newArray(int i)
        {
            return new TimestampedTemperature[i];
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
