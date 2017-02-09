// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IPerformanceService.java

package com.google.vr.vrcore.performance.api;

import android.content.ComponentName;
import android.os.*;

// Referenced classes of package com.google.vr.vrcore.performance.api:
//            IPerformanceService, IThrottlingTriggerCallback, TimestampedTemperature

private static class mRemote
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

    I(IBinder ibinder)
    {
        mRemote = ibinder;
    }
}
