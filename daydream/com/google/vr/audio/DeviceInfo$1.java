// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DeviceInfo.java

package com.google.vr.audio;

import android.content.*;

// Referenced classes of package com.google.vr.audio:
//            DeviceInfo

class  extends BroadcastReceiver
{

    public void onReceive(Context context, Intent intent)
    {
        int i;
        if(intent.getAction().equals("android.intent.action.HEADSET_PLUG"))
            switch(i = intent.getIntExtra("state", -1))
            {
            case 0: // '\0'
                DeviceInfo.access$100(DeviceInfo.this, DeviceInfo.access$000(DeviceInfo.this), 2);
                return;

            case 1: // '\001'
                DeviceInfo.access$100(DeviceInfo.this, DeviceInfo.access$000(DeviceInfo.this), 1);
                return;

            default:
                DeviceInfo.access$100(DeviceInfo.this, DeviceInfo.access$000(DeviceInfo.this), 0);
                break;
            }
    }

    final DeviceInfo this$0;

    adphoneState()
    {
        this$0 = DeviceInfo.this;
        super();
    }
}
