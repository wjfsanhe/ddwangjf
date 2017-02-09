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
        if(gConfigValue != null && gConfigValue.length > 0)
        {
            cachedsize.gConfigValue = new GConfigValue[gConfigValue.length];
            for(int i = 0; i < gConfigValue.length; i++)
                if(gConfigValue[i] != null)
                    cachedsize.gConfigValue[i] = gConfigValue[i].clone();

        }
        return cachedsize;
    }

    public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
        throws IOException
    {
        if(gConfigValue != null && gConfigValue.length > 0)
        {
            for(int i = 0; i < gConfigValue.length; i++)
            {
                GConfigValue gconfigvalue;
                if((gconfigvalue = gConfigValue[i]) != null)
                    codedoutputbytebuffernano.writeMessage(1, gconfigvalue);
            }

        }
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(gConfigValue != null && gConfigValue.length > 0)
        {
            for(int j = 0; j < gConfigValue.length; j++)
            {
                GConfigValue gconfigvalue;
                if((gconfigvalue = gConfigValue[j]) != null)
                    i += CodedOutputByteBufferNano.computeMessageSize(1, gconfigvalue);
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
                int j = WireFormatNano.getRepeatedFieldArrayLength(codedinputbytebuffernano1, 10);
                int k;
                GConfigValue agconfigvalue[] = new GConfigValue[(k = clone1.gConfigValue != null ? clone1.gConfigValue.length : 0) + j];
                if(k != 0)
                    System.arraycopy(clone1.gConfigValue, 0, agconfigvalue, 0, k);
                for(; k < agconfigvalue.length - 1; k++)
                {
                    agconfigvalue[k] = new GConfigValue();
                    codedinputbytebuffernano1.readMessage(agconfigvalue[k]);
                    codedinputbytebuffernano1.readTag();
                }

                agconfigvalue[k] = new GConfigValue();
                codedinputbytebuffernano1.readMessage(agconfigvalue[k]);
                clone1.gConfigValue = agconfigvalue;
                break;
            }
        while(true);
    }

    public final volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    private GConfigValue gConfigValue[];

    public GConfigValue.cachedSize()
    {
        class GConfigValue extends ExtendableMessageNano
            implements Cloneable
        {

            public static GConfigValue[] emptyArray()
            {
                if(_emptyArray == null)
                    synchronized(InternalNano.LAZY_INIT_LOCK)
                    {
                        if(_emptyArray == null)
                            _emptyArray = new GConfigValue[0];
                    }
                return _emptyArray;
            }

            public final GConfigValue clone()
            {
                GConfigValue gconfigvalue;
                try
                {
                    gconfigvalue = (GConfigValue)super.clone();
                }
                catch(CloneNotSupportedException clonenotsupportedexception)
                {
                    throw new AssertionError(clonenotsupportedexception);
                }
                return gconfigvalue;
            }

            public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
                throws IOException
            {
                if(gConfigKey != null)
                    codedoutputbytebuffernano.writeString(1, gConfigKey);
                if(stringValue != null)
                    codedoutputbytebuffernano.writeString(2, stringValue);
                super.writeTo(codedoutputbytebuffernano);
            }

            protected final int computeSerializedSize()
            {
                int i = super.computeSerializedSize();
                if(gConfigKey != null)
                    i += CodedOutputByteBufferNano.computeStringSize(1, gConfigKey);
                if(stringValue != null)
                    i += CodedOutputByteBufferNano.computeStringSize(2, stringValue);
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
                GConfigValue gconfigvalue = this;
                int i;
                do
                    switch(i = codedinputbytebuffernano1.readTag())
                    {
                    case 0: // '\0'
                        return gconfigvalue;

                    default:
                        if(!gconfigvalue.super.storeUnknownField(codedinputbytebuffernano1, i))
                            return gconfigvalue;
                        break;

                    case 10: // '\n'
                        gconfigvalue.gConfigKey = codedinputbytebuffernano1.readString();
                        break;

                    case 18: // '\022'
                        gconfigvalue.stringValue = codedinputbytebuffernano1.readString();
                        break;
                    }
                while(true);
            }

            public final volatile Object clone()
                throws CloneNotSupportedException
            {
                return clone();
            }

            private static volatile GConfigValue _emptyArray[];
            private String gConfigKey;
            private String stringValue;

            public GConfigValue()
            {
                GConfigValue gconfigvalue;
                (gconfigvalue = this).gConfigKey = null;
                gconfigvalue.stringValue = null;
                gconfigvalue.unknownFieldData = null;
                gconfigvalue.cachedSize = -1;
            }
        }

        GConfigValue.cachedSize cachedsize;
        (cachedsize = this).gConfigValue = GConfigValue.emptyArray();
        cachedsize.unknownFieldData = null;
        cachedsize.cachedSize = -1;
    }
}
