// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   NFCUtils.java

package com.google.vr.cardboard;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.*;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.util.Log;

public class NFCUtils
{

    public NFCUtils()
    {
    }

    public void onCreate(Activity activity)
    {
        context = activity.getApplicationContext();
        nfcAdapter = NfcAdapter.getDefaultAdapter(context);
        nfcBroadcastReceiver = new BroadcastReceiver() {

            public void onReceive(Context context1, Intent intent)
            {
                Log.i(NFCUtils.TAG, "Got an NFC tag!");
                onNFCTagDetected((Tag)intent.getParcelableExtra("android.nfc.extra.TAG"));
            }

            final NFCUtils this$0;

            
            {
                this$0 = NFCUtils.this;
                super();
            }
        };
        IntentFilter intentfilter;
        (intentfilter = createNfcIntentFilter()).addDataScheme("cardboard");
        IntentFilter intentfilter1;
        (intentfilter1 = createNfcIntentFilter()).addDataScheme("http");
        intentfilter1.addDataAuthority("goo.gl", null);
        IntentFilter intentfilter2;
        (intentfilter2 = createNfcIntentFilter()).addDataScheme("http");
        intentfilter2.addDataAuthority("google.com", null);
        intentfilter2.addDataPath("/cardboard/cfg.*", 2);
        nfcIntentFilters = (new IntentFilter[] {
            intentfilter, intentfilter1, intentfilter2
        });
    }

    public void onResume(Activity activity)
    {
        activity.registerReceiver(nfcBroadcastReceiver, createNfcIntentFilter());
        Intent intent;
        (intent = new Intent("android.nfc.action.NDEF_DISCOVERED")).setPackage(activity.getPackageName());
        PendingIntent pendingintent = PendingIntent.getBroadcast(context, 0, intent, 0);
        if(isNFCEnabled())
            nfcAdapter.enableForegroundDispatch(activity, pendingintent, nfcIntentFilters, null);
    }

    public void onPause(Activity activity)
    {
        if(isNFCEnabled())
            nfcAdapter.disableForegroundDispatch(activity);
        activity.unregisterReceiver(nfcBroadcastReceiver);
    }

    protected boolean isNFCEnabled()
    {
        return nfcAdapter != null && nfcAdapter.isEnabled();
    }

    protected void onNFCTagDetected(Tag tag)
    {
    }

    private IntentFilter createNfcIntentFilter()
    {
        IntentFilter intentfilter;
        (intentfilter = new IntentFilter()).addAction("android.nfc.action.NDEF_DISCOVERED");
        intentfilter.addAction("android.nfc.action.TECH_DISCOVERED");
        intentfilter.addAction("android.nfc.action.TAG_DISCOVERED");
        return intentfilter;
    }

    private static final String TAG = com/google/vr/cardboard/NFCUtils.getSimpleName();
    Context context;
    NfcAdapter nfcAdapter;
    BroadcastReceiver nfcBroadcastReceiver;
    IntentFilter nfcIntentFilters[];


}
