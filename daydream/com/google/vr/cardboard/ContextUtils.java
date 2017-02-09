// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ContextUtils.java

package com.google.vr.cardboard;

import android.app.Activity;
import android.content.*;

// Referenced classes of package com.google.vr.cardboard:
//            VrContextWrapper

public class ContextUtils
{

    public ContextUtils()
    {
    }

    public static Activity getActivity(Context context)
    {
        do
        {
            if(context == null)
                return null;
            if(context instanceof Activity)
                return (Activity)context;
            if(context instanceof ContextWrapper)
                context = ((ContextWrapper)context).getBaseContext();
            else
                return null;
        } while(true);
    }

    public static boolean canGetActivity(Context context)
    {
        return getActivity(context) != null;
    }

    public static ComponentName getComponentName(Context context)
    {
        if(context instanceof VrContextWrapper)
            return ((VrContextWrapper)context).getVrComponent();
        Activity activity;
        if((activity = getActivity(context)) != null)
            return activity.getComponentName();
        else
            return null;
    }
}
