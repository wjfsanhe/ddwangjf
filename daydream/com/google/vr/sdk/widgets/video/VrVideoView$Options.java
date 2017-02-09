// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrVideoView.java

package com.google.vr.sdk.widgets.video;

import android.util.Log;

// Referenced classes of package com.google.vr.sdk.widgets.video:
//            VrVideoView

public static class inputType
{

    public void validate()
    {
        if(inputFormat <= 0 || inputFormat >= 3)
        {
            int i;
            Log.e(VrVideoView.access$000(), (new StringBuilder(40)).append("Invalid Options.inputFormat: ").append(i = inputFormat).toString());
            inputFormat = 1;
        }
        if(inputType <= 0 || inputFormat >= 3)
        {
            int j;
            Log.e(VrVideoView.access$000(), (new StringBuilder(38)).append("Invalid Options.inputType: ").append(j = inputType).toString());
            inputType = 1;
        }
    }

    private static final int FORMAT_START_MARKER = 0;
    public static final int FORMAT_DEFAULT = 1;
    public static final int FORMAT_HLS = 2;
    private static final int FORMAT_END_MARKER = 3;
    public int inputFormat;
    private static final int TYPE_START_MARKER = 0;
    public static final int TYPE_MONO = 1;
    public static final int TYPE_STEREO_OVER_UNDER = 2;
    private static final int TYPE_END_MARKER = 3;
    public int inputType;

    public _cls9()
    {
        inputFormat = 1;
        inputType = 1;
    }
}
