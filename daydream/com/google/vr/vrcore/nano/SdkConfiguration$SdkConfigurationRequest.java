// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SdkConfiguration.java

package com.google.vr.vrcore.nano;

import com.google.protobuf.nano.*;
import java.io.IOException;

// Referenced classes of package com.google.vr.vrcore.nano:
//            SdkConfiguration

public static final class clear extends ExtendableMessageNano
{

    public static clear[] emptyArray()
    {
        if(_emptyArray == null)
            synchronized(InternalNano.LAZY_INIT_LOCK)
            {
                if(_emptyArray == null)
                    _emptyArray = new _emptyArray[0];
            }
        return _emptyArray;
    }

    public final _emptyArray clear()
    {
        sdkVersion = null;
        requestedParams = null;
        unknownFieldData = null;
        cachedSize = -1;
        return this;
    }

    public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
        throws IOException
    {
        if(sdkVersion != null)
            codedoutputbytebuffernano.writeString(1, sdkVersion);
        if(requestedParams != null)
            codedoutputbytebuffernano.writeMessage(2, requestedParams);
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(sdkVersion != null)
            i += CodedOutputByteBufferNano.computeStringSize(1, sdkVersion);
        if(requestedParams != null)
            i += CodedOutputByteBufferNano.computeMessageSize(2, requestedParams);
        return i;
    }

    public final requestedParams mergeFrom(CodedInputByteBufferNano codedinputbytebuffernano)
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
                sdkVersion = codedinputbytebuffernano.readString();
                break;

            case 18: // '\022'
                if(requestedParams == null)
                    requestedParams = new com.google.common.logging.nano.stedParams();
                codedinputbytebuffernano.readMessage(requestedParams);
                break;
            }
        while(true);
    }

    public static requestedParams parseFrom(byte abyte0[])
        throws InvalidProtocolBufferNanoException
    {
        return (requestedParams)MessageNano.mergeFrom(new <init>(), abyte0);
    }

    public static <init> parseFrom(CodedInputByteBufferNano codedinputbytebuffernano)
        throws IOException
    {
        return (new <init>()).mergeFrom(codedinputbytebuffernano);
    }

    public final volatile MessageNano mergeFrom(CodedInputByteBufferNano codedinputbytebuffernano)
        throws IOException
    {
        return mergeFrom(codedinputbytebuffernano);
    }

    private static volatile mergeFrom _emptyArray[];
    public String sdkVersion;
    public com.google.common.logging.nano.From requestedParams;

    public ()
    {
        clear();
    }
}
