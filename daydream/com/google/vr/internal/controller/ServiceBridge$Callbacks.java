// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ServiceBridge.java

package com.google.vr.internal.controller;

import com.google.vr.vrcore.controller.api.*;

// Referenced classes of package com.google.vr.internal.controller:
//            ServiceBridge

public static interface 
{

    public abstract void onServiceConnected(int i);

    public abstract void onServiceDisconnected();

    public abstract void onServiceUnavailable();

    public abstract void onServiceFailed();

    public abstract void onServiceInitFailed(int i);

    public abstract void onControllerStateChanged(int i, int j);

    public abstract void onControllerEventPacket(ControllerEventPacket controllereventpacket);

    public abstract void onControllerRecentered(ControllerOrientationEvent controllerorientationevent);

    public abstract void onControllerEventPacket2(ControllerEventPacket2 controllereventpacket2);
}
