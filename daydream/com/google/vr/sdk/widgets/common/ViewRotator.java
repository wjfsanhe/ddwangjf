// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ViewRotator.java

package com.google.vr.sdk.widgets.common;

import android.content.Context;
import android.view.*;

class ViewRotator
{

    public ViewRotator(final Context context, View view, int initialRotationDegrees, boolean trackingSensorsAvailable)
    {
        if(!isViewProperlyConfigured(view))
            throw new IllegalArgumentException("View should have MATCH_PARENT layout and no translation.");
        if(initialRotationDegrees < 180)
            this.initialRotationDegrees = initialRotationDegrees;
        else
            this.initialRotationDegrees = initialRotationDegrees - 180;
        this.view = view;
        orientationEventListener = new OrientationEventListener(trackingSensorsAvailable) {

            public void onOrientationChanged(int orientation)
            {
                if(!trackingSensorsAvailable)
                    return;
                if(orientation == -1)
                    return;
                orientation += initialRotationDegrees;
                if(orientation > 180)
                    orientation -= 360;
                int orientationDelta = orientation - currentViewOrientation90Inc;
                if(orientationDelta > 180)
                    orientationDelta = 360 - orientationDelta;
                if(orientationDelta < -180)
                    orientationDelta = 360 + orientationDelta;
                if(Math.abs(orientationDelta) > 70)
                    rotateView(orientation);
            }

            final boolean val$trackingSensorsAvailable;
            final ViewRotator this$0;

            
            {
                this.this$0 = ViewRotator.this;
                trackingSensorsAvailable = flag;
                super(x0);
            }
        };
    }

    public void enable()
    {
        orientationEventListener.enable();
    }

    public void disable()
    {
        orientationEventListener.disable();
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = -1;
        layoutParams.width = -1;
        view.setTranslationY(0.0F);
        view.setTranslationX(0.0F);
        view.setRotation(0.0F);
        originalViewWidth = 0;
        originalViewHeight = 0;
    }

    private void rotateView(int newPhoneOrientation)
    {
        if(view.getParent() == null)
            return;
        if(originalViewWidth == 0 || originalViewHeight == 0)
        {
            originalViewWidth = view.getWidth();
            originalViewHeight = view.getHeight();
            if(originalViewWidth == 0 || originalViewHeight == 0)
                return;
        }
        currentViewOrientation90Inc = getNearestOrientationWith90Inc(newPhoneOrientation);
        view.setRotation(-currentViewOrientation90Inc);
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if(currentViewOrientation90Inc % 180 != 0)
        {
            layoutParams.height = originalViewWidth;
            layoutParams.width = originalViewHeight;
            view.setTranslationX((originalViewWidth - originalViewHeight) / 2);
            view.setTranslationY((originalViewHeight - originalViewWidth) / 2);
        } else
        {
            layoutParams.height = originalViewHeight;
            layoutParams.width = originalViewWidth;
            view.setTranslationY(0.0F);
            view.setTranslationX(0.0F);
        }
        view.requestLayout();
    }

    static int getNearestOrientationWith90Inc(int orientation)
    {
        double orientationSign = Math.signum(orientation);
        return (int)(orientationSign * (double)Math.round((double)Math.abs(orientation) / 90D) * 90D);
    }

    private static boolean isViewProperlyConfigured(View view)
    {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if(layoutParams != null && (layoutParams.height != -1 || layoutParams.width != -1))
            return false;
        else
            return view.getTranslationX() == 0.0F && view.getTranslationY() == 0.0F;
    }

    private static final int ORIENTATION_DELTA_THRESHOLD_DEGREES = 70;
    private final View view;
    private int currentViewOrientation90Inc;
    private final int initialRotationDegrees;
    private int originalViewWidth;
    private int originalViewHeight;
    private OrientationEventListener orientationEventListener;



}
