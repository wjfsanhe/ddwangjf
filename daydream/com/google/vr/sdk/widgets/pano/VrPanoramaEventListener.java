// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrPanoramaEventListener.java

package com.google.vr.sdk.widgets.pano;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.vr.sdk.widgets.common.VrEventListener;

public class VrPanoramaEventListener extends VrEventListener
{

    public VrPanoramaEventListener()
    {
    }

    private void onLoadSuccessJni()
    {
        uiHandler.post(new Runnable() {

            public void run()
            {
                onLoadSuccess();
                VrPanoramaEventListener.isLoadSuccessful = true;
            }

            final VrPanoramaEventListener this$0;

            
            {
                this.this$0 = VrPanoramaEventListener.this;
                super();
            }
        });
    }

    private void onLoadErrorJni(final String errorMessage)
    {
        int i;
        Log.e(TAG, (new StringBuilder(20 + String.valueOf(errorMessage).length())).append(i = hashCode()).append(".onError ").append(errorMessage).toString());
        uiHandler.post(new Runnable() {

            public void run()
            {
                onLoadError(errorMessage);
            }

            final String val$errorMessage;
            final VrPanoramaEventListener this$0;

            
            {
                this.this$0 = VrPanoramaEventListener.this;
                errorMessage = s;
                super();
            }
        });
    }

    public static volatile boolean isLoadSuccessful = false;
    private static final String TAG = com/google/vr/sdk/widgets/pano/VrPanoramaEventListener.getSimpleName();
    private static final boolean DEBUG = false;
    private final Handler uiHandler = new Handler(Looper.getMainLooper());

}
