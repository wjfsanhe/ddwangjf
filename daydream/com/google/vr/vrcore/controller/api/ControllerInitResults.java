// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ControllerInitResults.java

package com.google.vr.vrcore.controller.api;


public class ControllerInitResults
{

    public ControllerInitResults()
    {
    }

    public static final String toString(int i)
    {
        switch(i)
        {
        case 0: // '\0'
            return "SUCCESS";

        case 1: // '\001'
            return "FAILED_UNSUPPORTED";

        case 2: // '\002'
            return "FAILED_NOT_AUTHORIZED";

        case 3: // '\003'
            return "FAILED_CLIENT_OBSOLETE";
        }
        return (new StringBuilder(45)).append("[UNKNOWN CONTROLLER INIT RESULT: ").append(i).append("]").toString();
    }

    public static final int SUCCESS = 0;
    public static final int FAILED_UNSUPPORTED = 1;
    public static final int FAILED_NOT_AUTHORIZED = 2;
    public static final int FAILED_CLIENT_OBSOLETE = 3;
}
