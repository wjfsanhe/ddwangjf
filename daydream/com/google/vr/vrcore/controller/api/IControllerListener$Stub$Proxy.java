// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IControllerListener.java

package com.google.vr.vrcore.controller.api;

import android.os.*;

// Referenced classes of package com.google.vr.vrcore.controller.api:
//            ControllerAccelEvent, ControllerButtonEvent, ControllerEventPacket, ControllerEventPacket2, 
//            ControllerGyroEvent, ControllerListenerOptions, ControllerOrientationEvent, ControllerTouchEvent, 
//            IControllerListener

private static class mRemote
    implements IControllerListener
{

    public IBinder asBinder()
    {
        return mRemote;
    }

    public String getInterfaceDescriptor()
    {
        return "com.google.vr.vrcore.controller.api.IControllerListener";
    }

    public int getApiVersion()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
        mRemote.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        break MISSING_BLOCK_LABEL_61;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
        return i;
    }

    public void onControllerStateChanged(int i, int j)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
        parcel.writeInt(i);
        parcel.writeInt(j);
        mRemote.transact(2, parcel, null, 1);
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        throw exception;
    }

    public void deprecatedOnControllerTouchEvent(ControllerTouchEvent controllertouchevent)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
        if(controllertouchevent != null)
        {
            parcel.writeInt(1);
            controllertouchevent.writeToParcel(parcel, 0);
        } else
        {
            parcel.writeInt(0);
        }
        mRemote.transact(3, parcel, null, 1);
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        throw exception;
    }

    public void deprecatedOnControllerOrientationEvent(ControllerOrientationEvent controllerorientationevent)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
        if(controllerorientationevent != null)
        {
            parcel.writeInt(1);
            controllerorientationevent.writeToParcel(parcel, 0);
        } else
        {
            parcel.writeInt(0);
        }
        mRemote.transact(4, parcel, null, 1);
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        throw exception;
    }

    public boolean deprecatedOnControllerButtonEventV1(ControllerButtonEvent controllerbuttonevent)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        boolean flag;
        parcel.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
        if(controllerbuttonevent != null)
        {
            parcel.writeInt(1);
            controllerbuttonevent.writeToParcel(parcel, 0);
        } else
        {
            parcel.writeInt(0);
        }
        mRemote.transact(5, parcel, parcel1, 0);
        parcel1.readException();
        flag = 0 != parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        break MISSING_BLOCK_LABEL_94;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
        return flag;
    }

    public void deprecatedOnControllerButtonEvent(ControllerButtonEvent controllerbuttonevent)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
        if(controllerbuttonevent != null)
        {
            parcel.writeInt(1);
            controllerbuttonevent.writeToParcel(parcel, 0);
        } else
        {
            parcel.writeInt(0);
        }
        mRemote.transact(6, parcel, null, 1);
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        throw exception;
    }

    public void deprecatedOnControllerAccelEvent(ControllerAccelEvent controlleraccelevent)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
        if(controlleraccelevent != null)
        {
            parcel.writeInt(1);
            controlleraccelevent.writeToParcel(parcel, 0);
        } else
        {
            parcel.writeInt(0);
        }
        mRemote.transact(7, parcel, null, 1);
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        throw exception;
    }

    public void deprecatedOnControllerGyroEvent(ControllerGyroEvent controllergyroevent)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
        if(controllergyroevent != null)
        {
            parcel.writeInt(1);
            controllergyroevent.writeToParcel(parcel, 0);
        } else
        {
            parcel.writeInt(0);
        }
        mRemote.transact(8, parcel, null, 1);
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        throw exception;
    }

    public ControllerListenerOptions getOptions()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        ControllerListenerOptions controllerlisteneroptions;
        parcel.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
        mRemote.transact(9, parcel, parcel1, 0);
        parcel1.readException();
        if(0 != parcel1.readInt())
            controllerlisteneroptions = (ControllerListenerOptions)ControllerListenerOptions.CREATOR.rcel(parcel1);
        else
            controllerlisteneroptions = null;
        parcel1.recycle();
        parcel.recycle();
        break MISSING_BLOCK_LABEL_83;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
        return controllerlisteneroptions;
    }

    public void onControllerEventPacket(ControllerEventPacket controllereventpacket)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
        if(controllereventpacket != null)
        {
            parcel.writeInt(1);
            controllereventpacket.writeToParcel(parcel, 0);
        } else
        {
            parcel.writeInt(0);
        }
        mRemote.transact(10, parcel, null, 1);
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        throw exception;
    }

    public void onControllerRecentered(ControllerOrientationEvent controllerorientationevent)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
        if(controllerorientationevent != null)
        {
            parcel.writeInt(1);
            controllerorientationevent.writeToParcel(parcel, 0);
        } else
        {
            parcel.writeInt(0);
        }
        mRemote.transact(11, parcel, null, 1);
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        throw exception;
    }

    public void onControllerEventPacket2(ControllerEventPacket2 controllereventpacket2)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
        if(controllereventpacket2 != null)
        {
            parcel.writeInt(1);
            controllereventpacket2.writeToParcel(parcel, 0);
        } else
        {
            parcel.writeInt(0);
        }
        mRemote.transact(12, parcel, null, 1);
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        throw exception;
    }

    private IBinder mRemote;

    (IBinder ibinder)
    {
        mRemote = ibinder;
    }
}
