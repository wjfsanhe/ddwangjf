// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TransitionView.java

package com.google.vr.cardboard;

import android.view.ViewGroup;
import android.view.animation.Animation;

// Referenced classes of package com.google.vr.cardboard:
//            TransitionView

class this._cls0
    implements android.view.animation.onListener
{

    public void onAnimationStart(Animation animation)
    {
    }

    public void onAnimationEnd(Animation animation)
    {
        setVisibility(8);
        ((ViewGroup)getParent()).removeView(TransitionView.this);
        if(TransitionView.access$000(TransitionView.this) != null)
            TransitionView.access$000(TransitionView.this).onTransitionDone();
    }

