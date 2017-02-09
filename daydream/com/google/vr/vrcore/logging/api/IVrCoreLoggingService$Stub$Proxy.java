// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IVrCoreLoggingService.java

package com.google.vr.vrcore.logging.api;

import android.os.*;

// Referenced classes of package com.google.vr.vrcore.logging.api:
//            IVrCoreLoggingService, VREventParcelable

private static class mRemote
    implements IVrCoreLoggingService
{

    public IBinder asBinder()
    {
        return mRemote;
    }

    public String getInterfaceDescriptor()
    {
        return "com.google.vr.vrcore.logging.api.IVrCoreLoggingService";
    }

    public void log(VREventParcelable vreventparcelable)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.vr.vrcore.logging.api.IVrCoreLoggingService");
        if(vreventparcelable != null)
        {
            parcel.writeInt(1);
            vreventparcelable.writeToParcel(parcel, 0);
        } else
        {
            parcel.writeInt(0);
        }
        mRemote.transact(2, parcel, null, 1);
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        throw exception;
    }

    public void logBatched(VREventParcelable avreventparcelable[])
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.vr.vrcore.logging.api.IVrCoreLoggingService");
        parcel.writeTypedArray(avreventparcelable, 0);
        mRemote.transact(3, parcel, null, 1);
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
