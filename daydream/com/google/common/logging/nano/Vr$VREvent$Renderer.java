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
        if(glVendor != null)
            codedoutputbytebuffernano.writeString(1, glVendor);
        if(glRenderer != null)
            codedoutputbytebuffernano.writeString(2, glRenderer);
        if(glVersion != null)
            codedoutputbytebuffernano.writeString(3, glVersion);
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(glVendor != null)
            i += CodedOutputByteBufferNano.computeStringSize(1, glVendor);
        if(glRenderer != null)
            i += CodedOutputByteBufferNano.computeStringSize(2, glRenderer);
        if(glVersion != null)
            i += CodedOutputByteBufferNano.computeStringSize(3, glVersion);
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
                clone1.glVendor = codedinputbytebuffernano1.readString();
                break;

            case 18: // '\022'
                clone1.glRenderer = codedinputbytebuffernano1.readString();
                break;

            case 26: // '\032'
                clone1.glVersion = codedinputbytebuffernano1.readString();
                break;
            }
        while(true);
    }

    public final volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    private String glVendor;
    private String glRenderer;
    private String glVersion;

    public ()
    {
         ;
        ( = this).glVendor = null;
        .glRenderer = null;
        .glVersion = null;
        .unknownFieldData = null;
        .cachedSize = -1;
    }
}
