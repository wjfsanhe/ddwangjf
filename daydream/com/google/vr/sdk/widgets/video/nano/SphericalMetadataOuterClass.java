// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SphericalMetadataOuterClass.java

package com.google.vr.sdk.widgets.video.nano;

import com.google.protobuf.nano.*;
import java.io.IOException;

public interface SphericalMetadataOuterClass
{
    public static final class SphericalMetadata extends MessageNano
    {

        public static SphericalMetadata[] emptyArray()
        {
            if(_emptyArray == null)
                synchronized(InternalNano.LAZY_INIT_LOCK)
                {
                    if(_emptyArray == null)
                        _emptyArray = new SphericalMetadata[0];
                }
            return _emptyArray;
        }

        public SphericalMetadata clear()
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

        public SphericalMetadata mergeFrom(CodedInputByteBufferNano input)
            throws IOException
        {
_L9:
            int tag = input.readTag();
            tag;
            JVM INSTR lookupswitch 6: default 66
        //                       0: 64
        //                       8: 76
        //                       16: 87
        //                       24: 98
        //                       32: 109
        //                       42: 148;
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
                mesh = new StereoMeshConfig();
            input.readMessage(mesh);
            if(true) goto _L9; else goto _L10
_L10:
        }

        public static SphericalMetadata parseFrom(byte data[])
            throws InvalidProtocolBufferNanoException
        {
            return (SphericalMetadata)MessageNano.mergeFrom(new SphericalMetadata(), data);
        }

        public static SphericalMetadata parseFrom(CodedInputByteBufferNano input)
            throws IOException
        {
            return (new SphericalMetadata()).mergeFrom(input);
        }

        public volatile MessageNano mergeFrom(CodedInputByteBufferNano codedinputbytebuffernano)
            throws IOException
        {
            return mergeFrom(codedinputbytebuffernano);
        }

        public static final int STEREO_FRAME_LAYOUT_MONO = 1;
        public static final int STEREO_FRAME_LAYOUT_TOP_BOTTOM = 2;
        public static final int STEREO_FRAME_LAYOUT_LEFT_RIGHT = 3;
        private static volatile SphericalMetadata _emptyArray[];
        public int initialViewHeadingDegrees;
        public int initialViewPitchDegrees;
        public int initialViewRollDegrees;
        public int frameLayoutMode;
        public StereoMeshConfig mesh;

        public SphericalMetadata()
        {
            clear();
        }
    }

    public static final class StereoMeshConfig extends MessageNano
    {
        public static final class Mesh extends MessageNano
        {
            public static final class Vertex extends MessageNano
            {

                public static Vertex[] emptyArray()
                {
                    if(_emptyArray == null)
                        synchronized(InternalNano.LAZY_INIT_LOCK)
                        {
                            if(_emptyArray == null)
                                _emptyArray = new Vertex[0];
                        }
                    return _emptyArray;
                }

                public Vertex clear()
                {
                    x = 0.0F;
                    y = 0.0F;
                    z = 0.0F;
                    u = 0.0F;
                    v = 0.0F;
                    cachedSize = -1;
                    return this;
                }

                public void writeTo(CodedOutputByteBufferNano output)
                    throws IOException
                {
                    if(Float.floatToIntBits(x) != Float.floatToIntBits(0.0F))
                        output.writeFloat(1, x);
                    if(Float.floatToIntBits(y) != Float.floatToIntBits(0.0F))
                        output.writeFloat(2, y);
                    if(Float.floatToIntBits(z) != Float.floatToIntBits(0.0F))
                        output.writeFloat(3, z);
                    if(Float.floatToIntBits(u) != Float.floatToIntBits(0.0F))
                        output.writeFloat(4, u);
                    if(Float.floatToIntBits(v) != Float.floatToIntBits(0.0F))
                        output.writeFloat(5, v);
                    super.writeTo(output);
                }

