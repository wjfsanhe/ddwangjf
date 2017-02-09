// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SphericalV2MetadataParser.java

package com.google.vr.sdk.widgets.video;

import com.google.vr.libraries.video.ProjectionMeshDecoderV2;
import com.google.vr.libraries.video.ProjectionScene;
import com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass;

public class SphericalV2MetadataParser
{

    public SphericalV2MetadataParser()
    {
    }

    public static com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass.SphericalMetadata parse(int stereoMode, byte projectionData[])
    {
        ProjectionMeshDecoderV2 decoder = new ProjectionMeshDecoderV2();
        ProjectionScene scene = decoder.decode(projectionData);
        com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass.SphericalMetadata metadata = new com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass.SphericalMetadata();
        switch(stereoMode)
        {
        case 0: // '\0'
            metadata.frameLayoutMode = 1;
            break;

        case 1: // '\001'
            metadata.frameLayoutMode = 2;
            break;

        case 2: // '\002'
            metadata.frameLayoutMode = 3;
            break;

        default:
            throw new IllegalArgumentException((new StringBuilder(33)).append("Unexpected stereoMode ").append(stereoMode).toString());
        }
        metadata.mesh = new com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass.StereoMeshConfig();
        metadata.mesh.leftEyeMesh = createMesh(scene.getLeftMesh());
        metadata.mesh.rightEyeMesh = createMesh(scene.getRightMesh());
        return metadata;
    }

    private static com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass.StereoMeshConfig.Mesh createMesh(com.google.vr.libraries.video.ProjectionScene.Mesh sceneMesh)
    {
        if(sceneMesh == null)
            return null;
        if(sceneMesh.getSubMeshCount() != 1)
            throw new IllegalArgumentException("There should be only a single submesh");
        com.google.vr.libraries.video.ProjectionScene.SubMesh subMesh = sceneMesh.getSubMesh(0);
        com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass.StereoMeshConfig.Mesh mesh = new com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass.StereoMeshConfig.Mesh();
        switch(subMesh.getMode())
        {
        case 5: // '\005'
            mesh.geometryType = 1;
            break;

        case 4: // '\004'
            mesh.geometryType = 0;
            break;

        default:
            int j = subMesh.getMode();
            throw new IllegalArgumentException((new StringBuilder(32)).append("Unexpected mesh mode ").append(j).toString());
        }
        float vertexArray[] = subMesh.getVertices();
        float coordArray[] = subMesh.getTextureCoords();
        int numVertices = vertexArray.length / 3;
        mesh.vertices = new com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass.StereoMeshConfig.Mesh.Vertex[numVertices];
        for(int i = 0; i < numVertices; i++)
        {
            com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass.StereoMeshConfig.Mesh.Vertex vertex = new com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass.StereoMeshConfig.Mesh.Vertex();
            mesh.vertices[i] = vertex;
            vertex.x = vertexArray[3 * i];
            vertex.y = vertexArray[3 * i + 1];
            vertex.z = vertexArray[3 * i + 2];
            vertex.u = coordArray[2 * i];
            vertex.v = coordArray[2 * i + 1];
        }

        return mesh;
    }

    private static final String TAG = com/google/vr/sdk/widgets/video/SphericalV2MetadataParser.getSimpleName();

}
