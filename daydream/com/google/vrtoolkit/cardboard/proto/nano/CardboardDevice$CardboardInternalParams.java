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


    public static OrientationType[] emptyArray()
    {
        if(_emptyArray == null)
            synchronized(InternalNano.LAZY_INIT_LOCK)
            {
                if(_emptyArray == null)
                    _emptyArray = new _emptyArray[0];
            }
        return _emptyArray;
    }

    public final float getScreenCenterToLensDistance()
    {
        return screenCenterToLensDistance_;
    }

    public final screenCenterToLensDistance_ setScreenCenterToLensDistance(float f)
    {
        screenCenterToLensDistance_ = f;
        bitField0_ |= 1;
        return this;
    }

    public final boolean hasScreenCenterToLensDistance()
    {
        return (bitField0_ & 1) != 0;
    }

    public final bitField0_ clearScreenCenterToLensDistance()
    {
        screenCenterToLensDistance_ = 0.0F;
        bitField0_ = bitField0_ & -2;
        return this;
    }

    public final float getXPpiOverride()
    {
        return xPpiOverride_;
    }

    public final xPpiOverride_ setXPpiOverride(float f)
    {
        xPpiOverride_ = f;
        bitField0_ |= 2;
        return this;
    }

    public final boolean hasXPpiOverride()
    {
        return (bitField0_ & 2) != 0;
    }

    public final bitField0_ clearXPpiOverride()
    {
        xPpiOverride_ = 0.0F;
        bitField0_ = bitField0_ & -3;
        return this;
    }

    public final float getYPpiOverride()
    {
        return yPpiOverride_;
    }

    public final yPpiOverride_ setYPpiOverride(float f)
    {
        yPpiOverride_ = f;
        bitField0_ |= 4;
        return this;
    }

    public final boolean hasYPpiOverride()
    {
        return (bitField0_ & 4) != 0;
    }

    public final bitField0_ clearYPpiOverride()
    {
        yPpiOverride_ = 0.0F;
        bitField0_ = bitField0_ & -5;
        return this;
    }

    public final String getAccelerometer()
    {
        return accelerometer_;
    }

    public final accelerometer_ setAccelerometer(String s)
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

    public final bitField0_ clearAccelerometer()
    {
        accelerometer_ = "";
        bitField0_ = bitField0_ & -9;
        return this;
    }

    public final String getGyroscope()
    {
        return gyroscope_;
    }

    public final gyroscope_ setGyroscope(String s)
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

    public final bitField0_ clearGyroscope()
    {
        gyroscope_ = "";
        bitField0_ = bitField0_ & 0xffffffef;
        return this;
    }

    public final bitField0_ clear()
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
        if(eyeOrientations != null && eyeOrientations.length > 0)
            cachedsize.eyeOrientations = (int[])eyeOrientations.clone();
        return cachedsize;
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

    public final gyroscope_ mergeFrom(CodedInputByteBufferNano codedinputbytebuffernano)
        throws IOException
    {
_L17:
        int i = codedinputbytebuffernano.readTag();
        JVM INSTR lookupswitch 8: default 82
    //                   0: 80
    //                   8: 93
    //                   10: 286
    //                   21: 512
    //                   29: 533
    //                   37: 554
    //                   42: 575
    //                   50: 597;
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
    public int eyeOrientations[];
    private float screenCenterToLensDistance_;
    private float xPpiOverride_;
    private float yPpiOverride_;
    private String accelerometer_;
    private String gyroscope_;

    public OrientationType()
    {
        clear();
    }
}
