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
        return cachedsize;
    }

    public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
        throws IOException
    {
        if(mediaLengthSeconds != null)
            codedoutputbytebuffernano.writeInt64(1, mediaLengthSeconds.longValue());
        if(sampleRate != null)
            codedoutputbytebuffernano.writeInt32(2, sampleRate.intValue());
        if(audioBitRate != null)
            codedoutputbytebuffernano.writeInt32(3, audioBitRate.intValue());
        if(audioCodec != null)
            codedoutputbytebuffernano.writeInt32(4, audioCodec.intValue());
        if(audioChannelCount != null)
            codedoutputbytebuffernano.writeInt32(5, audioChannelCount.intValue());
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(mediaLengthSeconds != null)
            i += CodedOutputByteBufferNano.computeInt64Size(1, mediaLengthSeconds.longValue());
        if(sampleRate != null)
            i += CodedOutputByteBufferNano.computeInt32Size(2, sampleRate.intValue());
        if(audioBitRate != null)
            i += CodedOutputByteBufferNano.computeInt32Size(3, audioBitRate.intValue());
        if(audioCodec != null)
            i += CodedOutputByteBufferNano.computeInt32Size(4, audioCodec.intValue());
        if(audioChannelCount != null)
            i += CodedOutputByteBufferNano.computeInt32Size(5, audioChannelCount.intValue());
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
                continue;

            case 8: // '\b'
                clone1.mediaLengthSeconds = Long.valueOf(codedinputbytebuffernano1.readInt64());
                continue;

            case 16: // '\020'
                clone1.sampleRate = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                continue;

            case 24: // '\030'
                clone1.audioBitRate = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                continue;

            case 32: // ' '
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

            case 40: // '('
                clone1.audioChannelCount = Integer.valueOf(codedinputbytebuffernano1.readInt32());
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
    private Integer sampleRate;
    private Integer audioBitRate;
    private Integer audioCodec;
    private Integer audioChannelCount;

    public ()
    {
         ;
        ( = this).mediaLengthSeconds = null;
        .sampleRate = null;
        .audioBitRate = null;
        .audioChannelCount = null;
        .unknownFieldData = null;
        .cachedSize = -1;
    }
}
