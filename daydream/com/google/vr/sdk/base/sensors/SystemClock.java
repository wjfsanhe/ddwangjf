// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SystemClock.java

package com.google.vr.sdk.base.sensors;


// Referenced classes of package com.google.vr.sdk.base.sensors:
//            Clock

public class SystemClock
    implements Clock
{

    public SystemClock()
    {
    }

    public long nanoTime()
    {
        return System.nanoTime();
    }
}
