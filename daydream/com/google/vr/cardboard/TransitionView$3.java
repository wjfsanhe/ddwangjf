// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TransitionView.java

package com.google.vr.cardboard;

import android.content.Context;
import android.view.OrientationEventListener;

// Referenced classes of package com.google.vr.cardboard:
//            TransitionView

class it> extends OrientationEventListener
{

    public void onOrientationChanged(int i)
    {
        TransitionView.access$202(TransitionView.this, i);
        if(!TransitionView.access$300(TransitionView.this))
        {
            TransitionView.access$400(TransitionView.this);
            return;
        }
        if(TransitionView.access$500(i))
        {
            TransitionView.access$100(TransitionView.this, false);
            return;
        } else
        {
            boolean _tmp = TransitionView.access$600(i);
            return;
        }
    }

    final TransitionView this$0;

    (Context context)
    {
        this$0 = TransitionView.this;
        super(context);
    }
}
