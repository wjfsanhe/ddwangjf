// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GLStateBackup.java

package com.google.vr.sdk.base;

import android.opengl.GLES20;
import java.nio.IntBuffer;

// Referenced classes of package com.google.vr.sdk.base:
//            GLStateBackup

private class attributeId
{

    void readFromGL()
    {
        GLES20.glGetVertexAttribiv(attributeId, 34338, enabled);
    }

    void writeToGL()
    {
        if(enabled.array()[0] == 0)
            GLES20.glDisableVertexAttribArray(attributeId);
        else
            GLES20.glEnableVertexAttribArray(attributeId);
    }

    private int attributeId;
    private IntBuffer enabled;

    (GLStateBackup glstatebackup, int attributeId)
    {
        enabled = IntBuffer.allocate(1);
        this.attributeId = attributeId;
    }
}
