// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ControllerManager.java

package com.google.vr.sdk.controller;

import android.content.*;
import android.graphics.PointF;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.vr.vrcore.base.api.VrCoreNotAvailableException;
import com.google.vr.vrcore.base.api.VrCoreUtils;
import com.google.vr.vrcore.controller.api.*;
import java.lang.ref.WeakReference;

// Referenced classes of package com.google.vr.sdk.controller:
//            Controller

public class ControllerManager
{
    private class InnerControllerListener
    {

        public void handleTouchEvent(ControllerTouchEvent event)
        {
            synchronized(currentControllerState)
            {
                currentControllerState.timestamp = event.timestampNanos;
                currentControllerState.touch.x = event.x;
                currentControllerState.touch.y = event.y;
                switch(event.action)
                {
                case 1: // '\001'
                case 2: // '\002'
                    currentControllerState.isTouching = true;
                    break;

                case 0: // '\0'
                case 3: // '\003'
                case 4: // '\004'
                    currentControllerState.isTouching = false;
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
            synchronized(currentControllerState)
            {
                currentControllerState.timestamp = event.timestampNanos;
                currentControllerState.setOrientationInSensorSpace(event.qx, event.qy, event.qz, event.qw);
                controller.notifyUpdate();
            }
        }

        public void handleButtonEvent(ControllerButtonEvent event)
        {
            synchronized(currentControllerState)
            {
                currentControllerState.timestamp = event.timestampNanos;
                switch(event.button)
                {
                case 3: // '\003'
                    currentControllerState.appButtonState = event.down;
                    break;

                case 1: // '\001'
                    currentControllerState.clickButtonState = event.down;
                    break;

                case 2: // '\002'
                    if(currentControllerState.setHomeButtonState(event.down))
                        serviceEventListener.onRecentered();
                    break;

                case 5: // '\005'
                    currentControllerState.volumeUpButtonState = event.down;
                    break;

                case 6: // '\006'
                    currentControllerState.volumeDownButtonState = event.down;
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
            synchronized(currentControllerState)
            {
                currentControllerState.timestamp = event.timestampNanos;
                currentControllerState.position[0] = event.x;
                currentControllerState.position[1] = event.y;
                currentControllerState.position[2] = event.z;
                controller.notifyUpdate();
            }
        }

        public void onControllerRecentered(ControllerOrientationEvent event)
        {
            handleOrientationEvent(event);
            serviceEventListener.onRecentered();
        }

        public void notifyConnectionStateChange(int newState)
        {
            controller.notifyConnectionStateChange(newState);
        }

        final ControllerManager this$0;

        private InnerControllerListener()
        {
            this$0 = ControllerManager.this;
            super();
        }

    }

    private static class OuterControllerListener extends com.google.vr.vrcore.controller.api.IControllerListener.Stub
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
            InnerControllerListener innerCopy = (InnerControllerListener)inner.get();
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
            InnerControllerListener innerCopy = (InnerControllerListener)inner.get();
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
            InnerControllerListener innerCopy = (InnerControllerListener)inner.get();
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

        private void handleEventsBackwardCompatible(ControllerEventPacket eventPacket, InnerControllerListener innerCopy)
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
            InnerControllerListener innerCopy = (InnerControllerListener)inner.get();
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
            InnerControllerListener innerCopy = (InnerControllerListener)inner.get();
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
            InnerControllerListener innerCopy = (InnerControllerListener)inner.get();
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
            InnerControllerListener innerCopy = (InnerControllerListener)inner.get();
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

        public OuterControllerListener(InnerControllerListener inner)
        {
            this.inner = new WeakReference(inner);
        }
    }

    public static class ApiStatus
    {

        public static final String toString(int state)
        {
            switch(state)
            {
            case 0: // '\0'
                return "OK";

            case 1: // '\001'
                return "ERROR_UNSUPPORTED";

            case 2: // '\002'
                return "ERROR_NOT_AUTHORIZED";

            case 3: // '\003'
                return "ERROR_UNAVAILABLE";

            case 4: // '\004'
                return "ERROR_SERVICE_OBSOLETE";

            case 5: // '\005'
                return "ERROR_CLIENT_OBSOLETE";

            case 6: // '\006'
                return "ERROR_MALFUNCTION";
            }
            return (new StringBuilder(58)).append("[UNKNOWN CONTROLLER MANAGER CONNECTION STATE: ").append(state).append("]").toString();
        }

        public static final int OK = 0;
        public static final int ERROR_UNSUPPORTED = 1;
        public static final int ERROR_NOT_AUTHORIZED = 2;
        public static final int ERROR_UNAVAILABLE = 3;
        public static final int ERROR_SERVICE_OBSOLETE = 4;
        public static final int ERROR_CLIENT_OBSOLETE = 5;
        public static final int ERROR_MALFUNCTION = 6;

        private ApiStatus()
        {
        }
    }

    public static interface EventListener
    {

        public abstract void onApiStatusChanged(int i);

        public abstract void onRecentered();
    }


    public ControllerManager(Context context, EventListener listener)
    {
        outerControllerListener = new OuterControllerListener(innerControllerListener);
        this.context = context;
        serviceEventListener = listener;
        bindIntent.setPackage("com.google.vr.vrcore");
    }

    public void start()
    {
        if(controllerService != null)
            return;
        if(!context.bindService(bindIntent, serviceConnection, 1))
            serviceEventListener.onApiStatusChanged(3);
    }

    public void stop()
    {
        if(controllerService == null)
            return;
        String s;
        try
        {
            controllerService.unregisterListener("com.google.vr.cardboard.controller.ControllerManager");
        }
        catch(RemoteException e)
        {
            Log.w("ControllerManager", (new StringBuilder(27 + String.valueOf(s = String.valueOf(e)).length())).append("unregisterListener failed: ").append(s).toString());
        }
        context.unbindService(serviceConnection);
        controllerService = null;
    }

    public Controller getController()
    {
        return controller;
    }

    void updateController(Controller controller)
    {
        synchronized(currentControllerState)
        {
            if(controller.timestamp != currentControllerState.timestamp)
                controller.setPublicState(currentControllerState);
        }
    }

    private static final String TAG = "ControllerManager";
    private static final boolean DEBUG = false;
    public static final int SERVICE_TARGET_API_VERSION = 11;
    private static final String LISTENER_KEY = "com.google.vr.cardboard.controller.ControllerManager";
    private final Intent bindIntent = new Intent("com.google.vr.vrcore.controller.BIND");
    private final EventListener serviceEventListener;
    private final Context context;
    private IControllerService controllerService;
    private final InnerControllerListener innerControllerListener = new InnerControllerListener();
    private final OuterControllerListener outerControllerListener;
    private final Controller currentControllerState = new Controller(null);
    private final Controller controller = new Controller(this);
    private final ServiceConnection serviceConnection = new ServiceConnection() {

        public void onServiceConnected(ComponentName componentName, IBinder binder)
        {
            controllerService = com.google.vr.vrcore.controller.api.IControllerService.Stub.asInterface(binder);
            try
            {
                int initResult = controllerService.initialize(11);
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
                    controllerService.registerListener(0, "com.google.vr.cardboard.controller.ControllerManager", outerControllerListener);
                else
                    Log.e("ControllerManager", String.format(".onServiceConnected %d, %d", new Object[] {
                        Integer.valueOf(initResult), Integer.valueOf(connectionState)
                    }));
                try
                {
                    currentControllerState.enableRecenterShim = VrCoreUtils.getVrCoreClientApiVersion(context) < 8;
                }
                catch(VrCoreNotAvailableException e)
                {
                    Log.e("ControllerManager", "Unable to set Controller.enableRecenterShim: ", e);
                }
                serviceEventListener.onApiStatusChanged(connectionState);
            }
            catch(RemoteException e)
            {
                Log.e("ControllerManager", "Initialization failed: ", e);
                serviceEventListener.onApiStatusChanged(3);
                stop();
            }
        }

        public void onServiceDisconnected(ComponentName componentName)
        {
            Log.e("ControllerManager", ".onServiceDisconnected");
            controllerService = null;
            serviceEventListener.onApiStatusChanged(3);
        }

        final ControllerManager this$0;

            
            {
                this.this$0 = ControllerManager.this;
                super();
            }
    };







}
