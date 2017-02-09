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
        if(bias != null)
            cachedsize.bias = bias.bias();
        if(lowerBound != null)
            cachedsize.lowerBound = lowerBound.lowerBound();
        if(upperBound != null)
            cachedsize.upperBound = upperBound.upperBound();
        if(standardDeviation != null)
            cachedsize.standardDeviation = standardDeviation.standardDeviation();
        return cachedsize;
    }

    public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
        throws IOException
    {
        if(bias != null)
            codedoutputbytebuffernano.writeMessage(1, bias);
        if(lowerBound != null)
            codedoutputbytebuffernano.writeMessage(2, lowerBound);
        if(upperBound != null)
            codedoutputbytebuffernano.writeMessage(3, upperBound);
        if(standardDeviation != null)
            codedoutputbytebuffernano.writeMessage(4, standardDeviation);
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(bias != null)
            i += CodedOutputByteBufferNano.computeMessageSize(1, bias);
        if(lowerBound != null)
            i += CodedOutputByteBufferNano.computeMessageSize(2, lowerBound);
        if(upperBound != null)
            i += CodedOutputByteBufferNano.computeMessageSize(3, upperBound);
        if(standardDeviation != null)
            i += CodedOutputByteBufferNano.computeMessageSize(4, standardDeviation);
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
                if(clone1.bias == null)
                    clone1.bias = new bias();
                codedinputbytebuffernano1.readMessage(clone1.bias);
                break;

            case 18: // '\022'
                if(clone1.lowerBound == null)
                    clone1.lowerBound = new lowerBound();
                codedinputbytebuffernano1.readMessage(clone1.lowerBound);
                break;

            case 26: // '\032'
                if(clone1.upperBound == null)
                    clone1.upperBound = new upperBound();
                codedinputbytebuffernano1.readMessage(clone1.upperBound);
                break;

            case 34: // '"'
                if(clone1.standardDeviation == null)
                    clone1.standardDeviation = new standardDeviation();
                codedinputbytebuffernano1.readMessage(clone1.standardDeviation);
                break;
            }
        while(true);
    }

    public final volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    private clone bias;
    private clone lowerBound;
    private clone upperBound;
    private clone standardDeviation;

    public ()
    {
         ;
        ( = this).bias = null;
        .lowerBound = null;
        .upperBound = null;
        .standardDeviation = null;
        .unknownFieldData = null;
        .cachedSize = -1;
    }
}
