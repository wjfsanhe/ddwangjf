// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Controller.java

package com.google.vr.sdk.controller;


// Referenced classes of package com.google.vr.sdk.controller:
//            Controller

public static class 
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

    private ()
    {
    }
}
