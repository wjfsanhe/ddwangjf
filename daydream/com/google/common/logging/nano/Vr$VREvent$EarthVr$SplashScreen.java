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
        if(exitType != null)
            codedoutputbytebuffernano.writeInt32(1, exitType.intValue());
        if(numberOfViewPreloadsAttempted != null)
            codedoutputbytebuffernano.writeInt64(2, numberOfViewPreloadsAttempted.longValue());
        if(numberOfViewPreloadsSucceeded != null)
            codedoutputbytebuffernano.writeInt64(3, numberOfViewPreloadsSucceeded.longValue());
        if(viewPreloadDurationMs != null)
            codedoutputbytebuffernano.writeInt64(4, viewPreloadDurationMs.longValue());
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(exitType != null)
            i += CodedOutputByteBufferNano.computeInt32Size(1, exitType.intValue());
        if(numberOfViewPreloadsAttempted != null)
            i += CodedOutputByteBufferNano.computeInt64Size(2, numberOfViewPreloadsAttempted.longValue());
        if(numberOfViewPreloadsSucceeded != null)
            i += CodedOutputByteBufferNano.computeInt64Size(3, numberOfViewPreloadsSucceeded.longValue());
        if(viewPreloadDurationMs != null)
            i += CodedOutputByteBufferNano.computeInt64Size(4, viewPreloadDurationMs.longValue());
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
                    clone1.exitType = Integer.valueOf(j);
                    break;
                }
                break;

            case 16: // '\020'
                clone1.numberOfViewPreloadsAttempted = Long.valueOf(codedinputbytebuffernano1.readInt64());
                break;

            case 24: // '\030'
                clone1.numberOfViewPreloadsSucceeded = Long.valueOf(codedinputbytebuffernano1.readInt64());
                break;

            case 32: // ' '
                clone1.viewPreloadDurationMs = Long.valueOf(codedinputbytebuffernano1.readInt64());
                break;
            }
        while(true);
    }

    public final volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    private Integer exitType;
    private Long numberOfViewPreloadsAttempted;
    private Long numberOfViewPreloadsSucceeded;
    private Long viewPreloadDurationMs;

    public ()
    {
         ;
        ( = this).numberOfViewPreloadsAttempted = null;
        .numberOfViewPreloadsSucceeded = null;
        .viewPreloadDurationMs = null;
        .unknownFieldData = null;
        .cachedSize = -1;
    }
}
