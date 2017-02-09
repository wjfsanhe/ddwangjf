// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GvrAudioSurround.java

package com.google.vr.sdk.audio;

import android.util.Log;
import java.nio.ByteBuffer;

public class GvrAudioSurround
{
    public static abstract class SurroundFormat
    {

        public static final int INVALID = 0;
        public static final int SURROUND_STEREO = 1;
        public static final int SURROUND_FIVE_DOT_ONE = 2;
        public static final int FIRST_ORDER_AMBISONICS = 3;
        public static final int SECOND_ORDER_AMBISONICS = 4;
        public static final int THIRD_ORDER_AMBISONICS = 5;

        public SurroundFormat()
        {
        }
    }


    public GvrAudioSurround(int surroundFormat, int sampleRateHz, int numInputChannels, int numFramesPerOutputBuffer)
    {
        vrAudioSystemRef = 0L;
        if(nativeLibraryLoadException != null)
        {
            throw nativeLibraryLoadException;
        } else
        {
            vrAudioSystemRef = nativeInitialize(surroundFormat, sampleRateHz, numInputChannels, numFramesPerOutputBuffer);
            this.numFramesPerOutputBuffer = numFramesPerOutputBuffer;
            this.numInputChannels = numInputChannels;
            return;
        }
    }

    private native long nativeInitialize(int i, int j, int k, int l);

    protected void finalize()
        throws Throwable
    {
        if(vrAudioSystemRef != 0L)
        {
            Log.w("GvrAudioSurround", "GvrAudioSurround not correctly released");
            release();
        }
        super.finalize();
        break MISSING_BLOCK_LABEL_35;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public void release()
    {
        nativeRelease(vrAudioSystemRef);
        vrAudioSystemRef = 0L;
    }

    private native void nativeRelease(long l);

    public int getAvailableInputSize()
    {
        return nativeGetAvailableInputSize(vrAudioSystemRef);
    }

    private native int nativeGetAvailableInputSize(long l);

    public int addInput(ByteBuffer inputBuffer, int offset, int size)
    {
        return nativeAddInput(vrAudioSystemRef, inputBuffer, offset, size);
    }

    private native int nativeAddInput(long l, ByteBuffer bytebuffer, int i, int j);

    public int getAvailableOutputSize()
    {
        return nativeGetAvailableOutputSize(vrAudioSystemRef);
    }

    private native int nativeGetAvailableOutputSize(long l);

    public int getOutput(ByteBuffer outputBuffer, int offset, int size)
    {
        return nativeGetOutput(vrAudioSystemRef, outputBuffer, offset, size);
    }

    private native int nativeGetOutput(long l, ByteBuffer bytebuffer, int i, int j);

    public boolean triggerProcessing()
    {
        return nativeTriggerProcessing(vrAudioSystemRef);
    }

    private native boolean nativeTriggerProcessing(long l);

    public void flush()
    {
        nativeFlush(vrAudioSystemRef);
    }

    private native void nativeFlush(long l);

    public void updateNativeOrientation(float w, float x, float y, float z)
    {
        nativeSetOrientationQuaternion(vrAudioSystemRef, w, x, y, z);
    }

    private native void nativeSetOrientationQuaternion(long l, float f, float f1, float f2, float f3);

    private static UnsatisfiedLinkError nativeLibraryLoadException;
    private long vrAudioSystemRef;
    private final int numFramesPerOutputBuffer;
    private final int numInputChannels;
    private static final String TAG = "GvrAudioSurround";
    private static final int NUM_STEREO_CHANNELS = 2;
    private static final int NUM_BYTES_PER_SAMPLE = 2;

    static 
    {
        try
        {
            nativeLibraryLoadException = null;
            System.loadLibrary("gvr_audio");
        }
        catch(UnsatisfiedLinkError exception)
        {
            nativeLibraryLoadException = exception;
        }
    }
}
