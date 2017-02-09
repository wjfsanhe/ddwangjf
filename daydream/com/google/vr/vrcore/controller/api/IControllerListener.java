// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IControllerListener.java

package com.google.vr.vrcore.controller.api;

import android.os.*;

// Referenced classes of package com.google.vr.vrcore.controller.api:
//            ControllerTouchEvent, ControllerOrientationEvent, ControllerButtonEvent, ControllerAccelEvent, 
//            ControllerGyroEvent, ControllerListenerOptions, ControllerEventPacket, ControllerEventPacket2

public interface IControllerListener
    extends IInterface
{
    public static abstract class Stub extends Binder
        implements IControllerListener
    {
        private static class Proxy
            implements IControllerListener
        {

            public IBinder asBinder()
            {
                return mRemote;
            }

            public String getInterfaceDescriptor()
            {
                return "com.google.vr.vrcore.controller.api.IControllerListener";
            }

            public int getApiVersion()
                throws RemoteException
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i;
                parcel.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
                mRemote.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                i = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                break MISSING_BLOCK_LABEL_61;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                return i;
            }

            public void onControllerStateChanged(int i, int j)
                throws RemoteException
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
                parcel.writeInt(i);
                parcel.writeInt(j);
                mRemote.transact(2, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void deprecatedOnControllerTouchEvent(ControllerTouchEvent controllertouchevent)
                throws RemoteException
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
                if(controllertouchevent != null)
                {
                    parcel.writeInt(1);
                    controllertouchevent.writeToParcel(parcel, 0);
                } else
                {
                    parcel.writeInt(0);
                }
                mRemote.transact(3, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void deprecatedOnControllerOrientationEvent(ControllerOrientationEvent controllerorientationevent)
                throws RemoteException
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
                if(controllerorientationevent != null)
                {
                    parcel.writeInt(1);
                    controllerorientationevent.writeToParcel(parcel, 0);
                } else
                {
                    parcel.writeInt(0);
                }
                mRemote.transact(4, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public boolean deprecatedOnControllerButtonEventV1(ControllerButtonEvent controllerbuttonevent)
                throws RemoteException
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                boolean flag;
                parcel.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
                if(controllerbuttonevent != null)
                {
                    parcel.writeInt(1);
                    controllerbuttonevent.writeToParcel(parcel, 0);
                } else
                {
                    parcel.writeInt(0);
                }
                mRemote.transact(5, parcel, parcel1, 0);
                parcel1.readException();
                flag = 0 != parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                break MISSING_BLOCK_LABEL_94;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                return flag;
            }

            public void deprecatedOnControllerButtonEvent(ControllerButtonEvent controllerbuttonevent)
                throws RemoteException
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
                if(controllerbuttonevent != null)
                {
                    parcel.writeInt(1);
                    controllerbuttonevent.writeToParcel(parcel, 0);
                } else
                {
                    parcel.writeInt(0);
                }
                mRemote.transact(6, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void deprecatedOnControllerAccelEvent(ControllerAccelEvent controlleraccelevent)
                throws RemoteException
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
                if(controlleraccelevent != null)
                {
                    parcel.writeInt(1);
                    controlleraccelevent.writeToParcel(parcel, 0);
                } else
                {
                    parcel.writeInt(0);
                }
                mRemote.transact(7, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void deprecatedOnControllerGyroEvent(ControllerGyroEvent controllergyroevent)
                throws RemoteException
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
                if(controllergyroevent != null)
                {
                    parcel.writeInt(1);
                    controllergyroevent.writeToParcel(parcel, 0);
                } else
                {
                    parcel.writeInt(0);
                }
                mRemote.transact(8, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public ControllerListenerOptions getOptions()
                throws RemoteException
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                ControllerListenerOptions controllerlisteneroptions;
                parcel.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
                mRemote.transact(9, parcel, parcel1, 0);
                parcel1.readException();
                if(0 != parcel1.readInt())
                    controllerlisteneroptions = (ControllerListenerOptions)ControllerListenerOptions.CREATOR.createFromParcel(parcel1);
                else
                    controllerlisteneroptions = null;
                parcel1.recycle();
                parcel.recycle();
                break MISSING_BLOCK_LABEL_83;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
                return controllerlisteneroptions;
            }

            public void onControllerEventPacket(ControllerEventPacket controllereventpacket)
                throws RemoteException
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
                if(controllereventpacket != null)
                {
                    parcel.writeInt(1);
                    controllereventpacket.writeToParcel(parcel, 0);
                } else
                {
                    parcel.writeInt(0);
                }
                mRemote.transact(10, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onControllerRecentered(ControllerOrientationEvent controllerorientationevent)
                throws RemoteException
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
                if(controllerorientationevent != null)
                {
                    parcel.writeInt(1);
                    controllerorientationevent.writeToParcel(parcel, 0);
                } else
                {
                    parcel.writeInt(0);
                }
                mRemote.transact(11, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            public void onControllerEventPacket2(ControllerEventPacket2 controllereventpacket2)
                throws RemoteException
            {
                Parcel parcel = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.vr.vrcore.controller.api.IControllerListener");
                if(controllereventpacket2 != null)
                {
                    parcel.writeInt(1);
                    controllereventpacket2.writeToParcel(parcel, 0);
                } else
                {
                    parcel.writeInt(0);
                }
                mRemote.transact(12, parcel, null, 1);
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel.recycle();
                throw exception;
            }

            private IBinder mRemote;

            Proxy(IBinder ibinder)
            {
                mRemote = ibinder;
            }
        }


        public static IControllerListener asInterface(IBinder ibinder)
        {
            if(ibinder == null)
                return null;
            IInterface iinterface;
            if((iinterface = ibinder.queryLocalInterface("com.google.vr.vrcore.controller.api.IControllerListener")) != null && (iinterface instanceof IControllerListener))
                return (IControllerListener)iinterface;
            else
                return new Proxy(ibinder);
        }

        public IBinder asBinder()
        {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
            throws RemoteException
        {
            switch(i)
            {
            case 1598968902: 
                parcel1.writeString("com.google.vr.vrcore.controller.api.IControllerListener");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.vr.vrcore.controller.api.IControllerListener");
                int k = getApiVersion();
                parcel1.writeNoException();
                parcel1.writeInt(k);
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.vr.vrcore.controller.api.IControllerListener");
                int l = parcel.readInt();
                int i1 = parcel.readInt();
                onControllerStateChanged(l, i1);
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.vr.vrcore.controller.api.IControllerListener");
                ControllerTouchEvent controllertouchevent;
                if(0 != parcel.readInt())
                    controllertouchevent = (ControllerTouchEvent)ControllerTouchEvent.CREATOR.createFromParcel(parcel);
                else
                    controllertouchevent = null;
                deprecatedOnControllerTouchEvent(controllertouchevent);
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.google.vr.vrcore.controller.api.IControllerListener");
                ControllerOrientationEvent controllerorientationevent;
                if(0 != parcel.readInt())
                    controllerorientationevent = (ControllerOrientationEvent)ControllerOrientationEvent.CREATOR.createFromParcel(parcel);
                else
                    controllerorientationevent = null;
                deprecatedOnControllerOrientationEvent(controllerorientationevent);
                return true;

            case 5: // '\005'
                parcel.enforceInterface("com.google.vr.vrcore.controller.api.IControllerListener");
                ControllerButtonEvent controllerbuttonevent;
                if(0 != parcel.readInt())
                    controllerbuttonevent = (ControllerButtonEvent)ControllerButtonEvent.CREATOR.createFromParcel(parcel);
                else
                    controllerbuttonevent = null;
                boolean flag = deprecatedOnControllerButtonEventV1(controllerbuttonevent);
                parcel1.writeNoException();
                parcel1.writeInt(flag ? 1 : 0);
                return true;

            case 6: // '\006'
                parcel.enforceInterface("com.google.vr.vrcore.controller.api.IControllerListener");
                ControllerButtonEvent controllerbuttonevent1;
                if(0 != parcel.readInt())
                    controllerbuttonevent1 = (ControllerButtonEvent)ControllerButtonEvent.CREATOR.createFromParcel(parcel);
                else
                    controllerbuttonevent1 = null;
                deprecatedOnControllerButtonEvent(controllerbuttonevent1);
                return true;

            case 7: // '\007'
                parcel.enforceInterface("com.google.vr.vrcore.controller.api.IControllerListener");
                ControllerAccelEvent controlleraccelevent;
                if(0 != parcel.readInt())
                    controlleraccelevent = (ControllerAccelEvent)ControllerAccelEvent.CREATOR.createFromParcel(parcel);
                else
                    controlleraccelevent = null;
                deprecatedOnControllerAccelEvent(controlleraccelevent);
                return true;

            case 8: // '\b'
                parcel.enforceInterface("com.google.vr.vrcore.controller.api.IControllerListener");
                ControllerGyroEvent controllergyroevent;
                if(0 != parcel.readInt())
                    controllergyroevent = (ControllerGyroEvent)ControllerGyroEvent.CREATOR.createFromParcel(parcel);
                else
                    controllergyroevent = null;
                deprecatedOnControllerGyroEvent(controllergyroevent);
                return true;

            case 9: // '\t'
                parcel.enforceInterface("com.google.vr.vrcore.controller.api.IControllerListener");
                ControllerListenerOptions controllerlisteneroptions = getOptions();
                parcel1.writeNoException();
                if(controllerlisteneroptions != null)
                {
                    parcel1.writeInt(1);
                    controllerlisteneroptions.writeToParcel(parcel1, 1);
                } else
                {
                    parcel1.writeInt(0);
                }
                return true;

            case 10: // '\n'
                parcel.enforceInterface("com.google.vr.vrcore.controller.api.IControllerListener");
                ControllerEventPacket controllereventpacket;
                if(0 != parcel.readInt())
                    controllereventpacket = (ControllerEventPacket)ControllerEventPacket.CREATOR.createFromParcel(parcel);
                else
                    controllereventpacket = null;
                onControllerEventPacket(controllereventpacket);
                return true;

            case 11: // '\013'
                parcel.enforceInterface("com.google.vr.vrcore.controller.api.IControllerListener");
                ControllerOrientationEvent controllerorientationevent1;
                if(0 != parcel.readInt())
                    controllerorientationevent1 = (ControllerOrientationEvent)ControllerOrientationEvent.CREATOR.createFromParcel(parcel);
                else
                    controllerorientationevent1 = null;
                onControllerRecentered(controllerorientationevent1);
                return true;

            case 12: // '\f'
                parcel.enforceInterface("com.google.vr.vrcore.controller.api.IControllerListener");
                ControllerEventPacket2 controllereventpacket2;
                if(0 != parcel.readInt())
                    controllereventpacket2 = (ControllerEventPacket2)ControllerEventPacket2.CREATOR.createFromParcel(parcel);
                else
                    controllereventpacket2 = null;
                onControllerEventPacket2(controllereventpacket2);
                return true;
            }
            return super.onTransact(i, parcel, parcel1, j);
        }

        private static final String DESCRIPTOR = "com.google.vr.vrcore.controller.api.IControllerListener";
        static final int TRANSACTION_getApiVersion = 1;
        static final int TRANSACTION_onControllerStateChanged = 2;
        static final int TRANSACTION_deprecatedOnControllerTouchEvent = 3;
        static final int TRANSACTION_deprecatedOnControllerOrientationEvent = 4;
        static final int TRANSACTION_deprecatedOnControllerButtonEventV1 = 5;
        static final int TRANSACTION_deprecatedOnControllerButtonEvent = 6;
        static final int TRANSACTION_deprecatedOnControllerAccelEvent = 7;
        static final int TRANSACTION_deprecatedOnControllerGyroEvent = 8;
        static final int TRANSACTION_getOptions = 9;
        static final int TRANSACTION_onControllerEventPacket = 10;
        static final int TRANSACTION_onControllerRecentered = 11;
        static final int TRANSACTION_onControllerEventPacket2 = 12;

        public Stub()
        {
            attachInterface(this, "com.google.vr.vrcore.controller.api.IControllerListener");
        }
    }


    public abstract int getApiVersion()
        throws RemoteException;

    public abstract void onControllerStateChanged(int i, int j)
        throws RemoteException;

    public abstract void deprecatedOnControllerTouchEvent(ControllerTouchEvent controllertouchevent)
        throws RemoteException;

    public abstract void deprecatedOnControllerOrientationEvent(ControllerOrientationEvent controllerorientationevent)
        throws RemoteException;

    public abstract boolean deprecatedOnControllerButtonEventV1(ControllerButtonEvent controllerbuttonevent)
        throws RemoteException;

    public abstract void deprecatedOnControllerButtonEvent(ControllerButtonEvent controllerbuttonevent)
        throws RemoteException;

    public abstract void deprecatedOnControllerAccelEvent(ControllerAccelEvent controlleraccelevent)
        throws RemoteException;

    public abstract void deprecatedOnControllerGyroEvent(ControllerGyroEvent controllergyroevent)
        throws RemoteException;

    public abstract ControllerListenerOptions getOptions()
        throws RemoteException;

    public abstract void onControllerEventPacket(ControllerEventPacket controllereventpacket)
        throws RemoteException;

    public abstract void onControllerRecentered(ControllerOrientationEvent controllerorientationevent)
        throws RemoteException;

    public abstract void onControllerEventPacket2(ControllerEventPacket2 controllereventpacket2)
        throws RemoteException;
}
