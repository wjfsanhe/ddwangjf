// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Vector3d.java

package com.google.vr.sdk.base.sensors.internal;


public class Vector3d
{

    public Vector3d()
    {
    }

    public Vector3d(double xx, double yy, double zz)
    {
        set(xx, yy, zz);
    }

    public void set(double xx, double yy, double zz)
    {
        x = xx;
        y = yy;
        z = zz;
    }

    public void setComponent(int i, double val)
    {
        if(i == 0)
            x = val;
        else
        if(i == 1)
            y = val;
        else
            z = val;
    }

    public void setZero()
    {
        x = y = z = 0.0D;
    }

    public void set(Vector3d other)
    {
        x = other.x;
        y = other.y;
        z = other.z;
    }

    public void scale(double s)
    {
        x *= s;
        y *= s;
        z *= s;
    }

    public void normalize()
    {
        double d = length();
        if(d != 0.0D)
            scale(1.0D / d);
    }

    public static double dot(Vector3d a, Vector3d b)
    {
        return a.x * b.x + a.y * b.y + a.z * b.z;
    }

    public double length()
    {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public boolean sameValues(Vector3d other)
    {
        return x == other.x && y == other.y && z == other.z;
    }

    public static void add(Vector3d a, Vector3d b, Vector3d result)
    {
        result.set(a.x + b.x, a.y + b.y, a.z + b.z);
    }

    public static void sub(Vector3d a, Vector3d b, Vector3d result)
    {
        result.set(a.x - b.x, a.y - b.y, a.z - b.z);
    }

    public static void cross(Vector3d a, Vector3d b, Vector3d result)
    {
        result.set(a.y * b.z - a.z * b.y, a.z * b.x - a.x * b.z, a.x * b.y - a.y * b.x);
    }

    public static void ortho(Vector3d v, Vector3d result)
    {
        int k = largestAbsComponent(v) - 1;
        if(k < 0)
            k = 2;
        result.setZero();
        result.setComponent(k, 1.0D);
        cross(v, result, result);
        result.normalize();
    }

    public String toString()
    {
        return String.format("%+05f %+05f %+05f", new Object[] {
            Double.valueOf(x), Double.valueOf(y), Double.valueOf(z)
        });
    }

    public static int largestAbsComponent(Vector3d v)
    {
        double xAbs = Math.abs(v.x);
        double yAbs = Math.abs(v.y);
        double zAbs = Math.abs(v.z);
        if(xAbs > yAbs)
            return xAbs <= zAbs ? 2 : 0;
        return yAbs <= zAbs ? 2 : 1;
    }

    public double maxNorm()
    {
        return Math.max(Math.abs(x), Math.max(Math.abs(y), Math.abs(z)));
    }

    public double x;
    public double y;
    public double z;
}
