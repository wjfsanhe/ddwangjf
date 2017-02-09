// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FullscreenMode.java

package com.google.vr.cardboard;

import android.os.Handler;
import android.view.View;

// Referenced classes of package com.google.vr.cardboard:
//            FullscreenMode

class this._cls1
    implements Runnable
{

    public void run()
    {
        FullscreenMode.access$000(_fld0);
    }

    final is._cls0 this$1;

    l.handler()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/google/vr/cardboard/FullscreenMode$1

/* anonymous class */
    class FullscreenMode._cls1
        implements android.view.View.OnSystemUiVisibilityChangeListener
    {

        public void onSystemUiVisibilityChange(int i)
        {
            if((i & 2) == 0)
                handler.postDelayed(new FullscreenMode._cls1._cls1(), 2000L);
        }

        final Handler val$handler;
        final FullscreenMode this$0;

            
            {
                this$0 = final_fullscreenmode;
                handler = Handler.this;
                super();
            }
    }

}
