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
        if(manufacturer != null)
            codedoutputbytebuffernano.writeString(1, manufacturer);
        if(model != null)
            codedoutputbytebuffernano.writeString(2, model);
        if(firmware != null)
            codedoutputbytebuffernano.writeString(3, firmware);
        if(availableFirmware != null)
            codedoutputbytebuffernano.writeString(4, availableFirmware);
        if(softwareRevision != null)
            codedoutputbytebuffernano.writeString(5, softwareRevision);
        if(batteryLevel != null)
            codedoutputbytebuffernano.writeInt32(6, batteryLevel.intValue());
        if(hardwareRevision != null)
            codedoutputbytebuffernano.writeString(7, hardwareRevision);
        if(xRailCount != null)
            codedoutputbytebuffernano.writeInt32(8, xRailCount.intValue());
        if(yRailCount != null)
            codedoutputbytebuffernano.writeInt32(9, yRailCount.intValue());
        if(zRailCount != null)
            codedoutputbytebuffernano.writeInt32(10, zRailCount.intValue());
        if(sampleCount != null)
            codedoutputbytebuffernano.writeInt32(11, sampleCount.intValue());
        if(sensorType != null)
            codedoutputbytebuffernano.writeInt32(12, sensorType.intValue());
        if(axis != null)
            codedoutputbytebuffernano.writeInt32(13, axis.intValue());
        if(otaRetries != null)
            codedoutputbytebuffernano.writeInt32(14, otaRetries.intValue());
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(manufacturer != null)
            i += CodedOutputByteBufferNano.computeStringSize(1, manufacturer);
        if(model != null)
            i += CodedOutputByteBufferNano.computeStringSize(2, model);
        if(firmware != null)
            i += CodedOutputByteBufferNano.computeStringSize(3, firmware);
        if(availableFirmware != null)
            i += CodedOutputByteBufferNano.computeStringSize(4, availableFirmware);
        if(softwareRevision != null)
            i += CodedOutputByteBufferNano.computeStringSize(5, softwareRevision);
        if(batteryLevel != null)
            i += CodedOutputByteBufferNano.computeInt32Size(6, batteryLevel.intValue());
        if(hardwareRevision != null)
            i += CodedOutputByteBufferNano.computeStringSize(7, hardwareRevision);
        if(xRailCount != null)
            i += CodedOutputByteBufferNano.computeInt32Size(8, xRailCount.intValue());
        if(yRailCount != null)
            i += CodedOutputByteBufferNano.computeInt32Size(9, yRailCount.intValue());
        if(zRailCount != null)
            i += CodedOutputByteBufferNano.computeInt32Size(10, zRailCount.intValue());
        if(sampleCount != null)
            i += CodedOutputByteBufferNano.computeInt32Size(11, sampleCount.intValue());
        if(sensorType != null)
            i += CodedOutputByteBufferNano.computeInt32Size(12, sensorType.intValue());
        if(axis != null)
            i += CodedOutputByteBufferNano.computeInt32Size(13, axis.intValue());
        if(otaRetries != null)
            i += CodedOutputByteBufferNano.computeInt32Size(14, otaRetries.intValue());
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

            case 10: // '\n'
                clone1.manufacturer = codedinputbytebuffernano1.readString();
                break;

            case 18: // '\022'
                clone1.model = codedinputbytebuffernano1.readString();
                break;

            case 26: // '\032'
                clone1.firmware = codedinputbytebuffernano1.readString();
                break;

            case 34: // '"'
                clone1.availableFirmware = codedinputbytebuffernano1.readString();
                break;

            case 42: // '*'
                clone1.softwareRevision = codedinputbytebuffernano1.readString();
                break;

            case 48: // '0'
                clone1.batteryLevel = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                break;

            case 58: // ':'
                clone1.hardwareRevision = codedinputbytebuffernano1.readString();
                break;

            case 64: // '@'
                clone1.xRailCount = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                break;

            case 72: // 'H'
                clone1.yRailCount = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                break;

            case 80: // 'P'
                clone1.zRailCount = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                break;

            case 88: // 'X'
                clone1.sampleCount = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                break;

            case 96: // '`'
                switch(j = codedinputbytebuffernano1.readInt32())
                {
                case 0: // '\0'
                case 1: // '\001'
                case 2: // '\002'
                    clone1.sensorType = Integer.valueOf(j);
                    break;
                }
                break;

            case 104: // 'h'
                switch(j = codedinputbytebuffernano1.readInt32())
                {
                case 0: // '\0'
                case 1: // '\001'
                case 2: // '\002'
                case 3: // '\003'
                    clone1.axis = Integer.valueOf(j);
                    break;
                }
                break;

            case 112: // 'p'
                clone1.otaRetries = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                break;
            }
        while(true);
    }

    public final volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    private String manufacturer;
    private String model;
    private String firmware;
    private String availableFirmware;
    private String softwareRevision;
    private Integer batteryLevel;
    private String hardwareRevision;
    private Integer xRailCount;
    private Integer yRailCount;
    private Integer zRailCount;
    private Integer sampleCount;
    private Integer sensorType;
    private Integer axis;
    private Integer otaRetries;

    public A()
    {
        A a;
        (a = this).manufacturer = null;
        a.model = null;
        a.firmware = null;
        a.availableFirmware = null;
        a.softwareRevision = null;
        a.batteryLevel = null;
        a.hardwareRevision = null;
        a.xRailCount = null;
        a.yRailCount = null;
        a.zRailCount = null;
        a.sampleCount = null;
        a.otaRetries = null;
        a.unknownFieldData = null;
        a.cachedSize = -1;
    }
}
