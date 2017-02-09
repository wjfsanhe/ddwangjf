// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GvrApi.java

package com.google.vr.ndk.base;

import android.content.Context;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import com.google.protobuf.nano.MessageNano;
import com.google.vr.cardboard.*;
import com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice;
import com.google.vrtoolkit.cardboard.proto.nano.Phone;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

// Referenced classes of package com.google.vr.ndk.base:
//            BufferSpec, BufferViewport, BufferViewportList, SdkConfigurationReader, 
//            SwapChain, UserPrefs, GvrAnalytics

public class GvrApi
{
    public static abstract class ViewerType
    {

        public static final int CARDBOARD = 0;
        public static final int DAYDREAM = 1;
        static final int DEFAULT = 0;

        public ViewerType()
        {
        }
    }

    public static abstract class Error
    {

        public static final int NONE = 0;
        public static final int CONTROLLER_CREATE_FAILED = 2;
        public static final int NO_FRAME_AVAILABLE = 3;

        public Error()
        {
        }
    }

    public static interface PoseTracker
    {

        public abstract void getHeadPoseInStartSpace(float af[], long l);
    }


    public static void setPoseTrackerForTesting(PoseTracker posetracker)
    {
        sPoseTrackerForTesting = posetracker;
    }

    public static void setDynamicLibraryLoadingEnabled(boolean flag)
    {
        nativeSetDynamicLibraryLoadingEnabled(flag);
    }

    public GvrApi(Context context1, DisplaySynchronizer displaysynchronizer)
    {
        context = context1;
        displaySynchronizer = displaysynchronizer;
        long l = displaysynchronizer != null ? displaysynchronizer.getNativeDisplaySynchronizer() : 0L;
        vrParamsProvider = VrParamsProviderFactory.create(context1);
        swapChainRefs = new ArrayList();
        DisplayMetrics displaymetrics = computeCurrentDisplayMetrics();
        nativeGvrContext = nativeCreate(getClass().getClassLoader(), context1.getApplicationContext(), l, displaymetrics.widthPixels, displaymetrics.heightPixels, displaymetrics.xdpi, displaymetrics.ydpi, sPoseTrackerForTesting);
        if(nativeGvrContext == 0L)
            throw new IllegalStateException("Native GVR context creation failed, implementation unavailable.");
        else
            return;
    }

    void requestContextSharing(EglReadyListener eglreadylistener)
    {
        nativeRequestContextSharing(nativeGvrContext, eglreadylistener);
    }

    static DisplaySynchronizer createDefaultDisplaySynchronizer(Context context1)
    {
        return new DisplaySynchronizer(context1, DisplayUtils.getDefaultDisplay(context1));
    }

