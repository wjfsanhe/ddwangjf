// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ControllerEventPacket2.java

package com.google.vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayDeque;

// Referenced classes of package com.google.vr.vrcore.controller.api:
//            ControllerEventPacket, ControllerPositionEvent

public final class ControllerEventPacket2 extends ControllerEventPacket
{

    public ControllerEventPacket2()
    {
        positionEvents = new ControllerPositionEvent[16];
        for(int i = 0; i < 16; i++)
            positionEvents[i] = new ControllerPositionEvent();

        clear();
    }

    public final void clear()
    {
        super.clear();
        positionEventCount = 0;
    }

    public final int getPositionEventCount()
    {
        return positionEventCount;
    }

    public final ControllerPositionEvent getPositionEvent(int i)
    {
        if(i < 0 || i >= positionEventCount)
            throw new IndexOutOfBoundsException();
        else
            return positionEvents[i];
    }

    public final ControllerPositionEvent addPositionEvent()
    {
        if(positionEventCount >= 16)
            throw new IllegalStateException("ControllerEventPacket capacity exceeded.");
        else
            return positionEvents[positionEventCount++];
    }

    public static ControllerEventPacket2 obtain()
    {
        Object obj = poolLock;
        JVM INSTR monitorenter ;
        return pool.isEmpty() ? new ControllerEventPacket2() : (ControllerEventPacket2)pool.remove();
        Exception exception;
        exception;
        throw exception;
    }

    public final void recycle()
    {
        clear();
        synchronized(poolLock)
        {
            if(!pool.contains(this))
                pool.add(this);
        }
    }

    public final int describeContents()
    {
        return 0;
    }

    protected final int calculateParcelByteLength()
    {
        int i = super.calculateParcelByteLength();
        i += 4;
        i += 4;
        for(int j = 0; j < positionEventCount; j++)
            i += positionEvents[j].getByteSize();

        return i;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        int j = parcel.dataPosition();
        int k = calculateParcelByteLength();
        parcel.writeInt(k);
        super.writeToParcel(parcel, i);
        parcel.writeInt(positionEventCount);
        for(int l = 0; l < positionEventCount; l++)
            positionEvents[l].writeToParcel(parcel, i);

        if(parcel.dataPosition() - j != k)
            throw new IllegalStateException("Parcelable implemented incorrectly, getByteSize() must return the correct size for each ControllerEvent subclass.");
        else
            return;
    }

    public final void readFromParcel(Parcel parcel)
    {
        int i = parcel.dataPosition();
        int j = parcel.readInt();
        super.readFromParcel(parcel);
        positionEventCount = parcel.readInt();
        checkIsValidEventCount(positionEventCount);
        for(int k = 0; k < positionEventCount; k++)
            positionEvents[k].readFromParcel(parcel);

        parcel.setDataPosition(i + j);
    }

    private static ArrayDeque pool = new ArrayDeque();
    private static Object poolLock = new Object();
    private int positionEventCount;
    private ControllerPositionEvent positionEvents[];
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

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

    };

}
