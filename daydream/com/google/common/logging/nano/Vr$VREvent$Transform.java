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
            codedoutputbytebuffernano.writeFloat(1, translationX.floatValue());
        if(translationY != null)
            codedoutputbytebuffernano.writeFloat(2, translationY.floatValue());
        if(translationZ != null)
            codedoutputbytebuffernano.writeFloat(3, translationZ.floatValue());
        if(rotationQx != null)
            codedoutputbytebuffernano.writeFloat(4, rotationQx.floatValue());
        if(rotationQy != null)
            codedoutputbytebuffernano.writeFloat(5, rotationQy.floatValue());
        if(rotationQz != null)
            codedoutputbytebuffernano.writeFloat(6, rotationQz.floatValue());
        if(scale != null)
            codedoutputbytebuffernano.writeFloat(7, scale.floatValue());
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(translationX != null)
            i += CodedOutputByteBufferNano.computeFloatSize(1, translationX.floatValue());
        if(translationY != null)
            i += CodedOutputByteBufferNano.computeFloatSize(2, translationY.floatValue());
        if(translationZ != null)
            i += CodedOutputByteBufferNano.computeFloatSize(3, translationZ.floatValue());
        if(rotationQx != null)
            i += CodedOutputByteBufferNano.computeFloatSize(4, rotationQx.floatValue());
        if(rotationQy != null)
            i += CodedOutputByteBufferNano.computeFloatSize(5, rotationQy.floatValue());
        if(rotationQz != null)
            i += CodedOutputByteBufferNano.computeFloatSize(6, rotationQz.floatValue());
        if(scale != null)
            i += CodedOutputByteBufferNano.computeFloatSize(7, scale.floatValue());
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

            case 13: // '\r'
                clone1.translationX = Float.valueOf(codedinputbytebuffernano1.readFloat());
                break;

            case 21: // '\025'
                clone1.translationY = Float.valueOf(codedinputbytebuffernano1.readFloat());
                break;

            case 29: // '\035'
                clone1.translationZ = Float.valueOf(codedinputbytebuffernano1.readFloat());
                break;

            case 37: // '%'
                clone1.rotationQx = Float.valueOf(codedinputbytebuffernano1.readFloat());
                break;

            case 45: // '-'
                clone1.rotationQy = Float.valueOf(codedinputbytebuffernano1.readFloat());
                break;

            case 53: // '5'
                clone1.rotationQz = Float.valueOf(codedinputbytebuffernano1.readFloat());
                break;

            case 61: // '='
                clone1.scale = Float.valueOf(codedinputbytebuffernano1.readFloat());
                break;
            }
        while(true);
    }

    public final volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    private Float translationX;
    private Float translationY;
    private Float translationZ;
    private Float rotationQx;
    private Float rotationQy;
    private Float rotationQz;
    private Float scale;

    public _cls9()
    {
        _cls9 _lcls9;
        (_lcls9 = this).translationX = null;
        _lcls9.translationY = null;
        _lcls9.translationZ = null;
        _lcls9.rotationQx = null;
        _lcls9.rotationQy = null;
        _lcls9.rotationQz = null;
        _lcls9.scale = null;
        _lcls9.unknownFieldData = null;
        _lcls9.cachedSize = -1;
    }
}
