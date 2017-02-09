// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SphericalMetadataParser.java

package com.google.vr.sdk.widgets.video;

import android.util.Log;
import com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass;
import java.io.IOException;
import java.io.StringBufferInputStream;
import org.xmlpull.v1.*;

public class SphericalMetadataParser
{

    public SphericalMetadataParser()
    {
    }

    public static com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass.SphericalMetadata parse(String xmlContents)
    {
        if(xmlContents == null)
            return new com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass.SphericalMetadata();
        XmlPullParser parser;
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);
        parser = factory.newPullParser();
        parser.setInput(new StringBufferInputStream(xmlContents), null);
        parser.nextTag();
        return readFeed(parser);
        Exception e;
        e;
        Log.e(TAG, e.getMessage());
        return new com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass.SphericalMetadata();
    }

    private static com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass.SphericalMetadata readFeed(XmlPullParser parser)
        throws XmlPullParserException, IOException
    {
        com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass.SphericalMetadata metadata = new com.google.vr.sdk.widgets.video.nano.SphericalMetadataOuterClass.SphericalMetadata();
_L3:
        if(parser.next() == 1) goto _L2; else goto _L1
_L1:
        if(parser.getEventType() == 2) goto _L4; else goto _L3
_L4:
        String text;
        int depth = 1;
        text = "";
        do
        {
            if(depth <= 0)
                continue; /* Loop/switch isn't completed */
            switch(parser.next())
            {
            case 2: // '\002'
                depth++;
                break;

            case 3: // '\003'
                depth--;
                break;

            case 4: // '\004'
                text = parser.getText();
                break;
            }
        } while(true);
        if(text != null) goto _L5; else goto _L3
_L5:
        String name;
        byte byte0;
        name = parser.getName();
        String s = name;
        byte0 = -1;
        switch(s.hashCode())
        {
        case 415550222: 
            if(s.equals("InitialViewHeadingDegrees"))
                byte0 = 0;
            break;

        case 80888400: 
            if(s.equals("InitialViewPitchDegrees"))
                byte0 = 1;
            break;

        case -1887876031: 
            if(s.equals("InitialViewRollDegrees"))
                byte0 = 2;
            break;

        case -1614191141: 
            if(s.equals("StereoMode"))
                byte0 = 3;
            break;

        case -1257448899: 
            if(s.equals("Spherical"))
                byte0 = 4;
            break;

        case 1611823408: 
            if(s.equals("Stitched"))
                byte0 = 5;
            break;

        case -253590984: 
            if(s.equals("StitchingSoftware"))
                byte0 = 6;
            break;

        case 132635209: 
            if(s.equals("ProjectionType"))
                byte0 = 7;
            break;
        }
        byte0;
        JVM INSTR tableswitch 0 7: default 552
    //                   0 372
    //                   1 383
    //                   2 394
    //                   3 405
    //                   4 549
    //                   5 549
    //                   6 549
    //                   7 549;
           goto _L6 _L7 _L8 _L9 _L10 _L11 _L11 _L11 _L11
_L11:
        continue; /* Loop/switch isn't completed */
_L7:
        metadata.initialViewHeadingDegrees = Integer.parseInt(text);
        continue; /* Loop/switch isn't completed */
_L8:
        metadata.initialViewPitchDegrees = Integer.parseInt(text);
        continue; /* Loop/switch isn't completed */
_L9:
        metadata.initialViewRollDegrees = Integer.parseInt(text);
        continue; /* Loop/switch isn't completed */
_L10:
        String s1 = text;
        byte byte1 = -1;
        switch(s1.hashCode())
        {
        case 1736247715: 
            if(s1.equals("top-bottom"))
                byte1 = 0;
            break;

        case 1028134102: 
            if(s1.equals("left-right"))
                byte1 = 1;
            break;

        case 3357411: 
            if(s1.equals("mono"))
                byte1 = 2;
            break;
        }
        switch(byte1)
        {
        case 0: // '\0'
            metadata.frameLayoutMode = 2;
            break;

        case 1: // '\001'
            Log.e(TAG, "left-right videos are unsupported");
            // fall through

        case 2: // '\002'
        default:
            metadata.frameLayoutMode = 1;
            break;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        TAG;
        "Unknown name: ";
        String s2 = String.valueOf(name);
        s2;
        if(s2.length() == 0) goto _L13; else goto _L12
_L12:
        concat();
          goto _L14
_L13:
        JVM INSTR pop ;
        JVM INSTR new #124 <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
_L14:
        Log.w();
        JVM INSTR pop ;
        continue; /* Loop/switch isn't completed */
_L2:
        return metadata;
        if(true) goto _L3; else goto _L15
_L15:
    }

    private static final String TAG = com/google/vr/sdk/widgets/video/SphericalMetadataParser.getSimpleName();
    private static final boolean DEBUG = false;
    private static final String INITIAL_HEADING = "InitialViewHeadingDegrees";
    private static final String INITIAL_PITCH = "InitialViewPitchDegrees";
    private static final String INITIAL_ROLL = "InitialViewRollDegrees";
    private static final String SPHERICAL = "Spherical";
    private static final String STITCHED = "Stitched";
    private static final String STITCHING_SOFTWARE = "StitchingSoftware";
    private static final String PROJECTION_TYPE = "ProjectionType";
    private static final String STEREO_MODE = "StereoMode";
    private static final String STEREO_MODE_MONO = "mono";
    private static final String STEREO_MODE_LEFT_RIGHT = "left-right";
    private static final String STEREO_MODE_TOP_BOTTOM = "top-bottom";

}
