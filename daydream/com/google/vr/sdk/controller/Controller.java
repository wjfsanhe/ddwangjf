// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Controller.java

package com.google.vr.sdk.controller;

import android.graphics.PointF;

// Referenced classes of package com.google.vr.sdk.controller:
//            Orientation, ControllerManager

public class Controller
{
    public static class ConnectionStates
    {

        public static final String toString(int state)
        {
            switch(state)
            {
            case 0: // '\0'
                return "DISCONNECTED";

            case 1: // '\001'
                return "SCANNING";

            case 2: // '\002'
                return "CONNECTING";

            case 3: // '\003'
                return "CONNECTED";
            }
            return (new StringBuilder(39)).append("[UNKNOWN CONTROLLER STATE: ").append(state).append("]").toString();
        }

        public static final int DISCONNECTED = 0;
        public static final int SCANNING = 1;
        public static final int CONNECTING = 2;
        public static final int CONNECTED = 3;

        private ConnectionStates()
        {
        }
    }

    public static class EventListener
    {

        public void onConnectionStateChanged(int i)
        {
        }

        public void onUpdate()
        {
        }

        public EventListener()
        {
        }
    }


    Controller(ControllerManager manager)
    {
        timestamp = 0L;
        controllerEventListener = new EventListener();
        startFromSensorTransformation = new Orientation();
        this.manager = manager;
    }

    public void setEventListener(EventListener listener)
    {
        controllerEventListener = listener;
    }

    public void update()
    {
        manager.updateController(this);
    }

    void notifyConnectionStateChange(int state)
    {
        controllerEventListener.onConnectionStateChanged(state);
    }

    void notifyUpdate()
    {
        controllerEventListener.onUpdate();
    }

    void setPublicState(Controller newValues)
    {
        timestamp = newValues.timestamp;
        orientation.w = newValues.orientation.w;
        orientation.x = newValues.orientation.x;
        orientation.y = newValues.orientation.y;
        orientation.z = newValues.orientation.z;
        isTouching = newValues.isTouching;
        touch.x = newValues.touch.x;
        touch.y = newValues.touch.y;
        System.arraycopy(newValues.position, 0, position, 0, position.length);
        appButtonState = newValues.appButtonState;
        homeButtonState = newValues.homeButtonState;
        clickButtonState = newValues.clickButtonState;
        volumeDownButtonState = newValues.volumeDownButtonState;
        volumeUpButtonState = newValues.volumeUpButtonState;
    }

    boolean setHomeButtonState(boolean down)
    {
        homeButtonState = down;
        if(!enableRecenterShim)
            return false;
        if(homeButtonState)
        {
            homeButtonDownTimestamp = timestamp;
        } else
        {
            long downtime = timestamp - homeButtonDownTimestamp;
            if(downtime > 0x23c34600L)
            {
                float angles[] = controllerPoseInSensorSpace.toEulerAngles(new float[3]);
                if(Math.abs(angles[0]) < RECENTER_PITCH_BOUNDS_RADIANS)
                {
                    setStartFromSensorTransformation();
                    return true;
                }
            }
        }
        return false;
    }

    void setOrientationInSensorSpace(float x, float y, float z, float w)
    {
        controllerPoseInSensorSpace.set(x, y, z, w);
        orientation.set(startFromSensorTransformation);
        orientation.multiply(controllerPoseInSensorSpace);
    }

    private void setStartFromSensorTransformation()
    {
        float angles[] = controllerPoseInSensorSpace.toEulerAngles(new float[3]);
        startFromSensorTransformation = new Orientation(0.0F, (float)Math.sin(-angles[1] / 2.0F), 0.0F, (float)Math.cos(angles[1] / 2.0F));
    }

    static final int MIN_VRCORE_API_WITH_RECENTERING = 8;
    private static final int DURATION_REQUIRED_TO_RECENTER_NS = 0x23c34600;
    private static final float RECENTER_PITCH_BOUNDS_RADIANS = (float)Math.toRadians(30D);
    public long timestamp;
    public final Orientation orientation = new Orientation();
    public final float position[] = new float[3];
    public boolean isTouching;
    public final PointF touch = new PointF();
    public boolean clickButtonState;
    public boolean appButtonState;
    public boolean homeButtonState;
    public boolean volumeUpButtonState;
    public boolean volumeDownButtonState;
    private final ControllerManager manager;
    private EventListener controllerEventListener;
    boolean enableRecenterShim;
    private final Orientation controllerPoseInSensorSpace = new Orientation();
    private Orientation startFromSensorTransformation;
    private long homeButtonDownTimestamp;

}
