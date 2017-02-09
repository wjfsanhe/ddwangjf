// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CardboardViewNativeImpl.java

package com.google.vr.sdk.base;

import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.google.vr.sdk.base:
//            CardboardViewNativeImpl, HeadTransform, Eye

class val.finished
    implements Runnable
{

    public void run()
    {
        CardboardViewNativeImpl.access$2900(_fld0, CardboardViewNativeImpl.access$100(_fld0), val$head, val$leftEye, val$rightEye, val$monocular, val$leftEyeNoDistortionCorrection, val$rightEyeNoDistortionCorrection);
        val$finished.countDown();
    }

    final HeadTransform val$head;
    final Eye val$leftEye;
    final Eye val$rightEye;
    final Eye val$monocular;
    final Eye val$leftEyeNoDistortionCorrection;
    final Eye val$rightEyeNoDistortionCorrection;
    final CountDownLatch val$finished;
    final val.finished this$1;

    ()
    {
        this.this$1 = this$1;
        val$head = headtransform;
        val$leftEye = eye;
        val$rightEye = eye1;
        val$monocular = eye2;
        val$leftEyeNoDistortionCorrection = eye3;
        val$rightEyeNoDistortionCorrection = eye4;
        val$finished = CountDownLatch.this;
        super();
    }
}
