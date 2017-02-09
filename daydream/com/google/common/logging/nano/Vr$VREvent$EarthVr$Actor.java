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

    public static cachedSize[] emptyArray()
    {
        if(_emptyArray == null)
            synchronized(InternalNano.LAZY_INIT_LOCK)
            {
                if(_emptyArray == null)
                    _emptyArray = new _emptyArray[0];
            }
        return _emptyArray;
    }

    public final _emptyArray clone()
    {
        _emptyArray _lemptyarray;
        try
        {
            _lemptyarray = (_emptyArray)super.clone();
        }
        catch(CloneNotSupportedException clonenotsupportedexception)
        {
            throw new AssertionError(clonenotsupportedexception);
        }
        if(startFromHeadTransform != null)
            _lemptyarray.startFromHeadTransform = startFromHeadTransform.e();
        if(controllerStates != null && controllerStates.length > 0)
        {
            _lemptyarray.controllerStates = new ControllerState[controllerStates.length];
            for(int i = 0; i < controllerStates.length; i++)
                if(controllerStates[i] != null)
                    _lemptyarray.controllerStates[i] = controllerStates[i].clone();

        }
        return _lemptyarray;
    }

    public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
        throws IOException
    {
        if(startFromHeadTransform != null)
            codedoutputbytebuffernano.writeMessage(2, startFromHeadTransform);
        if(controllerStates != null && controllerStates.length > 0)
        {
            for(int i = 0; i < controllerStates.length; i++)
            {
                ControllerState controllerstate;
                if((controllerstate = controllerStates[i]) != null)
                    codedoutputbytebuffernano.writeMessage(3, controllerstate);
            }

        }
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(startFromHeadTransform != null)
            i += CodedOutputByteBufferNano.computeMessageSize(2, startFromHeadTransform);
        if(controllerStates != null && controllerStates.length > 0)
        {
            for(int j = 0; j < controllerStates.length; j++)
            {
                ControllerState controllerstate;
                if((controllerstate = controllerStates[j]) != null)
                    i += CodedOutputByteBufferNano.computeMessageSize(3, controllerstate);
            }

        }
        return i;
    }

    public final volatile ExtendableMessageNano clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public final volatile MessageNano clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public final MessageNano mergeFrom(CodedInputByteBufferNano codedinputbytebuffernano)
        throws IOException
    {
        CodedInputByteBufferNano codedinputbytebuffernano1 = codedinputbytebuffernano;
        clone clone1 = this;
        int i;
        do
            switch(i = codedinputbytebuffernano1.readTag())
            {
            case 0: // '\0'
                return clone1;

            default:
                if(!clone1.super.storeUnknownField(codedinputbytebuffernano1, i))
                    return clone1;
                break;

            case 18: // '\022'
                if(clone1.startFromHeadTransform == null)
                    clone1.startFromHeadTransform = new t>();
                codedinputbytebuffernano1.readMessage(clone1.startFromHeadTransform);
                break;

            case 26: // '\032'
                int j = WireFormatNano.getRepeatedFieldArrayLength(codedinputbytebuffernano1, 26);
                int k;
                ControllerState acontrollerstate[] = new ControllerState[(k = clone1.controllerStates != null ? clone1.controllerStates.length : 0) + j];
                if(k != 0)
                    System.arraycopy(clone1.controllerStates, 0, acontrollerstate, 0, k);
                for(; k < acontrollerstate.length - 1; k++)
                {
                    acontrollerstate[k] = new ControllerState();
                    codedinputbytebuffernano1.readMessage(acontrollerstate[k]);
                    codedinputbytebuffernano1.readTag();
                }

                acontrollerstate[k] = new ControllerState();
                codedinputbytebuffernano1.readMessage(acontrollerstate[k]);
                clone1.controllerStates = acontrollerstate;
                break;
            }
        while(true);
    }

    public final volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    private static volatile clone _emptyArray[];
    private clone startFromHeadTransform;
    private ControllerState controllerStates[];

    public ControllerState.cachedSize()
    {
        ControllerState.cachedSize cachedsize;
        (cachedsize = this).startFromHeadTransform = null;
        class ControllerState extends ExtendableMessageNano
            implements Cloneable
        {

            public static ControllerState[] emptyArray()
            {
                if(_emptyArray == null)
                    synchronized(InternalNano.LAZY_INIT_LOCK)
                    {
                        if(_emptyArray == null)
                            _emptyArray = new ControllerState[0];
                    }
                return _emptyArray;
            }

            public final ControllerState clone()
            {
                ControllerState controllerstate;
                try
                {
                    controllerstate = (ControllerState)super.clone();
                }
                catch(CloneNotSupportedException clonenotsupportedexception)
                {
                    throw new AssertionError(clonenotsupportedexception);
                }
                if(startFromControllerTransform != null)
                    controllerstate.startFromControllerTransform = startFromControllerTransform.clone();
                return controllerstate;
            }

            public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
                throws IOException
            {
                if(role != null)
                    codedoutputbytebuffernano.writeInt32(1, role.intValue());
                if(startFromControllerTransform != null)
                    codedoutputbytebuffernano.writeMessage(2, startFromControllerTransform);
                super.writeTo(codedoutputbytebuffernano);
            }

            protected final int computeSerializedSize()
            {
                int i = super.computeSerializedSize();
                if(role != null)
                    i += CodedOutputByteBufferNano.computeInt32Size(1, role.intValue());
                if(startFromControllerTransform != null)
                    i += CodedOutputByteBufferNano.computeMessageSize(2, startFromControllerTransform);
                return i;
            }

            public final volatile ExtendableMessageNano clone()
                throws CloneNotSupportedException
            {
                return clone();
            }

            public final volatile MessageNano clone()
                throws CloneNotSupportedException
            {
                return clone();
            }

            public final MessageNano mergeFrom(CodedInputByteBufferNano codedinputbytebuffernano)
                throws IOException
            {
                CodedInputByteBufferNano codedinputbytebuffernano1 = codedinputbytebuffernano;
                ControllerState controllerstate = this;
                int i;
                int j;
                do
                    switch(i = codedinputbytebuffernano1.readTag())
                    {
                    case 0: // '\0'
                        return controllerstate;

                    default:
                        if(!controllerstate.super.storeUnknownField(codedinputbytebuffernano1, i))
                            return controllerstate;
                        break;

                    case 8: // '\b'
                        switch(j = codedinputbytebuffernano1.readInt32())
                        {
                        case 0: // '\0'
                        case 1: // '\001'
                        case 2: // '\002'
                            controllerstate.role = Integer.valueOf(j);
                            break;
                        }
                        break;

                    case 18: // '\022'
                        if(controllerstate.startFromControllerTransform == null)
                            controllerstate.startFromControllerTransform = new Vr.VREvent.Transform();
                        codedinputbytebuffernano1.readMessage(controllerstate.startFromControllerTransform);
                        break;
                    }
                while(true);
            }

            public final volatile Object clone()
                throws CloneNotSupportedException
            {
                return clone();
            }

            private static volatile ControllerState _emptyArray[];
            private Integer role;
            private Vr.VREvent.Transform startFromControllerTransform;

            public ControllerState()
            {
                ControllerState controllerstate;
                (controllerstate = this).startFromControllerTransform = null;
                controllerstate.unknownFieldData = null;
                controllerstate.cachedSize = -1;
            }
        }

        cachedsize.controllerStates = ControllerState.emptyArray();
        cachedsize.unknownFieldData = null;
        cachedsize.cachedSize = -1;
    }
}
