// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrWidgetView.java

package com.google.vr.sdk.widgets.common;

import android.app.Activity;
import android.content.*;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.*;
import android.view.*;
import android.widget.*;
import com.google.vr.cardboard.*;
import com.google.vr.widgets.common.R;
import com.google.vrtoolkit.cardboard.ScreenOnFlagHelper;
import com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice;

// Referenced classes of package com.google.vr.sdk.widgets.common:
//            VrWidgetRenderer, TouchTracker, VrEventListener, TrackingSensorsHelper, 
//            OrientationHelper, FullScreenDialog, ViewRotator

public abstract class VrWidgetView extends FrameLayout
{
    public static abstract class DisplayMode
    {

        private static final int START_MARKER = 0;
        public static final int EMBEDDED = 1;
        public static final int FULLSCREEN_MONO = 2;
        public static final int FULLSCREEN_STEREO = 3;
        private static final int END_MARKER = 4;

        public DisplayMode()
        {
        }
    }


    public VrWidgetView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        eventListener = new VrEventListener();
        if(isInEditMode())
        {
            return;
        } else
        {
            checkContextIsActivity(context);
            init();
            return;
        }
    }

    public VrWidgetView(Context context)
    {
        super(context);
        eventListener = new VrEventListener();
        checkContextIsActivity(context);
        init();
    }

    protected void onDetachedFromWindow()
    {
        renderer.onViewDetach();
        super.onDetachedFromWindow();
    }

    private void checkContextIsActivity(Context context)
    {
        if(!(context instanceof Activity))
        {
            throw new RuntimeException("Context must be an instance of activity");
        } else
        {
            activity = (Activity)context;
            return;
        }
    }

    private void init()
    {
        displayMode = 1;
        viewerParamsProvider = VrParamsProviderFactory.create(getContext());
        sensorsHelper = new TrackingSensorsHelper(getContext().getPackageManager());
        isStereoModeButtonEnabled = sensorsHelper.areTrackingSensorsAvailable() || sensorsHelper.showStereoModeButtonForTesting();
        isFullscreenButtonEnabled = true;
        isInfoButtonEnabled = true;
        isTouchTrackingEnabled = true;
        isTransitionViewEnabled = true;
        screenOnFlagHelper = new ScreenOnFlagHelper(activity);
        WindowManager windowManager = (WindowManager)getContext().getSystemService("window");
        Display display = windowManager.getDefaultDisplay();
        displayMetrics = new DisplayMetrics();
        display.getRealMetrics(displayMetrics);
        initializeRenderingView(display.getRotation());
        innerWidgetView = new FrameLayout(getContext());
        innerWidgetView.setId(com.google.vr.widgets.common.R.id.vrwidget_inner_view);
        innerWidgetView.addView(renderingView);
        setPadding(0, 0, 0, 0);
        addView(innerWidgetView);
        orientationHelper = new OrientationHelper(activity);
        fullScreenDialog = new FullScreenDialog(getContext(), innerWidgetView, renderer);
        fullScreenDialog.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            public void onCancel(DialogInterface dialog)
            {
                setDisplayMode(1);
            }

            final VrWidgetView this$0;

            
            {
                this.this$0 = VrWidgetView.this;
                super();
            }
        });
        uiView = inflate(getContext(), com.google.vr.widgets.common.R.layout.ui_view_embed, null);
        viewRotator = new ViewRotator(getContext(), uiView, getScreenRotationInDegrees(display.getRotation()), sensorsHelper.areTrackingSensorsAvailable());
        innerWidgetView.addView(uiView);
        innerWidgetView.addView(new View(getContext()));
        vrUiLayer = new UiLayer(getContext());
        vrUiLayer.setPortraitSupportEnabled(true);
        vrUiLayer.setEnabled(true);
        innerWidgetView.addView(vrUiLayer.getView());
        updateTouchTracker();
        initializeUiButtons();
    }

    private boolean isFullScreen()
    {
        return displayMode == 2 || displayMode == 3;
    }

    private void updateTouchTracker()
    {
        if(touchTracker == null)
        {
            touchTracker = new TouchTracker(getContext(), new TouchTracker.TouchEnabledVrView() {

                public void onPanningEvent(float deltaPixelX, float deltaPixelY)
                {
                    renderer.onPanningEvent(deltaPixelX, deltaPixelY);
                }

                public VrEventListener getEventListener()
                {
                    return eventListener;
                }

                final VrWidgetView this$0;

            
            {
                this.this$0 = VrWidgetView.this;
                super();
            }
            });
            setOnTouchListener(touchTracker);
        }
        touchTracker.setTouchTrackingEnabled(isTouchTrackingEnabled && displayMode != 3);
        touchTracker.setVerticalTrackingEnabled(isFullScreen());
    }

    private void initializeRenderingView(int rotation)
    {
        renderingView = new GLSurfaceView(getContext());
        renderingView.setEGLContextClientVersion(2);
        renderingView.setEGLConfigChooser(8, 8, 8, 8, 16, 8);
        renderingView.setPreserveEGLContextOnPause(true);
        float xMetersPerPixel = 0.0254F / displayMetrics.xdpi;
        float yMetersPerPixel = 0.0254F / displayMetrics.ydpi;
        VrWidgetRenderer.GLThreadScheduler scheduler = new VrWidgetRenderer.GLThreadScheduler() {

            public void queueGlThreadEvent(Runnable runnable)
            {
                renderingView.queueEvent(runnable);
            }

            final VrWidgetView this$0;

            
            {
                this.this$0 = VrWidgetView.this;
                super();
            }
        };
        renderer = createRenderer(getContext(), scheduler, xMetersPerPixel, yMetersPerPixel, getScreenRotationInDegrees(rotation));
        renderingView.setRenderer(renderer);
    }

    protected abstract VrWidgetRenderer createRenderer(Context context, VrWidgetRenderer.GLThreadScheduler glthreadscheduler, float f, float f1, int i);

    private void initializeUiButtons()
    {
        enterFullscreenButton = (ImageButton)uiView.findViewById(com.google.vr.widgets.common.R.id.fullscreen_button);
        enterFullscreenButton.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View v)
            {
                setDisplayMode(2);
            }

            final VrWidgetView this$0;

            
            {
                this.this$0 = VrWidgetView.this;
                super();
            }
        });
        enterStereoModeButton = (ImageButton)uiView.findViewById(com.google.vr.widgets.common.R.id.vr_mode_button);
        enterStereoModeButton.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View v)
            {
                setDisplayMode(3);
            }

            final VrWidgetView this$0;

            
            {
                this.this$0 = VrWidgetView.this;
                super();
            }
        });
        fullscreenBackButton = (ImageButton)uiView.findViewById(com.google.vr.widgets.common.R.id.fullscreen_back_button);
        fullscreenBackButton.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View v)
            {
                setDisplayMode(1);
            }

            final VrWidgetView this$0;

            
            {
                this.this$0 = VrWidgetView.this;
                super();
            }
        });
        infoButton = (ImageButton)uiView.findViewById(com.google.vr.widgets.common.R.id.info_button);
        infoButton.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View v)
            {
                activity.startActivity(VrWidgetView.getInfoButtonIntent());
            }

            final VrWidgetView this$0;

            
            {
                this.this$0 = VrWidgetView.this;
                super();
            }
        });
        updateButtonVisibility();
    }

    public void getHeadRotation(float yawAndPitch[])
    {
        if(yawAndPitch.length < 2)
        {
            throw new IllegalArgumentException("Array should have at least 2 elements.");
        } else
        {
            renderer.getHeadRotation(yawAndPitch);
            return;
        }
    }

    public void setDisplayMode(int newDisplayMode)
    {
        if(newDisplayMode == displayMode)
            return;
        renderer.updateCurrentYaw();
        if(newDisplayMode <= 0 || newDisplayMode >= 4)
        {
            int i;
            Log.e(TAG, (new StringBuilder(38)).append("Invalid DisplayMode value: ").append(i = newDisplayMode).toString());
            newDisplayMode = 1;
        }
        displayMode = newDisplayMode;
        updateStereoMode();
        if(isFullScreen())
        {
            orientationHelper.lockOrientation();
            fullScreenDialog.show();
        } else
        {
            fullScreenDialog.dismiss();
            orientationHelper.restoreOriginalOrientation();
        }
        updateControlsLayout();
        updateTouchTracker();
        eventListener.onDisplayModeChanged(displayMode);
    }

    public int getDisplayMode()
    {
        return displayMode;
    }

    private void updateControlsLayout()
    {
        LinearLayout controlLayout = (LinearLayout)innerWidgetView.findViewById(com.google.vr.widgets.common.R.id.control_layout);
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams)controlLayout.getLayoutParams();
        if(displayMode == 3 && orientationHelper.isInPortraitOrientation())
        {
            layoutParams.addRule(9);
            layoutParams.addRule(11, 0);
        } else
        {
            layoutParams.addRule(9, 0);
            layoutParams.addRule(11);
        }
        controlLayout.setLayoutParams(layoutParams);
        if(displayMode == 2)
            viewRotator.enable();
        else
            viewRotator.disable();
    }

    private void updateStereoMode()
    {
        renderer.setStereoMode(displayMode == 3);
        AndroidNCompat.setVrModeEnabled(activity, displayMode == 3);
        if(displayMode == 3)
            screenOnFlagHelper.start();
        else
            screenOnFlagHelper.stop();
        updateButtonVisibility();
        updateViewerName();
    }

    private void updateButtonVisibility()
    {
        if(isFullscreenButtonEnabled && displayMode != 2)
            enterFullscreenButton.setVisibility(0);
        else
            enterFullscreenButton.setVisibility(8);
        if(isStereoModeButtonEnabled && displayMode != 3)
            enterStereoModeButton.setVisibility(0);
        else
            enterStereoModeButton.setVisibility(8);
        vrUiLayer.setSettingsButtonEnabled(displayMode == 3);
        vrUiLayer.setAlignmentMarkerEnabled(displayMode == 3);
        vrUiLayer.setTransitionViewEnabled(displayMode == 3 && isTransitionViewEnabled);
        if(!isFullScreen())
        {
            fullscreenBackButton.setVisibility(8);
            vrUiLayer.setBackButtonListener(null);
        } else
        if(displayMode == 3)
        {
            fullscreenBackButton.setVisibility(8);
            vrUiLayer.setBackButtonListener(new Runnable() {

                public void run()
                {
                    setDisplayMode(1);
                }

                final VrWidgetView this$0;

            
            {
                this.this$0 = VrWidgetView.this;
                super();
            }
            });
        } else
        {
            fullscreenBackButton.setVisibility(0);
            vrUiLayer.setBackButtonListener(null);
        }
        infoButton.setVisibility(!isInfoButtonEnabled || displayMode == 3 ? 8 : 0);
    }

    private int getScreenRotationInDegrees(int rotation)
    {
        switch(rotation)
        {
        case 1: // '\001'
            return 90;

        case 2: // '\002'
            return 180;

        case 3: // '\003'
            return 270;

        case 0: // '\0'
        default:
            return 0;
        }
    }

    protected void setEventListener(VrEventListener eventListener)
    {
        this.eventListener = eventListener;
    }

    public void pauseRendering()
    {
        renderingView.onPause();
        renderer.onPause();
        screenOnFlagHelper.stop();
        isPaused = true;
        viewRotator.disable();
    }

    public void resumeRendering()
    {
        renderingView.onResume();
        renderer.onResume();
        updateStereoMode();
        if(isFullScreen())
            fullScreenDialog.show();
        updateButtonVisibility();
        updateControlsLayout();
        isPaused = false;
    }

    public void shutdown()
    {
        if(!isPaused)
        {
            throw new IllegalStateException("pauseRendering() must be called before calling shutdown().");
        } else
        {
            viewerParamsProvider.close();
            renderer.shutdown();
            return;
        }
    }

    public void setStereoModeButtonEnabled(boolean enabled)
    {
        boolean sensorsAvailable = sensorsHelper.areTrackingSensorsAvailable();
        if(enabled && !sensorsAvailable)
            Log.w(TAG, "This phone doesn't have the necessary sensors for head tracking, stereo Mode button will be disabled.");
        isStereoModeButtonEnabled = enabled && sensorsAvailable;
        updateButtonVisibility();
    }

    public void setFullscreenButtonEnabled(boolean enabled)
    {
        isFullscreenButtonEnabled = enabled;
        updateButtonVisibility();
    }

    public void setTouchTrackingEnabled(boolean enabled)
    {
        if(isTouchTrackingEnabled == enabled)
        {
            return;
        } else
        {
            isTouchTrackingEnabled = enabled;
            updateTouchTracker();
            return;
        }
    }

    public void setTransitionViewEnabled(boolean enabled)
    {
        isTransitionViewEnabled = enabled;
        updateButtonVisibility();
    }

    public void setInfoButtonEnabled(boolean enabled)
    {
        isInfoButtonEnabled = enabled;
        updateButtonVisibility();
    }

    public void setOnTouchListener(android.view.View.OnTouchListener touchListener)
    {
        innerWidgetView.setOnTouchListener(touchListener);
    }

    protected Parcelable onSaveInstanceState()
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("superClassState", super.onSaveInstanceState());
        bundle.putBundle("orientationHelperState", orientationHelper.onSaveInstanceState());
        bundle.putBundle("widgetRendererState", renderer.onSaveInstanceState());
        bundle.putInt("displayMode", displayMode);
        return bundle;
    }

    protected void onRestoreInstanceState(Parcelable state)
    {
        if(state instanceof Bundle)
        {
            Bundle bundle = (Bundle)state;
            orientationHelper.onRestoreInstanceState(bundle.getBundle("orientationHelperState"));
            renderer.onRestoreInstanceState(bundle.getBundle("widgetRendererState"));
            displayMode = bundle.getInt("displayMode");
            state = bundle.getParcelable("superClassState");
        }
        super.onRestoreInstanceState(state);
    }

    static Intent getInfoButtonIntent()
    {
        return new Intent("android.intent.action.VIEW", INFO_BUTTON_URL);
    }

    private void updateViewerName()
    {
        com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams deviceProto = viewerParamsProvider.readDeviceParams();
        vrUiLayer.setViewerName(deviceProto != null ? deviceProto.getModel() : null);
    }

    private static final String TAG = com/google/vr/sdk/widgets/common/VrWidgetView.getSimpleName();
    private static final boolean DEBUG = false;
    private static final int DEFAULT_DISPLAY_MODE = 1;
    private static final Uri INFO_BUTTON_URL = Uri.parse("https://g.co/vr/view");
    private static final String STATE_KEY_SUPER_CLASS = "superClassState";
    private static final String STATE_KEY_ORIENTATION_HELPER = "orientationHelperState";
    private static final String STATE_KEY_WIDGET_RENDERER = "widgetRendererState";
    private static final String STATE_KEY_DISPLAY_MODE = "displayMode";
    private static final float METERS_PER_INCH = 0.0254F;
    private VrWidgetRenderer renderer;
    private VrEventListener eventListener;
    private DisplayMetrics displayMetrics;
    private Activity activity;
    private boolean isPaused;
    private VrParamsProvider viewerParamsProvider;
    private ViewGroup innerWidgetView;
    private GLSurfaceView renderingView;
    private View uiView;
    private ImageButton enterStereoModeButton;
    private ImageButton enterFullscreenButton;
    private ImageButton fullscreenBackButton;
    private ImageButton infoButton;
    private boolean isStereoModeButtonEnabled;
    private boolean isFullscreenButtonEnabled;
    private boolean isTransitionViewEnabled;
    private boolean isTouchTrackingEnabled;
    private boolean isInfoButtonEnabled;
    public FullScreenDialog fullScreenDialog;
    private TrackingSensorsHelper sensorsHelper;
    private TouchTracker touchTracker;
    private ScreenOnFlagHelper screenOnFlagHelper;
    private OrientationHelper orientationHelper;
    private ViewRotator viewRotator;
    private int displayMode;
    UiLayer vrUiLayer;





}
