// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GvrLayout.java

package com.google.vr.ndk.base;

import android.app.Presentation;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.util.Log;
import android.view.*;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.vr.cardboard.DisplaySynchronizer;
import com.google.vr.cardboard.DisplayUtils;
import java.util.*;

// Referenced classes of package com.google.vr.ndk.base:
//            GvrLayout

private static class displayManager
    implements android.hardware.display.r
{

    public boolean isPresenting()
    {
        return presentation != null && presentation.isShowing();
    }

    public void onPause()
    {
        displayManager.unregisterDisplayListener(this);
    }

    public void onResume()
    {
        externalDisplayName = DisplayUtils.getExternalDisplayName(context);
        if(externalDisplayName == null)
        {
            setDisplay(null);
            return;
        }
        displayManager.registerDisplayListener(this, null);
        Display display = null;
        Display adisplay[];
        int i = (adisplay = displayManager.getDisplays()).length;
        int j = 0;
        do
        {
            if(j >= i)
                break;
            Display display1 = adisplay[j];
            if(isValidExternalDisplay(display1))
            {
                display = display1;
                break;
            }
            j++;
        } while(true);
        setDisplay(display);
    }

    public void shutdown()
    {
        displayManager.unregisterDisplayListener(this);
        if(presentation != null)
        {
            presentation.cancel();
            presentation = null;
            r r;
            for(Iterator iterator = listeners.iterator(); iterator.hasNext(); (r = (r)iterator.next()).onPresentationStopped());
        }
    }

    public void onDetachedFromWindow()
    {
        displayManager.unregisterDisplayListener(this);
        setDisplay(null);
    }

    public void addListener(r r)
    {
        if(listeners.contains(r))
            return;
        listeners.add(r);
        if(presentation != null)
            r.onPresentationStarted(presentation.getDisplay());
    }

    public void onDisplayAdded(int i)
    {
        Display display = displayManager.getDisplay(i);
        if(isValidExternalDisplay(display))
            setDisplay(display);
    }

    public void onDisplayRemoved(int i)
    {
        if(presentation != null && presentation.getDisplay().getDisplayId() == i)
            setDisplay(null);
    }

    public void onDisplayChanged(int i)
    {
    }

    private void setDisplay(Display display)
    {
        Presentation presentation1;
label0:
        {
            Display display1 = presentation == null ? null : presentation.getDisplay();
            if(!hasCurrentPresentationExpired() && DisplayUtils.isSameDisplay(display, display1))
                return;
            presentation1 = presentation;
            if(presentation != null)
            {
                presentation.dismiss();
                presentation = null;
            }
            detachViewFromParent(view);
            if(display != null)
            {
                presentation = GvrLayout.access$400() == null ? new Presentation(context, display) : GvrLayout.access$400().create(context, display);
                presentation.addContentView(view, layout);
                try
                {
                    presentation.show();
                    break label0;
                }
                catch(android.view.xception xception)
                {
                    String s;
                    Log.e("GvrLayout", (new StringBuilder(57 + String.valueOf(s = String.valueOf(xception)).length())).append("Attaching Cardboard View to the external display failed: ").append(s).toString());
                    presentation.cancel();
                    presentation = null;
                    detachViewFromParent(view);
                }
            }
            originalParent.addView(view, 0);
        }
        displaySynchronizer.setDisplay(presentation == null ? DisplayUtils.getDefaultDisplay(context) : presentation.getDisplay());
        if(presentation1 != null)
        {
            r r;
            for(Iterator iterator = listeners.iterator(); iterator.hasNext(); (r = (r)iterator.next()).onPresentationStopped());
        }
        if(presentation != null)
        {
            r r1;
            for(Iterator iterator1 = listeners.iterator(); iterator1.hasNext(); (r1 = (r)iterator1.next()).onPresentationStarted(presentation.getDisplay()));
        }
    }

    private static void detachViewFromParent(View view1)
    {
        ViewGroup viewgroup;
        if((viewgroup = (ViewGroup)view1.getParent()) != null)
            viewgroup.removeView(view1);
    }

    private boolean isValidExternalDisplay(Display display)
    {
        return display != null && display.isValid() && display.getName().equals(externalDisplayName);
    }

    private boolean hasCurrentPresentationExpired()
    {
        if(presentation == null)
            return false;
        return !presentation.isShowing() || !presentation.getDisplay().isValid();
    }

    private final android.widget.nHelper.presentation layout = new android.widget.init>(-1, -1);
    private final Context context;
    private final DisplayManager displayManager;
    private final DisplaySynchronizer displaySynchronizer;
    private final FrameLayout originalParent;
    private final View view;
    private final List listeners = new ArrayList();
    private String externalDisplayName;
    private Presentation presentation;

    r(Context context1, FrameLayout framelayout, View view1, DisplaySynchronizer displaysynchronizer, String s)
    {
        context = context1;
        originalParent = framelayout;
        view = view1;
        displaySynchronizer = displaysynchronizer;
        externalDisplayName = s;
        displayManager = (DisplayManager)context1.getSystemService("display");
    }
}
