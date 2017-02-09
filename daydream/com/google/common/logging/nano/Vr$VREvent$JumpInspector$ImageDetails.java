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
        return cachedsize;
    }

    public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
        throws IOException
    {
        if(resolution != null)
            codedoutputbytebuffernano.writeMessage(1, resolution);
        if(usedMonoFilename != null)
            codedoutputbytebuffernano.writeBool(2, usedMonoFilename.booleanValue());
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(resolution != null)
            i += CodedOutputByteBufferNano.computeMessageSize(1, resolution);
        if(usedMonoFilename != null)
            i += CodedOutputByteBufferNano.computeBoolSize(2, usedMonoFilename.booleanValue());
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
                if(clone1.resolution == null)
                    clone1.resolution = new nit>();
                codedinputbytebuffernano1.readMessage(clone1.resolution);
                break;

            case 16: // '\020'
                clone1.usedMonoFilename = Boolean.valueOf(codedinputbytebuffernano1.readBool());
                break;
            }
        while(true);
    }

    public final volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    private clone resolution;
    private Boolean usedMonoFilename;

    public ()
    {
         ;
        ( = this).resolution = null;
        .usedMonoFilename = null;
        .unknownFieldData = null;
        .cachedSize = -1;
    }
}
