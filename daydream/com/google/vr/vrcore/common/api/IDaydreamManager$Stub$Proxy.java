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

private static class mRemote
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

    A(IBinder ibinder)
    {
        mRemote = ibinder;
    }
}
