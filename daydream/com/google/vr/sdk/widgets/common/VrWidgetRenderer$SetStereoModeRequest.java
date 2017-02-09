// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrWidgetRenderer.java

package com.google.vr.sdk.widgets.common;


// Referenced classes of package com.google.vr.sdk.widgets.common:
//            VrWidgetRenderer

private class stereoMode
    implements stereoMode
{

    public void execute()
    {
        nativeSetStereoMode(VrWidgetRenderer.access$000(VrWidgetRenderer.this), stereoMode);
    }

    public final boolean stereoMode;
    final VrWidgetRenderer this$0;

    public (boolean stereoMode)
    {
        this$0 = VrWidgetRenderer.this;
        super();
        this.stereoMode = stereoMode;
    }
}
