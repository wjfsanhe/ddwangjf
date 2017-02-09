// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ControllerAccelEvent.java

package com.google.vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.google.vr.vrcore.controller.api:
//            ControllerAccelEvent

class 
    implements android.os.i.ControllerAccelEvent._cls1
{

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

    ()
    {
    }
}
