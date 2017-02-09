// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   NativeCallbacks.java

package com.google.vr.internal.controller;

import com.google.vr.vrcore.controller.api.*;

// Referenced classes of package com.google.vr.internal.controller:
//            ServiceBridge

public final class NativeCallbacks
    implements ServiceBridge.Callbacks
{

    public NativeCallbacks(long l)
    {
        userData = l;
    }

    public final synchronized void close()
    {
        closed = true;
    }

    public final synchronized void onControllerStateChanged(int i, int j)
    {
        if(!closed)
            handleStateChanged(userData, i, j);
    }

    public final synchronized void onControllerEventPacket(ControllerEventPacket controllereventpacket)
    {
        if(closed)
        {
            return;
        } else
        {
            handleEventsCompatibilityLocked(controllereventpacket);
            return;
        }
    }

    public final synchronized void onControllerEventPacket2(ControllerEventPacket2 controllereventpacket2)
    {
        if(closed)
            return;
        handleEventsCompatibilityLocked(controllereventpacket2);
        for(int i = 0; !closed && i < controllereventpacket2.getPositionEventCount(); i++)
        {
            ControllerPositionEvent controllerpositionevent = controllereventpacket2.getPositionEvent(i);
            handlePositionEvent(userData, controllerpositionevent.timestampNanos, controllerpositionevent.x, controllerpositionevent.y, controllerpositionevent.z);
        }

    }

    private final void handleEventsCompatibilityLocked(ControllerEventPacket controllereventpacket)
    {
        for(int i = 0; !closed && i < controllereventpacket.getAccelEventCount(); i++)
        {
            ControllerAccelEvent controlleraccelevent = controllereventpacket.getAccelEvent(i);
            handleAccelEvent(userData, controlleraccelevent.timestampNanos, controlleraccelevent.x, controlleraccelevent.y, controlleraccelevent.z);
        }

        for(int j = 0; !closed && j < controllereventpacket.getButtonEventCount(); j++)
        {
            ControllerButtonEvent controllerbuttonevent = controllereventpacket.getButtonEvent(j);
            handleButtonEvent(userData, controllerbuttonevent.timestampNanos, controllerbuttonevent.button, controllerbuttonevent.down);
        }

        for(int k = 0; !closed && k < controllereventpacket.getGyroEventCount(); k++)
        {
            ControllerGyroEvent controllergyroevent = controllereventpacket.getGyroEvent(k);
            handleGyroEvent(userData, controllergyroevent.timestampNanos, controllergyroevent.x, controllergyroevent.y, controllergyroevent.z);
        }

        for(int l = 0; !closed && l < controllereventpacket.getOrientationEventCount(); l++)
        {
            ControllerOrientationEvent controllerorientationevent = controllereventpacket.getOrientationEvent(l);
            handleOrientationEvent(userData, controllerorientationevent.timestampNanos, controllerorientationevent.qx, controllerorientationevent.qy, controllerorientationevent.qz, controllerorientationevent.qw);
        }

        for(int i1 = 0; !closed && i1 < controllereventpacket.getTouchEventCount(); i1++)
        {
            ControllerTouchEvent controllertouchevent = controllereventpacket.getTouchEvent(i1);
            handleTouchEvent(userData, controllertouchevent.timestampNanos, controllertouchevent.action, controllertouchevent.x, controllertouchevent.y);
        }

    }

    public final synchronized void onControllerRecentered(ControllerOrientationEvent controllerorientationevent)
    {
        if(!closed)
            handleControllerRecentered(userData, controllerorientationevent.timestampNanos, controllerorientationevent.qx, controllerorientationevent.qy, controllerorientationevent.qz, controllerorientationevent.qw);
    }

    public final synchronized void onServiceConnected(int i)
    {
        if(!closed)
            handleServiceConnected(userData, i);
    }

    public final synchronized void onServiceDisconnected()
    {
        if(!closed)
            handleServiceDisconnected(userData);
    }

    public final synchronized void onServiceFailed()
    {
        if(!closed)
            handleServiceFailed(userData);
    }

    public final synchronized void onServiceUnavailable()
    {
        if(!closed)
            handleServiceUnavailable(userData);
    }

    public final synchronized void onServiceInitFailed(int i)
    {
        if(!closed)
            handleServiceInitFailed(userData, i);
    }

    private final native void handleStateChanged(long l, int i, int j);

    private final native void handleControllerRecentered(long l, long l1, float f, float f1, float f2, 
            float f3);

    private final native void handleTouchEvent(long l, long l1, int i, float f, float f1);

    private final native void handleOrientationEvent(long l, long l1, float f, float f1, float f2, 
            float f3);

    private final native void handleButtonEvent(long l, long l1, int i, boolean flag);

    private final native void handleAccelEvent(long l, long l1, float f, float f1, float f2);

    private final native void handleGyroEvent(long l, long l1, float f, float f1, float f2);

    private final native void handleServiceInitFailed(long l, int i);

    private final native void handleServiceFailed(long l);

    private final native void handleServiceUnavailable(long l);

    private final native void handleServiceConnected(long l, int i);

    private final native void handleServiceDisconnected(long l);

    private final native void handlePositionEvent(long l, long l1, float f, float f1, float f2);

    private final long userData;
    private boolean closed;
}
