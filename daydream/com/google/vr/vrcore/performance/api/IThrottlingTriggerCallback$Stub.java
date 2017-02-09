// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IThrottlingTriggerCallback.java

package com.google.vr.vrcore.performance.api;

import android.os.*;

// Referenced classes of package com.google.vr.vrcore.performance.api:
//            IThrottlingTriggerCallback

public static abstract class attachInterface extends Binder
    implements IThrottlingTriggerCallback
{
    private static class Proxy
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

        Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    public static IThrottlingTriggerCallback asInterface(IBinder ibinder)
    {
        if(ibinder == null)
            return null;
        android.os.IInterface iinterface;
        if((iinterface = ibinder.queryLocalInterface("com.google.vr.vrcore.performance.api.IThrottlingTriggerCallback")) != null && (iinterface instanceof IThrottlingTriggerCallback))
            return (IThrottlingTriggerCallback)iinterface;
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
            parcel1.writeString("com.google.vr.vrcore.performance.api.IThrottlingTriggerCallback");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.vr.vrcore.performance.api.IThrottlingTriggerCallback");
            float f = parcel.readFloat();
            long l = parcel.readLong();
            onTriggerActivated(f, l);
            return true;
        }
        return super.onTransact(i, parcel, parcel1, j);
    }

    private static final String DESCRIPTOR = "com.google.vr.vrcore.performance.api.IThrottlingTriggerCallback";
    static final int TRANSACTION_onTriggerActivated = 1;

    public Proxy.mRemote()
    {
        attachInterface(this, "com.google.vr.vrcore.performance.api.IThrottlingTriggerCallback");
    }
}
