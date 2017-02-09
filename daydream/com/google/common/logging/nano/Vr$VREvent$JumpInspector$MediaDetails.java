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
        if(videoDetails != null)
            cachedsize.videoDetails = videoDetails.clone();
        if(imageDetails != null)
            cachedsize.imageDetails = imageDetails.clone();
        if(audioDetails != null)
            cachedsize.audioDetails = audioDetails.clone();
        return cachedsize;
    }

    public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
        throws IOException
    {
        if(fileExtension != null)
            codedoutputbytebuffernano.writeString(1, fileExtension);
        if(videoDetails != null)
            codedoutputbytebuffernano.writeMessage(2, videoDetails);
        if(imageDetails != null)
            codedoutputbytebuffernano.writeMessage(3, imageDetails);
        if(audioDetails != null)
            codedoutputbytebuffernano.writeMessage(4, audioDetails);
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(fileExtension != null)
            i += CodedOutputByteBufferNano.computeStringSize(1, fileExtension);
        if(videoDetails != null)
            i += CodedOutputByteBufferNano.computeMessageSize(2, videoDetails);
        if(imageDetails != null)
            i += CodedOutputByteBufferNano.computeMessageSize(3, imageDetails);
        if(audioDetails != null)
            i += CodedOutputByteBufferNano.computeMessageSize(4, audioDetails);
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
                clone1.fileExtension = codedinputbytebuffernano1.readString();
                break;

            case 18: // '\022'
                if(clone1.videoDetails == null)
                    clone1.videoDetails = new <init>();
                codedinputbytebuffernano1.readMessage(clone1.videoDetails);
                break;

            case 26: // '\032'
                if(clone1.imageDetails == null)
                    clone1.imageDetails = new <init>();
                codedinputbytebuffernano1.readMessage(clone1.imageDetails);
                break;

            case 34: // '"'
                if(clone1.audioDetails == null)
                    clone1.audioDetails = new <init>();
                codedinputbytebuffernano1.readMessage(clone1.audioDetails);
                break;
            }
        while(true);
    }

    public final volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    private String fileExtension;
    private clone videoDetails;
    private clone imageDetails;
    private clone audioDetails;

    public ()
    {
         ;
        ( = this).fileExtension = null;
        .videoDetails = null;
        .imageDetails = null;
        .audioDetails = null;
        .unknownFieldData = null;
        .cachedSize = -1;
    }
}
