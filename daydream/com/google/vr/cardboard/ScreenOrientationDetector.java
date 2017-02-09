// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ScreenOrientationDetector.java

package com.google.vr.cardboard;

import android.content.Context;
import android.view.OrientationEventListener;

public class ScreenOrientationDetector extends OrientationEventListener
{
    public static interface Listener
    {

        public abstract void onScreenOrientationChanged(int i);
    }

    public abstract class Orientation
    {

        public static final int UNKNOWN = -1;
        public static final int LANDSCAPE = 0;
        public static final int LANDSCAPE_REVERSE = 1;
        public static final int PORTRAIT = 2;
        public static final int PORTRAIT_REVERSE = 3;

        public Orientation()
        {
        }
    }


    public ScreenOrientationDetector(Context context, Listener listener)
    {
        this(context, listener, 30, 10);
    }

    public ScreenOrientationDetector(Context context, Listener listener, int i, int j)
    {
        super(context);
        currentScreenOrientation = -1;
        if(i + j > 90)
        {
            throw new IllegalArgumentException("Portrait and landscape detection thresholds must sum to to <= 90 degrees");
        } else
        {
            clientListener = listener;
            portraitToleranceDegrees = i;
            landscapeToleranceDegrees = j;
            return;
        }
    }

    public void enable()
    {
        currentScreenOrientation = -1;
        super.enable();
    }

    public void disable()
    {
        super.disable();
        currentScreenOrientation = -1;
    }

    public void onOrientationChanged(int i)
    {
        int j;
        if((j = determineScreenOrientation(i)) != currentScreenOrientation)
        {
            currentScreenOrientation = j;
            clientListener.onScreenOrientationChanged(j);
        }
    }

    public int getCurrentScreenOrientation()
    {
        return currentScreenOrientation;
    }

    private int determineScreenOrientation(int i)
    {
        if(i == -1)
            return -1;
        if((i %= 360) <= portraitToleranceDegrees || i >= 360 - portraitToleranceDegrees)
            return 2;
        if(Math.abs(i - 90) <= landscapeToleranceDegrees)
            return 1;
        if(Math.abs(i - 180) <= portraitToleranceDegrees)
            return 3;
        if(Math.abs(i - 270) <= landscapeToleranceDegrees)
            return 0;
        else
            return currentScreenOrientation;
    }

    private static final int DEFAULT_PORTRAIT_TOLERANCE_DEGREES = 30;
    private static final int DEFAULT_LANDSCAPE_TOLERANCE_DEGREES = 10;
    private final Listener clientListener;
    private final int landscapeToleranceDegrees;
    private final int portraitToleranceDegrees;
    private int currentScreenOrientation;
}
