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
        if(renderingTimePerBufferMilliseconds != null && renderingTimePerBufferMilliseconds.length > 0)
        {
            cachedsize.renderingTimePerBufferMilliseconds = new cket[renderingTimePerBufferMilliseconds.length];
            for(int i = 0; i < renderingTimePerBufferMilliseconds.length; i++)
                if(renderingTimePerBufferMilliseconds[i] != null)
                    cachedsize.renderingTimePerBufferMilliseconds[i] = renderingTimePerBufferMilliseconds[i].clone();

        }
        if(numberOfSimultaneousSoundObjects != null && numberOfSimultaneousSoundObjects.length > 0)
        {
            cachedsize.numberOfSimultaneousSoundObjects = new cket[numberOfSimultaneousSoundObjects.length];
            for(int j = 0; j < numberOfSimultaneousSoundObjects.length; j++)
                if(numberOfSimultaneousSoundObjects[j] != null)
                    cachedsize.numberOfSimultaneousSoundObjects[j] = numberOfSimultaneousSoundObjects[j].clone();

        }
        if(numberOfSimultaneousSoundFields != null && numberOfSimultaneousSoundFields.length > 0)
        {
            cachedsize.numberOfSimultaneousSoundFields = new cket[numberOfSimultaneousSoundFields.length];
            for(int k = 0; k < numberOfSimultaneousSoundFields.length; k++)
                if(numberOfSimultaneousSoundFields[k] != null)
                    cachedsize.numberOfSimultaneousSoundFields[k] = numberOfSimultaneousSoundFields[k].clone();

        }
        if(cpuMeasurementsPercent != null && cpuMeasurementsPercent.length > 0)
        {
            cachedsize.cpuMeasurementsPercent = new cket[cpuMeasurementsPercent.length];
            for(int l = 0; l < cpuMeasurementsPercent.length; l++)
                if(cpuMeasurementsPercent[l] != null)
                    cachedsize.cpuMeasurementsPercent[l] = cpuMeasurementsPercent[l].clone();

        }
        return cachedsize;
    }

    public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
        throws IOException
    {
        if(renderingMode != null)
            codedoutputbytebuffernano.writeInt32(1, renderingMode.intValue());
        if(sampleRate != null)
            codedoutputbytebuffernano.writeInt32(2, sampleRate.intValue());
        if(framesPerBuffer != null)
            codedoutputbytebuffernano.writeInt32(3, framesPerBuffer.intValue());
        if(renderingTimePerBufferMilliseconds != null && renderingTimePerBufferMilliseconds.length > 0)
        {
            for(int i = 0; i < renderingTimePerBufferMilliseconds.length; i++)
            {
                cket cket;
                if((cket = renderingTimePerBufferMilliseconds[i]) != null)
                    codedoutputbytebuffernano.writeMessage(4, cket);
            }

        }
        if(numberOfSimultaneousSoundObjects != null && numberOfSimultaneousSoundObjects.length > 0)
        {
            for(int j = 0; j < numberOfSimultaneousSoundObjects.length; j++)
            {
                cket cket1;
                if((cket1 = numberOfSimultaneousSoundObjects[j]) != null)
                    codedoutputbytebuffernano.writeMessage(5, cket1);
            }

        }
        if(numberOfSimultaneousSoundFields != null && numberOfSimultaneousSoundFields.length > 0)
        {
            for(int k = 0; k < numberOfSimultaneousSoundFields.length; k++)
            {
                cket cket2;
                if((cket2 = numberOfSimultaneousSoundFields[k]) != null)
                    codedoutputbytebuffernano.writeMessage(6, cket2);
            }

        }
        if(cpuMeasurementsPercent != null && cpuMeasurementsPercent.length > 0)
        {
            for(int l = 0; l < cpuMeasurementsPercent.length; l++)
            {
                cket cket3;
                if((cket3 = cpuMeasurementsPercent[l]) != null)
                    codedoutputbytebuffernano.writeMessage(7, cket3);
            }

        }
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(renderingMode != null)
            i += CodedOutputByteBufferNano.computeInt32Size(1, renderingMode.intValue());
        if(sampleRate != null)
            i += CodedOutputByteBufferNano.computeInt32Size(2, sampleRate.intValue());
        if(framesPerBuffer != null)
            i += CodedOutputByteBufferNano.computeInt32Size(3, framesPerBuffer.intValue());
        if(renderingTimePerBufferMilliseconds != null && renderingTimePerBufferMilliseconds.length > 0)
        {
            for(int j = 0; j < renderingTimePerBufferMilliseconds.length; j++)
            {
                cket cket;
                if((cket = renderingTimePerBufferMilliseconds[j]) != null)
                    i += CodedOutputByteBufferNano.computeMessageSize(4, cket);
            }

        }
        if(numberOfSimultaneousSoundObjects != null && numberOfSimultaneousSoundObjects.length > 0)
        {
            for(int k = 0; k < numberOfSimultaneousSoundObjects.length; k++)
            {
                cket cket1;
                if((cket1 = numberOfSimultaneousSoundObjects[k]) != null)
                    i += CodedOutputByteBufferNano.computeMessageSize(5, cket1);
            }

        }
        if(numberOfSimultaneousSoundFields != null && numberOfSimultaneousSoundFields.length > 0)
        {
            for(int l = 0; l < numberOfSimultaneousSoundFields.length; l++)
            {
                cket cket2;
                if((cket2 = numberOfSimultaneousSoundFields[l]) != null)
                    i += CodedOutputByteBufferNano.computeMessageSize(6, cket2);
            }

        }
        if(cpuMeasurementsPercent != null && cpuMeasurementsPercent.length > 0)
        {
            for(int i1 = 0; i1 < cpuMeasurementsPercent.length; i1++)
            {
                cket cket3;
                if((cket3 = cpuMeasurementsPercent[i1]) != null)
                    i += CodedOutputByteBufferNano.computeMessageSize(7, cket3);
            }

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
                    clone1.renderingMode = Integer.valueOf(j);
                    break;
                }
                break;

            case 16: // '\020'
                clone1.sampleRate = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                break;

            case 24: // '\030'
                clone1.framesPerBuffer = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                break;

            case 34: // '"'
                int k = WireFormatNano.getRepeatedFieldArrayLength(codedinputbytebuffernano1, 34);
                int k1;
                cket acket[] = new cket[(k1 = clone1.renderingTimePerBufferMilliseconds != null ? clone1.renderingTimePerBufferMilliseconds.length : 0) + k];
                if(k1 != 0)
                    System.arraycopy(clone1.renderingTimePerBufferMilliseconds, 0, acket, 0, k1);
                for(; k1 < acket.length - 1; k1++)
                {
                    acket[k1] = new cket();
                    codedinputbytebuffernano1.readMessage(acket[k1]);
                    codedinputbytebuffernano1.readTag();
                }

                acket[k1] = new cket();
                codedinputbytebuffernano1.readMessage(acket[k1]);
                clone1.renderingTimePerBufferMilliseconds = acket;
                break;

            case 42: // '*'
                int l = WireFormatNano.getRepeatedFieldArrayLength(codedinputbytebuffernano1, 42);
                int l1;
                cket acket1[] = new cket[(l1 = clone1.numberOfSimultaneousSoundObjects != null ? clone1.numberOfSimultaneousSoundObjects.length : 0) + l];
                if(l1 != 0)
                    System.arraycopy(clone1.numberOfSimultaneousSoundObjects, 0, acket1, 0, l1);
                for(; l1 < acket1.length - 1; l1++)
                {
                    acket1[l1] = new cket();
                    codedinputbytebuffernano1.readMessage(acket1[l1]);
                    codedinputbytebuffernano1.readTag();
                }

                acket1[l1] = new cket();
                codedinputbytebuffernano1.readMessage(acket1[l1]);
                clone1.numberOfSimultaneousSoundObjects = acket1;
                break;

            case 50: // '2'
                int i1 = WireFormatNano.getRepeatedFieldArrayLength(codedinputbytebuffernano1, 50);
                int i2;
                cket acket2[] = new cket[(i2 = clone1.numberOfSimultaneousSoundFields != null ? clone1.numberOfSimultaneousSoundFields.length : 0) + i1];
                if(i2 != 0)
                    System.arraycopy(clone1.numberOfSimultaneousSoundFields, 0, acket2, 0, i2);
                for(; i2 < acket2.length - 1; i2++)
                {
                    acket2[i2] = new cket();
                    codedinputbytebuffernano1.readMessage(acket2[i2]);
                    codedinputbytebuffernano1.readTag();
                }

                acket2[i2] = new cket();
                codedinputbytebuffernano1.readMessage(acket2[i2]);
                clone1.numberOfSimultaneousSoundFields = acket2;
                break;

            case 58: // ':'
                int j1 = WireFormatNano.getRepeatedFieldArrayLength(codedinputbytebuffernano1, 58);
                int j2;
                cket acket3[] = new cket[(j2 = clone1.cpuMeasurementsPercent != null ? clone1.cpuMeasurementsPercent.length : 0) + j1];
                if(j2 != 0)
                    System.arraycopy(clone1.cpuMeasurementsPercent, 0, acket3, 0, j2);
                for(; j2 < acket3.length - 1; j2++)
                {
                    acket3[j2] = new cket();
                    codedinputbytebuffernano1.readMessage(acket3[j2]);
                    codedinputbytebuffernano1.readTag();
                }

                acket3[j2] = new cket();
                codedinputbytebuffernano1.readMessage(acket3[j2]);
                clone1.cpuMeasurementsPercent = acket3;
                break;
            }
        while(true);
    }

    public final volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    private Integer renderingMode;
    private Integer sampleRate;
    private Integer framesPerBuffer;
    private cket renderingTimePerBufferMilliseconds[];
    private cket numberOfSimultaneousSoundObjects[];
    private cket numberOfSimultaneousSoundFields[];
    private cket cpuMeasurementsPercent[];

    public cket()
    {
        cket cket;
        (cket = this).sampleRate = null;
        cket.framesPerBuffer = null;
        cket.renderingTimePerBufferMilliseconds = com.google.common.logging.nano.cket.emptyArray();
        cket.numberOfSimultaneousSoundObjects = com.google.common.logging.nano.cket.emptyArray();
        cket.numberOfSimultaneousSoundFields = com.google.common.logging.nano.cket.emptyArray();
        cket.cpuMeasurementsPercent = com.google.common.logging.nano.cket.emptyArray();
        cket.unknownFieldData = null;
        cket.cachedSize = -1;
    }
}
