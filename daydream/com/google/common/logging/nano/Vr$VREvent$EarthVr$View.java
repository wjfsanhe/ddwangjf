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
        if(startFromKeyholeTransform != null)
            cachedsize.startFromKeyholeTransform = startFromKeyholeTransform.clone();
        return cachedsize;
    }

    public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
        throws IOException
    {
        if(mode != null)
            codedoutputbytebuffernano.writeInt32(1, mode.intValue());
        if(startFromKeyholeTransform != null)
            codedoutputbytebuffernano.writeMessage(2, startFromKeyholeTransform);
        if(simulationSecondsSinceEpoch != null)
            codedoutputbytebuffernano.writeInt64(3, simulationSecondsSinceEpoch.longValue());
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(mode != null)
            i += CodedOutputByteBufferNano.computeInt32Size(1, mode.intValue());
        if(startFromKeyholeTransform != null)
            i += CodedOutputByteBufferNano.computeMessageSize(2, startFromKeyholeTransform);
        if(simulationSecondsSinceEpoch != null)
            i += CodedOutputByteBufferNano.computeInt64Size(3, simulationSecondsSinceEpoch.longValue());
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
                break;

            case 8: // '\b'
                switch(j = codedinputbytebuffernano1.readInt32())
                {
                case 0: // '\0'
                case 1: // '\001'
                case 2: // '\002'
                case 3: // '\003'
                    clone1.mode = Integer.valueOf(j);
                    break;
                }
                break;

            case 18: // '\022'
                if(clone1.startFromKeyholeTransform == null)
                    clone1.startFromKeyholeTransform = new onTransform();
                codedinputbytebuffernano1.readMessage(clone1.startFromKeyholeTransform);
                break;

            case 24: // '\030'
                clone1.simulationSecondsSinceEpoch = Long.valueOf(codedinputbytebuffernano1.readInt64());
                break;
            }
        while(true);
    }

    public final volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    private Integer mode;
    private onTransform startFromKeyholeTransform;
    private Long simulationSecondsSinceEpoch;

    public onTransform()
    {
        onTransform ontransform;
        (ontransform = this).startFromKeyholeTransform = null;
        ontransform.simulationSecondsSinceEpoch = null;
        ontransform.unknownFieldData = null;
        ontransform.cachedSize = -1;
    }
}
