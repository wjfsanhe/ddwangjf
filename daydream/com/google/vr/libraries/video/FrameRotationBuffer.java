// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FrameRotationBuffer.java

package com.google.vr.libraries.video;

import android.opengl.Matrix;
import java.util.*;

public class FrameRotationBuffer
{

    public FrameRotationBuffer()
    {
        Matrix.setIdentityM(transform, 0);
    }

    public synchronized void setRotation(long timestampUs, float angleAxis[])
    {
        Vector vec = new Vector();
        for(int i = 0; i < 3; i++)
            vec.add(Float.valueOf(angleAxis[i]));

        rotations.put(Long.valueOf(timestampUs), vec);
    }

    public synchronized float[] getTransform(long presentationTimeUs)
    {
        java.util.Map.Entry floorRotation = rotations.floorEntry(Long.valueOf(presentationTimeUs));
        if(floorRotation == null)
        {
            return transform;
        } else
        {
            rotations.headMap((Long)floorRotation.getKey()).clear();
            Vector vec = (Vector)floorRotation.getValue();
            convertAngleAxisToTransformMatrix(((Float)vec.get(0)).floatValue(), ((Float)vec.get(1)).floatValue(), ((Float)vec.get(2)).floatValue(), transform);
            return transform;
        }
    }

    private static void convertAngleAxisToTransformMatrix(float x, float y, float z, float transform[])
    {
        float angle = Matrix.length(x, y, z);
        if(angle != 0.0F)
        {
            float degrees = (float)Math.toDegrees(angle);
            Matrix.setRotateM(transform, 0, degrees, -x / angle, -y / angle, z / angle);
        } else
        {
            Matrix.setIdentityM(transform, 0);
        }
    }

    private static final String TAG = "FrameRotationBuffer";
    private final float transform[] = new float[16];
    private final NavigableMap rotations = new TreeMap();
}
