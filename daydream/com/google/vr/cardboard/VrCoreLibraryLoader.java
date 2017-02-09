// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrCoreLibraryLoader.java

package com.google.vr.cardboard;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.vr.ndk.base.Version;
import com.google.vr.vrcore.base.api.VrCoreNotAvailableException;
import com.google.vr.vrcore.base.api.VrCoreUtils;
import com.google.vr.vrcore.library.api.*;

public class VrCoreLibraryLoader
{

    public VrCoreLibraryLoader()
    {
    }

    public static void checkVrCoreGvrLibraryAvailable(Context context)
        throws VrCoreNotAvailableException
    {
        checkVrCoreGvrLibraryAvailable(context, Version.CURRENT);
    }

    public static long loadNativeGvrLibrary(Context context, int i, int j, int k)
    {
        Version version;
        IVrNativeLibraryLoader ivrnativelibraryloader;
        version = new Version(i, j, k);
        if(!Version.CURRENT.equals(version))
            Log.w(TAG, String.format("Native SDK version does not match Java; expected %s but received %s", new Object[] {
                Version.CURRENT, version.toString()
            }));
        checkVrCoreGvrLibraryAvailable(context, version);
        Context context1 = VrCoreLoader.getRemoteContext(context);
        IVrCreator ivrcreator;
        if((ivrnativelibraryloader = (ivrcreator = VrCoreLoader.getRemoteCreator(context)).newNativeLibraryLoader(ObjectWrapper.wrap(context1), ObjectWrapper.wrap(context))) != null)
            break MISSING_BLOCK_LABEL_103;
        Log.e(TAG, "Failed to load native GVR library from VrCore: no library loader available.");
        return 0L;
        return ivrnativelibraryloader.loadNativeGvrLibrary(version.majorVersion, version.minorVersion, version.patchVersion);
        Object obj;
        obj;
        String s;
        Log.e(TAG, (new StringBuilder(49 + String.valueOf(s = String.valueOf(obj)).length())).append("Failed to load native GVR library from VrCore:\n  ").append(s).toString());
        return 0L;
    }

    private static void checkVrCoreGvrLibraryAvailable(Context context, Version version)
        throws VrCoreNotAvailableException
    {
        String s;
        Version version1;
        if((version1 = Version.parse(s = VrCoreUtils.getVrCoreSdkLibraryVersion(context))) == null)
        {
            Log.i(TAG, "VrCore version does not support library loading.");
            throw new VrCoreNotAvailableException(4);
        }
        if(!version1.isAtLeast(version))
        {
            Log.w(TAG, String.format("VrCore GVR library version obsolete; VrCore supports %s but target version is %s", new Object[] {
                s, version.toString()
            }));
            throw new VrCoreNotAvailableException(4);
        } else
        {
            return;
        }
    }

    private static final String TAG = com/google/vr/cardboard/VrCoreLibraryLoader.getSimpleName();

}
