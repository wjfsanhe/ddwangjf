// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ControllerButtonEvent.java

package com.google.vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.google.vr.vrcore.controller.api:
//            ControllerEvent

public final class ControllerButtonEvent extends ControllerEvent
{

    public ControllerButtonEvent()
    {
    }

    public ControllerButtonEvent(Parcel parcel)
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
        parcel.writeInt(button);
        parcel.writeInt(down ? 1 : 0);
    }

    public final void readFromParcel(Parcel parcel)
    {
        super.readFromParcel(parcel);
        button = parcel.readInt();
        down = 0 != parcel.readInt();
    }

    public static String buttonToString(int i)
    {
        switch(i)
        {
        case 0: // '\0'
            return "BUTTON_NONE";

        case 1: // '\001'
            return "BUTTON_CLICK";

        case 2: // '\002'
            return "BUTTON_HOME";

        case 3: // '\003'
            return "BUTTON_APP";

        case 5: // '\005'
            return "BUTTON_VOLUME_UP";

        case 6: // '\006'
            return "BUTTON_VOLUME_DOWN";

        case 4: // '\004'
        default:
            return (new StringBuilder(29)).append("[Unknown button: ").append(i).append("]").toString();
        }
    }

    public final int getByteSize()
    {
        return super.getByteSize() + 8;
    }

    public final void copyFrom(ControllerEvent controllerevent)
    {
        if(!(controllerevent instanceof ControllerButtonEvent))
        {
            throw new IllegalStateException("Cannot copy ControllerButtonEvent from non-ControllerButtonEvent instance.");
        } else
        {
            super.copyFrom(controllerevent);
            ControllerButtonEvent controllerbuttonevent = (ControllerButtonEvent)controllerevent;
            button = controllerbuttonevent.button;
            down = controllerbuttonevent.down;
            return;
        }
    }

    public static final int BUTTON_NONE = 0;
    public static final int BUTTON_CLICK = 1;
    public static final int BUTTON_HOME = 2;
    public static final int BUTTON_APP = 3;
    public static final int BUTTON_VOLUME_UP = 5;
    public static final int BUTTON_VOLUME_DOWN = 6;
    public static final int BUTTON_COUNT = 7;
    public int button;
    public boolean down;
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final ControllerButtonEvent createFromParcel(Parcel parcel)
        {
            return new ControllerButtonEvent(parcel);
        }

        public final ControllerButtonEvent[] newArray(int i)
        {
            return new ControllerButtonEvent[i];
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
