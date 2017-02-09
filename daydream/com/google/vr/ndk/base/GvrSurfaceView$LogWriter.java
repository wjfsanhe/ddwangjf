// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GvrSurfaceView.java

package com.google.vr.ndk.base;

import android.util.Log;
import java.io.Writer;

// Referenced classes of package com.google.vr.ndk.base:
//            GvrSurfaceView

static class mBuilder extends Writer
{

    public void close()
    {
        flushBuilder();
    }

    public void flush()
    {
        flushBuilder();
    }

    public void write(char ac[], int i, int j)
    {
        for(int k = 0; k < j; k++)
        {
            char c;
            if((c = ac[i + k]) == '\n')
                flushBuilder();
            else
                mBuilder.append(c);
        }

    }

    private void flushBuilder()
    {
        if(mBuilder.length() > 0)
        {
            Log.v("GvrSurfaceView", mBuilder.toString());
            mBuilder.delete(0, mBuilder.length());
        }
    }

    private StringBuilder mBuilder;

    ()
    {
        mBuilder = new StringBuilder();
    }
}
