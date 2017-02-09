// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SensorEventProvider.java

package com.google.vr.sdk.base.sensors;

import android.hardware.SensorEventListener;

public interface SensorEventProvider
{

    public abstract void start();

    public abstract void stop();

    public abstract void registerListener(SensorEventListener sensoreventlistener);

    public abstract void unregisterListener(SensorEventListener sensoreventlistener);
}
