// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Nfc.java

package com.google.vr.vrcore.proto.nano;

import com.google.protobuf.nano.*;
import java.io.IOException;

public interface Nfc
{
    public static final class NfcParams extends ExtendableMessageNano
        implements Cloneable
    {

        public static NfcParams[] emptyArray()
        {
            if(_emptyArray == null)
                synchronized(InternalNano.LAZY_INIT_LOCK)
                {
                    if(_emptyArray == null)
                        _emptyArray = new NfcParams[0];
                }
            return _emptyArray;
        }

        public final int getViewerId()
        {
            return viewerId_;
        }

        public final NfcParams setViewerId(int i)
        {
            viewerId_ = i;
            bitField0_ |= 1;
            return this;
        }

        public final boolean hasViewerId()
        {
            return (bitField0_ & 1) != 0;
        }

        public final NfcParams clearViewerId()
        {
            viewerId_ = 0;
            bitField0_ = bitField0_ & -2;
            return this;
        }

        public final NfcParams clear()
        {
            bitField0_ = 0;
            viewerId_ = 0;
            unknownFieldData = null;
            cachedSize = -1;
            return this;
        }

        public final NfcParams clone()
        {
            NfcParams nfcparams;
            try
            {
                nfcparams = (NfcParams)super.clone();
            }
            catch(CloneNotSupportedException clonenotsupportedexception)
            {
                throw new AssertionError(clonenotsupportedexception);
            }
            return nfcparams;
        }

        public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
            throws IOException
        {
            if((bitField0_ & 1) != 0)
                codedoutputbytebuffernano.writeInt32(1, viewerId_);
            super.writeTo(codedoutputbytebuffernano);
        }

        protected final int computeSerializedSize()
        {
            int i = super.computeSerializedSize();
            if((bitField0_ & 1) != 0)
                i += CodedOutputByteBufferNano.computeInt32Size(1, viewerId_);
            return i;
        }

        public final NfcParams mergeFrom(CodedInputByteBufferNano codedinputbytebuffernano)
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
                    viewerId_ = codedinputbytebuffernano.readInt32();
                    bitField0_ |= 1;
                    break;
                }
            while(true);
        }

        public static NfcParams parseFrom(byte abyte0[])
            throws InvalidProtocolBufferNanoException
        {
            return (NfcParams)MessageNano.mergeFrom(new NfcParams(), abyte0);
        }

        public static NfcParams parseFrom(CodedInputByteBufferNano codedinputbytebuffernano)
            throws IOException
        {
            return (new NfcParams()).mergeFrom(codedinputbytebuffernano);
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

        private static volatile NfcParams _emptyArray[];
        private int bitField0_;
        private int viewerId_;

        public NfcParams()
        {
            clear();
        }
    }

}
