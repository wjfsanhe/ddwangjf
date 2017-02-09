// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FullScreenDialog.java

package com.google.vr.sdk.widgets.common;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.vr.cardboard.FullscreenMode;

// Referenced classes of package com.google.vr.sdk.widgets.common:
//            VrWidgetRenderer

public class FullScreenDialog extends Dialog
{

    public FullScreenDialog(Context context, View innerWidgetView, VrWidgetRenderer renderer)
    {
        super(context, 0x103000a);
        this.innerWidgetView = innerWidgetView;
        this.renderer = renderer;
        dialogContent = new FrameLayout(context);
        setContentView(dialogContent);
    }

    protected void onStart()
    {
        super.onStart();
        renderer.onViewDetach();
        innerWidgetViewParent = (ViewGroup)innerWidgetView.getParent();
        innerWidgetViewParent.removeView(innerWidgetView);
        dialogContent.addView(innerWidgetView, -1, -1);
    }

    protected void onStop()
    {
        renderer.onViewDetach();
        dialogContent.removeView(innerWidgetView);
        innerWidgetViewParent.addView(innerWidgetView);
        super.onStop();
    }

    public void show()
    {
        super.show();
        fullscreenMode = new FullscreenMode(getWindow());
        fullscreenMode.goFullscreen();
    }

    private static final String TAG = com/google/vr/sdk/widgets/common/FullScreenDialog.getSimpleName();
    private static final boolean DEBUG = false;
    private final View innerWidgetView;
    private ViewGroup innerWidgetViewParent;
    private VrWidgetRenderer renderer;
    private final ViewGroup dialogContent;
    private FullscreenMode fullscreenMode;

}
