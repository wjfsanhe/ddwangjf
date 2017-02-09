// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ControllerPositionEvent.java

package com.google.vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.google.vr.vrcore.controller.api:
//            ControllerPositionEvent

class 
    implements android.os.ontrollerPositionEvent._cls1
{

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

    ()
    {
    }
}
