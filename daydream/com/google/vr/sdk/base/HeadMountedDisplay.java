// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   HeadMountedDisplay.java

package com.google.vr.sdk.base;


// Referenced classes of package com.google.vr.sdk.base:
//            ScreenParams, GvrViewerParams

public class HeadMountedDisplay
{

    public HeadMountedDisplay(ScreenParams screenParams, GvrViewerParams gvrViewerParams)
    {
        screen = screenParams;
        cardboardDevice = gvrViewerParams;
    }

    public HeadMountedDisplay(HeadMountedDisplay hmd)
    {
        screen = new ScreenParams(hmd.screen);
        cardboardDevice = new GvrViewerParams(hmd.cardboardDevice);
    }

    public void setScreenParams(ScreenParams screen)
    {
        this.screen = new ScreenParams(screen);
    }

    public ScreenParams getScreenParams()
    {
        return screen;
    }

    public void setGvrViewerParams(GvrViewerParams gvrViewerParams)
    {
        cardboardDevice = new GvrViewerParams(gvrViewerParams);
    }

    public GvrViewerParams getGvrViewerParams()
    {
        return cardboardDevice;
    }

    public boolean equals(Object other)
    {
        if(other == null)
            return false;
        if(other == this)
            return true;
        if(!(other instanceof HeadMountedDisplay))
        {
            return false;
        } else
        {
            HeadMountedDisplay o = (HeadMountedDisplay)other;
            return screen.equals(o.screen) && cardboardDevice.equals(o.cardboardDevice);
        }
    }

    private ScreenParams screen;
    private GvrViewerParams cardboardDevice;
}
