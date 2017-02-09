// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LowPassFilter.java

package com.google.vr.sdk.base.sensors.internal;

import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.vr.sdk.base.sensors.internal:
//            Vector3d

public class LowPassFilter
{

    public LowPassFilter(double cutoffFrequency)
    {
        timeConstantSecs = 1.0D / (6.2831853071795862D * cutoffFrequency);
    }

    public int getNumSamples()
    {
        return numSamples;
    }

    public void addSample(Vector3d sampleData, long timestampNs)
    {
        addWeightedSample(sampleData, timestampNs, 1.0D);
    }

    public void addWeightedSample(Vector3d sampleData, long timestampNs, double weight)
    {
        numSamples++;
        if(numSamples == 1)
        {
            filteredData.set(sampleData);
            lastTimestampNs = timestampNs;
            return;
        } else
        {
            double weightedDeltaSecs = weight * (double)(timestampNs - lastTimestampNs) * NANOS_TO_SECONDS;
            double alpha = weightedDeltaSecs / (timeConstantSecs + weightedDeltaSecs);
            filteredData.scale(1.0D - alpha);
            temp.set(sampleData);
            temp.scale(alpha);
            Vector3d.add(temp, filteredData, filteredData);
            lastTimestampNs = timestampNs;
            return;
        }
    }

    public Vector3d getFilteredData()
    {
        return filteredData;
    }

    private static final double NANOS_TO_SECONDS;
    private final double timeConstantSecs;
    private final Vector3d filteredData = new Vector3d();
    private long lastTimestampNs;
    private int numSamples;
    private final Vector3d temp = new Vector3d();

    static 
    {
        NANOS_TO_SECONDS = 1.0D / (double)TimeUnit.NANOSECONDS.convert(1L, TimeUnit.SECONDS);
    }
}
