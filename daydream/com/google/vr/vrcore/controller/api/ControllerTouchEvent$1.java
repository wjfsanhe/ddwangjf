// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ControllerTouchEvent.java

package com.google.vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.google.vr.vrcore.controller.api:
//            ControllerTouchEvent

class 
    implements android.os.i.ControllerTouchEvent._cls1
{

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

    ()
    {
    }
}
