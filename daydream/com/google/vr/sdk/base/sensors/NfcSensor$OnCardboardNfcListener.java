// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   NfcSensor.java

package com.google.vr.sdk.base.sensors;

import com.google.vr.sdk.base.GvrViewerParams;

// Referenced classes of package com.google.vr.sdk.base.sensors:
//            NfcSensor

public static interface 
{

    public abstract void onInsertedIntoGvrViewer(GvrViewerParams gvrviewerparams);

    public abstract void onRemovedFromGvrViewer();
}
