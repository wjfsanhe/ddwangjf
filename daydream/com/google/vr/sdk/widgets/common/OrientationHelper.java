// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   OrientationHelper.java

package com.google.vr.sdk.widgets.common;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;

class OrientationHelper
{

    public OrientationHelper(Activity activity)
    {
        this.activity = activity;
    }

    public boolean isInPortraitOrientation()
    {
        return activity.getResources().getConfiguration().orientation == 1;
    }

    public void lockOrientation()
    {
        if(isOrientationLocked)
        {
            return;
        } else
        {
            originalRequestedOrientation = activity.getRequestedOrientation();
            activity.setRequestedOrientation(isInPortraitOrientation() ? 1 : 0);
            isOrientationLocked = true;
            return;
        }
    }

    public void restoreOriginalOrientation()
    {
        isOrientationLocked = false;
        activity.setRequestedOrientation(originalRequestedOrientation);
    }

    public Bundle onSaveInstanceState()
    {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isOrientationLocked", isOrientationLocked);
        bundle.putInt("originalRequestedOrientation", originalRequestedOrientation);
        return bundle;
    }

    public void onRestoreInstanceState(Bundle state)
    {
        originalRequestedOrientation = state.getInt("originalRequestedOrientation");
        isOrientationLocked = state.getBoolean("isOrientationLocked");
    }

    private static final String STATE_KEY_IS_ORIENTATION_LOCKED = "isOrientationLocked";
    private static final String STATE_KEY_ORIGINAL_REQUESTED_ORIENTATION = "originalRequestedOrientation";
    private Activity activity;
    private boolean isOrientationLocked;
    private int originalRequestedOrientation;
}
