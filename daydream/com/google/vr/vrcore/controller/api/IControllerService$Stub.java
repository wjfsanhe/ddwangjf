// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IControllerService.java

package com.google.vr.vrcore.controller.api;

import android.os.*;

// Referenced classes of package com.google.vr.vrcore.controller.api:
//            IControllerListener, IControllerService

public static abstract class attachInterface extends Binder
    implements IControllerService
{
    private static class Proxy
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

        Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    public static IControllerService asInterface(IBinder ibinder)
    {
        if(ibinder == null)
            return null;
        android.os.IInterface iinterface;
        if((iinterface = ibinder.queryLocalInterface("com.google.vr.vrcore.controller.api.IControllerService")) != null && (iinterface instanceof IControllerService))
            return (IControllerService)iinterface;
        else
            return new Proxy(ibinder);
    }

    public IBinder asBinder()
    {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        throws RemoteException
    {
        switch(i)
        {
        case 1598968902: 
            parcel1.writeString("com.google.vr.vrcore.controller.api.IControllerService");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.vr.vrcore.controller.api.IControllerService");
            int k = parcel.readInt();
            int i1 = initialize(k);
            parcel1.writeNoException();
            parcel1.writeInt(i1);
            return true;

        case 5: // '\005'
            parcel.enforceInterface("com.google.vr.vrcore.controller.api.IControllerService");
            int l = parcel.readInt();
            String s1 = parcel.readString();
            IControllerListener icontrollerlistener = .asInterface(parcel.readStrongBinder());
            boolean flag1 = registerListener(l, s1, icontrollerlistener);
            parcel1.writeNoException();
            parcel1.writeInt(flag1 ? 1 : 0);
            return true;

        case 6: // '\006'
            parcel.enforceInterface("com.google.vr.vrcore.controller.api.IControllerService");
            String s = parcel.readString();
            boolean flag = unregisterListener(s);
            parcel1.writeNoException();
            parcel1.writeInt(flag ? 1 : 0);
            return true;
        }
        return super.onTransact(i, parcel, parcel1, j);
    }

    private static final String DESCRIPTOR = "com.google.vr.vrcore.controller.api.IControllerService";
    static final int TRANSACTION_initialize = 1;
    static final int TRANSACTION_registerListener = 5;
    static final int TRANSACTION_unregisterListener = 6;

    public Proxy.mRemote()
    {
        attachInterface(this, "com.google.vr.vrcore.controller.api.IControllerService");
    }
}
