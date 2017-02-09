// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Version.java

package com.google.vr.ndk.base;

import android.util.Log;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.google.vr.ndk.base:
//            BuildConstants

public final class Version
{

    public Version(int i, int j, int k)
    {
        majorVersion = i;
        minorVersion = j;
        patchVersion = k;
    }

    public static Version parse(String s)
    {
        Matcher matcher;
        if(s == null || s.isEmpty())
            return null;
        if((matcher = Pattern.compile("(\\d+)\\.(\\d+)\\.(\\d+)").matcher(s)).matches())
            break MISSING_BLOCK_LABEL_67;
        TAG;
        "Failed to parse version from: ";
        String s1 = String.valueOf(s);
        s1;
        if(s1.length() == 0) goto _L2; else goto _L1
_L1:
        concat();
          goto _L3
_L2:
        JVM INSTR pop ;
        JVM INSTR new #12  <Class String>;
        JVM INSTR dup_x1 ;
        JVM INSTR swap ;
        String();
_L3:
        Log.w();
        JVM INSTR pop ;
        return null;
        return new Version(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)));
    }

    public final boolean isAtLeast(Version version)
    {
        if(majorVersion > version.majorVersion)
            return true;
        if(majorVersion < version.majorVersion)
            return false;
        if(minorVersion > version.minorVersion)
            return true;
        if(minorVersion < version.minorVersion)
            return false;
        if(patchVersion > version.patchVersion)
            return true;
        return patchVersion >= version.patchVersion;
    }

    public final boolean equals(Object obj)
    {
        if(!(obj instanceof Version))
            return false;
        Version version = (Version)obj;
        return majorVersion == version.majorVersion && minorVersion == version.minorVersion && patchVersion == version.patchVersion;
    }

    public final int hashCode()
    {
        return Objects.hash(new Object[] {
            Integer.valueOf(majorVersion), Integer.valueOf(minorVersion), Integer.valueOf(patchVersion)
        });
    }

    public final String toString()
    {
        return String.format("%d.%d.%d", new Object[] {
            Integer.valueOf(majorVersion), Integer.valueOf(minorVersion), Integer.valueOf(patchVersion)
        });
    }

    public static final String TAG = com/google/vr/ndk/base/BuildConstants.getSimpleName();
    public static final Version CURRENT = parse("1.20.0");
    public final int majorVersion;
    public final int minorVersion;
    public final int patchVersion;

}
