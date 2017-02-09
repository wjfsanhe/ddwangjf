// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrContextWrapper.java

package com.google.vr.cardboard;

import android.content.*;

public abstract class VrContextWrapper extends MutableContextWrapper
{

    public VrContextWrapper(Context context)
    {
        super(context);
    }

    public abstract ComponentName getVrComponent();
}
