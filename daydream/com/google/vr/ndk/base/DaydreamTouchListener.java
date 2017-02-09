// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DaydreamTouchListener.java

package com.google.vr.ndk.base;

import android.content.Context;
import android.os.AsyncTask;
import android.util.DisplayMetrics;
import android.view.*;
import com.google.vr.cardboard.*;
import com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice;
import com.google.vrtoolkit.cardboard.proto.nano.Phone;

// Referenced classes of package com.google.vr.ndk.base:
//            GvrApi

class DaydreamTouchListener
    implements android.view.View.OnTouchListener
{
    private class FinishInitilizationTask extends AsyncTask
    {

        protected transient com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams doInBackground(Void avoid[])
        {
            return vrParamsProvider.readPhoneParams();
        }

        protected transient void onProgressUpdate(Void avoid[])
        {
        }

        protected void onPostExecute(com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams phoneparams)
        {
            DisplayMetrics displaymetrics = DisplayUtils.getDisplayMetricsLandscapeWithOverride(display, phoneparams);
            init(displaymetrics, phoneparams);
        }

        protected volatile void onProgressUpdate(Object aobj[])
        {
            onProgressUpdate((Void[])aobj);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams)obj);
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        public Display display;
        final DaydreamTouchListener this$0;

        private FinishInitilizationTask()
        {
            this$0 = DaydreamTouchListener.this;
            super();
        }

    }

    private class RefreshViewerProfileTask extends AsyncTask
    {

        protected transient com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams doInBackground(Void avoid[])
        {
            return vrParamsProvider.readDeviceParams();
        }

        protected transient void onProgressUpdate(Void avoid[])
        {
        }

        protected void onPostExecute(com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams deviceparams)
        {
            if(deviceparams == null || deviceparams.daydreamInternal == null || deviceparams.daydreamInternal.alignmentMarkers == null)
            {
                markersInPixels = null;
                return;
            }
            com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.ScreenAlignmentMarker ascreenalignmentmarker[] = deviceparams.daydreamInternal.alignmentMarkers;
            markersInPixels = new float[ascreenalignmentmarker.length][];
            currentMarkerBestDists = new double[ascreenalignmentmarker.length];
            markerBestTouch = new int[ascreenalignmentmarker.length];
            for(int i = 0; i < ascreenalignmentmarker.length; i++)
            {
                com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.ScreenAlignmentMarker screenalignmentmarker = ascreenalignmentmarker[i];
                markersInPixels[i] = new float[2];
                markersInPixels[i][0] = (float)(displayMetrics.widthPixels / 2) + screenalignmentmarker.getHorizontal() / xMetersPerPixel;
                markersInPixels[i][1] = (float)displayMetrics.heightPixels - ((screenalignmentmarker.getVertical() + deviceparams.getTrayToLensDistance()) - borderSizeMeters) / yMetersPerPixel;
            }

        }

        protected volatile void onProgressUpdate(Object aobj[])
        {
            onProgressUpdate((Void[])aobj);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams)obj);
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        final DaydreamTouchListener this$0;

        private RefreshViewerProfileTask()
        {
            this$0 = DaydreamTouchListener.this;
            super();
        }

    }


    public DaydreamTouchListener(Context context, GvrApi gvrapi)
    {
        pixelTranslation = new float[2];
        enabled = true;
        lastTranslation = new float[2];
        translation = new float[2];
        isDaydreamImageAlignmentEnabled = gvrapi.getSdkConfigurationParams().daydreamImageAlignment.intValue() != 1;
        vrParamsProvider = VrParamsProviderFactory.create(context);
        FinishInitilizationTask finishinitilizationtask;
        (finishinitilizationtask = new FinishInitilizationTask()).display = DisplayUtils.getDefaultDisplay(context);
        finishinitilizationtask.execute(new Void[0]);
        gvrApi = gvrapi;
    }

    DaydreamTouchListener(VrParamsProvider vrparamsprovider, DisplayMetrics displaymetrics, com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams phoneparams, GvrApi gvrapi, boolean flag)
    {
        pixelTranslation = new float[2];
        enabled = true;
        lastTranslation = new float[2];
        translation = new float[2];
        isDaydreamImageAlignmentEnabled = flag;
        vrParamsProvider = vrparamsprovider;
        gvrApi = gvrapi;
        init(displaymetrics, phoneparams);
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if(!processMotionEvent(motionevent))
            return false;
        getTranslationInScreenSpace(translation);
        if(translation[0] != lastTranslation[0] || translation[1] != lastTranslation[1])
        {
            lastTranslation[0] = translation[0];
            lastTranslation[1] = translation[1];
            gvrApi.setLensOffset(translation[0], translation[1]);
        }
        return true;
    }

    public void setEnabled(boolean flag)
    {
        enabled = flag;
        if(!flag)
            resetTrackingState();
    }

    public boolean processMotionEvent(MotionEvent motionevent)
    {
        if(!viewerNeedsTouchProcessing())
        {
            lastMotionEventInHeadset = false;
            return false;
        }
        if(!isDaydreamImageAlignmentEnabled())
            return true;
        int i;
        if((i = motionevent.getPointerCount()) > mostTouchesSeen)
        {
            touchBestMarker = new int[i];
            mostTouchesSeen = i;
        }
        for(int j = 0; j < markersInPixels.length; j++)
        {
            markerBestTouch[j] = -1;
            currentMarkerBestDists[j] = 0.00022499999999999999D;
        }

        for(int k = 0; k < i; k++)
        {
            double d = 0.00022499999999999999D;
            touchBestMarker[k] = -1;
            for(int i1 = 0; i1 < markersInPixels.length; i1++)
            {
                float f2 = (markersInPixels[i1][0] - motionevent.getX(k)) * xMetersPerPixel;
                float f3 = (markersInPixels[i1][1] - motionevent.getY(k)) * yMetersPerPixel;
                double d1;
                if((d1 = f2 * f2 + f3 * f3) < d)
                {
                    d = d1;
                    touchBestMarker[k] = i1;
                }
                if(d1 < currentMarkerBestDists[i1])
                {
                    currentMarkerBestDists[i1] = d1;
                    markerBestTouch[i1] = k;
                }
            }

        }

        float f = 0.0F;
        float f1 = 0.0F;
        int l = 0;
        for(int j1 = 0; j1 < markerBestTouch.length; j1++)
        {
            if(markerBestTouch[j1] == -1)
                continue;
            if(touchBestMarker[markerBestTouch[j1]] != j1)
            {
                markerBestTouch[j1] = -1;
            } else
            {
                l++;
                f += motionevent.getX(markerBestTouch[j1]) - markersInPixels[j1][0];
                f1 += motionevent.getY(markerBestTouch[j1]) - markersInPixels[j1][1];
            }
        }

        if(l > 0)
        {
            lastMotionEventInHeadset = true;
            pixelTranslation[0] = f / (float)l;
            pixelTranslation[1] = f1 / (float)l;
        } else
        {
            lastMotionEventInHeadset = false;
            pixelTranslation[0] = 0.0F;
            pixelTranslation[1] = 0.0F;
        }
        return true;
    }

    void getTranslationInPixels(float af[])
    {
        if(af.length < 2)
        {
            throw new IllegalArgumentException("Translation array too small");
        } else
        {
            af[0] = pixelTranslation[0];
            af[1] = pixelTranslation[1];
            return;
        }
    }

    public void getTranslationInScreenSpace(float af[])
    {
        if(af.length < 2)
        {
            throw new IllegalArgumentException("Translation array too small");
        } else
        {
            af[0] = pixelTranslation[0] / (float)displayMetrics.widthPixels;
            af[1] = pixelTranslation[1] / (float)displayMetrics.heightPixels;
            af[0] *= 4F;
            af[1] *= -2F;
            return;
        }
    }

    boolean viewerNeedsTouchProcessing()
    {
        return enabled && markersInPixels != null && markersInPixels.length > 0;
    }

    boolean isDaydreamImageAlignmentEnabled()
    {
        return isDaydreamImageAlignmentEnabled;
    }

    boolean wasLastMotionEventInViewer()
    {
        return lastMotionEventInHeadset;
    }

    public void refreshViewerProfile()
    {
        (new RefreshViewerProfileTask()).execute(new Void[0]);
    }

    public void shutdown()
    {
        vrParamsProvider.close();
    }

    private void init(DisplayMetrics displaymetrics, com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams phoneparams)
    {
        displayMetrics = displaymetrics;
        borderSizeMeters = DisplayUtils.getBorderSizeMeters(phoneparams);
        xMetersPerPixel = DisplayUtils.getMetersPerPixelFromDotsPerInch(displayMetrics.xdpi);
        yMetersPerPixel = DisplayUtils.getMetersPerPixelFromDotsPerInch(displayMetrics.ydpi);
        resetTrackingState();
        refreshViewerProfile();
    }

    private void resetTrackingState()
    {
        lastMotionEventInHeadset = false;
        pixelTranslation[0] = 0.0F;
        pixelTranslation[1] = 0.0F;
        mostTouchesSeen = 0;
    }

    private static final String TAG = "DaydreamTouchListener";
    private static final double MAX_TOUCH_DISTANCE_SQUARED_METERS = 0.00022499999999999999D;
    private final VrParamsProvider vrParamsProvider;
    private DisplayMetrics displayMetrics;
    private float xMetersPerPixel;
    private float yMetersPerPixel;
    private float borderSizeMeters;
    private float markersInPixels[][];
    private int mostTouchesSeen;
    private int touchBestMarker[];
    private int markerBestTouch[];
    private double currentMarkerBestDists[];
    private float pixelTranslation[];
    private boolean lastMotionEventInHeadset;
    private boolean enabled;
    private float lastTranslation[];
    private float translation[];
    private final GvrApi gvrApi;
    private final boolean isDaydreamImageAlignmentEnabled;










}
