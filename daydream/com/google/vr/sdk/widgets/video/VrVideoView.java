// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrVideoView.java

package com.google.vr.sdk.widgets.video;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.vr.sdk.widgets.common.VrWidgetRenderer;
import com.google.vr.sdk.widgets.common.VrWidgetView;
import com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass;
import java.io.IOException;

// Referenced classes of package com.google.vr.sdk.widgets.video:
//            VrVideoPlayer, VrVideoRenderer, VrVideoEventListener

public class VrVideoView extends VrWidgetView
{
    public static class Options
    {

        public void validate()
        {
            if(inputFormat <= 0 || inputFormat >= 3)
            {
                int i;
                Log.e(VrVideoView.TAG, (new StringBuilder(40)).append("Invalid Options.inputFormat: ").append(i = inputFormat).toString());
                inputFormat = 1;
            }
            if(inputType <= 0 || inputFormat >= 3)
            {
                int j;
                Log.e(VrVideoView.TAG, (new StringBuilder(38)).append("Invalid Options.inputType: ").append(j = inputType).toString());
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

        public Options()
        {
            inputFormat = 1;
            inputType = 1;
        }
    }


    public VrVideoView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public VrVideoView(Context context)
    {
        super(context);
    }

    protected VrVideoRenderer createRenderer(Context context, com.google.vr.sdk.widgets.common.VrWidgetRenderer.GLThreadScheduler glThreadScheduler, float xMetersPerPixel, float yMetersPerPixel, int screenRotation)
    {
        videoPlayer = new VrVideoPlayer(context);
        renderer = new VrVideoRenderer(videoPlayer, getContext(), glThreadScheduler, xMetersPerPixel, yMetersPerPixel, screenRotation);
        videoPlayer.setVideoTexturesListener(new VrVideoPlayer.VideoTexturesListener() {

            public void onVideoTexturesReady()
            {
                renderer.setSphericalMetadata(videoPlayer.getMetadata());
            }

            final VrVideoView this$0;

            
            {
                this.this$0 = VrVideoView.this;
                super();
            }
        });
        return renderer;
    }

    public void pauseRendering()
    {
        super.pauseRendering();
        pauseVideo();
    }

    public void loadVideo(Uri uri, Options options)
        throws IOException
    {
        videoPlayer.openUri(uri, options);
    }

    public void loadVideoFromAsset(String filename, Options options)
        throws IOException
    {
        videoPlayer.openAsset(filename, options);
    }

    public void setEventListener(VrVideoEventListener eventListener)
    {
        super.setEventListener(eventListener);
        videoPlayer.setEventListener(eventListener);
    }

    public void playVideo()
    {
        synchronized(videoPlayer)
        {
            videoPlayer.getExoPlayer().setPlayWhenReady(true);
        }
    }

    public void pauseVideo()
    {
        synchronized(videoPlayer)
        {
            videoPlayer.getExoPlayer().setPlayWhenReady(false);
        }
    }

    public void seekTo(long positionMs)
    {
        synchronized(videoPlayer)
        {
            videoPlayer.getExoPlayer().seekTo(positionMs);
        }
    }

    public long getDuration()
    {
        long duration;
        synchronized(videoPlayer)
        {
            duration = videoPlayer.getExoPlayer().getDuration();
        }
        return duration;
    }

    public long getCurrentPosition()
    {
        long position;
        synchronized(videoPlayer)
        {
            position = videoPlayer.getExoPlayer().getCurrentPosition();
        }
        return position;
    }

    public void setVolume(float volume)
    {
        videoPlayer.setVolume(volume);
    }

    protected volatile VrWidgetRenderer createRenderer(Context context, com.google.vr.sdk.widgets.common.VrWidgetRenderer.GLThreadScheduler glthreadscheduler, float f, float f1, int i)
    {
        return createRenderer(context, glthreadscheduler, f, f1, i);
    }

    private static final String TAG = com/google/vr/sdk/widgets/video/VrVideoView.getSimpleName();
    private static final boolean DEBUG = false;
    private VrVideoPlayer videoPlayer;
    private VrVideoRenderer renderer;




}
