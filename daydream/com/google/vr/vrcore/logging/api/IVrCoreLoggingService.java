// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IVrCoreLoggingService.java

package com.google.vr.vrcore.logging.api;

import android.os.*;

// Referenced classes of package com.google.vr.vrcore.logging.api:
//            VREventParcelable

public interface IVrCoreLoggingService
    extends IInterface
{
    public static abstract class Stub extends Binder
        implements IVrCoreLoggingService
    {
        private static class Proxy
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

            Proxy(IBinder ibinder)
            {
                mRemote = ibinder;
            }
        }


        public static IVrCoreLoggingService asInterface(IBinder ibinder)
        {
            if(ibinder == null)
                return null;
            IInterface iinterface;
            if((iinterface = ibinder.queryLocalInterface("com.google.vr.vrcore.logging.api.IVrCoreLoggingService")) != null && (iinterface instanceof IVrCoreLoggingService))
                return (IVrCoreLoggingService)iinterface;
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
                parcel1.writeString("com.google.vr.vrcore.logging.api.IVrCoreLoggingService");
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.vr.vrcore.logging.api.IVrCoreLoggingService");
                VREventParcelable vreventparcelable;
                if(0 != parcel.readInt())
                    vreventparcelable = (VREventParcelable)VREventParcelable.CREATOR.createFromParcel(parcel);
                else
                    vreventparcelable = null;
                log(vreventparcelable);
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.vr.vrcore.logging.api.IVrCoreLoggingService");
                VREventParcelable avreventparcelable[] = (VREventParcelable[])parcel.createTypedArray(VREventParcelable.CREATOR);
                logBatched(avreventparcelable);
                return true;
            }
            return super.onTransact(i, parcel, parcel1, j);
        }

        private static final String DESCRIPTOR = "com.google.vr.vrcore.logging.api.IVrCoreLoggingService";
        static final int TRANSACTION_log = 2;
        static final int TRANSACTION_logBatched = 3;

        public Stub()
        {
            attachInterface(this, "com.google.vr.vrcore.logging.api.IVrCoreLoggingService");
        }
    }


    public abstract void log(VREventParcelable vreventparcelable)
        throws RemoteException;

    public abstract void logBatched(VREventParcelable avreventparcelable[])
        throws RemoteException;
}
