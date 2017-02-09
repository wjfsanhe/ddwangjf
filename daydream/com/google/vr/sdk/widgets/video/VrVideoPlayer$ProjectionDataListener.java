// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrVideoPlayer.java

package com.google.vr.sdk.widgets.video;

import com.google.vr.libraries.video.SphericalV2ProjectionDataListener;
import com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass;

// Referenced classes of package com.google.vr.sdk.widgets.video:
//            VrVideoPlayer, SphericalV2MetadataParser

private class this._cls0
    implements SphericalV2ProjectionDataListener
{

    public void onProjectionDataChanged(int stereoMode, byte projectionData[])
    {
        VrVideoPlayer.access$402(VrVideoPlayer.this, SphericalV2MetadataParser.parse(stereoMode, projectionData));
        synchronized(VrVideoPlayer.this)
        {
            boolean isReady = VrVideoPlayer.access$500(VrVideoPlayer.this).length > 0;
            if(isReady && VrVideoPlayer.access$600(VrVideoPlayer.this) != null)
                VrVideoPlayer.access$600(VrVideoPlayer.this).nVideoTexturesReady();
        }
    }

    final VrVideoPlayer this$0;

    private ricalMetadata()
    {
        this$0 = VrVideoPlayer.this;
        super();
    }

}
