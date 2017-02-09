// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IPerformanceService.java

package com.google.vr.vrcore.performance.api;

import android.content.ComponentName;
import android.os.*;

// Referenced classes of package com.google.vr.vrcore.performance.api:
//            TimestampedTemperature, IThrottlingTriggerCallback

public interface IPerformanceService
    extends IInterface
{
    public static abstract class Stub extends Binder
        implements IPerformanceService
    {
        private static class Proxy
            implements IPerformanceService
        {

            public IBinder asBinder()
            {
                return mRemote;
            }

            public String getInterfaceDescriptor()
            {
                return "com.google.vr.vrcore.performance.api.IPerformanceService";
            }

            public void getCurrentThrottlingRelativeTemperature(TimestampedTemperature timestampedtemperature)
                throws RemoteException
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.vr.vrcore.performance.api.IPerformanceService");
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                if(0 != parcel1.readInt())
                    timestampedtemperature.readFromParcel(parcel1);
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public long getCurrentEstimatedThrottleWarningTime()
                throws RemoteException
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                long l;
                parcel.writeInterfaceToken("com.google.vr.vrcore.performance.api.IPerformanceService");
                mRemote.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                l = parcel1.readLong();
                parcel1.recycle();
                parcel.recycle();
                break MISSING_BLOCK_LABEL_61;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                return l;
            }

            public void addTrigger(ComponentName componentname, IThrottlingTriggerCallback ithrottlingtriggercallback, long l, float f, int i)
                throws RemoteException
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.vr.vrcore.performance.api.IPerformanceService");
                if(componentname != null)
                {
                    parcel.writeInt(1);
                    componentname.writeToParcel(parcel, 0);
                } else
                {
                    parcel.writeInt(0);
                }
                parcel.writeStrongBinder(ithrottlingtriggercallback == null ? null : ithrottlingtriggercallback.asBinder());
                parcel.writeLong(l);
                parcel.writeFloat(f);
                parcel.writeInt(i);
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

            public void removeAllTriggers(ComponentName componentname)
                throws RemoteException
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.vr.vrcore.performance.api.IPerformanceService");
                if(componentname != null)
                {
                    parcel.writeInt(1);
                    componentname.writeToParcel(parcel, 0);
                } else
                {
                    parcel.writeInt(0);
                }
                mRemote.transact(4, parcel, parcel1, 0);
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

            Proxy(IBinder ibinder)
            {
                mRemote = ibinder;
            }
        }


        public static IPerformanceService asInterface(IBinder ibinder)
        {
            if(ibinder == null)
                return null;
            IInterface iinterface;
            if((iinterface = ibinder.queryLocalInterface("com.google.vr.vrcore.performance.api.IPerformanceService")) != null && (iinterface instanceof IPerformanceService))
                return (IPerformanceService)iinterface;
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
                parcel1.writeString("com.google.vr.vrcore.performance.api.IPerformanceService");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.vr.vrcore.performance.api.IPerformanceService");
                TimestampedTemperature timestampedtemperature = new TimestampedTemperature();
                getCurrentThrottlingRelativeTemperature(timestampedtemperature);
                parcel1.writeNoException();
                parcel1.writeInt(1);
                timestampedtemperature.writeToParcel(parcel1, 1);
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.vr.vrcore.performance.api.IPerformanceService");
                long l = getCurrentEstimatedThrottleWarningTime();
                parcel1.writeNoException();
                parcel1.writeLong(l);
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.vr.vrcore.performance.api.IPerformanceService");
                ComponentName componentname;
                if(0 != parcel.readInt())
                    componentname = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
                else
                    componentname = null;
                IThrottlingTriggerCallback ithrottlingtriggercallback = IThrottlingTriggerCallback.Stub.asInterface(parcel.readStrongBinder());
                long l1 = parcel.readLong();
                float f = parcel.readFloat();
                int k = parcel.readInt();
                addTrigger(componentname, ithrottlingtriggercallback, l1, f, k);
                parcel1.writeNoException();
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.google.vr.vrcore.performance.api.IPerformanceService");
                ComponentName componentname1;
                if(0 != parcel.readInt())
                    componentname1 = (ComponentName)ComponentName.CREATOR.createFromParcel(parcel);
                else
                    componentname1 = null;
                removeAllTriggers(componentname1);
                parcel1.writeNoException();
                return true;
            }
            return super.onTransact(i, parcel, parcel1, j);
        }

        private static final String DESCRIPTOR = "com.google.vr.vrcore.performance.api.IPerformanceService";
        static final int TRANSACTION_getCurrentThrottlingRelativeTemperature = 1;
        static final int TRANSACTION_getCurrentEstimatedThrottleWarningTime = 2;
        static final int TRANSACTION_addTrigger = 3;
        static final int TRANSACTION_removeAllTriggers = 4;

        public Stub()
        {
            attachInterface(this, "com.google.vr.vrcore.performance.api.IPerformanceService");
        }
    }


    public abstract void getCurrentThrottlingRelativeTemperature(TimestampedTemperature timestampedtemperature)
        throws RemoteException;

    public abstract long getCurrentEstimatedThrottleWarningTime()
        throws RemoteException;

    public abstract void addTrigger(ComponentName componentname, IThrottlingTriggerCallback ithrottlingtriggercallback, long l, float f, int i)
        throws RemoteException;

    public abstract void removeAllTriggers(ComponentName componentname)
        throws RemoteException;
}
