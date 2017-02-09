// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IVrNativeLibraryLoader.java

package com.google.vr.vrcore.library.api;

import android.os.*;

// Referenced classes of package com.google.vr.vrcore.library.api:
//            IVrNativeLibraryLoader

public static abstract class attachInterface extends Binder
    implements IVrNativeLibraryLoader
{
    private static class Proxy
        implements IVrNativeLibraryLoader
    {

        public IBinder asBinder()
        {
            return mRemote;
        }

        public String getInterfaceDescriptor()
        {
            return "com.google.vr.vrcore.library.api.IVrNativeLibraryLoader";
        }

        public long loadNativeGvrLibrary(int i, int j, int k)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            long l;
            parcel.writeInterfaceToken("com.google.vr.vrcore.library.api.IVrNativeLibraryLoader");
            parcel.writeInt(i);
            parcel.writeInt(j);
            parcel.writeInt(k);
            mRemote.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            l = parcel1.readLong();
            parcel1.recycle();
            parcel.recycle();
            break MISSING_BLOCK_LABEL_91;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
            return l;
        }

        public void closeNativeGvrLibrary(long l)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.vr.vrcore.library.api.IVrNativeLibraryLoader");
            parcel.writeLong(l);
            mRemote.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        private IBinder mRemote;

        Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    public static IVrNativeLibraryLoader asInterface(IBinder ibinder)
    {
        if(ibinder == null)
            return null;
        android.os.IInterface iinterface;
        if((iinterface = ibinder.queryLocalInterface("com.google.vr.vrcore.library.api.IVrNativeLibraryLoader")) != null && (iinterface instanceof IVrNativeLibraryLoader))
            return (IVrNativeLibraryLoader)iinterface;
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
            parcel1.writeString("com.google.vr.vrcore.library.api.IVrNativeLibraryLoader");
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.vr.vrcore.library.api.IVrNativeLibraryLoader");
            int k = parcel.readInt();
            int i1 = parcel.readInt();
            int j1 = parcel.readInt();
            long l1 = loadNativeGvrLibrary(k, i1, j1);
            parcel1.writeNoException();
            parcel1.writeLong(l1);
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.vr.vrcore.library.api.IVrNativeLibraryLoader");
            long l = parcel.readLong();
            closeNativeGvrLibrary(l);
            parcel1.writeNoException();
            return true;
        }
        return super.onTransact(i, parcel, parcel1, j);
    }

    private static final String DESCRIPTOR = "com.google.vr.vrcore.library.api.IVrNativeLibraryLoader";
    static final int TRANSACTION_loadNativeGvrLibrary = 2;
    static final int TRANSACTION_closeNativeGvrLibrary = 3;

    public Proxy.mRemote()
    {
        attachInterface(this, "com.google.vr.vrcore.library.api.IVrNativeLibraryLoader");
    }
}
