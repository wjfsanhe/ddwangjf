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
        PanoSession.cachedSize cachedsize;
        try
        {
            cachedsize = (PanoSession.cachedSize)super.clone();
        }
        catch(CloneNotSupportedException clonenotsupportedexception)
        {
            throw new AssertionError(clonenotsupportedexception);
        }
        class PanoSession extends ExtendableMessageNano
            implements Cloneable
        {

            public final PanoSession clone()
            {
                PanoSession panosession;
                try
                {
                    panosession = (PanoSession)super.clone();
                }
                catch(CloneNotSupportedException clonenotsupportedexception1)
                {
                    throw new AssertionError(clonenotsupportedexception1);
                }
                return panosession;
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
                PanoSession panosession = this;
                int i;
                int j;
                do
                    switch(i = codedinputbytebuffernano1.readTag())
                    {
                    case 0: // '\0'
                        return panosession;

                    default:
                        if(!panosession.super.storeUnknownField(codedinputbytebuffernano1, i))
                            return panosession;
                        continue;

                    case 8: // '\b'
                        switch(j = codedinputbytebuffernano1.readInt32())
                        {
                        case 0: // '\0'
                        case 1: // '\001'
                        case 2: // '\002'
                        case 3: // '\003'
                        case 4: // '\004'
                            panosession.source = Integer.valueOf(j);
                            break;
                        }
                        break;

                    case 16: // '\020'
                        panosession.panosAvailable = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                        break;

                    case 24: // '\030'
                        panosession.panosViewed = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                        break;

                    case 32: // ' '
                        panosession.nodesNavigated = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                        break;

                    case 40: // '('
                        panosession.nextClicks = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                        break;

                    case 48: // '0'
                        panosession.prevClicks = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                        break;

                    case 56: // '8'
                        panosession.playPauseClicks = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                        break;

                    case 64: // '@'
                        panosession.infoClicks = Integer.valueOf(codedinputbytebuffernano1.readInt32());
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

            public PanoSession()
            {
                PanoSession panosession;
                (panosession = this).panosAvailable = null;
                panosession.panosViewed = null;
                panosession.nodesNavigated = null;
                panosession.nextClicks = null;
                panosession.prevClicks = null;
                panosession.playPauseClicks = null;
                panosession.infoClicks = null;
                panosession.unknownFieldData = null;
                panosession.cachedSize = -1;
            }
        }

        if(panoSession != null)
            cachedsize.panoSession = panoSession.clone();
        return cachedsize;
    }

    public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
        throws IOException
    {
        if(panoSession != null)
            codedoutputbytebuffernano.writeMessage(1, panoSession);
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(panoSession != null)
            i += CodedOutputByteBufferNano.computeMessageSize(1, panoSession);
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
        do
            switch(i = codedinputbytebuffernano1.readTag())
            {
            case 0: // '\0'
                return clone1;

            default:
                if(!clone1.super.storeUnknownField(codedinputbytebuffernano1, i))
                    return clone1;
                break;

            case 10: // '\n'
                if(clone1.panoSession == null)
                    clone1.panoSession = new PanoSession();
                codedinputbytebuffernano1.readMessage(clone1.panoSession);
                break;
            }
        while(true);
    }

    public final volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    private PanoSession panoSession;

    public PanoSession()
    {
        PanoSession panosession;
        (panosession = this).panoSession = null;
        panosession.unknownFieldData = null;
        panosession.cachedSize = -1;
    }
}
