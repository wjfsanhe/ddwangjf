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
        if(flags != null)
            codedoutputbytebuffernano.writeInt64(1, flags.longValue());
        if(displayLatencyMicros != null)
            codedoutputbytebuffernano.writeInt64(2, displayLatencyMicros.longValue());
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(flags != null)
            i += CodedOutputByteBufferNano.computeInt64Size(1, flags.longValue());
        if(displayLatencyMicros != null)
            i += CodedOutputByteBufferNano.computeInt64Size(2, displayLatencyMicros.longValue());
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

            case 8: // '\b'
                clone1.flags = Long.valueOf(codedinputbytebuffernano1.readInt64());
                break;

            case 16: // '\020'
                clone1.displayLatencyMicros = Long.valueOf(codedinputbytebuffernano1.readInt64());
                break;
            }
        while(true);
    }

    public final volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    private Long flags;
    private Long displayLatencyMicros;

    public ()
    {
         ;
        ( = this).flags = null;
        .displayLatencyMicros = null;
        .unknownFieldData = null;
        .cachedSize = -1;
    }
}
