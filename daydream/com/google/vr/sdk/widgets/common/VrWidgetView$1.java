// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrWidgetView.java

package com.google.vr.sdk.widgets.common;

import android.content.DialogInterface;

// Referenced classes of package com.google.vr.sdk.widgets.common:
//            VrWidgetView

class this._cls0
    implements android.content..OnCancelListener
{

    public void onCancel(DialogInterface dialog)
    {
        setDisplayMode(1);
    }

    final VrWidgetView this$0;

    splayMode()
    {
        this.this$0 = VrWidgetView.this;
        super();
    }
}
