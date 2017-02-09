// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   HeadMountedDisplayManager.java

package com.google.vr.sdk.base;

import android.content.Context;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.google.vr.cardboard.VrParamsProvider;
import com.google.vr.cardboard.VrParamsProviderFactory;
import com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice;
import com.google.vrtoolkit.cardboard.proto.nano.Phone;

// Referenced classes of package com.google.vr.sdk.base:
//            HeadMountedDisplay, GvrViewerParams, ScreenParams

public class HeadMountedDisplayManager
{

    public HeadMountedDisplayManager(Context context)
    {
        this.context = context;
        paramsProvider = VrParamsProviderFactory.create(context);
    }

    public HeadMountedDisplay getHeadMountedDisplay()
    {
        return hmd;
    }

    public void onResume()
    {
        com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams deviceProto = paramsProvider.readDeviceParams();
        GvrViewerParams deviceParams = deviceProto == null ? null : new GvrViewerParams(deviceProto);
        if(deviceParams != null && !deviceParams.equals(hmd.getGvrViewerParams()))
        {
            hmd.setGvrViewerParams(deviceParams);
            Log.i("HeadMountedDisplayManager", "Successfully read updated device params from external storage");
        }
        com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams phoneProto = paramsProvider.readPhoneParams();
        ScreenParams screenParams = phoneProto == null ? null : ScreenParams.fromProto(getDisplay(), phoneProto);
        if(screenParams != null && !screenParams.equals(hmd.getScreenParams()))
        {
            hmd.setScreenParams(screenParams);
            Log.i("HeadMountedDisplayManager", "Successfully read updated screen params from external storage");
        }
    }

    public void onPause()
    {
    }

    public boolean updateGvrViewerParams(GvrViewerParams gvrViewerParams)
    {
        if(gvrViewerParams == null || gvrViewerParams.equals(hmd.getGvrViewerParams()))
        {
            return false;
        } else
        {
            hmd.setGvrViewerParams(gvrViewerParams);
            paramsProvider.writeDeviceParams(gvrViewerParams.toProtobuf());
            return true;
        }
    }

    public boolean updateScreenParams(ScreenParams screenParams)
    {
        if(screenParams == null || screenParams.equals(hmd.getScreenParams()))
        {
            return false;
        } else
        {
            hmd.setScreenParams(screenParams);
            return true;
        }
    }

    private Display getDisplay()
    {
        WindowManager windowManager = (WindowManager)context.getSystemService("window");
        return windowManager.getDefaultDisplay();
    }

    private ScreenParams createScreenParams()
    {
        Display display = getDisplay();
        ScreenParams params = ScreenParams.fromProto(display, paramsProvider.readPhoneParams());
        return params == null ? new ScreenParams(display) : params;
    }

    private GvrViewerParams createGvrViewerParams()
    {
        return new GvrViewerParams(paramsProvider.readDeviceParams());
    }

    private static final String TAG = "HeadMountedDisplayManager";
    private final HeadMountedDisplay hmd = new HeadMountedDisplay(createScreenParams(), createGvrViewerParams());
    private final Context context;
    private final VrParamsProvider paramsProvider;
}
