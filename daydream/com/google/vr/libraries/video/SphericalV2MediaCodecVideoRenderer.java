// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SphericalV2MediaCodecVideoRenderer.java

package com.google.vr.libraries.video;

import android.content.Context;
import android.media.MediaCodec;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.video.MediaCodecVideoRenderer;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import java.nio.ByteBuffer;

// Referenced classes of package com.google.vr.libraries.video:
//            SphericalV2ProjectionDataListener

public class SphericalV2MediaCodecVideoRenderer extends MediaCodecVideoRenderer
{

    public SphericalV2MediaCodecVideoRenderer(Context context, Handler mainHandler, DrmSessionManager drmSessionManager, VideoRendererEventListener eventListener, long allowedVideoJoiningTimeMs)
    {
        super(context, MediaCodecSelector.DEFAULT, allowedVideoJoiningTimeMs, drmSessionManager, false, mainHandler, eventListener, 1);
        presentationStartTimeUs = 0L;
    }

    public void setProjectionListener(SphericalV2ProjectionDataListener projectionListener)
    {
        this.projectionListener = projectionListener;
    }

    public long getPresentationStartTimeUs()
    {
        return presentationStartTimeUs;
    }

    protected void onInputFormatChanged(Format format)
        throws ExoPlaybackException
    {
        super.onInputFormatChanged(format);
        if(format != null && format.stereoMode != -1 && format.projectionData != null && projectionListener != null)
            projectionListener.onProjectionDataChanged(format.stereoMode, format.projectionData);
    }

    protected boolean processOutputBuffer(long positionUs, long elapsedRealtimeUs, MediaCodec codec, ByteBuffer buffer, int bufferIndex, 
            int bufferFlags, long bufferPresentationTimeUs, boolean shouldSkip)
    {
        long elapsedSinceStartOfLoopUs = SystemClock.elapsedRealtime() * 1000L - elapsedRealtimeUs;
        long earlyUs = bufferPresentationTimeUs - positionUs - elapsedSinceStartOfLoopUs;
        long systemTimeNs = System.nanoTime();
        long unadjustedFrameReleaseTimeNs = systemTimeNs + earlyUs * 1000L;
        presentationStartTimeUs = unadjustedFrameReleaseTimeNs / 1000L - bufferPresentationTimeUs;
        return super.processOutputBuffer(positionUs, elapsedRealtimeUs, codec, buffer, bufferIndex, bufferFlags, bufferPresentationTimeUs, shouldSkip);
    }

    private static final int MAX_DROPPED_FRAME_COUNT_TO_NOTIFY = 1;
    private static final String TAG = com/google/vr/libraries/video/SphericalV2MediaCodecVideoRenderer.getSimpleName();
    private long presentationStartTimeUs;
    private SphericalV2ProjectionDataListener projectionListener;

}
