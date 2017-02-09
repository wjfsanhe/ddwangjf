// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrWidgetView.java

package com.google.vr.sdk.widgets.common;

import android.opengl.GLSurfaceView;

// Referenced classes of package com.google.vr.sdk.widgets.common:
//            VrWidgetView, VrWidgetRenderer

class this._cls0
    implements r.GLThreadScheduler
{

    public void queueGlThreadEvent(Runnable runnable)
    {
        VrWidgetView.access$200(VrWidgetView.this).queueEvent(runnable);
    }

    final VrWidgetView this$0;

    r()
    {
        this.this$0 = VrWidgetView.this;
        super();
    }
}
