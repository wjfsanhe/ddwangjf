// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ControllerEventPacket2.java

package com.google.vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.google.vr.vrcore.controller.api:
//            ControllerEventPacket2

class 
    implements android.os.ControllerEventPacket2._cls1
{

    public final ControllerEventPacket2 createFromParcel(Parcel parcel)
    {
        ControllerEventPacket2 controllereventpacket2;
        (controllereventpacket2 = ControllerEventPacket2.obtain()).readFromParcel(parcel);
        return controllereventpacket2;
    }

    public final ControllerEventPacket2[] newArray(int i)
    {
        return new ControllerEventPacket2[i];
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
