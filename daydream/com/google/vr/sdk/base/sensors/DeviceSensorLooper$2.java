// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DeviceSensorLooper.java

package com.google.vr.sdk.base.sensors;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.*;
import android.util.Log;

// Referenced classes of package com.google.vr.sdk.base.sensors:
//            DeviceSensorLooper

class this._cls0 extends HandlerThread
{

    protected void onLooperPrepared()
    {
        Handler handler = new Handler(Looper.myLooper());
        Sensor accelerometer = DeviceSensorLooper.access$100(DeviceSensorLooper.this).getDefaultSensor(1);
        DeviceSensorLooper.access$100(DeviceSensorLooper.this).registerListener(DeviceSensorLooper.access$200(DeviceSensorLooper.this), accelerometer, 0, handler);
        Sensor gyroscope = DeviceSensorLooper.access$300(DeviceSensorLooper.this);
        if(gyroscope == null)
        {
            Log.i(DeviceSensorLooper.access$400(), "Uncalibrated gyroscope unavailable, default to regular gyroscope.");
            gyroscope = DeviceSensorLooper.access$100(DeviceSensorLooper.this).getDefaultSensor(4);
        }
        DeviceSensorLooper.access$100(DeviceSensorLooper.this).registerListener(DeviceSensorLooper.access$200(DeviceSensorLooper.this), gyroscope, 0, handler);
    }

    final DeviceSensorLooper this$0;

    _cls9(String x0)
    {
        this.this$0 = DeviceSensorLooper.this;
        super(x0);
    }
}
