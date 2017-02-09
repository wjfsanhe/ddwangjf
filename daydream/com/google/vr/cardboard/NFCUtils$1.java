// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   NFCUtils.java

package com.google.vr.cardboard;

import android.content.*;
import android.nfc.Tag;
import android.util.Log;

// Referenced classes of package com.google.vr.cardboard:
//            NFCUtils

class init> extends BroadcastReceiver
{

    public void onReceive(Context context, Intent intent)
    {
        Log.i(NFCUtils.access$000(), "Got an NFC tag!");
        onNFCTagDetected((Tag)intent.getParcelableExtra("android.nfc.extra.TAG"));
    }

    final NFCUtils this$0;

    ()
    {
        this$0 = NFCUtils.this;
        super();
    }
}
