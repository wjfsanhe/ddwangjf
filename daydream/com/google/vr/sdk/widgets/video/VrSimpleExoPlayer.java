// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrSimpleExoPlayer.java

package com.google.vr.sdk.widgets.video;

import android.content.Context;
import android.os.Handler;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.metadata.MetadataRenderer;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.vr.libraries.video.*;
import java.util.ArrayList;

public class VrSimpleExoPlayer extends SimpleExoPlayer
{

    public VrSimpleExoPlayer(Context context)
    {
        super(context, new DefaultTrackSelector(), new DefaultLoadControl(), null, 0, 5000L);
    }

    public void setFrameRotationBuffer(FrameRotationBuffer frameRotationBuffer)
    {
        cameraMotionRenderer.setFrameRotationBuffer(frameRotationBuffer);
    }

    public void setProjectionListener(SphericalV2ProjectionDataListener projectionListener)
    {
        videoRenderer.setProjectionListener(projectionListener);
    }

    public long getPresentationStartTimeUs()
    {
        return videoRenderer.getPresentationStartTimeUs();
    }

    protected void buildVideoRenderers(Context context, Handler mainHandler, DrmSessionManager drmSessionManager, int extensionRendererMode, VideoRendererEventListener eventListener, long allowedVideoJoiningTimeMs, 
            ArrayList out)
    {
        videoRenderer = new SphericalV2MediaCodecVideoRenderer(context, mainHandler, drmSessionManager, eventListener, allowedVideoJoiningTimeMs);
        out.add(videoRenderer);
    }

    protected void buildMetadataRenderers(Context context, Handler mainHandler, int extensionRendererMode, com.google.android.exoplayer2.metadata.MetadataRenderer.Output output, ArrayList out)
    {
        super.buildMetadataRenderers(context, mainHandler, extensionRendererMode, output, out);
        cameraMotionRenderer = new CameraMotionMetadataRendererV2();
        out.add(cameraMotionRenderer);
    }

    private CameraMotionMetadataRendererV2 cameraMotionRenderer;
    private SphericalV2MediaCodecVideoRenderer videoRenderer;
}
