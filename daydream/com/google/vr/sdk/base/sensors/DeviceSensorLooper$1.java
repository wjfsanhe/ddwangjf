// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DeviceSensorLooper.java

package com.google.vr.sdk.base.sensors;

import android.hardware.*;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.google.vr.sdk.base.sensors:
//            DeviceSensorLooper

class this._cls0
    implements SensorEventListener
{

    public void onSensorChanged(SensorEvent event)
    {
        synchronized(DeviceSensorLooper.access$000(DeviceSensorLooper.this))
        {
            SensorEventListener listener;
            for(Iterator iterator = DeviceSensorLooper.access$000(DeviceSensorLooper.this).iterator(); iterator.hasNext(); listener.onSensorChanged(event))
                listener = (SensorEventListener)iterator.next();

        }
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {
        synchronized(DeviceSensorLooper.access$000(DeviceSensorLooper.this))
        {
            SensorEventListener listener;
            for(Iterator iterator = DeviceSensorLooper.access$000(DeviceSensorLooper.this).iterator(); iterator.hasNext(); listener.onAccuracyChanged(sensor, accuracy))
                listener = (SensorEventListener)iterator.next();

        }
    }

    final DeviceSensorLooper this$0;

    _cls9()
    {
        this.this$0 = DeviceSensorLooper.this;
        super();
    }
}
