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

    public static cachedSize[] emptyArray()
    {
        if(_emptyArray == null)
            synchronized(InternalNano.LAZY_INIT_LOCK)
            {
                if(_emptyArray == null)
                    _emptyArray = new _emptyArray[0];
            }
        return _emptyArray;
    }

    public final _emptyArray clone()
    {
        _emptyArray _lemptyarray;
        try
        {
            _lemptyarray = (_emptyArray)super.clone();
        }
        catch(CloneNotSupportedException clonenotsupportedexception)
        {
            throw new AssertionError(clonenotsupportedexception);
        }
        return _lemptyarray;
    }

    public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
        throws IOException
    {
        if(gConfigKey != null)
            codedoutputbytebuffernano.writeString(1, gConfigKey);
        if(stringValue != null)
            codedoutputbytebuffernano.writeString(2, stringValue);
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(gConfigKey != null)
            i += CodedOutputByteBufferNano.computeStringSize(1, gConfigKey);
        if(stringValue != null)
            i += CodedOutputByteBufferNano.computeStringSize(2, stringValue);
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
                clone1.gConfigKey = codedinputbytebuffernano1.readString();
                break;

            case 18: // '\022'
                clone1.stringValue = codedinputbytebuffernano1.readString();
                break;
            }
        while(true);
    }

    public final volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    private static volatile clone _emptyArray[];
    private String gConfigKey;
    private String stringValue;

    public ()
    {
         ;
        ( = this).gConfigKey = null;
        .stringValue = null;
        .unknownFieldData = null;
        .cachedSize = -1;
    }
}
