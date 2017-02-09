// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GvrViewerParams.java

package com.google.vr.sdk.base;

import android.util.Log;
import com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice;

// Referenced classes of package com.google.vr.sdk.base:
//            GvrViewerParams

public static final class protoValue extends Enum
{

    public static protoValue[] values()
    {
        return (protoValue[])$VALUES.clone();
    }

    public static e_3B_.clone valueOf(String name)
    {
        return (e_3B_.clone)Enum.valueOf(com/google/vr/sdk/base/GvrViewerParams$VerticalAlignmentType, name);
    }

    int toProtoValue()
    {
        return protoValue;
    }

    static protoValue fromProtoValue(int protoValue)
    {
        protoValue aprotovalue[] = values();
        int i = aprotovalue.length;
        for(int j = 0; j < i; j++)
        {
            protoValue type = aprotovalue[j];
            if(type.protoValue == protoValue)
                return type;
        }

        Log.e("GvrViewerParams", String.format("Unknown alignment type from proto: %d", new Object[] {
            Integer.valueOf(protoValue)
        }));
        return BOTTOM;
    }

    public static final TOP BOTTOM;
    public static final TOP CENTER;
    public static final TOP TOP;
    private final int protoValue;
    private static final TOP $VALUES[];

    static 
    {
        BOTTOM = new <init>("BOTTOM", 0, 0);
        CENTER = new <init>("CENTER", 1, 1);
        TOP = new <init>("TOP", 2, 2);
        $VALUES = (new .VALUES[] {
            BOTTOM, CENTER, TOP
        });
    }

    private iceParams.VerticalAlignmentType(String s, int i, int protoValue)
    {
        super(s, i);
        this.protoValue = protoValue;
    }
}
