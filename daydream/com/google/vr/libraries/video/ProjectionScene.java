// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ProjectionScene.java

package com.google.vr.libraries.video;

import java.util.ArrayList;
import java.util.List;

public class ProjectionScene
{
    public static class Mesh
    {

        public void addSubMesh(SubMesh subMesh)
        {
            subMeshes.add(subMesh);
        }

        public int getSubMeshCount()
        {
            return subMeshes.size();
        }

        public SubMesh getSubMesh(int index)
        {
            return (SubMesh)subMeshes.get(index);
        }

        private List subMeshes;

        public Mesh()
        {
            subMeshes = new ArrayList();
        }
    }

    public static class SubMesh
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

        public SubMesh(float vertices[], float textureCoords[], int mode)
        {
            this.vertices = vertices;
            this.textureCoords = textureCoords;
            this.mode = mode;
        }
    }


    public ProjectionScene(int crc)
    {
        this.crc = crc;
        meshes = new Mesh[2];
    }

    public Mesh getLeftMesh()
    {
        return meshes[0];
    }

    public void setLeftMesh(Mesh mesh)
    {
        meshes[0] = mesh;
    }

    public Mesh getRightMesh()
    {
        return meshes[1];
    }

    public void setRightMesh(Mesh mesh)
    {
        meshes[1] = mesh;
    }

    public int getCrc()
    {
        return crc;
    }

    public int getStereoMode()
    {
        return stereoMode;
    }

    public void setStereoMode(int stereoMode)
    {
        this.stereoMode = stereoMode;
    }

    private int crc;
    private Mesh meshes[];
    private int stereoMode;
}
