// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   OrientationEKF.java

package com.google.vr.sdk.base.sensors.internal;


// Referenced classes of package com.google.vr.sdk.base.sensors.internal:
//            Matrix3x3d, Vector3d, So3Util

public class OrientationEKF
{

    public OrientationEKF()
    {
        rotationMatrix = new double[16];
        so3SensorFromWorld = new Matrix3x3d();
        so3LastMotion = new Matrix3x3d();
        mP = new Matrix3x3d();
        mQ = new Matrix3x3d();
        mR = new Matrix3x3d();
        mRaccel = new Matrix3x3d();
        mS = new Matrix3x3d();
        mH = new Matrix3x3d();
        mK = new Matrix3x3d();
        mNu = new Vector3d();
        mz = new Vector3d();
        mh = new Vector3d();
        mu = new Vector3d();
        mx = new Vector3d();
        down = new Vector3d();
        north = new Vector3d();
        previousAccelNorm = 0.0D;
        movingAverageAccelNormChange = 0.0D;
        timestepFilterInit = false;
        gyroFilterValid = true;
        getPredictedGLMatrixTempM1 = new Matrix3x3d();
        getPredictedGLMatrixTempM2 = new Matrix3x3d();
        getPredictedGLMatrixTempV1 = new Vector3d();
        setHeadingDegreesTempM1 = new Matrix3x3d();
        processGyroTempM1 = new Matrix3x3d();
        processGyroTempM2 = new Matrix3x3d();
        processAccTempM1 = new Matrix3x3d();
        processAccTempM2 = new Matrix3x3d();
        processAccTempM3 = new Matrix3x3d();
        processAccTempM4 = new Matrix3x3d();
        processAccTempM5 = new Matrix3x3d();
        processAccTempV1 = new Vector3d();
        processAccTempV2 = new Vector3d();
        processAccVDelta = new Vector3d();
        processMagTempV1 = new Vector3d();
        processMagTempV2 = new Vector3d();
        processMagTempV3 = new Vector3d();
        processMagTempV4 = new Vector3d();
        processMagTempV5 = new Vector3d();
        processMagTempM1 = new Matrix3x3d();
        processMagTempM2 = new Matrix3x3d();
        processMagTempM4 = new Matrix3x3d();
        processMagTempM5 = new Matrix3x3d();
        processMagTempM6 = new Matrix3x3d();
        updateCovariancesAfterMotionTempM1 = new Matrix3x3d();
        updateCovariancesAfterMotionTempM2 = new Matrix3x3d();
        accObservationFunctionForNumericalJacobianTempM = new Matrix3x3d();
        magObservationFunctionForNumericalJacobianTempM = new Matrix3x3d();
        reset();
    }

    public synchronized void reset()
    {
        sensorTimeStampGyro = 0L;
        so3SensorFromWorld.setIdentity();
        so3LastMotion.setIdentity();
        double initialSigmaP = 5D;
        mP.setZero();
        mP.setSameDiagonal(25D);
        double initialSigmaQ = 1.0D;
        mQ.setZero();
        mQ.setSameDiagonal(1.0D);
        double initialSigmaR = 0.25D;
        mR.setZero();
        mR.setSameDiagonal(0.0625D);
        mRaccel.setZero();
        mRaccel.setSameDiagonal(0.5625D);
        mS.setZero();
        mH.setZero();
        mK.setZero();
        mNu.setZero();
        mz.setZero();
        mh.setZero();
        mu.setZero();
        mx.setZero();
        down.set(0.0D, 0.0D, 9.8100000000000005D);
        north.set(0.0D, 1.0D, 0.0D);
        alignedToGravity = false;
        alignedToNorth = false;
    }

    public synchronized boolean isReady()
    {
        return alignedToGravity;
    }

    public synchronized double getHeadingDegrees()
    {
        double x = so3SensorFromWorld.get(2, 0);
        double y = so3SensorFromWorld.get(2, 1);
        double mag = Math.sqrt(x * x + y * y);
        if(mag < 0.10000000000000001D)
            return 0.0D;
        double heading = -90D - (Math.atan2(y, x) / 3.1415926535897931D) * 180D;
        if(heading < 0.0D)
            heading += 360D;
        if(heading >= 360D)
            heading -= 360D;
        return heading;
    }

    public synchronized void setHeadingDegrees(double heading)
    {
        double currentHeading = getHeadingDegrees();
        double deltaHeading = heading - currentHeading;
        double s = Math.sin((deltaHeading / 180D) * 3.1415926535897931D);
        double c = Math.cos((deltaHeading / 180D) * 3.1415926535897931D);
        double deltaHeadingRotationVals[][] = {
            {
                c, -s, 0.0D
            }, {
                s, c, 0.0D
            }, {
                0.0D, 0.0D, 1.0D
            }
        };
        arrayAssign(deltaHeadingRotationVals, setHeadingDegreesTempM1);
        Matrix3x3d.mult(so3SensorFromWorld, setHeadingDegreesTempM1, so3SensorFromWorld);
    }

