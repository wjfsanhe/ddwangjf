// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   HeadTrackingState.java

package com.google.vr.vrcore.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public class HeadTrackingState
    implements Parcelable
{

    public HeadTrackingState()
    {
        data = new byte[0];
    }

    public HeadTrackingState(byte abyte0[])
    {
        data = new byte[0];
        data = abyte0;
    }

    private HeadTrackingState(Parcel parcel)
    {
        data = new byte[0];
        readFromParcel(parcel);
    }

    public byte[] getData()
    {
        return data;
    }

    public boolean isEmpty()
    {
        return data.length == 0;
    }

    public void setData(byte abyte0[])
    {
        data = abyte0;
    }

    public void clear()
    {
        data = new byte[0];
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(data.length);
        parcel.writeByteArray(data);
    }

    public void readFromParcel(Parcel parcel)
    {
        int i = parcel.readInt();
        data = new byte[i];
        parcel.readByteArray(data);
    }

    public String toString()
    {
        int i = data.length;
        return (new StringBuilder(36)).append("HeadTrackingState[").append(i).append(" bytes]").toString();
    }

    public boolean equals(Object obj)
    {
        if(obj == this)
            return true;
        if(obj instanceof HeadTrackingState)
            return Arrays.equals(((HeadTrackingState)obj).data, data);
        else
            return false;
    }

    public int hashCode()
    {
        return Arrays.hashCode(data);
    }

    public void copyFrom(HeadTrackingState headtrackingstate)
    {
        Parcel parcel = Parcel.obtain();
        headtrackingstate.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        readFromParcel(parcel);
        parcel.recycle();
    }


    private byte data[];
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final HeadTrackingState createFromParcel(Parcel parcel)
        {
            return new HeadTrackingState(parcel);
        }

        public final HeadTrackingState[] newArray(int i)
        {
            return new HeadTrackingState[i];
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
