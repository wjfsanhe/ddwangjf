// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ControllerOrientationEvent.java

package com.google.vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.google.vr.vrcore.controller.api:
//            ControllerEvent

public final class ControllerOrientationEvent extends ControllerEvent
{

    public ControllerOrientationEvent()
    {
    }

    public ControllerOrientationEvent(float f, float f1, float f2, float f3)
    {
        qx = f;
        qy = f1;
        qz = f2;
        qw = f3;
    }

    public ControllerOrientationEvent(Parcel parcel)
    {
        readFromParcel(parcel);
    }

    public final void set(ControllerOrientationEvent controllerorientationevent)
    {
        qx = controllerorientationevent.qx;
        qy = controllerorientationevent.qy;
        qz = controllerorientationevent.qz;
        qw = controllerorientationevent.qw;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(qx);
        parcel.writeFloat(qy);
        parcel.writeFloat(qz);
        parcel.writeFloat(qw);
    }

    public final void readFromParcel(Parcel parcel)
    {
        super.readFromParcel(parcel);
        qx = parcel.readFloat();
        qy = parcel.readFloat();
        qz = parcel.readFloat();
        qw = parcel.readFloat();
    }

    public final int getByteSize()
    {
        return super.getByteSize() + 16;
    }

    public final void copyFrom(ControllerEvent controllerevent)
    {
        if(!(controllerevent instanceof ControllerOrientationEvent))
        {
            throw new IllegalStateException("Cannot copy ControllerOrientationEvent from non-ControllerOrientationEvent instance.");
        } else
        {
            super.copyFrom(controllerevent);
            ControllerOrientationEvent controllerorientationevent = (ControllerOrientationEvent)controllerevent;
            qx = controllerorientationevent.qx;
            qy = controllerorientationevent.qy;
            qz = controllerorientationevent.qz;
            qw = controllerorientationevent.qw;
            return;
        }
    }

    public float qx;
    public float qy;
    public float qz;
    public float qw;
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final ControllerOrientationEvent createFromParcel(Parcel parcel)
        {
            return new ControllerOrientationEvent(parcel);
        }

        public final ControllerOrientationEvent[] newArray(int i)
        {
            return new ControllerOrientationEvent[i];
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
