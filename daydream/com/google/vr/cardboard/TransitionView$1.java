// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TransitionView.java

package com.google.vr.cardboard;

import android.view.View;

// Referenced classes of package com.google.vr.cardboard:
//            TransitionView, UiUtils

class this._cls0
    implements android.view.ner
{

    public void onClick(View view)
    {
        UiUtils.launchOrInstallCardboard(getContext());
        if(TransitionView.access$000(TransitionView.this) != null)
            TransitionView.access$000(TransitionView.this).onSwitchViewer();
    }

    final TransitionView this$0;

    ansitionListener()
    {
        this$0 = TransitionView.this;
        super();
    }
}
