// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VrParamsProviderFactory.java

package com.google.vr.cardboard;

import android.content.*;
import android.content.pm.*;
import android.os.Build;
import java.util.*;

// Referenced classes of package com.google.vr.cardboard:
//            ContentProviderVrParamsProvider, LegacyVrParamsProvider, PackageUtils, VrParamsProvider

public final class VrParamsProviderFactory
{
    public static class ContentProviderClientHandle
    {

        public final ContentProviderClient client;
        public final String authority;

        ContentProviderClientHandle(ContentProviderClient contentproviderclient, String s)
        {
            client = contentproviderclient;
            authority = s;
        }
    }


    public VrParamsProviderFactory()
    {
    }

    public static VrParamsProvider create(Context context)
    {
        if(providerForTesting != null)
            return providerForTesting;
        ContentProviderClientHandle contentproviderclienthandle;
        if((contentproviderclienthandle = tryToGetContentProviderClientHandle(context)) != null)
            return new ContentProviderVrParamsProvider(contentproviderclienthandle.client, contentproviderclienthandle.authority);
        else
            return new LegacyVrParamsProvider();
    }

    public static ContentProviderClientHandle tryToGetContentProviderClientHandle(Context context)
    {
label0:
        {
            List list;
            if((list = getValidContentProviderAuthorities(context)) == null)
                break label0;
            Iterator iterator = list.iterator();
            String s;
            ContentProviderClient contentproviderclient;
            do
            {
                if(!iterator.hasNext())
                    break label0;
                s = (String)iterator.next();
            } while((contentproviderclient = context.getContentResolver().acquireContentProviderClient(s)) == null);
            return new ContentProviderClientHandle(contentproviderclient, s);
        }
        return null;
    }

    public static boolean isContentProviderAvailable(Context context)
    {
        if(providerForTesting != null && (providerForTesting instanceof ContentProviderVrParamsProvider))
            return true;
        List list;
        return (list = getValidContentProviderAuthorities(context)) != null && !list.isEmpty();
    }

    private static List getValidContentProviderAuthorities(Context context)
    {
        if(android.os.Build.VERSION.SDK_INT < 19)
            return null;
        PackageManager packagemanager = context.getPackageManager();
        Intent intent = new Intent("android.content.action.VR_SETTINGS_PROVIDER");
        List list;
        if((list = packagemanager.queryIntentContentProviders(intent, 0)) == null || list.isEmpty())
            return null;
        ArrayList arraylist = new ArrayList();
        Iterator iterator = list.iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            ResolveInfo resolveinfo;
            ProviderInfo providerinfo;
            if(PackageUtils.isGooglePackage((providerinfo = (resolveinfo = (ResolveInfo)iterator.next()).providerInfo).packageName))
                arraylist.add(providerinfo.authority);
        } while(true);
        return arraylist;
    }

    public static void setProviderForTesting(VrParamsProvider vrparamsprovider)
    {
        providerForTesting = vrparamsprovider;
    }

    private static final String TAG = com/google/vr/cardboard/VrParamsProviderFactory.getSimpleName();
    private static final boolean DEBUG = false;
    private static VrParamsProvider providerForTesting;

}
