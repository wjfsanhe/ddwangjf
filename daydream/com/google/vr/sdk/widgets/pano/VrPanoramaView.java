// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrPanoramaView.java

package com.google.vr.sdk.widgets.pano;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.Log;
import com.google.vr.sdk.widgets.common.VrWidgetRenderer;
import com.google.vr.sdk.widgets.common.VrWidgetView;

// Referenced classes of package com.google.vr.sdk.widgets.pano:
//            VrPanoramaEventListener, VrPanoramaRenderer

public class VrPanoramaView extends VrWidgetView
{
    public static class Options
    {

        void validate()
        {
            if(inputType <= 0 || inputType >= 3)
            {
                int i;
                Log.e(VrPanoramaView.TAG, (new StringBuilder(38)).append("Invalid Options.inputType: ").append(i = inputType).toString());
                inputType = 1;
            }
        }

        private static final int TYPE_START_MARKER = 0;
        public static final int TYPE_MONO = 1;
        public static final int TYPE_STEREO_OVER_UNDER = 2;
        private static final int TYPE_END_MARKER = 3;
        public int inputType;

        public Options()
        {
            inputType = 1;
        }
    }


    public VrPanoramaView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        eventListener = new VrPanoramaEventListener();
    }

    public VrPanoramaView(Context context)
    {
        super(context);
        eventListener = new VrPanoramaEventListener();
    }

    protected VrPanoramaRenderer createRenderer(Context context, com.google.vr.sdk.widgets.common.VrWidgetRenderer.GLThreadScheduler glThreadScheduler, float xMetersPerPixel, float yMetersPerPixel, int screenRotation)
    {
        renderer = new VrPanoramaRenderer(getContext(), glThreadScheduler, xMetersPerPixel, yMetersPerPixel, screenRotation);
        return renderer;
    }

    public void loadImageFromBitmap(Bitmap bitmap, Options options)
    {
        if(options == null)
            options = new Options();
        else
            options.validate();
        renderer.loadImageFromBitmap(bitmap, options, eventListener);
    }

    public void loadImageFromByteArray(byte jpegImageData[], Options options)
    {
        if(options == null)
            options = new Options();
        else
            options.validate();
        renderer.loadImageFromByteArray(jpegImageData, options, eventListener);
    }

    public void setEventListener(VrPanoramaEventListener eventListener)
    {
        super.setEventListener(eventListener);
        this.eventListener = eventListener;
    }

    protected volatile VrWidgetRenderer createRenderer(Context context, com.google.vr.sdk.widgets.common.VrWidgetRenderer.GLThreadScheduler glthreadscheduler, float f, float f1, int i)
    {
        return createRenderer(context, glthreadscheduler, f, f1, i);
    }

    private static final String TAG = com/google/vr/sdk/widgets/pano/VrPanoramaView.getSimpleName();
    private static final boolean DEBUG = false;
    private VrPanoramaRenderer renderer;
    private VrPanoramaEventListener eventListener;


}
