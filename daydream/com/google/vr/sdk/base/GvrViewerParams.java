// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GvrViewerParams.java

package com.google.vr.sdk.base;

import android.net.Uri;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.util.Base64;
import android.util.Log;
import com.google.protobuf.nano.MessageNano;
import com.google.vr.cardboard.ConfigUtils;
import com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice;

// Referenced classes of package com.google.vr.sdk.base:
//            FieldOfView, Distortion, ScreenParams

public class GvrViewerParams
{
    public static final class VerticalAlignmentType extends Enum
    {

        public static VerticalAlignmentType[] values()
        {
            return (VerticalAlignmentType[])$VALUES.clone();
        }

        public static VerticalAlignmentType valueOf(String name)
        {
            return (VerticalAlignmentType)Enum.valueOf(com/google/vr/sdk/base/GvrViewerParams$VerticalAlignmentType, name);
        }

        int toProtoValue()
        {
            return protoValue;
        }

        static VerticalAlignmentType fromProtoValue(int protoValue)
        {
            VerticalAlignmentType averticalalignmenttype[] = values();
            int i = averticalalignmenttype.length;
            for(int j = 0; j < i; j++)
            {
                VerticalAlignmentType type = averticalalignmenttype[j];
                if(type.protoValue == protoValue)
                    return type;
            }

            Log.e("GvrViewerParams", String.format("Unknown alignment type from proto: %d", new Object[] {
                Integer.valueOf(protoValue)
            }));
            return BOTTOM;
        }

        public static final VerticalAlignmentType BOTTOM;
        public static final VerticalAlignmentType CENTER;
        public static final VerticalAlignmentType TOP;
        private final int protoValue;
        private static final VerticalAlignmentType $VALUES[];

        static 
        {
            BOTTOM = new VerticalAlignmentType("BOTTOM", 0, 0);
            CENTER = new VerticalAlignmentType("CENTER", 1, 1);
            TOP = new VerticalAlignmentType("TOP", 2, 2);
            $VALUES = (new VerticalAlignmentType[] {
                BOTTOM, CENTER, TOP
            });
        }

        private VerticalAlignmentType(String s, int i, int protoValue)
        {
            super(s, i);
            this.protoValue = protoValue;
        }
    }


    public GvrViewerParams()
    {
        setDefaultValues();
    }

    public GvrViewerParams(GvrViewerParams params)
    {
        copyFrom(params);
    }

    public GvrViewerParams(com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams params)
    {
        setDefaultValues();
        if(params == null)
            return;
        originalDeviceProto = params.clone();
        vendor = params.getVendor();
        model = params.getModel();
        interLensDistance = params.getInterLensDistance();
        verticalAlignment = VerticalAlignmentType.fromProtoValue(params.getVerticalAlignment());
        verticalDistanceToLensCenter = params.getTrayToLensDistance();
        screenToLensDistance = params.getScreenToLensDistance();
        leftEyeMaxFov = FieldOfView.parseFromProtobuf(params.leftEyeFieldOfViewAngles);
        if(leftEyeMaxFov == null)
            leftEyeMaxFov = new FieldOfView();
        distortion = Distortion.parseFromProtobuf(params.distortionCoefficients);
        if(distortion == null)
            distortion = new Distortion();
        hasMagnet = params.getHasMagnet();
    }

    public static boolean isOriginalCardboardDeviceUri(Uri uri)
    {
        return URI_ORIGINAL_CARDBOARD_QR_CODE.equals(uri) || URI_ORIGINAL_CARDBOARD_NFC.getScheme().equals(uri.getScheme()) && URI_ORIGINAL_CARDBOARD_NFC.getAuthority().equals(uri.getAuthority());
    }

    private static boolean isCardboardDeviceUri(Uri uri)
    {
        return "http".equals(uri.getScheme()) && "google.com".equals(uri.getAuthority()) && "/cardboard/cfg".equals(uri.getPath());
    }

    public static boolean isGvrUri(Uri uri)
    {
        return isOriginalCardboardDeviceUri(uri) || isCardboardDeviceUri(uri);
    }

