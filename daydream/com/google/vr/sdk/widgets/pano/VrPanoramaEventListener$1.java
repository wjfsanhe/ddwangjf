// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrPanoramaEventListener.java

package com.google.vr.sdk.widgets.pano;


// Referenced classes of package com.google.vr.sdk.widgets.pano:
//            VrPanoramaEventListener

class this._cls0
    implements Runnable
{

    public void run()
    {
        onLoadSuccess();
        VrPanoramaEventListener.isLoadSuccessful = true;
    }

    final VrPanoramaEventListener this$0;

    ()
    {
        this.this$0 = VrPanoramaEventListener.this;
        super();
    }
}
