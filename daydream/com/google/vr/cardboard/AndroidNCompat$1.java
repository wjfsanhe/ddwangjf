// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AndroidNCompat.java

package com.google.vr.cardboard;

import android.content.*;
import android.net.Uri;
import android.util.Log;

// Referenced classes of package com.google.vr.cardboard:
//            AndroidNCompat

class val.context
    implements android.content.nClickListener
{

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        Intent intent;
        (intent = new Intent("android.intent.action.VIEW")).setData(Uri.parse("market://details?id=com.google.vr.vrcore"));
        intent.setPackage("com.android.vending");
        try
        {
            val$context.startActivity(intent);
            return;
        }
        catch(ActivityNotFoundException _ex)
        {
            Log.e(AndroidNCompat.access$000(), "Google Play Services is not installed, unable to download VrCore.");
        }
    }

    final Context val$context;

    ()
    {
        val$context = context1;
        super();
    }
}
