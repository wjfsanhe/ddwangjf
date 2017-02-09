// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CardboardEmulator.java

package com.google.vr.ndk.base;

import android.content.Context;
import com.google.vr.cardboard.ThreadUtils;
import com.google.vr.internal.controller.ServiceBridge;
import com.google.vr.vrcore.controller.api.*;

class CardboardEmulator
{
    private static class ControllerCallbacks
        implements com.google.vr.internal.controller.ServiceBridge.Callbacks
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

        ControllerCallbacks(Runnable runnable)
        {
            cardboardTriggerCallback = runnable;
        }
    }


    public CardboardEmulator(Context context, Runnable runnable)
    {
        controllerServiceBridge = createServiceBridge(context, new ControllerCallbacks(runnable));
        controllerServiceBridge.setOrientationEnabled(false);
        controllerServiceBridge.setGyroEnabled(false);
        controllerServiceBridge.setAccelEnabled(false);
        controllerServiceBridge.setTouchEnabled(false);
        controllerServiceBridge.setGesturesEnabled(false);
    }

    public void onResume()
    {
        if(!resumed)
        {
            resumed = true;
            controllerServiceBridge.requestBind();
        }
    }

    public void onPause()
    {
        if(resumed)
        {
            resumed = false;
            controllerServiceBridge.requestUnbind();
        }
    }

    protected ServiceBridge createServiceBridge(Context context, com.google.vr.internal.controller.ServiceBridge.Callbacks callbacks)
    {
        return new ServiceBridge(context, callbacks);
    }

    private static final String TAG = com/google/vr/ndk/base/CardboardEmulator.getSimpleName();
    private static final boolean DEBUG = false;
    private final ServiceBridge controllerServiceBridge;
    private boolean resumed;

}
