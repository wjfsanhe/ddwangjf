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
        if(x != null)
            codedoutputbytebuffernano.writeFloat(1, x.floatValue());
        if(y != null)
            codedoutputbytebuffernano.writeFloat(2, y.floatValue());
        if(z != null)
            codedoutputbytebuffernano.writeFloat(3, z.floatValue());
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(x != null)
            i += CodedOutputByteBufferNano.computeFloatSize(1, x.floatValue());
        if(y != null)
            i += CodedOutputByteBufferNano.computeFloatSize(2, y.floatValue());
        if(z != null)
            i += CodedOutputByteBufferNano.computeFloatSize(3, z.floatValue());
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

            case 13: // '\r'
                clone1.x = Float.valueOf(codedinputbytebuffernano1.readFloat());
                break;

            case 21: // '\025'
                clone1.y = Float.valueOf(codedinputbytebuffernano1.readFloat());
                break;

            case 29: // '\035'
                clone1.z = Float.valueOf(codedinputbytebuffernano1.readFloat());
                break;
            }
        while(true);
    }

    public final volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    private Float x;
    private Float y;
    private Float z;

    public ()
    {
         ;
        ( = this).x = null;
        .y = null;
        .z = null;
        .unknownFieldData = null;
        .cachedSize = -1;
    }
}
