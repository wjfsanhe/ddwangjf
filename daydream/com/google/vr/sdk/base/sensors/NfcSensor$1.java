// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   NfcSensor.java

package com.google.vr.sdk.base.sensors;

import android.content.*;

// Referenced classes of package com.google.vr.sdk.base.sensors:
//            NfcSensor

class this._cls0 extends BroadcastReceiver
{

    public void onReceive(Context context, Intent intent)
    {
        onNfcIntent(intent);
    }

    final NfcSensor this$0;

    ()
    {
        this.this$0 = NfcSensor.this;
        super();
    }
}
