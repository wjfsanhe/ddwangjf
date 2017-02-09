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

    public static cachedSize[] emptyArray()
    {
        if(_emptyArray == null)
            synchronized(InternalNano.LAZY_INIT_LOCK)
            {
                if(_emptyArray == null)
                    _emptyArray = new _emptyArray[0];
            }
        return _emptyArray;
    }

    public final _emptyArray clone()
    {
        _emptyArray _lemptyarray;
        try
        {
            _lemptyarray = (_emptyArray)super.clone();
        }
        catch(CloneNotSupportedException clonenotsupportedexception)
        {
            throw new AssertionError(clonenotsupportedexception);
        }
        if(textEntry != null)
            _lemptyarray.textEntry = textEntry.clone();
        if(keyboardService != null)
            _lemptyarray.keyboardService = keyboardService.keyboardService();
        if(systemLanguages != null && systemLanguages.length > 0)
            _lemptyarray.systemLanguages = (String[])systemLanguages.clone();
        if(enabledLanguages != null && enabledLanguages.length > 0)
            _lemptyarray.enabledLanguages = (String[])enabledLanguages.clone();
        return _lemptyarray;
    }

    public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
        throws IOException
    {
        if(clientTimestamp != null)
            codedoutputbytebuffernano.writeInt64(1, clientTimestamp.longValue());
        if(eventType != null)
            codedoutputbytebuffernano.writeInt32(2, eventType.intValue());
        if(textEntry != null)
            codedoutputbytebuffernano.writeMessage(3, textEntry);
        if(keyboardService != null)
            codedoutputbytebuffernano.writeMessage(4, keyboardService);
        if(systemLanguages != null && systemLanguages.length > 0)
        {
            for(int i = 0; i < systemLanguages.length; i++)
            {
                String s;
                if((s = systemLanguages[i]) != null)
                    codedoutputbytebuffernano.writeString(5, s);
            }

        }
        if(enabledLanguages != null && enabledLanguages.length > 0)
        {
            for(int j = 0; j < enabledLanguages.length; j++)
            {
                String s1;
                if((s1 = enabledLanguages[j]) != null)
                    codedoutputbytebuffernano.writeString(6, s1);
            }

        }
        if(language != null)
            codedoutputbytebuffernano.writeString(7, language);
        if(inputType != null)
            codedoutputbytebuffernano.writeInt32(8, inputType.intValue());
        if(layout != null)
            codedoutputbytebuffernano.writeString(9, layout);
        if(suggestionCount != null)
            codedoutputbytebuffernano.writeInt32(10, suggestionCount.intValue());
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(clientTimestamp != null)
            i += CodedOutputByteBufferNano.computeInt64Size(1, clientTimestamp.longValue());
        if(eventType != null)
            i += CodedOutputByteBufferNano.computeInt32Size(2, eventType.intValue());
        if(textEntry != null)
            i += CodedOutputByteBufferNano.computeMessageSize(3, textEntry);
        if(keyboardService != null)
            i += CodedOutputByteBufferNano.computeMessageSize(4, keyboardService);
        if(systemLanguages != null && systemLanguages.length > 0)
        {
            int j = 0;
            int l = 0;
            for(int j1 = 0; j1 < systemLanguages.length; j1++)
            {
                String s;
                if((s = systemLanguages[j1]) != null)
                {
                    j++;
                    l += CodedOutputByteBufferNano.computeStringSizeNoTag(s);
                }
            }

            i = (i += l) + 1 * j;
        }
        if(enabledLanguages != null && enabledLanguages.length > 0)
        {
            int k = 0;
            int i1 = 0;
            for(int k1 = 0; k1 < enabledLanguages.length; k1++)
            {
                String s1;
                if((s1 = enabledLanguages[k1]) != null)
                {
                    k++;
                    i1 += CodedOutputByteBufferNano.computeStringSizeNoTag(s1);
                }
            }

            i = (i += i1) + 1 * k;
        }
        if(language != null)
            i += CodedOutputByteBufferNano.computeStringSize(7, language);
        if(inputType != null)
            i += CodedOutputByteBufferNano.computeInt32Size(8, inputType.intValue());
        if(layout != null)
            i += CodedOutputByteBufferNano.computeStringSize(9, layout);
        if(suggestionCount != null)
            i += CodedOutputByteBufferNano.computeInt32Size(10, suggestionCount.intValue());
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
                clone1.clientTimestamp = Long.valueOf(codedinputbytebuffernano1.readInt64());
                break;

            case 16: // '\020'
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
                case 1000: 
                case 1001: 
                case 2000: 
                case 3000: 
                case 3001: 
                case 3002: 
                    clone1.eventType = Integer.valueOf(j);
                    break;
                }
                break;

            case 26: // '\032'
                if(clone1.textEntry == null)
                    clone1.textEntry = new try();
                codedinputbytebuffernano1.readMessage(clone1.textEntry);
                break;

            case 34: // '"'
                if(clone1.keyboardService == null)
                    clone1.keyboardService = new keyboardService();
                codedinputbytebuffernano1.readMessage(clone1.keyboardService);
                break;

            case 42: // '*'
                j = WireFormatNano.getRepeatedFieldArrayLength(codedinputbytebuffernano1, 42);
                int k;
                String as[] = new String[(k = clone1.systemLanguages != null ? clone1.systemLanguages.length : 0) + j];
                if(k != 0)
                    System.arraycopy(clone1.systemLanguages, 0, as, 0, k);
                for(; k < as.length - 1; k++)
                {
                    as[k] = codedinputbytebuffernano1.readString();
                    codedinputbytebuffernano1.readTag();
                }

                as[k] = codedinputbytebuffernano1.readString();
                clone1.systemLanguages = as;
                break;

            case 50: // '2'
                j = WireFormatNano.getRepeatedFieldArrayLength(codedinputbytebuffernano1, 50);
                int l;
                String as1[] = new String[(l = clone1.enabledLanguages != null ? clone1.enabledLanguages.length : 0) + j];
                if(l != 0)
                    System.arraycopy(clone1.enabledLanguages, 0, as1, 0, l);
                for(; l < as1.length - 1; l++)
                {
                    as1[l] = codedinputbytebuffernano1.readString();
                    codedinputbytebuffernano1.readTag();
                }

                as1[l] = codedinputbytebuffernano1.readString();
                clone1.enabledLanguages = as1;
                break;

            case 58: // ':'
                clone1.language = codedinputbytebuffernano1.readString();
                break;

            case 64: // '@'
                switch(j = codedinputbytebuffernano1.readInt32())
                {
                case 0: // '\0'
                case 1: // '\001'
                    clone1.inputType = Integer.valueOf(j);
                    break;
                }
                break;

            case 74: // 'J'
                clone1.layout = codedinputbytebuffernano1.readString();
                break;

            case 80: // 'P'
                clone1.suggestionCount = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                break;
            }
        while(true);
    }

    public final volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    private static volatile clone _emptyArray[];
    private Long clientTimestamp;
    private Integer eventType;
    private try textEntry;
    private try keyboardService;
    private String systemLanguages[];
    private String enabledLanguages[];
    private String language;
    private Integer inputType;
    private String layout;
    private Integer suggestionCount;

    public try()
    {
        try try1;
        (try1 = this).clientTimestamp = null;
        try1.textEntry = null;
        try1.keyboardService = null;
        try1.systemLanguages = WireFormatNano.EMPTY_STRING_ARRAY;
        try1.enabledLanguages = WireFormatNano.EMPTY_STRING_ARRAY;
        try1.language = null;
        try1.layout = null;
        try1.suggestionCount = null;
        try1.unknownFieldData = null;
        try1.cachedSize = -1;
    }
}
