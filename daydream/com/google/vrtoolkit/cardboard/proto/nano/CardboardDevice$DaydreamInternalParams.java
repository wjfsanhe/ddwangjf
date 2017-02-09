// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CardboardDevice.java

package com.google.vrtoolkit.cardboard.proto.nano;

import com.google.protobuf.nano.*;
import java.io.IOException;

// Referenced classes of package com.google.vrtoolkit.cardboard.proto.nano:
//            CardboardDevice

public static final class clear extends ExtendableMessageNano
    implements Cloneable
{

    public static clear[] emptyArray()
    {
        if(_emptyArray == null)
            synchronized(InternalNano.LAZY_INIT_LOCK)
            {
                if(_emptyArray == null)
                    _emptyArray = new _emptyArray[0];
            }
        return _emptyArray;
    }

    public final int getVersion()
    {
        return version_;
    }

    public final version_ setVersion(int i)
    {
        version_ = i;
        bitField0_ |= 1;
        return this;
    }

    public final boolean hasVersion()
    {
        return (bitField0_ & 1) != 0;
    }

    public final bitField0_ clearVersion()
    {
        version_ = 0;
        bitField0_ = bitField0_ & -2;
        return this;
    }

    public final bitField0_ clear()
    {
        bitField0_ = 0;
        version_ = 0;
        alignmentMarkers = mptyArray();
        unknownFieldData = null;
        cachedSize = -1;
        return this;
    }

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
        if(alignmentMarkers != null && alignmentMarkers.length > 0)
        {
            cachedsize.alignmentMarkers = new alignmentMarkers[alignmentMarkers.length];
            for(int i = 0; i < alignmentMarkers.length; i++)
                if(alignmentMarkers[i] != null)
                    cachedsize.alignmentMarkers[i] = alignmentMarkers[i].lone();

        }
        return cachedsize;
    }

    public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
        throws IOException
    {
        if((bitField0_ & 1) != 0)
            codedoutputbytebuffernano.writeInt32(1, version_);
        if(alignmentMarkers != null && alignmentMarkers.length > 0)
        {
            for(int i = 0; i < alignmentMarkers.length; i++)
            {
                lone lone;
                if((lone = alignmentMarkers[i]) != null)
                    codedoutputbytebuffernano.writeMessage(2, lone);
            }

        }
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if((bitField0_ & 1) != 0)
            i += CodedOutputByteBufferNano.computeInt32Size(1, version_);
        if(alignmentMarkers != null && alignmentMarkers.length > 0)
        {
            for(int j = 0; j < alignmentMarkers.length; j++)
            {
                alignmentMarkers alignmentmarkers;
                if((alignmentmarkers = alignmentMarkers[j]) != null)
                    i += CodedOutputByteBufferNano.computeMessageSize(2, alignmentmarkers);
            }

        }
        return i;
    }

    public final alignmentMarkers mergeFrom(CodedInputByteBufferNano codedinputbytebuffernano)
        throws IOException
    {
        int i;
        do
            switch(i = codedinputbytebuffernano.readTag())
            {
            case 0: // '\0'
                return this;

            default:
                if(!super.storeUnknownField(codedinputbytebuffernano, i))
                    return this;
                break;

            case 8: // '\b'
                version_ = codedinputbytebuffernano.readInt32();
                bitField0_ |= 1;
                break;

            case 18: // '\022'
                int j = WireFormatNano.getRepeatedFieldArrayLength(codedinputbytebuffernano, 18);
                int k;
                alignmentMarkers aalignmentmarkers[] = new bitField0_[(k = alignmentMarkers != null ? alignmentMarkers.length : 0) + j];
                if(k != 0)
                    System.arraycopy(alignmentMarkers, 0, aalignmentmarkers, 0, k);
                for(; k < aalignmentmarkers.length - 1; k++)
                {
                    aalignmentmarkers[k] = new init>();
                    codedinputbytebuffernano.readMessage(aalignmentmarkers[k]);
                    codedinputbytebuffernano.readTag();
                }

                aalignmentmarkers[k] = new init>();
                codedinputbytebuffernano.readMessage(aalignmentmarkers[k]);
                alignmentMarkers = aalignmentmarkers;
                break;
            }
        while(true);
    }

    public static alignmentMarkers parseFrom(byte abyte0[])
        throws InvalidProtocolBufferNanoException
    {
        return (alignmentMarkers)MessageNano.mergeFrom(new <init>(), abyte0);
    }

    public static <init> parseFrom(CodedInputByteBufferNano codedinputbytebuffernano)
        throws IOException
    {
        return (new <init>()).mergeFrom(codedinputbytebuffernano);
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

    public final volatile MessageNano mergeFrom(CodedInputByteBufferNano codedinputbytebuffernano)
        throws IOException
    {
        return mergeFrom(codedinputbytebuffernano);
    }

    public final volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    private static volatile clone _emptyArray[];
    private int bitField0_;
    private int version_;
    public clone alignmentMarkers[];

    public ()
    {
        clear();
    }
}
