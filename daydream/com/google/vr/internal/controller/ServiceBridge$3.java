// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ServiceBridge.java

package com.google.vr.internal.controller;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.vr.vrcore.controller.api.*;

// Referenced classes of package com.google.vr.internal.controller:
//            ServiceBridge

class tener.Stub extends com.google.vr.vrcore.controller.api.ner.Stub
{

    public int getApiVersion()
        throws RemoteException
    {
        return 11;
    }

    public ControllerListenerOptions getOptions()
        throws RemoteException
    {
        return ServiceBridge.access$200(ServiceBridge.this);
    }

    public void onControllerStateChanged(int i, int j)
        throws RemoteException
    {
        ServiceBridge.access$300(ServiceBridge.this).onControllerStateChanged(i, j);
    }

    public void onControllerEventPacket(ControllerEventPacket controllereventpacket)
        throws RemoteException
    {
        ServiceBridge.access$300(ServiceBridge.this).onControllerEventPacket(controllereventpacket);
        controllereventpacket.recycle();
    }

    public void onControllerEventPacket2(ControllerEventPacket2 controllereventpacket2)
        throws RemoteException
    {
        ServiceBridge.access$300(ServiceBridge.this).onControllerEventPacket2(controllereventpacket2);
        controllereventpacket2.recycle();
    }

    public void onControllerRecentered(ControllerOrientationEvent controllerorientationevent)
    {
        ServiceBridge.access$300(ServiceBridge.this).onControllerRecentered(controllerorientationevent);
    }

    public boolean deprecatedOnControllerButtonEventV1(ControllerButtonEvent controllerbuttonevent)
    {
        return true;
    }

    public void deprecatedOnControllerAccelEvent(ControllerAccelEvent controlleraccelevent)
    {
        ControllerEventPacket controllereventpacket = ControllerEventPacket.obtain();
        Parcel parcel = Parcel.obtain();
        controlleraccelevent.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        controllereventpacket.addAccelEvent().readFromParcel(parcel);
        ServiceBridge.access$300(ServiceBridge.this).onControllerEventPacket(controllereventpacket);
        controllereventpacket.recycle();
        parcel.recycle();
    }

    public void deprecatedOnControllerButtonEvent(ControllerButtonEvent controllerbuttonevent)
    {
        ControllerEventPacket controllereventpacket = ControllerEventPacket.obtain();
        Parcel parcel = Parcel.obtain();
        controllerbuttonevent.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        controllereventpacket.addButtonEvent().readFromParcel(parcel);
        ServiceBridge.access$300(ServiceBridge.this).onControllerEventPacket(controllereventpacket);
        controllereventpacket.recycle();
        parcel.recycle();
    }

    public void deprecatedOnControllerGyroEvent(ControllerGyroEvent controllergyroevent)
    {
        ControllerEventPacket controllereventpacket = ControllerEventPacket.obtain();
        Parcel parcel = Parcel.obtain();
        controllergyroevent.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        controllereventpacket.addGyroEvent().readFromParcel(parcel);
        ServiceBridge.access$300(ServiceBridge.this).onControllerEventPacket(controllereventpacket);
        controllereventpacket.recycle();
        parcel.recycle();
    }

    public void deprecatedOnControllerOrientationEvent(ControllerOrientationEvent controllerorientationevent)
    {
        ControllerEventPacket controllereventpacket = ControllerEventPacket.obtain();
        Parcel parcel = Parcel.obtain();
        controllerorientationevent.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        controllereventpacket.addOrientationEvent().readFromParcel(parcel);
        ServiceBridge.access$300(ServiceBridge.this).onControllerEventPacket(controllereventpacket);
        controllereventpacket.recycle();
        parcel.recycle();
    }

    public void deprecatedOnControllerTouchEvent(ControllerTouchEvent controllertouchevent)
    {
        ControllerEventPacket controllereventpacket = ControllerEventPacket.obtain();
        Parcel parcel = Parcel.obtain();
        controllertouchevent.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        controllereventpacket.addTouchEvent().readFromParcel(parcel);
        ServiceBridge.access$300(ServiceBridge.this).onControllerEventPacket(controllereventpacket);
        controllereventpacket.recycle();
        parcel.recycle();
    }

    final ServiceBridge this$0;

    hEvent()
    {
        this$0 = ServiceBridge.this;
        super();
    }
}
