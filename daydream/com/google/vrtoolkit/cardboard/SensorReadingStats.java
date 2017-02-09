// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SensorReadingStats.java

package com.google.vrtoolkit.cardboard;


class SensorReadingStats
{

    SensorReadingStats(int i, int j)
    {
        sampleBufSize = i;
        numAxes = j;
        if(i <= 0)
            throw new IllegalArgumentException("sampleBufSize is invalid.");
        if(j <= 0)
        {
            throw new IllegalArgumentException("numAxes is invalid.");
        } else
        {
            sampleBuf = new float[i][j];
            return;
        }
    }

    void addSample(float af[])
    {
        if(af.length < numAxes)
            throw new IllegalArgumentException("values.length is less than # of axes.");
        writePos = (writePos + 1) % sampleBufSize;
        for(int i = 0; i < numAxes; i++)
            sampleBuf[writePos][i] = af[i];

        samplesAdded++;
    }

    void reset()
    {
        samplesAdded = 0;
        writePos = 0;
    }

    boolean statsAvailable()
    {
        return samplesAdded >= sampleBufSize;
    }

    float getAverage(int i)
    {
        if(!statsAvailable())
            throw new IllegalStateException("Average not available. Not enough samples.");
        if(i < 0 || i >= numAxes)
        {
            int j = numAxes - 1;
            throw new IllegalStateException((new StringBuilder(38)).append("axis must be between 0 and ").append(j).toString());
        }
        float f = 0.0F;
        for(int k = 0; k < sampleBufSize; k++)
            f += sampleBuf[k][i];

        return f / (float)sampleBufSize;
    }

    float getMaxAbsoluteDeviation(int i)
    {
        if(i < 0 || i >= numAxes)
        {
            int j = numAxes - 1;
            throw new IllegalStateException((new StringBuilder(38)).append("axis must be between 0 and ").append(j).toString());
        }
        float f = getAverage(i);
        float f1 = 0.0F;
        for(int k = 0; k < sampleBufSize; k++)
            f1 = Math.max(Math.abs(sampleBuf[k][i] - f), f1);

        return f1;
    }

    float getMaxAbsoluteDeviation()
    {
        float f = 0.0F;
        for(int i = 0; i < numAxes; i++)
            f = Math.max(f, getMaxAbsoluteDeviation(i));

        return f;
    }

    private static final String TAG = com/google/vrtoolkit/cardboard/SensorReadingStats.getSimpleName();
    private int sampleBufSize;
    private int numAxes;
    private float sampleBuf[][];
    private int writePos;
    private int samplesAdded;

}
