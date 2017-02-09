// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ControllerManager.java

package com.google.vr.sdk.controller;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.vr.vrcore.base.api.VrCoreNotAvailableException;
import com.google.vr.vrcore.base.api.VrCoreUtils;
import com.google.vr.vrcore.controller.api.IControllerService;

// Referenced classes of package com.google.vr.sdk.controller:
//            ControllerManager, Controller

class this._cls0
    implements ServiceConnection
{

    public void onServiceConnected(ComponentName componentName, IBinder binder)
    {
        ControllerManager.access$102(ControllerManager.this, com.google.vr.vrcore.controller.api.tub.asInterface(binder));
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

    xception()
    {
        this.this$0 = ControllerManager.this;
        super();
    }
}
