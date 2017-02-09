// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ThrottlingMonitor.java

package com.google.vr.ndk.base;

import android.content.*;
import android.os.*;
import android.util.Log;
import com.google.vr.vrcore.performance.api.*;
import java.util.ArrayList;

public class ThrottlingMonitor
    implements AutoCloseable
{
    public static interface TemperatureTrigger
    {

        public abstract void onTemperatureEvent(float f, long l);
    }

    public static interface SetupCallback
    {

        public abstract void onInitialized();
    }

    private static class ThrottlingTriggerCallback extends com.google.vr.vrcore.performance.api.IThrottlingTriggerCallback.Stub
    {

        public void onTriggerActivated(final float temperature, final long timeRemaining)
        {
            if(handler == null)
            {
                trigger.onTemperatureEvent(temperature, timeRemaining);
                return;
            } else
            {
                handler.post(new Runnable() {

                    public void run()
                    {
                        trigger.onTemperatureEvent(temperature, timeRemaining);
                    }

                    final float val$temperature;
                    final long val$timeRemaining;
                    final ThrottlingTriggerCallback this$0;

                
                {
                    this$0 = ThrottlingTriggerCallback.this;
                    temperature = f;
                    timeRemaining = l;
                    super();
                }
                });
                return;
            }
        }

        private final TemperatureTrigger trigger;
        private final Handler handler;


        public ThrottlingTriggerCallback(TemperatureTrigger temperaturetrigger, Handler handler1)
        {
            trigger = temperaturetrigger;
            handler = handler1;
        }
    }


    private ThrottlingMonitor(Context context1)
    {
        context = context1;
        mainHandler = new Handler(context1.getMainLooper());
    }

    public static ThrottlingMonitor create(Context context1)
    {
        Intent intent;
        (intent = new Intent("com.google.vr.vrcore.performance.service.BIND")).setPackage("com.google.vr.vrcore");
        ThrottlingMonitor throttlingmonitor = new ThrottlingMonitor(context1);
        if(!context1.bindService(intent, throttlingmonitor.connection, 1))
            return null;
        else
            return throttlingmonitor;
    }

    public void registerSetupCallback(final SetupCallback callback)
    {
label0:
        {
            synchronized(lock)
            {
                if(perfService == null)
                    break label0;
                mainHandler.post(new Runnable() {

                    public void run()
                    {
                        callback.onInitialized();
                    }

                    final SetupCallback val$callback;

            
            {
                callback = setupcallback;
                super();
            }
                });
            }
            return;
        }
        setupCallbacks.add(callback);
        obj;
        JVM INSTR monitorexit ;
    }

    public int queryRelativeTemperature(TimestampedTemperature timestampedtemperature)
    {
        IPerformanceService iperformanceservice;
        synchronized(lock)
        {
            iperformanceservice = perfService;
        }
        if(iperformanceservice == null)
            return -3;
        try
        {
            iperformanceservice.getCurrentThrottlingRelativeTemperature(timestampedtemperature);
        }
        catch(RemoteException remoteexception)
        {
            String s;
            Log.e("ThrottlingMonitor", (new StringBuilder(29 + String.valueOf(s = String.valueOf(remoteexception)).length())).append("Service failed unexpectedly: ").append(s).toString());
            return -5;
        }
        catch(SecurityException _ex)
        {
            return -2;
        }
        catch(UnsupportedOperationException _ex)
        {
            Log.w("ThrottlingMonitor", "Throttling monitoring not supported on this device.");
            return -1;
        }
        return timestampedtemperature.temperature != 1.401298E-45F ? 0 : -4;
    }

    public int addTrigger(ComponentName componentname, float f, TemperatureTrigger temperaturetrigger, long l, Handler handler)
    {
        return addTriggerInternal(componentname, 3, f, temperaturetrigger, l, handler);
    }

    public int addTrigger(ComponentName componentname, TemperatureTrigger temperaturetrigger, long l, Handler handler)
    {
        return addTriggerInternal(componentname, 1, 0.0F, temperaturetrigger, l, handler);
    }

    public int addTrigger(ComponentName componentname, float f, TemperatureTrigger temperaturetrigger, Handler handler)
    {
        return addTriggerInternal(componentname, 2, f, temperaturetrigger, 0L, handler);
    }

    public int removeAllTriggers(ComponentName componentname)
    {
        IPerformanceService iperformanceservice;
        synchronized(lock)
        {
            iperformanceservice = perfService;
        }
        if(iperformanceservice == null)
            return -3;
        try
        {
            iperformanceservice.removeAllTriggers(componentname);
        }
        catch(RemoteException remoteexception)
        {
            String s;
            Log.e("ThrottlingMonitor", (new StringBuilder(29 + String.valueOf(s = String.valueOf(remoteexception)).length())).append("Service failed unexpectedly: ").append(s).toString());
            return -5;
        }
        catch(SecurityException _ex)
        {
            return -2;
        }
        catch(UnsupportedOperationException _ex)
        {
            Log.w("ThrottlingMonitor", "Throttling monitoring not supported on this device.");
            return -1;
        }
        return 0;
    }

    public long getEstimatedThrottlingTimeNanos()
    {
        IPerformanceService iperformanceservice;
        synchronized(lock)
        {
            iperformanceservice = perfService;
        }
        if(iperformanceservice == null)
            return -3L;
        long l;
        try
        {
            l = iperformanceservice.getCurrentEstimatedThrottleWarningTime();
        }
        catch(RemoteException remoteexception)
        {
            String s;
            Log.e("ThrottlingMonitor", (new StringBuilder(29 + String.valueOf(s = String.valueOf(remoteexception)).length())).append("Service failed unexpectedly: ").append(s).toString());
            return -5L;
        }
        catch(SecurityException _ex)
        {
            return -2L;
        }
        catch(UnsupportedOperationException _ex)
        {
            Log.w("ThrottlingMonitor", "Throttling monitoring not supported on this device.");
            return -1L;
        }
        if(l < 0L)
            return -4L;
        else
            return l;
    }

    public void close()
    {
        context.unbindService(connection);
    }

    private int addTriggerInternal(ComponentName componentname, int i, float f, TemperatureTrigger temperaturetrigger, long l, Handler handler)
    {
        if(temperaturetrigger == null)
            throw new IllegalArgumentException("Argument 'trigger' cannot be null.");
        IPerformanceService iperformanceservice;
        synchronized(lock)
        {
            iperformanceservice = perfService;
        }
        if(iperformanceservice == null)
            return -3;
        ThrottlingTriggerCallback throttlingtriggercallback = new ThrottlingTriggerCallback(temperaturetrigger, handler);
        try
        {
            iperformanceservice.addTrigger(componentname, throttlingtriggercallback, l, f, i);
        }
        catch(RemoteException remoteexception)
        {
            String s;
            Log.e("ThrottlingMonitor", (new StringBuilder(29 + String.valueOf(s = String.valueOf(remoteexception)).length())).append("Service failed unexpectedly: ").append(s).toString());
            return -5;
        }
        catch(SecurityException _ex)
        {
            return -2;
        }
        catch(UnsupportedOperationException _ex)
        {
            Log.w("ThrottlingMonitor", "Throttling monitoring not supported on this device.");
            return -1;
        }
        return 0;
    }

    private static final String TAG = "ThrottlingMonitor";
    public static final int SUCCESS = 0;
    public static final int ERROR_NOT_SUPPORTED = -1;
    public static final int ERROR_NO_PERMISSION = -2;
    public static final int ERROR_NOT_CONNECTED = -3;
    public static final int ERROR_NOT_ACCURATE = -4;
    public static final int ERROR_UNKNOWN = -5;
    private final Object lock = new Object();
    private final Context context;
    private final Handler mainHandler;
    private IPerformanceService perfService;
    private final ArrayList setupCallbacks = new ArrayList();
    private final ServiceConnection connection = new ServiceConnection() {

        public void onServiceConnected(ComponentName componentname, IBinder ibinder)
        {
            ArrayList arraylist = new ArrayList();
            synchronized(lock)
            {
                perfService = com.google.vr.vrcore.performance.api.IPerformanceService.Stub.asInterface(ibinder);
                arraylist.addAll(setupCallbacks);
                setupCallbacks.clear();
                lock.notifyAll();
            }
            ArrayList arraylist1;
            int i = (arraylist1 = (ArrayList)arraylist).size();
            int j = 0;
            Object obj1 = null;
            while(j < i) 
            {
                j++;
                SetupCallback setupcallback;
                (setupcallback = (SetupCallback)arraylist1.get(j)).onInitialized();
            }
        }

        public void onServiceDisconnected(ComponentName componentname)
        {
            synchronized(lock)
            {
                perfService = null;
                lock.notifyAll();
            }
        }

        final ThrottlingMonitor this$0;

            
            {
                this$0 = ThrottlingMonitor.this;
                super();
            }
    };



}