    protected void finalize()
        throws Throwable
    {
        if(nativeGvrContext != 0L)
        {
            Log.w(TAG, "GvrApi.shutdown() should be called to ensure resource cleanup");
            shutdown();
        }
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    com.google.common.logging.nano.Vr.VREvent.SdkConfigurationParams getSdkConfigurationParams()
    {
        return SdkConfigurationReader.getParams(context);
    }

    void pause()
    {
        nativePause(nativeGvrContext);
    }

    void resume()
    {
        nativeResume(nativeGvrContext);
    }

    public void shutdown()
    {
        ArrayList arraylist;
        int i = (arraylist = (ArrayList)swapChainRefs).size();
        int j = 0;
        Object obj = null;
        do
        {
            if(j >= i)
                break;
            j++;
            WeakReference weakreference;
            SwapChain swapchain;
            if((swapchain = (SwapChain)(weakreference = (WeakReference)arraylist.get(j)).get()) != null)
                swapchain.shutdown();
        } while(true);
        if(nativeGvrContext != 0L)
        {
            vrParamsProvider.close();
            nativeReleaseGvrContext(nativeGvrContext);
            nativeGvrContext = 0L;
        }
    }

    public long getNativeGvrContext()
    {
        return nativeGvrContext;
    }

    public int getError()
    {
        return nativeGetError(nativeGvrContext);
    }

    public int clearError()
    {
        return nativeClearError(nativeGvrContext);
    }

    public static String getErrorString(int i)
    {
        return nativeGetErrorString(i);
    }

    public UserPrefs getUserPrefs()
    {
        if(userPrefs == null)
            userPrefs = new UserPrefs(nativeGetUserPrefs(nativeGvrContext));
        return userPrefs;
    }

    public GvrAnalytics experimentalGetAnalytics()
    {
        return analytics;
    }

    void dumpDebugData()
    {
        nativeDumpDebugData(nativeGvrContext);
    }

    public void initializeGl()
    {
        nativeInitializeGl(nativeGvrContext);
    }

    public void onSurfaceCreatedReprojectionThread()
    {
        nativeOnSurfaceCreatedReprojectionThread(nativeGvrContext);
    }

    public BufferSpec createBufferSpec()
    {
        return new BufferSpec(nativeBufferSpecCreate(nativeGvrContext));
    }

    public SwapChain createSwapChain(BufferSpec abufferspec[])
    {
        long al[] = new long[abufferspec.length];
        for(int i = 0; i < abufferspec.length; i++)
            al[i] = abufferspec[i].nativeBufferSpec;

        SwapChain swapchain = new SwapChain(nativeSwapChainCreate(nativeGvrContext, al));
        swapChainRefs.add(new WeakReference(swapchain));
        return swapchain;
    }

    public BufferViewportList createBufferViewportList()
    {
        return new BufferViewportList(nativeBufferViewportListCreate(nativeGvrContext));
    }

    public BufferViewport createBufferViewport()
    {
        return new BufferViewport(nativeBufferViewportCreate(nativeGvrContext));
    }

    public void getRecommendedBufferViewports(BufferViewportList bufferviewportlist)
    {
        nativeGetRecommendedBufferViewports(nativeGvrContext, bufferviewportlist.nativeBufferViewportList);
    }

    public void getScreenBufferViewports(BufferViewportList bufferviewportlist)
    {
        nativeGetScreenBufferViewports(nativeGvrContext, bufferviewportlist.nativeBufferViewportList);
    }

    public void getMaximumEffectiveRenderTargetSize(Point point)
    {
        nativeGetMaximumEffectiveRenderTargetSize(nativeGvrContext, point);
    }

    public void getScreenTargetSize(Point point)
    {
        nativeGetScreenTargetSize(nativeGvrContext, point);
    }

    /**
     * @deprecated Method distortToScreen is deprecated
     */

    public void distortToScreen(int i, BufferViewportList bufferviewportlist, float af[], long l)
    {
        if(af == null)
        {
            throw new IllegalArgumentException("Head transform must not be null.");
        } else
        {
            nativeDistortToScreen(nativeGvrContext, i, bufferviewportlist.nativeBufferViewportList, af, l);
            return;
        }
    }

    public Point renderReprojectionThread()
    {
        return nativeRenderReprojectionThread(nativeGvrContext);
    }

    public void onPauseReprojectionThread()
    {
        nativeOnPauseReprojectionThread(nativeGvrContext);
    }

    public void updateSurfaceReprojectionThread(int i, int j, long l, float af[])
    {
        nativeUpdateSurfaceReprojectionThread(nativeGvrContext, i, j, l, af);
    }

    public void removeAllSurfacesReprojectionThread()
    {
        nativeRemoveAllSurfacesReprojectionThread(nativeGvrContext);
    }

    public void setDefaultFramebufferActive()
    {
        nativeSetDefaultFramebufferActive(nativeGvrContext);
    }

    public void getHeadSpaceFromStartSpaceRotation(float af[], long l)
    {
        if(af == null || af.length != 16)
        {
            throw new IllegalArgumentException("Invalid head rotation argument, must be a float[16].");
        } else
        {
            nativeGetHeadSpaceFromStartSpaceRotation(nativeGvrContext, af, l);
            return;
        }
    }

    void setIgnoreManualTrackerPauseResume(boolean flag)
    {
        nativeSetIgnoreManualPauseResumeTracker(nativeGvrContext, flag);
    }

    public void pauseTracking()
    {
        nativePauseTracking(nativeGvrContext);
    }

    public void resumeTracking()
    {
        nativeResumeTracking(nativeGvrContext, null);
    }

    public byte[] pauseTrackingGetState()
    {
        return nativePauseTracking(nativeGvrContext);
    }

    public void resumeTrackingSetState(byte abyte0[])
    {
        nativeResumeTracking(nativeGvrContext, abyte0);
    }

    public void resetTracking()
    {
        nativeResetTracking(nativeGvrContext);
    }

    public void recenterTracking()
    {
        nativeRecenterTracking(nativeGvrContext);
    }

    public void reconnectSensors()
    {
        nativeReconnectSensors(nativeGvrContext);
    }

    public void refreshDisplayMetrics()
    {
        setDisplayMetrics(computeCurrentDisplayMetrics());
    }

    public boolean setDefaultViewerProfile(String s)
    {
        return nativeSetDefaultViewerProfile(nativeGvrContext, s);
    }

    public void refreshViewerProfile()
    {
        com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams deviceparams;
        if((deviceparams = vrParamsProvider.readDeviceParams()) != null)
            setViewerParams(MessageNano.toByteArray(deviceparams));
    }

    public String getViewerVendor()
    {
        return nativeGetViewerVendor(nativeGvrContext);
    }

    public String getViewerModel()
    {
        return nativeGetViewerModel(nativeGvrContext);
    }

    public int getViewerType()
    {
        return nativeGetViewerType(nativeGvrContext);
    }

    /**
     * @deprecated Method getEyeFromHeadMatrix is deprecated
     */

    public float[] getEyeFromHeadMatrix(int i)
    {
        float af[] = new float[16];
        getEyeFromHeadMatrix(i, af);
        return af;
    }

    public void getEyeFromHeadMatrix(int i, float af[])
    {
        nativeGetEyeFromHeadMatrix(nativeGvrContext, i, af);
    }

    public int[] getWindowBounds()
    {
        int ai[];
        if((ai = nativeGetWindowBounds(nativeGvrContext)).length != 4)
            throw new AssertionError("Implementation error: invalid window bounds.");
        else
            return ai;
    }

    public float[] computeDistortedPoint(int i, float af[])
    {
        float af1[];
        if((af1 = nativeComputeDistortedPoint(nativeGvrContext, i, af)).length != 6)
            throw new AssertionError("Implementation error: invalid UV coordinates output.");
        else
            return af1;
    }

    boolean setAsyncReprojectionEnabled(boolean flag)
    {
        return nativeSetAsyncReprojectionEnabled(nativeGvrContext, flag);
    }

    public boolean getAsyncReprojectionEnabled()
    {
        return nativeGetAsyncReprojectionEnabled(nativeGvrContext);
    }

    public void setSurfaceSize(int i, int j)
    {
        if((i == 0) != (j == 0))
        {
            throw new IllegalArgumentException("Custom surface dimensions should both either be zero or non-zero");
        } else
        {
            nativeSetSurfaceSize(nativeGvrContext, i, j);
            return;
        }
    }

    public void setLensOffset(float f, float f1)
    {
        nativeSetLensOffset(nativeGvrContext, f, f1);
    }

    public DisplayMetrics computeCurrentDisplayMetrics()
    {
        Display display;
        if(displaySynchronizer == null)
            display = DisplayUtils.getDefaultDisplay(context);
        else
            display = displaySynchronizer.getDisplay();
        return DisplayUtils.getDisplayMetricsLandscapeWithOverride(display, vrParamsProvider.readPhoneParams());
    }

    public void setDisplayMetrics(DisplayMetrics displaymetrics)
    {
        nativeSetDisplayMetrics(nativeGvrContext, displaymetrics.widthPixels, displaymetrics.heightPixels, displaymetrics.xdpi, displaymetrics.ydpi);
    }

    public float getBorderSizeMeters()
    {
        return nativeGetBorderSizeMeters(nativeGvrContext);
    }

    private boolean setViewerParams(byte abyte0[])
    {
        return nativeSetViewerParams(nativeGvrContext, abyte0);
    }

    public boolean usingVrDisplayService()
    {
        return nativeUsingVrDisplayService(nativeGvrContext);
    }

    private native long nativeBufferViewportListCreate(long l);

    static native void nativeBufferViewportListDestroy(long l);

    static native int nativeBufferViewportListGetSize(long l);

    static native void nativeBufferViewportListGetItem(long l, int i, long l1);

    static native void nativeBufferViewportListSetItem(long l, int i, long l1);

    static native long nativeBufferViewportCreate(long l);

    static native void nativeBufferViewportDestroy(long l);

    static native void nativeBufferViewportGetSourceUv(long l, RectF rectf);

    static native void nativeBufferViewportSetSourceUv(long l, float f, float f1, float f2, float f3);

    static native void nativeBufferViewportGetSourceFov(long l, RectF rectf);

    static native void nativeBufferViewportSetSourceFov(long l, float f, float f1, float f2, float f3);

    static native void nativeBufferViewportGetTransform(long l, float af[]);

    static native void nativeBufferViewportSetTransform(long l, float af[]);

    static native boolean nativeBufferViewportEqual(long l, long l1);

    static native int nativeBufferViewportGetTargetEye(long l);

    static native void nativeBufferViewportSetTargetEye(long l, int i);

    static native int nativeBufferViewportGetSourceBufferIndex(long l);

    static native void nativeBufferViewportSetSourceBufferIndex(long l, int i);

    static native int nativeBufferViewportGetExternalSurfaceId(long l);

    static native void nativeBufferViewportSetExternalSurfaceId(long l, int i);

    static native int nativeBufferViewportGetReprojection(long l);

    static native void nativeBufferViewportSetReprojection(long l, int i);

    static native long nativeBufferSpecCreate(long l);

    static native void nativeBufferSpecDestroy(long l);

    static native void nativeBufferSpecGetSize(long l, Point point);

    static native void nativeBufferSpecSetSize(long l, int i, int j);

    static native void nativeBufferSpecSetColorFormat(long l, int i);

    static native void nativeBufferSpecSetDepthStencilFormat(long l, int i);

    static native int nativeBufferSpecGetSamples(long l);

    static native void nativeBufferSpecSetSamples(long l, int i);

    static native long nativeSwapChainCreate(long l, long al[]);

    static native void nativeSwapChainDestroy(long l);

    static native int nativeSwapChainGetBufferCount(long l);

    static native void nativeSwapChainGetBufferSize(long l, int i, Point point);

    static native void nativeSwapChainResizeBuffer(long l, int i, int j, int k);

    static native long nativeSwapChainAcquireFrame(long l);

    static native void nativeFrameBindBuffer(long l, int i);

    static native void nativeFrameUnbind(long l);

    static native int nativeFrameGetFramebufferObject(long l, int i);

    static native void nativeFrameGetBufferSize(long l, int i, Point point);

    static native void nativeFrameSubmit(long l, long l1, float af[]);

    private static native void nativeSetDynamicLibraryLoadingEnabled(boolean flag);

    private native long nativeCreate(ClassLoader classloader, Context context1, long l, int i, int j, float f, 
            float f1, PoseTracker posetracker);

    private native void nativeRequestContextSharing(long l, EglReadyListener eglreadylistener);

    private native int nativeGetError(long l);

    private native int nativeClearError(long l);

    private static native String nativeGetErrorString(int i);

    private native long nativeGetUserPrefs(long l);

    static native int nativeUserPrefsGetControllerHandedness(long l);

    static native boolean nativeUserPrefsGetPerformanceMonitoringEnabled(long l);

    private native long nativeGetAnalytics(long l);

    static native byte[] nativeAnalyticsGetSample(long l);

    private native void nativePause(long l);

    private native void nativeResume(long l);

    private native void nativeReleaseGvrContext(long l);

    private native void nativeInitializeGl(long l);

    private native void nativeOnSurfaceCreatedReprojectionThread(long l);

    private native void nativeGetRecommendedBufferViewports(long l, long l1);

    private native void nativeGetScreenBufferViewports(long l, long l1);

    private native void nativeGetMaximumEffectiveRenderTargetSize(long l, Point point);

    private native void nativeGetScreenTargetSize(long l, Point point);

    private native void nativeDistortToScreen(long l, int i, long l1, float af[], long l2);

    private native void nativeSetDefaultFramebufferActive(long l);

    private native Point nativeRenderReprojectionThread(long l);

    private native void nativeOnPauseReprojectionThread(long l);

    private native void nativeUpdateSurfaceReprojectionThread(long l, int i, int j, long l1, float af[]);

    private native void nativeRemoveAllSurfacesReprojectionThread(long l);

    private native void nativeGetHeadSpaceFromStartSpaceRotation(long l, float af[], long l1);

    private native void nativeSetIgnoreManualPauseResumeTracker(long l, boolean flag);

    private native byte[] nativePauseTracking(long l);

    private native void nativeResumeTracking(long l, byte abyte0[]);

    private native void nativeResetTracking(long l);

    private native void nativeRecenterTracking(long l);

    private native void nativeGetEyeFromHeadMatrix(long l, int i, float af[]);

    private native int[] nativeGetWindowBounds(long l);

    private native float[] nativeComputeDistortedPoint(long l, int i, float af[]);

    private native boolean nativeSetDefaultViewerProfile(long l, String s);

    private native String nativeGetViewerVendor(long l);

    private native String nativeGetViewerModel(long l);

    private native int nativeGetViewerType(long l);

    private native boolean nativeSetAsyncReprojectionEnabled(long l, boolean flag);

    private native boolean nativeGetAsyncReprojectionEnabled(long l);

    private native void nativeReconnectSensors(long l);

    private native boolean nativeSetViewerParams(long l, byte abyte0[]);

    private native void nativeSetDisplayMetrics(long l, int i, int j, float f, float f1);

    private native float nativeGetBorderSizeMeters(long l);

    private native void nativeSetSurfaceSize(long l, int i, int j);

    private native void nativeSetLensOffset(long l, float f, float f1);

    private native void nativeDumpDebugData(long l);

    private native boolean nativeUsingVrDisplayService(long l);

    private static final String TAG = com/google/vr/ndk/base/GvrApi.getSimpleName();
    private static PoseTracker sPoseTrackerForTesting;
    private long nativeGvrContext;
    private final Context context;
    private final VrParamsProvider vrParamsProvider;
    private final DisplaySynchronizer displaySynchronizer;
    private ArrayList swapChainRefs;
    private UserPrefs userPrefs;
    private GvrAnalytics analytics;

    static 
    {
        try
        {
            System.loadLibrary("gvr");
        }
        catch(UnsatisfiedLinkError _ex) { }
    }
}