                protected int computeSerializedSize()
                {
                    int size = super.computeSerializedSize();
                    if(Float.floatToIntBits(x) != Float.floatToIntBits(0.0F))
                        size += CodedOutputByteBufferNano.computeFloatSize(1, x);
                    if(Float.floatToIntBits(y) != Float.floatToIntBits(0.0F))
                        size += CodedOutputByteBufferNano.computeFloatSize(2, y);
                    if(Float.floatToIntBits(z) != Float.floatToIntBits(0.0F))
                        size += CodedOutputByteBufferNano.computeFloatSize(3, z);
                    if(Float.floatToIntBits(u) != Float.floatToIntBits(0.0F))
                        size += CodedOutputByteBufferNano.computeFloatSize(4, u);
                    if(Float.floatToIntBits(v) != Float.floatToIntBits(0.0F))
                        size += CodedOutputByteBufferNano.computeFloatSize(5, v);
                    return size;
                }

                public Vertex mergeFrom(CodedInputByteBufferNano input)
                    throws IOException
                {
                    do
                    {
                        int tag = input.readTag();
                        switch(tag)
                        {
                        case 0: // '\0'
                            return this;

                        default:
                            if(!WireFormatNano.parseUnknownField(input, tag))
                                return this;
                            break;

                        case 13: // '\r'
                            x = input.readFloat();
                            break;

                        case 21: // '\025'
                            y = input.readFloat();
                            break;

                        case 29: // '\035'
                            z = input.readFloat();
                            break;

                        case 37: // '%'
                            u = input.readFloat();
                            break;

                        case 45: // '-'
                            v = input.readFloat();
                            break;
                        }
                    } while(true);
                }

                public static Vertex parseFrom(byte data[])
                    throws InvalidProtocolBufferNanoException
                {
                    return (Vertex)MessageNano.mergeFrom(new Vertex(), data);
                }

                public static Vertex parseFrom(CodedInputByteBufferNano input)
                    throws IOException
                {
                    return (new Vertex()).mergeFrom(input);
                }

                public volatile MessageNano mergeFrom(CodedInputByteBufferNano codedinputbytebuffernano)
                    throws IOException
                {
                    return mergeFrom(codedinputbytebuffernano);
                }

                private static volatile Vertex _emptyArray[];
                public float x;
                public float y;
                public float z;
                public float u;
                public float v;

                public Vertex()
                {
                    clear();
                }
            }


            public static Mesh[] emptyArray()
            {
                if(_emptyArray == null)
                    synchronized(InternalNano.LAZY_INIT_LOCK)
                    {
                        if(_emptyArray == null)
                            _emptyArray = new Mesh[0];
                    }
                return _emptyArray;
            }

            public Mesh clear()
            {
                vertices = Vertex.emptyArray();
                geometryType = 0;
                cachedSize = -1;
                return this;
            }

            public void writeTo(CodedOutputByteBufferNano output)
                throws IOException
            {
                if(vertices != null && vertices.length > 0)
                {
                    for(int i = 0; i < vertices.length; i++)
                    {
                        Vertex element = vertices[i];
                        if(element != null)
                            output.writeMessage(1, element);
                    }

                }
                if(geometryType != 0)
                    output.writeInt32(2, geometryType);
                super.writeTo(output);
            }

            protected int computeSerializedSize()
            {
                int size = super.computeSerializedSize();
                if(vertices != null && vertices.length > 0)
                {
                    for(int i = 0; i < vertices.length; i++)
                    {
                        Vertex element = vertices[i];
                        if(element != null)
                            size += CodedOutputByteBufferNano.computeMessageSize(1, element);
                    }

                }
                if(geometryType != 0)
                    size += CodedOutputByteBufferNano.computeInt32Size(2, geometryType);
                return size;
            }

