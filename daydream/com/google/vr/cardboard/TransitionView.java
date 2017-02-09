// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TransitionView.java

package com.google.vr.cardboard;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.*;
import android.view.animation.*;
import android.widget.*;

// Referenced classes of package com.google.vr.cardboard:
//            R, UiUtils

public class TransitionView extends FrameLayout
    implements android.view.View.OnTouchListener
{
    public static interface TransitionListener
    {

        public abstract void onTransitionDone();

        public abstract void onSwitchViewer();
    }


    public TransitionView(Context context)
    {
        super(context);
        orientation = -1;
        setOnTouchListener(this);
        setBackground(new ColorDrawable(0xff455a64));
        inflateContentView(R.layout.transition_view);
        super.setVisibility(8);
    }

    private void inflateContentView(int i)
    {
        removeAllViews();
        LayoutInflater.from(getContext()).inflate(i, this, true);
        View view;
        (view = findViewById(R.id.transition_switch_action)).setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view1)
            {
                UiUtils.launchOrInstallCardboard(getContext());
                if(transitionListener != null)
                    transitionListener.onSwitchViewer();
            }

            final TransitionView this$0;

            
            {
                this$0 = TransitionView.this;
                super();
            }
        });
        ImageView imageview;
        (imageview = (ImageView)findViewById(R.id.transition_icon)).setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view1)
            {
                fadeOutAndRemove(false);
            }

            final TransitionView this$0;

            
            {
                this$0 = TransitionView.this;
                super();
            }
        });
        updateBackButtonVisibility();
        if(getResources().getConfiguration().orientation == 2)
            findViewById(R.id.transition_bottom_frame).setVisibility(8);
    }

    public void setViewerName(String s)
    {
        TextView textview = (TextView)findViewById(R.id.transition_text);
        if(s != null)
        {
            textview.setText(getContext().getString(R.string.place_your_viewer_into_viewer_format, new Object[] {
                s
            }));
            return;
        } else
        {
            textview.setText(getContext().getString(R.string.place_your_phone_into_cardboard));
            return;
        }
    }

    public void setBackButtonListener(Runnable runnable)
    {
        backButtonRunnable = runnable;
        updateBackButtonVisibility();
    }

    public void setVisibility(int i)
    {
        int j = getVisibility();
        super.setVisibility(i);
        if(j != i)
        {
            if(i == 0)
            {
                startOrientationMonitor();
                return;
            }
            stopOrientationMonitor();
        }
    }

    public void setTransitionListener(TransitionListener transitionlistener)
    {
        transitionListener = transitionlistener;
    }

    private void startOrientationMonitor()
    {
        if(orientationEventListener != null)
        {
            return;
        } else
        {
            orientationEventListener = new OrientationEventListener(getContext()) {

                public void onOrientationChanged(int i)
                {
                    orientation = i;
                    if(!rotationChecked)
                    {
                        rotateViewIfNeeded();
                        return;
                    }
                    if(TransitionView.isLandscapeLeft(i))
                    {
                        fadeOutAndRemove(false);
                        return;
                    } else
                    {
                        TransitionView.isLandscapeRight(i);
                        return;
                    }
                }

                final TransitionView this$0;

            
            {
                this$0 = TransitionView.this;
                super(context);
            }
            };
            orientationEventListener.enable();
            return;
        }
    }

    private void stopOrientationMonitor()
    {
        if(orientationEventListener == null)
        {
            return;
        } else
        {
            orientation = -1;
            orientationEventListener.disable();
            orientationEventListener = null;
            return;
        }
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if(orientationEventListener != null)
            orientationEventListener.enable();
        rotateViewIfNeeded();
    }

    protected void onDetachedFromWindow()
    {
        if(orientationEventListener != null)
        {
            orientation = -1;
            orientationEventListener.disable();
        }
        super.onDetachedFromWindow();
    }

    private void rotateViewIfNeeded()
    {
        if(getWidth() <= 0 || getHeight() <= 0 || orientation == -1 || orientationEventListener == null || rotationChecked)
            return;
        boolean flag = getWidth() < getHeight();
        boolean flag1 = isPortrait(orientation);
        if(flag != flag1)
        {
            View view;
            int i = (view = findViewById(R.id.transition_frame)).getWidth();
            int j = view.getHeight();
            if(android.os.Build.VERSION.SDK_INT >= 17 && getLayoutDirection() == 1)
            {
                view.setPivotX((float)j - view.getPivotX());
                view.setPivotY((float)i - view.getPivotY());
            }
            if(flag)
                view.setRotation(90F);
            else
                view.setRotation(-90F);
            view.setTranslationX((i - j) / 2);
            view.setTranslationY((j - i) / 2);
            android.view.ViewGroup.LayoutParams layoutparams;
            (layoutparams = view.getLayoutParams()).height = i;
            layoutparams.width = j;
            view.requestLayout();
        }
        if(!flag1)
            findViewById(R.id.transition_bottom_frame).setVisibility(8);
        else
            findViewById(R.id.transition_bottom_frame).setVisibility(0);
        rotationChecked = true;
        if(isLandscapeLeft(orientation))
            fadeOutAndRemove(true);
    }

    private void fadeOutAndRemove(boolean flag)
    {
        stopOrientationMonitor();
        Animation animation;
        if((animation = getAnimation()) != null)
        {
            if(flag || animation.getStartOffset() == 0L)
                return;
            animation.setAnimationListener(null);
            clearAnimation();
        }
        AlphaAnimation alphaanimation;
        (alphaanimation = new AlphaAnimation(1.0F, 0.0F)).setInterpolator(new AccelerateInterpolator());
        alphaanimation.setRepeatCount(0);
        alphaanimation.setDuration(500L);
        if(flag)
            alphaanimation.setStartOffset(2000L);
        alphaanimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            public void onAnimationStart(Animation animation1)
            {
            }

            public void onAnimationEnd(Animation animation1)
            {
                setVisibility(8);
                ((ViewGroup)getParent()).removeView(TransitionView.this);
                if(transitionListener != null)
                    transitionListener.onTransitionDone();
            }

            public void onAnimationRepeat(Animation animation1)
            {
            }

            final TransitionView this$0;

            
            {
                this$0 = TransitionView.this;
                super();
            }
        });
        startAnimation(alphaanimation);
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        return true;
    }

    private void updateBackButtonVisibility()
    {
        ViewGroup viewgroup = (ViewGroup)findViewById(R.id.transition_frame);
        backButton = (ImageButton)viewgroup.findViewById(R.id.back_button);
        if(backButtonRunnable == null)
        {
            backButton.setVisibility(8);
            backButton.setTag(null);
            backButton.setOnClickListener(null);
            return;
        } else
        {
            backButton.setTag(backButtonRunnable);
            backButton.setVisibility(0);
            backButton.setOnClickListener(new android.view.View.OnClickListener() {

                public void onClick(View view)
                {
                    backButtonRunnable.run();
                }

                final TransitionView this$0;

            
            {
                this$0 = TransitionView.this;
                super();
            }
            });
            return;
        }
    }

    private static boolean isPortrait(int i)
    {
        return Math.abs(i - 180) > 135;
    }

    private static boolean isLandscapeLeft(int i)
    {
        return Math.abs(i - 270) < 5;
    }

    private static boolean isLandscapeRight(int i)
    {
        return Math.abs(i - 90) < 5;
    }

    public static final int TRANSITION_BACKGROUND_COLOR = 0xff455a64;
    public static final int ALREADY_LANDSCAPE_LEFT_TRANSITION_DELAY_MS = 2000;
    public static final int TRANSITION_ANIMATION_DURATION_MS = 500;
    private static final int VIEW_CORRECTION_ROTATION_DEGREES = 90;
    private static final int PORTRAIT_TOLERANCE_DEGREES = 45;
    private static final int LANDSCAPE_TOLERANCE_DEGREES = 5;
    private int orientation;
    private OrientationEventListener orientationEventListener;
    private boolean rotationChecked;
    private TransitionListener transitionListener;
    private ImageButton backButton;
    private Runnable backButtonRunnable;








}
