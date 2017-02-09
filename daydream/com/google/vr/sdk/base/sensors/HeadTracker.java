// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   HeadTracker.java

package com.google.vr.sdk.base.sensors;

import android.content.Context;
import android.hardware.*;
import android.opengl.Matrix;
import android.view.Display;
import android.view.WindowManager;
import com.google.vr.sdk.base.sensors.internal.GyroscopeBiasEstimator;
import com.google.vr.sdk.base.sensors.internal.Matrix3x3d;
import com.google.vr.sdk.base.sensors.internal.OrientationEKF;
import com.google.vr.sdk.base.sensors.internal.Vector3d;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.vr.sdk.base.sensors:
//            DeviceSensorLooper, SystemClock, Clock, SensorEventProvider

public class HeadTracker
    implements SensorEventListener
{

    public static HeadTracker createFromContext(Context context)
    {
        SensorManager sensorManager = (SensorManager)context.getSystemService("sensor");
        Display display = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        return new HeadTracker(new DeviceSensorLooper(sensorManager), new SystemClock(), display);
    }

    public HeadTracker(SensorEventProvider sensorEventProvider, Clock clock, Display display)
    {
        displayRotation = (0.0F / 0.0F);
        neckModelFactor = 1.0F;
        firstGyroValue = true;
        initialSystemGyroBias = new float[3];
        this.clock = clock;
        this.sensorEventProvider = sensorEventProvider;
        this.display = display;
        gyroBiasEstimator = new GyroscopeBiasEstimator();
        Matrix.setIdentityM(neckModelTranslation, 0);
    }

    public void onSensorChanged(SensorEvent event)
    {
        if(event.sensor.getType() == 1)
        {
            latestAcc.set(event.values[0], event.values[1], event.values[2]);
            tracker.processAcc(latestAcc, event.timestamp);
            synchronized(gyroBiasEstimatorMutex)
            {
                if(gyroBiasEstimator != null)
                    gyroBiasEstimator.processAccelerometer(latestAcc, event.timestamp);
            }
        } else
        if(event.sensor.getType() == 4 || event.sensor.getType() == 16)
        {
            latestGyroEventClockTimeNs = clock.nanoTime();
            if(event.sensor.getType() == 16)
            {
                if(firstGyroValue && event.values.length == 6)
                {
                    initialSystemGyroBias[0] = event.values[3];
                    initialSystemGyroBias[1] = event.values[4];
                    initialSystemGyroBias[2] = event.values[5];
                }
                latestGyro.set(event.values[0] - initialSystemGyroBias[0], event.values[1] - initialSystemGyroBias[1], event.values[2] - initialSystemGyroBias[2]);
            } else
            {
                latestGyro.set(event.values[0], event.values[1], event.values[2]);
            }
            firstGyroValue = false;
            synchronized(gyroBiasEstimatorMutex)
            {
                if(gyroBiasEstimator != null)
                {
                    gyroBiasEstimator.processGyroscope(latestGyro, event.timestamp);
                    gyroBiasEstimator.getGyroBias(gyroBias);
                    Vector3d.sub(latestGyro, gyroBias, latestGyro);
                }
            }
            tracker.processGyro(latestGyro, event.timestamp);
        }
    }

    public void onAccuracyChanged(Sensor sensor1, int i)
    {
    }

    public void startTracking()
    {
        if(tracking)
            return;
        tracker.reset();
        synchronized(gyroBiasEstimatorMutex)
        {
            if(gyroBiasEstimator != null)
                gyroBiasEstimator.reset();
        }
        firstGyroValue = true;
        sensorEventProvider.registerListener(this);
        sensorEventProvider.start();
        tracking = true;
    }

    public void resetTracker()
    {
        tracker.reset();
    }

    public void stopTracking()
    {
        if(!tracking)
        {
            return;
        } else
        {
            sensorEventProvider.unregisterListener(this);
            sensorEventProvider.stop();
            tracking = false;
            return;
        }
    }

    public void setNeckModelEnabled(boolean enabled)
    {
        if(enabled)
            setNeckModelFactor(1.0F);
        else
            setNeckModelFactor(0.0F);
    }

    public float getNeckModelFactor()
    {
        Object obj = neckModelFactorMutex;
        JVM INSTR monitorenter ;
        return neckModelFactor;
        Exception exception;
        exception;
        throw exception;
    }

    public void setNeckModelFactor(float factor)
    {
        synchronized(neckModelFactorMutex)
        {
            if(factor < 0.0F || factor > 1.0F)
                throw new IllegalArgumentException("factor should be within [0.0, 1.0]");
            neckModelFactor = factor;
        }
    }

    public void getLastHeadView(float headView[], int offset)
    {
label0:
        {
            if(offset + 16 > headView.length)
                throw new IllegalArgumentException("Not enough space to write the result");
            float rotation = 0.0F;
            switch(display.getRotation())
            {
            case 0: // '\0'
                rotation = 0.0F;
                break;

            case 1: // '\001'
                rotation = 90F;
                break;

            case 2: // '\002'
                rotation = 180F;
                break;

            case 3: // '\003'
                rotation = 270F;
                break;
            }
            if(rotation != displayRotation)
            {
                displayRotation = rotation;
                Matrix.setRotateEulerM(sensorToDisplay, 0, 0.0F, 0.0F, -rotation);
                Matrix.setRotateEulerM(ekfToHeadTracker, 0, -90F, 0.0F, rotation);
            }
            synchronized(tracker)
            {
                if(tracker.isReady())
                    break label0;
            }
            return;
        }
        double secondsSinceLastGyroEvent = TimeUnit.NANOSECONDS.toSeconds(clock.nanoTime() - latestGyroEventClockTimeNs);
        double secondsToPredictForward = secondsSinceLastGyroEvent + 0.057999998331069946D;
        double mat[] = tracker.getPredictedGLMatrix(secondsToPredictForward);
        for(int i = 0; i < headView.length; i++)
            tmpHeadView[i] = (float)mat[i];

        orientationekf;
        JVM INSTR monitorexit ;
          goto _L1
        exception;
        throw exception;
_L1:
        Matrix.multiplyMM(tmpHeadView2, 0, sensorToDisplay, 0, tmpHeadView, 0);
        Matrix.multiplyMM(headView, offset, tmpHeadView2, 0, ekfToHeadTracker, 0);
        Matrix.setIdentityM(neckModelTranslation, 0);
        Matrix.translateM(neckModelTranslation, 0, 0.0F, -neckModelFactor * 0.075F, neckModelFactor * 0.08F);
        Matrix.multiplyMM(tmpHeadView, 0, neckModelTranslation, 0, headView, offset);
        Matrix.translateM(headView, offset, tmpHeadView, 0, 0.0F, neckModelFactor * 0.075F, 0.0F);
        return;
    }

    Matrix3x3d getCurrentPoseForTest()
    {
        return new Matrix3x3d(tracker.getRotationMatrix());
    }

    void setGyroBiasEstimator(GyroscopeBiasEstimator estimator)
    {
        synchronized(gyroBiasEstimatorMutex)
        {
            gyroBiasEstimator = estimator;
        }
    }

    private static final float DEFAULT_NECK_HORIZONTAL_OFFSET = 0.08F;
    private static final float DEFAULT_NECK_VERTICAL_OFFSET = 0.075F;
    private static final float DEFAULT_NECK_MODEL_FACTOR = 1F;
    private static final float PREDICTION_TIME_IN_SECONDS = 0.058F;
    private final Display display;
    private final float ekfToHeadTracker[] = new float[16];
    private final float sensorToDisplay[] = new float[16];
    private float displayRotation;
    private final float neckModelTranslation[] = new float[16];
    private final float tmpHeadView[] = new float[16];
    private final float tmpHeadView2[] = new float[16];
    private float neckModelFactor;
    private final Object neckModelFactorMutex = new Object();
    private volatile boolean tracking;
    private final OrientationEKF tracker = new OrientationEKF();
    private final Object gyroBiasEstimatorMutex = new Object();
    private GyroscopeBiasEstimator gyroBiasEstimator;
    private SensorEventProvider sensorEventProvider;
    private Clock clock;
    private long latestGyroEventClockTimeNs;
    private volatile boolean firstGyroValue;
    private float initialSystemGyroBias[];
    private final Vector3d gyroBias = new Vector3d();
    private final Vector3d latestGyro = new Vector3d();
    private final Vector3d latestAcc = new Vector3d();
}
