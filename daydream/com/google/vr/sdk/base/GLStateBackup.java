// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GLStateBackup.java

package com.google.vr.sdk.base;

import android.opengl.GLES20;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Iterator;

class GLStateBackup
{
    private class VertexAttributeState
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

        VertexAttributeState(int attributeId)
        {
            enabled = IntBuffer.allocate(1);
            this.attributeId = attributeId;
        }
    }


    GLStateBackup()
    {
        viewport = IntBuffer.allocate(4);
        texture2dId = IntBuffer.allocate(1);
        textureUnit = IntBuffer.allocate(1);
        scissorBox = IntBuffer.allocate(4);
        shaderProgram = IntBuffer.allocate(1);
        arrayBufferBinding = IntBuffer.allocate(1);
        elementArrayBufferBinding = IntBuffer.allocate(1);
        clearColor = FloatBuffer.allocate(4);
        vertexAttributes = new ArrayList();
    }

    void addTrackedVertexAttribute(int attributeId)
    {
        vertexAttributes.add(new VertexAttributeState(attributeId));
    }

    void clearTrackedVertexAttributes()
    {
        vertexAttributes.clear();
    }

    void readFromGL()
    {
        GLES20.glGetIntegerv(2978, viewport);
        cullFaceEnabled = GLES20.glIsEnabled(2884);
        scissorTestEnabled = GLES20.glIsEnabled(3089);
        depthTestEnabled = GLES20.glIsEnabled(2929);
        GLES20.glGetFloatv(3106, clearColor);
        GLES20.glGetIntegerv(35725, shaderProgram);
        GLES20.glGetIntegerv(3088, scissorBox);
        GLES20.glGetIntegerv(34016, textureUnit);
        GLES20.glGetIntegerv(32873, texture2dId);
        GLES20.glGetIntegerv(34964, arrayBufferBinding);
        GLES20.glGetIntegerv(34965, elementArrayBufferBinding);
        VertexAttributeState vas;
        for(Iterator iterator = vertexAttributes.iterator(); iterator.hasNext(); vas.readFromGL())
            vas = (VertexAttributeState)iterator.next();

    }

    void writeToGL()
    {
        VertexAttributeState vas;
        for(Iterator iterator = vertexAttributes.iterator(); iterator.hasNext(); vas.writeToGL())
            vas = (VertexAttributeState)iterator.next();

        GLES20.glBindBuffer(34962, arrayBufferBinding.array()[0]);
        GLES20.glBindBuffer(34963, elementArrayBufferBinding.array()[0]);
        GLES20.glBindTexture(3553, texture2dId.array()[0]);
        GLES20.glActiveTexture(textureUnit.array()[0]);
        GLES20.glScissor(scissorBox.array()[0], scissorBox.array()[1], scissorBox.array()[2], scissorBox.array()[3]);
        GLES20.glUseProgram(shaderProgram.array()[0]);
        GLES20.glClearColor(clearColor.array()[0], clearColor.array()[1], clearColor.array()[2], clearColor.array()[3]);
        if(cullFaceEnabled)
            GLES20.glEnable(2884);
        else
            GLES20.glDisable(2884);
        if(scissorTestEnabled)
            GLES20.glEnable(3089);
        else
            GLES20.glDisable(3089);
        if(depthTestEnabled)
            GLES20.glEnable(2929);
        else
            GLES20.glDisable(2929);
        GLES20.glViewport(viewport.array()[0], viewport.array()[1], viewport.array()[2], viewport.array()[3]);
    }

    private boolean cullFaceEnabled;
    private boolean scissorTestEnabled;
    private boolean depthTestEnabled;
    private IntBuffer viewport;
    private IntBuffer texture2dId;
    private IntBuffer textureUnit;
    private IntBuffer scissorBox;
    private IntBuffer shaderProgram;
    private IntBuffer arrayBufferBinding;
    private IntBuffer elementArrayBufferBinding;
    private FloatBuffer clearColor;
    private ArrayList vertexAttributes;
}
