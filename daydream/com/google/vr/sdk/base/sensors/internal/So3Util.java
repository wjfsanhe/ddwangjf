// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   So3Util.java

package com.google.vr.sdk.base.sensors.internal;


// Referenced classes of package com.google.vr.sdk.base.sensors.internal:
//            Vector3d, Matrix3x3d

public class So3Util
{

    public So3Util()
    {
    }

    public static void sO3FromTwoVec(Vector3d a, Vector3d b, Matrix3x3d result)
    {
        Vector3d.cross(a, b, sO3FromTwoVecN);
        if(sO3FromTwoVecN.length() == 0.0D)
        {
            double dot = Vector3d.dot(a, b);
            if(dot >= 0.0D)
            {
                result.setIdentity();
            } else
            {
                Vector3d.ortho(a, sO3FromTwoVecRotationAxis);
                rotationPiAboutAxis(sO3FromTwoVecRotationAxis, result);
            }
            return;
        } else
        {
            sO3FromTwoVecA.set(a);
            sO3FromTwoVecB.set(b);
            sO3FromTwoVecN.normalize();
            sO3FromTwoVecA.normalize();
            sO3FromTwoVecB.normalize();
            Matrix3x3d r1 = sO3FromTwoVec33R1;
            r1.setColumn(0, sO3FromTwoVecA);
            r1.setColumn(1, sO3FromTwoVecN);
            Vector3d.cross(sO3FromTwoVecN, sO3FromTwoVecA, temp31);
            r1.setColumn(2, temp31);
            Matrix3x3d r2 = sO3FromTwoVec33R2;
            r2.setColumn(0, sO3FromTwoVecB);
            r2.setColumn(1, sO3FromTwoVecN);
            Vector3d.cross(sO3FromTwoVecN, sO3FromTwoVecB, temp31);
            r2.setColumn(2, temp31);
            r1.transpose();
            Matrix3x3d.mult(r2, r1, result);
            return;
        }
    }

    private static void rotationPiAboutAxis(Vector3d v, Matrix3x3d result)
    {
        rotationPiAboutAxisTemp.set(v);
        rotationPiAboutAxisTemp.scale(3.1415926535897931D / rotationPiAboutAxisTemp.length());
        double invTheta = 0.31830988618379069D;
        double kA = 0.0D;
        double kB = 0.20264236728467558D;
        rodriguesSo3Exp(rotationPiAboutAxisTemp, kA, kB, result);
    }

    public static void sO3FromMu(Vector3d w, Matrix3x3d result)
    {
        double thetaSq = Vector3d.dot(w, w);
        double theta = Math.sqrt(thetaSq);
        double kA;
        double kB;
        if(thetaSq < 1E-08D)
        {
            kA = 1.0D - 0.1666666716337204D * thetaSq;
            kB = 0.5D;
        } else
        if(thetaSq < 9.9999999999999995E-07D)
        {
            kB = 0.5D - 0.041666667908430099D * thetaSq;
            kA = 1.0D - thetaSq * 0.1666666716337204D * (1.0D - 0.1666666716337204D * thetaSq);
        } else
        {
            double invTheta = 1.0D / theta;
            kA = Math.sin(theta) * invTheta;
            kB = (1.0D - Math.cos(theta)) * (invTheta * invTheta);
        }
        rodriguesSo3Exp(w, kA, kB, result);
    }

    public static void muFromSO3(Matrix3x3d so3, Vector3d result)
    {
        double cosAngle = ((so3.get(0, 0) + so3.get(1, 1) + so3.get(2, 2)) - 1.0D) * 0.5D;
        result.set((so3.get(2, 1) - so3.get(1, 2)) / 2D, (so3.get(0, 2) - so3.get(2, 0)) / 2D, (so3.get(1, 0) - so3.get(0, 1)) / 2D);
        double sinAngleAbs = result.length();
        if(cosAngle > 0.70710678118654757D)
        {
            if(sinAngleAbs > 0.0D)
                result.scale(Math.asin(sinAngleAbs) / sinAngleAbs);
        } else
        if(cosAngle > -0.70710678118654757D)
        {
            double angle = Math.acos(cosAngle);
            result.scale(angle / sinAngleAbs);
        } else
        {
            double angle = 3.1415926535897931D - Math.asin(sinAngleAbs);
            double d0 = so3.get(0, 0) - cosAngle;
            double d1 = so3.get(1, 1) - cosAngle;
            double d2 = so3.get(2, 2) - cosAngle;
            Vector3d r2 = muFromSO3R2;
            if(d0 * d0 > d1 * d1 && d0 * d0 > d2 * d2)
                r2.set(d0, (so3.get(1, 0) + so3.get(0, 1)) / 2D, (so3.get(0, 2) + so3.get(2, 0)) / 2D);
            else
            if(d1 * d1 > d2 * d2)
                r2.set((so3.get(1, 0) + so3.get(0, 1)) / 2D, d1, (so3.get(2, 1) + so3.get(1, 2)) / 2D);
            else
                r2.set((so3.get(0, 2) + so3.get(2, 0)) / 2D, (so3.get(2, 1) + so3.get(1, 2)) / 2D, d2);
            if(Vector3d.dot(r2, result) < 0.0D)
                r2.scale(-1D);
            r2.normalize();
            r2.scale(angle);
            result.set(r2);
        }
    }

    private static void rodriguesSo3Exp(Vector3d w, double kA, double kB, Matrix3x3d result)
    {
        double wx2 = w.x * w.x;
        double wy2 = w.y * w.y;
        double wz2 = w.z * w.z;
        result.set(0, 0, 1.0D - kB * (wy2 + wz2));
        result.set(1, 1, 1.0D - kB * (wx2 + wz2));
        result.set(2, 2, 1.0D - kB * (wx2 + wy2));
        double a = kA * w.z;
        double b = kB * (w.x * w.y);
        result.set(0, 1, b - a);
        result.set(1, 0, b + a);
        a = kA * w.y;
        b = kB * (w.x * w.z);
        result.set(0, 2, b + a);
        result.set(2, 0, b - a);
        a = kA * w.x;
        b = kB * (w.y * w.z);
        result.set(1, 2, b - a);
        result.set(2, 1, b + a);
    }

    public static void generatorField(int i, Matrix3x3d pos, Matrix3x3d result)
    {
        result.set(i, 0, 0.0D);
        result.set((i + 1) % 3, 0, -pos.get((i + 2) % 3, 0));
        result.set((i + 2) % 3, 0, pos.get((i + 1) % 3, 0));
    }

    private static final double M_SQRT1_2 = 0.70710678118654757D;
    private static final double ONE_6TH = 0.1666666716337204D;
    private static final double ONE_20TH = 0.1666666716337204D;
    private static Vector3d temp31 = new Vector3d();
    private static Vector3d sO3FromTwoVecN = new Vector3d();
    private static Vector3d sO3FromTwoVecA = new Vector3d();
    private static Vector3d sO3FromTwoVecB = new Vector3d();
    private static Vector3d sO3FromTwoVecRotationAxis = new Vector3d();
    private static Matrix3x3d sO3FromTwoVec33R1 = new Matrix3x3d();
    private static Matrix3x3d sO3FromTwoVec33R2 = new Matrix3x3d();
    private static Vector3d muFromSO3R2 = new Vector3d();
    private static Vector3d rotationPiAboutAxisTemp = new Vector3d();

}