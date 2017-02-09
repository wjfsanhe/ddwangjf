// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IVrCoreSdkService.java

package com.google.vr.vrcore.common.api;

import android.content.ComponentName;
import android.os.*;
import com.google.vr.vrcore.logging.api.IVrCoreLoggingService;

// Referenced classes of package com.google.vr.vrcore.common.api:
//            IDaydreamManager, IVrCoreSdkService

private static class mRemote
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
        idaydreammanager = face(parcel1.readStrongBinder());
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
        ivrcoreloggingservice = com.google.vr.vrcore.logging.api.Interface(parcel1.readStrongBinder());
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

    (IBinder ibinder)
    {
        mRemote = ibinder;
    }
}
