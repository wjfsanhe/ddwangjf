// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IVrCoreSdkService.java

package com.google.vr.vrcore.common.api;

import android.content.ComponentName;
import android.os.*;
import com.google.vr.vrcore.logging.api.IVrCoreLoggingService;

// Referenced classes of package com.google.vr.vrcore.common.api:
//            IDaydreamManager

public interface IVrCoreSdkService
    extends IInterface
{
    public static abstract class Stub extends Binder
        implements IVrCoreSdkService
    {
        private static class Proxy
            implements IVrCoreSdkService
        {

            public IBinder asBinder()
            {
                return mRemote;
            }

            public String getInterfaceDescriptor()
            {
                return "com.google.vr.vrcore.common.api.IVrCoreSdkService";
            }

            public boolean initialize(int i)
                throws RemoteException
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                boolean flag;
                parcel.writeInterfaceToken("com.google.vr.vrcore.common.api.IVrCoreSdkService");
                parcel.writeInt(i);
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                flag = 0 != parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                break MISSING_BLOCK_LABEL_76;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                return flag;
            }

            public IDaydreamManager getDaydreamManager()
                throws RemoteException
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IDaydreamManager idaydreammanager;
                parcel.writeInterfaceToken("com.google.vr.vrcore.common.api.IVrCoreSdkService");
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                idaydreammanager = IDaydreamManager.Stub.asInterface(parcel1.readStrongBinder());
                parcel1.recycle();
                parcel.recycle();
                break MISSING_BLOCK_LABEL_64;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                return idaydreammanager;
            }

            public boolean setClientOptions(ComponentName componentname, Bundle bundle)
                throws RemoteException
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                boolean flag;
                parcel.writeInterfaceToken("com.google.vr.vrcore.common.api.IVrCoreSdkService");
                if(componentname != null)
                {
                    parcel.writeInt(1);
                    componentname.writeToParcel(parcel, 0);
                } else
                {
                    parcel.writeInt(0);
                }
                if(bundle != null)
                {
                    parcel.writeInt(1);
                    bundle.writeToParcel(parcel, 0);
                } else
                {
                    parcel.writeInt(0);
                }
                mRemote.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                flag = 0 != parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                break MISSING_BLOCK_LABEL_123;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                return flag;
            }

            public IVrCoreLoggingService getLoggingService()
                throws RemoteException
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                IVrCoreLoggingService ivrcoreloggingservice;
                parcel.writeInterfaceToken("com.google.vr.vrcore.common.api.IVrCoreSdkService");
                mRemote.transact(4, parcel, parcel1, 0);
                parcel1.readException();
                ivrcoreloggingservice = com.google.vr.vrcore.logging.api.IVrCoreLoggingService.Stub.asInterface(parcel1.readStrongBinder());
                parcel1.recycle();
                parcel.recycle();
                break MISSING_BLOCK_LABEL_64;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                return ivrcoreloggingservice;
            }

            private IBinder mRemote;

            Proxy(IBinder ibinder)
            {
                mRemote = ibinder;
            }
        }


        public static IVrCoreSdkService asInterface(IBinder ibinder)
        {
            if(ibinder == null)
                return null;
            IInterface iinterface;
            if((iinterface = ibinder.queryLocalInterface("com.google.vr.vrcore.common.api.IVrCoreSdkService")) != null && (iinterface instanceof IVrCoreSdkService))
                return (IVrCoreSdkService)iinterface;
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
                parcel1.writeString("com.google.vr.vrcore.common.api.IVrCoreSdkService");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.vr.vrcore.common.api.IVrCoreSdkService");
                int k = parcel.readInt();
                boolean flag = initialize(k);
                parcel1.writeNoException();
                parcel1.writeInt(flag ? 1 : 0);
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.vr.vrcore.common.api.IVrCoreSdkService");
                IDaydreamManager idaydreammanager = getDaydreamManager();
                parcel1.writeNoException();
                parcel1.writeStrongBinder(idaydreammanager == null ? null : idaydreammanager.asBinder());
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.vr.vrcore.common.api.IVrCoreSdkService");
                ComponentName componentname;
                if(0 != parcel.readInt())
                    componentname = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
                else
                    componentname = null;
                Bundle bundle;
                if(0 != parcel.readInt())
                    bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                else
                    bundle = null;
                boolean flag1 = setClientOptions(componentname, bundle);
                parcel1.writeNoException();
                parcel1.writeInt(flag1 ? 1 : 0);
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.google.vr.vrcore.common.api.IVrCoreSdkService");
                IVrCoreLoggingService ivrcoreloggingservice = getLoggingService();
                parcel1.writeNoException();
                parcel1.writeStrongBinder(ivrcoreloggingservice == null ? null : ivrcoreloggingservice.asBinder());
                return true;
            }
            return super.onTransact(i, parcel, parcel1, j);
        }

        private static final String DESCRIPTOR = "com.google.vr.vrcore.common.api.IVrCoreSdkService";
        static final int TRANSACTION_initialize = 1;
        static final int TRANSACTION_getDaydreamManager = 2;
        static final int TRANSACTION_setClientOptions = 3;
        static final int TRANSACTION_getLoggingService = 4;

        public Stub()
        {
            attachInterface(this, "com.google.vr.vrcore.common.api.IVrCoreSdkService");
        }
    }


    public abstract boolean initialize(int i)
        throws RemoteException;

    public abstract IDaydreamManager getDaydreamManager()
        throws RemoteException;

    public abstract boolean setClientOptions(ComponentName componentname, Bundle bundle)
        throws RemoteException;

    public abstract IVrCoreLoggingService getLoggingService()
        throws RemoteException;
}
