// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ScreenOnFlagHelper.java

package com.google.vrtoolkit.cardboard;

import android.app.Activity;
import android.hardware.*;
import android.view.Window;
import android.view.WindowManager;

// Referenced classes of package com.google.vrtoolkit.cardboard:
//            SensorReadingStats

public class ScreenOnFlagHelper
    implements SensorEventListener
{

    public ScreenOnFlagHelper(Activity activity1)
    {
        screenAlwaysOn = false;
        sensorStats = new SensorReadingStats(120, 3);
        lastSampleTimestamp = 0L;
        isFlagSet = false;
        activity = activity1;
    }

    void setSensorManager(SensorManager sensormanager)
    {
        sensorManager = sensormanager;
    }

    public void setScreenAlwaysOn(boolean flag)
    {
        screenAlwaysOn = flag;
        updateFlag();
    }

    public void start()
    {
        if(sensorManager == null)
            sensorManager = (SensorManager)activity.getSystemService("sensor");
        if(sensor == null)
            sensor = sensorManager.getDefaultSensor(1);
        isFlagSet = false;
        setKeepScreenOnFlag(true);
        sensorStats.reset();
        sensorManager.registerListener(this, sensor, 0x3d090);
    }

    public void stop()
    {
        if(sensorManager != null)
            sensorManager.unregisterListener(this);
        setKeepScreenOnFlag(false);
    }

    public void onAccuracyChanged(Sensor sensor1, int i)
    {
    }

    public void onSensorChanged(SensorEvent sensorevent)
    {
        long l;
        if((l = (sensorevent.timestamp - lastSampleTimestamp) / 0xf4240L) < 250L)
        {
            return;
        } else
        {
            sensorStats.addSample(sensorevent.values);
            lastSampleTimestamp = sensorevent.timestamp;
            updateFlag();
            return;
        }
    }

    private void updateFlag()
    {
        if(screenAlwaysOn || !sensorStats.statsAvailable())
        {
            setKeepScreenOnFlag(true);
            return;
        } else
        {
            float f = sensorStats.getMaxAbsoluteDeviation();
            setKeepScreenOnFlag(f > 0.2F);
            return;
        }
    }

    private void setKeepScreenOnFlag(boolean flag)
    {
        if(flag == isFlagSet)
            return;
        if(flag)
            activity.getWindow().addFlags(128);
        else
            activity.getWindow().clearFlags(128);
        isFlagSet = flag;
    }

    private static final String TAG = "ScreenOnFlagHelper";
    private static final boolean DEBUG = false;
    private static final long IDLE_TIMEOUT_MS = 30000L;
    private static final long SAMPLE_INTERVAL_MS = 250L;
    private static final int NUM_SAMPLES = 120;
    private static final float SENSOR_THRESHOLD = 0.2F;
    private boolean screenAlwaysOn;
    private Activity activity;
    private SensorReadingStats sensorStats;
    private long lastSampleTimestamp;
    private boolean isFlagSet;
    private SensorManager sensorManager;
    private Sensor sensor;
}
