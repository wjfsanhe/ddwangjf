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
        clone clone1;
        CodedInputByteBufferNano codedinputbytebuffernano1;
        codedinputbytebuffernano1 = codedinputbytebuffernano;
        clone1 = this;
_L9:
        int i = codedinputbytebuffernano1.readTag();
        JVM INSTR lookupswitch 4: default 54
    //                   0: 52
    //                   8: 66
    //                   16: 80
    //                   24: 94;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        return clone1;
_L1:
        if(!clone1.super.storeUnknownField(codedinputbytebuffernano1, i))
            return clone1;
        continue; /* Loop/switch isn't completed */
_L3:
        clone1.widthPixels = Integer.valueOf(codedinputbytebuffernano1.readInt32());
        continue; /* Loop/switch isn't completed */
_L4:
        clone1.heightPixels = Integer.valueOf(codedinputbytebuffernano1.readInt32());
        continue; /* Loop/switch isn't completed */
_L5:
        int j = codedinputbytebuffernano1.readInt32();
        JVM INSTR tableswitch 0 2: default 137
    //                   0 128
    //                   1 128
    //                   2 128;
           goto _L6 _L7 _L7 _L7
_L6:
        continue; /* Loop/switch isn't completed */
_L7:
        clone1.stereoFormat = Integer.valueOf(j);
        if(true) goto _L9; else goto _L8
_L8:
    }

    public final volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    private Integer widthPixels;
    private Integer heightPixels;
    private Integer stereoFormat;

    public ()
    {
         ;
        ( = this).widthPixels = null;
        .heightPixels = null;
        .unknownFieldData = null;
        .cachedSize = -1;
    }
}
