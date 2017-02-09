// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrWidgetView.java

package com.google.vr.sdk.widgets.common;


// Referenced classes of package com.google.vr.sdk.widgets.common:
//            VrWidgetView, TouchTracker, VrWidgetRenderer, VrEventListener

class this._cls0
    implements uchEnabledVrView
{

    public void onPanningEvent(float deltaPixelX, float deltaPixelY)
    {
        VrWidgetView.access$000(VrWidgetView.this).onPanningEvent(deltaPixelX, deltaPixelY);
    }

    public VrEventListener getEventListener()
    {
        return VrWidgetView.access$100(VrWidgetView.this);
    }

    final VrWidgetView this$0;

    ()
    {
        this.this$0 = VrWidgetView.this;
        super();
    }
}
