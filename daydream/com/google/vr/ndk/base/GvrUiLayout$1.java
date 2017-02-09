// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GvrUiLayout.java

package com.google.vr.ndk.base;

import android.app.Activity;
import android.content.Intent;

// Referenced classes of package com.google.vr.ndk.base:
//            GvrUiLayout

class val.activity
    implements Runnable
{

    public final void run()
    {
        Intent intent;
        (intent = new Intent("android.intent.action.MAIN")).addCategory("android.intent.category.HOME");
        intent.setFlags(0x10000000);
        val$activity.startActivity(intent);
        val$activity.finish();
    }

    final Activity val$activity;

    ()
    {
        val$activity = activity1;
        super();
    }
}
