// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ControllerTouchEvent.java

package com.google.vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.google.vr.vrcore.controller.api:
//            ControllerEvent

public final class ControllerTouchEvent extends ControllerEvent
{

    public ControllerTouchEvent()
    {
    }

    public ControllerTouchEvent(Parcel parcel)
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
        parcel.writeInt(fingerId);
        parcel.writeInt(action);
        parcel.writeFloat(x);
        parcel.writeFloat(y);
    }

    public final void readFromParcel(Parcel parcel)
    {
        super.readFromParcel(parcel);
        fingerId = parcel.readInt();
        action = parcel.readInt();
        x = parcel.readFloat();
        y = parcel.readFloat();
    }

    public final int getByteSize()
    {
        return super.getByteSize() + 8 + 8;
    }

    public final void copyFrom(ControllerEvent controllerevent)
    {
        if(!(controllerevent instanceof ControllerTouchEvent))
        {
            throw new IllegalStateException("Cannot copy ControllerTouchEvent from non-ControllerTouchEvent instance.");
        } else
        {
            super.copyFrom(controllerevent);
            ControllerTouchEvent controllertouchevent = (ControllerTouchEvent)controllerevent;
            fingerId = controllertouchevent.fingerId;
            action = controllertouchevent.action;
            x = controllertouchevent.x;
            y = controllertouchevent.y;
            return;
        }
    }

    public static final int ACTION_NONE = 0;
    public static final int ACTION_DOWN = 1;
    public static final int ACTION_MOVE = 2;
    public static final int ACTION_UP = 3;
    public static final int ACTION_CANCEL = 4;
    public int fingerId;
    public int action;
    public float x;
    public float y;
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final ControllerTouchEvent createFromParcel(Parcel parcel)
        {
            return new ControllerTouchEvent(parcel);
        }

        public final ControllerTouchEvent[] newArray(int i)
        {
            return new ControllerTouchEvent[i];
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
