// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ControllerManager.java

package com.google.vr.sdk.controller;

import android.os.RemoteException;
import com.google.vr.vrcore.controller.api.*;
import java.lang.ref.WeakReference;

// Referenced classes of package com.google.vr.sdk.controller:
//            ControllerManager

private static class inner extends com.google.vr.vrcore.controller.api.
{

    public int getApiVersion()
        throws RemoteException
    {
        return 11;
    }

    public ControllerListenerOptions getOptions()
        throws RemoteException
    {
        return null;
    }

    public void onControllerStateChanged(int controllerId, int newState)
        throws RemoteException
    {
        String stateString = ControllerStates.toString(newState);
        inner innerCopy = (inner)inner.get();
        if(innerCopy == null)
        {
            return;
        } else
        {
            innerCopy.notifyConnectionStateChange(newState);
            return;
        }
    }

    public void onControllerEventPacket2(ControllerEventPacket2 eventPacket)
        throws RemoteException
    {
        notifyConnectionStateChange innerCopy = (notifyConnectionStateChange)inner.get();
        if(innerCopy == null)
            return;
        handleEventsBackwardCompatible(eventPacket, innerCopy);
        for(int i = 0; i < eventPacket.getPositionEventCount(); i++)
            innerCopy.handlePositionEvent(eventPacket.getPositionEvent(i));

        eventPacket.recycle();
    }

    public void onControllerEventPacket(ControllerEventPacket eventPacket)
        throws RemoteException
    {
        vent innerCopy = (vent)inner.get();
        if(innerCopy == null)
        {
            return;
        } else
        {
            handleEventsBackwardCompatible(eventPacket, innerCopy);
            eventPacket.recycle();
            return;
        }
    }

    private void handleEventsBackwardCompatible(ControllerEventPacket eventPacket, handleEventsBackwardCompatible innerCopy)
    {
        for(int i = 0; i < eventPacket.getButtonEventCount(); i++)
            innerCopy.handleButtonEvent(eventPacket.getButtonEvent(i));

        for(int i = 0; i < eventPacket.getOrientationEventCount(); i++)
            innerCopy.handleOrientationEvent(eventPacket.getOrientationEvent(i));

        for(int i = 0; i < eventPacket.getTouchEventCount(); i++)
            innerCopy.handleTouchEvent(eventPacket.getTouchEvent(i));

    }

    public void onControllerRecentered(ControllerOrientationEvent event)
    {
         innerCopy = ()inner.get();
        if(innerCopy == null)
        {
            return;
        } else
        {
            innerCopy.onControllerRecentered(event);
            return;
        }
    }

    public boolean deprecatedOnControllerButtonEventV1(ControllerButtonEvent event)
    {
        return true;
    }

    public void deprecatedOnControllerAccelEvent(ControllerAccelEvent controlleraccelevent)
    {
    }

    public void deprecatedOnControllerButtonEvent(ControllerButtonEvent event)
    {
        onControllerRecentered innerCopy = (onControllerRecentered)inner.get();
        if(innerCopy == null)
        {
            return;
        } else
        {
            innerCopy.handleButtonEvent(event);
            return;
        }
    }

    public void deprecatedOnControllerGyroEvent(ControllerGyroEvent controllergyroevent)
    {
    }

    public void deprecatedOnControllerOrientationEvent(ControllerOrientationEvent event)
    {
        handleButtonEvent innerCopy = (handleButtonEvent)inner.get();
        if(innerCopy == null)
        {
            return;
        } else
        {
            innerCopy.handleOrientationEvent(event);
            return;
        }
    }

    public void deprecatedOnControllerTouchEvent(ControllerTouchEvent event)
    {
        handleOrientationEvent innerCopy = (handleOrientationEvent)inner.get();
        if(innerCopy == null)
        {
            return;
        } else
        {
            innerCopy.handleTouchEvent(event);
            return;
        }
    }

    private final WeakReference inner;

    public ( inner)
    {
        this.inner = new WeakReference(inner);
    }
}
