// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UiUtils.java

package com.google.vr.cardboard;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.pm.*;
import android.net.Uri;
import android.view.*;
import android.widget.Toast;
import java.util.*;

// Referenced classes of package com.google.vr.cardboard:
//            ContextUtils, PackageUtils, R, StoragePermissionUtils, 
//            VrParamsProviderFactory

public class UiUtils
{

    public UiUtils()
    {
    }

    public static void launchOrInstallCardboard(Context context)
    {
        PackageManager packagemanager = context.getPackageManager();
        Intent intent;
        (intent = new Intent()).setAction("com.google.vrtoolkit.cardboard.CONFIGURE");
        List list = packagemanager.queryIntentActivities(intent, 0);
        ArrayList arraylist = new ArrayList();
        Integer integer = null;
        Iterator iterator = list.iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            ResolveInfo resolveinfo;
            String s;
            if(!PackageUtils.isGooglePackage(s = (resolveinfo = (ResolveInfo)iterator.next()).activityInfo.packageName))
                continue;
            int i = resolveinfo.priority;
            if(PackageUtils.isSystemPackage(context, s))
                i++;
            if(integer == null)
                integer = Integer.valueOf(i);
            else
            if(i > integer.intValue())
            {
                integer = Integer.valueOf(i);
                arraylist.clear();
            } else
            if(i < integer.intValue())
                continue;
            Intent intent2;
            (intent2 = new Intent(intent)).setClassName(s, resolveinfo.activityInfo.name);
            arraylist.add(intent2);
        } while(true);
        if(!VrParamsProviderFactory.isContentProviderAvailable(context))
            permissionUtils.requestStoragePermission(context);
        if(arraylist.isEmpty())
        {
            showInstallDialog(context);
            return;
        } else
        {
            Intent intent1 = arraylist.size() != 1 ? intent : (Intent)arraylist.get(0);
            context.startActivity(intent1);
            return;
        }
    }

    public static AlertDialog showDaydreamHelpCenterDialog(final Context context, int i, int j, final Runnable onCancelledCallback)
    {
        android.content.DialogInterface.OnClickListener onclicklistener = new android.content.DialogInterface.OnClickListener() {

            public final void onClick(DialogInterface dialoginterface, int k)
            {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://support.google.com/daydream?p=daydream_help_menu"));
                try
                {
                    context.startActivity(intent);
                    return;
                }
                catch(ActivityNotFoundException _ex)
                {
                    Toast.makeText(context, R.string.no_browser_text, 1).show();
                }
                dialoginterface.cancel();
            }

            final Context val$context;

            
            {
                context = context1;
                super();
            }
        };
        android.app.AlertDialog.Builder builder;
        (builder = createAlertDialogBuilder(context)).setTitle(i).setMessage(j).setCancelable(false).setPositiveButton(R.string.dialog_button_open_help_center, onclicklistener).setNegativeButton(R.string.dialog_button_got_it, new android.content.DialogInterface.OnClickListener() {

            public final void onClick(DialogInterface dialoginterface, int k)
            {
                dialoginterface.cancel();
            }

        });
        if(onCancelledCallback != null)
            builder.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                public final void onCancel(DialogInterface dialoginterface)
                {
                    onCancelledCallback.run();
                }

                final Runnable val$onCancelledCallback;

            
            {
                onCancelledCallback = runnable;
                super();
            }
            });
        AlertDialog alertdialog;
        (alertdialog = builder.create()).setCanceledOnTouchOutside(false);
        return showImmersiveDialog(context, alertdialog);
    }

    private static void showInstallDialog(final Context context)
    {
        android.content.DialogInterface.OnClickListener onclicklistener = new android.content.DialogInterface.OnClickListener() {

            public final void onClick(DialogInterface dialoginterface, int i)
            {
                try
                {
                    context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://google.com/cardboard/cfg")));
                    return;
                }
                catch(ActivityNotFoundException _ex)
                {
                    Toast.makeText(context, R.string.no_browser_text, 1).show();
                }
            }

            final Context val$context;

            
            {
                context = context1;
                super();
            }
        };
        android.app.AlertDialog.Builder builder;
        (builder = createAlertDialogBuilder(context)).setTitle(R.string.dialog_title).setMessage(R.string.dialog_message_no_cardboard).setPositiveButton(R.string.go_to_playstore_button, onclicklistener).setNegativeButton(R.string.cancel_button, null);
        showImmersiveDialog(context, builder.create());
    }

    private static AlertDialog showImmersiveDialog(Context context, AlertDialog alertdialog)
    {
        alertdialog.getWindow().setFlags(8, 8);
        alertdialog.show();
        Activity activity;
        if((activity = ContextUtils.getActivity(context)) != null)
            alertdialog.getWindow().getDecorView().setSystemUiVisibility(activity.getWindow().getDecorView().getSystemUiVisibility());
        alertdialog.getWindow().clearFlags(8);
        return alertdialog;
    }

    private static android.app.AlertDialog.Builder createAlertDialogBuilder(Context context)
    {
        if(dialogBuilderForTesting != null)
            return dialogBuilderForTesting;
        else
            return new android.app.AlertDialog.Builder(context, R.style.GvrDialogTheme);
    }

    private static final String CARDBOARD_WEBSITE = "https://google.com/cardboard/cfg";
    private static final String CARDBOARD_CONFIGURE_ACTION = "com.google.vrtoolkit.cardboard.CONFIGURE";
    private static final String DAYDREAM_HELP_CENTER_LINK = "https://support.google.com/daydream?p=daydream_help_menu";
    public static StoragePermissionUtils permissionUtils = new StoragePermissionUtils();
    public static android.app.AlertDialog.Builder dialogBuilderForTesting;

}
