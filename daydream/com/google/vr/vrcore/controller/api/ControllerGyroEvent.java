// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ControllerGyroEvent.java

package com.google.vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.google.vr.vrcore.controller.api:
//            ControllerEvent

public final class ControllerGyroEvent extends ControllerEvent
{

    public ControllerGyroEvent()
    {
    }

    public ControllerGyroEvent(Parcel parcel)
    {
        readFromParcel(parcel);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(x);
        parcel.writeFloat(y);
        parcel.writeFloat(z);
    }

    public final void readFromParcel(Parcel parcel)
    {
        super.readFromParcel(parcel);
        x = parcel.readFloat();
        y = parcel.readFloat();
        z = parcel.readFloat();
    }

    public final int getByteSize()
    {
        return super.getByteSize() + 12;
    }

    public final void copyFrom(ControllerEvent controllerevent)
    {
        if(!(controllerevent instanceof ControllerGyroEvent))
        {
            throw new IllegalStateException("Cannot copy ControllerGyroEvent from non-ControllerGyroEvent instance.");
        } else
        {
            super.copyFrom(controllerevent);
            ControllerGyroEvent controllergyroevent = (ControllerGyroEvent)controllerevent;
            x = controllergyroevent.x;
            y = controllergyroevent.y;
            z = controllergyroevent.z;
            return;
        }
    }

    public float x;
    public float y;
    public float z;
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final ControllerGyroEvent createFromParcel(Parcel parcel)
        {
            return new ControllerGyroEvent(parcel);
        }

        public final ControllerGyroEvent[] newArray(int i)
        {
            return new ControllerGyroEvent[i];
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
