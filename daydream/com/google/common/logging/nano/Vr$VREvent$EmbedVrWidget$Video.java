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
        if(widthPixels != null)
            codedoutputbytebuffernano.writeInt32(1, widthPixels.intValue());
        if(heightPixels != null)
            codedoutputbytebuffernano.writeInt32(2, heightPixels.intValue());
        if(stereoFormat != null)
            codedoutputbytebuffernano.writeInt32(3, stereoFormat.intValue());
        if(videoDurationMs != null)
            codedoutputbytebuffernano.writeInt32(4, videoDurationMs.intValue());
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(widthPixels != null)
            i += CodedOutputByteBufferNano.computeInt32Size(1, widthPixels.intValue());
        if(heightPixels != null)
            i += CodedOutputByteBufferNano.computeInt32Size(2, heightPixels.intValue());
        if(stereoFormat != null)
            i += CodedOutputByteBufferNano.computeInt32Size(3, stereoFormat.intValue());
        if(videoDurationMs != null)
            i += CodedOutputByteBufferNano.computeInt32Size(4, videoDurationMs.intValue());
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
                clone1.widthPixels = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                continue;

            case 16: // '\020'
                clone1.heightPixels = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                continue;

            case 24: // '\030'
                switch(j = codedinputbytebuffernano1.readInt32())
                {
                case 0: // '\0'
                case 1: // '\001'
                case 2: // '\002'
                    clone1.stereoFormat = Integer.valueOf(j);
                    break;
                }
                break;

            case 32: // ' '
                clone1.videoDurationMs = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                break;
            }
        while(true);
    }

    public final volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    private Integer widthPixels;
    private Integer heightPixels;
    private Integer stereoFormat;
    private Integer videoDurationMs;

    public ()
    {
         ;
        ( = this).widthPixels = null;
        .heightPixels = null;
        .videoDurationMs = null;
        .unknownFieldData = null;
        .cachedSize = -1;
    }
}
