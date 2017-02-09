// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrVideoPlayer.java

package com.google.vr.sdk.widgets.video;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import com.google.android.exoplayer2.*;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.*;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.*;
import com.google.vr.libraries.video.FrameRotationBuffer;
import com.google.vr.libraries.video.SphericalV2ProjectionDataListener;
import com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass;
import java.io.*;

// Referenced classes of package com.google.vr.sdk.widgets.video:
//            VrVideoView, VideoTexture, VrSimpleExoPlayer, SphericalMetadataMP4, 
//            SphericalMetadataParser, VrVideoEventListener, SphericalV2MetadataParser

class VrVideoPlayer
    implements AdaptiveMediaSourceEventListener, com.google.android.exoplayer2.source.ExtractorMediaSource.EventListener
{
    private class NewFrameNotifier
        implements VideoTexture.OnNewFrameListener, Runnable
    {

        public void onNewFrame()
        {
            mainHandler.post(this);
        }

        public void run()
        {
            if(eventListener != null)
                eventListener.onNewFrame();
        }

        private Handler mainHandler;
        final VrVideoPlayer this$0;

        private NewFrameNotifier()
        {
            this$0 = VrVideoPlayer.this;
            super();
            mainHandler = new Handler(Looper.getMainLooper());
        }

    }

    private class ProjectionDataListener
        implements SphericalV2ProjectionDataListener
    {

        public void onProjectionDataChanged(int stereoMode, byte projectionData[])
        {
            metadata = SphericalV2MetadataParser.parse(stereoMode, projectionData);
            synchronized(VrVideoPlayer.this)
            {
                boolean isReady = videoTextures.length > 0;
                if(isReady && videoTexturesListener != null)
                    videoTexturesListener.onVideoTexturesReady();
            }
        }

        final VrVideoPlayer this$0;

        private ProjectionDataListener()
        {
            this$0 = VrVideoPlayer.this;
            super();
        }

    }

    private class VideoLooperListener
        implements com.google.android.exoplayer2.ExoPlayer.EventListener
    {

        public void onTracksChanged(TrackGroupArray trackgrouparray, TrackSelectionArray trackselectionarray)
        {
        }

        public void onPositionDiscontinuity()
        {
        }

        public void onTimelineChanged(Timeline timeline1, Object obj)
        {
        }

        public void onLoadingChanged(boolean flag)
        {
        }

        public void onPlayerError(ExoPlaybackException error)
        {
            int i;
            Log.e(VrVideoPlayer.TAG, (new StringBuilder(25)).append(i = hashCode()).append(".onPlayerError").toString(), error);
            if(eventListener != null)
                eventListener.onLoadError(error.getMessage());
        }

        public void onPlayerStateChanged(boolean playWhenReady, int playbackState)
        {
            if(playbackState == 2)
                isBuffering = true;
            else
            if(playbackState == 3)
            {
                if(isBuffering && eventListener != null)
                {
                    isBuffering = false;
                    eventListener.onLoadSuccess();
                }
            } else
            if(playWhenReady && playbackState == 4)
            {
                if(eventListener != null)
                    eventListener.onCompletion();
                if(isLooping)
                    synchronized(VrVideoPlayer.this)
                    {
                        getExoPlayer().seekTo(0L);
                    }
            }
        }

        final VrVideoPlayer this$0;

        private VideoLooperListener()
        {
            this$0 = VrVideoPlayer.this;
            super();
        }

    }

    public static interface VideoTexturesListener
    {

        public abstract void onVideoTexturesReady();
    }


    public VrVideoPlayer(Context context)
    {
        videoTextures = new VideoTexture[0];
        isBuffering = false;
        volume = 1.0F;
        this.context = context;
        init(context);
    }

    private void init(Context context)
    {
        mainHandler = new Handler(Looper.getMainLooper());
        simpleExoPlayer = new VrSimpleExoPlayer(context);
        simpleExoPlayer.setProjectionListener(new ProjectionDataListener());
        frameRotationBuffer = new FrameRotationBuffer();
        simpleExoPlayer.setFrameRotationBuffer(frameRotationBuffer);
        getExoPlayer().addListener(new VideoLooperListener());
        getExoPlayer().setPlayWhenReady(true);
    }

    private void loadVideoIntoPlayer(Uri uri, VrVideoView.Options options)
    {
        if(options == null)
            options = new VrVideoView.Options();
        else
            options.validate();
        mediaDataSourceFactory = new DefaultDataSourceFactory(context, "Video Player Widget");
        MediaSource mediaSource = buildMediaSource(uri, options);
        simpleExoPlayer.prepare(mediaSource);
        videoTextures = new VideoTexture[1];
        videoTextures[0] = new VideoTexture();
        videoTextures[0].setOnNewFrameListener(new NewFrameNotifier());
        if(videoTexturesListener != null)
            videoTexturesListener.onVideoTexturesReady();
        applyVolumeToPlayer();
    }

    private MediaSource buildMediaSource(Uri uri, VrVideoView.Options options)
    {
        if(options.inputFormat == 2)
            return new HlsMediaSource(uri, mediaDataSourceFactory, mainHandler, this);
        else
            return new ExtractorMediaSource(uri, mediaDataSourceFactory, new DefaultExtractorsFactory(), mainHandler, this);
    }

    public void setEventListener(VrVideoEventListener eventListener)
    {
        this.eventListener = eventListener;
    }

    public void openAsset(String filename, VrVideoView.Options options)
        throws IOException
    {
        metadata = new com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass.SphericalMetadata();
        if(options != null)
            metadata = createMetadataFromOptions(options);
        else
            metadata = parseMetadataFromVideoInputStream(context.getAssets().open(filename));
        "file:///android_asset/";
        String s = String.valueOf(filename);
        s;
        if(s.length() == 0) goto _L2; else goto _L1
_L1:
        concat();
          goto _L3
_L2:
        JVM INSTR pop ;
        JVM INSTR new #241 <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
_L3:
        Uri.parse();
        Uri videoUri;
        videoUri;
        loadVideoIntoPlayer(videoUri, options);
        return;
    }

    public void openUri(Uri uri, VrVideoView.Options options)
        throws IOException
    {
        metadata = new com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass.SphericalMetadata();
        if(options != null)
        {
            metadata = createMetadataFromOptions(options);
        } else
        {
            String scheme = uri.getScheme();
            if(scheme == null || !scheme.startsWith("http"))
                metadata = parseMetadataFromVideoInputStream(new FileInputStream(uri.getPath()));
        }
        loadVideoIntoPlayer(uri, options);
    }

    public com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass.SphericalMetadata getMetadata()
    {
        return metadata;
    }

    public byte[] getMetadataBytes()
    {
        return com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass.SphericalMetadata.toByteArray(metadata);
    }

    public float[] getCameraRotationMatrix()
    {
        return cameraRotationMatrix;
    }

    public synchronized int[] bindTexture()
    {
        if(videoTextures.length == 0)
            throw new IllegalStateException("openXXX() should be called successfully first.");
        int textureIds[] = new int[videoTextures.length];
        for(int i = 0; i < videoTextures.length; i++)
        {
            VideoTexture videoTexture = videoTextures[i];
            if(!videoTexture.getIsTextureSet())
                videoTexture.init();
            Surface videoSurface = new Surface(videoTexture.getSurfaceTexture());
            simpleExoPlayer.setVideoSurface(videoSurface);
            getExoPlayer().seekTo(getExoPlayer().getCurrentPosition() + 1L);
            textureIds[i] = videoTexture.getTextureId();
        }

        return textureIds;
    }

    public synchronized boolean prepareFrame()
    {
        boolean isReady = videoTextures.length > 0;
        VideoTexture avideotexture[] = videoTextures;
        int i = avideotexture.length;
        for(int j = 0; j < i; j++)
        {
            VideoTexture videoTexture = avideotexture[j];
            if(videoTexture.getIsTextureSet())
            {
                videoTexture.updateTexture();
                if(frameRotationBuffer != null)
                {
                    long releaseTimeUs = videoTexture.getTimestamp() / 1000L;
                    long presentationTimeUs = releaseTimeUs - simpleExoPlayer.getPresentationStartTimeUs();
                    cameraRotationMatrix = frameRotationBuffer.getTransform(presentationTimeUs);
                }
            } else
            {
                isReady = false;
            }
        }

        return isReady;
    }

    public synchronized void onViewDetach()
    {
        for(int i = 0; i < videoTextures.length; i++)
        {
            simpleExoPlayer.setVideoSurface(null);
            videoTextures[i].release();
        }

    }

    public synchronized void shutdown()
    {
        getExoPlayer().stop();
        getExoPlayer().release();
        VideoTexture avideotexture[] = videoTextures;
        int i = avideotexture.length;
        for(int j = 0; j < i; j++)
        {
            VideoTexture videoTexture = avideotexture[j];
            videoTexture.release();
        }

    }

    public synchronized long getCurrentPositionMs()
    {
        return getExoPlayer().getCurrentPosition();
    }

    public ExoPlayer getExoPlayer()
    {
        return simpleExoPlayer;
    }

    public void setVideoTexturesListener(VideoTexturesListener videoTexturesListener)
    {
        this.videoTexturesListener = videoTexturesListener;
    }

    public synchronized void setVolume(float volume)
    {
        this.volume = volume;
        applyVolumeToPlayer();
    }

    private synchronized void applyVolumeToPlayer()
    {
        simpleExoPlayer.setVolume(volume);
    }

    private static com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass.SphericalMetadata createMetadataFromOptions(VrVideoView.Options options)
    {
        com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass.SphericalMetadata metadata = new com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass.SphericalMetadata();
        switch(options.inputType)
        {
        case 1: // '\001'
            metadata.frameLayoutMode = 1;
            break;

        case 2: // '\002'
            metadata.frameLayoutMode = 2;
            break;

        default:
            int i = options.inputType;
            throw new IllegalArgumentException((new StringBuilder(40)).append("Unexpected options.inputType ").append(i).toString());
        }
        return metadata;
    }

    private static com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass.SphericalMetadata parseMetadataFromVideoInputStream(InputStream videoInputStream)
        throws IOException
    {
        com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass.SphericalMetadata metadata = new com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass.SphericalMetadata();
        String metadataString = SphericalMetadataMP4.extract(videoInputStream);
        metadata = SphericalMetadataParser.parse(metadataString);
        videoInputStream.close();
        return metadata;
    }

    public void onLoadError(IOException error)
    {
        int i;
        String s;
        Log.e(TAG, (new StringBuilder(58 + String.valueOf(s = String.valueOf(error)).length())).append(i = hashCode()).append("ExtractorMediaSource.EventListener.onLoadError ").append(s).toString());
        if(eventListener != null)
            eventListener.onLoadError(error.toString());
    }

    public void onLoadStarted(DataSpec dataspec, int i, int j, Format format, int k, Object obj, long l, long l1, long l2)
    {
    }

    public void onLoadError(DataSpec dataSpec, int dataType, int trackType, Format trackFormat, int trackSelectionReason, Object trackSelectionData, long mediaStartTimeMs, long mediaEndTimeMs, long elapsedRealtimeMs, long loadDurationMs, 
            long bytesLoaded, IOException error, boolean wasCanceled)
    {
        int i;
        String s;
        Log.e(TAG, (new StringBuilder(56 + String.valueOf(s = String.valueOf(error)).length())).append(i = hashCode()).append("AdaptiveMediaSourceEventListener.onLoadError ").append(s).toString());
        if(eventListener != null)
            eventListener.onLoadError(error.toString());
    }

    public void onLoadCanceled(DataSpec dataspec, int i, int j, Format format, int k, Object obj, long l, long l1, long l2, long l3, 
            long l4)
    {
    }

    public void onLoadCompleted(DataSpec dataspec, int i, int j, Format format, int k, Object obj, long l, long l1, long l2, long l3, 
            long l4)
    {
    }

    public void onUpstreamDiscarded(int i, long l, long l1)
    {
    }

    public void onDownstreamFormatChanged(int i, Format format, int j, Object obj, long l)
    {
    }

    private static final String TAG = com/google/vr/sdk/widgets/video/VrVideoPlayer.getSimpleName();
    private static final String EXO_USER_AGENT = "Video Player Widget";
    private static final boolean DEBUG = false;
    private Handler mainHandler;
    private VrSimpleExoPlayer simpleExoPlayer;
    private VideoTexture videoTextures[];
    private boolean isBuffering;
    private boolean isLooping;
    private Context context;
    private VrVideoEventListener eventListener;
    private VideoTexturesListener videoTexturesListener;
    private com.google.android.exoplayer2.upstream.DataSource.Factory mediaDataSourceFactory;
    private float volume;
    private FrameRotationBuffer frameRotationBuffer;
    private float cameraRotationMatrix[];
    private com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass.SphericalMetadata metadata;









}
