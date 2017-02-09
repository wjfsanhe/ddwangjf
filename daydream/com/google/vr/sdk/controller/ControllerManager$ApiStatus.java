// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ControllerManager.java

package com.google.vr.sdk.controller;


// Referenced classes of package com.google.vr.sdk.controller:
//            ControllerManager

public static class 
{

    public static final String toString(int state)
    {
        switch(state)
        {
        case 0: // '\0'
            return "OK";

        case 1: // '\001'
            return "ERROR_UNSUPPORTED";

        case 2: // '\002'
            return "ERROR_NOT_AUTHORIZED";

        case 3: // '\003'
            return "ERROR_UNAVAILABLE";

        case 4: // '\004'
            return "ERROR_SERVICE_OBSOLETE";

        case 5: // '\005'
            return "ERROR_CLIENT_OBSOLETE";

        case 6: // '\006'
            return "ERROR_MALFUNCTION";
        }
        return (new StringBuilder(58)).append("[UNKNOWN CONTROLLER MANAGER CONNECTION STATE: ").append(state).append("]").toString();
    }

    public static final int OK = 0;
    public static final int ERROR_UNSUPPORTED = 1;
    public static final int ERROR_NOT_AUTHORIZED = 2;
    public static final int ERROR_UNAVAILABLE = 3;
    public static final int ERROR_SERVICE_OBSOLETE = 4;
    public static final int ERROR_CLIENT_OBSOLETE = 5;
    public static final int ERROR_MALFUNCTION = 6;

    private ()
    {
    }
}
