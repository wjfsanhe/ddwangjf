// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DeviceInfo.java

package com.google.vr.audio;

import android.content.*;
import android.media.AudioManager;

public class DeviceInfo
{
    private static abstract class HeadphoneState
    {

        public static final int UNKNOWN = 0;
        public static final int PLUGGEDIN = 1;
        public static final int UNPLUGGED = 2;

        private HeadphoneState()
        {
        }
    }


    private DeviceInfo(long l, Context context1)
    {
        nativeObject = l;
        context = context1;
    }

    private static DeviceInfo createDeviceInfo(long l, Context context1)
    {
        return new DeviceInfo(l, context1);
    }

    private void registerHandlers()
    {
        IntentFilter intentfilter = new IntentFilter("android.intent.action.HEADSET_PLUG");
        context.registerReceiver(headphoneStateReceiver, intentfilter);
    }

    private void unregisterHandlers()
    {
        context.unregisterReceiver(headphoneStateReceiver);
    }

    private boolean isHeadphonePluggedIn()
    {
        AudioManager audiomanager;
        return (audiomanager = (AudioManager)context.getSystemService("audio")).isWiredHeadsetOn();
    }

    private native void nativeUpdateHeadphoneStateChange(long l, int i);

    private static final String TAG = "DeviceInfo";
    private final long nativeObject;
    private final Context context;
    private final BroadcastReceiver headphoneStateReceiver = new BroadcastReceiver() {

        public void onReceive(Context context2, Intent intent)
        {
            int i;
            if(intent.getAction().equals("android.intent.action.HEADSET_PLUG"))
                switch(i = intent.getIntExtra("state", -1))
                {
                case 0: // '\0'
                    nativeUpdateHeadphoneStateChange(nativeObject, 2);
                    return;

                case 1: // '\001'
                    nativeUpdateHeadphoneStateChange(nativeObject, 1);
                    return;

                default:
                    nativeUpdateHeadphoneStateChange(nativeObject, 0);
                    break;
                }
        }

        final DeviceInfo this$0;

            
            {
                this$0 = DeviceInfo.this;
                super();
            }
    };


}
