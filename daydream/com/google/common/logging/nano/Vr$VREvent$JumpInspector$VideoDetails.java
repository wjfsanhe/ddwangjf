// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Vr.java

package com.google.common.logging.nano;

import com.google.protobuf.nano.*;
import java.io.IOException;

public final class cachedSize extends ExtendableMessageNano
    implements Cloneable
{

    public final cachedSize clone()
    {
        cachedSize cachedsize;
        try
        {
            cachedsize = (cachedSize)super.clone();
        }
        catch(CloneNotSupportedException clonenotsupportedexception)
        {
            throw new AssertionError(clonenotsupportedexception);
        }
        if(resolution != null)
            cachedsize.resolution = resolution.one();
        if(sphericalMetadata != null)
            cachedsize.sphericalMetadata = sphericalMetadata.clone();
        return cachedsize;
    }

    public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
        throws IOException
    {
        if(mediaLengthSeconds != null)
            codedoutputbytebuffernano.writeInt64(1, mediaLengthSeconds.longValue());
        if(resolution != null)
            codedoutputbytebuffernano.writeMessage(2, resolution);
        if(framesPerSecond != null)
            codedoutputbytebuffernano.writeDouble(3, framesPerSecond.doubleValue());
        if(sampleRate != null)
            codedoutputbytebuffernano.writeInt32(4, sampleRate.intValue());
        if(videoBitRate != null)
            codedoutputbytebuffernano.writeInt32(5, videoBitRate.intValue());
        if(audioBitRate != null)
            codedoutputbytebuffernano.writeInt32(6, audioBitRate.intValue());
        if(videoCodec != null)
            codedoutputbytebuffernano.writeInt32(7, videoCodec.intValue());
        if(audioCodec != null)
            codedoutputbytebuffernano.writeInt32(8, audioCodec.intValue());
        if(sphericalMetadata != null)
            codedoutputbytebuffernano.writeMessage(9, sphericalMetadata);
        if(audioChannelCount != null)
            codedoutputbytebuffernano.writeInt32(10, audioChannelCount.intValue());
        if(usedMonoFilename != null)
            codedoutputbytebuffernano.writeBool(11, usedMonoFilename.booleanValue());
        if(usedWalleFilename != null)
            codedoutputbytebuffernano.writeBool(12, usedWalleFilename.booleanValue());
        if(usedWallyFilename != null)
            codedoutputbytebuffernano.writeBool(13, usedWallyFilename.booleanValue());
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(mediaLengthSeconds != null)
            i += CodedOutputByteBufferNano.computeInt64Size(1, mediaLengthSeconds.longValue());
        if(resolution != null)
            i += CodedOutputByteBufferNano.computeMessageSize(2, resolution);
        if(framesPerSecond != null)
            i += CodedOutputByteBufferNano.computeDoubleSize(3, framesPerSecond.doubleValue());
        if(sampleRate != null)
            i += CodedOutputByteBufferNano.computeInt32Size(4, sampleRate.intValue());
        if(videoBitRate != null)
            i += CodedOutputByteBufferNano.computeInt32Size(5, videoBitRate.intValue());
        if(audioBitRate != null)
            i += CodedOutputByteBufferNano.computeInt32Size(6, audioBitRate.intValue());
        if(videoCodec != null)
            i += CodedOutputByteBufferNano.computeInt32Size(7, videoCodec.intValue());
        if(audioCodec != null)
            i += CodedOutputByteBufferNano.computeInt32Size(8, audioCodec.intValue());
        if(sphericalMetadata != null)
            i += CodedOutputByteBufferNano.computeMessageSize(9, sphericalMetadata);
        if(audioChannelCount != null)
            i += CodedOutputByteBufferNano.computeInt32Size(10, audioChannelCount.intValue());
        if(usedMonoFilename != null)
            i += CodedOutputByteBufferNano.computeBoolSize(11, usedMonoFilename.booleanValue());
        if(usedWalleFilename != null)
            i += CodedOutputByteBufferNano.computeBoolSize(12, usedWalleFilename.booleanValue());
        if(usedWallyFilename != null)
            i += CodedOutputByteBufferNano.computeBoolSize(13, usedWallyFilename.booleanValue());
        return i;
    }

    public final volatile ExtendableMessageNano clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public final volatile MessageNano clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public final MessageNano mergeFrom(CodedInputByteBufferNano codedinputbytebuffernano)
        throws IOException
    {
        CodedInputByteBufferNano codedinputbytebuffernano1 = codedinputbytebuffernano;
        clone clone1 = this;
        int i;
        int j;
        do
            switch(i = codedinputbytebuffernano1.readTag())
            {
            case 0: // '\0'
                return clone1;

            default:
                if(!clone1.super.storeUnknownField(codedinputbytebuffernano1, i))
                    return clone1;
                break;

            case 8: // '\b'
                clone1.mediaLengthSeconds = Long.valueOf(codedinputbytebuffernano1.readInt64());
                break;

            case 18: // '\022'
                if(clone1.resolution == null)
                    clone1.resolution = new nit>();
                codedinputbytebuffernano1.readMessage(clone1.resolution);
                break;

            case 25: // '\031'
                clone1.framesPerSecond = Double.valueOf(codedinputbytebuffernano1.readDouble());
                break;

            case 32: // ' '
                clone1.sampleRate = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                break;

            case 40: // '('
                clone1.videoBitRate = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                break;

            case 48: // '0'
                clone1.audioBitRate = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                break;

            case 56: // '8'
                switch(j = codedinputbytebuffernano1.readInt32())
                {
                case 0: // '\0'
                case 1: // '\001'
                case 2: // '\002'
                case 3: // '\003'
                case 4: // '\004'
                    clone1.videoCodec = Integer.valueOf(j);
                    break;
                }
                break;

            case 64: // '@'
                switch(j = codedinputbytebuffernano1.readInt32())
                {
                case 0: // '\0'
                case 1: // '\001'
                case 2: // '\002'
                case 3: // '\003'
                case 4: // '\004'
                    clone1.audioCodec = Integer.valueOf(j);
                    break;
                }
                break;

            case 74: // 'J'
                if(clone1.sphericalMetadata == null)
                    clone1.sphericalMetadata = new data();
                codedinputbytebuffernano1.readMessage(clone1.sphericalMetadata);
                break;

            case 80: // 'P'
                clone1.audioChannelCount = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                break;

            case 88: // 'X'
                clone1.usedMonoFilename = Boolean.valueOf(codedinputbytebuffernano1.readBool());
                break;

            case 96: // '`'
                clone1.usedWalleFilename = Boolean.valueOf(codedinputbytebuffernano1.readBool());
                break;

            case 104: // 'h'
                clone1.usedWallyFilename = Boolean.valueOf(codedinputbytebuffernano1.readBool());
                break;
            }
        while(true);
    }

    public final volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    private Long mediaLengthSeconds;
    private clone resolution;
    private Double framesPerSecond;
    private Integer sampleRate;
    private Integer videoBitRate;
    private Integer audioBitRate;
    private Integer videoCodec;
    private Integer audioCodec;
    private data sphericalMetadata;
    private Integer audioChannelCount;
    private Boolean usedMonoFilename;
    private Boolean usedWalleFilename;
    private Boolean usedWallyFilename;

    public data()
    {
        data data;
        (data = this).mediaLengthSeconds = null;
        data.resolution = null;
        data.framesPerSecond = null;
        data.sampleRate = null;
        data.videoBitRate = null;
        data.audioBitRate = null;
        data.sphericalMetadata = null;
        data.audioChannelCount = null;
        data.usedMonoFilename = null;
        data.usedWalleFilename = null;
        data.usedWallyFilename = null;
        data.unknownFieldData = null;
        data.cachedSize = -1;
    }
}
