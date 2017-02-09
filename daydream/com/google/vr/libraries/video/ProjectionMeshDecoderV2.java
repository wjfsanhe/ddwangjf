// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ProjectionMeshDecoderV2.java

package com.google.vr.libraries.video;

import com.google.android.exoplayer2.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

// Referenced classes of package com.google.vr.libraries.video:
//            ProjectionScene

public class ProjectionMeshDecoderV2
{

    public ProjectionMeshDecoderV2()
    {
        sceneList = new ArrayList();
    }

    public ProjectionScene decode(byte projectionData[])
    {
        if(projectionData == null)
            return null;
        error = false;
        ytmpParsed = false;
        scene = null;
        ParsableByteArray input = new ParsableByteArray(projectionData);
        if(isProj(input))
            return parseProj(input);
        else
            return parseYtmp(input, input.capacity());
    }

    private boolean isProj(ParsableByteArray input)
    {
        int position = input.getPosition();
        input.setPosition(0);
        input.skipBytes(4);
        int type = input.readInt();
        input.setPosition(position);
        return type == TYPE_PROJ;
    }

    private ProjectionScene parseProj(ParsableByteArray input)
    {
        input.skipBytes(8);
        int childAtomSize;
        for(int position = input.getPosition(); position < input.capacity() && !error; position += childAtomSize)
        {
            input.setPosition(position);
            childAtomSize = input.readInt();
            if(childAtomSize == 0)
                return null;
            int childAtomType = input.readInt();
            if(childAtomType != TYPE_YTMP && childAtomType != TYPE_MSHP)
                continue;
            if(ytmpParsed)
                return null;
            ProjectionScene sceneReturned = parseYtmp(input, childAtomSize + position);
            if(error)
                return null;
            if(sceneReturned != null)
                return sceneReturned;
        }

        return null;
    }

    private boolean readFromCache(int crc)
    {
        for(int i = 0; i < sceneList.size(); i++)
            if(((ProjectionScene)sceneList.get(i)).getCrc() == crc)
            {
                scene = (ProjectionScene)sceneList.get(i);
                return true;
            }

        return false;
    }

    private ProjectionScene parseYtmp(ParsableByteArray input, int endOfBoxPosition)
    {
        int version = input.readUnsignedByte();
        input.skipBytes(3);
        if(version == 0)
        {
            int crc = input.readInt();
            if(readFromCache(crc))
                return scene;
            int encoding = input.readInt();
            if(encoding == TYPE_RAW)
            {
                parseRawYtmpData(input, endOfBoxPosition, crc);
                ytmpParsed = true;
            } else
            if(encoding == TYPE_DFL8)
            {
                int outputLen[] = new int[1];
                byte rawData[] = inflate(input.data, input.getPosition(), endOfBoxPosition - input.getPosition(), outputLen);
                if(rawData == null)
                    return null;
                ParsableByteArray rawInput = new ParsableByteArray(rawData, outputLen[0]);
                parseRawYtmpData(rawInput, outputLen[0], crc);
                ytmpParsed = true;
            } else
            {
                error = true;
            }
            if(error)
                return null;
            if(scene.getLeftMesh() != null)
            {
                sceneList.add(scene);
                return scene;
            }
        }
        return null;
    }

    private void parseRawYtmpData(ParsableByteArray input, int endOfBoxPosition, int crc)
    {
        meshCount = 0;
        int position = input.getPosition();
        scene = new ProjectionScene(crc);
        int childAtomSize;
        for(; position < endOfBoxPosition && !error; position += childAtomSize)
        {
            input.setPosition(position);
            childAtomSize = input.readInt();
            if(childAtomSize == 0)
            {
                error = true;
                return;
            }
            int childAtomType = input.readInt();
            if(childAtomType != TYPE_MESH)
                continue;
            if(meshCount >= 2)
            {
                error = true;
                return;
            }
            parseMesh(input);
            meshCount++;
        }

    }

