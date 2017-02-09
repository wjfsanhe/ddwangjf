// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IVrCreator.java

package com.google.vr.vrcore.library.api;

import android.os.*;

// Referenced classes of package com.google.vr.vrcore.library.api:
//            IObjectWrapper, IVrCreator, IVrNativeLibraryLoader

public static abstract class attachInterface extends Binder
    implements IVrCreator
{
    private static class Proxy
        implements IVrCreator
    {

        public IBinder asBinder()
        {
            return mRemote;
        }

        public String getInterfaceDescriptor()
        {
            return "com.google.vr.vrcore.library.api.IVrCreator";
        }

        public IVrNativeLibraryLoader DEPRECATED_newNativeLibraryLoader(IObjectWrapper iobjectwrapper)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            IVrNativeLibraryLoader ivrnativelibraryloader;
            parcel.writeInterfaceToken("com.google.vr.vrcore.library.api.IVrCreator");
            parcel.writeStrongBinder(iobjectwrapper == null ? null : iobjectwrapper.asBinder());
            mRemote.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            ivrnativelibraryloader = IVrNativeLibraryLoader.Stub.asInterface(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            break MISSING_BLOCK_LABEL_83;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
            return ivrnativelibraryloader;
        }

        public IVrNativeLibraryLoader newNativeLibraryLoader(IObjectWrapper iobjectwrapper, IObjectWrapper iobjectwrapper1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            IVrNativeLibraryLoader ivrnativelibraryloader;
            parcel.writeInterfaceToken("com.google.vr.vrcore.library.api.IVrCreator");
            parcel.writeStrongBinder(iobjectwrapper == null ? null : iobjectwrapper.asBinder());
            parcel.writeStrongBinder(iobjectwrapper1 == null ? null : iobjectwrapper1.asBinder());
            mRemote.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            ivrnativelibraryloader = IVrNativeLibraryLoader.Stub.asInterface(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            break MISSING_BLOCK_LABEL_107;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
            return ivrnativelibraryloader;
        }

        private IBinder mRemote;

        Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    public static IVrCreator asInterface(IBinder ibinder)
    {
        if(ibinder == null)
            return null;
        android.os.IInterface iinterface;
        if((iinterface = ibinder.queryLocalInterface("com.google.vr.vrcore.library.api.IVrCreator")) != null && (iinterface instanceof IVrCreator))
            return (IVrCreator)iinterface;
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
            parcel1.writeString("com.google.vr.vrcore.library.api.IVrCreator");
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.vr.vrcore.library.api.IVrCreator");
            IObjectWrapper iobjectwrapper = tub.asInterface(parcel.readStrongBinder());
            IVrNativeLibraryLoader ivrnativelibraryloader = DEPRECATED_newNativeLibraryLoader(iobjectwrapper);
            parcel1.writeNoException();
            parcel1.writeStrongBinder(ivrnativelibraryloader == null ? null : ivrnativelibraryloader.asBinder());
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.google.vr.vrcore.library.api.IVrCreator");
            IObjectWrapper iobjectwrapper1 = tub.asInterface(parcel.readStrongBinder());
            IObjectWrapper iobjectwrapper2 = tub.asInterface(parcel.readStrongBinder());
            IVrNativeLibraryLoader ivrnativelibraryloader1 = newNativeLibraryLoader(iobjectwrapper1, iobjectwrapper2);
            parcel1.writeNoException();
            parcel1.writeStrongBinder(ivrnativelibraryloader1 == null ? null : ivrnativelibraryloader1.asBinder());
            return true;
        }
        return super.onTransact(i, parcel, parcel1, j);
    }

    private static final String DESCRIPTOR = "com.google.vr.vrcore.library.api.IVrCreator";
    static final int TRANSACTION_DEPRECATED_newNativeLibraryLoader = 3;
    static final int TRANSACTION_newNativeLibraryLoader = 4;

    public Proxy.mRemote()
    {
        attachInterface(this, "com.google.vr.vrcore.library.api.IVrCreator");
    }
}
