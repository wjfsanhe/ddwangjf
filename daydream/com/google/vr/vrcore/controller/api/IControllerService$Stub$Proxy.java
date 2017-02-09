// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IControllerService.java

package com.google.vr.vrcore.controller.api;

import android.os.*;

// Referenced classes of package com.google.vr.vrcore.controller.api:
//            IControllerListener, IControllerService

private static class mRemote
    implements IControllerService
{

    public IBinder asBinder()
    {
        return mRemote;
    }

    public String getInterfaceDescriptor()
    {
        return "com.google.vr.vrcore.controller.api.IControllerService";
    }

    public int initialize(int i)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int j;
        parcel.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerService");
        parcel.writeInt(i);
        mRemote.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        j = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        break MISSING_BLOCK_LABEL_67;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
        return j;
    }

    public boolean registerListener(int i, String s, IControllerListener icontrollerlistener)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        boolean flag;
        parcel.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerService");
        parcel.writeInt(i);
        parcel.writeString(s);
        parcel.writeStrongBinder(icontrollerlistener == null ? null : icontrollerlistener.asBinder());
        mRemote.transact(5, parcel, parcel1, 0);
        parcel1.readException();
        flag = 0 != parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        break MISSING_BLOCK_LABEL_113;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
        return flag;
    }

    public boolean unregisterListener(String s)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        boolean flag;
        parcel.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerService");
        parcel.writeString(s);
        mRemote.transact(6, parcel, parcel1, 0);
        parcel1.readException();
        flag = 0 != parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        break MISSING_BLOCK_LABEL_77;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
        return flag;
    }

    private IBinder mRemote;

    (IBinder ibinder)
    {
        mRemote = ibinder;
    }
}
