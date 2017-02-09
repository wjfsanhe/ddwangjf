// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FadeOverlayView.java

package com.google.vr.ndk.base;

import android.content.Context;
import android.os.*;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;

class FadeOverlayView extends View
{

    public FadeOverlayView(Context context)
    {
        super(context);
        fadeType = 0;
        setBackgroundColor(0xff000000);
    }

    public void startFade(int i, long l)
    {
        Log.d("FadeOverlayView", (new StringBuilder(23)).append(".startFade: ").append(i).toString());
        if(!isEnabled())
        {
            Log.w("FadeOverlayView", "Ignoring fade request while disabled.");
            return;
        }
        if(!visible)
        {
            Log.w("FadeOverlayView", "Ignoring fade request while invisible.");
            return;
        } else
        {
            removeFadeCallbacks();
            fadeType = i;
            fadeDurationMillis = l;
            fadeStartTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            updateFade();
            return;
        }
    }

    public void onInvisible()
    {
        if(!visible)
            return;
        visible = false;
        if(isEnabled())
        {
            removeFadeCallbacks();
            fadeType = 2;
            endFade();
        }
    }

    public void onVisible()
    {
        if(visible && getAlpha() == 0.0F)
            return;
        visible = true;
        if(isEnabled())
        {
            autoFadeHandler.removeMessages(0x49c1485);
            autoFadeHandler.sendEmptyMessageDelayed(0x49c1485, 1000L);
        }
    }

    public void flushAutoFade(long l)
    {
        Log.d("FadeOverlayView", ".flushAutoFade");
        if(autoFadeHandler.hasMessages(0x49c1485))
        {
            autoFadeHandler.removeMessages(0x49c1485);
            autoFadeHandler.sendEmptyMessageDelayed(0x49c1485, l);
        }
    }

    public void setEnabled(boolean flag)
    {
        if(isEnabled() == flag)
            return;
        super.setEnabled(flag);
        if(!flag)
        {
            removeFadeCallbacks();
            fadeType = 1;
            endFade();
        }
    }

    int getFadeType()
    {
        return fadeType;
    }

    boolean isVisible()
    {
        return visible;
    }

    private void removeFadeCallbacks()
    {
        autoFadeHandler.removeMessages(0x49c1485);
        removeCallbacks(fadeUpdateRunnable);
    }

    private void endFade()
    {
        if(fadeType == 0)
        {
            return;
        } else
        {
            setVisibility(fadeType != 2 ? 8 : 0);
            setAlpha(fadeType != 2 ? 0.0F : 1.0F);
            removeCallbacks(fadeUpdateRunnable);
            fadeType = 0;
            Log.d("FadeOverlayView", ".endFade");
            return;
        }
    }

    private void updateFade()
    {
        long l;
        float f = (float)(l = AnimationUtils.currentAnimationTimeMillis() - fadeStartTimeMillis) / (float)fadeDurationMillis;
        float f1 = fadeType != 2 ? 1.0F - f : f;
        setAlpha(Math.min(Math.max(f1, 0.0F), 1.0F));
        if(l < fadeDurationMillis && getVisibility() != 0)
            setVisibility(0);
        if(l < fadeDurationMillis)
        {
            postOnAnimation(fadeUpdateRunnable);
            return;
        } else
        {
            endFade();
            return;
        }
    }

    private static final String TAG = "FadeOverlayView";
    private static final boolean DEBUG = true;
    private static final int MSG_AUTO_FADE = 0x49c1485;
    private static final int BACKGROUND_COLOR = 0xff000000;
    static final long AUTO_FADE_DURATION_MILLIS = 350L;
    static final long AUTO_FADE_START_DELAY_MILLIS = 1000L;
    private int fadeType;
    private long fadeStartTimeMillis;
    private long fadeDurationMillis;
    private boolean visible;
    private final Runnable fadeUpdateRunnable = new Runnable() {

        public void run()
        {
            updateFade();
        }

        final FadeOverlayView this$0;

            
            {
                this$0 = FadeOverlayView.this;
                super();
            }
    };
    private final Handler autoFadeHandler = new Handler(Looper.getMainLooper()) {

        public void handleMessage(Message message)
        {
            if(message.what == 0x49c1485)
            {
                startFade(1, 350L);
                return;
            } else
            {
                super.handleMessage(message);
                return;
            }
        }

        final FadeOverlayView this$0;

            
            {
                this$0 = FadeOverlayView.this;
                super(looper);
            }
    };

}
