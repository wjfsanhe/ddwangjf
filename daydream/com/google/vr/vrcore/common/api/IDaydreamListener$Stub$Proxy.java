// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IDaydreamListener.java

package com.google.vr.vrcore.common.api;

import android.os.*;

// Referenced classes of package com.google.vr.vrcore.common.api:
//            HeadTrackingState, IDaydreamListener

private static class mRemote
    implements IDaydreamListener
{

    public IBinder asBinder()
    {
        return mRemote;
    }

    public String getInterfaceDescriptor()
    {
        return "com.google.vr.vrcore.common.api.IDaydreamListener";
    }

    public int getTargetApiVersion()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamListener");
        mRemote.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        break MISSING_BLOCK_LABEL_61;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
        return i;
    }

    public HeadTrackingState requestStopTracking()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        HeadTrackingState headtrackingstate;
        parcel.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamListener");
        mRemote.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        if(0 != parcel1.readInt())
            headtrackingstate = (HeadTrackingState)HeadTrackingState.CREATOR.Parcel(parcel1);
        else
            headtrackingstate = null;
        parcel1.recycle();
        parcel.recycle();
        break MISSING_BLOCK_LABEL_82;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
        return headtrackingstate;
    }

    public void applyFade(int i, long l)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamListener");
        parcel.writeInt(i);
        parcel.writeLong(l);
        mRemote.transact(3, parcel, null, 1);
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        throw exception;
    }

    public void recenterHeadTracking()
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamListener");
        mRemote.transact(4, parcel, null, 1);
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        throw exception;
    }

    public void dumpDebugData()
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamListener");
        mRemote.transact(5, parcel, null, 1);
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        throw exception;
    }

    public void resumeHeadTracking(HeadTrackingState headtrackingstate)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamListener");
        if(headtrackingstate != null)
        {
            parcel.writeInt(1);
            headtrackingstate.writeToParcel(parcel, 0);
        } else
        {
            parcel.writeInt(0);
        }
        mRemote.transact(6, parcel, null, 1);
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
