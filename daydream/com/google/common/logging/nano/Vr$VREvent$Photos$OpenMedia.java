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
        if(type != null)
            codedoutputbytebuffernano.writeInt32(1, type.intValue());
        if(source != null)
            codedoutputbytebuffernano.writeInt32(2, source.intValue());
        if(isSample != null)
            codedoutputbytebuffernano.writeBool(3, isSample.booleanValue());
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(type != null)
            i += CodedOutputByteBufferNano.computeInt32Size(1, type.intValue());
        if(source != null)
            i += CodedOutputByteBufferNano.computeInt32Size(2, source.intValue());
        if(isSample != null)
            i += CodedOutputByteBufferNano.computeBoolSize(3, isSample.booleanValue());
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
                    clone1.type = Integer.valueOf(j);
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
                    clone1.source = Integer.valueOf(j);
                    break;
                }
                break;

            case 24: // '\030'
                clone1.isSample = Boolean.valueOf(codedinputbytebuffernano1.readBool());
                break;
            }
        while(true);
    }

    public final volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    private Integer type;
    private Integer source;
    private Boolean isSample;

    public ()
    {
         ;
        ( = this).isSample = null;
        .unknownFieldData = null;
        .cachedSize = -1;
    }
}
