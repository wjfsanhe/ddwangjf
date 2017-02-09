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
        GyroscopeStats.cachedSize cachedsize;
        try
        {
            cachedsize = (GyroscopeStats.cachedSize)super.clone();
        }
        catch(CloneNotSupportedException clonenotsupportedexception)
        {
            throw new AssertionError(clonenotsupportedexception);
        }
        class GyroscopeStats extends ExtendableMessageNano
            implements Cloneable
        {

            public final GyroscopeStats clone()
            {
                GyroscopeStats gyroscopestats;
                try
                {
                    gyroscopestats = (GyroscopeStats)super.clone();
                }
                catch(CloneNotSupportedException clonenotsupportedexception1)
                {
                    throw new AssertionError(clonenotsupportedexception1);
                }
                class Vector3 extends ExtendableMessageNano
                    implements Cloneable
                {

                    public final Vector3 clone()
                    {
                        Vector3 vector3;
                        try
                        {
                            vector3 = (Vector3)super.clone();
                        }
                        catch(CloneNotSupportedException clonenotsupportedexception2)
                        {
                            throw new AssertionError(clonenotsupportedexception2);
                        }
                        return vector3;
                    }

                    public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
                        throws IOException
                    {
                        if(x != null)
                            codedoutputbytebuffernano.writeFloat(1, x.floatValue());
                        if(y != null)
                            codedoutputbytebuffernano.writeFloat(2, y.floatValue());
                        if(z != null)
                            codedoutputbytebuffernano.writeFloat(3, z.floatValue());
                        super.writeTo(codedoutputbytebuffernano);
                    }

                    protected final int computeSerializedSize()
                    {
                        int i = super.computeSerializedSize();
                        if(x != null)
                            i += CodedOutputByteBufferNano.computeFloatSize(1, x.floatValue());
                        if(y != null)
                            i += CodedOutputByteBufferNano.computeFloatSize(2, y.floatValue());
                        if(z != null)
                            i += CodedOutputByteBufferNano.computeFloatSize(3, z.floatValue());
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
                        Vector3 vector3 = this;
                        int i;
                        do
                            switch(i = codedinputbytebuffernano1.readTag())
                            {
                            case 0: // '\0'
                                return vector3;

                            default:
                                if(!vector3.super.storeUnknownField(codedinputbytebuffernano1, i))
                                    return vector3;
                                break;

                            case 13: // '\r'
                                vector3.x = Float.valueOf(codedinputbytebuffernano1.readFloat());
                                break;

                            case 21: // '\025'
                                vector3.y = Float.valueOf(codedinputbytebuffernano1.readFloat());
                                break;

                            case 29: // '\035'
                                vector3.z = Float.valueOf(codedinputbytebuffernano1.readFloat());
                                break;
                            }
                        while(true);
                    }

                    public final volatile Object clone()
                        throws CloneNotSupportedException
                    {
                        return clone();
                    }

                    private Float x;
                    private Float y;
                    private Float z;

                        public Vector3()
                        {
                            Vector3 vector3;
                            (vector3 = this).x = null;
                            vector3.y = null;
                            vector3.z = null;
                            vector3.unknownFieldData = null;
                            vector3.cachedSize = -1;
                        }
                }

                if(bias != null)
                    gyroscopestats.bias = bias.clone();
                if(lowerBound != null)
                    gyroscopestats.lowerBound = lowerBound.clone();
                if(upperBound != null)
                    gyroscopestats.upperBound = upperBound.clone();
                if(standardDeviation != null)
                    gyroscopestats.standardDeviation = standardDeviation.clone();
                return gyroscopestats;
            }

            public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
                throws IOException
            {
                if(bias != null)
                    codedoutputbytebuffernano.writeMessage(1, bias);
                if(lowerBound != null)
                    codedoutputbytebuffernano.writeMessage(2, lowerBound);
                if(upperBound != null)
                    codedoutputbytebuffernano.writeMessage(3, upperBound);
                if(standardDeviation != null)
                    codedoutputbytebuffernano.writeMessage(4, standardDeviation);
                super.writeTo(codedoutputbytebuffernano);
            }

            protected final int computeSerializedSize()
            {
                int i = super.computeSerializedSize();
                if(bias != null)
                    i += CodedOutputByteBufferNano.computeMessageSize(1, bias);
                if(lowerBound != null)
                    i += CodedOutputByteBufferNano.computeMessageSize(2, lowerBound);
                if(upperBound != null)
                    i += CodedOutputByteBufferNano.computeMessageSize(3, upperBound);
                if(standardDeviation != null)
                    i += CodedOutputByteBufferNano.computeMessageSize(4, standardDeviation);
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
                GyroscopeStats gyroscopestats = this;
                int i;
                do
                    switch(i = codedinputbytebuffernano1.readTag())
                    {
                    case 0: // '\0'
                        return gyroscopestats;

                    default:
                        if(!gyroscopestats.super.storeUnknownField(codedinputbytebuffernano1, i))
                            return gyroscopestats;
                        break;

                    case 10: // '\n'
                        if(gyroscopestats.bias == null)
                            gyroscopestats.bias = new Vector3();
                        codedinputbytebuffernano1.readMessage(gyroscopestats.bias);
                        break;

                    case 18: // '\022'
                        if(gyroscopestats.lowerBound == null)
                            gyroscopestats.lowerBound = new Vector3();
                        codedinputbytebuffernano1.readMessage(gyroscopestats.lowerBound);
                        break;

                    case 26: // '\032'
                        if(gyroscopestats.upperBound == null)
                            gyroscopestats.upperBound = new Vector3();
                        codedinputbytebuffernano1.readMessage(gyroscopestats.upperBound);
                        break;

                    case 34: // '"'
                        if(gyroscopestats.standardDeviation == null)
                            gyroscopestats.standardDeviation = new Vector3();
                        codedinputbytebuffernano1.readMessage(gyroscopestats.standardDeviation);
                        break;
                    }
                while(true);
            }

            public final volatile Object clone()
                throws CloneNotSupportedException
            {
                return clone();
            }

            private Vector3 bias;
            private Vector3 lowerBound;
            private Vector3 upperBound;
            private Vector3 standardDeviation;

            public GyroscopeStats()
            {
                GyroscopeStats gyroscopestats;
                (gyroscopestats = this).bias = null;
                gyroscopestats.lowerBound = null;
                gyroscopestats.upperBound = null;
                gyroscopestats.standardDeviation = null;
                gyroscopestats.unknownFieldData = null;
                gyroscopestats.cachedSize = -1;
            }
        }

        if(gyroscopeStats != null)
            cachedsize.gyroscopeStats = gyroscopeStats.clone();
        return cachedsize;
    }

    public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
        throws IOException
    {
        if(gyroscopeStats != null)
            codedoutputbytebuffernano.writeMessage(1, gyroscopeStats);
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(gyroscopeStats != null)
            i += CodedOutputByteBufferNano.computeMessageSize(1, gyroscopeStats);
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

            case 10: // '\n'
                if(clone1.gyroscopeStats == null)
                    clone1.gyroscopeStats = new GyroscopeStats();
                codedinputbytebuffernano1.readMessage(clone1.gyroscopeStats);
                break;
            }
        while(true);
    }

    public final volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    private GyroscopeStats gyroscopeStats;

    public GyroscopeStats()
    {
        GyroscopeStats gyroscopestats;
        (gyroscopestats = this).gyroscopeStats = null;
        gyroscopestats.unknownFieldData = null;
        gyroscopestats.cachedSize = -1;
    }
}
