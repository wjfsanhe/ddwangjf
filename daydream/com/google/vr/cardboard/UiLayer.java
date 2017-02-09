// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UiLayer.java

package com.google.vr.cardboard;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.*;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

// Referenced classes of package com.google.vr.cardboard:
//            R, ThreadUtils, TransitionView, UiUtils

public class UiLayer
{

    public UiLayer(Context context1)
    {
        isSettingsButtonEnabled = true;
        isAlignmentMarkerEnabled = true;
        backButtonRunnable = null;
        transitionViewEnabled = false;
        context = context1;
        initializeViewsWithLayoutId(R.layout.ui_layer);
    }

    public void setPortraitSupportEnabled(boolean flag)
    {
        initializeViewsWithLayoutId(flag ? R.layout.ui_layer_with_portrait_support : R.layout.ui_layer);
    }

    private void initializeViewsWithLayoutId(int i)
    {
        rootLayout = (RelativeLayout)LayoutInflater.from(context).inflate(i, null, false);
        settingsButtonRunnable = new Runnable() {

            public void run()
            {
                UiUtils.launchOrInstallCardboard(context);
            }

            final UiLayer this$0;

            
            {
                this$0 = UiLayer.this;
                super();
            }
        };
        settingsButton = (ImageButton)rootLayout.findViewById(R.id.ui_settings_button);
        settingsButton.setVisibility(computeVisibility(isSettingsButtonEnabled));
        settingsButton.setContentDescription("Settings");
        settingsButton.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
                Runnable runnable;
                if((runnable = settingsButtonRunnable) != null)
                    runnable.run();
            }

