// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   NfcSensor.java

package com.google.vr.sdk.base.sensors;

import com.google.vr.sdk.base.GvrViewerParams;

// Referenced classes of package com.google.vr.sdk.base.sensors:
//            NfcSensor

class val.viewerParams
    implements Runnable
{

    public void run()
    {
        cess._mth500(this._cls0.this).onInsertedIntoGvrViewer(val$viewerParams);
    }

    final GvrViewerParams val$viewerParams;
    final val.viewerParams this$0;

    tener()
    {
        this.this$0 = this$0;
        val$viewerParams = GvrViewerParams.this;
        super();
    }
}
