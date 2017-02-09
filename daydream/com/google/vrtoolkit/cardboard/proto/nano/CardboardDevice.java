// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CardboardDevice.java

package com.google.vrtoolkit.cardboard.proto.nano;

import com.google.protobuf.nano.*;
import java.io.IOException;

public interface CardboardDevice
{
    public static final class ScreenAlignmentMarker extends ExtendableMessageNano
        implements Cloneable
    {

        public static ScreenAlignmentMarker[] emptyArray()
        {
            if(_emptyArray == null)
                synchronized(InternalNano.LAZY_INIT_LOCK)
                {
                    if(_emptyArray == null)
                        _emptyArray = new ScreenAlignmentMarker[0];
                }
            return _emptyArray;
        }

        public final float getHorizontal()
        {
            return horizontal_;
        }

        public final ScreenAlignmentMarker setHorizontal(float f)
        {
            horizontal_ = f;
            bitField0_ |= 1;
            return this;
        }

        public final boolean hasHorizontal()
        {
            return (bitField0_ & 1) != 0;
        }

        public final ScreenAlignmentMarker clearHorizontal()
        {
            horizontal_ = 0.0F;
            bitField0_ = bitField0_ & -2;
            return this;
        }

        public final float getVertical()
        {
            return vertical_;
        }

        public final ScreenAlignmentMarker setVertical(float f)
        {
            vertical_ = f;
            bitField0_ |= 2;
            return this;
        }

        public final boolean hasVertical()
        {
            return (bitField0_ & 2) != 0;
        }

        public final ScreenAlignmentMarker clearVertical()
        {
            vertical_ = 0.0F;
            bitField0_ = bitField0_ & -3;
            return this;
        }

        public final ScreenAlignmentMarker clear()
        {
            bitField0_ = 0;
            horizontal_ = 0.0F;
            vertical_ = 0.0F;
            unknownFieldData = null;
            cachedSize = -1;
            return this;
        }

        public final ScreenAlignmentMarker clone()
        {
            ScreenAlignmentMarker screenalignmentmarker;
            try
            {
                screenalignmentmarker = (ScreenAlignmentMarker)super.clone();
            }
            catch(CloneNotSupportedException clonenotsupportedexception)
            {
                throw new AssertionError(clonenotsupportedexception);
            }
            return screenalignmentmarker;
        }

        public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
            throws IOException
        {
            if((bitField0_ & 1) != 0)
                codedoutputbytebuffernano.writeFloat(1, horizontal_);
            if((bitField0_ & 2) != 0)
                codedoutputbytebuffernano.writeFloat(2, vertical_);
            super.writeTo(codedoutputbytebuffernano);
        }

        protected final int computeSerializedSize()
        {
            int i = super.computeSerializedSize();
            if((bitField0_ & 1) != 0)
                i += CodedOutputByteBufferNano.computeFloatSize(1, horizontal_);
            if((bitField0_ & 2) != 0)
                i += CodedOutputByteBufferNano.computeFloatSize(2, vertical_);
            return i;
        }

        public final ScreenAlignmentMarker mergeFrom(CodedInputByteBufferNano codedinputbytebuffernano)
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
                    horizontal_ = codedinputbytebuffernano.readFloat();
                    bitField0_ |= 1;
                    break;

                case 21: // '\025'
                    vertical_ = codedinputbytebuffernano.readFloat();
                    bitField0_ |= 2;
                    break;
                }
            while(true);
        }

        public static ScreenAlignmentMarker parseFrom(byte abyte0[])
            throws InvalidProtocolBufferNanoException
        {
            return (ScreenAlignmentMarker)MessageNano.mergeFrom(new ScreenAlignmentMarker(), abyte0);
        }

        public static ScreenAlignmentMarker parseFrom(CodedInputByteBufferNano codedinputbytebuffernano)
            throws IOException
        {
            return (new ScreenAlignmentMarker()).mergeFrom(codedinputbytebuffernano);
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

        private static volatile ScreenAlignmentMarker _emptyArray[];
        private int bitField0_;
        private float horizontal_;
        private float vertical_;

        public ScreenAlignmentMarker()
        {
            clear();
        }
    }

    public static final class DaydreamInternalParams extends ExtendableMessageNano
        implements Cloneable
    {

        public static DaydreamInternalParams[] emptyArray()
        {
            if(_emptyArray == null)
                synchronized(InternalNano.LAZY_INIT_LOCK)
                {
                    if(_emptyArray == null)
                        _emptyArray = new DaydreamInternalParams[0];
                }
            return _emptyArray;
        }

        public final int getVersion()
        {
            return version_;
        }

        public final DaydreamInternalParams setVersion(int i)
        {
            version_ = i;
            bitField0_ |= 1;
            return this;
        }

        public final boolean hasVersion()
        {
            return (bitField0_ & 1) != 0;
        }

        public final DaydreamInternalParams clearVersion()
        {
            version_ = 0;
            bitField0_ = bitField0_ & -2;
            return this;
        }

        public final DaydreamInternalParams clear()
        {
            bitField0_ = 0;
            version_ = 0;
            alignmentMarkers = ScreenAlignmentMarker.emptyArray();
            unknownFieldData = null;
            cachedSize = -1;
            return this;
        }

        public final DaydreamInternalParams clone()
        {
            DaydreamInternalParams daydreaminternalparams;
            try
            {
                daydreaminternalparams = (DaydreamInternalParams)super.clone();
            }
            catch(CloneNotSupportedException clonenotsupportedexception)
            {
                throw new AssertionError(clonenotsupportedexception);
            }
            if(alignmentMarkers != null && alignmentMarkers.length > 0)
            {
                daydreaminternalparams.alignmentMarkers = new ScreenAlignmentMarker[alignmentMarkers.length];
                for(int i = 0; i < alignmentMarkers.length; i++)
                    if(alignmentMarkers[i] != null)
                        daydreaminternalparams.alignmentMarkers[i] = alignmentMarkers[i].clone();

            }
            return daydreaminternalparams;
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
                    ScreenAlignmentMarker screenalignmentmarker;
                    if((screenalignmentmarker = alignmentMarkers[i]) != null)
                        codedoutputbytebuffernano.writeMessage(2, screenalignmentmarker);
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
                    ScreenAlignmentMarker screenalignmentmarker;
                    if((screenalignmentmarker = alignmentMarkers[j]) != null)
                        i += CodedOutputByteBufferNano.computeMessageSize(2, screenalignmentmarker);
                }

            }
            return i;
        }

        public final DaydreamInternalParams mergeFrom(CodedInputByteBufferNano codedinputbytebuffernano)
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
                    ScreenAlignmentMarker ascreenalignmentmarker[] = new ScreenAlignmentMarker[(k = alignmentMarkers != null ? alignmentMarkers.length : 0) + j];
                    if(k != 0)
                        System.arraycopy(alignmentMarkers, 0, ascreenalignmentmarker, 0, k);
                    for(; k < ascreenalignmentmarker.length - 1; k++)
                    {
                        ascreenalignmentmarker[k] = new ScreenAlignmentMarker();
                        codedinputbytebuffernano.readMessage(ascreenalignmentmarker[k]);
                        codedinputbytebuffernano.readTag();
                    }

                    ascreenalignmentmarker[k] = new ScreenAlignmentMarker();
                    codedinputbytebuffernano.readMessage(ascreenalignmentmarker[k]);
                    alignmentMarkers = ascreenalignmentmarker;
                    break;
                }
            while(true);
        }

        public static DaydreamInternalParams parseFrom(byte abyte0[])
            throws InvalidProtocolBufferNanoException
        {
            return (DaydreamInternalParams)MessageNano.mergeFrom(new DaydreamInternalParams(), abyte0);
        }

        public static DaydreamInternalParams parseFrom(CodedInputByteBufferNano codedinputbytebuffernano)
            throws IOException
        {
            return (new DaydreamInternalParams()).mergeFrom(codedinputbytebuffernano);
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

        private static volatile DaydreamInternalParams _emptyArray[];
        private int bitField0_;
        private int version_;
        public ScreenAlignmentMarker alignmentMarkers[];

        public DaydreamInternalParams()
        {
            clear();
        }
    }

    public static final class CardboardInternalParams extends ExtendableMessageNano
        implements Cloneable
    {
        public static interface OrientationType
        {

            public static final int CCW_0_DEGREES = 0;
            public static final int CCW_90_DEGREES = 1;
            public static final int CCW_180_DEGREES = 2;
            public static final int CCW_270_DEGREES = 3;
            public static final int CCW_0_DEGREES_MIRRORED = 4;
            public static final int CCW_90_DEGREES_MIRRORED = 5;
            public static final int CCW_180_DEGREES_MIRRORED = 6;
            public static final int CCW_270_DEGREES_MIRRORED = 7;
        }


        public static CardboardInternalParams[] emptyArray()
        {
            if(_emptyArray == null)
                synchronized(InternalNano.LAZY_INIT_LOCK)
                {
                    if(_emptyArray == null)
                        _emptyArray = new CardboardInternalParams[0];
                }
            return _emptyArray;
        }

        public final float getScreenCenterToLensDistance()
        {
            return screenCenterToLensDistance_;
        }

        public final CardboardInternalParams setScreenCenterToLensDistance(float f)
        {
            screenCenterToLensDistance_ = f;
            bitField0_ |= 1;
            return this;
        }

        public final boolean hasScreenCenterToLensDistance()
        {
            return (bitField0_ & 1) != 0;
        }

        public final CardboardInternalParams clearScreenCenterToLensDistance()
        {
            screenCenterToLensDistance_ = 0.0F;
            bitField0_ = bitField0_ & -2;
            return this;
        }

        public final float getXPpiOverride()
        {
            return xPpiOverride_;
        }

        public final CardboardInternalParams setXPpiOverride(float f)
        {
            xPpiOverride_ = f;
            bitField0_ |= 2;
            return this;
        }

        public final boolean hasXPpiOverride()
        {
            return (bitField0_ & 2) != 0;
        }

        public final CardboardInternalParams clearXPpiOverride()
        {
            xPpiOverride_ = 0.0F;
            bitField0_ = bitField0_ & -3;
            return this;
        }

        public final float getYPpiOverride()
        {
            return yPpiOverride_;
        }

        public final CardboardInternalParams setYPpiOverride(float f)
        {
            yPpiOverride_ = f;
            bitField0_ |= 4;
            return this;
        }

        public final boolean hasYPpiOverride()
        {
            return (bitField0_ & 4) != 0;
        }

        public final CardboardInternalParams clearYPpiOverride()
        {
            yPpiOverride_ = 0.0F;
            bitField0_ = bitField0_ & -5;
            return this;
        }

        public final String getAccelerometer()
        {
            return accelerometer_;
        }

        public final CardboardInternalParams setAccelerometer(String s)
        {
            if(s == null)
            {
                throw new NullPointerException();
            } else
            {
                accelerometer_ = s;
                bitField0_ |= 8;
                return this;
            }
        }

        public final boolean hasAccelerometer()
        {
            return (bitField0_ & 8) != 0;
        }

        public final CardboardInternalParams clearAccelerometer()
        {
            accelerometer_ = "";
            bitField0_ = bitField0_ & -9;
            return this;
        }

        public final String getGyroscope()
        {
            return gyroscope_;
        }

        public final CardboardInternalParams setGyroscope(String s)
        {
            if(s == null)
            {
                throw new NullPointerException();
            } else
            {
                gyroscope_ = s;
                bitField0_ |= 0x10;
                return this;
            }
        }

        public final boolean hasGyroscope()
        {
            return (bitField0_ & 0x10) != 0;
        }

        public final CardboardInternalParams clearGyroscope()
        {
            gyroscope_ = "";
            bitField0_ = bitField0_ & 0xffffffef;
            return this;
        }

        public final CardboardInternalParams clear()
        {
            bitField0_ = 0;
            eyeOrientations = WireFormatNano.EMPTY_INT_ARRAY;
            screenCenterToLensDistance_ = 0.0F;
            xPpiOverride_ = 0.0F;
            yPpiOverride_ = 0.0F;
            accelerometer_ = "";
            gyroscope_ = "";
            unknownFieldData = null;
            cachedSize = -1;
            return this;
        }

        public final CardboardInternalParams clone()
        {
            CardboardInternalParams cardboardinternalparams;
            try
            {
                cardboardinternalparams = (CardboardInternalParams)super.clone();
            }
            catch(CloneNotSupportedException clonenotsupportedexception)
            {
                throw new AssertionError(clonenotsupportedexception);
            }
            if(eyeOrientations != null && eyeOrientations.length > 0)
                cardboardinternalparams.eyeOrientations = (int[])eyeOrientations.clone();
            return cardboardinternalparams;
        }

        public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
            throws IOException
        {
            if(eyeOrientations != null && eyeOrientations.length > 0)
            {
                int i = 0;
                for(int j = 0; j < eyeOrientations.length; j++)
                {
                    int l = eyeOrientations[j];
                    i += CodedOutputByteBufferNano.computeInt32SizeNoTag(l);
                }

                codedoutputbytebuffernano.writeRawVarint32(10);
                codedoutputbytebuffernano.writeRawVarint32(i);
                for(int k = 0; k < eyeOrientations.length; k++)
                    codedoutputbytebuffernano.writeRawVarint32(eyeOrientations[k]);

            }
            if((bitField0_ & 1) != 0)
                codedoutputbytebuffernano.writeFloat(2, screenCenterToLensDistance_);
            if((bitField0_ & 2) != 0)
                codedoutputbytebuffernano.writeFloat(3, xPpiOverride_);
            if((bitField0_ & 4) != 0)
                codedoutputbytebuffernano.writeFloat(4, yPpiOverride_);
            if((bitField0_ & 8) != 0)
                codedoutputbytebuffernano.writeString(5, accelerometer_);
            if((bitField0_ & 0x10) != 0)
                codedoutputbytebuffernano.writeString(6, gyroscope_);
            super.writeTo(codedoutputbytebuffernano);
        }

        protected final int computeSerializedSize()
        {
            int i = super.computeSerializedSize();
            if(eyeOrientations != null && eyeOrientations.length > 0)
            {
                int j = 0;
                for(int k = 0; k < eyeOrientations.length; k++)
                {
                    int l = eyeOrientations[k];
                    j += CodedOutputByteBufferNano.computeInt32SizeNoTag(l);
                }

                i += j;
                i = ++i + CodedOutputByteBufferNano.computeRawVarint32Size(j);
            }
            if((bitField0_ & 1) != 0)
                i += CodedOutputByteBufferNano.computeFloatSize(2, screenCenterToLensDistance_);
            if((bitField0_ & 2) != 0)
                i += CodedOutputByteBufferNano.computeFloatSize(3, xPpiOverride_);
            if((bitField0_ & 4) != 0)
                i += CodedOutputByteBufferNano.computeFloatSize(4, yPpiOverride_);
            if((bitField0_ & 8) != 0)
                i += CodedOutputByteBufferNano.computeStringSize(5, accelerometer_);
            if((bitField0_ & 0x10) != 0)
                i += CodedOutputByteBufferNano.computeStringSize(6, gyroscope_);
            return i;
        }

        public final CardboardInternalParams mergeFrom(CodedInputByteBufferNano codedinputbytebuffernano)
            throws IOException
        {
_L17:
            int i = codedinputbytebuffernano.readTag();
            JVM INSTR lookupswitch 8: default 82
        //                       0: 80
        //                       8: 93
        //                       10: 286
        //                       21: 512
        //                       29: 533
        //                       37: 554
        //                       42: 575
        //                       50: 597;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L2:
            return this;
_L1:
            if(!super.storeUnknownField(codedinputbytebuffernano, i))
                return this;
            continue; /* Loop/switch isn't completed */
_L3:
            int j;
            int ai[] = new int[j = WireFormatNano.getRepeatedFieldArrayLength(codedinputbytebuffernano, 8)];
            int i1 = 0;
            int k1 = 0;
            do
            {
                if(k1 >= j)
                    break;
                if(k1 != 0)
                    codedinputbytebuffernano.readTag();
                int i2;
                switch(i2 = codedinputbytebuffernano.readInt32())
                {
                case 0: // '\0'
                case 1: // '\001'
                case 2: // '\002'
                case 3: // '\003'
                case 4: // '\004'
                case 5: // '\005'
                case 6: // '\006'
                case 7: // '\007'
                    ai[i1++] = i2;
                    break;
                }
                k1++;
            } while(true);
            if(i1 != 0)
                if((k1 = eyeOrientations != null ? eyeOrientations.length : 0) == 0 && i1 == j)
                {
                    eyeOrientations = ai;
                } else
                {
                    int ai1[] = new int[k1 + i1];
                    if(k1 != 0)
                        System.arraycopy(eyeOrientations, 0, ai1, 0, k1);
                    System.arraycopy(ai, 0, ai1, k1, i1);
                    eyeOrientations = ai1;
                }
            continue; /* Loop/switch isn't completed */
_L4:
            int l;
            int j1;
            int l1;
            int k = codedinputbytebuffernano.readRawVarint32();
            l = codedinputbytebuffernano.pushLimit(k);
            j1 = 0;
            l1 = codedinputbytebuffernano.getPosition();
_L15:
            if(codedinputbytebuffernano.getBytesUntilLimit() > 0)
            {
                switch(codedinputbytebuffernano.readInt32())
                {
                case 0: // '\0'
                case 1: // '\001'
                case 2: // '\002'
                case 3: // '\003'
                case 4: // '\004'
                case 5: // '\005'
                case 6: // '\006'
                case 7: // '\007'
                    j1++;
                    break;
                }
                continue; /* Loop/switch isn't completed */
            }
            if(j1 == 0) goto _L11; else goto _L10
_L10:
            int j2;
            int ai2[];
            codedinputbytebuffernano.rewindToPosition(l1);
            ai2 = new int[(j2 = eyeOrientations != null ? eyeOrientations.length : 0) + j1];
            if(j2 != 0)
                System.arraycopy(eyeOrientations, 0, ai2, 0, j2);
_L13:
            if(codedinputbytebuffernano.getBytesUntilLimit() > 0)
            {
                int k2;
                switch(k2 = codedinputbytebuffernano.readInt32())
                {
                case 0: // '\0'
                case 1: // '\001'
                case 2: // '\002'
                case 3: // '\003'
                case 4: // '\004'
                case 5: // '\005'
                case 6: // '\006'
                case 7: // '\007'
                    ai2[j2++] = k2;
                    break;
                }
                continue; /* Loop/switch isn't completed */
            }
            eyeOrientations = ai2;
              goto _L11
            if(true) goto _L13; else goto _L12
_L12:
            if(true) goto _L15; else goto _L14
_L14:
_L11:
            codedinputbytebuffernano.popLimit(l);
            continue; /* Loop/switch isn't completed */
_L5:
            screenCenterToLensDistance_ = codedinputbytebuffernano.readFloat();
            bitField0_ |= 1;
            continue; /* Loop/switch isn't completed */
_L6:
            xPpiOverride_ = codedinputbytebuffernano.readFloat();
            bitField0_ |= 2;
            continue; /* Loop/switch isn't completed */
_L7:
            yPpiOverride_ = codedinputbytebuffernano.readFloat();
            bitField0_ |= 4;
            continue; /* Loop/switch isn't completed */
_L8:
            accelerometer_ = codedinputbytebuffernano.readString();
            bitField0_ |= 8;
            continue; /* Loop/switch isn't completed */
_L9:
            gyroscope_ = codedinputbytebuffernano.readString();
            bitField0_ |= 0x10;
            if(true) goto _L17; else goto _L16
_L16:
        }

        public static CardboardInternalParams parseFrom(byte abyte0[])
            throws InvalidProtocolBufferNanoException
        {
            return (CardboardInternalParams)MessageNano.mergeFrom(new CardboardInternalParams(), abyte0);
        }

        public static CardboardInternalParams parseFrom(CodedInputByteBufferNano codedinputbytebuffernano)
            throws IOException
        {
            return (new CardboardInternalParams()).mergeFrom(codedinputbytebuffernano);
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

        private static volatile CardboardInternalParams _emptyArray[];
        private int bitField0_;
        public int eyeOrientations[];
        private float screenCenterToLensDistance_;
        private float xPpiOverride_;
        private float yPpiOverride_;
        private String accelerometer_;
        private String gyroscope_;

        public CardboardInternalParams()
        {
            clear();
        }
    }

    public static final class DeviceParams extends ExtendableMessageNano
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


        public static DeviceParams[] emptyArray()
        {
            if(_emptyArray == null)
                synchronized(InternalNano.LAZY_INIT_LOCK)
                {
                    if(_emptyArray == null)
                        _emptyArray = new DeviceParams[0];
                }
            return _emptyArray;
        }

        public final String getVendor()
        {
            return vendor_;
        }

        public final DeviceParams setVendor(String s)
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

        public final DeviceParams clearVendor()
        {
            vendor_ = "";
            bitField0_ = bitField0_ & -2;
            return this;
        }

        public final String getModel()
        {
            return model_;
        }

        public final DeviceParams setModel(String s)
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

        public final DeviceParams clearModel()
        {
            model_ = "";
            bitField0_ = bitField0_ & -3;
            return this;
        }

        public final float getScreenToLensDistance()
        {
            return screenToLensDistance_;
        }

        public final DeviceParams setScreenToLensDistance(float f)
        {
            screenToLensDistance_ = f;
            bitField0_ |= 4;
            return this;
        }

        public final boolean hasScreenToLensDistance()
        {
            return (bitField0_ & 4) != 0;
        }

        public final DeviceParams clearScreenToLensDistance()
        {
            screenToLensDistance_ = 0.0F;
            bitField0_ = bitField0_ & -5;
            return this;
        }

        public final float getInterLensDistance()
        {
            return interLensDistance_;
        }

        public final DeviceParams setInterLensDistance(float f)
        {
            interLensDistance_ = f;
            bitField0_ |= 8;
            return this;
        }

        public final boolean hasInterLensDistance()
        {
            return (bitField0_ & 8) != 0;
        }

        public final DeviceParams clearInterLensDistance()
        {
            interLensDistance_ = 0.0F;
            bitField0_ = bitField0_ & -9;
            return this;
        }

        public final int getVerticalAlignment()
        {
            return verticalAlignment_;
        }

        public final DeviceParams setVerticalAlignment(int i)
        {
            verticalAlignment_ = i;
            bitField0_ |= 0x10;
            return this;
        }

        public final boolean hasVerticalAlignment()
        {
            return (bitField0_ & 0x10) != 0;
        }

        public final DeviceParams clearVerticalAlignment()
        {
            verticalAlignment_ = 0;
            bitField0_ = bitField0_ & 0xffffffef;
            return this;
        }

        public final float getTrayToLensDistance()
        {
            return trayToLensDistance_;
        }

        public final DeviceParams setTrayToLensDistance(float f)
        {
            trayToLensDistance_ = f;
            bitField0_ |= 0x20;
            return this;
        }

        public final boolean hasTrayToLensDistance()
        {
            return (bitField0_ & 0x20) != 0;
        }

        public final DeviceParams clearTrayToLensDistance()
        {
            trayToLensDistance_ = 0.0F;
            bitField0_ = bitField0_ & 0xffffffdf;
            return this;
        }

        public final boolean getHasMagnet()
        {
            return hasMagnet_;
        }

        public final DeviceParams setHasMagnet(boolean flag)
        {
            hasMagnet_ = flag;
            bitField0_ |= 0x40;
            return this;
        }

        public final boolean hasHasMagnet()
        {
            return (bitField0_ & 0x40) != 0;
        }

        public final DeviceParams clearHasMagnet()
        {
            hasMagnet_ = false;
            bitField0_ = bitField0_ & 0xffffffbf;
            return this;
        }

        public final int getPrimaryButton()
        {
            return primaryButton_;
        }

        public final DeviceParams setPrimaryButton(int i)
        {
            primaryButton_ = i;
            bitField0_ |= 0x80;
            return this;
        }

        public final boolean hasPrimaryButton()
        {
            return (bitField0_ & 0x80) != 0;
        }

        public final DeviceParams clearPrimaryButton()
        {
            primaryButton_ = 1;
            bitField0_ = bitField0_ & 0xffffff7f;
            return this;
        }

        public final DeviceParams clear()
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

        public final DeviceParams clone()
        {
            DeviceParams deviceparams;
            try
            {
                deviceparams = (DeviceParams)super.clone();
            }
            catch(CloneNotSupportedException clonenotsupportedexception)
            {
                throw new AssertionError(clonenotsupportedexception);
            }
            if(leftEyeFieldOfViewAngles != null && leftEyeFieldOfViewAngles.length > 0)
                deviceparams.leftEyeFieldOfViewAngles = (float[])leftEyeFieldOfViewAngles.clone();
            if(distortionCoefficients != null && distortionCoefficients.length > 0)
                deviceparams.distortionCoefficients = (float[])distortionCoefficients.clone();
            if(internal != null)
                deviceparams.internal = internal.clone();
            if(daydreamInternal != null)
                deviceparams.daydreamInternal = daydreamInternal.clone();
            return deviceparams;
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

        public final DeviceParams mergeFrom(CodedInputByteBufferNano codedinputbytebuffernano)
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
                        internal = new CardboardInternalParams();
                    codedinputbytebuffernano.readMessage(internal);
                    break;

                case 1575066: 
                    if(daydreamInternal == null)
                        daydreamInternal = new DaydreamInternalParams();
                    codedinputbytebuffernano.readMessage(daydreamInternal);
                    break;
                }
            while(true);
        }

        public static DeviceParams parseFrom(byte abyte0[])
            throws InvalidProtocolBufferNanoException
        {
            return (DeviceParams)MessageNano.mergeFrom(new DeviceParams(), abyte0);
        }

        public static DeviceParams parseFrom(CodedInputByteBufferNano codedinputbytebuffernano)
            throws IOException
        {
            return (new DeviceParams()).mergeFrom(codedinputbytebuffernano);
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

        private static volatile DeviceParams _emptyArray[];
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
        public CardboardInternalParams internal;
        public DaydreamInternalParams daydreamInternal;

        public DeviceParams()
        {
            clear();
        }
    }

}
