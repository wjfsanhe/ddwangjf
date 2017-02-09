// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrPanoramaView.java

package com.google.vr.sdk.widgets.pano;

import android.util.Log;

// Referenced classes of package com.google.vr.sdk.widgets.pano:
//            VrPanoramaView

public static class inputType
{

    void validate()
    {
        if(inputType <= 0 || inputType >= 3)
        {
            int i;
            Log.e(VrPanoramaView.access$000(), (new StringBuilder(38)).append("Invalid Options.inputType: ").append(i = inputType).toString());
            inputType = 1;
        }
    }

    private static final int TYPE_START_MARKER = 0;
    public static final int TYPE_MONO = 1;
    public static final int TYPE_STEREO_OVER_UNDER = 2;
    private static final int TYPE_END_MARKER = 3;
    public int inputType;

    public ()
    {
        inputType = 1;
    }
}
