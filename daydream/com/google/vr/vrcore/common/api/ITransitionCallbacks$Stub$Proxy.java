// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ITransitionCallbacks.java

package com.google.vr.vrcore.common.api;

import android.os.*;

// Referenced classes of package com.google.vr.vrcore.common.api:
//            ITransitionCallbacks

private static class mRemote
    implements ITransitionCallbacks
{

    public IBinder asBinder()
    {
        return mRemote;
    }

    public String getInterfaceDescriptor()
    {
        return "com.google.vr.vrcore.common.api.ITransitionCallbacks";
    }

    public void onTransitionComplete()
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.vr.vrcore.common.api.ITransitionCallbacks");
        mRemote.transact(1, parcel, null, 1);
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
