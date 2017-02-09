// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GvrUiLayout.java

package com.google.vr.ndk.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.FrameLayout;
import com.google.vr.cardboard.*;

// Referenced classes of package com.google.vr.ndk.base:
//            DaydreamUtilsWrapper

public class GvrUiLayout extends FrameLayout
{

    GvrUiLayout(Context context)
    {
        this(context, new DaydreamUtilsWrapper());
    }

    GvrUiLayout(Context context, DaydreamUtilsWrapper daydreamutilswrapper)
    {
        super(context);
        daydreamModeEnabled = false;
        defaultCloseButtonRunnable = createDefaultCloseButtonRunnable(context, daydreamutilswrapper);
        uiLayer = new UiLayer(context);
        uiLayer.setBackButtonListener(defaultCloseButtonRunnable);
        addView(uiLayer.getView());
    }

    public static void launchOrInstallGvrApp(Activity activity)
    {
        UiUtils.launchOrInstallCardboard(activity);
    }

    public void setEnabled(boolean flag)
    {
        uiLayer.setEnabled(flag);
    }

    public void setCloseButtonListener(Runnable runnable)
    {
        uiLayer.setBackButtonListener(runnable == null ? defaultCloseButtonRunnable : runnable);
    }

    public void setTransitionViewEnabled(boolean flag)
    {
        uiLayer.setTransitionViewEnabled(flag && !daydreamModeEnabled);
    }

    public void setViewerName(String s)
    {
        uiLayer.setViewerName(s);
    }

    public UiLayer getUiLayer()
    {
        return uiLayer;
    }

    void invokeCloseButtonListener()
    {
        Runnable runnable;
        if((runnable = uiLayer.getBackButtonRunnable()) != null)
            runnable.run();
    }

    void setDaydreamModeEnabled(boolean flag)
    {
        if(daydreamModeEnabled == flag)
            return;
        daydreamModeEnabled = flag;
        if(flag)
        {
            uiLayer.setAlignmentMarkerScale(0.35F);
            uiLayer.setTransitionViewEnabled(false);
            return;
        } else
        {
            uiLayer.setAlignmentMarkerScale(1.0F);
            return;
        }
    }

    boolean isDaydreamModeEnabled()
    {
        return daydreamModeEnabled;
    }

    private static Runnable createDefaultCloseButtonRunnable(Context context, DaydreamUtilsWrapper daydreamutilswrapper)
    {
        final Activity activity;
        if((activity = ContextUtils.getActivity(context)) == null)
            return null;
        if(daydreamutilswrapper.isDaydreamActivity(activity))
            return new Runnable() {

                public final void run()
                {
                    Intent intent;
                    (intent = new Intent("android.intent.action.MAIN")).addCategory("android.intent.category.HOME");
                    intent.setFlags(0x10000000);
                    activity.startActivity(intent);
                    activity.finish();
                }

                final Activity val$activity;

            
            {
                activity = activity1;
                super();
            }
            };
        else
            return new Runnable() {

                public final void run()
                {
                    activity.onBackPressed();
                }

                final Activity val$activity;

            
            {
                activity = activity1;
                super();
            }
            };
    }

    private static final float DAYDREAM_ALIGNMENT_MARKER_SCALE = 0.35F;
    private final UiLayer uiLayer;
    private final Runnable defaultCloseButtonRunnable;
    private boolean daydreamModeEnabled;
}
