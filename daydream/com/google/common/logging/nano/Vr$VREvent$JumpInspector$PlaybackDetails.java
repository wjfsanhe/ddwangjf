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
        if(videoPlayback != null)
            cachedsize.videoPlayback = videoPlayback.clone();
        if(imagePlayback != null)
            cachedsize.imagePlayback = imagePlayback.clone();
        return cachedsize;
    }

    public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
        throws IOException
    {
        if(playbackState != null)
            codedoutputbytebuffernano.writeInt32(1, playbackState.intValue());
        if(playbackDurationSeconds != null)
            codedoutputbytebuffernano.writeInt64(2, playbackDurationSeconds.longValue());
        if(playbackEngine != null)
            codedoutputbytebuffernano.writeInt32(3, playbackEngine.intValue());
        if(videoPlayback != null)
            codedoutputbytebuffernano.writeMessage(4, videoPlayback);
        if(imagePlayback != null)
            codedoutputbytebuffernano.writeMessage(5, imagePlayback);
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(playbackState != null)
            i += CodedOutputByteBufferNano.computeInt32Size(1, playbackState.intValue());
        if(playbackDurationSeconds != null)
            i += CodedOutputByteBufferNano.computeInt64Size(2, playbackDurationSeconds.longValue());
        if(playbackEngine != null)
            i += CodedOutputByteBufferNano.computeInt32Size(3, playbackEngine.intValue());
        if(videoPlayback != null)
            i += CodedOutputByteBufferNano.computeMessageSize(4, videoPlayback);
        if(imagePlayback != null)
            i += CodedOutputByteBufferNano.computeMessageSize(5, imagePlayback);
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
                switch(j = codedinputbytebuffernano1.readInt32())
                {
                case 0: // '\0'
                case 1: // '\001'
                case 2: // '\002'
                case 3: // '\003'
                    clone1.playbackState = Integer.valueOf(j);
                    break;
                }
                break;

            case 16: // '\020'
                clone1.playbackDurationSeconds = Long.valueOf(codedinputbytebuffernano1.readInt64());
                break;

            case 24: // '\030'
                switch(j = codedinputbytebuffernano1.readInt32())
                {
                case 0: // '\0'
                case 1: // '\001'
                case 2: // '\002'
                    clone1.playbackEngine = Integer.valueOf(j);
                    break;
                }
                break;

            case 34: // '"'
                if(clone1.videoPlayback == null)
                    clone1.videoPlayback = new ails();
                codedinputbytebuffernano1.readMessage(clone1.videoPlayback);
                break;

            case 42: // '*'
                if(clone1.imagePlayback == null)
                    clone1.imagePlayback = new ails();
                codedinputbytebuffernano1.readMessage(clone1.imagePlayback);
                break;
            }
        while(true);
    }

    public final volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    private Integer playbackState;
    private Long playbackDurationSeconds;
    private Integer playbackEngine;
    private ails videoPlayback;
    private ails imagePlayback;

    public ails()
    {
        ails ails;
        (ails = this).playbackDurationSeconds = null;
        ails.videoPlayback = null;
        ails.imagePlayback = null;
        ails.unknownFieldData = null;
        ails.cachedSize = -1;
    }
}
