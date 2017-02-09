// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ITransitionCallbacks.java

package com.google.vr.vrcore.common.api;

import android.os.*;

// Referenced classes of package com.google.vr.vrcore.common.api:
//            ITransitionCallbacks

public static abstract class attachInterface extends Binder
    implements ITransitionCallbacks
{
    private static class Proxy
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

        Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    public static ITransitionCallbacks asInterface(IBinder ibinder)
    {
        if(ibinder == null)
            return null;
        android.os.IInterface iinterface;
        if((iinterface = ibinder.queryLocalInterface("com.google.vr.vrcore.common.api.ITransitionCallbacks")) != null && (iinterface instanceof ITransitionCallbacks))
            return (ITransitionCallbacks)iinterface;
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
            parcel1.writeString("com.google.vr.vrcore.common.api.ITransitionCallbacks");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.vr.vrcore.common.api.ITransitionCallbacks");
            onTransitionComplete();
            return true;
        }
        return super.onTransact(i, parcel, parcel1, j);
    }

    private static final String DESCRIPTOR = "com.google.vr.vrcore.common.api.ITransitionCallbacks";
    static final int TRANSACTION_onTransitionComplete = 1;

    public Proxy.mRemote()
    {
        attachInterface(this, "com.google.vr.vrcore.common.api.ITransitionCallbacks");
    }
}
