// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IDaydreamManager.java

package com.google.vr.vrcore.common.api;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.os.*;

// Referenced classes of package com.google.vr.vrcore.common.api:
//            HeadTrackingState, IDaydreamListener, IDaydreamManager, ITransitionCallbacks

public static abstract class attachInterface extends Binder
    implements IDaydreamManager
{
    private static class Proxy
        implements IDaydreamManager
    {

        public IBinder asBinder()
        {
            return mRemote;
        }

        public String getInterfaceDescriptor()
        {
            return "com.google.vr.vrcore.common.api.IDaydreamManager";
        }

        public boolean registerListener(ComponentName componentname, IDaydreamListener idaydreamlistener)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            boolean flag;
            parcel.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamManager");
            if(componentname != null)
            {
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
            } else
            {
                parcel.writeInt(0);
            }
            parcel.writeStrongBinder(idaydreamlistener == null ? null : idaydreamlistener.asBinder());
            mRemote.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            flag = 0 != parcel1.readInt();
            parcel1.recycle();
            parcel.recycle();
            break MISSING_BLOCK_LABEL_118;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
            return flag;
        }

        public boolean unregisterListener(ComponentName componentname)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            boolean flag;
            parcel.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamManager");
            if(componentname != null)
            {
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
            } else
            {
                parcel.writeInt(0);
            }
            mRemote.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            flag = 0 != parcel1.readInt();
            parcel1.recycle();
            parcel.recycle();
            break MISSING_BLOCK_LABEL_94;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
            return flag;
        }

        public int prepareVr(ComponentName componentname, HeadTrackingState headtrackingstate)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i;
            parcel.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamManager");
            if(componentname != null)
            {
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
            } else
            {
                parcel.writeInt(0);
            }
            mRemote.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            i = parcel1.readInt();
            if(0 != parcel1.readInt())
                headtrackingstate.readFromParcel(parcel1);
            parcel1.recycle();
            parcel.recycle();
            break MISSING_BLOCK_LABEL_106;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
            return i;
        }

        public boolean deprecatedLaunchInVr(PendingIntent pendingintent)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            boolean flag;
            parcel.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamManager");
            if(pendingintent != null)
            {
                parcel.writeInt(1);
                pendingintent.writeToParcel(parcel, 0);
            } else
            {
                parcel.writeInt(0);
            }
            mRemote.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            flag = 0 != parcel1.readInt();
            parcel1.recycle();
            parcel.recycle();
            break MISSING_BLOCK_LABEL_94;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
            return flag;
        }

        public void registerDaydreamIntent(PendingIntent pendingintent)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamManager");
            if(pendingintent != null)
            {
                parcel.writeInt(1);
                pendingintent.writeToParcel(parcel, 0);
            } else
            {
                parcel.writeInt(0);
            }
            mRemote.transact(5, parcel, null, 1);
            parcel.recycle();
            return;
            Exception exception;
            exception;
            parcel.recycle();
            throw exception;
        }

        public void unregisterDaydreamIntent()
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamManager");
            mRemote.transact(6, parcel, null, 1);
            parcel.recycle();
            return;
            Exception exception;
            exception;
            parcel.recycle();
            throw exception;
        }

        public boolean launchInVr(PendingIntent pendingintent, ComponentName componentname)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            boolean flag;
            parcel.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamManager");
            if(pendingintent != null)
            {
                parcel.writeInt(1);
                pendingintent.writeToParcel(parcel, 0);
            } else
            {
                parcel.writeInt(0);
            }
            if(componentname != null)
            {
                parcel.writeInt(1);
                componentname.writeToParcel(parcel, 0);
            } else
            {
                parcel.writeInt(0);
            }
            mRemote.transact(7, parcel, parcel1, 0);
            parcel1.readException();
            flag = 0 != parcel1.readInt();
            parcel1.recycle();
            parcel.recycle();
            break MISSING_BLOCK_LABEL_124;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
            return flag;
        }

        public boolean launchVrHome()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            boolean flag;
            parcel.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamManager");
            mRemote.transact(8, parcel, parcel1, 0);
            parcel1.readException();
            flag = 0 != parcel1.readInt();
            parcel1.recycle();
            parcel.recycle();
            break MISSING_BLOCK_LABEL_71;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
            return flag;
        }

        public boolean launchVrTransition(ITransitionCallbacks itransitioncallbacks)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            boolean flag;
            parcel.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamManager");
            parcel.writeStrongBinder(itransitioncallbacks == null ? null : itransitioncallbacks.asBinder());
            mRemote.transact(9, parcel, parcel1, 0);
            parcel1.readException();
            flag = 0 != parcel1.readInt();
            parcel1.recycle();
            parcel.recycle();
            break MISSING_BLOCK_LABEL_90;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
            return flag;
        }

        public boolean exitFromVr(PendingIntent pendingintent)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            boolean flag;
            parcel.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamManager");
            if(pendingintent != null)
            {
                parcel.writeInt(1);
                pendingintent.writeToParcel(parcel, 0);
            } else
            {
                parcel.writeInt(0);
            }
            mRemote.transact(10, parcel, parcel1, 0);
            parcel1.readException();
            flag = 0 != parcel1.readInt();
            parcel1.recycle();
            parcel.recycle();
            break MISSING_BLOCK_LABEL_95;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
            return flag;
        }

        public void handleInsertionIntoHeadset(byte abyte0[])
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamManager");
            parcel.writeByteArray(abyte0);
            mRemote.transact(11, parcel, null, 1);
            parcel.recycle();
            return;
            Exception exception;
            exception;
            parcel.recycle();
            throw exception;
        }

        public void handleRemovalFromHeadset()
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.vr.vrcore.common.api.IDaydreamManager");
            mRemote.transact(12, parcel, null, 1);
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


    public static IDaydreamManager asInterface(IBinder ibinder)
    {
        if(ibinder == null)
            return null;
        android.os.IInterface iinterface;
        if((iinterface = ibinder.queryLocalInterface("com.google.vr.vrcore.common.api.IDaydreamManager")) != null && (iinterface instanceof IDaydreamManager))
            return (IDaydreamManager)iinterface;
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
            parcel1.writeString("com.google.vr.vrcore.common.api.IDaydreamManager");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamManager");
            ComponentName componentname;
            if(0 != parcel.readInt())
                componentname = (ComponentName)ComponentName.CREATOR.ateFromParcel(parcel);
            else
                componentname = null;
            IDaydreamListener idaydreamlistener = .asInterface(parcel.readStrongBinder());
            boolean flag5 = registerListener(componentname, idaydreamlistener);
            parcel1.writeNoException();
            parcel1.writeInt(flag5 ? 1 : 0);
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamManager");
            ComponentName componentname1;
            if(0 != parcel.readInt())
                componentname1 = (ComponentName)ComponentName.CREATOR.ateFromParcel(parcel);
            else
                componentname1 = null;
            boolean flag1 = unregisterListener(componentname1);
            parcel1.writeNoException();
            parcel1.writeInt(flag1 ? 1 : 0);
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamManager");
            ComponentName componentname2;
            if(0 != parcel.readInt())
                componentname2 = (ComponentName)ComponentName.CREATOR.ateFromParcel(parcel);
            else
                componentname2 = null;
            HeadTrackingState headtrackingstate = new HeadTrackingState();
            int k = prepareVr(componentname2, headtrackingstate);
            parcel1.writeNoException();
            parcel1.writeInt(k);
            parcel1.writeInt(1);
            headtrackingstate.writeToParcel(parcel1, 1);
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamManager");
            PendingIntent pendingintent;
            if(0 != parcel.readInt())
                pendingintent = (PendingIntent)PendingIntent.CREATOR.ateFromParcel(parcel);
            else
                pendingintent = null;
            boolean flag2 = deprecatedLaunchInVr(pendingintent);
            parcel1.writeNoException();
            parcel1.writeInt(flag2 ? 1 : 0);
            return true;

        case 5: // '\005'
            parcel.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamManager");
            PendingIntent pendingintent1;
            if(0 != parcel.readInt())
                pendingintent1 = (PendingIntent)PendingIntent.CREATOR.ateFromParcel(parcel);
            else
                pendingintent1 = null;
            registerDaydreamIntent(pendingintent1);
            return true;

        case 6: // '\006'
            parcel.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamManager");
            unregisterDaydreamIntent();
            return true;

        case 7: // '\007'
            parcel.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamManager");
            PendingIntent pendingintent2;
            if(0 != parcel.readInt())
                pendingintent2 = (PendingIntent)PendingIntent.CREATOR.ateFromParcel(parcel);
            else
                pendingintent2 = null;
            ComponentName componentname3;
            if(0 != parcel.readInt())
                componentname3 = (ComponentName)ComponentName.CREATOR.ateFromParcel(parcel);
            else
                componentname3 = null;
            boolean flag6 = launchInVr(pendingintent2, componentname3);
            parcel1.writeNoException();
            parcel1.writeInt(flag6 ? 1 : 0);
            return true;

        case 8: // '\b'
            parcel.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamManager");
            boolean flag = launchVrHome();
            parcel1.writeNoException();
            parcel1.writeInt(flag ? 1 : 0);
            return true;

        case 9: // '\t'
            parcel.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamManager");
            ITransitionCallbacks itransitioncallbacks = tub.asInterface(parcel.readStrongBinder());
            boolean flag3 = launchVrTransition(itransitioncallbacks);
            parcel1.writeNoException();
            parcel1.writeInt(flag3 ? 1 : 0);
            return true;

        case 10: // '\n'
            parcel.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamManager");
            PendingIntent pendingintent3;
            if(0 != parcel.readInt())
                pendingintent3 = (PendingIntent)PendingIntent.CREATOR.ateFromParcel(parcel);
            else
                pendingintent3 = null;
            boolean flag4 = exitFromVr(pendingintent3);
            parcel1.writeNoException();
            parcel1.writeInt(flag4 ? 1 : 0);
            return true;

        case 11: // '\013'
            parcel.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamManager");
            byte abyte0[] = parcel.createByteArray();
            handleInsertionIntoHeadset(abyte0);
            return true;

        case 12: // '\f'
            parcel.enforceInterface("com.google.vr.vrcore.common.api.IDaydreamManager");
            handleRemovalFromHeadset();
            return true;
        }
        return super.onTransact(i, parcel, parcel1, j);
    }

    private static final String DESCRIPTOR = "com.google.vr.vrcore.common.api.IDaydreamManager";
    static final int TRANSACTION_registerListener = 1;
    static final int TRANSACTION_unregisterListener = 2;
    static final int TRANSACTION_prepareVr = 3;
    static final int TRANSACTION_deprecatedLaunchInVr = 4;
    static final int TRANSACTION_registerDaydreamIntent = 5;
    static final int TRANSACTION_unregisterDaydreamIntent = 6;
    static final int TRANSACTION_launchInVr = 7;
    static final int TRANSACTION_launchVrHome = 8;
    static final int TRANSACTION_launchVrTransition = 9;
    static final int TRANSACTION_exitFromVr = 10;
    static final int TRANSACTION_handleInsertionIntoHeadset = 11;
    static final int TRANSACTION_handleRemovalFromHeadset = 12;

    public Proxy.mRemote()
    {
        attachInterface(this, "com.google.vr.vrcore.common.api.IDaydreamManager");
    }
}