    private void parseMesh(ParsableByteArray input)
    {
        int coordinateCount = input.readInt();
        if(coordinateCount > 10000)
        {
            error = true;
            return;
        }
        float coordinates[] = new float[coordinateCount];
        int counter;
        for(counter = 0; counter < coordinateCount;)
            coordinates[counter++] = input.readFloat();

        int vertexCount = input.readInt();
        if(vertexCount > 32000)
        {
            error = true;
            return;
        }
        double log2 = Math.log(2D);
        int coordinateCountSizeBits = (int)Math.ceil(Math.log(2D * (double)coordinateCount) / log2);
        counter = 0;
        int xIndex = 0;
        int yIndex = 0;
        int zIndex = 0;
        int uIndex = 0;
        int vIndex = 0;
        ParsableBitArray bitInput = new ParsableBitArray(input.data);
        bitInput.setPosition(input.getPosition() * 8);
        float vertices[] = new float[vertexCount * 5];
        int vertexId = 0;
        while(counter++ < vertexCount) 
        {
            xIndex += decodeZigZag(bitInput.readBits(coordinateCountSizeBits));
            yIndex += decodeZigZag(bitInput.readBits(coordinateCountSizeBits));
            zIndex += decodeZigZag(bitInput.readBits(coordinateCountSizeBits));
            uIndex += decodeZigZag(bitInput.readBits(coordinateCountSizeBits));
            vIndex += decodeZigZag(bitInput.readBits(coordinateCountSizeBits));
            if(isVertexInvalid(xIndex, yIndex, zIndex, uIndex, vIndex, coordinateCount))
            {
                error = true;
                return;
            }
            vertices[vertexId++] = coordinates[xIndex];
            vertices[vertexId++] = coordinates[yIndex];
            vertices[vertexId++] = coordinates[zIndex];
            vertices[vertexId++] = coordinates[uIndex];
            vertices[vertexId++] = coordinates[vIndex];
        }
        bitInput.setPosition(bitInput.getPosition() + 7 & -8);
        bitInput.readBits(32);
        bitInput.readBits(8);
        int mode = bitInput.readBits(8);
        int triangleIndexCount = bitInput.readBits(32);
        if(triangleIndexCount > 0x1f400)
        {
            error = true;
            return;
        }
        int vertexCountSizeBits = (int)Math.ceil(Math.log(2D * (double)vertexCount) / log2);
        int index = 0;
        counter = 0;
        float triangleVertices[] = new float[triangleIndexCount * 3];
        float textureCoords[] = new float[triangleIndexCount * 2];
        for(; counter < triangleIndexCount; counter++)
        {
            index += decodeZigZag(bitInput.readBits(vertexCountSizeBits));
            if(index >= vertexCount)
            {
                error = true;
                return;
            }
            triangleVertices[counter * 3] = vertices[index * 5];
            triangleVertices[counter * 3 + 1] = vertices[index * 5 + 1];
            triangleVertices[counter * 3 + 2] = vertices[index * 5 + 2];
            textureCoords[counter * 2] = vertices[index * 5 + 3];
            textureCoords[counter * 2 + 1] = vertices[index * 5 + 4];
        }

        int glDrawMode = 4;
        switch(mode)
        {
        case 1: // '\001'
            glDrawMode = 5;
            break;

        case 2: // '\002'
            glDrawMode = 6;
            break;
        }
        ProjectionScene.Mesh mesh = new ProjectionScene.Mesh();
        ProjectionScene.SubMesh subMesh = new ProjectionScene.SubMesh(triangleVertices, textureCoords, glDrawMode);
        mesh.addSubMesh(subMesh);
        if(meshCount == 0)
            scene.setLeftMesh(mesh);
        else
        if(meshCount == 1)
            scene.setRightMesh(mesh);
    }

    private static int decodeZigZag(int n)
    {
        return n >> 1 ^ -(n & 1);
    }

    private static boolean isVertexInvalid(int x, int y, int z, int u, int v, int limit)
    {
        return Math.max(Math.max(x, y), Math.max(z, u)) >= limit || v >= limit;
    }

    static byte[] inflate(byte input[], int offset, int len, int outputLen[])
    {
        Inflater decompresser = new Inflater(true);
        decompresser.setInput(input, offset, len);
        int outputSize = 0x186a0;
        byte output[] = new byte[outputSize];
        int decodedLength = 0;
        boolean needBiggerBuffer = false;
        try
        {
            do
            {
                decodedLength += decompresser.inflate(output, decodedLength, outputSize - decodedLength);
                needBiggerBuffer = !decompresser.needsInput();
                if(needBiggerBuffer)
                {
                    output = resizeBuffer(output);
                    outputSize = output.length;
                }
            } while(needBiggerBuffer);
        }
        catch(DataFormatException e)
        {
            return null;
        }
        outputLen[0] = decodedLength;
        return output;
    }

    private static byte[] resizeBuffer(byte input[])
    {
        byte output[] = new byte[input.length * 2];
        System.arraycopy(input, 0, output, 0, input.length);
        return output;
    }

    private static final int TYPE_YTMP = Util.getIntegerCodeForString("ytmp");
    private static final int TYPE_MSHP = Util.getIntegerCodeForString("mshp");
    private static final int TYPE_RAW = Util.getIntegerCodeForString("raw ");
    private static final int TYPE_DFL8 = Util.getIntegerCodeForString("dfl8");
    private static final int TYPE_MESH = Util.getIntegerCodeForString("mesh");
    private static final int TYPE_PROJ = Util.getIntegerCodeForString("proj");
    private static final int MAX_MESH_COUNT = 2;
    private static final int MAX_COORDINATE_COUNT = 10000;
    private static final int MAX_VERTEX_COUNT = 32000;
    private static final int MAX_TRIANGLE_INDICES = 0x1f400;
    private static final int INITIAL_DECOMPRESS_SIZE = 0x186a0;
    private List sceneList;
    private boolean error;
    private ProjectionScene scene;
    private int meshCount;
    private boolean ytmpParsed;

}
