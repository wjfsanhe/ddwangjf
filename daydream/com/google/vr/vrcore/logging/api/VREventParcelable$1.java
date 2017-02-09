// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VREventParcelable.java

package com.google.vr.vrcore.logging.api;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.google.vr.vrcore.logging.api:
//            VREventParcelable

class 
    implements android.os.i.VREventParcelable._cls1
{

    public final VREventParcelable createFromParcel(Parcel parcel)
    {
        return new VREventParcelable(parcel, null);
    }

    public final VREventParcelable[] newArray(int i)
    {
        return new VREventParcelable[i];
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
