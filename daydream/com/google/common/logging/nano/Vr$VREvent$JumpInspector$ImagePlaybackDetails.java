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
        if(playbackMode != null)
            codedoutputbytebuffernano.writeInt32(1, playbackMode.intValue());
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(playbackMode != null)
            i += CodedOutputByteBufferNano.computeInt32Size(1, playbackMode.intValue());
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
_L7:
        int i = codedinputbytebuffernano1.readTag();
        JVM INSTR lookupswitch 2: default 38
    //                   0: 36
    //                   8: 50;
           goto _L1 _L2 _L3
_L2:
        return clone1;
_L1:
        if(!clone1.super.storeUnknownField(codedinputbytebuffernano1, i))
            return clone1;
        continue; /* Loop/switch isn't completed */
_L3:
        int j = codedinputbytebuffernano1.readInt32();
        JVM INSTR tableswitch 0 2: default 93
    //                   0 84
    //                   1 84
    //                   2 84;
           goto _L4 _L5 _L5 _L5
_L4:
        continue; /* Loop/switch isn't completed */
_L5:
        clone1.playbackMode = Integer.valueOf(j);
        if(true) goto _L7; else goto _L6
_L6:
    }

    public final volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    private Integer playbackMode;

    public ()
    {
         ;
        ( = this).unknownFieldData = null;
        .cachedSize = -1;
    }
}
