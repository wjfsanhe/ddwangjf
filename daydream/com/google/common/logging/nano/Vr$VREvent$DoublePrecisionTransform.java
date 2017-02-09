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
        return cachedsize;
    }

    public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
        throws IOException
    {
        if(translationX != null)
            codedoutputbytebuffernano.writeDouble(1, translationX.doubleValue());
        if(translationY != null)
            codedoutputbytebuffernano.writeDouble(2, translationY.doubleValue());
        if(translationZ != null)
            codedoutputbytebuffernano.writeDouble(3, translationZ.doubleValue());
        if(rotationQx != null)
            codedoutputbytebuffernano.writeDouble(4, rotationQx.doubleValue());
        if(rotationQy != null)
            codedoutputbytebuffernano.writeDouble(5, rotationQy.doubleValue());
        if(rotationQz != null)
            codedoutputbytebuffernano.writeDouble(6, rotationQz.doubleValue());
        if(scale != null)
            codedoutputbytebuffernano.writeDouble(7, scale.doubleValue());
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(translationX != null)
            i += CodedOutputByteBufferNano.computeDoubleSize(1, translationX.doubleValue());
        if(translationY != null)
            i += CodedOutputByteBufferNano.computeDoubleSize(2, translationY.doubleValue());
        if(translationZ != null)
            i += CodedOutputByteBufferNano.computeDoubleSize(3, translationZ.doubleValue());
        if(rotationQx != null)
            i += CodedOutputByteBufferNano.computeDoubleSize(4, rotationQx.doubleValue());
        if(rotationQy != null)
            i += CodedOutputByteBufferNano.computeDoubleSize(5, rotationQy.doubleValue());
        if(rotationQz != null)
            i += CodedOutputByteBufferNano.computeDoubleSize(6, rotationQz.doubleValue());
        if(scale != null)
            i += CodedOutputByteBufferNano.computeDoubleSize(7, scale.doubleValue());
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

            case 9: // '\t'
                clone1.translationX = Double.valueOf(codedinputbytebuffernano1.readDouble());
                break;

            case 17: // '\021'
                clone1.translationY = Double.valueOf(codedinputbytebuffernano1.readDouble());
                break;

            case 25: // '\031'
                clone1.translationZ = Double.valueOf(codedinputbytebuffernano1.readDouble());
                break;

            case 33: // '!'
                clone1.rotationQx = Double.valueOf(codedinputbytebuffernano1.readDouble());
                break;

            case 41: // ')'
                clone1.rotationQy = Double.valueOf(codedinputbytebuffernano1.readDouble());
                break;

            case 49: // '1'
                clone1.rotationQz = Double.valueOf(codedinputbytebuffernano1.readDouble());
                break;

            case 57: // '9'
                clone1.scale = Double.valueOf(codedinputbytebuffernano1.readDouble());
                break;
            }
        while(true);
    }

    public final volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    private Double translationX;
    private Double translationY;
    private Double translationZ;
    private Double rotationQx;
    private Double rotationQy;
    private Double rotationQz;
    private Double scale;

    public ()
    {
         ;
        ( = this).translationX = null;
        .translationY = null;
        .translationZ = null;
        .rotationQx = null;
        .rotationQy = null;
        .rotationQz = null;
        .scale = null;
        .unknownFieldData = null;
        .cachedSize = -1;
    }
}