            public Mesh mergeFrom(CodedInputByteBufferNano input)
                throws IOException
            {
_L6:
                int tag = input.readTag();
                tag;
                JVM INSTR lookupswitch 3: default 42
            //                           0: 40
            //                           10: 52
            //                           16: 176;
                   goto _L1 _L2 _L3 _L4
_L2:
                return this;
_L1:
                if(WireFormatNano.parseUnknownField(input, tag)) goto _L6; else goto _L5
_L5:
                return this;
_L3:
                int arrayLength = WireFormatNano.getRepeatedFieldArrayLength(input, 10);
                int i = vertices != null ? vertices.length : 0;
                Vertex newArray[] = new Vertex[i + arrayLength];
                if(i != 0)
                    System.arraycopy(vertices, 0, newArray, 0, i);
                for(; i < newArray.length - 1; i++)
                {
                    newArray[i] = new Vertex();
                    input.readMessage(newArray[i]);
                    input.readTag();
                }

                newArray[i] = new Vertex();
                input.readMessage(newArray[i]);
                vertices = newArray;
                  goto _L6
_L4:
                int value = input.readInt32();
                value;
                JVM INSTR lookupswitch 2: default 213
            //                           0: 208
            //                           1: 208;
                   goto _L7 _L8 _L8
_L7:
                continue; /* Loop/switch isn't completed */
_L8:
                geometryType = value;
                if(true) goto _L6; else goto _L9
_L9:
            }

            public static Mesh parseFrom(byte data[])
                throws InvalidProtocolBufferNanoException
            {
                return (Mesh)MessageNano.mergeFrom(new Mesh(), data);
            }

            public static Mesh parseFrom(CodedInputByteBufferNano input)
                throws IOException
            {
                return (new Mesh()).mergeFrom(input);
            }

            public volatile MessageNano mergeFrom(CodedInputByteBufferNano codedinputbytebuffernano)
                throws IOException
            {
                return mergeFrom(codedinputbytebuffernano);
            }

            public static final int TRIANGLES = 0;
            public static final int TRIANGLE_STRIP = 1;
            private static volatile Mesh _emptyArray[];
            public Vertex vertices[];
            public int geometryType;

            public Mesh()
            {
                clear();
            }
        }


        public static StereoMeshConfig[] emptyArray()
        {
            if(_emptyArray == null)
                synchronized(InternalNano.LAZY_INIT_LOCK)
                {
                    if(_emptyArray == null)
                        _emptyArray = new StereoMeshConfig[0];
                }
            return _emptyArray;
        }

        public StereoMeshConfig clear()
        {
            leftEyeMesh = null;
            rightEyeMesh = null;
            cachedSize = -1;
            return this;
        }

        public void writeTo(CodedOutputByteBufferNano output)
            throws IOException
        {
            if(leftEyeMesh != null)
                output.writeMessage(1, leftEyeMesh);
            if(rightEyeMesh != null)
                output.writeMessage(2, rightEyeMesh);
            super.writeTo(output);
        }

        protected int computeSerializedSize()
        {
            int size = super.computeSerializedSize();
            if(leftEyeMesh != null)
                size += CodedOutputByteBufferNano.computeMessageSize(1, leftEyeMesh);
            if(rightEyeMesh != null)
                size += CodedOutputByteBufferNano.computeMessageSize(2, rightEyeMesh);
            return size;
        }

        public StereoMeshConfig mergeFrom(CodedInputByteBufferNano input)
            throws IOException
        {
            do
            {
                int tag = input.readTag();
                switch(tag)
                {
                case 0: // '\0'
                    return this;

                default:
                    if(!WireFormatNano.parseUnknownField(input, tag))
                        return this;
                    break;

                case 10: // '\n'
                    if(leftEyeMesh == null)
                        leftEyeMesh = new Mesh();
                    input.readMessage(leftEyeMesh);
                    break;

                case 18: // '\022'
                    if(rightEyeMesh == null)
                        rightEyeMesh = new Mesh();
                    input.readMessage(rightEyeMesh);
                    break;
                }
            } while(true);
        }

        public static StereoMeshConfig parseFrom(byte data[])
            throws InvalidProtocolBufferNanoException
        {
            return (StereoMeshConfig)MessageNano.mergeFrom(new StereoMeshConfig(), data);
        }

        public static StereoMeshConfig parseFrom(CodedInputByteBufferNano input)
            throws IOException
        {
            return (new StereoMeshConfig()).mergeFrom(input);
        }

        public volatile MessageNano mergeFrom(CodedInputByteBufferNano codedinputbytebuffernano)
            throws IOException
        {
            return mergeFrom(codedinputbytebuffernano);
        }

        private static volatile StereoMeshConfig _emptyArray[];
        public Mesh leftEyeMesh;
        public Mesh rightEyeMesh;

        public StereoMeshConfig()
        {
            clear();
        }
    }

}
