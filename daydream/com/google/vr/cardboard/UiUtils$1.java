// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UiUtils.java

package com.google.vr.cardboard;

import android.content.*;
import android.net.Uri;
import android.widget.Toast;

// Referenced classes of package com.google.vr.cardboard:
//            R, UiUtils

class val.context
    implements android.content.rface.OnClickListener
{

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://support.google.com/daydream?p=daydream_help_menu"));
        try
        {
            val$context.startActivity(intent);
            return;
        }
        catch(ActivityNotFoundException _ex)
        {
            Toast.makeText(val$context, o_browser_text, 1).show();
        }
        dialoginterface.cancel();
    }

    final Context val$context;

    ception()
    {
        val$context = context1;
        super();
    }
}
