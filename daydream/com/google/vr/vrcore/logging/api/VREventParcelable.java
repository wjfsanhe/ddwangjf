// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VREventParcelable.java

package com.google.vr.vrcore.logging.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.protobuf.nano.MessageNano;

public class VREventParcelable
    implements Parcelable
{

    public VREventParcelable(int i, com.google.common.logging.nano.Vr.VREvent vrevent)
    {
        eventCode = i;
        event = vrevent;
    }

    private VREventParcelable(Parcel parcel)
    {
        eventCode = parcel.readInt();
        String s;
        try
        {
            byte abyte0[];
            byte abyte1[];
            if((abyte0 = parcel.createByteArray()).length > 0)
                event = (com.google.common.logging.nano.Vr.VREvent)MessageNano.mergeFrom(new com.google.common.logging.nano.Vr.VREvent(), abyte1 = abyte0);
            return;
        }
        catch(Exception exception)
        {
            Log.i(TAG, (new StringBuilder(35 + String.valueOf(s = String.valueOf(exception)).length())).append("Logging with empty VREvent. Error: ").append(s).toString());
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(eventCode);
        if(event != null)
            parcel.writeByteArray(com.google.common.logging.nano.Vr.VREvent.toByteArray(event));
    }

    public com.google.common.logging.nano.Vr.VREvent getEvent()
    {
        return event;
    }

    public int getEventCode()
    {
        return eventCode;
    }


    private static final String TAG = com/google/vr/vrcore/logging/api/VREventParcelable.getSimpleName();
    private int eventCode;
    private com.google.common.logging.nano.Vr.VREvent event;
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final VREventParcelable createFromParcel(Parcel parcel)
        {
            return new VREventParcelable(parcel);
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

    };

}
