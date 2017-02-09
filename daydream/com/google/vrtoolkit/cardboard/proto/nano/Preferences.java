// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Preferences.java

package com.google.vrtoolkit.cardboard.proto.nano;

import com.google.protobuf.nano.*;
import java.io.IOException;

public interface Preferences
{
    public static final class DeveloperPrefs extends ExtendableMessageNano
        implements Cloneable
    {

        public static DeveloperPrefs[] emptyArray()
        {
            if(_emptyArray == null)
                synchronized(InternalNano.LAZY_INIT_LOCK)
                {
                    if(_emptyArray == null)
                        _emptyArray = new DeveloperPrefs[0];
                }
            return _emptyArray;
        }

        public final boolean getPerformanceMonitoringEnabled()
        {
            return performanceMonitoringEnabled_;
        }

        public final DeveloperPrefs setPerformanceMonitoringEnabled(boolean flag)
        {
            performanceMonitoringEnabled_ = flag;
            bitField0_ |= 1;
            return this;
        }

        public final boolean hasPerformanceMonitoringEnabled()
        {
            return (bitField0_ & 1) != 0;
        }

        public final DeveloperPrefs clearPerformanceMonitoringEnabled()
        {
            performanceMonitoringEnabled_ = false;
            bitField0_ = bitField0_ & -2;
            return this;
        }

        public final boolean getSensorLoggingEnabled()
        {
            return sensorLoggingEnabled_;
        }

        public final DeveloperPrefs setSensorLoggingEnabled(boolean flag)
        {
            sensorLoggingEnabled_ = flag;
            bitField0_ |= 2;
            return this;
        }

        public final boolean hasSensorLoggingEnabled()
        {
            return (bitField0_ & 2) != 0;
        }

        public final DeveloperPrefs clearSensorLoggingEnabled()
        {
            sensorLoggingEnabled_ = false;
            bitField0_ = bitField0_ & -3;
            return this;
        }

        public final boolean getMotophoPatchEnabled()
        {
            return motophoPatchEnabled_;
        }

        public final DeveloperPrefs setMotophoPatchEnabled(boolean flag)
        {
            motophoPatchEnabled_ = flag;
            bitField0_ |= 4;
            return this;
        }

        public final boolean hasMotophoPatchEnabled()
        {
            return (bitField0_ & 4) != 0;
        }

        public final DeveloperPrefs clearMotophoPatchEnabled()
        {
            motophoPatchEnabled_ = false;
            bitField0_ = bitField0_ & -5;
            return this;
        }

        public final boolean getDeveloperLoggingEnabled()
        {
            return developerLoggingEnabled_;
        }

        public final DeveloperPrefs setDeveloperLoggingEnabled(boolean flag)
        {
            developerLoggingEnabled_ = flag;
            bitField0_ |= 8;
            return this;
        }

        public final boolean hasDeveloperLoggingEnabled()
        {
            return (bitField0_ & 8) != 0;
        }

        public final DeveloperPrefs clearDeveloperLoggingEnabled()
        {
            developerLoggingEnabled_ = false;
            bitField0_ = bitField0_ & -9;
            return this;
        }

        public final DeveloperPrefs clear()
        {
            bitField0_ = 0;
            performanceMonitoringEnabled_ = false;
            sensorLoggingEnabled_ = false;
            motophoPatchEnabled_ = false;
            developerLoggingEnabled_ = false;
            unknownFieldData = null;
            cachedSize = -1;
            return this;
        }

        public final DeveloperPrefs clone()
        {
            DeveloperPrefs developerprefs;
            try
            {
                developerprefs = (DeveloperPrefs)super.clone();
            }
            catch(CloneNotSupportedException clonenotsupportedexception)
            {
                throw new AssertionError(clonenotsupportedexception);
            }
            return developerprefs;
        }

        public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
            throws IOException
        {
            if((bitField0_ & 1) != 0)
                codedoutputbytebuffernano.writeBool(1, performanceMonitoringEnabled_);
            if((bitField0_ & 2) != 0)
                codedoutputbytebuffernano.writeBool(2, sensorLoggingEnabled_);
            if((bitField0_ & 4) != 0)
                codedoutputbytebuffernano.writeBool(3, motophoPatchEnabled_);
            if((bitField0_ & 8) != 0)
                codedoutputbytebuffernano.writeBool(4, developerLoggingEnabled_);
            super.writeTo(codedoutputbytebuffernano);
        }

        protected final int computeSerializedSize()
        {
            int i = super.computeSerializedSize();
            if((bitField0_ & 1) != 0)
                i += CodedOutputByteBufferNano.computeBoolSize(1, performanceMonitoringEnabled_);
            if((bitField0_ & 2) != 0)
                i += CodedOutputByteBufferNano.computeBoolSize(2, sensorLoggingEnabled_);
            if((bitField0_ & 4) != 0)
                i += CodedOutputByteBufferNano.computeBoolSize(3, motophoPatchEnabled_);
            if((bitField0_ & 8) != 0)
                i += CodedOutputByteBufferNano.computeBoolSize(4, developerLoggingEnabled_);
            return i;
        }

        public final DeveloperPrefs mergeFrom(CodedInputByteBufferNano codedinputbytebuffernano)
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
                    performanceMonitoringEnabled_ = codedinputbytebuffernano.readBool();
                    bitField0_ |= 1;
                    break;

                case 16: // '\020'
                    sensorLoggingEnabled_ = codedinputbytebuffernano.readBool();
                    bitField0_ |= 2;
                    break;

                case 24: // '\030'
                    motophoPatchEnabled_ = codedinputbytebuffernano.readBool();
                    bitField0_ |= 4;
                    break;

                case 32: // ' '
                    developerLoggingEnabled_ = codedinputbytebuffernano.readBool();
                    bitField0_ |= 8;
                    break;
                }
            while(true);
        }

        public static DeveloperPrefs parseFrom(byte abyte0[])
            throws InvalidProtocolBufferNanoException
        {
            return (DeveloperPrefs)MessageNano.mergeFrom(new DeveloperPrefs(), abyte0);
        }

        public static DeveloperPrefs parseFrom(CodedInputByteBufferNano codedinputbytebuffernano)
            throws IOException
        {
            return (new DeveloperPrefs()).mergeFrom(codedinputbytebuffernano);
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

        private static volatile DeveloperPrefs _emptyArray[];
        private int bitField0_;
        private boolean performanceMonitoringEnabled_;
        private boolean sensorLoggingEnabled_;
        private boolean motophoPatchEnabled_;
        private boolean developerLoggingEnabled_;

        public DeveloperPrefs()
        {
            clear();
        }
    }

    public static final class UserPrefs extends ExtendableMessageNano
        implements Cloneable
    {
        public static interface Handedness
        {

            public static final int RIGHT_HANDED = 0;
            public static final int LEFT_HANDED = 1;
        }


        public static UserPrefs[] emptyArray()
        {
            if(_emptyArray == null)
                synchronized(InternalNano.LAZY_INIT_LOCK)
                {
                    if(_emptyArray == null)
                        _emptyArray = new UserPrefs[0];
                }
            return _emptyArray;
        }

        public final int getControllerHandedness()
        {
            return controllerHandedness_;
        }

        public final UserPrefs setControllerHandedness(int i)
        {
            controllerHandedness_ = i;
            bitField0_ |= 1;
            return this;
        }

        public final boolean hasControllerHandedness()
        {
            return (bitField0_ & 1) != 0;
        }

        public final UserPrefs clearControllerHandedness()
        {
            controllerHandedness_ = 0;
            bitField0_ = bitField0_ & -2;
            return this;
        }

        public final UserPrefs clear()
        {
            bitField0_ = 0;
            controllerHandedness_ = 0;
            developerPrefs = null;
            unknownFieldData = null;
            cachedSize = -1;
            return this;
        }

        public final UserPrefs clone()
        {
            UserPrefs userprefs;
            try
            {
                userprefs = (UserPrefs)super.clone();
            }
            catch(CloneNotSupportedException clonenotsupportedexception)
            {
                throw new AssertionError(clonenotsupportedexception);
            }
            if(developerPrefs != null)
                userprefs.developerPrefs = developerPrefs.clone();
            return userprefs;
        }

        public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
            throws IOException
        {
            if((bitField0_ & 1) != 0)
                codedoutputbytebuffernano.writeInt32(1, controllerHandedness_);
            if(developerPrefs != null)
                codedoutputbytebuffernano.writeMessage(2, developerPrefs);
            super.writeTo(codedoutputbytebuffernano);
        }

        protected final int computeSerializedSize()
        {
            int i = super.computeSerializedSize();
            if((bitField0_ & 1) != 0)
                i += CodedOutputByteBufferNano.computeInt32Size(1, controllerHandedness_);
            if(developerPrefs != null)
                i += CodedOutputByteBufferNano.computeMessageSize(2, developerPrefs);
            return i;
        }

        public final UserPrefs mergeFrom(CodedInputByteBufferNano codedinputbytebuffernano)
            throws IOException
        {
            int i;
            int j;
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
                    switch(j = codedinputbytebuffernano.readInt32())
                    {
                    case 0: // '\0'
                    case 1: // '\001'
                        controllerHandedness_ = j;
                        bitField0_ |= 1;
                        break;
                    }
                    break;

                case 18: // '\022'
                    if(developerPrefs == null)
                        developerPrefs = new DeveloperPrefs();
                    codedinputbytebuffernano.readMessage(developerPrefs);
                    break;
                }
            while(true);
        }

        public static UserPrefs parseFrom(byte abyte0[])
            throws InvalidProtocolBufferNanoException
        {
            return (UserPrefs)MessageNano.mergeFrom(new UserPrefs(), abyte0);
        }

        public static UserPrefs parseFrom(CodedInputByteBufferNano codedinputbytebuffernano)
            throws IOException
        {
            return (new UserPrefs()).mergeFrom(codedinputbytebuffernano);
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

        private static volatile UserPrefs _emptyArray[];
        private int bitField0_;
        private int controllerHandedness_;
        public DeveloperPrefs developerPrefs;

        public UserPrefs()
        {
            clear();
        }
    }

}
