// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Viewport.java

package com.google.vr.sdk.base;

import android.opengl.GLES20;

public class Viewport
{

    public Viewport()
    {
    }

    public void setViewport(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setGLViewport()
    {
        GLES20.glViewport(x, y, width, height);
    }

    public void setGLScissor()
    {
        GLES20.glScissor(x, y, width, height);
    }

    public void getAsArray(int array[], int offset)
    {
        if(offset + 4 > array.length)
        {
            throw new IllegalArgumentException("Not enough space to write the result");
        } else
        {
            array[offset] = x;
            array[offset + 1] = y;
            array[offset + 2] = width;
            array[offset + 3] = height;
            return;
        }
    }

    public String toString()
    {
        int i;
        return (new StringBuilder()).append("{\n").append((new StringBuilder(18)).append("  x: ").append(i = x).append(",\n").toString()).append((new StringBuilder(18)).append("  y: ").append(i = y).append(",\n").toString()).append((new StringBuilder(22)).append("  width: ").append(i = width).append(",\n").toString()).append((new StringBuilder(23)).append("  height: ").append(i = height).append(",\n").toString()).append("}").toString();
    }

    public boolean equals(Object obj)
    {
        if(obj == this)
            return true;
        if(!(obj instanceof Viewport))
        {
            return false;
        } else
        {
            Viewport other = (Viewport)obj;
            return x == other.x && y == other.y && width == other.width && height == other.height;
        }
    }

    public int hashCode()
    {
        return Integer.valueOf(x).hashCode() ^ Integer.valueOf(y).hashCode() ^ Integer.valueOf(width).hashCode() ^ Integer.valueOf(height).hashCode();
    }

    public int x;
    public int y;
    public int width;
    public int height;
}
