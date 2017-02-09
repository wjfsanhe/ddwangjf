// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Session.java

package com.google.vrtoolkit.cardboard.proto.nano;

import com.google.protobuf.nano.*;
import java.io.IOException;

// Referenced classes of package com.google.vrtoolkit.cardboard.proto.nano:
//            Session

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

    public final long getTimeSinceEpochSeconds()
    {
        return timeSinceEpochSeconds_;
    }

    public final timeSinceEpochSeconds_ setTimeSinceEpochSeconds(long l)
    {
        timeSinceEpochSeconds_ = l;
        bitField0_ |= 1;
        return this;
    }

    public final boolean hasTimeSinceEpochSeconds()
    {
        return (bitField0_ & 1) != 0;
    }

    public final bitField0_ clearTimeSinceEpochSeconds()
    {
        timeSinceEpochSeconds_ = 0L;
        bitField0_ = bitField0_ & -2;
        return this;
    }

    public final double getLastGyroscopeTimestamp()
    {
        return lastGyroscopeTimestamp_;
    }

    public final lastGyroscopeTimestamp_ setLastGyroscopeTimestamp(double d)
    {
        lastGyroscopeTimestamp_ = d;
        bitField0_ |= 2;
        return this;
    }

    public final boolean hasLastGyroscopeTimestamp()
    {
        return (bitField0_ & 2) != 0;
    }

    public final bitField0_ clearLastGyroscopeTimestamp()
    {
        lastGyroscopeTimestamp_ = 0.0D;
        bitField0_ = bitField0_ & -3;
        return this;
    }

    public final bitField0_ clear()
    {
        bitField0_ = 0;
        q = WireFormatNano.EMPTY_DOUBLE_ARRAY;
        timeSinceEpochSeconds_ = 0L;
        gyroscopeBias = WireFormatNano.EMPTY_DOUBLE_ARRAY;
        lensOffset = WireFormatNano.EMPTY_FLOAT_ARRAY;
        lastGyroscopeSample = WireFormatNano.EMPTY_DOUBLE_ARRAY;
        lastGyroscopeTimestamp_ = 0.0D;
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
        if(q != null && q.length > 0)
            cachedsize.q = (double[])q.clone();
        if(gyroscopeBias != null && gyroscopeBias.length > 0)
            cachedsize.gyroscopeBias = (double[])gyroscopeBias.clone();
        if(lensOffset != null && lensOffset.length > 0)
            cachedsize.lensOffset = (float[])lensOffset.clone();
        if(lastGyroscopeSample != null && lastGyroscopeSample.length > 0)
            cachedsize.lastGyroscopeSample = (double[])lastGyroscopeSample.clone();
        return cachedsize;
    }

    public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
        throws IOException
    {
        if(q != null && q.length > 0)
        {
            int i = 8 * q.length;
            codedoutputbytebuffernano.writeRawVarint32(10);
            codedoutputbytebuffernano.writeRawVarint32(i);
            for(int i1 = 0; i1 < q.length; i1++)
                codedoutputbytebuffernano.writeDoubleNoTag(q[i1]);

        }
        if((bitField0_ & 1) != 0)
            codedoutputbytebuffernano.writeInt64(2, timeSinceEpochSeconds_);
        if(gyroscopeBias != null && gyroscopeBias.length > 0)
        {
            int j = 8 * gyroscopeBias.length;
            codedoutputbytebuffernano.writeRawVarint32(26);
            codedoutputbytebuffernano.writeRawVarint32(j);
            for(int j1 = 0; j1 < gyroscopeBias.length; j1++)
                codedoutputbytebuffernano.writeDoubleNoTag(gyroscopeBias[j1]);

        }
        if(lensOffset != null && lensOffset.length > 0)
        {
            int k = 4 * lensOffset.length;
            codedoutputbytebuffernano.writeRawVarint32(34);
            codedoutputbytebuffernano.writeRawVarint32(k);
            for(int k1 = 0; k1 < lensOffset.length; k1++)
                codedoutputbytebuffernano.writeFloatNoTag(lensOffset[k1]);

        }
        if(lastGyroscopeSample != null && lastGyroscopeSample.length > 0)
        {
            int l = 8 * lastGyroscopeSample.length;
            codedoutputbytebuffernano.writeRawVarint32(42);
            codedoutputbytebuffernano.writeRawVarint32(l);
            for(int l1 = 0; l1 < lastGyroscopeSample.length; l1++)
                codedoutputbytebuffernano.writeDoubleNoTag(lastGyroscopeSample[l1]);

        }
        if((bitField0_ & 2) != 0)
            codedoutputbytebuffernano.writeDouble(6, lastGyroscopeTimestamp_);
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(q != null && q.length > 0)
        {
            int j = 8 * q.length;
            i += j;
            i = ++i + CodedOutputByteBufferNano.computeRawVarint32Size(j);
        }
        if((bitField0_ & 1) != 0)
            i += CodedOutputByteBufferNano.computeInt64Size(2, timeSinceEpochSeconds_);
        if(gyroscopeBias != null && gyroscopeBias.length > 0)
        {
            int k = 8 * gyroscopeBias.length;
            i += k;
            i = ++i + CodedOutputByteBufferNano.computeRawVarint32Size(k);
        }
        if(lensOffset != null && lensOffset.length > 0)
        {
            int l = 4 * lensOffset.length;
            i += l;
            i = ++i + CodedOutputByteBufferNano.computeRawVarint32Size(l);
        }
        if(lastGyroscopeSample != null && lastGyroscopeSample.length > 0)
        {
            int i1 = 8 * lastGyroscopeSample.length;
            i += i1;
            i = ++i + CodedOutputByteBufferNano.computeRawVarint32Size(i1);
        }
        if((bitField0_ & 2) != 0)
            i += CodedOutputByteBufferNano.computeDoubleSize(6, lastGyroscopeTimestamp_);
        return i;
    }

    public final lastGyroscopeTimestamp_ mergeFrom(CodedInputByteBufferNano codedinputbytebuffernano)
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

            case 9: // '\t'
                int j = WireFormatNano.getRepeatedFieldArrayLength(codedinputbytebuffernano, 9);
                int j2;
                double ad[] = new double[(j2 = q != null ? q.length : 0) + j];
                if(j2 != 0)
                    System.arraycopy(q, 0, ad, 0, j2);
                for(; j2 < ad.length - 1; j2++)
                {
                    ad[j2] = codedinputbytebuffernano.readDouble();
                    codedinputbytebuffernano.readTag();
                }

                ad[j2] = codedinputbytebuffernano.readDouble();
                q = ad;
                break;

            case 10: // '\n'
                int k = codedinputbytebuffernano.readRawVarint32();
                int k2 = codedinputbytebuffernano.pushLimit(k);
                int j4 = k / 8;
                int j5;
                double ad3[] = new double[(j5 = q != null ? q.length : 0) + j4];
                if(j5 != 0)
                    System.arraycopy(q, 0, ad3, 0, j5);
                for(; j5 < ad3.length; j5++)
                    ad3[j5] = codedinputbytebuffernano.readDouble();

                q = ad3;
                codedinputbytebuffernano.popLimit(k2);
                break;

            case 16: // '\020'
                timeSinceEpochSeconds_ = codedinputbytebuffernano.readInt64();
                bitField0_ |= 1;
                break;

            case 25: // '\031'
                int l = WireFormatNano.getRepeatedFieldArrayLength(codedinputbytebuffernano, 25);
                int l2;
                double ad1[] = new double[(l2 = gyroscopeBias != null ? gyroscopeBias.length : 0) + l];
                if(l2 != 0)
                    System.arraycopy(gyroscopeBias, 0, ad1, 0, l2);
                for(; l2 < ad1.length - 1; l2++)
                {
                    ad1[l2] = codedinputbytebuffernano.readDouble();
                    codedinputbytebuffernano.readTag();
                }

                ad1[l2] = codedinputbytebuffernano.readDouble();
                gyroscopeBias = ad1;
                break;

            case 26: // '\032'
                int i1 = codedinputbytebuffernano.readRawVarint32();
                int i3 = codedinputbytebuffernano.pushLimit(i1);
                int k4 = i1 / 8;
                int k5;
                double ad4[] = new double[(k5 = gyroscopeBias != null ? gyroscopeBias.length : 0) + k4];
                if(k5 != 0)
                    System.arraycopy(gyroscopeBias, 0, ad4, 0, k5);
                for(; k5 < ad4.length; k5++)
                    ad4[k5] = codedinputbytebuffernano.readDouble();

                gyroscopeBias = ad4;
                codedinputbytebuffernano.popLimit(i3);
                break;

            case 37: // '%'
                int j1 = WireFormatNano.getRepeatedFieldArrayLength(codedinputbytebuffernano, 37);
                int j3;
                float af[] = new float[(j3 = lensOffset != null ? lensOffset.length : 0) + j1];
                if(j3 != 0)
                    System.arraycopy(lensOffset, 0, af, 0, j3);
                for(; j3 < af.length - 1; j3++)
                {
                    af[j3] = codedinputbytebuffernano.readFloat();
                    codedinputbytebuffernano.readTag();
                }

                af[j3] = codedinputbytebuffernano.readFloat();
                lensOffset = af;
                break;

            case 34: // '"'
                int k1 = codedinputbytebuffernano.readRawVarint32();
                int k3 = codedinputbytebuffernano.pushLimit(k1);
                int l4 = k1 / 4;
                int l5;
                float af1[] = new float[(l5 = lensOffset != null ? lensOffset.length : 0) + l4];
                if(l5 != 0)
                    System.arraycopy(lensOffset, 0, af1, 0, l5);
                for(; l5 < af1.length; l5++)
                    af1[l5] = codedinputbytebuffernano.readFloat();

                lensOffset = af1;
                codedinputbytebuffernano.popLimit(k3);
                break;

            case 41: // ')'
                int l1 = WireFormatNano.getRepeatedFieldArrayLength(codedinputbytebuffernano, 41);
                int l3;
                double ad2[] = new double[(l3 = lastGyroscopeSample != null ? lastGyroscopeSample.length : 0) + l1];
                if(l3 != 0)
                    System.arraycopy(lastGyroscopeSample, 0, ad2, 0, l3);
                for(; l3 < ad2.length - 1; l3++)
                {
                    ad2[l3] = codedinputbytebuffernano.readDouble();
                    codedinputbytebuffernano.readTag();
                }

                ad2[l3] = codedinputbytebuffernano.readDouble();
                lastGyroscopeSample = ad2;
                break;

            case 42: // '*'
                int i2 = codedinputbytebuffernano.readRawVarint32();
                int i4 = codedinputbytebuffernano.pushLimit(i2);
                int i5 = i2 / 8;
                int i6;
                double ad5[] = new double[(i6 = lastGyroscopeSample != null ? lastGyroscopeSample.length : 0) + i5];
                if(i6 != 0)
                    System.arraycopy(lastGyroscopeSample, 0, ad5, 0, i6);
                for(; i6 < ad5.length; i6++)
                    ad5[i6] = codedinputbytebuffernano.readDouble();

                lastGyroscopeSample = ad5;
                codedinputbytebuffernano.popLimit(i4);
                break;

            case 49: // '1'
                lastGyroscopeTimestamp_ = codedinputbytebuffernano.readDouble();
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
    public double q[];
    private long timeSinceEpochSeconds_;
    public double gyroscopeBias[];
    public float lensOffset[];
    public double lastGyroscopeSample[];
    private double lastGyroscopeTimestamp_;

    public ()
    {
        clear();
    }
}
