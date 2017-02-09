// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DaydreamApi.java

package com.google.vr.ndk.base;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.*;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.*;
import android.util.Log;
import com.google.vr.cardboard.*;
import com.google.vr.vrcore.base.api.VrCoreNotAvailableException;
import com.google.vr.vrcore.base.api.VrCoreUtils;
import com.google.vr.vrcore.common.api.*;
import com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.vr.ndk.base:
//            DaydreamUtils, GvrApi

public class DaydreamApi
    implements AutoCloseable
{

    public static DaydreamApi create(Context context1)
    {
        if(Looper.getMainLooper() != Looper.myLooper())
            throw new IllegalStateException("DaydreamApi must only be used from the main thread.");
        if(!DaydreamUtils.isDaydreamPhone(context1))
        {
            Log.i(TAG, "Phone is not Daydream-compatible");
            return null;
        }
        DaydreamApi daydreamapi;
        if((daydreamapi = new DaydreamApi(context1)).init())
        {
            return daydreamapi;
        } else
        {
            Log.w(TAG, "Failed to initialize DaydreamApi object.");
            return null;
        }
    }

    public static boolean isDaydreamReadyPlatform(Context context1)
    {
        return DaydreamUtils.isDaydreamPhone(context1);
    }

    public int getCurrentViewerType()
    {
        VrParamsProvider vrparamsprovider;
        checkNotClosed();
        if(!isDaydreamReadyPlatform(context))
            return 0;
        vrparamsprovider = VrParamsProviderFactory.create(context);
        com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams deviceparams;
        if((deviceparams = vrparamsprovider.readDeviceParams()) == null)
        {
            vrparamsprovider.close();
            return 0;
        }
        if(DaydreamUtils.isDaydreamViewer(deviceparams))
        {
            vrparamsprovider.close();
            return 1;
        } else
        {
            vrparamsprovider.close();
            return 0;
        }
        Exception exception;
        exception;
        vrparamsprovider.close();
        throw exception;
    }

    public void registerDaydreamIntent(final PendingIntent intent)
    {
        checkNotClosed();
        runWhenServiceConnected(new Runnable() {

            public void run()
            {
                if(daydreamManager == null)
                {
                    Log.w(DaydreamApi.TAG, "Can't register/unregister daydream intent: no DaydreamManager.");
                    return;
                }
                try
                {
                    if(intent != null)
                    {
                        daydreamManager.registerDaydreamIntent(intent);
                    } else
                    {
                        daydreamManager.unregisterDaydreamIntent();
                        return;
                    }
                }
                catch(RemoteException remoteexception)
                {
                    Log.e(DaydreamApi.TAG, "Error when attempting to register/unregister daydream intent: ", remoteexception);
                }
            }

            final PendingIntent val$intent;
            final DaydreamApi this$0;

            
            {
                this$0 = DaydreamApi.this;
                intent = pendingintent;
                super();
            }
        });
    }

    public void unregisterDaydreamIntent()
    {
        checkNotClosed();
        registerDaydreamIntent(null);
    }

    public static boolean setDaydreamSetupCompleted(Context context1, boolean flag)
    {
        com.google.vr.cardboard.VrParamsProviderFactory.ContentProviderClientHandle contentproviderclienthandle;
        android.net.Uri uri;
        if((contentproviderclienthandle = VrParamsProviderFactory.tryToGetContentProviderClientHandle(context1)) == null)
        {
            Log.e(TAG, "No ContentProvider available for Daydream setup.");
            return false;
        }
        uri = VrSettingsProviderContract.createUri(contentproviderclienthandle.authority, "daydream_setup");
        ContentValues contentvalues;
        (contentvalues = new ContentValues()).put("value", Boolean.valueOf(flag));
        int i;
        if((i = contentproviderclienthandle.client.update(uri, contentvalues, null, null)) > 0)
            return true;
        return false;
        Object obj;
        obj;
        Log.e(TAG, "Failed to indicate Daydream setup completion to ContentProvider", ((Throwable) (obj)));
        return false;
        obj;
        Log.e(TAG, "Insufficient permissions to indicate Daydream setup completion to ContentProvider", ((Throwable) (obj)));
        return false;
    }

    public static boolean getDaydreamSetupCompleted(Context context1)
    {
        com.google.vr.cardboard.VrParamsProviderFactory.ContentProviderClientHandle contentproviderclienthandle;
        android.net.Uri uri;
        Cursor cursor;
        if((contentproviderclienthandle = VrParamsProviderFactory.tryToGetContentProviderClientHandle(context1)) == null)
        {
            Log.e(TAG, "No ContentProvider available for Daydream setup.");
            return false;
        }
        uri = VrSettingsProviderContract.createUri(contentproviderclienthandle.authority, "daydream_setup");
        cursor = null;
        boolean flag;
        if((cursor = contentproviderclienthandle.client.query(uri, null, null, null, null)) == null || !cursor.moveToFirst())
            break MISSING_BLOCK_LABEL_89;
        flag = cursor.getInt(0) == 1;
        if(cursor != null)
            cursor.close();
        return flag;
        if(cursor != null)
            cursor.close();
        return false;
        Object obj;
        obj;
        Log.e(TAG, "Failed to read Daydream setup completion from ContentProvider", ((Throwable) (obj)));
        if(cursor != null)
            cursor.close();
        return false;
        obj;
        Log.e(TAG, "Insufficient permissions to read Daydream setup completion from ContentProvider", ((Throwable) (obj)));
        if(cursor != null)
            cursor.close();
        return false;
        Exception exception;
        exception;
        if(cursor != null)
            cursor.close();
        throw exception;
    }

    public void launchInVr(PendingIntent pendingintent)
    {
        checkNotClosed();
        launchInVr(pendingintent, null);
    }

    private void launchInVr(final PendingIntent pendingIntent, final ComponentName component)
    {
        runWhenServiceConnected(new Runnable() {

            public void run()
            {
                if(daydreamManager != null)
                {
                    try
                    {
                        daydreamManager.launchInVr(pendingIntent, component);
                        return;
                    }
                    catch(RemoteException remoteexception)
                    {
                        Log.e(DaydreamApi.TAG, "RemoteException while launching PendingIntent in VR.", remoteexception);
                    }
                    return;
                }
                Log.w(DaydreamApi.TAG, "Can't launch PendingIntent via DaydreamManager: not available.");
                try
                {
                    pendingIntent.send();
                    return;
                }
                catch(Exception exception)
                {
                    Log.e(DaydreamApi.TAG, "Couldn't launch PendingIntent: ", exception);
                }
            }

            final PendingIntent val$pendingIntent;
            final ComponentName val$component;
            final DaydreamApi this$0;

            
            {
                this$0 = DaydreamApi.this;
                pendingIntent = pendingintent;
                component = componentname;
                super();
            }
        });
    }

    private void launchTransitionCallbackInVr(final ITransitionCallbacks callbacks)
    {
        runWhenServiceConnected(new Runnable() {

            public void run()
            {
                boolean flag = false;
                if(daydreamManager != null)
                    try
                    {
                        flag = daydreamManager.launchVrTransition(callbacks);
                    }
                    catch(RemoteException remoteexception)
                    {
                        Log.e(DaydreamApi.TAG, "RemoteException while launching VR transition: ", remoteexception);
                    }
                if(!flag)
                {
                    Log.w(DaydreamApi.TAG, "Can't launch callbacks via DaydreamManager, sending manually");
                    try
                    {
                        callbacks.onTransitionComplete();
                        return;
                    }
                    catch(RemoteException _ex) { }
                }
            }

            final ITransitionCallbacks val$callbacks;
            final DaydreamApi this$0;

            
            {
                this$0 = DaydreamApi.this;
                callbacks = itransitioncallbacks;
                super();
            }
        });
    }

    public void launchVrHomescreen()
    {
        checkNotClosed();
        runWhenServiceConnected(new Runnable() {

            public void run()
            {
                if(daydreamManager == null)
                {
                    Log.e(DaydreamApi.TAG, "Can't launch VR homescreen via DaydreamManager. Giving up trying to leave current VR activity...");
                    return;
                }
                if(daydreamManager.launchVrHome())
                    return;
                String s;
                try
                {
                    Log.e(DaydreamApi.TAG, "There is no VR homescreen installed.");
                    return;
                }
                catch(RemoteException remoteexception)
                {
                    Log.e(DaydreamApi.TAG, (new StringBuilder(47 + String.valueOf(s = String.valueOf(remoteexception)).length())).append("RemoteException while launching VR homescreen: ").append(s).toString());
                }
                return;
            }

            final DaydreamApi this$0;

            
            {
                this$0 = DaydreamApi.this;
                super();
            }
        });
    }

    public void launchInVr(Intent intent)
        throws ActivityNotFoundException
    {
        checkNotClosed();
        if(intent == null)
        {
            throw new IllegalArgumentException("Null argument 'intent' passed to launchInVr");
        } else
        {
            checkIntent(intent);
            launchInVr(PendingIntent.getActivity(context, 0, intent, 0x48000000), intent.getComponent());
            return;
        }
    }

    public void launchInVr(ComponentName componentname)
        throws ActivityNotFoundException
    {
        checkNotClosed();
        if(componentname == null)
        {
            throw new IllegalArgumentException("Null argument 'componentName' passed to launchInVr");
        } else
        {
            Intent intent = createVrIntent(componentname);
            checkIntent(intent);
            launchInVr(PendingIntent.getActivity(context, 0, intent, 0x40000000), intent.getComponent());
            return;
        }
    }

    public void launchInVrForResult(final Activity activity, final PendingIntent pendingIntent, final int requestCode)
    {
        checkNotClosed();
        com.google.vr.vrcore.common.api.ITransitionCallbacks.Stub stub = new com.google.vr.vrcore.common.api.ITransitionCallbacks.Stub() {

            public void onTransitionComplete()
            {
                activity.runOnUiThread(new Runnable() {

                    public void run()
                    {
                        String s;
                        try
                        {
                            activity.startIntentSenderForResult(pendingIntent.getIntentSender(), requestCode, null, 0, 0, 0);
                            return;
                        }
                        catch(android.content.IntentSender.SendIntentException sendintentexception)
                        {
                            Log.e(DaydreamApi.TAG, (new StringBuilder(43 + String.valueOf(s = String.valueOf(sendintentexception)).length())).append("Exception while starting next VR activity: ").append(s).toString());
                        }
                    }

                    final _cls6 this$1;

                    
                    {
                        this$1 = _cls6.this;
                        super();
                    }
                });
            }

            final Activity val$activity;
            final PendingIntent val$pendingIntent;
            final int val$requestCode;

            
            {
                activity = activity1;
                pendingIntent = pendingintent;
                requestCode = i;
                super();
            }
        };
        launchTransitionCallbackInVr(stub);
    }

    public static Intent createVrIntent(ComponentName componentname)
    {
        Intent intent;
        (intent = new Intent()).setComponent(componentname);
        return setupVrIntent(intent);
    }

    public static Intent setupVrIntent(Intent intent)
    {
        intent.addCategory("com.google.intent.category.DAYDREAM");
        intent.addFlags(0x14010000);
        return intent;
    }

    public void exitFromVr(Activity activity, int i, Intent intent)
    {
        checkNotClosed();
        if(intent == null)
            intent = new Intent();
        final PendingIntent pendingVrExitIntent = activity.createPendingResult(i, intent, 0x40000000);
        final Runnable onFailureRunnable = new Runnable() {

            public void run()
            {
                String s;
                try
                {
                    pendingVrExitIntent.send(0);
                    return;
                }
                catch(Exception exception)
                {
                    Log.e(DaydreamApi.TAG, (new StringBuilder(31 + String.valueOf(s = String.valueOf(exception)).length())).append("Couldn't launch PendingIntent: ").append(s).toString());
                }
            }

            final PendingIntent val$pendingVrExitIntent;

            
            {
                pendingVrExitIntent = pendingintent;
                super();
            }
        };
        runWhenServiceConnected(new Runnable() {

            public void run()
            {
                if(daydreamManager == null)
                {
                    Log.w(DaydreamApi.TAG, "Failed to exit VR: Daydream service unavailable.");
                    onFailureRunnable.run();
                    return;
                }
                String s;
                try
                {
                    if(!daydreamManager.exitFromVr(pendingVrExitIntent))
                    {
                        Log.w(DaydreamApi.TAG, "Failed to exit VR: Invalid request.");
                        onFailureRunnable.run();
                    }
                    return;
                }
                catch(RemoteException remoteexception)
                {
                    Log.e(DaydreamApi.TAG, (new StringBuilder(49 + String.valueOf(s = String.valueOf(remoteexception)).length())).append("Failed to exit VR: RemoteException while exiting:").append(s).toString());
                }
                onFailureRunnable.run();
            }

            final Runnable val$onFailureRunnable;
            final PendingIntent val$pendingVrExitIntent;
            final DaydreamApi this$0;

            
            {
                this$0 = DaydreamApi.this;
                onFailureRunnable = runnable;
                pendingVrExitIntent = pendingintent;
                super();
            }
        });
    }

    public void setInhibitSystemButtons(final ComponentName componentName, final boolean shouldInhibit)
    {
        checkNotClosed();
        runWhenServiceConnected(new Runnable() {

            public void run()
            {
                try
                {
                    Bundle bundle;
                    (bundle = new Bundle()).putBoolean("OPTION_INHIBIT_SYSTEM_BUTTONS", shouldInhibit);
                    if(!vrCoreSdkService.setClientOptions(componentName, bundle))
                        Log.w(DaydreamApi.TAG, "Failed to set client options to inhibit system button.");
                    return;
                }
                catch(RemoteException remoteexception)
                {
                    Log.e(DaydreamApi.TAG, "RemoteException while setting client options.", remoteexception);
                }
            }

            final boolean val$shouldInhibit;
            final ComponentName val$componentName;
            final DaydreamApi this$0;

            
            {
                this$0 = DaydreamApi.this;
                shouldInhibit = flag;
                componentName = componentname;
                super();
            }
        });
    }

    public void handleInsertionIntoHeadset(final byte deviceParams[])
    {
        runWhenServiceConnected(new Runnable() {

            public void run()
            {
                if(vrCoreApiVersion < 11)
                {
                    String s;
                    int i;
                    Log.e(DaydreamApi.TAG, (new StringBuilder(11 + String.valueOf(s = String.valueOf("Can't handle insertion of phone into headset: VrCore API too old. Need: 11, found: ")).length())).append(s).append(i = vrCoreApiVersion).toString());
                    return;
                }
                if(daydreamManager == null)
                {
                    Log.e(DaydreamApi.TAG, "Can't handle insertion of phone into headset: no DaydreamManager.");
                    return;
                }
                try
                {
                    daydreamManager.handleInsertionIntoHeadset(deviceParams);
                    return;
                }
                catch(SecurityException securityexception)
                {
                    Log.e(DaydreamApi.TAG, "SecurityException when notifying phone insertion. Check that the calling app is in the system image (must have the SYSTEM flag in package manager).", securityexception);
                    return;
                }
                catch(RemoteException remoteexception)
                {
                    Log.e(DaydreamApi.TAG, "RemoteException while notifying phone insertion.", remoteexception);
                }
            }

            final byte val$deviceParams[];
            final DaydreamApi this$0;

            
            {
                this$0 = DaydreamApi.this;
                deviceParams = abyte0;
                super();
            }
        });
    }

    public void handleRemovalFromHeadset()
    {
        runWhenServiceConnected(new Runnable() {

            public void run()
            {
                if(vrCoreApiVersion < 11)
                {
                    String s;
                    int i;
                    Log.e(DaydreamApi.TAG, (new StringBuilder(11 + String.valueOf(s = String.valueOf("Can't handle removal of phone from headset: VrCore API too old. Need: 11, found: ")).length())).append(s).append(i = vrCoreApiVersion).toString());
                    return;
                }
                if(daydreamManager == null)
                {
                    Log.e(DaydreamApi.TAG, "Can't handle removal of phone from headset: no DaydreamManager.");
                    return;
                }
                try
                {
                    daydreamManager.handleRemovalFromHeadset();
                    return;
                }
                catch(SecurityException securityexception)
                {
                    Log.e(DaydreamApi.TAG, "SecurityException when notifying phone removal. Check that the calling app is in the system image (must have the SYSTEM flag in package manager).", securityexception);
                    return;
                }
                catch(RemoteException remoteexception)
                {
                    Log.e(DaydreamApi.TAG, "RemoteException while notifying phone removal.", remoteexception);
                }
            }

            final DaydreamApi this$0;

            
            {
                this$0 = DaydreamApi.this;
                super();
            }
        });
    }

    public void close()
    {
        if(closed)
        {
            return;
        } else
        {
            closed = true;
            runWhenServiceConnected(new Runnable() {

                public void run()
                {
                    context.unbindService(connection);
                    vrCoreSdkService = null;
                }

                final DaydreamApi this$0;

            
            {
                this$0 = DaydreamApi.this;
                super();
            }
            });
            return;
        }
    }

    private DaydreamApi(Context context1)
    {
        queuedRunnables = new ArrayList();
        context = context1;
    }

    private boolean init()
    {
        vrCoreApiVersion = VrCoreUtils.getVrCoreClientApiVersion(context);
        if(vrCoreApiVersion >= 8)
            break MISSING_BLOCK_LABEL_61;
        int i;
        Log.e(TAG, (new StringBuilder(79)).append("VrCore out of date, current version: ").append(i = vrCoreApiVersion).append(", required version: 8").toString());
        return false;
        Intent intent;
        (intent = new Intent("com.google.vr.vrcore.BIND_SDK_SERVICE")).setPackage("com.google.vr.vrcore");
        if(context.bindService(intent, connection, 1))
            return true;
        String s;
        try
        {
            Log.e(TAG, "Unable to bind to VrCoreSdkService");
        }
        catch(VrCoreNotAvailableException vrcorenotavailableexception)
        {
            Log.e(TAG, (new StringBuilder(22 + String.valueOf(s = String.valueOf(vrcorenotavailableexception)).length())).append("VrCore not available: ").append(s).toString());
        }
        return false;
    }

    private void runWhenServiceConnected(Runnable runnable)
    {
        if(vrCoreSdkService != null)
        {
            runnable.run();
            return;
        } else
        {
            queuedRunnables.add(runnable);
            return;
        }
    }

    private void checkIntent(Intent intent)
        throws ActivityNotFoundException
    {
        PackageManager packagemanager;
        List list;
        if((list = (packagemanager = context.getPackageManager()).queryIntentActivities(intent, 0)) == null || list.isEmpty())
        {
            String s = String.valueOf(intent);
            throw new ActivityNotFoundException((new StringBuilder(43 + String.valueOf(s).length())).append("No activity is available to handle intent: ").append(s).toString());
        } else
        {
            return;
        }
    }

    private void checkNotClosed()
    {
        if(closed)
            throw new IllegalStateException("DaydreamApi object is closed and can no longer be used.");
        else
            return;
    }

    private static final String TAG = com/google/vr/ndk/base/DaydreamApi.getSimpleName();
    private static final int MIN_VRCORE_API_VERSION = 8;
    private static final int MIN_API_FOR_HEADSET_INSERTION = 11;
    private static final String DAYDREAM_CATEGORY = "com.google.intent.category.DAYDREAM";
    private IVrCoreSdkService vrCoreSdkService;
    private IDaydreamManager daydreamManager;
    private final Context context;
    private boolean closed;
    private ArrayList queuedRunnables;
    private int vrCoreApiVersion;
    private final ServiceConnection connection = new ServiceConnection() {

        public void onServiceConnected(ComponentName componentname, IBinder ibinder)
        {
            vrCoreSdkService = com.google.vr.vrcore.common.api.IVrCoreSdkService.Stub.asInterface(ibinder);
            try
            {
                daydreamManager = vrCoreSdkService.getDaydreamManager();
            }
            catch(RemoteException _ex)
            {
                Log.e(DaydreamApi.TAG, "RemoteException in onServiceConnected");
            }
            if(daydreamManager == null)
                Log.w(DaydreamApi.TAG, "Daydream service component unavailable.");
            ArrayList arraylist;
            int i = (arraylist = (ArrayList)queuedRunnables).size();
            int j = 0;
            Object obj = null;
            while(j < i) 
            {
                j++;
                Runnable runnable;
                (runnable = (Runnable)arraylist.get(j)).run();
            }
            queuedRunnables.clear();
        }

        public void onServiceDisconnected(ComponentName componentname)
        {
            vrCoreSdkService = null;
        }

        final DaydreamApi this$0;

            
            {
                this$0 = DaydreamApi.this;
                super();
            }
    };










}