    public synchronized double[] getGLMatrix()
    {
        return glMatrixFromSo3(so3SensorFromWorld);
    }

    public synchronized double[] getPredictedGLMatrix(double secondsAfterLastGyroEvent)
    {
        double dT = secondsAfterLastGyroEvent;
        Vector3d pmu = getPredictedGLMatrixTempV1;
        pmu.set(lastGyro);
        pmu.scale(-dT);
        Matrix3x3d so3PredictedMotion = getPredictedGLMatrixTempM1;
        So3Util.sO3FromMu(pmu, so3PredictedMotion);
        Matrix3x3d so3PredictedState = getPredictedGLMatrixTempM2;
        Matrix3x3d.mult(so3PredictedMotion, so3SensorFromWorld, so3PredictedState);
        return glMatrixFromSo3(so3PredictedState);
    }

    public synchronized Matrix3x3d getRotationMatrix()
    {
        return so3SensorFromWorld;
    }

    public static void arrayAssign(double data[][], Matrix3x3d m)
    {
        if(!$assertionsDisabled && 3 != data.length)
            throw new AssertionError();
        if(!$assertionsDisabled && 3 != data[0].length)
            throw new AssertionError();
        if(!$assertionsDisabled && 3 != data[1].length)
            throw new AssertionError();
        if(!$assertionsDisabled && 3 != data[2].length)
        {
            throw new AssertionError();
        } else
        {
            m.set(data[0][0], data[0][1], data[0][2], data[1][0], data[1][1], data[1][2], data[2][0], data[2][1], data[2][2]);
            return;
        }
    }

    public synchronized boolean isAlignedToGravity()
    {
        return alignedToGravity;
    }

    public synchronized boolean isAlignedToNorth()
    {
        return alignedToNorth;
    }

    public synchronized void processGyro(Vector3d gyro, long sensorTimeStamp)
    {
        float kTimeThreshold = 0.04F;
        float kdTdefault = 0.01F;
        if(sensorTimeStampGyro != 0L)
        {
            float dT = (float)(sensorTimeStamp - sensorTimeStampGyro) * 1E-09F;
            if(dT > 0.04F)
                dT = gyroFilterValid ? filteredGyroTimestep : 0.01F;
            else
                filterGyroTimestep(dT);
            mu.set(gyro);
            mu.scale(-dT);
            So3Util.sO3FromMu(mu, so3LastMotion);
            processGyroTempM1.set(so3SensorFromWorld);
            Matrix3x3d.mult(so3LastMotion, so3SensorFromWorld, processGyroTempM1);
            so3SensorFromWorld.set(processGyroTempM1);
            updateCovariancesAfterMotion();
            processGyroTempM2.set(mQ);
            processGyroTempM2.scale(dT * dT);
            mP.plusEquals(processGyroTempM2);
        }
        sensorTimeStampGyro = sensorTimeStamp;
        lastGyro.set(gyro);
    }

    private void updateAccelCovariance(double currentAccelNorm)
    {
        double currentAccelNormChange = Math.abs(currentAccelNorm - previousAccelNorm);
        previousAccelNorm = currentAccelNorm;
        double kSmoothingFactor = 0.5D;
        movingAverageAccelNormChange = 0.5D * currentAccelNormChange + 0.5D * movingAverageAccelNormChange;
        double kMaxAccelNormChange = 0.14999999999999999D;
        double normChangeRatio = movingAverageAccelNormChange / 0.14999999999999999D;
        double accelNoiseSigma = Math.min(7D, 0.75D + normChangeRatio * 6.25D);
        mRaccel.setSameDiagonal(accelNoiseSigma * accelNoiseSigma);
    }

