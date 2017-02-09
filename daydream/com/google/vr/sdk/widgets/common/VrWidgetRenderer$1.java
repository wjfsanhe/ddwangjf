// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrWidgetRenderer.java

package com.google.vr.sdk.widgets.common;


// Referenced classes of package com.google.vr.sdk.widgets.common:
//            VrWidgetRenderer

class iRequest
    implements Runnable
{

    public void run()
    {
        executeApiRequestOnGlThread(val$apiRequest);
    }

    final iRequest val$apiRequest;
    final VrWidgetRenderer this$0;

    iRequest()
    {
        this.this$0 = this$0;
        val$apiRequest = iRequest.this;
        super();
    }
}
