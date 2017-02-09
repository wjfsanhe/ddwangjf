// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   StoragePermissionUtils.java

package com.google.vr.cardboard;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;

// Referenced classes of package com.google.vr.cardboard:
//            ContextUtils

public class StoragePermissionUtils
{

    public StoragePermissionUtils()
    {
    }

    public void requestStoragePermission(Context context)
    {
        if(android.os.Build.VERSION.SDK_INT < 23)
            return;
        if(context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0)
            return;
        Activity activity;
        if((activity = ContextUtils.getActivity(context)) == null)
        {
            Log.w(TAG, "An Activity Context is required, aborting storage permission request.");
            return;
        } else
        {
            activity.requestPermissions(new String[] {
                "android.permission.READ_EXTERNAL_STORAGE"
            }, 239);
            return;
        }
    }

    private static final String TAG = com/google/vr/cardboard/StoragePermissionUtils.getSimpleName();
    private static final String STORAGE_PERMISSION = "android.permission.READ_EXTERNAL_STORAGE";
    public static final int STORAGE_PERMISSION_DUMMY_REQUEST_CODE = 239;

}