    public static GvrViewerParams createFromUri(Uri uri)
    {
        if(uri == null)
            return null;
        if(isOriginalCardboardDeviceUri(uri))
            return cardboardV1ViewerParams();
        if(!isCardboardDeviceUri(uri))
        {
            Log.w("GvrViewerParams", String.format("URI \"%s\" not recognized as GVR viewer.", new Object[] {
                uri
            }));
            return null;
        } else
        {
            return new GvrViewerParams(ConfigUtils.readDeviceParamsFromUri(uri));
        }
    }

    public static GvrViewerParams cardboardV1ViewerParams()
    {
        GvrViewerParams deviceParams = new GvrViewerParams();
        deviceParams.vendor = "Google, Inc.";
        deviceParams.model = "Cardboard v1";
        deviceParams.interLensDistance = 0.06F;
        deviceParams.verticalAlignment = CARDBOARD_V1_VERTICAL_ALIGNMENT;
        deviceParams.verticalDistanceToLensCenter = 0.035F;
        deviceParams.screenToLensDistance = 0.042F;
        deviceParams.leftEyeMaxFov = FieldOfView.cardboardV1FieldOfView();
        deviceParams.hasMagnet = true;
        deviceParams.distortion = Distortion.cardboardV1Distortion();
        return deviceParams;
    }

    public static GvrViewerParams createFromNfcContents(NdefMessage tagContents)
    {
        if(tagContents == null)
        {
            Log.w("GvrViewerParams", "Could not get contents from NFC tag.");
            return null;
        }
        NdefRecord andefrecord[] = tagContents.getRecords();
        int i = andefrecord.length;
        for(int j = 0; j < i; j++)
        {
            NdefRecord record = andefrecord[j];
            GvrViewerParams params = createFromUri(record.toUri());
            if(params != null)
                return params;
        }

        return null;
    }

    byte[] toByteArray()
    {
        return MessageNano.toByteArray(toProtobuf());
    }

    public com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams toProtobuf()
    {
        com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams params = originalDeviceProto == null ? new com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams() : originalDeviceProto.clone();
        params.setVendor(vendor);
        params.setModel(model);
        params.setInterLensDistance(interLensDistance);
        params.setVerticalAlignment(verticalAlignment.toProtoValue());
        if(verticalAlignment == VerticalAlignmentType.CENTER)
            params.setTrayToLensDistance(0.035F);
        else
            params.setTrayToLensDistance(verticalDistanceToLensCenter);
        params.setScreenToLensDistance(screenToLensDistance);
        params.leftEyeFieldOfViewAngles = leftEyeMaxFov.toProtobuf();
        params.distortionCoefficients = distortion.toProtobuf();
        if(hasMagnet)
            params.setHasMagnet(hasMagnet);
        return params;
    }

    public Uri toUri()
    {
        byte paramsData[] = toByteArray();
        int paramsSize = paramsData.length;
        return (new android.net.Uri.Builder()).scheme("http").authority("google.com").appendEncodedPath("cardboard/cfg").appendQueryParameter("p", Base64.encodeToString(paramsData, 0, paramsSize, 11)).build();
    }

    public void setVendor(String vendor)
    {
        this.vendor = vendor == null ? "" : vendor;
    }

    public String getVendor()
    {
        return vendor;
    }

    public void setModel(String model)
    {
        this.model = model == null ? "" : model;
    }

    public String getModel()
    {
        return model;
    }

    public void setInterLensDistance(float interLensDistance)
    {
        this.interLensDistance = interLensDistance;
    }

    public float getInterLensDistance()
    {
        return interLensDistance;
    }

    public VerticalAlignmentType getVerticalAlignment()
    {
        return verticalAlignment;
    }

    public void setVerticalAlignment(VerticalAlignmentType verticalAlignment)
    {
        this.verticalAlignment = verticalAlignment;
    }

    public void setVerticalDistanceToLensCenter(float verticalDistanceToLensCenter)
    {
        this.verticalDistanceToLensCenter = verticalDistanceToLensCenter;
    }

    public float getVerticalDistanceToLensCenter()
    {
        return verticalDistanceToLensCenter;
    }

    float getYEyeOffsetMeters(ScreenParams screen)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$google$vr$sdk$base$GvrViewerParams$VerticalAlignmentType[];

