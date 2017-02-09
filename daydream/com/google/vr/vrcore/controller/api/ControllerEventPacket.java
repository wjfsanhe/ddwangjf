// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ControllerEventPacket.java

package com.google.vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayDeque;

// Referenced classes of package com.google.vr.vrcore.controller.api:
//            ControllerAccelEvent, ControllerButtonEvent, ControllerGyroEvent, ControllerOrientationEvent, 
//            ControllerTouchEvent

/**
 * @deprecated Class ControllerEventPacket is deprecated
 */

public class ControllerEventPacket
    implements Parcelable
{

    public ControllerEventPacket()
    {
        accelEvents = new ControllerAccelEvent[16];
        buttonEvents = new ControllerButtonEvent[16];
        gyroEvents = new ControllerGyroEvent[16];
        orientationEvents = new ControllerOrientationEvent[16];
        touchEvents = new ControllerTouchEvent[16];
        for(int i = 0; i < 16; i++)
        {
            accelEvents[i] = new ControllerAccelEvent();
            buttonEvents[i] = new ControllerButtonEvent();
            gyroEvents[i] = new ControllerGyroEvent();
            orientationEvents[i] = new ControllerOrientationEvent();
            touchEvents[i] = new ControllerTouchEvent();
        }

        clear();
    }

    public void copyFrom(ControllerEventPacket controllereventpacket)
    {
        accelEventCount = controllereventpacket.accelEventCount;
        buttonEventCount = controllereventpacket.buttonEventCount;
        gyroEventCount = controllereventpacket.gyroEventCount;
        orientationEventCount = controllereventpacket.orientationEventCount;
        touchEventCount = controllereventpacket.touchEventCount;
        for(int i = 0; i < 16; i++)
        {
            accelEvents[i].copyFrom(controllereventpacket.accelEvents[i]);
            buttonEvents[i].copyFrom(controllereventpacket.buttonEvents[i]);
            gyroEvents[i].copyFrom(controllereventpacket.gyroEvents[i]);
            orientationEvents[i].copyFrom(controllereventpacket.orientationEvents[i]);
            touchEvents[i].copyFrom(controllereventpacket.touchEvents[i]);
        }

    }

    protected ControllerEventPacket(Parcel parcel)
    {
        this();
        readFromParcel(parcel);
    }

    public void clear()
    {
        accelEventCount = 0;
        buttonEventCount = 0;
        gyroEventCount = 0;
        orientationEventCount = 0;
        touchEventCount = 0;
    }

    public int getAccelEventCount()
    {
        return accelEventCount;
    }

    public int getButtonEventCount()
    {
        return buttonEventCount;
    }

    public int getGyroEventCount()
    {
        return gyroEventCount;
    }

    public int getOrientationEventCount()
    {
        return orientationEventCount;
    }

    public int getTouchEventCount()
    {
        return touchEventCount;
    }

    public ControllerAccelEvent getAccelEvent(int i)
    {
        if(i < 0 || i >= accelEventCount)
            throw new IndexOutOfBoundsException();
        else
            return accelEvents[i];
    }

    public ControllerButtonEvent getButtonEvent(int i)
    {
        if(i < 0 || i >= buttonEventCount)
            throw new IndexOutOfBoundsException();
        else
            return buttonEvents[i];
    }

    public ControllerGyroEvent getGyroEvent(int i)
    {
        if(i < 0 || i >= gyroEventCount)
            throw new IndexOutOfBoundsException();
        else
            return gyroEvents[i];
    }

    public ControllerOrientationEvent getOrientationEvent(int i)
    {
        if(i < 0 || i >= orientationEventCount)
            throw new IndexOutOfBoundsException();
        else
            return orientationEvents[i];
    }

    public ControllerTouchEvent getTouchEvent(int i)
    {
        if(i < 0 || i >= touchEventCount)
            throw new IndexOutOfBoundsException();
        else
            return touchEvents[i];
    }

    public ControllerAccelEvent addAccelEvent()
    {
        if(accelEventCount >= 16)
            throw new IllegalStateException("ControllerEventPacket capacity exceeded.");
        else
            return accelEvents[accelEventCount++];
    }

    public ControllerButtonEvent addButtonEvent()
    {
        if(buttonEventCount >= 16)
            throw new IllegalStateException("ControllerEventPacket capacity exceeded.");
        else
            return buttonEvents[buttonEventCount++];
    }

    public ControllerGyroEvent addGyroEvent()
    {
        if(gyroEventCount >= 16)
            throw new IllegalStateException("ControllerEventPacket capacity exceeded.");
        else
            return gyroEvents[gyroEventCount++];
    }

    public ControllerOrientationEvent addOrientationEvent()
    {
        if(orientationEventCount >= 16)
            throw new IllegalStateException("ControllerEventPacket capacity exceeded.");
        else
            return orientationEvents[orientationEventCount++];
    }

    public ControllerTouchEvent addTouchEvent()
    {
        if(touchEventCount >= 16)
            throw new IllegalStateException("ControllerEventPacket capacity exceeded.");
        else
            return touchEvents[touchEventCount++];
    }

    public static ControllerEventPacket obtain()
    {
        Object obj = poolLock;
        JVM INSTR monitorenter ;
        return pool.isEmpty() ? new ControllerEventPacket() : (ControllerEventPacket)pool.remove();
        Exception exception;
        exception;
        throw exception;
    }

    public void recycle()
    {
        clear();
        synchronized(poolLock)
        {
            if(!pool.contains(this))
                pool.add(this);
        }
    }

    public int describeContents()
    {
        return 0;
    }

    protected int calculateParcelByteLength()
    {
        int i = 4;
        i += 20;
        for(int j = 0; j < accelEventCount; j++)
            i += accelEvents[j].getByteSize();

        for(int k = 0; k < buttonEventCount; k++)
            i += buttonEvents[k].getByteSize();

        for(int l = 0; l < gyroEventCount; l++)
            i += gyroEvents[l].getByteSize();

        for(int i1 = 0; i1 < orientationEventCount; i1++)
            i += orientationEvents[i1].getByteSize();

        for(int j1 = 0; j1 < touchEventCount; j1++)
            i += touchEvents[j1].getByteSize();

        return i;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(1);
        parcel.writeInt(accelEventCount);
        for(int j = 0; j < accelEventCount; j++)
            accelEvents[j].writeToParcel(parcel, i);

        parcel.writeInt(buttonEventCount);
        for(int k = 0; k < buttonEventCount; k++)
            buttonEvents[k].writeToParcel(parcel, i);

        parcel.writeInt(gyroEventCount);
        for(int l = 0; l < gyroEventCount; l++)
            gyroEvents[l].writeToParcel(parcel, i);

        parcel.writeInt(orientationEventCount);
        for(int i1 = 0; i1 < orientationEventCount; i1++)
            orientationEvents[i1].writeToParcel(parcel, i);

        parcel.writeInt(touchEventCount);
        for(int j1 = 0; j1 < touchEventCount; j1++)
            touchEvents[j1].writeToParcel(parcel, i);

    }

    public void readFromParcel(Parcel parcel)
    {
        parcel.readInt();
        accelEventCount = parcel.readInt();
        checkIsValidEventCount(accelEventCount);
        for(int i = 0; i < accelEventCount; i++)
            accelEvents[i].readFromParcel(parcel);

        buttonEventCount = parcel.readInt();
        checkIsValidEventCount(buttonEventCount);
        for(int j = 0; j < buttonEventCount; j++)
            buttonEvents[j].readFromParcel(parcel);

        gyroEventCount = parcel.readInt();
        checkIsValidEventCount(gyroEventCount);
        for(int k = 0; k < gyroEventCount; k++)
            gyroEvents[k].readFromParcel(parcel);

        orientationEventCount = parcel.readInt();
        checkIsValidEventCount(orientationEventCount);
        for(int l = 0; l < orientationEventCount; l++)
            orientationEvents[l].readFromParcel(parcel);

        touchEventCount = parcel.readInt();
        checkIsValidEventCount(touchEventCount);
        for(int i1 = 0; i1 < touchEventCount; i1++)
            touchEvents[i1].readFromParcel(parcel);

    }

    protected void checkIsValidEventCount(int i)
    {
        if(i < 0 || i >= 16)
            throw new IllegalArgumentException((new StringBuilder(32)).append("Invalid event count: ").append(i).toString());
        else
            return;
    }

    private static final int SERIALIZED_FORMAT_VERSION = 1;
    protected static final int MAX_EVENTS = 16;
    private static ArrayDeque pool = new ArrayDeque();
    private static Object poolLock = new Object();
    private int accelEventCount;
    private ControllerAccelEvent accelEvents[];
    private int buttonEventCount;
    private ControllerButtonEvent buttonEvents[];
    private int gyroEventCount;
    private ControllerGyroEvent gyroEvents[];
    private int orientationEventCount;
    private ControllerOrientationEvent orientationEvents[];
    private int touchEventCount;
    private ControllerTouchEvent touchEvents[];
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

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

    };

}
