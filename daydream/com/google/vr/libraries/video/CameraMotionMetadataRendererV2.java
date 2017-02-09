// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CameraMotionMetadataRendererV2.java

package com.google.vr.libraries.video;

import android.util.Log;
import com.google.android.exoplayer2.*;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.nio.ByteBuffer;

// Referenced classes of package com.google.vr.libraries.video:
//            FrameRotationBuffer

public final class CameraMotionMetadataRendererV2 extends BaseRenderer
{

    public CameraMotionMetadataRendererV2()
    {
        super(4);
        inputStreamEnded = false;
        hasSample = false;
    }

    public void setFrameRotationBuffer(FrameRotationBuffer frameRotationBuffer)
    {
        this.frameRotationBuffer = frameRotationBuffer;
    }

    public int supportsFormat(Format format)
    {
        return format.sampleMimeType.equals("application/x-camera-motion") ? 3 : 0;
    }

    protected void onPositionReset(long positionUs, boolean joining)
    {
        hasSample = false;
        inputStreamEnded = false;
    }

    public void render(long positionUs, long elapsedRealtimeUs)
        throws ExoPlaybackException
    {
        if(frameRotationBuffer == null)
            throw new IllegalStateException("Callers must set the frame rotation buffer before rendering");
        if(!inputStreamEnded && !hasSample)
        {
            buffer.clear();
            int result = readSource(formatHolder, buffer);
            if(result == -4)
                if(buffer.isEndOfStream())
                {
                    inputStreamEnded = true;
                    Log.d("CameraMotionMetadataRenderer", "stream ended");
                } else
                {
                    hasSample = true;
                }
        }
        if(hasSample && buffer.timeUs <= positionUs + 0x186a0L)
        {
            try
            {
                buffer.flip();
                frameRotationBuffer.setRotation(buffer.timeUs, parseMetadata(buffer.data.array(), buffer.data.limit()));
            }
            catch(IOException e)
            {
                throw ExoPlaybackException.createForRenderer(e, getIndex());
            }
            hasSample = false;
        }
    }

    public boolean isEnded()
    {
        return inputStreamEnded;
    }

    public boolean isReady()
    {
        return true;
    }

    private static float[] parseMetadata(byte data[], int size)
        throws IOException
    {
        ParsableByteArray parsable = new ParsableByteArray(data, size);
        float result[] = new float[3];
        parsable.skipBytes(4);
        result[0] = Float.intBitsToFloat(parsable.readLittleEndianInt());
        result[1] = Float.intBitsToFloat(parsable.readLittleEndianInt());
        result[2] = Float.intBitsToFloat(parsable.readLittleEndianInt());
        return result;
    }

    private static final String TAG = "CameraMotionMetadataRenderer";
    private final FormatHolder formatHolder = new FormatHolder();
    private final DecoderInputBuffer buffer = new DecoderInputBuffer(1);
    private FrameRotationBuffer frameRotationBuffer;
    private boolean inputStreamEnded;
    private boolean hasSample;
}
