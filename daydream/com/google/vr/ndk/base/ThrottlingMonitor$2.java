// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ThrottlingMonitor.java

package com.google.vr.ndk.base;


// Referenced classes of package com.google.vr.ndk.base:
//            ThrottlingMonitor

class val.callback
    implements Runnable
{

    public void run()
    {
        val$callback.onInitialized();
    }

    final tupCallback val$callback;

    tupCallback(tupCallback tupcallback)
    {
        val$callback = tupcallback;
        super();
    }
}
