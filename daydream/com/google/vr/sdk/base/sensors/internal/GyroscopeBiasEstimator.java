// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GyroscopeBiasEstimator.java

package com.google.vr.sdk.base.sensors.internal;


// Referenced classes of package com.google.vr.sdk.base.sensors.internal:
//            Vector3d, LowPassFilter

public class GyroscopeBiasEstimator
{
    private static class IsStaticCounter
    {

        void appendFrame(boolean isStatic)
        {
            if(!isStatic)
                consecutiveIsStatic = 0;
            else
                consecutiveIsStatic++;
        }

        boolean isRecentlyStatic()
        {
            return consecutiveIsStatic >= minStaticFrames;
        }

        private final int minStaticFrames;
        private int consecutiveIsStatic;

        IsStaticCounter(int minStaticFrames)
        {
            this.minStaticFrames = minStaticFrames;
        }
    }


    public GyroscopeBiasEstimator()
    {
        reset();
    }

    public void reset()
    {
        smoothedGyroDiff = new Vector3d();
        smoothedAccelDiff = new Vector3d();
        accelLowPass = new LowPassFilter(1.0D);
        gyroLowPass = new LowPassFilter(10D);
        gyroBiasLowPass = new LowPassFilter(0.15000000596046448D);
        isAccelStatic = new IsStaticCounter(10);
        isGyroStatic = new IsStaticCounter(10);
    }

    public void processGyroscope(Vector3d gyro, long sensorTimestampNs)
    {
        gyroLowPass.addSample(gyro, sensorTimestampNs);
        Vector3d.sub(gyro, gyroLowPass.getFilteredData(), smoothedGyroDiff);
        isGyroStatic.appendFrame(smoothedGyroDiff.length() < 0.0080000003799796104D);
        if(isGyroStatic.isRecentlyStatic() && isAccelStatic.isRecentlyStatic())
            updateGyroBias(gyro, sensorTimestampNs);
    }

    public void processAccelerometer(Vector3d accel, long sensorTimestampNs)
    {
        accelLowPass.addSample(accel, sensorTimestampNs);
        Vector3d.sub(accel, accelLowPass.getFilteredData(), smoothedAccelDiff);
        isAccelStatic.appendFrame(smoothedAccelDiff.length() < 0.5D);
    }

    public void getGyroBias(Vector3d result)
    {
        if(gyroBiasLowPass.getNumSamples() < 30)
        {
            result.setZero();
        } else
        {
            result.set(gyroBiasLowPass.getFilteredData());
            double rampUpRatio = Math.min(1.0D, (double)(gyroBiasLowPass.getNumSamples() - 30) / 100D);
            result.scale(rampUpRatio);
        }
    }

    private void updateGyroBias(Vector3d gyro, long sensorTimestampNs)
    {
        if(gyro.length() >= 0.34999999403953552D)
        {
            return;
        } else
        {
            double updateWeight = Math.max(0.0D, 1.0D - gyro.length() / 0.34999999403953552D);
            updateWeight *= updateWeight;
            gyroBiasLowPass.addWeightedSample(gyroLowPass.getFilteredData(), sensorTimestampNs, updateWeight);
            return;
        }
    }

    private static final float ACCEL_LOWPASS_FREQ = 1F;
    private static final float GYRO_LOWPASS_FREQ = 10F;
    private static final float GYRO_BIAS_LOWPASS_FREQ = 0.15F;
    private static final int NUM_GYRO_BIAS_SAMPLES_THRESHOLD = 30;
    private static final int NUM_GYRO_BIAS_SAMPLES_INITIAL_SMOOTHING = 100;
    private LowPassFilter accelLowPass;
    private LowPassFilter gyroLowPass;
    private LowPassFilter gyroBiasLowPass;
    private static final float ACCEL_DIFF_STATIC_THRESHOLD = 0.5F;
    private static final float GYRO_DIFF_STATIC_THRESHOLD = 0.008F;
    private Vector3d smoothedGyroDiff;
    private Vector3d smoothedAccelDiff;
    private static final float GYRO_FOR_BIAS_THRESHOLD = 0.35F;
    private static final int IS_STATIC_NUM_FRAMES_THRESHOLD = 10;
    private IsStaticCounter isAccelStatic;
    private IsStaticCounter isGyroStatic;
}
