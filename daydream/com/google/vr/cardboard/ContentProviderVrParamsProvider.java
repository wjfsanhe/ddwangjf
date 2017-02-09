// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ContentProviderVrParamsProvider.java

package com.google.vr.cardboard;

import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.net.Uri;
import android.os.RemoteException;
import android.util.Base64;
import android.util.Log;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.vr.ndk.base.SdkConfigurationReader;
import com.google.vr.vrcore.nano.SdkConfiguration;
import com.google.vrtoolkit.cardboard.proto.nano.*;

// Referenced classes of package com.google.vr.cardboard:
//            VrParamsProvider, VrSettingsProviderContract

public class ContentProviderVrParamsProvider
    implements VrParamsProvider
{

    public ContentProviderVrParamsProvider(ContentProviderClient contentproviderclient, String s)
    {
        if(contentproviderclient == null)
            throw new IllegalArgumentException("ContentProviderClient must not be null");
        if(s == null || s.isEmpty())
        {
            throw new IllegalArgumentException("Authority key must be non-null and non-empty");
        } else
        {
            client = contentproviderclient;
            deviceParamsSettingUri = VrSettingsProviderContract.createUri(s, "device_params");
            userPrefsUri = VrSettingsProviderContract.createUri(s, "user_prefs");
            phoneParamsSettingUri = VrSettingsProviderContract.createUri(s, "phone_params");
            sdkConfigurationParamsSettingUri = VrSettingsProviderContract.createUri(s, "sdk_configuration_params");
            return;
        }
    }

    public com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams readDeviceParams()
    {
        return (com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams)readParams(new com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams(), deviceParamsSettingUri, null);
    }

    public boolean writeDeviceParams(com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams deviceparams)
    {
        return writeParams(deviceparams, deviceParamsSettingUri);
    }

    public com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams readPhoneParams()
    {
        return (com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams)readParams(new com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams(), phoneParamsSettingUri, null);
    }

    public com.google.common.logging.nano.Vr.VREvent.SdkConfigurationParams readSdkConfigurationParams(com.google.vr.vrcore.nano.SdkConfiguration.SdkConfigurationRequest sdkconfigurationrequest)
    {
        String s = Base64.encodeToString(MessageNano.toByteArray(sdkconfigurationrequest), 0);
        return (com.google.common.logging.nano.Vr.VREvent.SdkConfigurationParams)readParams(SdkConfigurationReader.DEFAULT_PARAMS, sdkConfigurationParamsSettingUri, s);
    }

    public com.google.vrtoolkit.cardboard.proto.nano.Preferences.UserPrefs readUserPrefs()
    {
        return (com.google.vrtoolkit.cardboard.proto.nano.Preferences.UserPrefs)readParams(new com.google.vrtoolkit.cardboard.proto.nano.Preferences.UserPrefs(), userPrefsUri, null);
    }

    public boolean updateUserPrefs(com.google.vrtoolkit.cardboard.proto.nano.Preferences.UserPrefs userprefs)
    {
        return writeParams(userprefs, userPrefsUri);
    }

    public void close()
    {
        client.release();
    }

    private MessageNano readParams(MessageNano messagenano, Uri uri, String s)
    {
        Cursor cursor = null;
        if((cursor = client.query(uri, null, s, null, null)) == null || !cursor.moveToFirst())
            break MISSING_BLOCK_LABEL_82;
        byte abyte0[];
        if((abyte0 = cursor.getBlob(0)) == null)
        {
            if(cursor != null)
                cursor.close();
            return null;
        }
        MessageNano messagenano1 = MessageNano.mergeFrom(messagenano, abyte0);
        if(cursor != null)
            cursor.close();
        return messagenano1;
        String s1;
        Log.e(TAG, (new StringBuilder(50 + String.valueOf(s1 = String.valueOf(uri)).length())).append("Invalid params result from ContentProvider query: ").append(s1).toString());
        if(cursor != null)
            cursor.close();
        return null;
        Object obj;
        obj;
        Log.e(TAG, "Error reading params from ContentProvider", ((Throwable) (obj)));
        if(cursor != null)
            cursor.close();
        return null;
        Exception exception;
        exception;
        if(cursor != null)
            cursor.close();
        throw exception;
    }

    private boolean writeParams(MessageNano messagenano, Uri uri)
    {
        int i;
        if(messagenano == null)
        {
            i = client.delete(uri, null, null);
        } else
        {
            ContentValues contentvalues = new ContentValues();
            byte abyte0[] = MessageNano.toByteArray(messagenano);
            contentvalues.put("value", abyte0);
            i = client.update(uri, contentvalues, null, null);
        }
        if(i > 0)
            return true;
        return false;
        Object obj;
        obj;
        Log.e(TAG, "Failed to write params to ContentProvider", ((Throwable) (obj)));
        return false;
        obj;
        Log.e(TAG, "Insufficient permissions to write params to ContentProvider", ((Throwable) (obj)));
        return false;
    }

    private static final String TAG = com/google/vr/cardboard/ContentProviderVrParamsProvider.getSimpleName();
    private final ContentProviderClient client;
    private final Uri deviceParamsSettingUri;
    private final Uri userPrefsUri;
    private final Uri phoneParamsSettingUri;
    private final Uri sdkConfigurationParamsSettingUri;

}
