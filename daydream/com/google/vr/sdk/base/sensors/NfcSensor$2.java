// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   NfcSensor.java

package com.google.vr.sdk.base.sensors;

import android.nfc.tech.Ndef;
import java.util.TimerTask;

// Referenced classes of package com.google.vr.sdk.base.sensors:
//            NfcSensor

class this._cls0 extends TimerTask
{

    public void run()
    {
        synchronized(NfcSensor.access$000(NfcSensor.this))
        {
            if(!NfcSensor.access$100(NfcSensor.this).isConnected())
            {
                int _tmp = NfcSensor.access$204(NfcSensor.this);
                if(NfcSensor.access$200(NfcSensor.this) > 1)
                {
                    NfcSensor.access$300(NfcSensor.this);
                    NfcSensor.access$400(NfcSensor.this);
                }
            }
        }
    }

    final NfcSensor this$0;

    ()
    {
        this.this$0 = NfcSensor.this;
        super();
    }
}
