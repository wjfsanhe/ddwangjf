// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrCoreNotAvailableException.java

package com.google.vr.vrcore.base.api;


// Referenced classes of package com.google.vr.vrcore.base.api:
//            VrCoreUtils

public final class VrCoreNotAvailableException extends Exception
{

    public VrCoreNotAvailableException(int i)
    {
        super(VrCoreUtils.getConnectionResultString(i));
        errorCode = i;
    }

    public final int errorCode;
}
