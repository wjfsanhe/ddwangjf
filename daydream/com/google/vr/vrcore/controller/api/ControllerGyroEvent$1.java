// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ControllerGyroEvent.java

package com.google.vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.google.vr.vrcore.controller.api:
//            ControllerGyroEvent

class 
    implements android.os.pi.ControllerGyroEvent._cls1
{

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

    ()
    {
    }
}
