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
        Video.cachedSize cachedsize;
        try
        {
            cachedsize = (Video.cachedSize)super.clone();
        }
        catch(CloneNotSupportedException clonenotsupportedexception)
        {
            throw new AssertionError(clonenotsupportedexception);
        }
        class Pano extends ExtendableMessageNano
            implements Cloneable
        {

            public final Pano clone()
            {
                Pano pano1;
                try
                {
                    pano1 = (Pano)super.clone();
                }
                catch(CloneNotSupportedException clonenotsupportedexception1)
                {
                    throw new AssertionError(clonenotsupportedexception1);
                }
                return pano1;
            }

            public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
                throws IOException
            {
                if(widthPixels != null)
                    codedoutputbytebuffernano.writeInt32(1, widthPixels.intValue());
                if(heightPixels != null)
                    codedoutputbytebuffernano.writeInt32(2, heightPixels.intValue());
                if(stereoFormat != null)
                    codedoutputbytebuffernano.writeInt32(3, stereoFormat.intValue());
                super.writeTo(codedoutputbytebuffernano);
            }

            protected final int computeSerializedSize()
            {
                int i = super.computeSerializedSize();
                if(widthPixels != null)
                    i += CodedOutputByteBufferNano.computeInt32Size(1, widthPixels.intValue());
                if(heightPixels != null)
                    i += CodedOutputByteBufferNano.computeInt32Size(2, heightPixels.intValue());
                if(stereoFormat != null)
                    i += CodedOutputByteBufferNano.computeInt32Size(3, stereoFormat.intValue());
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
                Pano pano1;
                CodedInputByteBufferNano codedinputbytebuffernano1;
                codedinputbytebuffernano1 = codedinputbytebuffernano;
                pano1 = this;
_L9:
                int i = codedinputbytebuffernano1.readTag();
                JVM INSTR lookupswitch 4: default 54
            //                           0: 52
            //                           8: 66
            //                           16: 80
            //                           24: 94;
                   goto _L1 _L2 _L3 _L4 _L5
_L2:
                return pano1;
_L1:
                if(!pano1.super.storeUnknownField(codedinputbytebuffernano1, i))
                    return pano1;
                continue; /* Loop/switch isn't completed */
_L3:
                pano1.widthPixels = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                continue; /* Loop/switch isn't completed */
_L4:
                pano1.heightPixels = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                continue; /* Loop/switch isn't completed */
_L5:
                int j = codedinputbytebuffernano1.readInt32();
                JVM INSTR tableswitch 0 2: default 137
            //                           0 128
            //                           1 128
            //                           2 128;
                   goto _L6 _L7 _L7 _L7
_L6:
                continue; /* Loop/switch isn't completed */
_L7:
                pano1.stereoFormat = Integer.valueOf(j);
                if(true) goto _L9; else goto _L8
_L8:
            }

            public final volatile Object clone()
                throws CloneNotSupportedException
            {
                return clone();
            }

            private Integer widthPixels;
            private Integer heightPixels;
            private Integer stereoFormat;

            public Pano()
            {
                Pano pano1;
                (pano1 = this).widthPixels = null;
                pano1.heightPixels = null;
                pano1.unknownFieldData = null;
                pano1.cachedSize = -1;
            }
        }

        if(pano != null)
            cachedsize.pano = pano.clone();
        class Video extends ExtendableMessageNano
            implements Cloneable
        {

            public final Video clone()
            {
                Video video1;
                try
                {
                    video1 = (Video)super.clone();
                }
                catch(CloneNotSupportedException clonenotsupportedexception1)
                {
                    throw new AssertionError(clonenotsupportedexception1);
                }
                return video1;
            }

            public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
                throws IOException
            {
                if(widthPixels != null)
                    codedoutputbytebuffernano.writeInt32(1, widthPixels.intValue());
                if(heightPixels != null)
                    codedoutputbytebuffernano.writeInt32(2, heightPixels.intValue());
                if(stereoFormat != null)
                    codedoutputbytebuffernano.writeInt32(3, stereoFormat.intValue());
                if(videoDurationMs != null)
                    codedoutputbytebuffernano.writeInt32(4, videoDurationMs.intValue());
                super.writeTo(codedoutputbytebuffernano);
            }

            protected final int computeSerializedSize()
            {
                int i = super.computeSerializedSize();
                if(widthPixels != null)
                    i += CodedOutputByteBufferNano.computeInt32Size(1, widthPixels.intValue());
                if(heightPixels != null)
                    i += CodedOutputByteBufferNano.computeInt32Size(2, heightPixels.intValue());
                if(stereoFormat != null)
                    i += CodedOutputByteBufferNano.computeInt32Size(3, stereoFormat.intValue());
                if(videoDurationMs != null)
                    i += CodedOutputByteBufferNano.computeInt32Size(4, videoDurationMs.intValue());
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
                Video video1 = this;
                int i;
                int j;
                do
                    switch(i = codedinputbytebuffernano1.readTag())
                    {
                    case 0: // '\0'
                        return video1;

                    default:
                        if(!video1.super.storeUnknownField(codedinputbytebuffernano1, i))
                            return video1;
                        continue;

                    case 8: // '\b'
                        video1.widthPixels = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                        continue;

                    case 16: // '\020'
                        video1.heightPixels = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                        continue;

                    case 24: // '\030'
                        switch(j = codedinputbytebuffernano1.readInt32())
                        {
                        case 0: // '\0'
                        case 1: // '\001'
                        case 2: // '\002'
                            video1.stereoFormat = Integer.valueOf(j);
                            break;
                        }
                        break;

                    case 32: // ' '
                        video1.videoDurationMs = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                        break;
                    }
                while(true);
            }

            public final volatile Object clone()
                throws CloneNotSupportedException
            {
                return clone();
            }

            private Integer widthPixels;
            private Integer heightPixels;
            private Integer stereoFormat;
            private Integer videoDurationMs;

            public Video()
            {
                Video video1;
                (video1 = this).widthPixels = null;
                video1.heightPixels = null;
                video1.videoDurationMs = null;
                video1.unknownFieldData = null;
                video1.cachedSize = -1;
            }
        }

        if(video != null)
            cachedsize.video = video.clone();
        return cachedsize;
    }

    public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
        throws IOException
    {
        if(viewMode != null)
            codedoutputbytebuffernano.writeInt32(1, viewMode.intValue());
        if(pano != null)
            codedoutputbytebuffernano.writeMessage(2, pano);
        if(video != null)
            codedoutputbytebuffernano.writeMessage(3, video);
        if(errorMsg != null)
            codedoutputbytebuffernano.writeString(4, errorMsg);
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(viewMode != null)
            i += CodedOutputByteBufferNano.computeInt32Size(1, viewMode.intValue());
        if(pano != null)
            i += CodedOutputByteBufferNano.computeMessageSize(2, pano);
        if(video != null)
            i += CodedOutputByteBufferNano.computeMessageSize(3, video);
        if(errorMsg != null)
            i += CodedOutputByteBufferNano.computeStringSize(4, errorMsg);
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
        int j;
        do
            switch(i = codedinputbytebuffernano1.readTag())
            {
            case 0: // '\0'
                return clone1;

            default:
                if(!clone1.super.storeUnknownField(codedinputbytebuffernano1, i))
                    return clone1;
                break;

            case 8: // '\b'
                switch(j = codedinputbytebuffernano1.readInt32())
                {
                case 0: // '\0'
                case 1: // '\001'
                case 2: // '\002'
                case 3: // '\003'
                    clone1.viewMode = Integer.valueOf(j);
                    break;
                }
                break;

            case 18: // '\022'
                if(clone1.pano == null)
                    clone1.pano = new Pano();
                codedinputbytebuffernano1.readMessage(clone1.pano);
                break;

            case 26: // '\032'
                if(clone1.video == null)
                    clone1.video = new Video();
                codedinputbytebuffernano1.readMessage(clone1.video);
                break;

            case 34: // '"'
                clone1.errorMsg = codedinputbytebuffernano1.readString();
                break;
            }
        while(true);
    }

    public final volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    private Integer viewMode;
    private Pano pano;
    private Video video;
    private String errorMsg;

    public Video()
    {
        Video video1;
        (video1 = this).pano = null;
        video1.video = null;
        video1.errorMsg = null;
        video1.unknownFieldData = null;
        video1.cachedSize = -1;
    }
}
