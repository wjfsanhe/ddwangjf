// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IVrCreator.java

package com.google.vr.vrcore.library.api;

import android.os.*;

// Referenced classes of package com.google.vr.vrcore.library.api:
//            IObjectWrapper, IVrCreator, IVrNativeLibraryLoader

private static class mRemote
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
        ivrnativelibraryloader = .Stub.asInterface(parcel1.readStrongBinder());
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
        ivrnativelibraryloader = .Stub.asInterface(parcel1.readStrongBinder());
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

    (IBinder ibinder)
    {
        mRemote = ibinder;
    }
}
