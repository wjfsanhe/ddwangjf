// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GvrAudioEngine.java

package com.google.vr.sdk.audio;

import android.content.Context;

public class GvrAudioEngine
{
    public static abstract class DistanceRolloffModel
    {

        public static final int LOGARITHMIC = 0;
        public static final int LINEAR = 1;
        public static final int NONE = 2;

        public DistanceRolloffModel()
        {
        }
    }

    public static abstract class MaterialName
    {

        public static final int TRANSPARENT = 0;
        public static final int ACOUSTIC_CEILING_TILES = 1;
        public static final int BRICK_BARE = 2;
        public static final int BRICK_PAINTED = 3;
        public static final int CONCRETE_BLOCK_COARSE = 4;
        public static final int CONCRETE_BLOCK_PAINTED = 5;
        public static final int CURTAIN_HEAVY = 6;
        public static final int FIBER_GLASS_INSULATION = 7;
        public static final int GLASS_THIN = 8;
        public static final int GLASS_THICK = 9;
        public static final int GRASS = 10;
        public static final int LINOLEUM_ON_CONCRETE = 11;
        public static final int MARBLE = 12;
        public static final int METAL = 13;
        public static final int PARQUET_ON_CONCRETE = 14;
        public static final int PLASTER_ROUGH = 15;
        public static final int PLASTER_SMOOTH = 16;
        public static final int PLYWOOD_PANEL = 17;
        public static final int POLISHED_CONCRETE_OR_TILE = 18;
        public static final int SHEET_ROCK = 19;
        public static final int WATER_OR_ICE_SURFACE = 20;
        public static final int WOOD_CEILING = 21;
        public static final int WOOD_PANEL = 22;

        public MaterialName()
        {
        }
    }

    public static abstract class RenderingMode
    {

        public static final int STEREO_PANNING = 0;
        public static final int BINAURAL_LOW_QUALITY = 1;
        public static final int BINAURAL_HIGH_QUALITY = 2;

        public RenderingMode()
        {
        }
    }


    public GvrAudioEngine(Context context, int renderingMode)
    {
        if(nativeLibraryLoadException != null)
        {
            throw nativeLibraryLoadException;
        } else
        {
            vrAudioSystemRef = nativeInitialize(getClass().getClassLoader(), context.getApplicationContext(), renderingMode);
            return;
        }
    }

    private native long nativeInitialize(ClassLoader classloader, Context context, int i);

