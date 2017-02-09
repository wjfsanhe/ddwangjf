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
        AsyncReprojectionConfig.cachedSize cachedsize;
        try
        {
            cachedsize = (AsyncReprojectionConfig.cachedSize)super.clone();
        }
        catch(CloneNotSupportedException clonenotsupportedexception)
        {
            throw new AssertionError(clonenotsupportedexception);
        }
        class AsyncReprojectionConfig extends ExtendableMessageNano
            implements Cloneable
        {

            public final AsyncReprojectionConfig clone()
            {
                AsyncReprojectionConfig asyncreprojectionconfig;
                try
                {
                    asyncreprojectionconfig = (AsyncReprojectionConfig)super.clone();
                }
                catch(CloneNotSupportedException clonenotsupportedexception1)
                {
                    throw new AssertionError(clonenotsupportedexception1);
                }
                return asyncreprojectionconfig;
            }

            public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
                throws IOException
            {
                if(flags != null)
                    codedoutputbytebuffernano.writeInt64(1, flags.longValue());
                if(displayLatencyMicros != null)
                    codedoutputbytebuffernano.writeInt64(2, displayLatencyMicros.longValue());
                super.writeTo(codedoutputbytebuffernano);
            }

            protected final int computeSerializedSize()
            {
                int i = super.computeSerializedSize();
                if(flags != null)
                    i += CodedOutputByteBufferNano.computeInt64Size(1, flags.longValue());
                if(displayLatencyMicros != null)
                    i += CodedOutputByteBufferNano.computeInt64Size(2, displayLatencyMicros.longValue());
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
                AsyncReprojectionConfig asyncreprojectionconfig = this;
                int i;
                do
                    switch(i = codedinputbytebuffernano1.readTag())
                    {
                    case 0: // '\0'
                        return asyncreprojectionconfig;

                    default:
                        if(!asyncreprojectionconfig.super.storeUnknownField(codedinputbytebuffernano1, i))
                            return asyncreprojectionconfig;
                        break;

                    case 8: // '\b'
                        asyncreprojectionconfig.flags = Long.valueOf(codedinputbytebuffernano1.readInt64());
                        break;

                    case 16: // '\020'
                        asyncreprojectionconfig.displayLatencyMicros = Long.valueOf(codedinputbytebuffernano1.readInt64());
                        break;
                    }
                while(true);
            }

            public final volatile Object clone()
                throws CloneNotSupportedException
            {
                return clone();
            }

            private Long flags;
            private Long displayLatencyMicros;

            public AsyncReprojectionConfig()
            {
                AsyncReprojectionConfig asyncreprojectionconfig;
                (asyncreprojectionconfig = this).flags = null;
                asyncreprojectionconfig.displayLatencyMicros = null;
                asyncreprojectionconfig.unknownFieldData = null;
                asyncreprojectionconfig.cachedSize = -1;
            }
        }

        if(asyncReprojectionConfig != null)
            cachedsize.asyncReprojectionConfig = asyncReprojectionConfig.clone();
        return cachedsize;
    }

    public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
        throws IOException
    {
        if(daydreamImageAlignmentEnabled != null)
            codedoutputbytebuffernano.writeBool(1, daydreamImageAlignmentEnabled.booleanValue());
        if(useSystemClockForSensorTimestamps != null)
            codedoutputbytebuffernano.writeBool(2, useSystemClockForSensorTimestamps.booleanValue());
        if(useMagnetometerInSensorFusion != null)
            codedoutputbytebuffernano.writeBool(3, useMagnetometerInSensorFusion.booleanValue());
        if(allowDynamicLibraryLoading != null)
            codedoutputbytebuffernano.writeBool(4, allowDynamicLibraryLoading.booleanValue());
        if(cpuLateLatchingEnabled != null)
            codedoutputbytebuffernano.writeBool(5, cpuLateLatchingEnabled.booleanValue());
        if(daydreamImageAlignment != null)
            codedoutputbytebuffernano.writeInt32(6, daydreamImageAlignment.intValue());
        if(asyncReprojectionConfig != null)
            codedoutputbytebuffernano.writeMessage(7, asyncReprojectionConfig);
        if(useOnlineMagnetometerCalibration != null)
            codedoutputbytebuffernano.writeBool(8, useOnlineMagnetometerCalibration.booleanValue());
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(daydreamImageAlignmentEnabled != null)
            i += CodedOutputByteBufferNano.computeBoolSize(1, daydreamImageAlignmentEnabled.booleanValue());
        if(useSystemClockForSensorTimestamps != null)
            i += CodedOutputByteBufferNano.computeBoolSize(2, useSystemClockForSensorTimestamps.booleanValue());
        if(useMagnetometerInSensorFusion != null)
            i += CodedOutputByteBufferNano.computeBoolSize(3, useMagnetometerInSensorFusion.booleanValue());
        if(allowDynamicLibraryLoading != null)
            i += CodedOutputByteBufferNano.computeBoolSize(4, allowDynamicLibraryLoading.booleanValue());
        if(cpuLateLatchingEnabled != null)
            i += CodedOutputByteBufferNano.computeBoolSize(5, cpuLateLatchingEnabled.booleanValue());
        if(daydreamImageAlignment != null)
            i += CodedOutputByteBufferNano.computeInt32Size(6, daydreamImageAlignment.intValue());
        if(asyncReprojectionConfig != null)
            i += CodedOutputByteBufferNano.computeMessageSize(7, asyncReprojectionConfig);
        if(useOnlineMagnetometerCalibration != null)
            i += CodedOutputByteBufferNano.computeBoolSize(8, useOnlineMagnetometerCalibration.booleanValue());
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
                clone1.daydreamImageAlignmentEnabled = Boolean.valueOf(codedinputbytebuffernano1.readBool());
                break;

            case 16: // '\020'
                clone1.useSystemClockForSensorTimestamps = Boolean.valueOf(codedinputbytebuffernano1.readBool());
                break;

            case 24: // '\030'
                clone1.useMagnetometerInSensorFusion = Boolean.valueOf(codedinputbytebuffernano1.readBool());
                break;

            case 32: // ' '
                clone1.allowDynamicLibraryLoading = Boolean.valueOf(codedinputbytebuffernano1.readBool());
                break;

            case 40: // '('
                clone1.cpuLateLatchingEnabled = Boolean.valueOf(codedinputbytebuffernano1.readBool());
                break;

            case 48: // '0'
                switch(j = codedinputbytebuffernano1.readInt32())
                {
                case 0: // '\0'
                case 1: // '\001'
                case 2: // '\002'
                case 3: // '\003'
                    clone1.daydreamImageAlignment = Integer.valueOf(j);
                    break;
                }
                break;

            case 58: // ':'
                if(clone1.asyncReprojectionConfig == null)
                    clone1.asyncReprojectionConfig = new AsyncReprojectionConfig();
                codedinputbytebuffernano1.readMessage(clone1.asyncReprojectionConfig);
                break;

            case 64: // '@'
                clone1.useOnlineMagnetometerCalibration = Boolean.valueOf(codedinputbytebuffernano1.readBool());
                break;
            }
        while(true);
    }

    public final volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    private Boolean daydreamImageAlignmentEnabled;
    public Boolean useSystemClockForSensorTimestamps;
    public Boolean useMagnetometerInSensorFusion;
    public Boolean allowDynamicLibraryLoading;
    public Boolean cpuLateLatchingEnabled;
    public Integer daydreamImageAlignment;
    public AsyncReprojectionConfig asyncReprojectionConfig;
    public Boolean useOnlineMagnetometerCalibration;

    public AsyncReprojectionConfig()
    {
        AsyncReprojectionConfig asyncreprojectionconfig;
        (asyncreprojectionconfig = this).daydreamImageAlignmentEnabled = null;
        asyncreprojectionconfig.useSystemClockForSensorTimestamps = null;
        asyncreprojectionconfig.useMagnetometerInSensorFusion = null;
        asyncreprojectionconfig.allowDynamicLibraryLoading = null;
        asyncreprojectionconfig.cpuLateLatchingEnabled = null;
        asyncreprojectionconfig.asyncReprojectionConfig = null;
        asyncreprojectionconfig.useOnlineMagnetometerCalibration = null;
        asyncreprojectionconfig.unknownFieldData = null;
        asyncreprojectionconfig.cachedSize = -1;
    }
}
