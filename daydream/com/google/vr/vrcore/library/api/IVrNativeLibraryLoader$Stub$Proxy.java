// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IVrNativeLibraryLoader.java

package com.google.vr.vrcore.library.api;

import android.os.*;

// Referenced classes of package com.google.vr.vrcore.library.api:
//            IVrNativeLibraryLoader

private static class mRemote
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

    (IBinder ibinder)
    {
        mRemote = ibinder;
    }
}
