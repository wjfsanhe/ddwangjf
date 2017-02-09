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
        if(outcome != null)
            codedoutputbytebuffernano.writeInt32(1, outcome.intValue());
        if(angleDegrees != null)
            codedoutputbytebuffernano.writeFloat(2, angleDegrees.floatValue());
        if(withSound != null)
            codedoutputbytebuffernano.writeBool(3, withSound.booleanValue());
        if(captureWarnings != null)
            codedoutputbytebuffernano.writeBool(4, captureWarnings.booleanValue());
        if(compositionTimeMs != null)
            codedoutputbytebuffernano.writeInt64(5, compositionTimeMs.longValue());
        if(captureTimeMs != null)
            codedoutputbytebuffernano.writeInt64(6, captureTimeMs.longValue());
        if(processingTimeMs != null)
            codedoutputbytebuffernano.writeInt64(7, processingTimeMs.longValue());
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(outcome != null)
            i += CodedOutputByteBufferNano.computeInt32Size(1, outcome.intValue());
        if(angleDegrees != null)
            i += CodedOutputByteBufferNano.computeFloatSize(2, angleDegrees.floatValue());
        if(withSound != null)
            i += CodedOutputByteBufferNano.computeBoolSize(3, withSound.booleanValue());
        if(captureWarnings != null)
            i += CodedOutputByteBufferNano.computeBoolSize(4, captureWarnings.booleanValue());
        if(compositionTimeMs != null)
            i += CodedOutputByteBufferNano.computeInt64Size(5, compositionTimeMs.longValue());
        if(captureTimeMs != null)
            i += CodedOutputByteBufferNano.computeInt64Size(6, captureTimeMs.longValue());
        if(processingTimeMs != null)
            i += CodedOutputByteBufferNano.computeInt64Size(7, processingTimeMs.longValue());
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
                    clone1.outcome = Integer.valueOf(j);
                    break;
                }
                break;

            case 21: // '\025'
                clone1.angleDegrees = Float.valueOf(codedinputbytebuffernano1.readFloat());
                break;

            case 24: // '\030'
                clone1.withSound = Boolean.valueOf(codedinputbytebuffernano1.readBool());
                break;

            case 32: // ' '
                clone1.captureWarnings = Boolean.valueOf(codedinputbytebuffernano1.readBool());
                break;

            case 40: // '('
                clone1.compositionTimeMs = Long.valueOf(codedinputbytebuffernano1.readInt64());
                break;

            case 48: // '0'
                clone1.captureTimeMs = Long.valueOf(codedinputbytebuffernano1.readInt64());
                break;

            case 56: // '8'
                clone1.processingTimeMs = Long.valueOf(codedinputbytebuffernano1.readInt64());
                break;
            }
        while(true);
    }

    public final volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    private Integer outcome;
    private Float angleDegrees;
    private Boolean withSound;
    private Boolean captureWarnings;
    private Long compositionTimeMs;
    private Long captureTimeMs;
    private Long processingTimeMs;

    public ()
    {
         ;
        ( = this).angleDegrees = null;
        .withSound = null;
        .captureWarnings = null;
        .compositionTimeMs = null;
        .captureTimeMs = null;
        .processingTimeMs = null;
        .unknownFieldData = null;
        .cachedSize = -1;
    }
}
