// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IObjectWrapper.java

package com.google.vr.vrcore.library.api;

import android.os.*;

public interface IObjectWrapper
    extends IInterface
{
    public static abstract class Stub extends Binder
        implements IObjectWrapper
    {
        private static class Proxy
            implements IObjectWrapper
        {

            public IBinder asBinder()
            {
                return mRemote;
            }

            public String getInterfaceDescriptor()
            {
                return "com.google.vr.vrcore.library.api.IObjectWrapper";
            }

            private IBinder mRemote;

            Proxy(IBinder ibinder)
            {
                mRemote = ibinder;
            }
        }


        public static IObjectWrapper asInterface(IBinder ibinder)
        {
            if(ibinder == null)
                return null;
            IInterface iinterface;
            if((iinterface = ibinder.queryLocalInterface("com.google.vr.vrcore.library.api.IObjectWrapper")) != null && (iinterface instanceof IObjectWrapper))
                return (IObjectWrapper)iinterface;
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
                parcel1.writeString("com.google.vr.vrcore.library.api.IObjectWrapper");
                return true;
            }
            return super.onTransact(i, parcel, parcel1, j);
        }

        private static final String DESCRIPTOR = "com.google.vr.vrcore.library.api.IObjectWrapper";

        public Stub()
        {
            attachInterface(this, "com.google.vr.vrcore.library.api.IObjectWrapper");
        }
    }

}
