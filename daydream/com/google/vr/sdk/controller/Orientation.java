// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Orientation.java

package com.google.vr.sdk.controller;

import java.util.Locale;

public class Orientation
{

    Orientation()
    {
        set(0.0F, 0.0F, 0.0F, 1.0F);
    }

    Orientation(float x, float y, float z, float w)
    {
        set(x, y, z, w);
    }

    void set(float x, float y, float z, float w)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    void set(Orientation o)
    {
        set(o.x, o.y, o.z, o.w);
    }

    public String toString()
    {
        return String.format(Locale.US, "%5.2fi %5.2fj %5.2fk %5.2f", new Object[] {
            Float.valueOf(x), Float.valueOf(y), Float.valueOf(z), Float.valueOf(w)
        });
    }

    public String toAxisAngleString()
    {
        float ang = (float)Math.toDegrees(2D * Math.acos(w));
        float sqrt = (float)Math.sqrt(1.0F - w * w);
        float vecX = sqrt <= 0.0F ? 0.0F : x / sqrt;
        float vecY = sqrt <= 0.0F ? 0.0F : y / sqrt;
        float vecZ = sqrt <= 0.0F ? 0.0F : z / sqrt;
        return String.format(Locale.US, "(%5.2f, %5.2f, %5.2f), %3.0f\260", new Object[] {
            Float.valueOf(vecX), Float.valueOf(vecY), Float.valueOf(vecZ), Float.valueOf(ang)
        });
    }

    void multiply(Orientation o)
    {
        float x0 = x;
        float y0 = y;
        float z0 = z;
        float w0 = w;
        x = (o.w * x0 + o.x * w0 + o.z * y0) - o.y * z0;
        y = (o.w * y0 + o.y * w0 + o.x * z0) - o.z * x0;
        z = (o.w * z0 + o.z * w0 + o.y * x0) - o.x * y0;
        w = o.w * w0 - o.x * x0 - o.y * y0 - o.z * z0;
    }

    float[] toEulerAngles(float angles[])
    {
        float test = z * y + x * w;
        if(Math.abs(test) < 0.4999F)
        {
            angles[0] = (float)Math.asin(2.0F * test);
            angles[1] = (float)Math.atan2(2.0F * y * w - 2.0F * z * x, 1.0F - 2.0F * y * y - 2.0F * x * x);
            angles[2] = (float)Math.atan2(2.0F * z * w - 2.0F * y * x, 1.0F - 2.0F * z * z - 2.0F * x * x);
        } else
        {
            angles[0] = (float)Math.copySign(1.5707963267948966D, test);
            angles[1] = (float)((double)Math.copySign(2.0F, test) * Math.atan2(z, w));
            angles[2] = 0.0F;
        }
        return angles;
    }

    public float[] toRotationMatrix(float output[])
    {
        output[0] = 1.0F - 2.0F * y * y - 2.0F * z * z;
        output[1] = 2.0F * x * y + 2.0F * z * w;
        output[2] = 2.0F * x * z - 2.0F * y * w;
        output[3] = 0.0F;
        output[4] = 2.0F * x * y - 2.0F * z * w;
        output[5] = 1.0F - 2.0F * x * x - 2.0F * z * z;
        output[6] = 2.0F * y * z + 2.0F * x * w;
        output[7] = 0.0F;
        output[8] = 2.0F * x * z + 2.0F * y * w;
        output[9] = 2.0F * y * z - 2.0F * x * w;
        output[10] = 1.0F - 2.0F * x * x - 2.0F * y * y;
        output[11] = 0.0F;
        output[12] = 0.0F;
        output[13] = 0.0F;
        output[14] = 0.0F;
        output[15] = 1.0F;
        return output;
    }

    public float x;
    public float y;
    public float z;
    public float w;
}
