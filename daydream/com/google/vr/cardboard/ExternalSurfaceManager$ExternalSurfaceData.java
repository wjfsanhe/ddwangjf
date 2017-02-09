// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ExternalSurfaceManager.java

package com.google.vr.cardboard;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.google.vr.cardboard:
//            ExternalSurfaceManager

private static class ss._cls000
{

    final HashMap surfaces;
    final HashMap surfacesToRelease;

    ()
    {
        surfaces = new HashMap();
        surfacesToRelease = new HashMap();
    }

    surfacesToRelease(surfacesToRelease surfacestorelease)
    {
        surfaces = new HashMap(surfacestorelease.surfaces);
        surfacesToRelease = new HashMap(surfacestorelease.surfacesToRelease);
        Iterator iterator = surfacesToRelease.entrySet().iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            java.util.alSurface alsurface;
            if(ss._mth000((ss._cls000)(alsurface = (java.util.alSurface)iterator.next()).alSurface()).get())
                iterator.remove();
        } while(true);
    }
}
