// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ControllerManager.java

package com.google.vr.sdk.controller;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.graphics.PointF;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.vr.vrcore.base.api.VrCoreNotAvailableException;
import com.google.vr.vrcore.base.api.VrCoreUtils;
import com.google.vr.vrcore.controller.api.*;

// Referenced classes of package com.google.vr.sdk.controller:
//            ControllerManager, Controller

private class this._cls0
{

    public void handleTouchEvent(ControllerTouchEvent event)
    {
        synchronized(ControllerManager.access$300(ControllerManager.this))
        {
            ControllerManager.access$300(ControllerManager.this).timestamp = event.timestampNanos;
            ControllerManager.access$300(ControllerManager.this).touch.x = event.x;
            ControllerManager.access$300(ControllerManager.this).touch.y = event.y;
            switch(event.action)
            {
            case 1: // '\001'
            case 2: // '\002'
                ControllerManager.access$300(ControllerManager.this).isTouching = true;
                break;

            case 0: // '\0'
            case 3: // '\003'
            case 4: // '\004'
                ControllerManager.access$300(ControllerManager.this).isTouching = false;
                break;

            default:
                Log.w("ControllerManager", String.format(".handleTouchEvent didn't handle %d", new Object[] {
                    Integer.valueOf(event.action)
                }));
                break;
            }
        }
    }

    public void handleOrientationEvent(ControllerOrientationEvent event)
    {
        synchronized(ControllerManager.access$300(ControllerManager.this))
        {
            ControllerManager.access$300(ControllerManager.this).timestamp = event.timestampNanos;
            ControllerManager.access$300(ControllerManager.this).setOrientationInSensorSpace(event.qx, event.qy, event.qz, event.qw);
            ControllerManager.access$600(ControllerManager.this).notifyUpdate();
        }
    }

    public void handleButtonEvent(ControllerButtonEvent event)
    {
        synchronized(ControllerManager.access$300(ControllerManager.this))
        {
            ControllerManager.access$300(ControllerManager.this).timestamp = event.timestampNanos;
            switch(event.button)
            {
            case 3: // '\003'
                ControllerManager.access$300(ControllerManager.this).appButtonState = event.down;
                break;

            case 1: // '\001'
                ControllerManager.access$300(ControllerManager.this).clickButtonState = event.down;
                break;

            case 2: // '\002'
                if(ControllerManager.access$300(ControllerManager.this).setHomeButtonState(event.down))
                    ControllerManager.access$500(ControllerManager.this).ed();
                break;

            case 5: // '\005'
                ControllerManager.access$300(ControllerManager.this).volumeUpButtonState = event.down;
                break;

            case 6: // '\006'
                ControllerManager.access$300(ControllerManager.this).volumeDownButtonState = event.down;
                break;

            case 4: // '\004'
            default:
                Log.w("ControllerManager", String.format("onControllerButtonEvent didn't handle %d", new Object[] {
                    Integer.valueOf(event.button)
                }));
                break;
            }
        }
    }

    public void handlePositionEvent(ControllerPositionEvent event)
    {
        synchronized(ControllerManager.access$300(ControllerManager.this))
        {
            ControllerManager.access$300(ControllerManager.this).timestamp = event.timestampNanos;
            ControllerManager.access$300(ControllerManager.this).position[0] = event.x;
            ControllerManager.access$300(ControllerManager.this).position[1] = event.y;
            ControllerManager.access$300(ControllerManager.this).position[2] = event.z;
            ControllerManager.access$600(ControllerManager.this).notifyUpdate();
        }
    }

    public void onControllerRecentered(ControllerOrientationEvent event)
    {
        handleOrientationEvent(event);
        ControllerManager.access$500(ControllerManager.this).ed();
    }

    public void notifyConnectionStateChange(int newState)
    {
        ControllerManager.access$600(ControllerManager.this).notifyConnectionStateChange(newState);
    }

    final ControllerManager this$0;

    private ()
    {
        this$0 = ControllerManager.this;
        super();
    }


    // Unreferenced inner class com/google/vr/sdk/controller/ControllerManager$1

/* anonymous class */
    class ControllerManager._cls1
        implements ServiceConnection
    {

        public void onServiceConnected(ComponentName componentName, IBinder binder)
        {
            ControllerManager.access$102(ControllerManager.this, com.google.vr.vrcore.controller.api.IControllerService.Stub.asInterface(binder));
            try
            {
                int initResult = ControllerManager.access$100(ControllerManager.this).initialize(11);
                int connectionState;
                switch(initResult)
                {
                case 0: // '\0'
                    connectionState = 0;
                    break;

                case 1: // '\001'
                    connectionState = 1;
                    break;

                case 2: // '\002'
                    connectionState = 2;
                    break;

                case 3: // '\003'
                    connectionState = 5;
                    break;

                default:
                    connectionState = 5;
                    break;
                }
                if(connectionState == 0)
                    ControllerManager.access$100(ControllerManager.this).registerListener(0, "com.google.vr.cardboard.controller.ControllerManager", ControllerManager.access$200(ControllerManager.this));
                else
                    Log.e("ControllerManager", String.format(".onServiceConnected %d, %d", new Object[] {
                        Integer.valueOf(initResult), Integer.valueOf(connectionState)
                    }));
                try
                {
                    ControllerManager.access$300(ControllerManager.this).enableRecenterShim = VrCoreUtils.getVrCoreClientApiVersion(ControllerManager.access$400(ControllerManager.this)) < 8;
                }
                catch(VrCoreNotAvailableException e)
                {
                    Log.e("ControllerManager", "Unable to set Controller.enableRecenterShim: ", e);
                }
                ControllerManager.access$500(ControllerManager.this).onApiStatusChanged(connectionState);
            }
            catch(RemoteException e)
            {
                Log.e("ControllerManager", "Initialization failed: ", e);
                ControllerManager.access$500(ControllerManager.this).onApiStatusChanged(3);
                stop();
            }
        }

        public void onServiceDisconnected(ComponentName componentName)
        {
            Log.e("ControllerManager", ".onServiceDisconnected");
            ControllerManager.access$102(ControllerManager.this, null);
            ControllerManager.access$500(ControllerManager.this).onApiStatusChanged(3);
        }

        final ControllerManager this$0;

            
            {
                this.this$0 = ControllerManager.this;
                super();
            }
    }

}
