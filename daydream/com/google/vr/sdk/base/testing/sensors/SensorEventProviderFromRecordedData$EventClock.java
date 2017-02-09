// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SensorEventProviderFromRecordedData.java

package com.google.vr.sdk.base.testing.sensors;

import com.google.vr.sdk.base.sensors.Clock;

// Referenced classes of package com.google.vr.sdk.base.testing.sensors:
//            SensorEventProviderFromRecordedData

private static class 
    implements Clock
{

    public long nanoTime()
    {
        return currentTimeNs;
    }

    public void setTimeNs(long nanos)
    {
        currentTimeNs = nanos;
    }

    private long currentTimeNs;

    private ()
    {
    }

}
