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
        if(frameTime != null && frameTime.length > 0)
        {
            cachedsize.frameTime = new frameTime[frameTime.length];
            for(int i = 0; i < frameTime.length; i++)
                if(frameTime[i] != null)
                    cachedsize.frameTime[i] = frameTime[i].lone();

        }
        if(timeSeriesData != null)
            cachedsize.timeSeriesData = timeSeriesData.one();
        if(appRenderTime != null && appRenderTime.length > 0)
        {
            cachedsize.appRenderTime = new appRenderTime[appRenderTime.length];
            for(int j = 0; j < appRenderTime.length; j++)
                if(appRenderTime[j] != null)
                    cachedsize.appRenderTime[j] = appRenderTime[j].lone();

        }
        if(presentTime != null && presentTime.length > 0)
        {
            cachedsize.presentTime = new presentTime[presentTime.length];
            for(int k = 0; k < presentTime.length; k++)
                if(presentTime[k] != null)
                    cachedsize.presentTime[k] = presentTime[k].lone();

        }
        if(totalRenderTime != null && totalRenderTime.length > 0)
        {
            cachedsize.totalRenderTime = new totalRenderTime[totalRenderTime.length];
            for(int l = 0; l < totalRenderTime.length; l++)
                if(totalRenderTime[l] != null)
                    cachedsize.totalRenderTime[l] = totalRenderTime[l].lone();

        }
        if(postFrameTime != null && postFrameTime.length > 0)
        {
            cachedsize.postFrameTime = new postFrameTime[postFrameTime.length];
            for(int i1 = 0; i1 < postFrameTime.length; i1++)
                if(postFrameTime[i1] != null)
                    cachedsize.postFrameTime[i1] = postFrameTime[i1].lone();

        }
        if(consecutiveDroppedFrames != null && consecutiveDroppedFrames.length > 0)
        {
            cachedsize.consecutiveDroppedFrames = new consecutiveDroppedFrames[consecutiveDroppedFrames.length];
            for(int j1 = 0; j1 < consecutiveDroppedFrames.length; j1++)
                if(consecutiveDroppedFrames[j1] != null)
                    cachedsize.consecutiveDroppedFrames[j1] = consecutiveDroppedFrames[j1].lone();

        }
        if(scanlineRacingVsyncOvershootUs != null && scanlineRacingVsyncOvershootUs.length > 0)
        {
            cachedsize.scanlineRacingVsyncOvershootUs = new scanlineRacingVsyncOvershootUs[scanlineRacingVsyncOvershootUs.length];
            for(int k1 = 0; k1 < scanlineRacingVsyncOvershootUs.length; k1++)
                if(scanlineRacingVsyncOvershootUs[k1] != null)
                    cachedsize