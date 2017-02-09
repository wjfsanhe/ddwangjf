// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SensorEventProviderFromRecordedData.java

package com.google.vr.sdk.base.testing.sensors;

import android.hardware.SensorEventListener;
import com.google.vr.sdk.base.sensors.Clock;
import com.google.vr.sdk.base.sensors.SensorEventProvider;
import java.util.*;

// Referenced classes of package com.google.vr.sdk.base.testing.sensors:
//            SensorEventAndTime

public class SensorEventProviderFromRecordedData
    implements SensorEventProvider
{
    private static class EventClock
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

        private EventClock()
        {
        }

    }


    public SensorEventProviderFromRecordedData(List events)
    {
        eventsIterator = null;
        eventClock = new EventClock();
        this.events = events;
    }

    public void start()
    {
        reset();
        next();
    }

    public void reset()
    {
        eventsIterator = events.listIterator();
    }

    public void stop()
    {
    }

    public boolean atEnd()
    {
        return !eventsIterator.hasNext();
    }

    public boolean next()
    {
        if(atEnd())
            return false;
        SensorEventAndTime currentEvent = (SensorEventAndTime)eventsIterator.next();
        eventClock.setTimeNs(currentEvent.timeNs);
        synchronized(registeredListeners)
        {
            SensorEventListener listener;
            for(Iterator iterator = registeredListeners.iterator(); iterator.hasNext(); listener.onSensorChanged(currentEvent.event))
                listener = (SensorEventListener)iterator.next();

        }
        return true;
    }

    public void registerListener(SensorEventListener listener)
    {
        synchronized(registeredListeners)
        {
            registeredListeners.add(listener);
        }
    }

    public void unregisterListener(SensorEventListener listener)
    {
        synchronized(registeredListeners)
        {
            registeredListeners.remove(listener);
        }
    }

    public Clock getClock()
    {
        return eventClock;
    }

    private final List events;
    private ListIterator eventsIterator;
    private EventClock eventClock;
    private final List registeredListeners = new ArrayList();
}
