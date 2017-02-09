// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ControllerEventPacket.java

package com.google.vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.google.vr.vrcore.controller.api:
//            ControllerEventPacket

class A
    implements android.os..ControllerEventPacket._cls1
{

    public final ControllerEventPacket createFromParcel(Parcel parcel)
    {
        ControllerEventPacket controllereventpacket;
        (controllereventpacket = ControllerEventPacket.obtain()).readFromParcel(parcel);
        return controllereventpacket;
    }

    public final ControllerEventPacket[] newArray(int i)
    {
        return new ControllerEventPacket[i];
    }

    public final volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    public final volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    A()
    {
    }
}
