// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FullscreenMode.java

package com.google.vr.cardboard;

import android.os.Handler;
import android.view.View;

// Referenced classes of package com.google.vr.cardboard:
//            FullscreenMode

class val.handler
    implements android.view.sibilityChangeListener
{

    public void onSystemUiVisibilityChange(int i)
    {
        if((i & 2) == 0)
            val$handler.postDelayed(new Runnable() {

                public void run()
                {
                    FullscreenMode.access$000(this$0);
                }

                final FullscreenMode._cls1 this$1;

            
            {
                this$1 = FullscreenMode._cls1.this;
                super();
            }
            }, 2000L);
    }

    final Handler val$handler;
    final FullscreenMode this$0;

    _cls1.this._cls1()
    {
        this$0 = final_fullscreenmode;
        val$handler = Handler.this;
        super();
    }
}
