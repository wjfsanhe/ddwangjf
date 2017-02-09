// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Analytics.java

package com.google.vrtoolkit.cardboard.proto.nano;

import com.google.protobuf.nano.*;
import java.io.IOException;

public interface Analytics
{
    public static final class AsyncReprojectionAnalytics extends ExtendableMessageNano
        implements Cloneable
    {

        public static AsyncReprojectionAnalytics[] emptyArray()
        {
            if(_emptyArray == null)
                synchronized(InternalNano.LAZY_INIT_LOCK)
                {
                    if(_emptyArray == null)
                        _emptyArray = new AsyncReprojectionAnalytics[0];
                }
            return _emptyArray;
        }

        public final int getTotalMissedVsyncs()
        {
            return totalMissedVsyncs_;
        }

        public final AsyncReprojectionAnalytics setTotalMissedVsyncs(int i)
        {
            totalMissedVsyncs_ = i;
            bitField0_ |= 1;
            return this;
        }

        public final boolean hasTotalMissedVsyncs()
        {
            return (bitField0_ & 1) != 0;
        }

        public final AsyncReprojectionAnalytics clearTotalMissedVsyncs()
        {
            totalMissedVsyncs_ = 0;
            bitField0_ = bitField0_ & -2;
            return this;
        }

        public final float getFps()
        {
            return fps_;
        }

        public final AsyncReprojectionAnalytics setFps(float f)
        {
            fps_ = f;
            bitField0_ |= 2;
            return this;
        }

        public final boolean hasFps()
        {
            return (bitField0_ & 2) != 0;
        }

        public final AsyncReprojectionAnalytics clearFps()
        {
            fps_ = 0.0F;
            bitField0_ = bitField0_ & -3;
            return this;
        }

        public final AsyncReprojectionAnalytics clear()
        {
            bitField0_ = 0;
            totalMissedVsyncs_ = 0;
            fps_ = 0.0F;
            unknownFieldData = null;
            cachedSize = -1;
            return this;
        }

        public final AsyncReprojectionAnalytics clone()
        {
            AsyncReprojectionAnalytics asyncreprojectionanalytics;
            try
            {
                asyncreprojectionanalytics = (AsyncReprojectionAnalytics)super.clone();
            }
            catch(CloneNotSupportedException clonenotsupportedexception)
            {
                throw new AssertionError(clonenotsupportedexception);
            }
            return asyncreprojectionanalytics;
        }

        public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
            throws IOException
        {
            if((bitField0_ & 1) != 0)
                codedoutputbytebuffernano.writeInt32(1, totalMissedVsyncs_);
            if((bitField0_ & 2) != 0)
                codedoutputbytebuffernano.writeFloat(2, fps_);
            super.writeTo(codedoutputbytebuffernano);
        }

        protected final int computeSerializedSize()
        {
            int i = super.computeSerializedSize();
            if((bitField0_ & 1) != 0)
                i += CodedOutputByteBufferNano.computeInt32Size(1, totalMissedVsyncs_);
            if((bitField0_ & 2) != 0)
                i += CodedOutputByteBufferNano.computeFloatSize(2, fps_);
            return i;
        }

        public final AsyncReprojectionAnalytics mergeFrom(CodedInputByteBufferNano codedinputbytebuffernano)
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
                    totalMissedVsyncs_ = codedinputbytebuffernano.readInt32();
                    bitField0_ |= 1;
                    break;

                case 21: // '\025'
                    fps_ = codedinputbytebuffernano.readFloat();
                    bitField0_ |= 2;
                    break;
                }
            while(true);
        }

        public static AsyncReprojectionAnalytics parseFrom(byte abyte0[])
            throws InvalidProtocolBufferNanoException
        {
            return (AsyncReprojectionAnalytics)MessageNano.mergeFrom(new AsyncReprojectionAnalytics(), abyte0);
        }

        public static AsyncReprojectionAnalytics parseFrom(CodedInputByteBufferNano codedinputbytebuffernano)
            throws IOException
        {
            return (new AsyncReprojectionAnalytics()).mergeFrom(codedinputbytebuffernano);
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

        private static volatile AsyncReprojectionAnalytics _emptyArray[];
        private int bitField0_;
        private int totalMissedVsyncs_;
        private float fps_;

        public AsyncReprojectionAnalytics()
        {
            clear();
        }
    }

    public static final class AnalyticsSample extends ExtendableMessageNano
        implements Cloneable
    {

        public static AnalyticsSample[] emptyArray()
        {
            if(_emptyArray == null)
                synchronized(InternalNano.LAZY_INIT_LOCK)
                {
                    if(_emptyArray == null)
                        _emptyArray = new AnalyticsSample[0];
                }
            return _emptyArray;
        }

        public final AnalyticsSample clear()
        {
            asyncReprojectionAnalytics = null;
            unknownFieldData = null;
            cachedSize = -1;
            return this;
        }

        public final AnalyticsSample clone()
        {
            AnalyticsSample analyticssample;
            try
            {
                analyticssample = (AnalyticsSample)super.clone();
            }
            catch(CloneNotSupportedException clonenotsupportedexception)
            {
                throw new AssertionError(clonenotsupportedexception);
            }
            if(asyncReprojectionAnalytics != null)
                analyticssample.asyncReprojectionAnalytics = asyncReprojectionAnalytics.clone();
            return analyticssample;
        }

        public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
            throws IOException
        {
            if(asyncReprojectionAnalytics != null)
                codedoutputbytebuffernano.writeMessage(1, asyncReprojectionAnalytics);
            super.writeTo(codedoutputbytebuffernano);
        }

        protected final int computeSerializedSize()
        {
            int i = super.computeSerializedSize();
            if(asyncReprojectionAnalytics != null)
                i += CodedOutputByteBufferNano.computeMessageSize(1, asyncReprojectionAnalytics);
            return i;
        }

        public final AnalyticsSample mergeFrom(CodedInputByteBufferNano codedinputbytebuffernano)
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

                case 10: // '\n'
                    if(asyncReprojectionAnalytics == null)
                        asyncReprojectionAnalytics = new AsyncReprojectionAnalytics();
                    codedinputbytebuffernano.readMessage(asyncReprojectionAnalytics);
                    break;
                }
            while(true);
        }

        public static AnalyticsSample parseFrom(byte abyte0[])
            throws InvalidProtocolBufferNanoException
        {
            return (AnalyticsSample)MessageNano.mergeFrom(new AnalyticsSample(), abyte0);
        }

        public static AnalyticsSample parseFrom(CodedInputByteBufferNano codedinputbytebuffernano)
            throws IOException
        {
            return (new AnalyticsSample()).mergeFrom(codedinputbytebuffernano);
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

        private static volatile AnalyticsSample _emptyArray[];
        public AsyncReprojectionAnalytics asyncReprojectionAnalytics;

        public AnalyticsSample()
        {
            clear();
        }
    }

}
