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
        if(length != null)
            codedoutputbytebuffernano.writeInt32(2, length.intValue());
        if(layout != null)
            codedoutputbytebuffernano.writeString(3, layout);
        if(language != null)
            codedoutputbytebuffernano.writeString(4, language);
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(type != null)
            i += CodedOutputByteBufferNano.computeInt32Size(1, type.intValue());
        if(length != null)
            i += CodedOutputByteBufferNano.computeInt32Size(2, length.intValue());
        if(layout != null)
            i += CodedOutputByteBufferNano.computeStringSize(3, layout);
        if(language != null)
            i += CodedOutputByteBufferNano.computeStringSize(4, language);
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
                case 4: // '\004'
                case 5: // '\005'
                    clone1.type = Integer.valueOf(j);
                    break;
                }
                break;

            case 16: // '\020'
                clone1.length = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                break;

            case 26: // '\032'
                clone1.layout = codedinputbytebuffernano1.readString();
                break;

            case 34: // '"'
                clone1.language = codedinputbytebuffernano1.readString();
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
    private Integer length;
    private String layout;
    private String language;

    public ()
    {
         ;
        ( = this).length = null;
        .layout = null;
        .language = null;
        .unknownFieldData = null;
        .cachedSize = -1;
    }
}
