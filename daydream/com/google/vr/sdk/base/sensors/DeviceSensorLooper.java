// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DeviceSensorLooper.java

package com.google.vr.sdk.base.sensors;

import android.hardware.*;
import android.os.*;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.google.vr.sdk.base.sensors:
//            SensorEventProvider

public class DeviceSensorLooper
    implements SensorEventProvider
{

    public DeviceSensorLooper(SensorManager sensorManager)
    {
        this.sensorManager = sensorManager;
    }

    private Sensor getUncalibratedGyro()
    {
        if(Build.MANUFACTURER.equals("HTC"))
            return null;
        else
            return sensorManager.getDefaultSensor(16);
    }

    public void start()
    {
        if(isRunning)
        {
            return;
        } else
        {
            sensorEventListener = new SensorEventListener() {

                public void onSensorChanged(SensorEvent event)
                {
                    synchronized(registeredListeners)
                    {
                        SensorEventListener listener;
                        for(Iterator iterator = registeredListeners.iterator(); iterator.hasNext(); listener.onSensorChanged(event))
                            listener = (SensorEventListener)iterator.next();

                    }
                }

                public void onAccuracyChanged(Sensor sensor, int accuracy)
                {
                    synchronized(registeredListeners)
                    {
                        SensorEventListener listener;
                        for(Iterator iterator = registeredListeners.iterator(); iterator.hasNext(); listener.onAccuracyChanged(sensor, accuracy))
                            listener = (SensorEventListener)iterator.next();

                    }
                }

                final DeviceSensorLooper this$0;

            
            {
                this.this$0 = DeviceSensorLooper.this;
                super();
            }
            };
            HandlerThread sensorThread = new HandlerThread("sensor") {

                protected void onLooperPrepared()
                {
                    Handler handler = new Handler(Looper.myLooper());
                    Sensor accelerometer = sensorManager.getDefaultSensor(1);
                    sensorManager.registerListener(sensorEventListener, accelerometer, 0, handler);
                    Sensor gyroscope = getUncalibratedGyro();
                    if(gyroscope == null)
                    {
                        Log.i(DeviceSensorLooper.LOG_TAG, "Uncalibrated gyroscope unavailable, default to regular gyroscope.");
                        gyroscope = sensorManager.getDefaultSensor(4);
                    }
                    sensorManager.registerListener(sensorEventListener, gyroscope, 0, handler);
                }

                final DeviceSensorLooper this$0;

            
            {
                this.this$0 = DeviceSensorLooper.this;
                super(x0);
            }
            };
            sensorThread.start();
            sensorLooper = sensorThread.getLooper();
            isRunning = true;
            return;
        }
    }

    public void stop()
    {
        if(!isRunning)
        {
            return;
        } else
        {
            sensorManager.unregisterListener(sensorEventListener);
            sensorEventListener = null;
            sensorLooper.quit();
            sensorLooper = null;
            isRunning = false;
            return;
        }
    }

    public void registerListener(SensorEventListener listener)
    {
        synchronized(registeredListeners)
        {
            registeredListeners.add(listener);
        }
    }

    public void unregisterListener(SensorEventListener listener)
    {
        synchronized(registeredListeners)
        {
            registeredListeners.remove(listener);
        }
    }

    private static final String LOG_TAG = com/google/vr/sdk/base/sensors/DeviceSensorLooper.getSimpleName();
    private boolean isRunning;
    private SensorManager sensorManager;
    private Looper sensorLooper;
    private SensorEventListener sensorEventListener;
    private final ArrayList registeredListeners = new ArrayList();






}
