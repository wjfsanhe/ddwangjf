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

    public static cachedSize[] emptyArray()
    {
        if(_emptyArray == null)
            synchronized(InternalNano.LAZY_INIT_LOCK)
            {
                if(_emptyArray == null)
                    _emptyArray = new _emptyArray[0];
            }
        return _emptyArray;
    }

    public final _emptyArray clone()
    {
        _emptyArray _lemptyarray;
        try
        {
            _lemptyarray = (_emptyArray)super.clone();
        }
        catch(CloneNotSupportedException clonenotsupportedexception)
        {
            throw new AssertionError(clonenotsupportedexception);
        }
        if(cpuTemperature != null && cpuTemperature.length > 0)
            _lemptyarray.cpuTemperature = (float[])cpuTemperature.clone();
        if(gpuTemperature != null && gpuTemperature.length > 0)
            _lemptyarray.gpuTemperature = (float[])gpuTemperature.clone();
        if(batteryTemperature != null && batteryTemperature.length > 0)
            _lemptyarray.batteryTemperature = (float[])batteryTemperature.clone();
        return _lemptyarray;
    }

    public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
        throws IOException
    {
        if(intervalStartTimeSeconds != null)
            codedoutputbytebuffernano.writeInt32(1, intervalStartTimeSeconds.intValue());
        if(skinTemperature != null)
            codedoutputbytebuffernano.writeFloat(2, skinTemperature.floatValue());
        if(edsThreadFrameDropCount != null)
            codedoutputbytebuffernano.writeInt32(3, edsThreadFrameDropCount.intValue());
        if(batteryLevel != null)
            codedoutputbytebuffernano.writeInt32(4, batteryLevel.intValue());
        if(batteryLevelDelta != null)
            codedoutputbytebuffernano.writeInt32(5, batteryLevelDelta.intValue());
        if(thermalWarningsShown != null)
            codedoutputbytebuffernano.writeInt32(6, thermalWarningsShown.intValue());
        if(cpuTemperature != null && cpuTemperature.length > 0)
        {
            for(int i = 0; i < cpuTemperature.length; i++)
                codedoutputbytebuffernano.writeFloat(7, cpuTemperature[i]);

        }
        if(gpuTemperature != null && gpuTemperature.length > 0)
        {
            for(int j = 0; j < gpuTemperature.length; j++)
                codedoutputbytebuffernano.writeFloat(8, gpuTemperature[j]);

        }
        if(batteryTemperature != null && batteryTemperature.length > 0)
        {
            for(int k = 0; k < batteryTemperature.length; k++)
                codedoutputbytebuffernano.writeFloat(9, batteryTemperature[k]);

        }
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(intervalStartTimeSeconds != null)
            i += CodedOutputByteBufferNano.computeInt32Size(1, intervalStartTimeSeconds.intValue());
        if(skinTemperature != null)
            i += CodedOutputByteBufferNano.computeFloatSize(2, skinTemperature.floatValue());
        if(edsThreadFrameDropCount != null)
            i += CodedOutputByteBufferNano.computeInt32Size(3, edsThreadFrameDropCount.intValue());
        if(batteryLevel != null)
            i += CodedOutputByteBufferNano.computeInt32Size(4, batteryLevel.intValue());
        if(batteryLevelDelta != null)
            i += CodedOutputByteBufferNano.computeInt32Size(5, batteryLevelDelta.intValue());
        if(thermalWarningsShown != null)
            i += CodedOutputByteBufferNano.computeInt32Size(6, thermalWarningsShown.intValue());
        if(cpuTemperature != null && cpuTemperature.length > 0)
        {
            int j = 4 * cpuTemperature.length;
            i = (i += j) + 1 * cpuTemperature.length;
        }
        if(gpuTemperature != null && gpuTemperature.length > 0)
        {
            int k = 4 * gpuTemperature.length;
            i = (i += k) + 1 * gpuTemperature.length;
        }
        if(batteryTemperature != null && batteryTemperature.length > 0)
        {
            int l = 4 * batteryTemperature.length;
            i = (i += l) + 1 * batteryTemperature.length;
        }
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
                clone1.intervalStartTimeSeconds = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                break;

            case 21: // '\025'
                clone1.skinTemperature = Float.valueOf(codedinputbytebuffernano1.readFloat());
                break;

            case 24: // '\030'
                clone1.edsThreadFrameDropCount = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                break;

            case 32: // ' '
                clone1.batteryLevel = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                break;

            case 40: // '('
                clone1.batteryLevelDelta = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                break;

            case 48: // '0'
                clone1.thermalWarningsShown = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                break;

            case 61: // '='
                int j = WireFormatNano.getRepeatedFieldArrayLength(codedinputbytebuffernano1, 61);
                int l1;
                float af[] = new float[(l1 = clone1.cpuTemperature != null ? clone1.cpuTemperature.length : 0) + j];
                if(l1 != 0)
                    System.arraycopy(clone1.cpuTemperature, 0, af, 0, l1);
                for(; l1 < af.length - 1; l1++)
                {
                    af[l1] = codedinputbytebuffernano1.readFloat();
                    codedinputbytebuffernano1.readTag();
                }

                af[l1] = codedinputbytebuffernano1.readFloat();
                clone1.cpuTemperature = af;
                break;

            case 58: // ':'
                int k = codedinputbytebuffernano1.readRawVarint32();
                int i2 = codedinputbytebuffernano1.pushLimit(k);
                int j3 = k / 4;
                int i4;
                float af3[] = new float[(i4 = clone1.cpuTemperature != null ? clone1.cpuTemperature.length : 0) + j3];
                if(i4 != 0)
                    System.arraycopy(clone1.cpuTemperature, 0, af3, 0, i4);
                for(; i4 < af3.length; i4++)
                    af3[i4] = codedinputbytebuffernano1.readFloat();

                clone1.cpuTemperature = af3;
                codedinputbytebuffernano1.popLimit(i2);
                break;

            case 69: // 'E'
                int l = WireFormatNano.getRepeatedFieldArrayLength(codedinputbytebuffernano1, 69);
                int j2;
                float af1[] = new float[(j2 = clone1.gpuTemperature != null ? clone1.gpuTemperature.length : 0) + l];
                if(j2 != 0)
                    System.arraycopy(clone1.gpuTemperature, 0, af1, 0, j2);
                for(; j2 < af1.length - 1; j2++)
                {
                    af1[j2] = codedinputbytebuffernano1.readFloat();
                    codedinputbytebuffernano1.readTag();
                }

                af1[j2] = codedinputbytebuffernano1.readFloat();
                clone1.gpuTemperature = af1;
                break;

            case 66: // 'B'
                int i1 = codedinputbytebuffernano1.readRawVarint32();
                int k2 = codedinputbytebuffernano1.pushLimit(i1);
                int k3 = i1 / 4;
                int j4;
                float af4[] = new float[(j4 = clone1.gpuTemperature != null ? clone1.gpuTemperature.length : 0) + k3];
                if(j4 != 0)
                    System.arraycopy(clone1.gpuTemperature, 0, af4, 0, j4);
                for(; j4 < af4.length; j4++)
                    af4[j4] = codedinputbytebuffernano1.readFloat();

                clone1.gpuTemperature = af4;
                codedinputbytebuffernano1.popLimit(k2);
                break;

            case 77: // 'M'
                int j1 = WireFormatNano.getRepeatedFieldArrayLength(codedinputbytebuffernano1, 77);
                int l2;
                float af2[] = new float[(l2 = clone1.batteryTemperature != null ? clone1.batteryTemperature.length : 0) + j1];
                if(l2 != 0)
                    System.arraycopy(clone1.batteryTemperature, 0, af2, 0, l2);
                for(; l2 < af2.length - 1; l2++)
                {
                    af2[l2] = codedinputbytebuffernano1.readFloat();
                    codedinputbytebuffernano1.readTag();
                }

                af2[l2] = codedinputbytebuffernano1.readFloat();
                clone1.batteryTemperature = af2;
                break;

            case 74: // 'J'
                int k1 = codedinputbytebuffernano1.readRawVarint32();
                int i3 = codedinputbytebuffernano1.pushLimit(k1);
                int l3 = k1 / 4;
                int k4;
                float af5[] = new float[(k4 = clone1.batteryTemperature != null ? clone1.batteryTemperature.length : 0) + l3];
                if(k4 != 0)
                    System.arraycopy(clone1.batteryTemperature, 0, af5, 0, k4);
                for(; k4 < af5.length; k4++)
                    af5[k4] = codedinputbytebuffernano1.readFloat();

                clone1.batteryTemperature = af5;
                codedinputbytebuffernano1.popLimit(i3);
                break;
            }
        while(true);
    }

    public final volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    private static volatile clone _emptyArray[];
    private Integer intervalStartTimeSeconds;
    private Float skinTemperature;
    private Integer edsThreadFrameDropCount;
    private Integer batteryLevel;
    private Integer batteryLevelDelta;
    private Integer thermalWarningsShown;
    private float cpuTemperature[];
    private float gpuTemperature[];
    private float batteryTemperature[];

    public ()
    {
         ;
        ( = this).intervalStartTimeSeconds = null;
        .skinTemperature = null;
        .edsThreadFrameDropCount = null;
        .batteryLevel = null;
        .batteryLevelDelta = null;
        .thermalWarningsShown = null;
        .cpuTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
        .gpuTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
        .batteryTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
        .unknownFieldData = null;
        .cachedSize = -1;
    }
}
