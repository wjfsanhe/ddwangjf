// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrCoreLoader.java

package com.google.vr.vrcore.library.api;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.IBinder;
import com.google.vr.vrcore.base.api.VrCoreNotAvailableException;
import com.google.vr.vrcore.base.api.VrCoreUtils;

// Referenced classes of package com.google.vr.vrcore.library.api:
//            IVrCreator

public class VrCoreLoader
{

    public VrCoreLoader()
    {
    }

    public static IVrCreator getRemoteCreator(Context context)
        throws VrCoreNotAvailableException
    {
        ClassLoader classloader;
        IBinder ibinder;
        if(sCreator == null)
            sCreator = IVrCreator.Stub.asInterface(ibinder = newBinderInstance(classloader = getRemoteContext(context).getClassLoader(), "com.google.vr.vrcore.library.VrCreator"));
        return sCreator;
    }

    public static Context getRemoteContext(Context context)
        throws VrCoreNotAvailableException
    {
        if(sRemoteContext == null)
        {
            int i;
            if((i = VrCoreUtils.getVrCoreClientApiVersion(context)) < 9)
                throw new VrCoreNotAvailableException(4);
            try
            {
                sRemoteContext = context.createPackageContext("com.google.vr.vrcore", 3);
            }
            catch(android.content.pm.PackageManager.NameNotFoundException _ex)
            {
                throw new VrCoreNotAvailableException(1);
            }
        }
        return sRemoteContext;
    }

    private static IBinder newBinderInstance(ClassLoader classloader, String s)
    {
        Class class1;
        return (IBinder)(class1 = classloader.loadClass(s)).newInstance();
        JVM INSTR pop ;
        JVM INSTR new #22  <Class IllegalStateException>;
        JVM INSTR dup ;
        "Unable to find dynamic class ";
        String s1 = String.valueOf(s);
        s1;
        if(s1.length() == 0) goto _L2; else goto _L1
_L1:
        concat();
          goto _L3
_L2:
        JVM INSTR pop ;
        JVM INSTR new #25  <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
_L3:
        IllegalStateException();
        throw ;
        JVM INSTR pop ;
        JVM INSTR new #22  <Class IllegalStateException>;
        JVM INSTR dup ;
        "Unable to instantiate the remote class ";
        String s2 = String.valueOf(s);
        s2;
        if(s2.length() == 0) goto _L5; else goto _L4
_L4:
        concat();
          goto _L6
_L5:
        JVM INSTR pop ;
        JVM INSTR new #25  <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
_L6:
        IllegalStateException();
        throw ;
        JVM INSTR pop ;
        JVM INSTR new #22  <Class IllegalStateException>;
        JVM INSTR dup ;
        "Unable to call the default constructor of ";
        String s3 = String.valueOf(s);
        s3;
        if(s3.length() == 0) goto _L8; else goto _L7
_L7:
        concat();
          goto _L9
_L8:
        JVM INSTR pop ;
        JVM INSTR new #25  <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
_L9:
        IllegalStateException();
        throw ;
    }

    private static final String TAG = com/google/vr/vrcore/library/api/VrCoreLoader.getSimpleName();
    private static final boolean DEBUG = false;
    private static final String LIBRARY_APK_PACKAGE = "com.google.vr.vrcore";
    private static final String CREATOR_NAME = "com.google.vr.vrcore.library.VrCreator";
    static final int MIN_TARGET_API_VERSION = 9;
    private static Context sRemoteContext;
    private static IVrCreator sCreator;

}