    public synchronized void processAcc(Vector3d acc, long sensorTimeStamp)
    {
        mz.set(acc);
        updateAccelCovariance(mz.length());
        if(alignedToGravity)
        {
            accObservationFunctionForNumericalJacobian(so3SensorFromWorld, mNu);
            double eps = 9.9999999999999995E-08D;
            for(int dof = 0; dof < 3; dof++)
            {
                Vector3d delta = processAccVDelta;
                delta.setZero();
                delta.setComponent(dof, eps);
                So3Util.sO3FromMu(delta, processAccTempM1);
                Matrix3x3d.mult(processAccTempM1, so3SensorFromWorld, processAccTempM2);
                accObservationFunctionForNumericalJacobian(processAccTempM2, processAccTempV1);
                Vector3d withDelta = processAccTempV1;
                Vector3d.sub(mNu, withDelta, processAccTempV2);
                processAccTempV2.scale(1.0D / eps);
                mH.setColumn(dof, processAccTempV2);
            }

            mH.transpose(processAccTempM3);
            Matrix3x3d.mult(mP, processAccTempM3, processAccTempM4);
            Matrix3x3d.mult(mH, processAccTempM4, processAccTempM5);
            Matrix3x3d.add(processAccTempM5, mRaccel, mS);
            mS.invert(processAccTempM3);
            mH.transpose(processAccTempM4);
            Matrix3x3d.mult(processAccTempM4, processAccTempM3, processAccTempM5);
            Matrix3x3d.mult(mP, processAccTempM5, mK);
            Matrix3x3d.mult(mK, mNu, mx);
            Matrix3x3d.mult(mK, mH, processAccTempM3);
            processAccTempM4.setIdentity();
            processAccTempM4.minusEquals(processAccTempM3);
            Matrix3x3d.mult(processAccTempM4, mP, processAccTempM3);
            mP.set(processAccTempM3);
            So3Util.sO3FromMu(mx, so3LastMotion);
            Matrix3x3d.mult(so3LastMotion, so3SensorFromWorld, so3SensorFromWorld);
            updateCovariancesAfterMotion();
        } else
        {
            So3Util.sO3FromTwoVec(down, mz, so3SensorFromWorld);
            alignedToGravity = true;
        }
    }

    public synchronized void processMag(float mag[], long sensorTimeStamp)
    {
        if(!alignedToGravity)
            return;
        mz.set(mag[0], mag[1], mag[2]);
        mz.normalize();
        Vector3d downInSensorFrame = new Vector3d();
        so3SensorFromWorld.getColumn(2, downInSensorFrame);
        Vector3d.cross(mz, downInSensorFrame, processMagTempV1);
        Vector3d perpToDownAndMag = processMagTempV1;
        perpToDownAndMag.normalize();
        Vector3d.cross(downInSensorFrame, perpToDownAndMag, processMagTempV2);
        Vector3d magHorizontal = processMagTempV2;
        magHorizontal.normalize();
        mz.set(magHorizontal);
        if(alignedToNorth)
        {
            magObservationFunctionForNumericalJacobian(so3SensorFromWorld, mNu);
            double eps = 9.9999999999999995E-08D;
            for(int dof = 0; dof < 3; dof++)
            {
                Vector3d delta = processMagTempV3;
                delta.setZero();
                delta.setComponent(dof, eps);
                So3Util.sO3FromMu(delta, processMagTempM1);
                Matrix3x3d.mult(processMagTempM1, so3SensorFromWorld, processMagTempM2);
                magObservationFunctionForNumericalJacobian(processMagTempM2, processMagTempV4);
                Vector3d withDelta = processMagTempV4;
                Vector3d.sub(mNu, withDelta, processMagTempV5);
                processMagTempV5.scale(1.0D / eps);
                mH.setColumn(dof, processMagTempV5);
            }

            mH.transpose(processMagTempM4);
            Matrix3x3d.mult(mP, processMagTempM4, processMagTempM5);
            Matrix3x3d.mult(mH, processMagTempM5, processMagTempM6);
            Matrix3x3d.add(processMagTempM6, mR, mS);
            mS.invert(processMagTempM4);
            mH.transpose(processMagTempM5);
            Matrix3x3d.mult(processMagTempM5, processMagTempM4, processMagTempM6);
            Matrix3x3d.mult(mP, processMagTempM6, mK);
            Matrix3x3d.mult(mK, mNu, mx);
            Matrix3x3d.mult(mK, mH, processMagTempM4);
            processMagTempM5.setIdentity();
            processMagTempM5.minusEquals(processMagTempM4);
            Matrix3x3d.mult(processMagTempM5, mP, processMagTempM4);
            mP.set(processMagTempM4);
            So3Util.sO3FromMu(mx, so3LastMotion);
            Matrix3x3d.mult(so3LastMotion, so3SensorFromWorld, processMagTempM4);
            so3SensorFromWorld.set(processMagTempM4);
            updateCovariancesAfterMotion();
        } else
        {
            magObservationFunctionForNumericalJacobian(so3SensorFromWorld, mNu);
            So3Util.sO3FromMu(mNu, so3LastMotion);
            Matrix3x3d.mult(so3LastMotion, so3SensorFromWorld, processMagTempM4);
            so3SensorFromWorld.set(processMagTempM4);
            updateCovariancesAfterMotion();
            alignedToNorth = true;
        }
    }

    private double[] glMatrixFromSo3(Matrix3x3d so3)
    {
        for(int r = 0; r < 3; r++)
        {
            for(int c = 0; c < 3; c++)
                rotationMatrix[4 * c + r] = so3.get(r, c);

        }

        rotationMatrix[3] = rotationMatrix[7] = rotationMatrix[11] = 0.0D;
        rotationMatrix[12] = rotationMatrix[13] = rotationMatrix[14] = 0.0D;
        rotationMatrix[15] = 1.0D;
        return rotationMatrix;
    }

