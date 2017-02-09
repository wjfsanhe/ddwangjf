// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ConfigUtils.java

package com.google.vr.cardboard;

import android.net.Uri;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice;
import com.google.vrtoolkit.cardboard.proto.nano.Phone;
import java.io.*;
import java.nio.ByteBuffer;

public class ConfigUtils
{

    public ConfigUtils()
    {
    }

    public static com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams readDeviceParamsFromExternalStorage()
    {
        com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams deviceparams;
        return deviceparams = (com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams)readFromExternalStorage(com/google/vrtoolkit/cardboard/proto/nano/CardboardDevice$DeviceParams, "current_device_params", 0x35587a2b, true);
    }

    public static com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams readDeviceParamsFromUri(Uri uri)
    {
        String s;
        if((s = uri.getQueryParameter("p")) == null)
        {
            Log.w(TAG, "No Cardboard parameters in URI.");
            return null;
        }
        byte abyte0[] = Base64.decode(s, 11);
        com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams deviceparams;
        return deviceparams = (com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams)MessageNano.mergeFrom(new com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams(), abyte0);
        Exception exception;
        exception;
        String s1;
        Log.w(TAG, (new StringBuilder(46 + String.valueOf(s1 = String.valueOf(exception)).length())).append("Parsing cardboard parameters from URI failed: ").append(s1).toString());
        return null;
    }

    public static com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams readPhoneParamsFromExternalStorage()
    {
        com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams phoneparams;
        return phoneparams = (com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams)readFromExternalStorage(com/google/vrtoolkit/cardboard/proto/nano/Phone$PhoneParams, "phone_params", 0x2e765996, false);
    }

    public static boolean writeDeviceParamsToExternalStorage(com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams deviceparams)
    {
        boolean flag;
        if(!(flag = writeToExternalStorage(deviceparams, "current_device_params", 0x35587a2b)))
            Log.e(TAG, "Could not write Cardboard parameters to external storage.");
        return flag;
    }

    public static boolean writePhoneParamsToExternalStorage(com.google.vrtoolkit.cardboard.proto.nano.Phone.PhoneParams phoneparams)
    {
        if(phoneparams.dEPRECATEDGyroBias != null && phoneparams.dEPRECATEDGyroBias.length == 0)
            (phoneparams = phoneparams.clone()).dEPRECATEDGyroBias = (new float[] {
                0.0F, 0.0F, 0.0F
            });
        boolean flag;
        if(!(flag = writeToExternalStorage(phoneparams, "phone_params", 0x2e765996)))
            Log.e(TAG, "Could not write Phone parameters to external storage.");
        return flag;
    }

    public static boolean removeDeviceParamsFromExternalStorage()
    {
        boolean flag = false;
        File file;
        String s;
        try
        {
            flag = (file = getConfigFile("current_device_params")).exists() ? file.delete() : true;
        }
        catch(IllegalStateException illegalstateexception)
        {
            Log.w(TAG, (new StringBuilder(34 + String.valueOf(s = String.valueOf(illegalstateexception)).length())).append("Error clearing device parameters: ").append(s).toString());
        }
        if(!flag)
            Log.e(TAG, "Could not clear Cardboard parameters from external storage.");
        return flag;
    }

    private static File getConfigFile(String s)
        throws IllegalStateException
    {
        File file;
        if(!(file = new File(Environment.getExternalStorageDirectory(), "Cardboard")).exists())
            file.mkdirs();
        else
        if(!file.isDirectory())
        {
            String s1 = String.valueOf(file);
            throw new IllegalStateException((new StringBuilder(61 + String.valueOf(s1).length())).append(s1).append(" already exists as a file, but is expected to be a directory.").toString());
        }
        return new File(file, s);
    }

    private static MessageNano readFromExternalStorage(Class class1, String s, int i, boolean flag)
    {
        BufferedInputStream bufferedinputstream = null;
        Object obj1;
        bufferedinputstream = new BufferedInputStream(new FileInputStream(getConfigFile(s)));
        obj1 = readFromInputStream(class1, bufferedinputstream, i);
        try
        {
            bufferedinputstream.close();
        }
        catch(IOException _ex) { }
        return ((MessageNano) (obj1));
        Exception exception;
        exception;
        if(bufferedinputstream != null)
            try
            {
                bufferedinputstream.close();
            }
            catch(IOException _ex) { }
        throw exception;
        Object obj;
        obj;
        if(flag)
            Log.d(TAG, (new StringBuilder(39 + String.valueOf(obj1 = String.valueOf(obj)).length())).append("Parameters file not found for reading: ").append(((String) (obj1))).toString());
        break MISSING_BLOCK_LABEL_166;
        obj;
        Log.w(TAG, (new StringBuilder(26 + String.valueOf(obj1 = String.valueOf(obj)).length())).append("Error reading parameters: ").append(((String) (obj1))).toString());
        return null;
    }

