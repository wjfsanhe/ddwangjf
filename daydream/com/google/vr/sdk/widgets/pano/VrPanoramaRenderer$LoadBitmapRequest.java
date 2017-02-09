// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrPanoramaRenderer.java

package com.google.vr.sdk.widgets.pano;

import android.graphics.Bitmap;
import com.google.vr.sdk.widgets.common.VrEventListener;
import com.google.vr.sdk.widgets.common.VrWidgetRenderer;

// Referenced classes of package com.google.vr.sdk.widgets.pano:
//            VrPanoramaView, VrPanoramaRenderer

private class eventListener
    implements com.google.vr.sdk.widgets.common.entListener
{

    public void execute()
    {
        VrPanoramaRenderer.access$100(VrPanoramaRenderer.this, VrPanoramaRenderer.access$000(VrPanoramaRenderer.this), bitmap, options, eventListener);
    }

    public final Bitmap bitmap;
    public final eventListener options;
    public final VrEventListener eventListener;
    final VrPanoramaRenderer this$0;

    public I(Bitmap bitmap, I options, VrEventListener eventListener)
    {
        this$0 = VrPanoramaRenderer.this;
        super();
        this.bitmap = bitmap;
        this.options = options;
        this.eventListener = eventListener;
    }
}
