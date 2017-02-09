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
        PickerDetails.cachedSize cachedsize;
        try
        {
            cachedsize = (PickerDetails.cachedSize)super.clone();
        }
        catch(CloneNotSupportedException clonenotsupportedexception)
        {
            throw new AssertionError(clonenotsupportedexception);
        }
        class MediaDetails extends ExtendableMessageNano
            implements Cloneable
        {

            public final MediaDetails clone()
            {
                MediaDetails mediadetails;
                try
                {
                    mediadetails = (MediaDetails)super.clone();
                }
                catch(CloneNotSupportedException clonenotsupportedexception1)
                {
                    throw new AssertionError(clonenotsupportedexception1);
                }
                class VideoDetails extends ExtendableMessageNano
                    implements Cloneable
                {

                    public final VideoDetails clone()
                    {
                        VideoDetails videodetails;
                        try
                        {
                            videodetails = (VideoDetails)super.clone();
                        }
                        catch(CloneNotSupportedException clonenotsupportedexception2)
                        {
                            throw new AssertionError(clonenotsupportedexception2);
                        }
                        class Resolution extends ExtendableMessageNano
                            implements Cloneable
                        {

                            public final Resolution clone()
                            {
                                Resolution resolution1;
                                try
                                {
                                    resolution1 = (Resolution)super.clone();
                                }
                                catch(CloneNotSupportedException clonenotsupportedexception3)
                                {
                                    throw new AssertionError(clonenotsupportedexception3);
                                }
                                return resolution1;
                            }

                            public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
                                throws IOException
                            {
                                if(width != null)
                                    codedoutputbytebuffernano.writeInt32(1, width.intValue());
                                if(height != null)
                                    codedoutputbytebuffernano.writeInt32(2, height.intValue());
                                super.writeTo(codedoutputbytebuffernano);
                            }

                            protected final int computeSerializedSize()
                            {
                                int i = super.computeSerializedSize();
                                if(width != null)
                                    i += CodedOutputByteBufferNano.computeInt32Size(1, width.intValue());
                                if(height != null)
                                    i += CodedOutputByteBufferNano.computeInt32Size(2, height.intValue());
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
                                Resolution resolution1 = this;
                                int i;
                                do
                                    switch(i = codedinputbytebuffernano1.readTag())
                                    {
                                    case 0: // '\0'
                                        return resolution1;

                                    default:
                                        if(!resolution1.super.storeUnknownField(codedinputbytebuffernano1, i))
                                            return resolution1;
                                        break;

                                    case 8: // '\b'
                                        resolution1.width = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                                        break;

                                    case 16: // '\020'
                                        resolution1.height = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                                        break;
                                    }
                                while(true);
                            }

                            public final volatile Object clone()
                                throws CloneNotSupportedException
                            {
                                return clone();
                            }

                            private Integer width;
                            private Integer height;

                                public Resolution()
                                {
                                    Resolution resolution1;
                                    (resolution1 = this).width = null;
                                    resolution1.height = null;
                                    resolution1.unknownFieldData = null;
                                    resolution1.cachedSize = -1;
                                }
                        }

                        if(resolution != null)
                            videodetails.resolution = resolution.clone();
                        class SphericalMetadata extends ExtendableMessageNano
                            implements Cloneable
                        {

                            public final SphericalMetadata clone()
                            {
                                SphericalMetadata sphericalmetadata;
                                try
                                {
                                    sphericalmetadata = (SphericalMetadata)super.clone();
                                }
                                catch(CloneNotSupportedException clonenotsupportedexception3)
                                {
                                    throw new AssertionError(clonenotsupportedexception3);
                                }
                                return sphericalmetadata;
                            }

                            public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
                                throws IOException
                            {
                                if(metadataVersion != null)
                                    codedoutputbytebuffernano.writeInt32(1, metadataVersion.intValue());
                                if(projectionType != null)
                                    codedoutputbytebuffernano.writeInt32(2, projectionType.intValue());
                                if(meshCrc != null)
                                    codedoutputbytebuffernano.writeInt32(3, meshCrc.intValue());
                                super.writeTo(codedoutputbytebuffernano);
                            }

                            protected final int computeSerializedSize()
                            {
                                int i = super.computeSerializedSize();
                                if(metadataVersion != null)
                                    i += CodedOutputByteBufferNano.computeInt32Size(1, metadataVersion.intValue());
                                if(projectionType != null)
                                    i += CodedOutputByteBufferNano.computeInt32Size(2, projectionType.intValue());
                                if(meshCrc != null)
                                    i += CodedOutputByteBufferNano.computeInt32Size(3, meshCrc.intValue());
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
                                SphericalMetadata sphericalmetadata = this;
                                int i;
                                int j;
                                do
                                    switch(i = codedinputbytebuffernano1.readTag())
                                    {
                                    case 0: // '\0'
                                        return sphericalmetadata;

                                    default:
                                        if(!sphericalmetadata.super.storeUnknownField(codedinputbytebuffernano1, i))
                                            return sphericalmetadata;
                                        continue;

                                    case 8: // '\b'
                                        sphericalmetadata.metadataVersion = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                                        continue;

                                    case 16: // '\020'
                                        switch(j = codedinputbytebuffernano1.readInt32())
                                        {
                                        case 0: // '\0'
                                        case 1: // '\001'
                                        case 2: // '\002'
                                        case 3: // '\003'
                                        case 4: // '\004'
                                            sphericalmetadata.projectionType = Integer.valueOf(j);
                                            break;
                                        }
                                        break;

                                    case 24: // '\030'
                                        sphericalmetadata.meshCrc = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                                        break;
                                    }
                                while(true);
                            }

                            public final volatile Object clone()
                                throws CloneNotSupportedException
                            {
                                return clone();
                            }

                            private Integer metadataVersion;
                            private Integer projectionType;
                            private Integer meshCrc;

                                public SphericalMetadata()
                                {
                                    SphericalMetadata sphericalmetadata;
                                    (sphericalmetadata = this).metadataVersion = null;
                                    sphericalmetadata.meshCrc = null;
                                    sphericalmetadata.unknownFieldData = null;
                                    sphericalmetadata.cachedSize = -1;
                                }
                        }

                        if(sphericalMetadata != null)
                            videodetails.sphericalMetadata = sphericalMetadata.clone();
                        return videodetails;
                    }

                    public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
                        throws IOException
                    {
                        if(mediaLengthSeconds != null)
                            codedoutputbytebuffernano.writeInt64(1, mediaLengthSeconds.longValue());
                        if(resolution != null)
                            codedoutputbytebuffernano.writeMessage(2, resolution);
                        if(framesPerSecond != null)
                            codedoutputbytebuffernano.writeDouble(3, framesPerSecond.doubleValue());
                        if(sampleRate != null)
                            codedoutputbytebuffernano.writeInt32(4, sampleRate.intValue());
                        if(videoBitRate != null)
                            codedoutputbytebuffernano.writeInt32(5, videoBitRate.intValue());
                        if(audioBitRate != null)
                            codedoutputbytebuffernano.writeInt32(6, audioBitRate.intValue());
                        if(videoCodec != null)
                            codedoutputbytebuffernano.writeInt32(7, videoCodec.intValue());
                        if(audioCodec != null)
                            codedoutputbytebuffernano.writeInt32(8, audioCodec.intValue());
                        if(sphericalMetadata != null)
                            codedoutputbytebuffernano.writeMessage(9, sphericalMetadata);
                        if(audioChannelCount != null)
                            codedoutputbytebuffernano.writeInt32(10, audioChannelCount.intValue());
                        if(usedMonoFilename != null)
                            codedoutputbytebuffernano.writeBool(11, usedMonoFilename.booleanValue());
                        if(usedWalleFilename != null)
                            codedoutputbytebuffernano.writeBool(12, usedWalleFilename.booleanValue());
                        if(usedWallyFilename != null)
                            codedoutputbytebuffernano.writeBool(13, usedWallyFilename.booleanValue());
                        super.writeTo(codedoutputbytebuffernano);
                    }

                    protected final int computeSerializedSize()
                    {
                        int i = super.computeSerializedSize();
                        if(mediaLengthSeconds != null)
                            i += CodedOutputByteBufferNano.computeInt64Size(1, mediaLengthSeconds.longValue());
                        if(resolution != null)
                            i += CodedOutputByteBufferNano.computeMessageSize(2, resolution);
                        if(framesPerSecond != null)
                            i += CodedOutputByteBufferNano.computeDoubleSize(3, framesPerSecond.doubleValue());
                        if(sampleRate != null)
                            i += CodedOutputByteBufferNano.computeInt32Size(4, sampleRate.intValue());
                        if(videoBitRate != null)
                            i += CodedOutputByteBufferNano.computeInt32Size(5, videoBitRate.intValue());
                        if(audioBitRate != null)
                            i += CodedOutputByteBufferNano.computeInt32Size(6, audioBitRate.intValue());
                        if(videoCodec != null)
                            i += CodedOutputByteBufferNano.computeInt32Size(7, videoCodec.intValue());
                        if(audioCodec != null)
                            i += CodedOutputByteBufferNano.computeInt32Size(8, audioCodec.intValue());
                        if(sphericalMetadata != null)
                            i += CodedOutputByteBufferNano.computeMessageSize(9, sphericalMetadata);
                        if(audioChannelCount != null)
                            i += CodedOutputByteBufferNano.computeInt32Size(10, audioChannelCount.intValue());
                        if(usedMonoFilename != null)
                            i += CodedOutputByteBufferNano.computeBoolSize(11, usedMonoFilename.booleanValue());
                        if(usedWalleFilename != null)
                            i += CodedOutputByteBufferNano.computeBoolSize(12, usedWalleFilename.booleanValue());
                        if(usedWallyFilename != null)
                            i += CodedOutputByteBufferNano.computeBoolSize(13, usedWallyFilename.booleanValue());
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
                        VideoDetails videodetails = this;
                        int i;
                        int j;
                        do
                            switch(i = codedinputbytebuffernano1.readTag())
                            {
                            case 0: // '\0'
                                return videodetails;

                            default:
                                if(!videodetails.super.storeUnknownField(codedinputbytebuffernano1, i))
                                    return videodetails;
                                break;

                            case 8: // '\b'
                                videodetails.mediaLengthSeconds = Long.valueOf(codedinputbytebuffernano1.readInt64());
                                break;

                            case 18: // '\022'
                                if(videodetails.resolution == null)
                                    videodetails.resolution = new Resolution();
                                codedinputbytebuffernano1.readMessage(videodetails.resolution);
                                break;

                            case 25: // '\031'
                                videodetails.framesPerSecond = Double.valueOf(codedinputbytebuffernano1.readDouble());
                                break;

                            case 32: // ' '
                                videodetails.sampleRate = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                                break;

                            case 40: // '('
                                videodetails.videoBitRate = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                                break;

                            case 48: // '0'
                                videodetails.audioBitRate = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                                break;

                            case 56: // '8'
                                switch(j = codedinputbytebuffernano1.readInt32())
                                {
                                case 0: // '\0'
                                case 1: // '\001'
                                case 2: // '\002'
                                case 3: // '\003'
                                case 4: // '\004'
                                    videodetails.videoCodec = Integer.valueOf(j);
                                    break;
                                }
                                break;

                            case 64: // '@'
                                switch(j = codedinputbytebuffernano1.readInt32())
                                {
                                case 0: // '\0'
                                case 1: // '\001'
                                case 2: // '\002'
                                case 3: // '\003'
                                case 4: // '\004'
                                    videodetails.audioCodec = Integer.valueOf(j);
                                    break;
                                }
                                break;

                            case 74: // 'J'
                                if(videodetails.sphericalMetadata == null)
                                    videodetails.sphericalMetadata = new SphericalMetadata();
                                codedinputbytebuffernano1.readMessage(videodetails.sphericalMetadata);
                                break;

                            case 80: // 'P'
                                videodetails.audioChannelCount = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                                break;

                            case 88: // 'X'
                                videodetails.usedMonoFilename = Boolean.valueOf(codedinputbytebuffernano1.readBool());
                                break;

                            case 96: // '`'
                                videodetails.usedWalleFilename = Boolean.valueOf(codedinputbytebuffernano1.readBool());
                                break;

                            case 104: // 'h'
                                videodetails.usedWallyFilename = Boolean.valueOf(codedinputbytebuffernano1.readBool());
                                break;
                            }
                        while(true);
                    }

                    public final volatile Object clone()
                        throws CloneNotSupportedException
                    {
                        return clone();
                    }

                    private Long mediaLengthSeconds;
                    private Resolution resolution;
                    private Double framesPerSecond;
                    private Integer sampleRate;
                    private Integer videoBitRate;
                    private Integer audioBitRate;
                    private Integer videoCodec;
                    private Integer audioCodec;
                    private SphericalMetadata sphericalMetadata;
                    private Integer audioChannelCount;
                    private Boolean usedMonoFilename;
                    private Boolean usedWalleFilename;
                    private Boolean usedWallyFilename;

                        public VideoDetails()
                        {
                            VideoDetails videodetails;
                            (videodetails = this).mediaLengthSeconds = null;
                            videodetails.resolution = null;
                            videodetails.framesPerSecond = null;
                            videodetails.sampleRate = null;
                            videodetails.videoBitRate = null;
                            videodetails.audioBitRate = null;
                            videodetails.sphericalMetadata = null;
                            videodetails.audioChannelCount = null;
                            videodetails.usedMonoFilename = null;
                            videodetails.usedWalleFilename = null;
                            videodetails.usedWallyFilename = null;
                            videodetails.unknownFieldData = null;
                            videodetails.cachedSize = -1;
                        }
                }

                if(videoDetails != null)
                    mediadetails.videoDetails = videoDetails.clone();
                class ImageDetails extends ExtendableMessageNano
                    implements Cloneable
                {

                    public final ImageDetails clone()
                    {
                        ImageDetails imagedetails;
                        try
                        {
                            imagedetails = (ImageDetails)super.clone();
                        }
                        catch(CloneNotSupportedException clonenotsupportedexception2)
                        {
                            throw new AssertionError(clonenotsupportedexception2);
                        }
                        if(resolution != null)
                            imagedetails.resolution = resolution.clone();
                        return imagedetails;
                    }

                    public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
                        throws IOException
                    {
                        if(resolution != null)
                            codedoutputbytebuffernano.writeMessage(1, resolution);
                        if(usedMonoFilename != null)
                            codedoutputbytebuffernano.writeBool(2, usedMonoFilename.booleanValue());
                        super.writeTo(codedoutputbytebuffernano);
                    }

                    protected final int computeSerializedSize()
                    {
                        int i = super.computeSerializedSize();
                        if(resolution != null)
                            i += CodedOutputByteBufferNano.computeMessageSize(1, resolution);
                        if(usedMonoFilename != null)
                            i += CodedOutputByteBufferNano.computeBoolSize(2, usedMonoFilename.booleanValue());
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
                        ImageDetails imagedetails = this;
                        int i;
                        do
                            switch(i = codedinputbytebuffernano1.readTag())
                            {
                            case 0: // '\0'
                                return imagedetails;

                            default:
                                if(!imagedetails.super.storeUnknownField(codedinputbytebuffernano1, i))
                                    return imagedetails;
                                break;

                            case 10: // '\n'
                                if(imagedetails.resolution == null)
                                    imagedetails.resolution = new Resolution();
                                codedinputbytebuffernano1.readMessage(imagedetails.resolution);
                                break;

                            case 16: // '\020'
                                imagedetails.usedMonoFilename = Boolean.valueOf(codedinputbytebuffernano1.readBool());
                                break;
                            }
                        while(true);
                    }

                    public final volatile Object clone()
                        throws CloneNotSupportedException
                    {
                        return clone();
                    }

                    private Resolution resolution;
                    private Boolean usedMonoFilename;

                        public ImageDetails()
                        {
                            ImageDetails imagedetails;
                            (imagedetails = this).resolution = null;
                            imagedetails.usedMonoFilename = null;
                            imagedetails.unknownFieldData = null;
                            imagedetails.cachedSize = -1;
                        }
                }

                if(imageDetails != null)
                    mediadetails.imageDetails = imageDetails.clone();
                class AudioDetails extends ExtendableMessageNano
                    implements Cloneable
                {

                    public final AudioDetails clone()
                    {
                        AudioDetails audiodetails;
                        try
                        {
                            audiodetails = (AudioDetails)super.clone();
                        }
                        catch(CloneNotSupportedException clonenotsupportedexception2)
                        {
                            throw new AssertionError(clonenotsupportedexception2);
                        }
                        return audiodetails;
                    }

                    public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
                        throws IOException
                    {
                        if(mediaLengthSeconds != null)
                            codedoutputbytebuffernano.writeInt64(1, mediaLengthSeconds.longValue());
                        if(sampleRate != null)
                            codedoutputbytebuffernano.writeInt32(2, sampleRate.intValue());
                        if(audioBitRate != null)
                            codedoutputbytebuffernano.writeInt32(3, audioBitRate.intValue());
                        if(audioCodec != null)
                            codedoutputbytebuffernano.writeInt32(4, audioCodec.intValue());
                        if(audioChannelCount != null)
                            codedoutputbytebuffernano.writeInt32(5, audioChannelCount.intValue());
                        super.writeTo(codedoutputbytebuffernano);
                    }

                    protected final int computeSerializedSize()
                    {
                        int i = super.computeSerializedSize();
                        if(mediaLengthSeconds != null)
                            i += CodedOutputByteBufferNano.computeInt64Size(1, mediaLengthSeconds.longValue());
                        if(sampleRate != null)
                            i += CodedOutputByteBufferNano.computeInt32Size(2, sampleRate.intValue());
                        if(audioBitRate != null)
                            i += CodedOutputByteBufferNano.computeInt32Size(3, audioBitRate.intValue());
                        if(audioCodec != null)
                            i += CodedOutputByteBufferNano.computeInt32Size(4, audioCodec.intValue());
                        if(audioChannelCount != null)
                            i += CodedOutputByteBufferNano.computeInt32Size(5, audioChannelCount.intValue());
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
                        AudioDetails audiodetails = this;
                        int i;
                        int j;
                        do
                            switch(i = codedinputbytebuffernano1.readTag())
                            {
                            case 0: // '\0'
                                return audiodetails;

                            default:
                                if(!audiodetails.super.storeUnknownField(codedinputbytebuffernano1, i))
                                    return audiodetails;
                                continue;

                            case 8: // '\b'
                                audiodetails.mediaLengthSeconds = Long.valueOf(codedinputbytebuffernano1.readInt64());
                                continue;

                            case 16: // '\020'
                                audiodetails.sampleRate = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                                continue;

                            case 24: // '\030'
                                audiodetails.audioBitRate = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                                continue;

                            case 32: // ' '
                                switch(j = codedinputbytebuffernano1.readInt32())
                                {
                                case 0: // '\0'
                                case 1: // '\001'
                                case 2: // '\002'
                                case 3: // '\003'
                                case 4: // '\004'
                                    audiodetails.audioCodec = Integer.valueOf(j);
                                    break;
                                }
                                break;

                            case 40: // '('
                                audiodetails.audioChannelCount = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                                break;
                            }
                        while(true);
                    }

                    public final volatile Object clone()
                        throws CloneNotSupportedException
                    {
                        return clone();
                    }

                    private Long mediaLengthSeconds;
                    private Integer sampleRate;
                    private Integer audioBitRate;
                    private Integer audioCodec;
                    private Integer audioChannelCount;

                        public AudioDetails()
                        {
                            AudioDetails audiodetails;
                            (audiodetails = this).mediaLengthSeconds = null;
                            audiodetails.sampleRate = null;
                            audiodetails.audioBitRate = null;
                            audiodetails.audioChannelCount = null;
                            audiodetails.unknownFieldData = null;
                            audiodetails.cachedSize = -1;
                        }
                }

                if(audioDetails != null)
                    mediadetails.audioDetails = audioDetails.clone();
                return mediadetails;
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
                MediaDetails mediadetails = this;
                int i;
                do
                    switch(i = codedinputbytebuffernano1.readTag())
                    {
                    case 0: // '\0'
                        return mediadetails;

                    default:
                        if(!mediadetails.super.storeUnknownField(codedinputbytebuffernano1, i))
                            return mediadetails;
                        break;

                    case 10: // '\n'
                        mediadetails.fileExtension = codedinputbytebuffernano1.readString();
                        break;

                    case 18: // '\022'
                        if(mediadetails.videoDetails == null)
                            mediadetails.videoDetails = new VideoDetails();
                        codedinputbytebuffernano1.readMessage(mediadetails.videoDetails);
                        break;

                    case 26: // '\032'
                        if(mediadetails.imageDetails == null)
                            mediadetails.imageDetails = new ImageDetails();
                        codedinputbytebuffernano1.readMessage(mediadetails.imageDetails);
                        break;

                    case 34: // '"'
                        if(mediadetails.audioDetails == null)
                            mediadetails.audioDetails = new AudioDetails();
                        codedinputbytebuffernano1.readMessage(mediadetails.audioDetails);
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
            private VideoDetails videoDetails;
            private ImageDetails imageDetails;
            private AudioDetails audioDetails;

            public MediaDetails()
            {
                MediaDetails mediadetails;
                (mediadetails = this).fileExtension = null;
                mediadetails.videoDetails = null;
                mediadetails.imageDetails = null;
                mediadetails.audioDetails = null;
                mediadetails.unknownFieldData = null;
                mediadetails.cachedSize = -1;
            }
        }

        if(mediaDetails != null)
            cachedsize.mediaDetails = mediaDetails.clone();
        class PlaybackDetails extends ExtendableMessageNano
            implements Cloneable
        {

            public final PlaybackDetails clone()
            {
                PlaybackDetails playbackdetails;
                try
                {
                    playbackdetails = (PlaybackDetails)super.clone();
                }
                catch(CloneNotSupportedException clonenotsupportedexception1)
                {
                    throw new AssertionError(clonenotsupportedexception1);
                }
                class VideoPlaybackDetails extends ExtendableMessageNano
                    implements Cloneable
                {

                    public final VideoPlaybackDetails clone()
                    {
                        VideoPlaybackDetails videoplaybackdetails;
                        try
                        {
                            videoplaybackdetails = (VideoPlaybackDetails)super.clone();
                        }
                        catch(CloneNotSupportedException clonenotsupportedexception2)
                        {
                            throw new AssertionError(clonenotsupportedexception2);
                        }
                        return videoplaybackdetails;
                    }

                    public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
                        throws IOException
                    {
                        if(playbackMode != null)
                            codedoutputbytebuffernano.writeInt32(1, playbackMode.intValue());
                        if(usedExternalSync != null)
                            codedoutputbytebuffernano.writeBool(2, usedExternalSync.booleanValue());
                        if(droppedFramesCount != null)
                            codedoutputbytebuffernano.writeInt32(3, droppedFramesCount.intValue());
                        super.writeTo(codedoutputbytebuffernano);
                    }

                    protected final int computeSerializedSize()
                    {
                        int i = super.computeSerializedSize();
                        if(playbackMode != null)
                            i += CodedOutputByteBufferNano.computeInt32Size(1, playbackMode.intValue());
                        if(usedExternalSync != null)
                            i += CodedOutputByteBufferNano.computeBoolSize(2, usedExternalSync.booleanValue());
                        if(droppedFramesCount != null)
                            i += CodedOutputByteBufferNano.computeInt32Size(3, droppedFramesCount.intValue());
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
                        VideoPlaybackDetails videoplaybackdetails = this;
                        int i;
                        int j;
                        do
                            switch(i = codedinputbytebuffernano1.readTag())
                            {
                            case 0: // '\0'
                                return videoplaybackdetails;

                            default:
                                if(!videoplaybackdetails.super.storeUnknownField(codedinputbytebuffernano1, i))
                                    return videoplaybackdetails;
                                continue;

                            case 8: // '\b'
                                switch(j = codedinputbytebuffernano1.readInt32())
                                {
                                case 0: // '\0'
                                case 1: // '\001'
                                case 2: // '\002'
                                    videoplaybackdetails.playbackMode = Integer.valueOf(j);
                                    break;
                                }
                                break;

                            case 16: // '\020'
                                videoplaybackdetails.usedExternalSync = Boolean.valueOf(codedinputbytebuffernano1.readBool());
                                break;

                            case 24: // '\030'
                                videoplaybackdetails.droppedFramesCount = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                                break;
                            }
                        while(true);
                    }

                    public final volatile Object clone()
                        throws CloneNotSupportedException
                    {
                        return clone();
                    }

                    private Integer playbackMode;
                    private Boolean usedExternalSync;
                    private Integer droppedFramesCount;

                        public VideoPlaybackDetails()
                        {
                            VideoPlaybackDetails videoplaybackdetails;
                            (videoplaybackdetails = this).usedExternalSync = null;
                            videoplaybackdetails.droppedFramesCount = null;
                            videoplaybackdetails.unknownFieldData = null;
                            videoplaybackdetails.cachedSize = -1;
                        }
                }

                if(videoPlayback != null)
                    playbackdetails.videoPlayback = videoPlayback.clone();
                class ImagePlaybackDetails extends ExtendableMessageNano
                    implements Cloneable
                {

                    public final ImagePlaybackDetails clone()
                    {
                        ImagePlaybackDetails imageplaybackdetails;
                        try
                        {
                            imageplaybackdetails = (ImagePlaybackDetails)super.clone();
                        }
                        catch(CloneNotSupportedException clonenotsupportedexception2)
                        {
                            throw new AssertionError(clonenotsupportedexception2);
                        }
                        return imageplaybackdetails;
                    }

                    public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
                        throws IOException
                    {
                        if(playbackMode != null)
                            codedoutputbytebuffernano.writeInt32(1, playbackMode.intValue());
                        super.writeTo(codedoutputbytebuffernano);
                    }

                    protected final int computeSerializedSize()
                    {
                        int i = super.computeSerializedSize();
                        if(playbackMode != null)
                            i += CodedOutputByteBufferNano.computeInt32Size(1, playbackMode.intValue());
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
                        ImagePlaybackDetails imageplaybackdetails;
                        CodedInputByteBufferNano codedinputbytebuffernano1;
                        codedinputbytebuffernano1 = codedinputbytebuffernano;
                        imageplaybackdetails = this;
_L7:
                        int i = codedinputbytebuffernano1.readTag();
                        JVM INSTR lookupswitch 2: default 38
                    //                                   0: 36
                    //                                   8: 50;
                           goto _L1 _L2 _L3
_L2:
                        return imageplaybackdetails;
_L1:
                        if(!imageplaybackdetails.super.storeUnknownField(codedinputbytebuffernano1, i))
                            return imageplaybackdetails;
                        continue; /* Loop/switch isn't completed */
_L3:
                        int j = codedinputbytebuffernano1.readInt32();
                        JVM INSTR tableswitch 0 2: default 93
                    //                                   0 84
                    //                                   1 84
                    //                                   2 84;
                           goto _L4 _L5 _L5 _L5
_L4:
                        continue; /* Loop/switch isn't completed */
_L5:
                        imageplaybackdetails.playbackMode = Integer.valueOf(j);
                        if(true) goto _L7; else goto _L6
_L6:
                    }

                    public final volatile Object clone()
                        throws CloneNotSupportedException
                    {
                        return clone();
                    }

                    private Integer playbackMode;

                        public ImagePlaybackDetails()
                        {
                            ImagePlaybackDetails imageplaybackdetails;
                            (imageplaybackdetails = this).unknownFieldData = null;
                            imageplaybackdetails.cachedSize = -1;
                        }
                }

                if(imagePlayback != null)
                    playbackdetails.imagePlayback = imagePlayback.clone();
                return playbackdetails;
            }

            public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
                throws IOException
            {
                if(playbackState != null)
                    codedoutputbytebuffernano.writeInt32(1, playbackState.intValue());
                if(playbackDurationSeconds != null)
                    codedoutputbytebuffernano.writeInt64(2, playbackDurationSeconds.longValue());
                if(playbackEngine != null)
                    codedoutputbytebuffernano.writeInt32(3, playbackEngine.intValue());
                if(videoPlayback != null)
                    codedoutputbytebuffernano.writeMessage(4, videoPlayback);
                if(imagePlayback != null)
                    codedoutputbytebuffernano.writeMessage(5, imagePlayback);
                super.writeTo(codedoutputbytebuffernano);
            }

            protected final int computeSerializedSize()
            {
                int i = super.computeSerializedSize();
                if(playbackState != null)
                    i += CodedOutputByteBufferNano.computeInt32Size(1, playbackState.intValue());
                if(playbackDurationSeconds != null)
                    i += CodedOutputByteBufferNano.computeInt64Size(2, playbackDurationSeconds.longValue());
                if(playbackEngine != null)
                    i += CodedOutputByteBufferNano.computeInt32Size(3, playbackEngine.intValue());
                if(videoPlayback != null)
                    i += CodedOutputByteBufferNano.computeMessageSize(4, videoPlayback);
                if(imagePlayback != null)
                    i += CodedOutputByteBufferNano.computeMessageSize(5, imagePlayback);
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
                PlaybackDetails playbackdetails = this;
                int i;
                int j;
                do
                    switch(i = codedinputbytebuffernano1.readTag())
                    {
                    case 0: // '\0'
                        return playbackdetails;

                    default:
                        if(!playbackdetails.super.storeUnknownField(codedinputbytebuffernano1, i))
                            return playbackdetails;
                        break;

                    case 8: // '\b'
                        switch(j = codedinputbytebuffernano1.readInt32())
                        {
                        case 0: // '\0'
                        case 1: // '\001'
                        case 2: // '\002'
                        case 3: // '\003'
                            playbackdetails.playbackState = Integer.valueOf(j);
                            break;
                        }
                        break;

                    case 16: // '\020'
                        playbackdetails.playbackDurationSeconds = Long.valueOf(codedinputbytebuffernano1.readInt64());
                        break;

                    case 24: // '\030'
                        switch(j = codedinputbytebuffernano1.readInt32())
                        {
                        case 0: // '\0'
                        case 1: // '\001'
                        case 2: // '\002'
                            playbackdetails.playbackEngine = Integer.valueOf(j);
                            break;
                        }
                        break;

                    case 34: // '"'
                        if(playbackdetails.videoPlayback == null)
                            playbackdetails.videoPlayback = new VideoPlaybackDetails();
                        codedinputbytebuffernano1.readMessage(playbackdetails.videoPlayback);
                        break;

                    case 42: // '*'
                        if(playbackdetails.imagePlayback == null)
                            playbackdetails.imagePlayback = new ImagePlaybackDetails();
                        codedinputbytebuffernano1.readMessage(playbackdetails.imagePlayback);
                        break;
                    }
                while(true);
            }

            public final volatile Object clone()
                throws CloneNotSupportedException
            {
                return clone();
            }

            private Integer playbackState;
            private Long playbackDurationSeconds;
            private Integer playbackEngine;
            private VideoPlaybackDetails videoPlayback;
            private ImagePlaybackDetails imagePlayback;

            public PlaybackDetails()
            {
                PlaybackDetails playbackdetails;
                (playbackdetails = this).playbackDurationSeconds = null;
                playbackdetails.videoPlayback = null;
                playbackdetails.imagePlayback = null;
                playbackdetails.unknownFieldData = null;
                playbackdetails.cachedSize = -1;
            }
        }

        if(playbackDetails != null)
            cachedsize.playbackDetails = playbackDetails.clone();
        class PickerDetails extends ExtendableMessageNano
            implements Cloneable
        {

            public final PickerDetails clone()
            {
                PickerDetails pickerdetails;
                try
                {
                    pickerdetails = (PickerDetails)super.clone();
                }
                catch(CloneNotSupportedException clonenotsupportedexception1)
                {
                    throw new AssertionError(clonenotsupportedexception1);
                }
                return pickerdetails;
            }

            public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
                throws IOException
            {
                if(numberOfFiles != null)
                    codedoutputbytebuffernano.writeInt32(1, numberOfFiles.intValue());
                if(numberOfFolders != null)
                    codedoutputbytebuffernano.writeInt32(2, numberOfFolders.intValue());
                super.writeTo(codedoutputbytebuffernano);
            }

            protected final int computeSerializedSize()
            {
                int i = super.computeSerializedSize();
                if(numberOfFiles != null)
                    i += CodedOutputByteBufferNano.computeInt32Size(1, numberOfFiles.intValue());
                if(numberOfFolders != null)
                    i += CodedOutputByteBufferNano.computeInt32Size(2, numberOfFolders.intValue());
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
                PickerDetails pickerdetails = this;
                int i;
                do
                    switch(i = codedinputbytebuffernano1.readTag())
                    {
                    case 0: // '\0'
                        return pickerdetails;

                    default:
                        if(!pickerdetails.super.storeUnknownField(codedinputbytebuffernano1, i))
                            return pickerdetails;
                        break;

                    case 8: // '\b'
                        pickerdetails.numberOfFiles = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                        break;

                    case 16: // '\020'
                        pickerdetails.numberOfFolders = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                        break;
                    }
                while(true);
            }

            public final volatile Object clone()
                throws CloneNotSupportedException
            {
                return clone();
            }

            private Integer numberOfFiles;
            private Integer numberOfFolders;

            public PickerDetails()
            {
                PickerDetails pickerdetails;
                (pickerdetails = this).numberOfFiles = null;
                pickerdetails.numberOfFolders = null;
                pickerdetails.unknownFieldData = null;
                pickerdetails.cachedSize = -1;
            }
        }

        if(pickerEvent != null)
            cachedsize.pickerEvent = pickerEvent.clone();
        return cachedsize;
    }

    public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
        throws IOException
    {
        if(mediaDetails != null)
            codedoutputbytebuffernano.writeMessage(1, mediaDetails);
        if(playbackDetails != null)
            codedoutputbytebuffernano.writeMessage(2, playbackDetails);
        if(pickerEvent != null)
            codedoutputbytebuffernano.writeMessage(3, pickerEvent);
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(mediaDetails != null)
            i += CodedOutputByteBufferNano.computeMessageSize(1, mediaDetails);
        if(playbackDetails != null)
            i += CodedOutputByteBufferNano.computeMessageSize(2, playbackDetails);
        if(pickerEvent != null)
            i += CodedOutputByteBufferNano.computeMessageSize(3, pickerEvent);
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
                if(clone1.mediaDetails == null)
                    clone1.mediaDetails = new MediaDetails();
                codedinputbytebuffernano1.readMessage(clone1.mediaDetails);
                break;

            case 18: // '\022'
                if(clone1.playbackDetails == null)
                    clone1.playbackDetails = new PlaybackDetails();
                codedinputbytebuffernano1.readMessage(clone1.playbackDetails);
                break;

            case 26: // '\032'
                if(clone1.pickerEvent == null)
                    clone1.pickerEvent = new PickerDetails();
                codedinputbytebuffernano1.readMessage(clone1.pickerEvent);
                break;
            }
        while(true);
    }

    public final volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    private MediaDetails mediaDetails;
    private PlaybackDetails playbackDetails;
    private PickerDetails pickerEvent;

    public PickerDetails()
    {
        PickerDetails pickerdetails;
        (pickerdetails = this).mediaDetails = null;
        pickerdetails.playbackDetails = null;
        pickerdetails.pickerEvent = null;
        pickerdetails.unknownFieldData = null;
        pickerdetails.cachedSize = -1;
    }
}
