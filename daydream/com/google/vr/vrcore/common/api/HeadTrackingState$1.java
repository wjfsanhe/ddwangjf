// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   HeadTrackingState.java

package com.google.vr.vrcore.common.api;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.google.vr.vrcore.common.api:
//            HeadTrackingState

class _cls9
    implements android.os..HeadTrackingState._cls1
{

    public final HeadTrackingState createFromParcel(Parcel parcel)
    {
        return new HeadTrackingState(parcel, null);
    }

    public final HeadTrackingState[] newArray(int i)
    {
        return new HeadTrackingState[i];
    }

    public final volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    public final volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    _cls9()
    {
    }
}
