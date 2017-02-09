// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrPanoramaRenderer.java

package com.google.vr.sdk.widgets.pano;

import com.google.vr.sdk.widgets.common.VrEventListener;
import com.google.vr.sdk.widgets.common.VrWidgetRenderer;

// Referenced classes of package com.google.vr.sdk.widgets.pano:
//            VrPanoramaView, VrPanoramaRenderer

private class eventListener
    implements com.google.vr.sdk.widgets.common.entListener
{

    public void execute()
    {
        VrPanoramaRenderer.access$300(VrPanoramaRenderer.this, VrPanoramaRenderer.access$200(VrPanoramaRenderer.this), jpegImageData, options, eventListener);
    }

    public final byte jpegImageData[];
    public final eventListener options;
    public final VrEventListener eventListener;
    final VrPanoramaRenderer this$0;

    public (byte jpegImageData[],  options, VrEventListener eventListener)
    {
        this$0 = VrPanoramaRenderer.this;
        super();
        this.jpegImageData = jpegImageData;
        this.options = options;
        this.eventListener = eventListener;
    }
}
