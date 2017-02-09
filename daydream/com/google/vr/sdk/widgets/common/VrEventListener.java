// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrEventListener.java

package com.google.vr.sdk.widgets.common;

import android.util.Log;

public class VrEventListener
{

    public VrEventListener()
    {
    }

    public void onLoadSuccess()
    {
    }

    public void onLoadError(String errorMessage)
    {
        int i;
        Log.e(TAG, (new StringBuilder(25 + String.valueOf(errorMessage).length())).append(i = hashCode()).append(".onLoadError: ").append(errorMessage).toString());
    }

    public void onClick()
    {
    }

    public void onDisplayModeChanged(int i)
    {
    }

    private static final String TAG = com/google/vr/sdk/widgets/common/VrEventListener.getSimpleName();
    private static final boolean DEBUG = false;

}
