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
        if(step != null)
            codedoutputbytebuffernano.writeInt32(1, step.intValue());
        if(previousStepState != null)
            codedoutputbytebuffernano.writeInt32(2, previousStepState.intValue());
        if(newStepState != null)
            codedoutputbytebuffernano.writeInt32(3, newStepState.intValue());
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(step != null)
            i += CodedOutputByteBufferNano.computeInt32Size(1, step.intValue());
        if(previousStepState != null)
            i += CodedOutputByteBufferNano.computeInt32Size(2, previousStepState.intValue());
        if(newStepState != null)
            i += CodedOutputByteBufferNano.computeInt32Size(3, newStepState.intValue());
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
                case 4: // '\004'
                case 5: // '\005'
                case 6: // '\006'
                case 7: // '\007'
                case 8: // '\b'
                    clone1.step = Integer.valueOf(j);
                    break;
                }
                break;

            case 16: // '\020'
                switch(j = codedinputbytebuffernano1.readInt32())
                {
                case 0: // '\0'
                case 1: // '\001'
                case 2: // '\002'
                case 3: // '\003'
                case 4: // '\004'
                    clone1.previousStepState = Integer.valueOf(j);
                    break;
                }
                break;

            case 24: // '\030'
                switch(j = codedinputbytebuffernano1.readInt32())
                {
                default:
                    break;

                case 0: // '\0'
                case 1: // '\001'
                case 2: // '\002'
                case 3: // '\003'
                case 4: // '\004'
                    clone1.newStepState = Integer.valueOf(j);
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

    private Integer step;
    private Integer previousStepState;
    private Integer newStepState;

    public ()
    {
         ;
        ( = this).unknownFieldData = null;
        .cachedSize = -1;
    }
}
