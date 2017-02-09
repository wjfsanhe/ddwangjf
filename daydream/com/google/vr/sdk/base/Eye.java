// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Eye.java

package com.google.vr.sdk.base;


// Referenced classes of package com.google.vr.sdk.base:
//            Viewport, FieldOfView

public class Eye
{
    public static abstract class Type
    {

        public static final int MONOCULAR = 0;
        public static final int LEFT = 1;
        public static final int RIGHT = 2;

        public Type()
        {
        }
    }


    public Eye(int type)
    {
        this.type = type;
        projectionChanged = true;
    }

    public int getType()
    {
        return type;
    }

    public float[] getEyeView()
    {
        return eyeView;
    }

    public float[] getPerspective(float zNear, float zFar)
    {
        if(!projectionChanged && lastZNear == zNear && lastZFar == zFar)
            return perspective;
        if(perspective == null)
            perspective = new float[16];
        getFov().toPerspectiveMatrix(zNear, zFar, perspective, 0);
        lastZNear = zNear;
        lastZFar = zFar;
        projectionChanged = false;
        return perspective;
    }

    public Viewport getViewport()
    {
        return viewport;
    }

    public FieldOfView getFov()
    {
        return fov;
    }

    public void setProjectionChanged()
    {
        projectionChanged = true;
    }

    public boolean getProjectionChanged()
    {
        return projectionChanged;
    }

    private void setValues(int viewportX, int viewportY, int viewportWidth, int viewportHeight, float fovLeft, float fovRight, float fovBottom, 
            float fovTop)
    {
        viewport.setViewport(viewportX, viewportY, viewportWidth, viewportHeight);
        fov.setAngles(fovLeft, fovRight, fovBottom, fovTop);
        projectionChanged = true;
    }

    private final int type;
    private final float eyeView[] = new float[16];
    private final Viewport viewport = new Viewport();
    private final FieldOfView fov = new FieldOfView();
    private volatile boolean projectionChanged;
    private float perspective[];
    private float lastZNear;
    private float lastZFar;
}
