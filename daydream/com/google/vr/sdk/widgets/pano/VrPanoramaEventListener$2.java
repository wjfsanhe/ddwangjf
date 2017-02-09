// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrPanoramaEventListener.java

package com.google.vr.sdk.widgets.pano;


// Referenced classes of package com.google.vr.sdk.widgets.pano:
//            VrPanoramaEventListener

class val.errorMessage
    implements Runnable
{

    public void run()
    {
        onLoadError(val$errorMessage);
    }

    final String val$errorMessage;
    final VrPanoramaEventListener this$0;

    ()
    {
        this.this$0 = this$0;
        val$errorMessage = String.this;
        super();
    }
}
