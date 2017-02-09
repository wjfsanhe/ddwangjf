// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ProjectionScene.java

package com.google.vr.libraries.video;


// Referenced classes of package com.google.vr.libraries.video:
//            ProjectionScene

public static class mode
{

    public int getMode()
    {
        return mode;
    }

    public float[] getVertices()
    {
        return vertices;
    }

    public float[] getTextureCoords()
    {
        return textureCoords;
    }

    private int mode;
    private float vertices[];
    private float textureCoords[];

    public (float vertices[], float textureCoords[], int mode)
    {
        this.vertices = vertices;
        this.textureCoords = textureCoords;
        this.mode = mode;
    }
}
