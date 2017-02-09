// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CardboardViewNativeImpl.java

package com.google.vr.sdk.base;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;

// Referenced classes of package com.google.vr.sdk.base:
//            CardboardViewNativeImpl, ScreenParams

class val.enabled
    implements Runnable
{

    public void run()
    {
        if(cess._mth2600(this._cls1.this) == val$enabled)
            return;
        cess._mth2602(this._cls1.this, val$enabled);
        CardboardViewNativeImpl.access$2700(_fld0, CardboardViewNativeImpl.access$100(_fld0), val$enabled);
        if(!EGL10.EGL_NO_SURFACE.equals(((EGL10)EGLContext.getEGL()).eglGetCurrentSurface(12377)))
            SurfaceChanged((GL10)null, cess._mth2800(this._cls1.this).getWidth(), cess._mth2800(this._cls1.this).getHeight());
    }

    final boolean val$enabled;
    final this._cls1 this$1;

    ()
    {
        this.this$1 = this$1;
        val$enabled = Z.this;
        super();
    }
}
