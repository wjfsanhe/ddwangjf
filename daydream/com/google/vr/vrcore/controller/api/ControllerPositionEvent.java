// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ControllerPositionEvent.java

package com.google.vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.google.vr.vrcore.controller.api:
//            ControllerEvent

public final class ControllerPositionEvent extends ControllerEvent
{

    public ControllerPositionEvent()
    {
    }

    public ControllerPositionEvent(Parcel parcel)
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
        if(!(controllerevent instanceof ControllerPositionEvent))
        {
            throw new IllegalStateException("Cannot copy ControllerPositionEvent from non-ControllerPositionEvent instance.");
        } else
        {
            super.copyFrom(controllerevent);
            ControllerPositionEvent controllerpositionevent = (ControllerPositionEvent)controllerevent;
            x = controllerpositionevent.x;
            y = controllerpositionevent.y;
            z = controllerpositionevent.z;
            return;
        }
    }

    public float x;
    public float y;
    public float z;
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final ControllerPositionEvent createFromParcel(Parcel parcel)
        {
            return new ControllerPositionEvent(parcel);
        }

        public final ControllerPositionEvent[] newArray(int i)
        {
            return new ControllerPositionEvent[i];
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
