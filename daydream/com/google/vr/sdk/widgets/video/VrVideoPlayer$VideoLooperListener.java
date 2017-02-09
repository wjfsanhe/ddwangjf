// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrVideoPlayer.java

package com.google.vr.sdk.widgets.video;

import android.util.Log;
import com.google.android.exoplayer2.*;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;

// Referenced classes of package com.google.vr.sdk.widgets.video:
//            VrVideoPlayer, VrVideoEventListener

private class this._cls0
    implements com.google.android.exoplayer2.r
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
        Log.e(VrVideoPlayer.access$000(), (new StringBuilder(25)).append(i = hashCode()).append(".onPlayerError").toString(), error);
        if(VrVideoPlayer.access$100(VrVideoPlayer.this) != null)
            VrVideoPlayer.access$100(VrVideoPlayer.this).onLoadError(error.getMessage());
    }

    public void onPlayerStateChanged(boolean playWhenReady, int playbackState)
    {
        if(playbackState == 2)
            VrVideoPlayer.access$202(VrVideoPlayer.this, true);
        else
        if(playbackState == 3)
        {
            if(VrVideoPlayer.access$200(VrVideoPlayer.this) && VrVideoPlayer.access$100(VrVideoPlayer.this) != null)
            {
                VrVideoPlayer.access$202(VrVideoPlayer.this, false);
                VrVideoPlayer.access$100(VrVideoPlayer.this).onLoadSuccess();
            }
        } else
        if(playWhenReady && playbackState == 4)
        {
            if(VrVideoPlayer.access$100(VrVideoPlayer.this) != null)
                VrVideoPlayer.access$100(VrVideoPlayer.this).onCompletion();
            if(VrVideoPlayer.access$300(VrVideoPlayer.this))
                synchronized(VrVideoPlayer.this)
                {
                    getExoPlayer().seekTo(0L);
                }
        }
    }

    final VrVideoPlayer this$0;

    private ()
    {
        this$0 = VrVideoPlayer.this;
        super();
    }

}
