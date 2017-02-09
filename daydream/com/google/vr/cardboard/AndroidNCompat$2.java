// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AndroidNCompat.java

package com.google.vr.cardboard;

import android.content.*;

// Referenced classes of package com.google.vr.cardboard:
//            AndroidNCompat

class val.context
    implements android.content.nClickListener
{

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        val$context.startActivity(new Intent("android.settings.VR_LISTENER_SETTINGS"));
    }

    final Context val$context;

    stener()
    {
        val$context = context1;
        super();
    }
}
