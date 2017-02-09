// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IThrottlingTriggerCallback.java

package com.google.vr.vrcore.performance.api;

import android.os.*;

// Referenced classes of package com.google.vr.vrcore.performance.api:
//            IThrottlingTriggerCallback

private static class mRemote
    implements IThrottlingTriggerCallback
{

    public IBinder asBinder()
    {
        return mRemote;
    }

    public String getInterfaceDescriptor()
    {
        return "com.google.vr.vrcore.performance.api.IThrottlingTriggerCallback";
    }

    public void onTriggerActivated(float f, long l)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.vr.vrcore.performance.api.IThrottlingTriggerCallback");
        parcel.writeFloat(f);
        parcel.writeLong(l);
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
