// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ControllerAccelEvent.java

package com.google.vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.google.vr.vrcore.controller.api:
//            ControllerEvent

public final class ControllerAccelEvent extends ControllerEvent
{

    public ControllerAccelEvent()
    {
    }

    public ControllerAccelEvent(Parcel parcel)
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
        if(!(controllerevent instanceof ControllerAccelEvent))
        {
            throw new IllegalStateException("Cannot copy ControllerAccelEvent from non-ControllerAccelEvent instance.");
        } else
        {
            super.copyFrom(controllerevent);
            ControllerAccelEvent controlleraccelevent = (ControllerAccelEvent)controllerevent;
            x = controlleraccelevent.x;
            y = controlleraccelevent.y;
            z = controlleraccelevent.z;
            return;
        }
    }

    public float x;
    public float y;
    public float z;
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final ControllerAccelEvent createFromParcel(Parcel parcel)
        {
            return new ControllerAccelEvent(parcel);
        }

        public final ControllerAccelEvent[] newArray(int i)
        {
            return new ControllerAccelEvent[i];
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