    protected void finalize()
        throws Throwable
    {
        nativeRelease(vrAudioSystemRef);
        super.finalize();
        break MISSING_BLOCK_LABEL_22;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    private native void nativeRelease(long l);

    public void update()
    {
        nativeUpdate(vrAudioSystemRef);
    }

    private native void nativeUpdate(long l);

    public void pause()
    {
        nativePause(vrAudioSystemRef);
    }

    private native void nativePause(long l);

    public void resume()
    {
        nativeResume(vrAudioSystemRef);
    }

    private native void nativeResume(long l);

    public boolean preloadSoundFile(String filename)
    {
        return nativePreloadSoundFile(vrAudioSystemRef, filename);
    }

    private native boolean nativePreloadSoundFile(long l, String s);

    public void unloadSoundFile(String filename)
    {
        nativeUnloadSoundFile(vrAudioSystemRef, filename);
    }

    private native void nativeUnloadSoundFile(long l, String s);

    public int createSoundObject(String filename)
    {
        return nativeCreateSoundObject(vrAudioSystemRef, filename);
    }

    private native int nativeCreateSoundObject(long l, String s);

    public int createSoundfield(String filename)
    {
        return nativeCreateSoundfield(vrAudioSystemRef, filename);
    }

    private native int nativeCreateSoundfield(long l, String s);

    public int createStereoSound(String filename)
    {
        return nativeCreateStereoSound(vrAudioSystemRef, filename);
    }

    private native int nativeCreateStereoSound(long l, String s);

    public void playSound(int sourceId, boolean loopingEnabled)
    {
        nativePlaySound(vrAudioSystemRef, sourceId, loopingEnabled);
    }

    private native void nativePlaySound(long l, int i, boolean flag);

    public void pauseSound(int sourceId)
    {
        nativePauseSound(vrAudioSystemRef, sourceId);
    }

    private native void nativePauseSound(long l, int i);

    public void resumeSound(int sourceId)
    {
        nativeResumeSound(vrAudioSystemRef, sourceId);
    }

    private native void nativeResumeSound(long l, int i);

    public void stopSound(int sourceId)
    {
        nativeStopSound(vrAudioSystemRef, sourceId);
    }

    private native void nativeStopSound(long l, int i);

    public boolean isSoundPlaying(int sourceId)
    {
        return nativeIsSoundPlaying(vrAudioSystemRef, sourceId);
    }

    private native boolean nativeIsSoundPlaying(long l, int i);

    public boolean isSourceIdValid(int sourceId)
    {
        return nativeIsSourceIdValid(vrAudioSystemRef, sourceId);
    }

    private native boolean nativeIsSourceIdValid(long l, int i);

    public void setSoundObjectPosition(int soundObjectId, float x, float y, float z)
    {
        nativeSetSoundObjectPosition(vrAudioSystemRef, soundObjectId, x, y, z);
    }

    private native void nativeSetSoundObjectPosition(long l, int i, float f, float f1, float f2);

    public void setSoundObjectDistanceRolloffModel(int soundObjectId, int rolloffModel, float minDistance, float maxDistance)
    {
        nativeSetSoundObjectDistanceRolloffModel(vrAudioSystemRef, soundObjectId, rolloffModel, minDistance, maxDistance);
    }

    private native void nativeSetSoundObjectDistanceRolloffModel(long l, int i, int j, float f, float f1);

    public void setSoundfieldRotation(int soundfieldId, float x, float y, float z, float w)
    {
        nativeSetSoundfieldRotation(vrAudioSystemRef, soundfieldId, x, y, z, w);
    }

    private native void nativeSetSoundfieldRotation(long l, int i, float f, float f1, float f2, float f3);

    public void setSoundVolume(int sourceId, float volume)
    {
        nativeSetSoundVolume(vrAudioSystemRef, sourceId, volume);
    }

    private native void nativeSetSoundVolume(long l, int i, float f);

    public void setHeadPosition(float x, float y, float z)
    {
        nativeSetHeadPosition(vrAudioSystemRef, x, y, z);
    }

    private native void nativeSetHeadPosition(long l, float f, float f1, float f2);

    public void setHeadRotation(float x, float y, float z, float w)
    {
        nativeSetHeadRotation(vrAudioSystemRef, x, y, z, w);
    }

    private native void nativeSetHeadRotation(long l, float f, float f1, float f2, float f3);

    public void enableRoom(boolean enable)
    {
        nativeEnableRoom(vrAudioSystemRef, enable);
    }

    private native void nativeEnableRoom(long l, boolean flag);

    public void setRoomProperties(float sizeX, float sizeY, float sizeZ, int wallMaterial, int ceilingMaterial, int floorMaterial)
    {
        nativeSetRoomProperties(vrAudioSystemRef, sizeX, sizeY, sizeZ, wallMaterial, ceilingMaterial, floorMaterial);
    }

    private native void nativeSetRoomProperties(long l, float f, float f1, float f2, int i, int j, 
            int k);

    public void setRoomReverbAdjustments(float gain, float timeAdjust, float brightnessAdjust)
    {
        nativeSetRoomReverbAdjustments(vrAudioSystemRef, gain, timeAdjust, brightnessAdjust);
    }

    private native void nativeSetRoomReverbAdjustments(long l, float f, float f1, float f2);

    public void enableSpeakerStereoMode(boolean enable)
    {
        nativeEnableStereoSpeakerMode(vrAudioSystemRef, enable);
    }

    private native void nativeEnableStereoSpeakerMode(long l, boolean flag);

    public static final int INVALID_ID = -1;
    private static UnsatisfiedLinkError nativeLibraryLoadException;
    private final long vrAudioSystemRef;

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