    private void filterGyroTimestep(float timeStep)
    {
        float kFilterCoeff = 0.95F;
        float kMinSamples = 10F;
        if(!timestepFilterInit)
        {
            filteredGyroTimestep = timeStep;
            numGyroTimestepSamples = 1;
            timestepFilterInit = true;
        } else
        {
            filteredGyroTimestep = 0.95F * filteredGyroTimestep + 0.05000001F * timeStep;
            if((float)(++numGyroTimestepSamples) > 10F)
                gyroFilterValid = true;
        }
    }

    private void updateCovariancesAfterMotion()
    {
        so3LastMotion.transpose(updateCovariancesAfterMotionTempM1);
        Matrix3x3d.mult(mP, updateCovariancesAfterMotionTempM1, updateCovariancesAfterMotionTempM2);
        Matrix3x3d.mult(so3LastMotion, updateCovariancesAfterMotionTempM2, mP);
        so3LastMotion.setIdentity();
    }

    private void accObservationFunctionForNumericalJacobian(Matrix3x3d so3SensorFromWorldPred, Vector3d result)
    {
        Matrix3x3d.mult(so3SensorFromWorldPred, down, mh);
        So3Util.sO3FromTwoVec(mh, mz, accObservationFunctionForNumericalJacobianTempM);
        So3Util.muFromSO3(accObservationFunctionForNumericalJacobianTempM, result);
    }

    private void magObservationFunctionForNumericalJacobian(Matrix3x3d so3SensorFromWorldPred, Vector3d result)
    {
        Matrix3x3d.mult(so3SensorFromWorldPred, north, mh);
        So3Util.sO3FromTwoVec(mh, mz, magObservationFunctionForNumericalJacobianTempM);
        So3Util.muFromSO3(magObservationFunctionForNumericalJacobianTempM, result);
    }

    private static final float NS2S = 1E-09F;
    private static final double MIN_ACCEL_NOISE_SIGMA = 0.75D;
    private static final double MAX_ACCEL_NOISE_SIGMA = 7D;
    private double rotationMatrix[];
    private Matrix3x3d so3SensorFromWorld;
    private Matrix3x3d so3LastMotion;
    private Matrix3x3d mP;
    private Matrix3x3d mQ;
    private Matrix3x3d mR;
    private Matrix3x3d mRaccel;
    private Matrix3x3d mS;
    private Matrix3x3d mH;
    private Matrix3x3d mK;
    private Vector3d mNu;
    private Vector3d mz;
    private Vector3d mh;
    private Vector3d mu;
    private Vector3d mx;
    private Vector3d down;
    private Vector3d north;
    private long sensorTimeStampGyro;
    private final Vector3d lastGyro = new Vector3d();
    private double previousAccelNorm;
    private double movingAverageAccelNormChange;
    private float filteredGyroTimestep;
    private boolean timestepFilterInit;
    private int numGyroTimestepSamples;
    private boolean gyroFilterValid;
    private Matrix3x3d getPredictedGLMatrixTempM1;
    private Matrix3x3d getPredictedGLMatrixTempM2;
    private Vector3d getPredictedGLMatrixTempV1;
    private Matrix3x3d setHeadingDegreesTempM1;
    private Matrix3x3d processGyroTempM1;
    private Matrix3x3d processGyroTempM2;
    private Matrix3x3d processAccTempM1;
    private Matrix3x3d processAccTempM2;
    private Matrix3x3d processAccTempM3;
    private Matrix3x3d processAccTempM4;
    private Matrix3x3d processAccTempM5;
    private Vector3d processAccTempV1;
    private Vector3d processAccTempV2;
    private Vector3d processAccVDelta;
    private Vector3d processMagTempV1;
    private Vector3d processMagTempV2;
    private Vector3d processMagTempV3;
    private Vector3d processMagTempV4;
    private Vector3d processMagTempV5;
    private Matrix3x3d processMagTempM1;
    private Matrix3x3d processMagTempM2;
    private Matrix3x3d processMagTempM4;
    private Matrix3x3d processMagTempM5;
    private Matrix3x3d processMagTempM6;
    private Matrix3x3d updateCovariancesAfterMotionTempM1;
    private Matrix3x3d updateCovariancesAfterMotionTempM2;
    private Matrix3x3d accObservationFunctionForNumericalJacobianTempM;
    private Matrix3x3d magObservationFunctionForNumericalJacobianTempM;
    private boolean alignedToGravity;
    private boolean alignedToNorth;
    static final boolean $assertionsDisabled = !com/google/vr/sdk/base/sensors/internal/OrientationEKF.desiredAssertionStatus();

}
