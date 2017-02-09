// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Phone.java

package com.google.vrtoolkit.cardboard.proto.nano;

import com.google.protobuf.nano.*;
import java.io.IOException;

public interface Phone
{
    public static final class PhoneParams extends ExtendableMessageNano
        implements Cloneable
    {

        public static PhoneParams[] emptyArray()
        {
            if(_emptyArray == null)
                synchronized(InternalNano.LAZY_INIT_LOCK)
                {
                    if(_emptyArray == null)
                        _emptyArray = new PhoneParams[0];
                }
            return _emptyArray;
        }

        public final float getXPpi()
        {
            return xPpi_;
        }

        public final PhoneParams setXPpi(float f)
        {
            xPpi_ = f;
            bitField0_ |= 1;
            return this;
        }

        public final boolean hasXPpi()
        {
            return (bitField0_ & 1) != 0;
        }

        public final PhoneParams clearXPpi()
        {
            xPpi_ = 0.0F;
            bitField0_ = bitField0_ & -2;
            return this;
        }

        public final float getYPpi()
        {
            return yPpi_;
        }

        public final PhoneParams setYPpi(float f)
        {
            yPpi_ = f;
            bitField0_ |= 2;
            return this;
        }

        public final boolean hasYPpi()
        {
            return (bitField0_ & 2) != 0;
        }

        public final PhoneParams clearYPpi()
        {
            yPpi_ = 0.0F;
            bitField0_ = bitField0_ & -3;
            return this;
        }

        public final float getBottomBezelHeight()
        {
            return bottomBezelHeight_;
        }

        public final PhoneParams setBottomBezelHeight(float f)
        {
            bottomBezelHeight_ = f;
            bitField0_ |= 4;
            return this;
        }

        public final boolean hasBottomBezelHeight()
        {
            return (bitField0_ & 4) != 0;
        }

        public final PhoneParams clearBottomBezelHeight()
        {
            bottomBezelHeight_ = 0.0F;
            bitField0_ = bitField0_ & -5;
            return this;
        }

        public final PhoneParams clear()
        {
            bitField0_ = 0;
            xPpi_ = 0.0F;
            yPpi_ = 0.0F;
            bottomBezelHeight_ = 0.0F;
            dEPRECATEDGyroBias = WireFormatNano.EMPTY_FLOAT_ARRAY;
            unknownFieldData = null;
            cachedSize = -1;
            return this;
        }

        public final PhoneParams clone()
        {
            PhoneParams phoneparams;
            try
            {
                phoneparams = (PhoneParams)super.clone();
            }
            catch(CloneNotSupportedException clonenotsupportedexception)
            {
                throw new AssertionError(clonenotsupportedexception);
            }
            if(dEPRECATEDGyroBias != null && dEPRECATEDGyroBias.length > 0)
                phoneparams.dEPRECATEDGyroBias = (float[])dEPRECATEDGyroBias.clone();
            return phoneparams;
        }

        public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
            throws IOException
        {
            if((bitField0_ & 1) != 0)
                codedoutputbytebuffernano.writeFloat(1, xPpi_);
            if((bitField0_ & 2) != 0)
                codedoutputbytebuffernano.writeFloat(2, yPpi_);
            if((bitField0_ & 4) != 0)
                codedoutputbytebuffernano.writeFloat(3, bottomBezelHeight_);
            if(dEPRECATEDGyroBias != null && dEPRECATEDGyroBias.length > 0)
            {
                int i = 4 * dEPRECATEDGyroBias.length;
                codedoutputbytebuffernano.writeRawVarint32(34);
                codedoutputbytebuffernano.writeRawVarint32(i);
                for(int j = 0; j < dEPRECATEDGyroBias.length; j++)
                    codedoutputbytebuffernano.writeFloatNoTag(dEPRECATEDGyroBias[j]);

            }
            super.writeTo(codedoutputbytebuffernano);
        }

        protected final int computeSerializedSize()
        {
            int i = super.computeSerializedSize();
            if((bitField0_ & 1) != 0)
                i += CodedOutputByteBufferNano.computeFloatSize(1, xPpi_);
            if((bitField0_ & 2) != 0)
                i += CodedOutputByteBufferNano.computeFloatSize(2, yPpi_);
            if((bitField0_ & 4) != 0)
                i += CodedOutputByteBufferNano.computeFloatSize(3, bottomBezelHeight_);
            if(dEPRECATEDGyroBias != null && dEPRECATEDGyroBias.length > 0)
            {
                int j = 4 * dEPRECATEDGyroBias.length;
                i += j;
                i = ++i + CodedOutputByteBufferNano.computeRawVarint32Size(j);
            }
            return i;
        }

        public final PhoneParams mergeFrom(CodedInputByteBufferNano codedinputbytebuffernano)
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

                case 13: // '\r'
                    xPpi_ = codedinputbytebuffernano.readFloat();
                    bitField0_ |= 1;
                    break;

                case 21: // '\025'
                    yPpi_ = codedinputbytebuffernano.readFloat();
                    bitField0_ |= 2;
                    break;

                case 29: // '\035'
                    bottomBezelHeight_ = codedinputbytebuffernano.readFloat();
                    bitField0_ |= 4;
                    break;

                case 37: // '%'
                    int j = WireFormatNano.getRepeatedFieldArrayLength(codedinputbytebuffernano, 37);
                    int l;
                    float af[] = new float[(l = dEPRECATEDGyroBias != null ? dEPRECATEDGyroBias.length : 0) + j];
                    if(l != 0)
                        System.arraycopy(dEPRECATEDGyroBias, 0, af, 0, l);
                    for(; l < af.length - 1; l++)
                    {
                        af[l] = codedinputbytebuffernano.readFloat();
                        codedinputbytebuffernano.readTag();
                    }

                    af[l] = codedinputbytebuffernano.readFloat();
                    dEPRECATEDGyroBias = af;
                    break;

                case 34: // '"'
                    int k = codedinputbytebuffernano.readRawVarint32();
                    int i1 = codedinputbytebuffernano.pushLimit(k);
                    int j1 = k / 4;
                    int k1;
                    float af1[] = new float[(k1 = dEPRECATEDGyroBias != null ? dEPRECATEDGyroBias.length : 0) + j1];
                    if(k1 != 0)
                        System.arraycopy(dEPRECATEDGyroBias, 0, af1, 0, k1);
                    for(; k1 < af1.length; k1++)
                        af1[k1] = codedinputbytebuffernano.readFloat();

                    dEPRECATEDGyroBias = af1;
                    codedinputbytebuffernano.popLimit(i1);
                    break;
                }
            while(true);
        }

        public static PhoneParams parseFrom(byte abyte0[])
            throws InvalidProtocolBufferNanoException
        {
            return (PhoneParams)MessageNano.mergeFrom(new PhoneParams(), abyte0);
        }

        public static PhoneParams parseFrom(CodedInputByteBufferNano codedinputbytebuffernano)
            throws IOException
        {
            return (new PhoneParams()).mergeFrom(codedinputbytebuffernano);
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

        private static volatile PhoneParams _emptyArray[];
        private int bitField0_;
        private float xPpi_;
        private float yPpi_;
        private float bottomBezelHeight_;
        public float dEPRECATEDGyroBias[];

        public PhoneParams()
        {
            clear();
        }
    }

}