    private static MessageNano readFromInputStream(Class class1, InputStream inputstream, int i)
    {
        if(inputstream == null)
            return null;
        ByteBuffer bytebuffer;
        bytebuffer = ByteBuffer.allocate(8);
        if(inputstream.read(bytebuffer.array(), 0, bytebuffer.array().length) != -1)
            break MISSING_BLOCK_LABEL_41;
        Log.e(TAG, "Error parsing param record: end of stream.");
        return null;
        int k;
        int j = bytebuffer.getInt();
        k = bytebuffer.getInt();
        if(j == i)
            break MISSING_BLOCK_LABEL_70;
        Log.e(TAG, "Error parsing param record: incorrect sentinel.");
        return null;
        byte abyte0[];
        abyte0 = new byte[k];
        if(inputstream.read(abyte0, 0, k) != -1)
            break MISSING_BLOCK_LABEL_100;
        Log.e(TAG, "Error parsing param record: end of stream.");
        return null;
        return MessageNano.mergeFrom((MessageNano)class1.newInstance(), abyte0);
        Object obj;
        obj;
        TAG;
        "Error parsing protocol buffer: ";
        String s = String.valueOf(((InvalidProtocolBufferNanoException) (obj)).toString());
        s;
        if(s.length() == 0) goto _L2; else goto _L1
_L1:
        concat();
          goto _L3
_L2:
        JVM INSTR pop ;
        JVM INSTR new #51  <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
_L3:
        Log.w();
        JVM INSTR pop ;
        break MISSING_BLOCK_LABEL_278;
        obj;
        TAG;
        "Error reading parameters: ";
        String s1 = String.valueOf(((IOException) (obj)).toString());
        s1;
        if(s1.length() == 0) goto _L5; else goto _L4
_L4:
        concat();
          goto _L6
_L5:
        JVM INSTR pop ;
        JVM INSTR new #51  <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
_L6:
        Log.w();
        JVM INSTR pop ;
        break MISSING_BLOCK_LABEL_278;
        obj;
        TAG;
        "Error creating parameters: ";
        String s2 = String.valueOf(((InstantiationException) (obj)).toString());
        s2;
        if(s2.length() == 0) goto _L8; else goto _L7
_L7:
        concat();
          goto _L9
_L8:
        JVM INSTR pop ;
        JVM INSTR new #51  <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
_L9:
        Log.w();
        JVM INSTR pop ;
        break MISSING_BLOCK_LABEL_278;
        obj;
        TAG;
        "Error accessing parameter type: ";
        String s3 = String.valueOf(((IllegalAccessException) (obj)).toString());
        s3;
        if(s3.length() == 0) goto _L11; else goto _L10
_L10:
        concat();
          goto _L12
_L11:
        JVM INSTR pop ;
        JVM INSTR new #51  <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
_L12:
        Log.w();
        JVM INSTR pop ;
        return null;
    }

    private static boolean writeToExternalStorage(MessageNano messagenano, String s, int i)
    {
        boolean flag;
        BufferedOutputStream bufferedoutputstream;
        flag = false;
        bufferedoutputstream = null;
        bufferedoutputstream = new BufferedOutputStream(new FileOutputStream(getConfigFile(s)));
        flag = writeToOutputStream(messagenano, bufferedoutputstream, i);
        try
        {
            bufferedoutputstream.close();
        }
        catch(IOException _ex) { }
        break MISSING_BLOCK_LABEL_194;
        Object obj;
        obj;
        String s1;
        Log.e(TAG, (new StringBuilder(39 + String.valueOf(s1 = String.valueOf(obj)).length())).append("Parameters file not found for writing: ").append(s1).toString());
        if(bufferedoutputstream != null)
            try
            {
                bufferedoutputstream.close();
            }
            catch(IOException _ex) { }
        break MISSING_BLOCK_LABEL_194;
        obj;
        Log.w(TAG, (new StringBuilder(26 + String.valueOf(s1 = String.valueOf(obj)).length())).append("Error writing parameters: ").append(s1).toString());
        if(bufferedoutputstream != null)
            try
            {
                bufferedoutputstream.close();
            }
            catch(IOException _ex) { }
        break MISSING_BLOCK_LABEL_194;
        Exception exception;
        exception;
        if(bufferedoutputstream != null)
            try
            {
                bufferedoutputstream.close();
            }
            catch(IOException _ex) { }
        throw exception;
        return flag;
    }

    private static boolean writeToOutputStream(MessageNano messagenano, OutputStream outputstream, int i)
    {
        byte abyte0[] = MessageNano.toByteArray(messagenano);
        ByteBuffer bytebuffer;
        (bytebuffer = ByteBuffer.allocate(8)).putInt(i);
        bytebuffer.putInt(abyte0.length);
        outputstream.write(bytebuffer.array());
        outputstream.write(abyte0);
        return true;
        IOException ioexception;
        ioexception;
        TAG;
        "Error writing parameters: ";
        String s = String.valueOf(ioexception.toString());
        s;
        if(s.length() == 0) goto _L2; else goto _L1
_L1:
        concat();
          goto _L3
_L2:
        JVM INSTR pop ;
        JVM INSTR new #51  <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
_L3:
        Log.w();
        JVM INSTR pop ;
        return false;
    }

    private static final boolean DEBUG = false;
    private static final String TAG = com/google/vr/cardboard/ConfigUtils.getSimpleName();
    private static final int CARDBOARD_PHONE_PARAMS_STREAM_SENTINEL = 0x2e765996;
    public static final String URI_KEY_PARAMS = "p";
    public static final String CARDBOARD_CONFIG_FOLDER = "Cardboard";
    private static final String CARDBOARD_DEVICE_PARAMS_FILE = "current_device_params";
    private static final String CARDBOARD_PHONE_PARAMS_FILE = "phone_params";
    private static final int CARDBOARD_DEVICE_PARAMS_STREAM_SENTINEL = 0x35587a2b;

}
