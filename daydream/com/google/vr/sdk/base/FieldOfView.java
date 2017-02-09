// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FieldOfView.java

package com.google.vr.sdk.base;

import android.opengl.Matrix;

public class FieldOfView
{

    public FieldOfView()
    {
        left = 60F;
        right = 60F;
        bottom = 60F;
        top = 60F;
    }

    public static FieldOfView cardboardV1FieldOfView()
    {
        FieldOfView params = new FieldOfView();
        params.setAngles(40F, 40F, 40F, 40F);
        return params;
    }

    public FieldOfView(float left, float right, float bottom, float top)
    {
        setAngles(left, right, bottom, top);
    }

    public FieldOfView(FieldOfView other)
    {
        copy(other);
    }

    public static FieldOfView parseFromProtobuf(float angles[])
    {
        if(angles.length != 4)
            return null;
        else
            return new FieldOfView(angles[0], angles[1], angles[2], angles[3]);
    }

    public float[] toProtobuf()
    {
        return (new float[] {
            left, right, bottom, top
        });
    }

    public void copy(FieldOfView other)
    {
        left = other.left;
        right = other.right;
        bottom = other.bottom;
        top = other.top;
    }

    public void setAngles(float left, float right, float bottom, float top)
    {
        this.left = left;
        this.right = right;
        this.bottom = bottom;
        this.top = top;
    }

    public void setLeft(float left)
    {
        this.left = left;
    }

    public float getLeft()
    {
        return left;
    }

    public void setRight(float right)
    {
        this.right = right;
    }

    public float getRight()
    {
        return right;
    }

    public void setBottom(float bottom)
    {
        this.bottom = bottom;
    }

    public float getBottom()
    {
        return bottom;
    }

    public void setTop(float top)
    {
        this.top = top;
    }

    public float getTop()
    {
        return top;
    }

    public void toPerspectiveMatrix(float near, float far, float perspective[], int offset)
    {
        if(offset + 16 > perspective.length)
        {
            throw new IllegalArgumentException("Not enough space to write the result");
        } else
        {
            float l = (float)(-Math.tan(Math.toRadians(left))) * near;
            float r = (float)Math.tan(Math.toRadians(right)) * near;
            float b = (float)(-Math.tan(Math.toRadians(bottom))) * near;
            float t = (float)Math.tan(Math.toRadians(top)) * near;
            Matrix.frustumM(perspective, offset, l, r, b, t, near, far);
            return;
        }
    }

    public boolean equals(Object other)
    {
        if(other == null)
            return false;
        if(other == this)
            return true;
        if(!(other instanceof FieldOfView))
        {
            return false;
        } else
        {
            FieldOfView o = (FieldOfView)other;
            return left == o.left && right == o.right && bottom == o.bottom && top == o.top;
        }
    }

    public String toString()
    {
        float f;
        return (new StringBuilder()).append("{\n").append((new StringBuilder(25)).append("  left: ").append(f = left).append(",\n").toString()).append((new StringBuilder(26)).append("  right: ").append(f = right).append(",\n").toString()).append((new StringBuilder(27)).append("  bottom: ").append(f = bottom).append(",\n").toString()).append((new StringBuilder(24)).append("  top: ").append(f = top).append(",\n").toString()).append("}").toString();
    }

    private static final float CARDBOARD_V2_2_MAX_FOV_LEFT_RIGHT = 60F;
    private static final float CARDBOARD_V2_2_MAX_FOV_BOTTOM = 60F;
    private static final float CARDBOARD_V2_2_MAX_FOV_TOP = 60F;
    private static final float CARDBOARD_V1_MAX_FOV_LEFT_RIGHT = 40F;
    private static final float CARDBOARD_V1_MAX_FOV_BOTTOM = 40F;
    private static final float CARDBOARD_V1_MAX_FOV_TOP = 40F;
    private float left;
    private float right;
    private float bottom;
    private float top;
}
