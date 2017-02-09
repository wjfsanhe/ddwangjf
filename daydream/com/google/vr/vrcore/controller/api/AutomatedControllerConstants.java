// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AutomatedControllerConstants.java

package com.google.vr.vrcore.controller.api;


public final class AutomatedControllerConstants
{
    public final class TouchEvent
    {

        public static final String TYPE = "touch";
        public static final String ACTION_KEY = "touch-action";
        public static final String X_KEY = "touch-x";
        public static final String Y_KEY = "touch-y";
        public static final String TIME_NANO_KEY = "time-nanos";

        public TouchEvent()
        {
        }
    }

    public final class OrientationEvent
    {

        public static final String TYPE = "orientation";
        public static final String QX_KEY = "qx";
        public static final String QY_KEY = "qy";
        public static final String QZ_KEY = "qz";
        public static final String QW_KEY = "qw";
        public static final String TIME_NANO_KEY = "time-nanos";

        public OrientationEvent()
        {
        }
    }

    public final class ButtonEvent
    {

        public static final String TYPE = "button";
        public static final String IS_PRESSING_KEY = "pressing";
        public static final String BUTTON_KEY = "button";
        public static final String TIME_NANO_KEY = "delay-nanos";

        public ButtonEvent()
        {
        }
    }


    private AutomatedControllerConstants()
        throws IllegalAccessException
    {
        throw new IllegalAccessException("This is class of constants, you may not create an object");
    }

    public static final String VRCORE_ACTION_AUTOMATION = "com.google.vr.vrcore.ACTION_AUTOMATION";
    public static final String PAPRIKA_DATA_KEY = "paprika-data";
    public static final String EVENT_TYPE_KEY = "event-type";
}
