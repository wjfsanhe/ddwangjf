// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CardboardEmulator.java

package com.google.vr.ndk.base;

import com.google.vr.cardboard.ThreadUtils;
import com.google.vr.internal.controller.ServiceBridge;
import com.google.vr.vrcore.controller.api.*;

// Referenced classes of package com.google.vr.ndk.base:
//            CardboardEmulator

private static class cardboardTriggerCallback
    implements com.google.vr.internal.controller.iggerCallback
{

    public void onServiceConnected(int i)
    {
    }

    public void onServiceDisconnected()
    {
    }

    public void onServiceUnavailable()
    {
    }

    public void onServiceFailed()
    {
    }

    public void onServiceInitFailed(int i)
    {
    }

    public void onControllerStateChanged(int i, int j)
    {
    }

    public void onControllerEventPacket(ControllerEventPacket controllereventpacket)
    {
        for(int i = 0; i < controllereventpacket.getButtonEventCount(); i++)
        {
            ControllerButtonEvent controllerbuttonevent;
            if((controllerbuttonevent = controllereventpacket.getButtonEvent(i)).down)
                switch(controllerbuttonevent.button)
                {
                case 1: // '\001'
                case 3: // '\003'
                    ThreadUtils.runOnUiThread(cardboardTriggerCallback);
                    break;
                }
        }

    }

    public void onControllerRecentered(ControllerOrientationEvent controllerorientationevent)
    {
    }

    public void onControllerEventPacket2(ControllerEventPacket2 controllereventpacket2)
    {
        onControllerEventPacket(controllereventpacket2);
    }

    private final Runnable cardboardTriggerCallback;

    t(Runnable runnable)
    {
        cardboardTriggerCallback = runnable;
    }
}
