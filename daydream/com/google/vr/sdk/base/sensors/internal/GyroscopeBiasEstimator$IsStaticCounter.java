// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GyroscopeBiasEstimator.java

package com.google.vr.sdk.base.sensors.internal;


// Referenced classes of package com.google.vr.sdk.base.sensors.internal:
//            GyroscopeBiasEstimator

private static class minStaticFrames
{

    void appendFrame(boolean isStatic)
    {
        if(!isStatic)
            consecutiveIsStatic = 0;
        else
            consecutiveIsStatic++;
    }

    boolean isRecentlyStatic()
    {
        return consecutiveIsStatic >= minStaticFrames;
    }

    private final int minStaticFrames;
    private int consecutiveIsStatic;

    (int minStaticFrames)
    {
        this.minStaticFrames = minStaticFrames;
    }
}
