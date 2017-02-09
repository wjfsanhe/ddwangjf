// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GvrActivity.java

package com.google.vr.sdk.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import com.google.vr.cardboard.AndroidNCompat;
import com.google.vr.cardboard.FullscreenMode;
import com.google.vrtoolkit.cardboard.ScreenOnFlagHelper;

// Referenced classes of package com.google.vr.sdk.base:
//            GvrView, GvrViewerParams

public class GvrActivity extends Activity
{

    public GvrActivity()
    {
    }

    public void setGvrView(GvrView gvrView)
    {
        setGvrView(gvrView, true);
    }

    public void setGvrView(GvrView gvrView, boolean enableVrModeFallbacks)
    {
        if(cardboardView == gvrView)
            return;
        if(cardboardView != null)
            cardboardView.setOnCardboardTriggerListener(null);
        cardboardView = gvrView;
        boolean enableAndroidVrMode = gvrView != null;
        androidVrModeEnabled = AndroidNCompat.setVrModeEnabled(this, enableAndroidVrMode, enableVrModeFallbacks ? 1 : 0) && enableAndroidVrMode;
        if(gvrView == null)
        {
            return;
        } else
        {
            gvrView.setOnCardboardTriggerListener(new Runnable() {

                public void run()
                {
                    onCardboardTrigger();
                }

                final GvrActivity this$0;

            
            {
                this.this$0 = GvrActivity.this;
                super();
            }
            });
            return;
        }
    }

    public GvrView getGvrView()
    {
        return cardboardView;
    }

    public void onCardboardTrigger()
    {
    }

    protected void updateGvrViewerParams(GvrViewerParams newParams)
    {
        if(cardboardView != null)
            cardboardView.updateGvrViewerParams(newParams);
    }

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        fullscreenMode = new FullscreenMode(getWindow());
    }

    protected void onResume()
    {
        super.onResume();
        if(cardboardView != null)
            cardboardView.onResume();
        fullscreenMode.goFullscreen();
        screenOnFlagHelper.start();
    }

    protected void onPause()
    {
        super.onPause();
        if(cardboardView != null)
            cardboardView.onPause();
        screenOnFlagHelper.stop();
    }

    protected void onDestroy()
    {
        if(cardboardView != null)
        {
            cardboardView.setOnCardboardTriggerListener(null);
            cardboardView.shutdown();
            cardboardView = null;
        }
        super.onDestroy();
    }

    public void setContentView(View view)
    {
        if(view instanceof GvrView)
            setGvrView((GvrView)view);
        super.setContentView(view);
    }

    public void setContentView(View view, android.view.ViewGroup.LayoutParams params)
    {
        if(view instanceof GvrView)
            setGvrView((GvrView)view);
        super.setContentView(view, params);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        return shouldSuppressKey(keyCode) || super.onKeyDown(keyCode, event);
    }

    public boolean onKeyUp(int keyCode, KeyEvent event)
    {
        return shouldSuppressKey(keyCode) || super.onKeyUp(keyCode, event);
    }

    public void onWindowFocusChanged(boolean hasFocus)
    {
        super.onWindowFocusChanged(hasFocus);
        fullscreenMode.onWindowFocusChanged(hasFocus);
    }

    public void setScreenAlwaysOn(boolean enabled)
    {
        screenOnFlagHelper.setScreenAlwaysOn(enabled);
    }

    private boolean shouldSuppressKey(int keyCode)
    {
        if(androidVrModeEnabled)
            return keyCode == 24 || keyCode == 25;
        else
            return false;
    }

    private FullscreenMode fullscreenMode;
    private final ScreenOnFlagHelper screenOnFlagHelper = new ScreenOnFlagHelper(this);
    private GvrView cardboardView;
    private boolean androidVrModeEnabled;
}
