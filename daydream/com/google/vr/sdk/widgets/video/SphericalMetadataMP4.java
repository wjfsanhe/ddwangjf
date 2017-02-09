// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SphericalMetadataMP4.java

package com.google.vr.sdk.widgets.video;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public final class SphericalMetadataMP4
{

    public SphericalMetadataMP4()
    {
    }

    public static String extract(InputStream stream)
    {
        if(stream == null)
        {
            Log.e("SphericalMetadataMP4", "Failed to extract metadata string from mp4: no stream!");
            return null;
        }
        return extract(stream, 0, 0x7fffffffL);
        Exception e;
        e;
        Log.e("SphericalMetadataMP4", "Failed to extract metadata string from mp4.", e);
        return null;
    }

    private static String extract(InputStream stream, int depth, long size)
        throws IOException
    {
        int pos;
        if(depth > METADATA_PATH.length)
            throw new IllegalArgumentException("Search depth exceeds expectations.");
        pos = 0;
_L5:
        long bytesToEnd;
        String xmlString;
        if((long)pos >= size && depth != 0)
            break; /* Loop/switch isn't completed */
        byte sizeBytes[] = readBytes(stream, 4);
        pos += 4;
        if(sizeBytes == null)
        {
            if(depth != 0)
            {
                int i = pos;
                throw new IOException((new StringBuilder(69)).append("Unexpected end of stream.").append(i).append(" ").append(size).append(" ").append(depth).toString());
            }
            break; /* Loop/switch isn't completed */
        }
        long atomSize = bytesToInt(sizeBytes, 4);
        if(atomSize < 8L && atomSize != 1L)
        {
            long l = atomSize;
            throw new IOException((new StringBuilder(39)).append("Invalid atom size: ").append(l).toString());
        }
        byte nameBytes[] = readBytes(stream, 4);
        pos += 4;
        if(nameBytes == null)
            throw new IOException("Unexpected end of stream.");
        String atomName = bytesToString(nameBytes, "UTF-8");
        if(atomName == null || atomName.length() != 4)
            throw new IOException("Invalid atom name.");
        bytesToEnd = atomSize - 8L;
        if(atomSize == 1L)
        {
            sizeBytes = readBytes(stream, 8);
            pos += 8;
            if(sizeBytes == null)
                throw new IOException("Unexpected end of stream.");
            atomSize = bytesToInt(sizeBytes, 8);
            bytesToEnd = atomSize - 16L;
            if(atomSize < 8L)
            {
                long l1 = atomSize;
                throw new IOException((new StringBuilder(39)).append("Invalid atom size: ").append(l1).toString());
            }
        }
        if(depth != METADATA_PATH.length && METADATA_PATH[depth].equals(atomName))
        {
            String result = extract(stream, depth + 1, atomSize - 8L);
            if(result != null)
                return result;
            pos = (int)((long)pos + bytesToEnd);
            bytesToEnd = 0L;
            break MISSING_BLOCK_LABEL_530;
        }
        if(depth != METADATA_PATH.length || !"uuid".equals(atomName))
            break MISSING_BLOCK_LABEL_530;
        byte uuid[] = readBytes(stream, SPHERICAL_UUID.length);
        pos += SPHERICAL_UUID.length;
        bytesToEnd -= SPHERICAL_UUID.length;
        if(uuid == null)
            throw new IOException("Failed to parse UUID.");
        if(!Arrays.equals(uuid, SPHERICAL_UUID))
            break MISSING_BLOCK_LABEL_530;
        byte xmlBytes[] = readBytes(stream, (int)bytesToEnd);
        xmlString = bytesToString(xmlBytes, "UTF-8");
        if(xmlString == null)
            throw new IOException("Error retrieving metadata xml.");
        "SphericalMetadataMP4";
        "Located spherical metadata:\n";
        String s = String.valueOf(xmlString);
        s;
        if(s.length() == 0) goto _L2; else goto _L1
_L1:
        concat();
          goto _L3
_L2:
        JVM INSTR pop ;
        JVM INSTR new #109 <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
_L3:
        Log.i();
        JVM INSTR pop ;
        return xmlString;
        while(bytesToEnd > 0L) 
        {
            long bytesSkipped = stream.skip(bytesToEnd);
            if(bytesSkipped > 0L)
            {
                bytesToEnd -= bytesSkipped;
                pos = (int)((long)pos + bytesSkipped);
            }
        }
        if(true) goto _L5; else goto _L4
_L4:
        return null;
    }

    private static byte[] readBytes(InputStream stream, int numBytes)
        throws IOException
    {
        int bytesRead = 0;
        byte out[] = new byte[numBytes];
        int read;
        for(; bytesRead < numBytes; bytesRead += read)
        {
            read = stream.read(out, bytesRead, numBytes - bytesRead);
            if(read == -1)
                return null;
        }

        return out;
    }

    private static long bytesToInt(byte bytes[], int intBytes)
    {
        if(bytes == null || bytes.length != intBytes || intBytes > 8)
            throw new IllegalArgumentException("Invalid byte array.");
        int result = 0;
        for(int i = 0; i < intBytes; i++)
            result |= (bytes[i] & 0xff) << 8 * (intBytes - 1 - i);

        return (long)result;
    }

    private static String bytesToString(byte bytes[], String charset)
    {
        if(bytes == null)
            throw new IllegalArgumentException("Null byte array.");
        return new String(bytes, charset);
        IOException e;
        e;
        throw new IllegalArgumentException("Invalid charset.");
    }

    private static final String TAG = "SphericalMetadataMP4";
    private static final String METADATA_PATH[] = {
        "moov", "trak"
    };
    private static final String METADATA_ATOM = "uuid";
    private static final byte SPHERICAL_UUID[] = {
        -1, -52, -126, 99, -8, 85, 74, -109, -120, 20, 
        88, 122, 2, 82, 31, -35
    };
    private static final String METADATA_ATOM_CHARSET = "UTF-8";
    private static final long MIN_ATOM_SIZE = 8L;
    private static final long ATOM_SIZE_64_BITS = 1L;

}
