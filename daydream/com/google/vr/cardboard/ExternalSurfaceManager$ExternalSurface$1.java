// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ExternalSurfaceManager.java

package com.google.vr.cardboard;

import android.graphics.SurfaceTexture;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.google.vr.cardboard:
//            ExternalSurfaceManager

class this._cls0
    implements android.graphics.face._cls1
{

    public void onFrameAvailable(SurfaceTexture surfacetexture)
    {
        cess._mth200(this._cls0.this).set(true);
        if(cess._mth300(this._cls0.this) != null)
            cess._mth300(this._cls0.this).postOnFrameAvailable();
    }

    final lback.postOnFrameAvailable this$0;

    lback()
    {
        this$0 = this._cls0.this;
        super();
    }
}
