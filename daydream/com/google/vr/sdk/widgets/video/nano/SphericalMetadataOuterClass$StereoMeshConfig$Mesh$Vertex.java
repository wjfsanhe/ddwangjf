// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SphericalMetadataOuterClass.java

package com.google.vr.sdk.widgets.video.nano;

import com.google.protobuf.nano.*;
import java.io.IOException;

// Referenced classes of package com.google.vr.sdk.widgets.video.nano:
//            SphericalMetadataOuterClass

public static final class clear extends MessageNano
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

    public _emptyArray clear()
    {
        x = 0.0F;
        y = 0.0F;
        z = 0.0F;
        u = 0.0F;
        v = 0.0F;
        cachedSize = -1;
        return this;
    }

    public void writeTo(CodedOutputByteBufferNano output)
        throws IOException
    {
        if(Float.floatToIntBits(x) != Float.floatToIntBits(0.0F))
            output.writeFloat(1, x);
        if(Float.floatToIntBits(y) != Float.floatToIntBits(0.0F))
            output.writeFloat(2, y);
        if(Float.floatToIntBits(z) != Float.floatToIntBits(0.0F))
            output.writeFloat(3, z);
        if(Float.floatToIntBits(u) != Float.floatToIntBits(0.0F))
            output.writeFloat(4, u);
        if(Float.floatToIntBits(v) != Float.floatToIntBits(0.0F))
            output.writeFloat(5, v);
        super.writeTo(output);
    }

    protected int computeSerializedSize()
    {
        int size = super.computeSerializedSize();
        if(Float.floatToIntBits(x) != Float.floatToIntBits(0.0F))
            size += CodedOutputByteBufferNano.computeFloatSize(1, x);
        if(Float.floatToIntBits(y) != Float.floatToIntBits(0.0F))
            size += CodedOutputByteBufferNano.computeFloatSize(2, y);
        if(Float.floatToIntBits(z) != Float.floatToIntBits(0.0F))
            size += CodedOutputByteBufferNano.computeFloatSize(3, z);
        if(Float.floatToIntBits(u) != Float.floatToIntBits(0.0F))
            size += CodedOutputByteBufferNano.computeFloatSize(4, u);
        if(Float.floatToIntBits(v) != Float.floatToIntBits(0.0F))
            size += CodedOutputByteBufferNano.computeFloatSize(5, v);
        return size;
    }

    public v mergeFrom(CodedInputByteBufferNano input)
        throws IOException
    {
        do
        {
            int tag = input.readTag();
            switch(tag)
            {
            case 0: // '\0'
                return this;

            default:
                if(!WireFormatNano.parseUnknownField(input, tag))
                    return this;
                break;

            case 13: // '\r'
                x = input.readFloat();
                break;

            case 21: // '\025'
                y = input.readFloat();
                break;

            case 29: // '\035'
                z = input.readFloat();
                break;

            case 37: // '%'
                u = input.readFloat();
                break;

            case 45: // '-'
                v = input.readFloat();
                break;
            }
        } while(true);
    }

    public static v parseFrom(byte data[])
        throws InvalidProtocolBufferNanoException
    {
        return (v)MessageNano.mergeFrom(new <init>(), data);
    }

    public static <init> parseFrom(CodedInputByteBufferNano input)
        throws IOException
    {
        return (new <init>()).mergeFrom(input);
    }

    public volatile MessageNano mergeFrom(CodedInputByteBufferNano codedinputbytebuffernano)
        throws IOException
    {
        return mergeFrom(codedinputbytebuffernano);
    }

    private static volatile mergeFrom _emptyArray[];
    public float x;
    public float y;
    public float z;
    public float u;
    public float v;

    public ()
    {
        clear();
    }
}
