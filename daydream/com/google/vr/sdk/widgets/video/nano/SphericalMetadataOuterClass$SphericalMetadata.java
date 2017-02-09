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
        initialViewHeadingDegrees = 0;
        initialViewPitchDegrees = 0;
        initialViewRollDegrees = 0;
        frameLayoutMode = 1;
        mesh = null;
        cachedSize = -1;
        return this;
    }

    public void writeTo(CodedOutputByteBufferNano output)
        throws IOException
    {
        if(initialViewHeadingDegrees != 0)
            output.writeInt32(1, initialViewHeadingDegrees);
        if(initialViewPitchDegrees != 0)
            output.writeInt32(2, initialViewPitchDegrees);
        if(initialViewRollDegrees != 0)
            output.writeInt32(3, initialViewRollDegrees);
        if(frameLayoutMode != 1)
            output.writeInt32(4, frameLayoutMode);
        if(mesh != null)
            output.writeMessage(5, mesh);
        super.writeTo(output);
    }

    protected int computeSerializedSize()
    {
        int size = super.computeSerializedSize();
        if(initialViewHeadingDegrees != 0)
            size += CodedOutputByteBufferNano.computeInt32Size(1, initialViewHeadingDegrees);
        if(initialViewPitchDegrees != 0)
            size += CodedOutputByteBufferNano.computeInt32Size(2, initialViewPitchDegrees);
        if(initialViewRollDegrees != 0)
            size += CodedOutputByteBufferNano.computeInt32Size(3, initialViewRollDegrees);
        if(frameLayoutMode != 1)
            size += CodedOutputByteBufferNano.computeInt32Size(4, frameLayoutMode);
        if(mesh != null)
            size += CodedOutputByteBufferNano.computeMessageSize(5, mesh);
        return size;
    }

    public mesh mergeFrom(CodedInputByteBufferNano input)
        throws IOException
    {
_L9:
        int tag = input.readTag();
        tag;
        JVM INSTR lookupswitch 6: default 66
    //                   0: 64
    //                   8: 76
    //                   16: 87
    //                   24: 98
    //                   32: 109
    //                   42: 148;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L2:
        return this;
_L1:
        if(WireFormatNano.parseUnknownField(input, tag)) goto _L9; else goto _L8
_L8:
        return this;
_L3:
        initialViewHeadingDegrees = input.readInt32();
          goto _L9
_L4:
        initialViewPitchDegrees = input.readInt32();
          goto _L9
_L5:
        initialViewRollDegrees = input.readInt32();
          goto _L9
_L6:
        int value = input.readInt32();
        switch(value)
        {
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            frameLayoutMode = value;
            break;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if(mesh == null)
            mesh = new init>();
        input.readMessage(mesh);
        if(true) goto _L9; else goto _L10
_L10:
    }

    public static mesh parseFrom(byte data[])
        throws InvalidProtocolBufferNanoException
    {
        return (mesh)MessageNano.mergeFrom(new <init>(), data);
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

    public static final int STEREO_FRAME_LAYOUT_MONO = 1;
    public static final int STEREO_FRAME_LAYOUT_TOP_BOTTOM = 2;
    public static final int STEREO_FRAME_LAYOUT_LEFT_RIGHT = 3;
    private static volatile mergeFrom _emptyArray[];
    public int initialViewHeadingDegrees;
    public int initialViewPitchDegrees;
    public int initialViewRollDegrees;
    public int frameLayoutMode;
    public mergeFrom mesh;

    public ()
    {
        clear();
    }
}
