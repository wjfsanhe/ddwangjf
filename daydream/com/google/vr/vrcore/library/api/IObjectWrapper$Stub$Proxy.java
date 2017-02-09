// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IObjectWrapper.java

package com.google.vr.vrcore.library.api;

import android.os.IBinder;

// Referenced classes of package com.google.vr.vrcore.library.api:
//            IObjectWrapper

private static class mRemote
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

    (IBinder ibinder)
    {
        mRemote = ibinder;
    }
}
