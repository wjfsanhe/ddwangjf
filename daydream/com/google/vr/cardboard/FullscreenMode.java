// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FullscreenMode.java

package com.google.vr.cardboard;

import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.Window;

public class FullscreenMode
{

    public FullscreenMode(Window window1)
    {
        window = window1;
    }

    public void goFullscreen()
    {
        setFullscreenModeFlags();
        setImmersiveStickyModeCompat();
    }

    private void setImmersiveStickyModeCompat()
    {
        if(android.os.Build.VERSION.SDK_INT < 19)
        {
            final Handler handler = new Handler();
            window.getDecorView().setOnSystemUiVisibilityChangeListener(new android.view.View.OnSystemUiVisibilityChangeListener() {

                public void onSystemUiVisibilityChange(int i)
                {
                    if((i & 2) == 0)
                        handler.postDelayed(new Runnable() {

                            public void run()
                            {
                                setFullscreenModeFlags();
                            }

                            final _cls1 this$1;

                    
                    {
                        this$1 = _cls1.this;
                        super();
                    }
                        }, 2000L);
                }

                final Handler val$handler;
                final FullscreenMode this$0;

            
            {
                this$0 = FullscreenMode.this;
                handler = handler1;
                super();
            }
            });
        }
    }

    public void onWindowFocusChanged(boolean flag)
    {
        if(flag)
            setFullscreenModeFlags();
    }

    private void setFullscreenModeFlags()
    {
        window.getDecorView().setSystemUiVisibility(5894);
    }

    private static final int NAVIGATION_BAR_TIMEOUT_MS = 2000;
    private final Window window;

}
