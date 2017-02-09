// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrWidgetView.java

package com.google.vr.sdk.widgets.common;

import android.app.Activity;
import android.view.View;

// Referenced classes of package com.google.vr.sdk.widgets.common:
//            VrWidgetView

class this._cls0
    implements android.view.tener
{

    public void onClick(View v)
    {
        VrWidgetView.access$300(VrWidgetView.this).startActivity(VrWidgetView.getInfoButtonIntent());
    }

    final VrWidgetView this$0;

    ()
    {
        this.this$0 = VrWidgetView.this;
        super();
    }
}
