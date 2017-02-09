// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ScreenParams.java

package com.google.vr.sdk.base;

import android.util.DisplayMetrics;
import android.view.Display;
import com.google.vr.cardboard.DisplayUtils;
import com.google.vrtoolkit.cardboard.proto.nano.Phone;

public class ScreenParams
{

    public ScreenParams(Display display)
    {
        DisplayMetrics metrics = DisplayUtils.getDisplayMetricsLandscape(display);
        xMetersPerPixel = DisplayUtils.getMetersPerPixelFromDotsPerInch(metrics.xdpi);
        yMetersPerPixel = DisplayUtils.getMetersPerPixelFromDotsPerInch(metrics.ydpi);
        width = metrics.widthPixels;
        height = metrics.heightPixels;
        borderSizeMeters = DisplayUtils.getBorderSizeMeters(null);
        if(height > width)
        {
            int tempPx = width;
            width = height;
            height = tempPx;
            float tempMetersPerPixel = xMetersPerPixel;
            xMetersPerPixel = yMetersPerPixel;
            yMetersPerPixel = tempMetersPerPixel;
        }
    }

    public static ScreenParams fromProto(Display display, com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams params)
    {
        if(params == null)
            return null;
        ScreenParams screenParams = new ScreenParams(display);
        if(params.hasXPpi())
            screenParams.xMetersPerPixel = DisplayUtils.getMetersPerPixelFromDotsPerInch(params.getXPpi());
        if(params.hasYPpi())
            screenParams.yMetersPerPixel = DisplayUtils.getMetersPerPixelFromDotsPerInch(params.getYPpi());
        screenParams.borderSizeMeters = DisplayUtils.getBorderSizeMeters(params);
        return screenParams;
    }

    public ScreenParams(ScreenParams params)
    {
        width = params.width;
        height = params.height;
        xMetersPerPixel = params.xMetersPerPixel;
        yMetersPerPixel = params.yMetersPerPixel;
        borderSizeMeters = params.borderSizeMeters;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getWidth()
    {
        return width;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public int getHeight()
    {
        return height;
    }

    public float getWidthMeters()
    {
        return (float)width * xMetersPerPixel;
    }

    public float getHeightMeters()
    {
        return (float)height * yMetersPerPixel;
    }

    public void setBorderSizeMeters(float displayBorderSize)
    {
        borderSizeMeters = displayBorderSize;
    }

    public float getBorderSizeMeters()
    {
        return borderSizeMeters;
    }

    public boolean equals(Object other)
    {
        if(other == null)
            return false;
        if(other == this)
            return true;
        if(!(other instanceof ScreenParams))
        {
            return false;
        } else
        {
            ScreenParams o = (ScreenParams)other;
            return width == o.width && height == o.height && xMetersPerPixel == o.xMetersPerPixel && yMetersPerPixel == o.yMetersPerPixel && borderSizeMeters == o.borderSizeMeters;
        }
    }

    public String toString()
    {
        float f;
        return (new StringBuilder()).append("{\n").append((new StringBuilder(22)).append("  width: ").append(f = width).append(",\n").toString()).append((new StringBuilder(23)).append("  height: ").append(f = height).append(",\n").toString()).append((new StringBuilder(39)).append("  x_meters_per_pixel: ").append(f = xMetersPerPixel).append(",\n").toString()).append((new StringBuilder(39)).append("  y_meters_per_pixel: ").append(f = yMetersPerPixel).append(",\n").toString()).append((new StringBuilder(39)).append("  border_size_meters: ").append(f = borderSizeMeters).append(",\n").toString()).append("}").toString();
    }

    private int width;
    private int height;
    private float xMetersPerPixel;
    private float yMetersPerPixel;
    private float borderSizeMeters;
}
