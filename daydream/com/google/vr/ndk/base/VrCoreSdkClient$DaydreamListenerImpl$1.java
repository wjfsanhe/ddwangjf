// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrCoreSdkClient.java

package com.google.vr.ndk.base;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

// Referenced classes of package com.google.vr.ndk.base:
//            VrCoreSdkClient

class this._cls0 extends Handler
{

    public void handleMessage(Message message)
    {
        switch(message.what)
        {
        case 2: // '\002'
            Log.w("VrCoreSdkClient", "Forcing fade in: VrCore unresponsive");
            cess._mth800(this._cls0.this, 1, 350L);
            return;

        case 1: // '\001'
            Log.w("VrCoreSdkClient", "Forcing tracking resume: VrCore unresponsive");
            cess._mth900(this._cls0.this, null);
            return;
        }
        super.handleMessage(message);
    }

    final this._cls0 this$0;

    ()
    {
        this$0 = this._cls0.this;
        super();
    }
}
