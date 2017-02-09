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
        if(source != null)
            codedoutputbytebuffernano.writeInt32(1, source.intValue());
        if(panosAvailable != null)
            codedoutputbytebuffernano.writeInt32(2, panosAvailable.intValue());
        if(panosViewed != null)
            codedoutputbytebuffernano.writeInt32(3, panosViewed.intValue());
        if(nodesNavigated != null)
            codedoutputbytebuffernano.writeInt32(4, nodesNavigated.intValue());
        if(nextClicks != null)
            codedoutputbytebuffernano.writeInt32(5, nextClicks.intValue());
        if(prevClicks != null)
            codedoutputbytebuffernano.writeInt32(6, prevClicks.intValue());
        if(playPauseClicks != null)
            codedoutputbytebuffernano.writeInt32(7, playPauseClicks.intValue());
        if(infoClicks != null)
            codedoutputbytebuffernano.writeInt32(8, infoClicks.intValue());
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(source != null)
            i += CodedOutputByteBufferNano.computeInt32Size(1, source.intValue());
        if(panosAvailable != null)
            i += CodedOutputByteBufferNano.computeInt32Size(2, panosAvailable.intValue());
        if(panosViewed != null)
            i += CodedOutputByteBufferNano.computeInt32Size(3, panosViewed.intValue());
        if(nodesNavigated != null)
            i += CodedOutputByteBufferNano.computeInt32Size(4, nodesNavigated.intValue());
        if(nextClicks != null)
            i += CodedOutputByteBufferNano.computeInt32Size(5, nextClicks.intValue());
        if(prevClicks != null)
            i += CodedOutputByteBufferNano.computeInt32Size(6, prevClicks.intValue());
        if(playPauseClicks != null)
            i += CodedOutputByteBufferNano.computeInt32Size(7, playPauseClicks.intValue());
        if(infoClicks != null)
            i += CodedOutputByteBufferNano.computeInt32Size(8, infoClicks.intValue());
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
                switch(j = codedinputbytebuffernano1.readInt32())
                {
                case 0: // '\0'
                case 1: // '\001'
                case 2: // '\002'
                case 3: // '\003'
                case 4: // '\004'
                    clone1.source = Integer.valueOf(j);
                    break;
                }
                break;

            case 16: // '\020'
                clone1.panosAvailable = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                break;

            case 24: // '\030'
                clone1.panosViewed = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                break;

            case 32: // ' '
                clone1.nodesNavigated = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                break;

            case 40: // '('
                clone1.nextClicks = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                break;

            case 48: // '0'
                clone1.prevClicks = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                break;

            case 56: // '8'
                clone1.playPauseClicks = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                break;

            case 64: // '@'
                clone1.infoClicks = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                break;
            }
        while(true);
    }

    public final volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    private Integer source;
    private Integer panosAvailable;
    private Integer panosViewed;
    private Integer nodesNavigated;
    private Integer nextClicks;
    private Integer prevClicks;
    private Integer playPauseClicks;
    private Integer infoClicks;

    public ()
    {
         ;
        ( = this).panosAvailable = null;
        .panosViewed = null;
        .nodesNavigated = null;
        .nextClicks = null;
        .prevClicks = null;
        .playPauseClicks = null;
        .infoClicks = null;
        .unknownFieldData = null;
        .cachedSize = -1;
    }
}
