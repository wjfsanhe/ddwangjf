// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Preferences.java

package com.google.vrtoolkit.cardboard.proto.nano;

import com.google.protobuf.nano.*;
import java.io.IOException;

// Referenced classes of package com.google.vrtoolkit.cardboard.proto.nano:
//            Preferences

public static final class clear extends ExtendableMessageNano
    implements Cloneable
{
    public static interface Handedness
    {

        public static final int RIGHT_HANDED = 0;
        public static final int LEFT_HANDED = 1;
    }


    public static Handedness[] emptyArray()
    {
        if(_emptyArray == null)
            synchronized(InternalNano.LAZY_INIT_LOCK)
            {
                if(_emptyArray == null)
                    _emptyArray = new _emptyArray[0];
            }
        return _emptyArray;
    }

    public final int getControllerHandedness()
    {
        return controllerHandedness_;
    }

    public final controllerHandedness_ setControllerHandedness(int i)
    {
        controllerHandedness_ = i;
        bitField0_ |= 1;
        return this;
    }

    public final boolean hasControllerHandedness()
    {
        return (bitField0_ & 1) != 0;
    }

    public final bitField0_ clearControllerHandedness()
    {
        controllerHandedness_ = 0;
        bitField0_ = bitField0_ & -2;
        return this;
    }

    public final bitField0_ clear()
    {
        bitField0_ = 0;
        controllerHandedness_ = 0;
        developerPrefs = null;
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
        if(developerPrefs != null)
            cachedsize.developerPrefs = developerPrefs.clone();
        return cachedsize;
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

    public final developerPrefs mergeFrom(CodedInputByteBufferNano codedinputbytebuffernano)
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
                    developerPrefs = new refs();
                codedinputbytebuffernano.readMessage(developerPrefs);
                break;
            }
        while(true);
    }

    public static developerPrefs parseFrom(byte abyte0[])
        throws InvalidProtocolBufferNanoException
    {
        return (developerPrefs)MessageNano.mergeFrom(new <init>(), abyte0);
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
    private int controllerHandedness_;
    public refs developerPrefs;

    public Handedness()
    {
        clear();
    }
}
