// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MathUtil.java

package com.google.vr.sdk.base.testing;

import com.google.vr.sdk.base.sensors.internal.Matrix3x3d;
import com.google.vr.sdk.base.sensors.internal.Vector3d;

public final class MathUtil
{

    private MathUtil()
    {
    }

    public static double vectorDiffNorm(Vector3d expected, Vector3d actual)
    {
        Vector3d diff = new Vector3d();
        Vector3d.sub(expected, actual, diff);
        return diff.maxNorm();
    }

    public static double matrixDiffNorm(Matrix3x3d expected, Matrix3x3d actual)
    {
        Matrix3x3d diff = new Matrix3x3d(expected);
        diff.minusEquals(actual);
        return diff.maxNorm();
    }

    public static Vector3d vectorFromScalar(double x)
    {
        return new Vector3d(x, -0.5D * x, 0.80000000000000004D * x);
    }
}
