// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CardboardViewNativeImpl.java

package com.google.vr.sdk.base;

import com.google.vr.cardboard.ThreadUtils;
import com.google.vr.cardboard.TransitionView;

// Referenced classes of package com.google.vr.sdk.base:
//            CardboardViewNativeImpl

class this._cls0
    implements com.google.vr.cardboard.istener
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

    Listener()
    {
        this.this$0 = CardboardViewNativeImpl.this;
        super();
    }
}
