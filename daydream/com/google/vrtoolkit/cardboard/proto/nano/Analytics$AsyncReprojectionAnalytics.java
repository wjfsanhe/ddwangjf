// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Analytics.java

package com.google.vrtoolkit.cardboard.proto.nano;

import com.google.protobuf.nano.*;
import java.io.IOException;

// Referenced classes of package com.google.vrtoolkit.cardboard.proto.nano:
//            Analytics

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

    public final int getTotalMissedVsyncs()
    {
        return totalMissedVsyncs_;
    }

    public final totalMissedVsyncs_ setTotalMissedVsyncs(int i)
    {
        totalMissedVsyncs_ = i;
        bitField0_ |= 1;
        return this;
    }

    public final boolean hasTotalMissedVsyncs()
    {
        return (bitField0_ & 1) != 0;
    }

    public final bitField0_ clearTotalMissedVsyncs()
    {
        totalMissedVsyncs_ = 0;
        bitField0_ = bitField0_ & -2;
        return this;
    }

    public final float getFps()
    {
        return fps_;
    }

    public final fps_ setFps(float f)
    {
        fps_ = f;
        bitField0_ |= 2;
        return this;
    }

    public final boolean hasFps()
    {
        return (bitField0_ & 2) != 0;
    }

    public final bitField0_ clearFps()
    {
        fps_ = 0.0F;
        bitField0_ = bitField0_ & -3;
        return this;
    }

    public final bitField0_ clear()
    {
        bitField0_ = 0;
        totalMissedVsyncs_ = 0;
        fps_ = 0.0F;
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
        return cachedsize;
    }

    public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
        throws IOException
    {
        if((bitField0_ & 1) != 0)
            codedoutputbytebuffernano.writeInt32(1, totalMissedVsyncs_);
        if((bitField0_ & 2) != 0)
            codedoutputbytebuffernano.writeFloat(2, fps_);
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if((bitField0_ & 1) != 0)
            i += CodedOutputByteBufferNano.computeInt32Size(1, totalMissedVsyncs_);
        if((bitField0_ & 2) != 0)
            i += CodedOutputByteBufferNano.computeFloatSize(2, fps_);
        return i;
    }

    public final fps_ mergeFrom(CodedInputByteBufferNano codedinputbytebuffernano)
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
                totalMissedVsyncs_ = codedinputbytebuffernano.readInt32();
                bitField0_ |= 1;
                break;

            case 21: // '\025'
                fps_ = codedinputbytebuffernano.readFloat();
                bitField0_ |= 2;
                break;
            }
        while(true);
    }

    public static bitField0_ parseFrom(byte abyte0[])
        throws InvalidProtocolBufferNanoException
    {
        return (bitField0_)MessageNano.mergeFrom(new <init>(), abyte0);
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
    private int totalMissedVsyncs_;
    private float fps_;

    public ()
    {
        clear();
    }
}
