// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CardboardViewNativeImpl.java

package com.google.vr.sdk.base;

import android.view.Display;
import com.google.vr.cardboard.ThreadUtils;
import com.google.vr.cardboard.TransitionView;
import com.google.vr.ndk.base.GvrLayout;

// Referenced classes of package com.google.vr.sdk.base:
//            CardboardViewNativeImpl, ScreenParams

private class this._cls0
    implements com.google.vr.ndk.base.this._cls0
{

    public void onPresentationStarted(Display display)
    {
        originalParams = getScreenParams();
        ScreenParams newParams = new ScreenParams(display);
        updateScreenParams(newParams);
        CardboardViewNativeImpl.access$1400(CardboardViewNativeImpl.this);
    }

    public void onPresentationStopped()
    {
        if(originalParams != null)
            updateScreenParams(originalParams);
    }

    ScreenParams originalParams;
    final CardboardViewNativeImpl this$0;

    private I()
    {
        this$0 = CardboardViewNativeImpl.this;
        super();
    }


    // Unreferenced inner class com/google/vr/sdk/base/CardboardViewNativeImpl$1

/* anonymous class */
    class CardboardViewNativeImpl._cls1
        implements com.google.vr.cardboard.TransitionView.TransitionListener
    {

        public void onTransitionDone()
        {
            if(CardboardViewNativeImpl.access$100(CardboardViewNativeImpl.this) != 0L)
                CardboardViewNativeImpl.access$200(CardboardViewNativeImpl.this, CardboardViewNativeImpl.access$100(CardboardViewNativeImpl.this), 2002);
            if(CardboardViewNativeImpl.access$300(CardboardViewNativeImpl.this) != null)
                ThreadUtils.runOnUiThread(CardboardViewNativeImpl.access$300(CardboardViewNativeImpl.this));
        }

        public void onSwitchViewer()
        {
            if(CardboardViewNativeImpl.access$100(CardboardViewNativeImpl.this) != 0L)
                CardboardViewNativeImpl.access$200(CardboardViewNativeImpl.this, CardboardViewNativeImpl.access$100(CardboardViewNativeImpl.this), 2003);
        }

        final CardboardViewNativeImpl this$0;

            
            {
                this.this$0 = CardboardViewNativeImpl.this;
                super();
            }
    }

}