            final UiLayer this$0;

            
            {
                this$0 = UiLayer.this;
                super();
            }
        });
        backButton = (ImageButton)rootLayout.findViewById(R.id.ui_back_button);
        backButton.setVisibility(computeVisibility(getBackButtonEnabled()));
        backButton.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
                Runnable runnable;
                if((runnable = backButtonRunnable) != null)
                    runnable.run();
            }

            final UiLayer this$0;

            
            {
                this$0 = UiLayer.this;
                super();
            }
        });
        alignmentMarker = (RelativeLayout)rootLayout.findViewById(R.id.ui_alignment_marker);
        alignmentMarker.setVisibility(computeVisibility(getAlignmentMarkerEnabled()));
    }

    private TransitionView getTransitionView()
    {
        if(transitionView == null)
        {
            transitionView = new TransitionView(context);
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            transitionView.setLayoutParams(layoutparams);
            transitionView.setVisibility(computeVisibility(transitionViewEnabled));
            if(viewerName != null)
                transitionView.setViewerName(viewerName);
            transitionView.setBackButtonListener(backButtonRunnable);
            rootLayout.addView(transitionView);
        }
        return transitionView;
    }

    private static int computeVisibility(boolean flag)
    {
        return !flag ? 8 : 0;
    }

    public View getView()
    {
        return rootLayout;
    }

    public void setEnabled(final boolean enabled)
    {
        ThreadUtils.runOnUiThread(new Runnable() {

            public void run()
            {
                rootLayout.setVisibility(UiLayer.computeVisibility(enabled));
            }

            final boolean val$enabled;
            final UiLayer this$0;

            
            {
                this$0 = UiLayer.this;
                enabled = flag;
                super();
            }
        });
    }

    public void setSettingsButtonEnabled(final boolean enabled)
    {
        isSettingsButtonEnabled = enabled;
        ThreadUtils.runOnUiThread(new Runnable() {

            public void run()
            {
                settingsButton.setVisibility(UiLayer.computeVisibility(enabled));
            }

            final boolean val$enabled;
            final UiLayer this$0;

            
            {
                this$0 = UiLayer.this;
                enabled = flag;
                super();
            }
        });
    }

    public void setSettingsButtonRunnable(Runnable runnable)
    {
        settingsButtonRunnable = runnable;
    }

    public void setBackButtonListener(final Runnable runnable)
    {
        backButtonRunnable = runnable;
        ThreadUtils.runOnUiThread(new Runnable() {

            public void run()
            {
                boolean flag = runnable != null;
                backButton.setVisibility(UiLayer.computeVisibility(flag));
                if(transitionView != null)
                    transitionView.setBackButtonListener(runnable);
            }

            final Runnable val$runnable;
            final UiLayer this$0;

            
            {
                this$0 = UiLayer.this;
                runnable = runnable1;
                super();
            }
        });
    }

    public void setAlignmentMarkerEnabled(final boolean enabled)
    {
        isAlignmentMarkerEnabled = enabled;
        ThreadUtils.runOnUiThread(new Runnable() {

            public void run()
            {
                alignmentMarker.setVisibility(UiLayer.computeVisibility(enabled));
            }

            final boolean val$enabled;
            final UiLayer this$0;

            
            {
                this$0 = UiLayer.this;
                enabled = flag;
                super();
            }
        });
    }

    public void setAlignmentMarkerScale(final float scale)
    {
        if(android.os.Build.VERSION.SDK_INT < 23)
        {
            return;
        } else
        {
            ThreadUtils.runOnUiThread(new Runnable() {

                public void run()
                {
                    android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)alignmentMarker.getLayoutParams();
                    int i;
                    int j = (int)((float)(i = (int)context.getResources().getDimension(R.dimen.alignment_marker_height)) * scale);
                    if(layoutparams.getRule(15) == -1)
                        layoutparams.width = j;
                    else
                        layoutparams.height = j;
                    alignmentMarker.setLayoutParams(layoutparams);
                }

                final float val$scale;
                final UiLayer this$0;

            
            {
                this$0 = UiLayer.this;
                scale = f;
                super();
            }
            });
            return;
        }
    }

    public void setTransitionViewEnabled(final boolean enabled)
    {
        transitionViewEnabled = enabled;
        ThreadUtils.runOnUiThread(new Runnable() {

            public void run()
            {
                if(!enabled && transitionView == null)
                {
                    return;
                } else
                {
                    getTransitionView().setVisibility(UiLayer.computeVisibility(enabled));
                    return;
                }
            }

            final boolean val$enabled;
            final UiLayer this$0;

            
            {
                this$0 = UiLayer.this;
                enabled = flag;
                super();
            }
        });
    }

    public boolean getTransitionViewEnabled()
    {
        return transitionViewEnabled;
    }

    public void setTransitionViewListener(final TransitionView.TransitionListener listener)
    {
        ThreadUtils.runOnUiThread(new Runnable() {

            public void run()
            {
                if(listener == null && transitionView == null)
                {
                    return;
                } else
                {
                    getTransitionView().setTransitionListener(listener);
                    return;
                }
            }

            final TransitionView.TransitionListener val$listener;
            final UiLayer this$0;

            
            {
                this$0 = UiLayer.this;
                listener = transitionlistener;
                super();
            }
        });
    }

    public void setViewerName(final String viewerName)
    {
        this.viewerName = viewerName;
        ThreadUtils.runOnUiThread(new Runnable() {

            public void run()
            {
                if(transitionView != null)
                    transitionView.setViewerName(viewerName);
            }

            final String val$viewerName;
            final UiLayer this$0;

            
            {
                this$0 = UiLayer.this;
                viewerName = s;
                super();
            }
        });
    }

    public String getViewerName()
    {
        return viewerName;
    }

    public boolean getSettingsButtonEnabled()
    {
        return isSettingsButtonEnabled;
    }

    public boolean getBackButtonEnabled()
    {
        return backButtonRunnable != null;
    }

    public Runnable getBackButtonRunnable()
    {
        return backButtonRunnable;
    }

    public boolean getAlignmentMarkerEnabled()
    {
        return isAlignmentMarkerEnabled;
    }

    private final Context context;
    private ImageButton settingsButton;
    private ImageButton backButton;
    private RelativeLayout alignmentMarker;
    private TransitionView transitionView;
    private RelativeLayout rootLayout;
    private volatile boolean isSettingsButtonEnabled;
    private volatile boolean isAlignmentMarkerEnabled;
    private volatile Runnable backButtonRunnable;
    private volatile Runnable settingsButtonRunnable;
    private volatile boolean transitionViewEnabled;
    private volatile String viewerName;










}
