// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TouchTracker.java

package com.google.vr.sdk.widgets.common;

import android.content.Context;
import android.graphics.PointF;
import android.view.*;

// Referenced classes of package com.google.vr.sdk.widgets.common:
//            VrEventListener

public class TouchTracker
    implements android.view.View.OnTouchListener
{
    static interface TouchEnabledVrView
    {

        public abstract void onPanningEvent(float f, float f1);

        public abstract VrEventListener getEventListener();
    }


    public TouchTracker(Context context, TouchEnabledVrView target)
    {
        lastTouchPointPx = new PointF();
        startTouchPointPx = new PointF();
        touchTrackingEnabled = true;
        verticalTrackingEnabled = false;
        this.target = target;
        scrollSlopPx = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    TouchTracker(TouchEnabledVrView target, float scrollSlopPx)
    {
        lastTouchPointPx = new PointF();
        startTouchPointPx = new PointF();
        touchTrackingEnabled = true;
        verticalTrackingEnabled = false;
        this.target = target;
        this.scrollSlopPx = scrollSlopPx;
    }

    void setVerticalTrackingEnabled(boolean enabled)
    {
        verticalTrackingEnabled = enabled;
    }

    void setTouchTrackingEnabled(boolean enabled)
    {
        touchTrackingEnabled = enabled;
    }

    public boolean onTouch(View view, MotionEvent event)
    {
        switch(event.getAction())
        {
        case 0: // '\0'
            startTouchPointPx.set(event.getX(), event.getY());
            lastTouchPointPx.set(event.getX(), event.getY());
            view.getParent().requestDisallowInterceptTouchEvent(true);
            isYawing = false;
            return true;

        case 2: // '\002'
            if(!touchTrackingEnabled)
            {
                view.getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
            if(!isYawing)
            {
                if(!verticalTrackingEnabled && Math.abs(event.getY() - startTouchPointPx.y) > scrollSlopPx)
                {
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                    return false;
                }
                if(Math.abs(event.getX() - startTouchPointPx.x) > scrollSlopPx)
                    isYawing = true;
            }
            target.onPanningEvent(event.getX() - lastTouchPointPx.x, verticalTrackingEnabled ? event.getY() - lastTouchPointPx.y : 0.0F);
            lastTouchPointPx.set(event.getX(), event.getY());
            return true;

        case 1: // '\001'
            if(!touchTrackingEnabled || Math.abs(event.getX() - startTouchPointPx.x) < scrollSlopPx && Math.abs(event.getY() - startTouchPointPx.y) < scrollSlopPx)
                target.getEventListener().onClick();
            view.getParent().requestDisallowInterceptTouchEvent(false);
            return true;
        }
        return false;
    }

    private final TouchEnabledVrView target;
    private PointF lastTouchPointPx;
    private PointF startTouchPointPx;
    private boolean isYawing;
    private final float scrollSlopPx;
    private boolean touchTrackingEnabled;
    private boolean verticalTrackingEnabled;
}
