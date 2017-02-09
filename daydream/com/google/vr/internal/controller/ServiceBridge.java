// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ServiceBridge.java

package com.google.vr.internal.controller;

import android.content.*;
import android.os.*;
import android.util.Log;
import com.google.vr.vrcore.base.api.VrCoreNotAvailableException;
import com.google.vr.vrcore.base.api.VrCoreUtils;
import com.google.vr.vrcore.controller.api.*;

public class ServiceBridge
    implements ServiceConnection
{
    public static interface Callbacks
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


    public ServiceBridge(Context context1, Callbacks callbacks1)
    {
        context = context1.getApplicationContext();
        callbacks = callbacks1;
    }

    public void setOrientationEnabled(boolean flag)
    {
        options.enableOrientation = flag;
    }

    public void setTouchEnabled(boolean flag)
    {
        options.enableTouch = flag;
    }

    public void setGyroEnabled(boolean flag)
    {
        options.enableGyro = flag;
    }

    public void setAccelEnabled(boolean flag)
    {
        options.enableAccel = flag;
    }

    public void setGesturesEnabled(boolean flag)
    {
        options.enableGestures = flag;
    }

    public void setPositionEnabled(boolean flag)
    {
    }

    public void requestBind()
    {
        mainThreadHandler.post(bindRunnable);
    }

    public void requestUnbind()
    {
        mainThreadHandler.post(unbindRunnable);
    }

    private void doBind()
    {
        ensureOnMainThread();
        if(isBound)
        {
            Log.w(TAG, "Service is already bound.");
            return;
        }
        Intent intent;
        (intent = new Intent("com.google.vr.vrcore.controller.BIND")).setPackage("com.google.vr.vrcore");
        if(!context.bindService(intent, this, 1))
        {
            Log.w(TAG, "Bind failed. Service is not available.");
            callbacks.onServiceUnavailable();
            return;
        } else
        {
            isBound = true;
            return;
        }
    }

    private void unregisterListener()
    {
        if(service == null)
            return;
        service.unregisterListener("com.google.vr.internal.controller.LISTENER_KEY");
        return;
        JVM INSTR dup ;
        RemoteException remoteexception;
        remoteexception;
        printStackTrace();
        Log.w(TAG, "RemoteException while unregistering listener.");
        return;
    }

    private void doUnbind()
    {
        ensureOnMainThread();
        if(!isBound)
        {
            Log.w(TAG, "Service is already unbound.");
            return;
        } else
        {
            unregisterListener();
            context.unbindService(this);
            isBound = false;
            return;
        }
    }

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        ensureOnMainThread();
        service = com.google.vr.vrcore.controller.api.IControllerService.Stub.asInterface(ibinder);
        int i;
        i = service.initialize(11);
        break MISSING_BLOCK_LABEL_56;
        JVM INSTR dup ;
        RemoteException remoteexception;
        remoteexception;
        printStackTrace();
        Log.e(TAG, "Failed to call initialize() on controller service (RemoteException).");
        callbacks.onServiceFailed();
        doUnbind();
        return;
        if(i == 0)
            break MISSING_BLOCK_LABEL_113;
        TAG;
        "initialize() returned error: ";
        String s = String.valueOf(ControllerInitResults.toString(i));
        s;
        if(s.length() == 0) goto _L2; else goto _L1
_L1:
        concat();
          goto _L3
_L2:
        JVM INSTR pop ;
        JVM INSTR new #43  <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
_L3:
        Log.e();
        JVM INSTR pop ;
        callbacks.onServiceInitFailed(i);
        doUnbind();
        return;
        int j;
        if((j = getVrCoreClientApiVersion()) < 0)
        {
            Log.w(TAG, "Failed to get VrCore client API version.");
            callbacks.onServiceFailed();
            doUnbind();
            return;
        }
        int k = 0;
        if(j >= 8)
            k = 1;
        else
            Log.w(TAG, (new StringBuilder(62)).append("Recentering is not supported by VrCore API version ").append(j).toString());
        callbacks.onServiceConnected(k);
        if(!service.registerListener(0, "com.google.vr.internal.controller.LISTENER_KEY", controllerListener))
        {
            Log.w(TAG, "Failed to register listener.");
            callbacks.onServiceFailed();
            doUnbind();
            return;
        }
        return;
        JVM INSTR dup ;
        RemoteException remoteexception1;
        remoteexception1;
        printStackTrace();
        Log.w(TAG, "RemoteException while registering listener.");
        callbacks.onServiceFailed();
        doUnbind();
        return;
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        ensureOnMainThread();
        service = null;
        callbacks.onServiceDisconnected();
    }

    protected int getVrCoreClientApiVersion()
    {
        return VrCoreUtils.getVrCoreClientApiVersion(context);
        VrCoreNotAvailableException vrcorenotavailableexception;
        vrcorenotavailableexception;
        Log.w(TAG, "VrCore not available.", vrcorenotavailableexception);
        return -1;
    }

    private void ensureOnMainThread()
    {
        if(Looper.myLooper() != Looper.getMainLooper())
            throw new IllegalStateException("This should be running on the main thread.");
        else
            return;
    }

    private static final String TAG = com/google/vr/internal/controller/ServiceBridge.getSimpleName();
    private static final boolean DEBUG = false;
    static final int TARGET_SERVICE_API_VERSION = 11;
    static final String LISTENER_KEY = "com.google.vr.internal.controller.LISTENER_KEY";
    private static final int MIN_SERVICE_API_FOR_RECENTERING = 8;
    public static final int FLAG_SUPPORTS_RECENTER = 1;
    private final Context context;
    private final ControllerListenerOptions options = new ControllerListenerOptions();
    private final Handler mainThreadHandler = new Handler(Looper.getMainLooper());
    private IControllerService service;
    private final Callbacks callbacks;
    private boolean isBound;
    private final Runnable bindRunnable = new Runnable() {

        public void run()
        {
            doBind();
        }

        final ServiceBridge this$0;

            
            {
                this$0 = ServiceBridge.this;
                super();
            }
    };
    private final Runnable unbindRunnable = new Runnable() {

        public void run()
        {
            doUnbind();
        }

        final ServiceBridge this$0;

            
            {
                this$0 = ServiceBridge.this;
                super();
            }
    };
    private final IControllerListener controllerListener = new com.google.vr.vrcore.controller.api.IControllerListener.Stub() {

        public int getApiVersion()
            throws RemoteException
        {
            return 11;
        }

        public ControllerListenerOptions getOptions()
            throws RemoteException
        {
            return options;
        }

        public void onControllerStateChanged(int i, int j)
            throws RemoteException
        {
            callbacks.onControllerStateChanged(i, j);
        }

        public void onControllerEventPacket(ControllerEventPacket controllereventpacket)
            throws RemoteException
        {
            callbacks.onControllerEventPacket(controllereventpacket);
            controllereventpacket.recycle();
        }

        public void onControllerEventPacket2(ControllerEventPacket2 controllereventpacket2)
            throws RemoteException
        {
            callbacks.onControllerEventPacket2(controllereventpacket2);
            controllereventpacket2.recycle();
        }

        public void onControllerRecentered(ControllerOrientationEvent controllerorientationevent)
        {
            callbacks.onControllerRecentered(controllerorientationevent);
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
            callbacks.onControllerEventPacket(controllereventpacket);
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
            callbacks.onControllerEventPacket(controllereventpacket);
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
            callbacks.onControllerEventPacket(controllereventpacket);
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
            callbacks.onControllerEventPacket(controllereventpacket);
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
            callbacks.onControllerEventPacket(controllereventpacket);
            controllereventpacket.recycle();
            parcel.recycle();
        }

        final ServiceBridge this$0;

            
            {
                this$0 = ServiceBridge.this;
                super();
            }
    };





}
