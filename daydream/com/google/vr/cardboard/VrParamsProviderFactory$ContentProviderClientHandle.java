// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrParamsProviderFactory.java

package com.google.vr.cardboard;

import android.content.ContentProviderClient;

// Referenced classes of package com.google.vr.cardboard:
//            VrParamsProviderFactory

public static class authority
{

    public final ContentProviderClient client;
    public final String authority;

    Q(ContentProviderClient contentproviderclient, String s)
    {
        client = contentproviderclient;
        authority = s;
    }
}
