// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrVideoRenderer.java

package com.google.vr.sdk.widgets.video;

import com.google.vr.sdk.widgets.common.VrWidgetRenderer;
import com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass;

// Referenced classes of package com.google.vr.sdk.widgets.video:
//            VrVideoRenderer, VrVideoPlayer

private class metadata
    implements com.google.vr.sdk.widgets.common.etadata
{

    public void execute()
    {
        VrVideoRenderer.access$100(VrVideoRenderer.this, VrVideoRenderer.access$000(VrVideoRenderer.this), com.google.vr.sdk.widgets.video.nano.icalMetadata.toByteArray(metadata));
        VrVideoRenderer.access$400(VrVideoRenderer.this, VrVideoRenderer.access$200(VrVideoRenderer.this), VrVideoRenderer.access$300(VrVideoRenderer.this).bindTexture());
    }

    private final com.google.vr.sdk.widgets.video.nano.icalMetadata metadata;
    final VrVideoRenderer this$0;

    public SphericalMetadata(com.google.vr.sdk.widgets.video.nano.icalMetadata metadata)
    {
        this$0 = VrVideoRenderer.this;
        super();
        this.metadata = metadata;
    }
}