            static 
            {
                $SwitchMap$com$google$vr$sdk$base$GvrViewerParams$VerticalAlignmentType = new int[VerticalAlignmentType.values().length];
                try
                {
                    $SwitchMap$com$google$vr$sdk$base$GvrViewerParams$VerticalAlignmentType[VerticalAlignmentType.CENTER.ordinal()] = 1;
                }
                catch(NoSuchFieldError nosuchfielderror) { }
                try
                {
                    $SwitchMap$com$google$vr$sdk$base$GvrViewerParams$VerticalAlignmentType[VerticalAlignmentType.BOTTOM.ordinal()] = 2;
                }
                catch(NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$google$vr$sdk$base$GvrViewerParams$VerticalAlignmentType[VerticalAlignmentType.TOP.ordinal()] = 3;
                }
                catch(NoSuchFieldError nosuchfielderror2) { }
            }
        }

        switch(_cls1..SwitchMap.com.google.vr.sdk.base.GvrViewerParams.VerticalAlignmentType[getVerticalAlignment().ordinal()])
        {
        case 1: // '\001'
        default:
            return screen.getHeightMeters() / 2.0F;

        case 2: // '\002'
            return getVerticalDistanceToLensCenter() - screen.getBorderSizeMeters();

        case 3: // '\003'
            return screen.getHeightMeters() - (getVerticalDistanceToLensCenter() - screen.getBorderSizeMeters());
        }
    }

    public void setScreenToLensDistance(float screenToLensDistance)
    {
        this.screenToLensDistance = screenToLensDistance;
    }

    public float getScreenToLensDistance()
    {
        return screenToLensDistance;
    }

    public Distortion getDistortion()
    {
        return distortion;
    }

    public FieldOfView getLeftEyeMaxFov()
    {
        return leftEyeMaxFov;
    }

    public boolean getHasMagnet()
    {
        return hasMagnet;
    }

    public void setHasMagnet(boolean magnet)
    {
        hasMagnet = magnet;
    }

    public boolean equals(Object other)
    {
        if(other == null)
            return false;
        if(other == this)
            return true;
        if(!(other instanceof GvrViewerParams))
            return false;
        GvrViewerParams o = (GvrViewerParams)other;
        boolean fieldsHandledByThisClassAreEqual = vendor.equals(o.vendor) && model.equals(o.model) && interLensDistance == o.interLensDistance && verticalAlignment == o.verticalAlignment && (verticalAlignment == VerticalAlignmentType.CENTER || verticalDistanceToLensCenter == o.verticalDistanceToLensCenter) && screenToLensDistance == o.screenToLensDistance && leftEyeMaxFov.equals(o.leftEyeMaxFov) && distortion.equals(o.distortion) && hasMagnet == o.hasMagnet;
        if(!fieldsHandledByThisClassAreEqual)
            return false;
        else
            return MessageNano.messageNanoEquals(originalDeviceProto, o.originalDeviceProto);
    }

    public String toString()
    {
        String s;
        float f;
        return (new StringBuilder()).append("{\n").append((new StringBuilder(12 + String.valueOf(s = vendor).length())).append("  vendor: ").append(s).append(",\n").toString()).append((new StringBuilder(11 + String.valueOf(s = model).length())).append("  model: ").append(s).append(",\n").toString()).append((new StringBuilder(40)).append("  inter_lens_distance: ").append(f = interLensDistance).append(",\n").toString()).append((new StringBuilder(24 + String.valueOf(f = String.valueOf(verticalAlignment)).length())).append("  vertical_alignment: ").append(f).append(",\n").toString()).append((new StringBuilder(53)).append("  vertical_distance_to_lens_center: ").append(f = verticalDistanceToLensCenter).append(",\n").toString()).append((new StringBuilder(44)).append("  screen_to_lens_distance: ").append(f = screenToLensDistance).append(",\n").toString()).append((new StringBuilder(22 + String.valueOf(f = String.valueOf(leftEyeMaxFov.toString().replace("\n", "\n  "))).length())).append("  left_eye_max_fov: ").append(f).append(",\n").toString()).append((new StringBuilder(16 + String.valueOf(f = String.valueOf(distortion.toString().replace("\n", "\n  "))).length())).append("  distortion: ").append(f).append(",\n").toString()).append((new StringBuilder(17)).append("  magnet: ").append(f = hasMagnet).append(",\n").toString()).append("}\n").toString();
    }

    public boolean isDefault()
    {
        return DEFAULT_PARAMS.equals(this);
    }

    private void setDefaultValues()
    {
        vendor = "Google, Inc.";
        model = "Default Cardboard";
        interLensDistance = 0.064F;
        verticalAlignment = CARDBOARD_V2_2_VERTICAL_ALIGNMENT;
        verticalDistanceToLensCenter = 0.035F;
        screenToLensDistance = 0.039F;
        leftEyeMaxFov = new FieldOfView();
        hasMagnet = false;
        distortion = new Distortion();
    }

    private void copyFrom(GvrViewerParams params)
    {
        vendor = params.vendor;
        model = params.model;
        interLensDistance = params.interLensDistance;
        verticalAlignment = params.verticalAlignment;
        verticalDistanceToLensCenter = params.verticalDistanceToLensCenter;
        screenToLensDistance = params.screenToLensDistance;
        leftEyeMaxFov = new FieldOfView(params.leftEyeMaxFov);
        hasMagnet = params.hasMagnet;
        distortion = new Distortion(params.distortion);
        originalDeviceProto = params.originalDeviceProto;
    }

    private static final String TAG = "GvrViewerParams";
    private static final String HTTP_SCHEME = "http";
    private static final String URI_HOST_GOOGLE_SHORT = "g.co";
    private static final String URI_HOST_GOOGLE = "google.com";
    private static final String URI_PATH_CARDBOARD_HOME = "cardboard";
    private static final String URI_PATH_CARDBOARD_CONFIG = "cardboard/cfg";
    private static final String URI_SCHEME_LEGACY_CARDBOARD = "cardboard";
    private static final String URI_HOST_LEGACY_CARDBOARD = "v1.0.0";
    private static final Uri URI_ORIGINAL_CARDBOARD_NFC = (new android.net.Uri.Builder()).scheme("cardboard").authority("v1.0.0").build();
    private static final Uri URI_ORIGINAL_CARDBOARD_QR_CODE = (new android.net.Uri.Builder()).scheme("http").authority("g.co").appendEncodedPath("cardboard").build();
    private static final String CARDBOARD_V2_2_VENDOR = "Google, Inc.";
    private static final String CARDBOARD_V2_2_MODEL = "Default Cardboard";
    private static final float CARDBOARD_V2_2_INTER_LENS_DISTANCE = 0.064F;
    private static final VerticalAlignmentType CARDBOARD_V2_2_VERTICAL_ALIGNMENT;
    private static final float CARDBOARD_V2_2_VERTICAL_DISTANCE_TO_LENS_CENTER = 0.035F;
    private static final float CARDBOARD_V2_2_SCREEN_TO_LENS_DISTANCE = 0.039F;
    private static final String CARDBOARD_V1_VENDOR = "Google, Inc.";
    private static final String CARDBOARD_V1_MODEL = "Cardboard v1";
    private static final float CARDBOARD_V1_INTER_LENS_DISTANCE = 0.06F;
    private static final VerticalAlignmentType CARDBOARD_V1_VERTICAL_ALIGNMENT;
    private static final float CARDBOARD_V1_VERTICAL_DISTANCE_TO_LENS_CENTER = 0.035F;
    private static final float CARDBOARD_V1_SCREEN_TO_LENS_DISTANCE = 0.042F;
    private static final GvrViewerParams DEFAULT_PARAMS = new GvrViewerParams();
    private String vendor;
    private String model;
    private float interLensDistance;
    private VerticalAlignmentType verticalAlignment;
    private float verticalDistanceToLensCenter;
    private float screenToLensDistance;
    private FieldOfView leftEyeMaxFov;
    private boolean hasMagnet;
    private Distortion distortion;
    private com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice.DeviceParams originalDeviceProto;

    static 
    {
        CARDBOARD_V2_2_VERTICAL_ALIGNMENT = VerticalAlignmentType.BOTTOM;
        CARDBOARD_V1_VERTICAL_ALIGNMENT = VerticalAlignmentType.BOTTOM;
    }
}
