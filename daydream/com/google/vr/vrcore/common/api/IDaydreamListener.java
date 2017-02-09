// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IDaydreamListener.java

package com.google.vr.vrcore.common.api;

import android.os.*;

// Referenced classes of package com.google.vr.vrcore.common.api:
//            HeadTrackingState

public interface IDaydreamListener
    extends IInterface
{
    public static abstract class Stub extends Binder
        implements IDaydreamListener
    {
        private static class Proxy
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
                    headtrackingstate = (HeadTrackingState)HeadTrackingState.CREATOR.createFromParcel(parcel1);
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

            Proxy(IBinder ibinder)
            {
                mRemote = ibinder;
            }
        }


        public static IDaydreamListener asInterface(IBinder ibinder)
        {
            if(ibinder == null)
                return null;
            IInterface iinterface;
            if((iinterface = ibinder.queryLocalInterface("com.google.vr.vrcore.common.api.IDaydreamListener")) != null && (iinterface instanceof IDaydreamListener))
                return (IDaydreamListener)iinterface;
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
                parcel1.writeString("com.google.vr.vrcore.common.api.IDaydreamListener");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamListener");
                int k = getTargetApiVersion();
                parcel1.writeNoException();
                parcel1.writeInt(k);
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamListener");
                HeadTrackingState headtrackingstate = requestStopTracking();
                parcel1.writeNoException();
                if(headtrackingstate != null)
                {
                    parcel1.writeInt(1);
                    headtrackingstate.writeToParcel(parcel1, 1);
                } else
                {
                    parcel1.writeInt(0);
                }
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamListener");
                int l = parcel.readInt();
                long l1 = parcel.readLong();
                applyFade(l, l1);
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamListener");
                recenterHeadTracking();
                return true;

            case 5: // '\005'
                parcel.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamListener");
                dumpDebugData();
                return true;

            case 6: // '\006'
                parcel.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamListener");
                HeadTrackingState headtrackingstate1;
                if(0 != parcel.readInt())
                    headtrackingstate1 = (HeadTrackingState)HeadTrackingState.CREATOR.createFromParcel(parcel);
                else
                    headtrackingstate1 = null;
                resumeHeadTracking(headtrackingstate1);
                return true;
            }
            return super.onTransact(i, parcel, parcel1, j);
        }

        private static final String DESCRIPTOR = "com.google.vr.vrcore.common.api.IDaydreamListener";
        static final int TRANSACTION_getTargetApiVersion = 1;
        static final int TRANSACTION_requestStopTracking = 2;
        static final int TRANSACTION_applyFade = 3;
        static final int TRANSACTION_recenterHeadTracking = 4;
        static final int TRANSACTION_dumpDebugData = 5;
        static final int TRANSACTION_resumeHeadTracking = 6;

        public Stub()
        {
            attachInterface(this, "com.google.vr.vrcore.common.api.IDaydreamListener");
        }
    }


    public abstract int getTargetApiVersion()
        throws RemoteException;

    public abstract HeadTrackingState requestStopTracking()
        throws RemoteException;

    public abstract void applyFade(int i, long l)
        throws RemoteException;

    public abstract void recenterHeadTracking()
        throws RemoteException;

    public abstract void dumpDebugData()
        throws RemoteException;

    public abstract void resumeHeadTracking(HeadTrackingState headtrackingstate)
        throws RemoteException;
}
