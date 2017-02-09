// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ExternalSurfaceManager.java

package com.google.vr.cardboard;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import com.google.vr.ndk.base.GvrApi;
import com.google.vr.ndk.base.GvrLayout;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class ExternalSurfaceManager
    implements com.google.vr.ndk.base.GvrLayout.ExternalSurfaceManager
{
    private static class ExternalSurface
    {

        void maybeAttachToCurrentGLContext()
        {
            if(isAttached)
                return;
            GLES20.glGenTextures(1, glTextureId, 0);
            if(surfaceTexture == null)
            {
                surfaceTexture = new SurfaceTexture(glTextureId[0]);
                surfaceTexture.setOnFrameAvailableListener(new android.graphics.SurfaceTexture.OnFrameAvailableListener() {

                    public void onFrameAvailable(SurfaceTexture surfacetexture)
                    {
                        hasNewFrame.set(true);
                        if(callback != null)
                            callback.postOnFrameAvailable();
                    }

                    final ExternalSurface this$0;

                
                {
                    this$0 = ExternalSurface.this;
                    super();
                }
                });
                surface = new Surface(surfaceTexture);
            } else
            {
                surfaceTexture.attachToGLContext(glTextureId[0]);
            }
            isAttached = true;
            if(callback != null)
                callback.postOnAvailable(surface);
        }

        void maybeDetachFromCurrentGLContext()
        {
            if(!isAttached)
            {
                return;
            } else
            {
                surfaceTexture.detachFromGLContext();
                isAttached = false;
                return;
            }
        }

        void updateSurfaceTexture(GvrApi gvrapi)
        {
            if(!isAttached)
                return;
            boolean flag;
            if(flag = hasNewFrame.getAndSet(false))
            {
                surfaceTexture.updateTexImage();
                surfaceTexture.getTransformMatrix(transformMatrix);
                long l = surfaceTexture.getTimestamp();
                gvrapi.updateSurfaceReprojectionThread(id, glTextureId[0], l, transformMatrix);
            }
        }

        Surface getSurface()
        {
            return surface;
        }

        void shutdown(GvrApi gvrapi)
        {
            if(released.getAndSet(true))
                return;
            if(surfaceTexture != null)
            {
                surfaceTexture.release();
                surfaceTexture = null;
                surface = null;
            }
            gvrapi.updateSurfaceReprojectionThread(id, 0, 0L, transformMatrix);
        }

        private final int id;
        private final ExternalSurfaceCallback callback;
        private final float transformMatrix[] = new float[16];
        private final AtomicBoolean hasNewFrame = new AtomicBoolean(false);
        private final AtomicBoolean released = new AtomicBoolean(false);
        private final int glTextureId[] = new int[1];
        private volatile SurfaceTexture surfaceTexture;
        private volatile Surface surface;
        private boolean isAttached;




        ExternalSurface(int i, ExternalSurfaceCallback externalsurfacecallback)
        {
            isAttached = false;
            id = i;
            callback = externalsurfacecallback;
            Matrix.setIdentityM(transformMatrix, 0);
        }
    }

    private static class ExternalSurfaceCallback
    {

        public void postOnAvailable(final Surface surface)
        {
            handler.post(new Runnable() {

                public void run()
                {
                    listener.onSurfaceAvailable(surface);
                }

                final Surface val$surface;
                final ExternalSurfaceCallback this$0;

                
                {
                    this$0 = ExternalSurfaceCallback.this;
                    surface = surface1;
                    super();
                }
            });
        }

        public void postOnFrameAvailable()
        {
            handler.post(frameAvailableRunnable);
        }

        private final com.google.vr.ndk.base.GvrLayout.ExternalSurfaceListener listener;
        private final Handler handler;
        private final Runnable frameAvailableRunnable = new Runnable() {

            public void run()
            {
                listener.onFrameAvailable();
            }

            final ExternalSurfaceCallback this$0;

                
                {
                    this$0 = ExternalSurfaceCallback.this;
                    super();
                }
        };


        public ExternalSurfaceCallback(com.google.vr.ndk.base.GvrLayout.ExternalSurfaceListener externalsurfacelistener, Handler handler1)
        {
            listener = externalsurfacelistener;
            handler = handler1;
        }
    }

    private static class ExternalSurfaceData
    {

        final HashMap surfaces;
        final HashMap surfacesToRelease;

        ExternalSurfaceData()
        {
            surfaces = new HashMap();
            surfacesToRelease = new HashMap();
        }

        ExternalSurfaceData(ExternalSurfaceData externalsurfacedata)
        {
            surfaces = new HashMap(externalsurfacedata.surfaces);
            surfacesToRelease = new HashMap(externalsurfacedata.surfacesToRelease);
            Iterator iterator = surfacesToRelease.entrySet().iterator();
            do
            {
                if(!iterator.hasNext())
                    break;
                java.util.Map.Entry entry;
                if(((ExternalSurface)(entry = (java.util.Map.Entry)iterator.next()).getValue()).released.get())
                    iterator.remove();
            } while(true);
        }
    }


    public ExternalSurfaceManager(GvrApi gvrapi)
    {
        surfaceData = new ExternalSurfaceData();
        nextID = 1;
        gvrApi = gvrapi;
    }

    public void shutdown()
    {
        synchronized(surfaceDataUpdateLock)
        {
            ExternalSurfaceData externalsurfacedata = surfaceData;
            surfaceData = new ExternalSurfaceData();
            ExternalSurface externalsurface;
            for(Iterator iterator = externalsurfacedata.surfaces.values().iterator(); iterator.hasNext(); (externalsurface = (ExternalSurface)iterator.next()).shutdown(gvrApi));
            ExternalSurface externalsurface1;
            for(Iterator iterator1 = externalsurfacedata.surfacesToRelease.values().iterator(); iterator1.hasNext(); (externalsurface1 = (ExternalSurface)iterator1.next()).shutdown(gvrApi));
        }
    }

    public int createExternalSurface(com.google.vr.ndk.base.GvrLayout.ExternalSurfaceListener externalsurfacelistener, Handler handler)
    {
        if(externalsurfacelistener == null || handler == null)
            throw new IllegalArgumentException("listener and handler must both be both non-null");
        else
            return createExternalSurfaceImpl(externalsurfacelistener, handler);
    }

    public int createExternalSurface()
    {
        return createExternalSurfaceImpl(null, null);
    }

    private int createExternalSurfaceImpl(com.google.vr.ndk.base.GvrLayout.ExternalSurfaceListener externalsurfacelistener, Handler handler)
    {
        Object obj = surfaceDataUpdateLock;
        JVM INSTR monitorenter ;
        int i;
        ExternalSurfaceData externalsurfacedata = new ExternalSurfaceData(surfaceData);
        i = nextID++;
        ExternalSurfaceCallback externalsurfacecallback = null;
        if(externalsurfacelistener != null && handler != null)
            externalsurfacecallback = new ExternalSurfaceCallback(externalsurfacelistener, handler);
        externalsurfacedata.surfaces.put(Integer.valueOf(i), new ExternalSurface(i, externalsurfacecallback));
        surfaceData = externalsurfacedata;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public void releaseExternalSurface(int i)
    {
        ExternalSurfaceData externalsurfacedata;
        ExternalSurface externalsurface;
        synchronized(surfaceDataUpdateLock)
        {
            if((externalsurface = (ExternalSurface)(externalsurfacedata = new ExternalSurfaceData(surfaceData)).surfaces.remove(Integer.valueOf(i))) != null)
            {
                externalsurfacedata.surfacesToRelease.put(Integer.valueOf(i), externalsurface);
                surfaceData = externalsurfacedata;
            } else
            {
                Log.e(TAG, (new StringBuilder(48)).append("Not releasing nonexistent surface ID ").append(i).toString());
            }
        }
    }

    public int getSurfaceCount()
    {
        return surfaceData.surfaces.size();
    }

    public Surface getSurface(int i)
    {
        ExternalSurfaceData externalsurfacedata;
        if((externalsurfacedata = surfaceData).surfaces.containsKey(Integer.valueOf(i)))
        {
            return ((ExternalSurface)externalsurfacedata.surfaces.get(Integer.valueOf(i))).getSurface();
        } else
        {
            Log.e(TAG, (new StringBuilder(58)).append("Surface with ID ").append(i).append(" does not exist, returning null").toString());
            return null;
        }
    }

    public void consumerAttachToCurrentGLContext()
    {
        ExternalSurfaceData externalsurfacedata;
        ExternalSurface externalsurface;
        for(Iterator iterator = (externalsurfacedata = surfaceData).surfaces.values().iterator(); iterator.hasNext(); (externalsurface = (ExternalSurface)iterator.next()).maybeAttachToCurrentGLContext());
    }

    public void consumerDetachFromCurrentGLContext()
    {
        ExternalSurfaceData externalsurfacedata;
        ExternalSurface externalsurface;
        for(Iterator iterator = (externalsurfacedata = surfaceData).surfaces.values().iterator(); iterator.hasNext(); (externalsurface = (ExternalSurface)iterator.next()).maybeDetachFromCurrentGLContext());
        gvrApi.removeAllSurfacesReprojectionThread();
    }

    public void consumerUpdateManagedSurfaces()
    {
        ExternalSurfaceData externalsurfacedata;
        ExternalSurface externalsurface;
        for(Iterator iterator = (externalsurfacedata = surfaceData).surfaces.values().iterator(); iterator.hasNext(); (externalsurface = (ExternalSurface)iterator.next()).updateSurfaceTexture(gvrApi));
        ExternalSurface externalsurface1;
        for(Iterator iterator1 = externalsurfacedata.surfacesToRelease.values().iterator(); iterator1.hasNext(); (externalsurface1 = (ExternalSurface)iterator1.next()).shutdown(gvrApi));
    }

    private static final String TAG = com/google/vr/cardboard/ExternalSurfaceManager.getSimpleName();
    private final GvrApi gvrApi;
    private volatile ExternalSurfaceData surfaceData;
    private final Object surfaceDataUpdateLock = new Object();
    private int nextID;

}
