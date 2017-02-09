// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ImplementationSelector.java

package com.google.vr.sdk.base;

import android.content.Context;

// Referenced classes of package com.google.vr.sdk.base:
//            CardboardViewNativeImpl, CardboardViewApi

public class ImplementationSelector
{

    public ImplementationSelector()
    {
    }

    public static CardboardViewApi createCardboardViewApi(Context context)
    {
        return new CardboardViewNativeImpl(context);
    }
}
