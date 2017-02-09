// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ControllerEvent.java

package com.google.vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class ControllerEvent
    implements Parcelable
{

    public ControllerEvent()
    {
        controllerId = 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(timestampNanos);
        parcel.writeInt(controllerId);
    }

    public void readFromParcel(Parcel parcel)
    {
        timestampNanos = parcel.readLong();
        controllerId = parcel.readInt();
    }

    public int getByteSize()
    {
        return 12;
    }

    public void copyFrom(ControllerEvent controllerevent)
    {
        timestampNanos = controllerevent.timestampNanos;
        controllerId = controllerevent.controllerId;
    }

    public static final int CONTROLLER_ID_DEFAULT = 0;
    public long timestampNanos;
    public int controllerId;
}
