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
        if(labelsState != null)
            codedoutputbytebuffernano.writeInt32(1, labelsState.intValue());
        if(comfortModeState != null)
            codedoutputbytebuffernano.writeInt32(2, comfortModeState.intValue());
        if(startConfiguration != null)
            codedoutputbytebuffernano.writeInt32(3, startConfiguration.intValue());
        if(guestMode != null)
            codedoutputbytebuffernano.writeInt32(4, guestMode.intValue());
        if(humanScaleMode != null)
            codedoutputbytebuffernano.writeInt32(5, humanScaleMode.intValue());
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(labelsState != null)
            i += CodedOutputByteBufferNano.computeInt32Size(1, labelsState.intValue());
        if(comfortModeState != null)
            i += CodedOutputByteBufferNano.computeInt32Size(2, comfortModeState.intValue());
        if(startConfiguration != null)
            i += CodedOutputByteBufferNano.computeInt32Size(3, startConfiguration.intValue());
        if(guestMode != null)
            i += CodedOutputByteBufferNano.computeInt32Size(4, guestMode.intValue());
        if(humanScaleMode != null)
            i += CodedOutputByteBufferNano.computeInt32Size(5, humanScaleMode.intValue());
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
                    clone1.labelsState = Integer.valueOf(j);
                    break;
                }
                break;

            case 16: // '\020'
                switch(j = codedinputbytebuffernano1.readInt32())
                {
                case 0: // '\0'
                case 1: // '\001'
                case 2: // '\002'
                    clone1.comfortModeState = Integer.valueOf(j);
                    break;
                }
                break;

            case 24: // '\030'
                switch(j = codedinputbytebuffernano1.readInt32())
                {
                case 0: // '\0'
                case 1: // '\001'
                case 2: // '\002'
                    clone1.startConfiguration = Integer.valueOf(j);
                    break;
                }
                break;

            case 32: // ' '
                switch(j = codedinputbytebuffernano1.readInt32())
                {
                case 0: // '\0'
                case 1: // '\001'
                case 2: // '\002'
                    clone1.guestMode = Integer.valueOf(j);
                    break;
                }
                break;

            case 40: // '('
                switch(j = codedinputbytebuffernano1.readInt32())
                {
                default:
                    break;

                case 0: // '\0'
                case 1: // '\001'
                case 2: // '\002'
                    clone1.humanScaleMode = Integer.valueOf(j);
                    break;
                }
                break;
            }
        while(true);
    }

    public final volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    private Integer labelsState;
    private Integer comfortModeState;
    private Integer startConfiguration;
    private Integer guestMode;
    private Integer humanScaleMode;

    public ()
    {
         ;
        ( = this).unknownFieldData = null;
        .cachedSize = -1;
    }
}
