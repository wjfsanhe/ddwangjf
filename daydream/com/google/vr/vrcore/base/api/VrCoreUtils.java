// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrCoreUtils.java

package com.google.vr.vrcore.base.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.*;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.vr.vrcore.base.api:
//            BuildUtils, SignatureUtils, VrCoreNotAvailableException

public final class VrCoreUtils
{
    public static class ConnectionResult
    {

        public static final int SUCCESS = 0;
        public static final int SERVICE_MISSING = 1;
        public static final int SERVICE_DISABLED = 2;
        public static final int SERVICE_UPDATING = 3;
        public static final int SERVICE_OBSOLETE = 4;
        public static final int SERVICE_NOT_CONNECTED = 5;
        public static final int NO_PERMISSION = 6;
        public static final int NOT_SUPPORTED = 7;
        public static final int UNKNOWN = 8;
        public static final int SERVICE_INVALID = 9;

        public ConnectionResult()
        {
        }
    }


    public VrCoreUtils()
    {
    }

    public static int checkVrCoreAvailability(Context context)
    {
        int i;
        return i = checkVrCoreAvailabilityImpl(context);
    }

    public static boolean isVrCoreAvailable(Context context)
    {
        return checkVrCoreAvailability(context) == 0;
    }

    public static int getVrCoreClientApiVersion(Context context)
        throws VrCoreNotAvailableException
    {
        ApplicationInfo applicationinfo;
        if(!(applicationinfo = context.getPackageManager().getApplicationInfo("com.google.vr.vrcore", 128)).enabled)
            break MISSING_BLOCK_LABEL_40;
        if(applicationinfo.metaData != null)
            return applicationinfo.metaData.getInt("com.google.vr.vrcore.ClientApiVersion", 0);
        return 0;
        try
        {
            throw new VrCoreNotAvailableException(2);
        }
        catch(android.content.pm.PackageManager.NameNotFoundException _ex)
        {
            throw new VrCoreNotAvailableException(checkVrCoreAvailability(context));
        }
    }

    public static int getVrCoreVersionCode(Context context)
        throws VrCoreNotAvailableException
    {
        return context.getPackageManager().getPackageInfo("com.google.vr.vrcore", 0).versionCode;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        Log.e(TAG, "Could not find VrCore package", namenotfoundexception);
        throw new VrCoreNotAvailableException(checkVrCoreAvailability(context));
    }

    public static String getVrCoreVersionName(Context context)
        throws VrCoreNotAvailableException
    {
        return context.getPackageManager().getPackageInfo("com.google.vr.vrcore", 0).versionName;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        Log.e(TAG, "Could not find VrCore package", namenotfoundexception);
        throw new VrCoreNotAvailableException(checkVrCoreAvailability(context));
    }

    public static String getVrCoreSdkLibraryVersion(Context context)
        throws VrCoreNotAvailableException
    {
        ApplicationInfo applicationinfo;
        try
        {
            applicationinfo = context.getPackageManager().getApplicationInfo("com.google.vr.vrcore", 128);
        }
        catch(android.content.pm.PackageManager.NameNotFoundException _ex)
        {
            throw new VrCoreNotAvailableException(checkVrCoreAvailability(context));
        }
        if(applicationinfo == null)
            throw new VrCoreNotAvailableException(8);
        if(!applicationinfo.enabled)
            throw new VrCoreNotAvailableException(2);
        if(applicationinfo.metaData == null)
            throw new VrCoreNotAvailableException(4);
        String s;
        if((s = applicationinfo.metaData.getString("com.google.vr.vrcore.SdkLibraryVersion", "")).isEmpty())
            throw new VrCoreNotAvailableException(4);
        else
            return s.substring(1);
    }

    public static String getConnectionResultString(int i)
    {
        switch(i)
        {
        case 0: // '\0'
            return "VR Service present";

        case 1: // '\001'
            return "VR Service missing";

        case 2: // '\002'
            return "VR Service disabled";

        case 3: // '\003'
            return "VR Service updating";

        case 4: // '\004'
            return "VR Service obsolete";

        case 5: // '\005'
            return "VR Service not connected";

        case 6: // '\006'
            return "No permission to do operation";

        case 7: // '\007'
            return "This operation is not supported on this device";

        case 8: // '\b'
            return "An unknown failure occurred";
        }
        return (new StringBuilder(38)).append("Invalid connection result: ").append(i).toString();
    }

    public static boolean isVrCorePackage(String s)
    {
        return "com.google.vr.vrcore".equalsIgnoreCase(s);
    }

    public static boolean isVrCoreComponent(ComponentName componentname)
    {
        return componentname != null && isVrCorePackage(componentname.getPackageName());
    }

    private static int checkVrCoreAvailabilityImpl(Context context)
    {
        if("com.google.vr.vrcore".equals(context.getPackageName()))
            return 0;
        Object obj;
        if(!((ApplicationInfo) (obj = context.getPackageManager().getApplicationInfo("com.google.vr.vrcore", 0))).enabled)
            return 2;
        return verifyRemotePackageSignature(context) ? 0 : 9;
        JVM INSTR pop ;
label0:
        {
            if(android.os.Build.VERSION.SDK_INT < 21)
                break label0;
            Iterator iterator = ((List) (obj = context.getPackageManager().getPackageInstaller().getAllSessions())).iterator();
            android.content.pm.PackageInstaller.SessionInfo sessioninfo;
            do
            {
                if(!iterator.hasNext())
                    break label0;
                sessioninfo = (android.content.pm.PackageInstaller.SessionInfo)iterator.next();
            } while(!"com.google.vr.vrcore".equals(sessioninfo.getAppPackageName()));
            return 3;
        }
        obj = context.getPackageManager();
        ApplicationInfo applicationinfo;
        if((applicationinfo = ((PackageManager) (obj)).getApplicationInfo("com.google.vr.vrcore", 8192)).enabled)
            return 3;
        break MISSING_BLOCK_LABEL_137;
        JVM INSTR pop ;
        return 1;
    }

    private static boolean verifyRemotePackageSignature(Context context)
        throws android.content.pm.PackageManager.NameNotFoundException
    {
        PackageInfo packageinfo;
        if(SignatureUtils.verifySignature(packageinfo = context.getPackageManager().getPackageInfo("com.google.vr.vrcore", 64), new Signature[] {
    SignatureUtils.VRCORE_RELEASE_SIGNATURE
}))
            return true;
        if(BuildUtils.isDebugBuild(context))
            return SignatureUtils.verifySignature(packageinfo, new Signature[] {
                SignatureUtils.VRCORE_DEBUG_SIGNATURE
            });
        else
            return false;
    }

    private static final String TAG = com/google/vr/vrcore/base/api/VrCoreUtils.getSimpleName();
    private static final boolean DEBUG = false;

}
