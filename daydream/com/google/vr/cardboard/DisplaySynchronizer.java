// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DisplaySynchronizer.java

package com.google.vr.cardboard;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.Choreographer;
import android.view.Display;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.vr.cardboard:
//            FrameMonitor

public class DisplaySynchronizer
    implements android.view.Choreographer.FrameCallback
{

    public DisplaySynchronizer(Context context, Display display1)
    {
        displayRotationDegrees = -1;
        lastDisplayRotationUpdateTimeNanos = 0L;
        nativeDisplaySynchronizer = nativeCreate(getClass().getClassLoader(), context.getApplicationContext());
        if(nativeDisplaySynchronizer == 0L)
        {
            throw new IllegalStateException("Native DisplaySynchronizer creation failed, implementation unavailable.");
        } else
        {
            setDisplay(display1);
            frameMonitor = new FrameMonitor(this);
            return;
        }
    }

    public void setDisplay(Display display1)
    {
        checkNativeDisplaySynchronizer();
        display = display1;
        invalidateDisplayRotation();
        float f;
        long l = (f = display1.getRefreshRate()) < 30F ? 0L : (long)((float)TimeUnit.SECONDS.toNanos(1L) / f);
        long l1 = 0L;
        if(android.os.Build.VERSION.SDK_INT >= 21)
            l1 = display1.getAppVsyncOffsetNanos();
        nativeReset(nativeDisplaySynchronizer, l, l1);
    }

    public Display getDisplay()
    {
        return display;
    }

    protected void finalize()
        throws Throwable
    {
        if(nativeDisplaySynchronizer != 0L)
        {
            Log.w("DisplaySynchronizer", "DisplaySynchronizer.shutdown() should be called to ensure resource cleanup");
            nativeDestroy(nativeDisplaySynchronizer);
        }
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public void onPause()
    {
        frameMonitor.onPause();
    }

    public void onResume()
    {
        invalidateDisplayRotation();
        frameMonitor.onResume();
    }

    public void onConfigurationChanged()
    {
        invalidateDisplayRotation();
    }

    public void shutdown()
    {
        if(nativeDisplaySynchronizer != 0L)
        {
            onPause();
            nativeDestroy(nativeDisplaySynchronizer);
            nativeDisplaySynchronizer = 0L;
        }
    }

    public long getNativeDisplaySynchronizer()
    {
        checkNativeDisplaySynchronizer();
        return nativeDisplaySynchronizer;
    }

    public void doFrame(long l)
    {
        checkNativeDisplaySynchronizer();
        if(displayRotationDegrees == -1 || l - lastDisplayRotationUpdateTimeNanos > DISPLAY_ROTATION_REFRESH_INTERVAL_NANOS)
        {
            switch(display.getRotation())
            {
            case 0: // '\0'
                displayRotationDegrees = 0;
                break;

            case 1: // '\001'
                displayRotationDegrees = 90;
                break;

            case 2: // '\002'
                displayRotationDegrees = 180;
                break;

            case 3: // '\003'
                displayRotationDegrees = 270;
                break;

            default:
                Log.e("DisplaySynchronizer", "Unknown display rotation, defaulting to 0");
                displayRotationDegrees = 0;
                break;
            }
            lastDisplayRotationUpdateTimeNanos = l;
        }
        nativeUpdate(nativeDisplaySynchronizer, l, displayRotationDegrees);
    }

    private void checkNativeDisplaySynchronizer()
    {
        if(nativeDisplaySynchronizer == 0L)
            throw new IllegalStateException("DisplaySynchronizer has already been shut down.");
        else
            return;
    }

    private void invalidateDisplayRotation()
    {
        displayRotationDegrees = -1;
    }

    protected native long nativeCreate(ClassLoader classloader, Context context);

    protected native void nativeDestroy(long l);

    protected native void nativeReset(long l, long l1, long l2);

    protected native void nativeUpdate(long l, long l1, int i);

    private static final String TAG = "DisplaySynchronizer";
    private static final boolean DEBUG = false;
    private static final float MIN_VALID_DISPLAY_REFRESH_RATE = 30F;
    public static final long DISPLAY_ROTATION_REFRESH_INTERVAL_NANOS;
    private static final int INVALID_DISPLAY_ROTATION = -1;
    private long nativeDisplaySynchronizer;
    private final FrameMonitor frameMonitor;
    private volatile Display display;
    private int displayRotationDegrees;
    private long lastDisplayRotationUpdateTimeNanos;

    static 
    {
        DISPLAY_ROTATION_REFRESH_INTERVAL_NANOS = TimeUnit.SECONDS.toNanos(1L);
    }
}
