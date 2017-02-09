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
    public static interface ButtonType
    {

        public static final int NONE = 0;
        public static final int MAGNET = 1;
        public static final int TOUCH = 2;
        public static final int INDIRECT_TOUCH = 3;
    }

    public static interface VerticalAlignmentType
    {

        public static final int BOTTOM = 0;
        public static final int CENTER = 1;
        public static final int TOP = 2;
    }


    public static VerticalAlignmentType[] emptyArray()
    {
        if(_emptyArray == null)
            synchronized(InternalNano.LAZY_INIT_LOCK)
            {
                if(_emptyArray == null)
                    _emptyArray = new _emptyArray[0];
            }
        return _emptyArray;
    }

    public final String getVendor()
    {
        return vendor_;
    }

    public final vendor_ setVendor(String s)
    {
        if(s == null)
        {
            throw new NullPointerException();
        } else
        {
            vendor_ = s;
            bitField0_ |= 1;
            return this;
        }
    }

    public final boolean hasVendor()
    {
        return (bitField0_ & 1) != 0;
    }

    public final bitField0_ clearVendor()
    {
        vendor_ = "";
        bitField0_ = bitField0_ & -2;
        return this;
    }

    public final String getModel()
    {
        return model_;
    }

    public final model_ setModel(String s)
    {
        if(s == null)
        {
            throw new NullPointerException();
        } else
        {
            model_ = s;
            bitField0_ |= 2;
            return this;
        }
    }

    public final boolean hasModel()
    {
        return (bitField0_ & 2) != 0;
    }

    public final bitField0_ clearModel()
    {
        model_ = "";
        bitField0_ = bitField0_ & -3;
        return this;
    }

    public final float getScreenToLensDistance()
    {
        return screenToLensDistance_;
    }

    public final screenToLensDistance_ setScreenToLensDistance(float f)
    {
        screenToLensDistance_ = f;
        bitField0_ |= 4;
        return this;
    }

    public final boolean hasScreenToLensDistance()
    {
        return (bitField0_ & 4) != 0;
    }

    public final bitField0_ clearScreenToLensDistance()
    {
        screenToLensDistance_ = 0.0F;
        bitField0_ = bitField0_ & -5;
        return this;
    }

    public final float getInterLensDistance()
    {
        return interLensDistance_;
    }

    public final interLensDistance_ setInterLensDistance(float f)
    {
        interLensDistance_ = f;
        bitField0_ |= 8;
        return this;
    }

    public final boolean hasInterLensDistance()
    {
        return (bitField0_ & 8) != 0;
    }

    public final bitField0_ clearInterLensDistance()
    {
        interLensDistance_ = 0.0F;
        bitField0_ = bitField0_ & -9;
        return this;
    }

    public final int getVerticalAlignment()
    {
        return verticalAlignment_;
    }

    public final verticalAlignment_ setVerticalAlignment(int i)
    {
        verticalAlignment_ = i;
        bitField0_ |= 0x10;
        return this;
    }

    public final boolean hasVerticalAlignment()
    {
        return (bitField0_ & 0x10) != 0;
    }

    public final bitField0_ clearVerticalAlignment()
    {
        verticalAlignment_ = 0;
        bitField0_ = bitField0_ & 0xffffffef;
        return this;
    }

    public final float getTrayToLensDistance()
    {
        return trayToLensDistance_;
    }

    public final trayToLensDistance_ setTrayToLensDistance(float f)
    {
        trayToLensDistance_ = f;
        bitField0_ |= 0x20;
        return this;
    }

    public final boolean hasTrayToLensDistance()
    {
        return (bitField0_ & 0x20) != 0;
    }

    public final bitField0_ clearTrayToLensDistance()
    {
        trayToLensDistance_ = 0.0F;
        bitField0_ = bitField0_ & 0xffffffdf;
        return this;
    }

    public final boolean getHasMagnet()
    {
        return hasMagnet_;
    }

    public final hasMagnet_ setHasMagnet(boolean flag)
    {
        hasMagnet_ = flag;
        bitField0_ |= 0x40;
        return this;
    }

    public final boolean hasHasMagnet()
    {
        return (bitField0_ & 0x40) != 0;
    }

    public final bitField0_ clearHasMagnet()
    {
        hasMagnet_ = false;
        bitField0_ = bitField0_ & 0xffffffbf;
        return this;
    }

    public final int getPrimaryButton()
    {
        return primaryButton_;
    }

    public final primaryButton_ setPrimaryButton(int i)
    {
        primaryButton_ = i;
        bitField0_ |= 0x80;
        return this;
    }

    public final boolean hasPrimaryButton()
    {
        return (bitField0_ & 0x80) != 0;
    }

    public final bitField0_ clearPrimaryButton()
    {
        primaryButton_ = 1;
        bitField0_ = bitField0_ & 0xffffff7f;
        return this;
    }

    public final bitField0_ clear()
    {
        bitField0_ = 0;
        vendor_ = "";
        model_ = "";
        screenToLensDistance_ = 0.0F;
        interLensDistance_ = 0.0F;
        leftEyeFieldOfViewAngles = WireFormatNano.EMPTY_FLOAT_ARRAY;
        verticalAlignment_ = 0;
        trayToLensDistance_ = 0.0F;
        distortionCoefficients = WireFormatNano.EMPTY_FLOAT_ARRAY;
        hasMagnet_ = false;
        primaryButton_ = 1;
        internal = null;
        daydreamInternal = null;
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
        if(leftEyeFieldOfViewAngles != null && leftEyeFieldOfViewAngles.length > 0)
            cachedsize.leftEyeFieldOfViewAngles = (float[])leftEyeFieldOfViewAngles.clone();
        if(distortionCoefficients != null && distortionCoefficients.length > 0)
            cachedsize.distortionCoefficients = (float[])distortionCoefficients.clone();
        if(internal != null)
            cachedsize.internal = internal.clone();
        if(daydreamInternal != null)
            cachedsize.daydreamInternal = daydreamInternal.clone();
        return cachedsize;
    }

    public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
        throws IOException
    {
        if((bitField0_ & 1) != 0)
            codedoutputbytebuffernano.writeString(1, vendor_);
        if((bitField0_ & 2) != 0)
            codedoutputbytebuffernano.writeString(2, model_);
        if((bitField0_ & 4) != 0)
            codedoutputbytebuffernano.writeFloat(3, screenToLensDistance_);
        if((bitField0_ & 8) != 0)
            codedoutputbytebuffernano.writeFloat(4, interLensDistance_);
        if(leftEyeFieldOfViewAngles != null && leftEyeFieldOfViewAngles.length > 0)
        {
            int i = 4 * leftEyeFieldOfViewAngles.length;
            codedoutputbytebuffernano.writeRawVarint32(42);
            codedoutputbytebuffernano.writeRawVarint32(i);
            for(int k = 0; k < leftEyeFieldOfViewAngles.length; k++)
                codedoutputbytebuffernano.writeFloatNoTag(leftEyeFieldOfViewAngles[k]);

        }
        if((bitField0_ & 0x20) != 0)
            codedoutputbytebuffernano.writeFloat(6, trayToLensDistance_);
        if(distortionCoefficients != null && distortionCoefficients.length > 0)
        {
            int j = 4 * distortionCoefficients.length;
            codedoutputbytebuffernano.writeRawVarint32(58);
            codedoutputbytebuffernano.writeRawVarint32(j);
            for(int l = 0; l < distortionCoefficients.length; l++)
                codedoutputbytebuffernano.writeFloatNoTag(distortionCoefficients[l]);

        }
        if((bitField0_ & 0x40) != 0)
            codedoutputbytebuffernano.writeBool(10, hasMagnet_);
        if((bitField0_ & 0x10) != 0)
            codedoutputbytebuffernano.writeInt32(11, verticalAlignment_);
        if((bitField0_ & 0x80) != 0)
            codedoutputbytebuffernano.writeInt32(12, primaryButton_);
        if(internal != null)
            codedoutputbytebuffernano.writeMessage(1729, internal);
        if(daydreamInternal != null)
            codedoutputbytebuffernano.writeMessage(0x30113, daydreamInternal);
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if((bitField0_ & 1) != 0)
            i += CodedOutputByteBufferNano.computeStringSize(1, vendor_);
        if((bitField0_ & 2) != 0)
            i += CodedOutputByteBufferNano.computeStringSize(2, model_);
        if((bitField0_ & 4) != 0)
            i += CodedOutputByteBufferNano.computeFloatSize(3, screenToLensDistance_);
        if((bitField0_ & 8) != 0)
            i += CodedOutputByteBufferNano.computeFloatSize(4, interLensDistance_);
        if(leftEyeFieldOfViewAngles != null && leftEyeFieldOfViewAngles.length > 0)
        {
            int j = 4 * leftEyeFieldOfViewAngles.length;
            i += j;
            i = ++i + CodedOutputByteBufferNano.computeRawVarint32Size(j);
        }
        if((bitField0_ & 0x20) != 0)
            i += CodedOutputByteBufferNano.computeFloatSize(6, trayToLensDistance_);
        if(distortionCoefficients != null && distortionCoefficients.length > 0)
        {
            int k = 4 * distortionCoefficients.length;
            i += k;
            i = ++i + CodedOutputByteBufferNano.computeRawVarint32Size(k);
        }
        if((bitField0_ & 0x40) != 0)
            i += CodedOutputByteBufferNano.computeBoolSize(10, hasMagnet_);
        if((bitField0_ & 0x10) != 0)
            i += CodedOutputByteBufferNano.computeInt32Size(11, verticalAlignment_);
        if((bitField0_ & 0x80) != 0)
            i += CodedOutputByteBufferNano.computeInt32Size(12, primaryButton_);
        if(internal != null)
            i += CodedOutputByteBufferNano.computeMessageSize(1729, internal);
        if(daydreamInternal != null)
            i += CodedOutputByteBufferNano.computeMessageSize(0x30113, daydreamInternal);
        return i;
    }

    public final daydreamInternal mergeFrom(CodedInputByteBufferNano codedinputbytebuffernano)
        throws IOException
    {
        int i;
        int j1;
        do
            switch(i = codedinputbytebuffernano.readTag())
            {
            case 0: // '\0'
                return this;

            default:
                if(!super.storeUnknownField(codedinputbytebuffernano, i))
                    return this;
                break;

            case 10: // '\n'
                vendor_ = codedinputbytebuffernano.readString();
                bitField0_ |= 1;
                break;

            case 18: // '\022'
                model_ = codedinputbytebuffernano.readString();
                bitField0_ |= 2;
                break;

            case 29: // '\035'
                screenToLensDistance_ = codedinputbytebuffernano.readFloat();
                bitField0_ |= 4;
                break;

            case 37: // '%'
                interLensDistance_ = codedinputbytebuffernano.readFloat();
                bitField0_ |= 8;
                break;

            case 45: // '-'
                int j = WireFormatNano.getRepeatedFieldArrayLength(codedinputbytebuffernano, 45);
                int k1;
                float af[] = new float[(k1 = leftEyeFieldOfViewAngles != null ? leftEyeFieldOfViewAngles.length : 0) + j];
                if(k1 != 0)
                    System.arraycopy(leftEyeFieldOfViewAngles, 0, af, 0, k1);
                for(; k1 < af.length - 1; k1++)
                {
                    af[k1] = codedinputbytebuffernano.readFloat();
                    codedinputbytebuffernano.readTag();
                }

                af[k1] = codedinputbytebuffernano.readFloat();
                leftEyeFieldOfViewAngles = af;
                break;

            case 42: // '*'
                int k = codedinputbytebuffernano.readRawVarint32();
                int l1 = codedinputbytebuffernano.pushLimit(k);
                int k2 = k / 4;
                int i3;
                float af2[] = new float[(i3 = leftEyeFieldOfViewAngles != null ? leftEyeFieldOfViewAngles.length : 0) + k2];
                if(i3 != 0)
                    System.arraycopy(leftEyeFieldOfViewAngles, 0, af2, 0, i3);
                for(; i3 < af2.length; i3++)
                    af2[i3] = codedinputbytebuffernano.readFloat();

                leftEyeFieldOfViewAngles = af2;
                codedinputbytebuffernano.popLimit(l1);
                break;

            case 53: // '5'
                trayToLensDistance_ = codedinputbytebuffernano.readFloat();
                bitField0_ |= 0x20;
                break;

            case 61: // '='
                int l = WireFormatNano.getRepeatedFieldArrayLength(codedinputbytebuffernano, 61);
                int i2;
                float af1[] = new float[(i2 = distortionCoefficients != null ? distortionCoefficients.length : 0) + l];
                if(i2 != 0)
                    System.arraycopy(distortionCoefficients, 0, af1, 0, i2);
                for(; i2 < af1.length - 1; i2++)
                {
                    af1[i2] = codedinputbytebuffernano.readFloat();
                    codedinputbytebuffernano.readTag();
                }

                af1[i2] = codedinputbytebuffernano.readFloat();
                distortionCoefficients = af1;
                break;

            case 58: // ':'
                int i1 = codedinputbytebuffernano.readRawVarint32();
                int j2 = codedinputbytebuffernano.pushLimit(i1);
                int l2 = i1 / 4;
                int j3;
                float af3[] = new float[(j3 = distortionCoefficients != null ? distortionCoefficients.length : 0) + l2];
                if(j3 != 0)
                    System.arraycopy(distortionCoefficients, 0, af3, 0, j3);
                for(; j3 < af3.length; j3++)
                    af3[j3] = codedinputbytebuffernano.readFloat();

                distortionCoefficients = af3;
                codedinputbytebuffernano.popLimit(j2);
                break;

            case 80: // 'P'
                hasMagnet_ = codedinputbytebuffernano.readBool();
                bitField0_ |= 0x40;
                break;

            case 88: // 'X'
                switch(j1 = codedinputbytebuffernano.readInt32())
                {
                case 0: // '\0'
                case 1: // '\001'
                case 2: // '\002'
                    verticalAlignment_ = j1;
                    bitField0_ |= 0x10;
                    break;
                }
                break;

            case 96: // '`'
                switch(j1 = codedinputbytebuffernano.readInt32())
                {
                case 0: // '\0'
                case 1: // '\001'
                case 2: // '\002'
                case 3: // '\003'
                    primaryButton_ = j1;
                    bitField0_ |= 0x80;
                    break;
                }
                break;

            case 13834: 
                if(internal == null)
                    internal = new rnalParams();
                codedinputbytebuffernano.readMessage(internal);
                break;

            case 1575066: 
                if(daydreamInternal == null)
                    daydreamInternal = new nalParams();
                codedinputbytebuffernano.readMessage(daydreamInternal);
                break;
            }
        while(true);
    }

    public static daydreamInternal parseFrom(byte abyte0[])
        throws InvalidProtocolBufferNanoException
    {
        return (daydreamInternal)MessageNano.mergeFrom(new <init>(), abyte0);
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
    private String vendor_;
    private String model_;
    private float screenToLensDistance_;
    private float interLensDistance_;
    public float leftEyeFieldOfViewAngles[];
    private int verticalAlignment_;
    private float trayToLensDistance_;
    public float distortionCoefficients[];
    private boolean hasMagnet_;
    private int primaryButton_;
    public rnalParams internal;
    public nalParams daydreamInternal;

    public VerticalAlignmentType()
    {
        clear();
    }
}
