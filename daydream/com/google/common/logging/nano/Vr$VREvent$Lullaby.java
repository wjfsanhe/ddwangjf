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
        LoadTime.cachedSize cachedsize;
        try
        {
            cachedsize = (LoadTime.cachedSize)super.clone();
        }
        catch(CloneNotSupportedException clonenotsupportedexception)
        {
            throw new AssertionError(clonenotsupportedexception);
        }
        class LoadTime extends ExtendableMessageNano
            implements Cloneable
        {

            public final LoadTime clone()
            {
                LoadTime loadtime;
                try
                {
                    loadtime = (LoadTime)super.clone();
                }
                catch(CloneNotSupportedException clonenotsupportedexception1)
                {
                    throw new AssertionError(clonenotsupportedexception1);
                }
                return loadtime;
            }

            public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
                throws IOException
            {
                if(assetType != null)
                    codedoutputbytebuffernano.writeInt32(1, assetType.intValue());
                if(loadTimeMs != null)
                    codedoutputbytebuffernano.writeInt64(2, loadTimeMs.longValue());
                super.writeTo(codedoutputbytebuffernano);
            }

            protected final int computeSerializedSize()
            {
                int i = super.computeSerializedSize();
                if(assetType != null)
                    i += CodedOutputByteBufferNano.computeInt32Size(1, assetType.intValue());
                if(loadTimeMs != null)
                    i += CodedOutputByteBufferNano.computeInt64Size(2, loadTimeMs.longValue());
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
                LoadTime loadtime = this;
                int i;
                int j;
                do
                    switch(i = codedinputbytebuffernano1.readTag())
                    {
                    case 0: // '\0'
                        return loadtime;

                    default:
                        if(!loadtime.super.storeUnknownField(codedinputbytebuffernano1, i))
                            return loadtime;
                        continue;

                    case 8: // '\b'
                        switch(j = codedinputbytebuffernano1.readInt32())
                        {
                        case 0: // '\0'
                        case 1: // '\001'
                        case 2: // '\002'
                        case 3: // '\003'
                        case 4: // '\004'
                        case 5: // '\005'
                        case 6: // '\006'
                        case 7: // '\007'
                        case 8: // '\b'
                        case 9: // '\t'
                        case 10: // '\n'
                            loadtime.assetType = Integer.valueOf(j);
                            break;
                        }
                        break;

                    case 16: // '\020'
                        loadtime.loadTimeMs = Long.valueOf(codedinputbytebuffernano1.readInt64());
                        break;
                    }
                while(true);
            }

            public final volatile Object clone()
                throws CloneNotSupportedException
            {
                return clone();
            }

            private Integer assetType;
            private Long loadTimeMs;

            public LoadTime()
            {
                LoadTime loadtime;
                (loadtime = this).loadTimeMs = null;
                loadtime.unknownFieldData = null;
                loadtime.cachedSize = -1;
            }
        }

        if(loadTime != null)
            cachedsize.loadTime = loadTime.clone();
        return cachedsize;
    }

    public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
        throws IOException
    {
        if(uiElement != null)
            codedoutputbytebuffernano.writeInt32(1, uiElement.intValue());
        if(index != null)
            codedoutputbytebuffernano.writeInt32(2, index.intValue());
        if(contentId != null)
            codedoutputbytebuffernano.writeString(3, contentId);
        if(loadTime != null)
            codedoutputbytebuffernano.writeMessage(4, loadTime);
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(uiElement != null)
            i += CodedOutputByteBufferNano.computeInt32Size(1, uiElement.intValue());
        if(index != null)
            i += CodedOutputByteBufferNano.computeInt32Size(2, index.intValue());
        if(contentId != null)
            i += CodedOutputByteBufferNano.computeStringSize(3, contentId);
        if(loadTime != null)
            i += CodedOutputByteBufferNano.computeMessageSize(4, loadTime);
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
                case 1000: 
                case 1001: 
                case 1002: 
                case 1003: 
                case 1004: 
                case 1005: 
                case 1006: 
                case 1007: 
                case 2000: 
                case 2001: 
                case 2002: 
                case 2003: 
                case 2004: 
                case 2005: 
                case 2006: 
                case 2007: 
                case 2008: 
                case 2009: 
                case 2010: 
                case 2011: 
                case 2012: 
                case 2013: 
                case 2014: 
                case 2015: 
                case 2016: 
                case 2017: 
                case 2018: 
                case 2019: 
                case 2020: 
                case 2021: 
                    clone1.uiElement = Integer.valueOf(j);
                    break;
                }
                break;

            case 16: // '\020'
                clone1.index = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                break;

            case 26: // '\032'
                clone1.contentId = codedinputbytebuffernano1.readString();
                break;

            case 34: // '"'
                if(clone1.loadTime == null)
                    clone1.loadTime = new LoadTime();
                codedinputbytebuffernano1.readMessage(clone1.loadTime);
                break;
            }
        while(true);
    }

    public final volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    private Integer uiElement;
    private Integer index;
    private String contentId;
    private LoadTime loadTime;

    public ()
    {
         ;
        ( = this).index = null;
        .contentId = null;
        .loadTime = null;
        .unknownFieldData = null;
        .cachedSize = -1;
    }
}
