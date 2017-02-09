// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ProjectionScene.java

package com.google.vr.libraries.video;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.vr.libraries.video:
//            ProjectionScene

public static class subMeshes
{

    public void addSubMesh(sh subMesh)
    {
        subMeshes.add(subMesh);
    }

    public int getSubMeshCount()
    {
        return subMeshes.size();
    }

    public sh getSubMesh(int index)
    {
        return (sh)subMeshes.get(index);
    }

    private List subMeshes;

    public sh()
    {
        subMeshes = new ArrayList();
    }
}
