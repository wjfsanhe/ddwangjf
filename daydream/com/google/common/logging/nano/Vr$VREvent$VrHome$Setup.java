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
        StepStateChange.cachedSize cachedsize;
        try
        {
            cachedsize = (StepStateChange.cachedSize)super.clone();
        }
        catch(CloneNotSupportedException clonenotsupportedexception)
        {
            throw new AssertionError(clonenotsupportedexception);
        }
        class View extends ExtendableMessageNano
            implements Cloneable
        {

            public final View clone()
            {
                View view1;
                try
                {
                    view1 = (View)super.clone();
                }
                catch(CloneNotSupportedException clonenotsupportedexception1)
                {
                    throw new AssertionError(clonenotsupportedexception1);
                }
                return view1;
            }

            public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
                throws IOException
            {
                if(step != null)
                    codedoutputbytebuffernano.writeInt32(1, step.intValue());
                if(page != null)
                    codedoutputbytebuffernano.writeInt32(2, page.intValue());
                super.writeTo(codedoutputbytebuffernano);
            }

            protected final int computeSerializedSize()
            {
                int i = super.computeSerializedSize();
                if(step != null)
                    i += CodedOutputByteBufferNano.computeInt32Size(1, step.intValue());
                if(page != null)
                    i += CodedOutputByteBufferNano.computeInt32Size(2, page.intValue());
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
                View view1 = this;
                int i;
                int j;
                do
                    switch(i = codedinputbytebuffernano1.readTag())
                    {
                    case 0: // '\0'
                        return view1;

                    default:
                        if(!view1.super.storeUnknownField(codedinputbytebuffernano1, i))
                            return view1;
                        continue;

                    case 8: // '\b'
                        switch(j = codedinputbytebuffernano1.readInt32())
                        {
                        case 0: // '\0'
                        case 1: // '\001'
                        case 2: // '\002'
                        case 3: // '\003'
                        case 4: // '\004'
                        case 5: // '\005'
                        case 6: // '\006'
                        case 7: // '\007'
                        case 8: // '\b'
                            view1.step = Integer.valueOf(j);
                            break;
                        }
                        break;

                    case 16: // '\020'
                        view1.page = Integer.valueOf(codedinputbytebuffernano1.readInt32());
                        break;
                    }
                while(true);
            }

            public final volatile Object clone()
                throws CloneNotSupportedException
            {
                return clone();
            }

            private Integer step;
            private Integer page;

            public View()
            {
                View view1;
                (view1 = this).page = null;
                view1.unknownFieldData = null;
                view1.cachedSize = -1;
            }
        }

        if(view != null)
            cachedsize.view = view.clone();
        class StepStateChange extends ExtendableMessageNano
            implements Cloneable
        {

            public final StepStateChange clone()
            {
                StepStateChange stepstatechange;
                try
                {
                    stepstatechange = (StepStateChange)super.clone();
                }
                catch(CloneNotSupportedException clonenotsupportedexception1)
                {
                    throw new AssertionError(clonenotsupportedexception1);
                }
                return stepstatechange;
            }

            public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
                throws IOException
            {
                if(step != null)
                    codedoutputbytebuffernano.writeInt32(1, step.intValue());
                if(previousStepState != null)
                    codedoutputbytebuffernano.writeInt32(2, previousStepState.intValue());
                if(newStepState != null)
                    codedoutputbytebuffernano.writeInt32(3, newStepState.intValue());
                super.writeTo(codedoutputbytebuffernano);
            }

            protected final int computeSerializedSize()
            {
                int i = super.computeSerializedSize();
                if(step != null)
                    i += CodedOutputByteBufferNano.computeInt32Size(1, step.intValue());
                if(previousStepState != null)
                    i += CodedOutputByteBufferNano.computeInt32Size(2, previousStepState.intValue());
                if(newStepState != null)
                    i += CodedOutputByteBufferNano.computeInt32Size(3, newStepState.intValue());
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
                StepStateChange stepstatechange = this;
                int i;
                int j;
                do
                    switch(i = codedinputbytebuffernano1.readTag())
                    {
                    case 0: // '\0'
                        return stepstatechange;

                    default:
                        if(!stepstatechange.super.storeUnknownField(codedinputbytebuffernano1, i))
                            return stepstatechange;
                        break;

                    case 8: // '\b'
                        switch(j = codedinputbytebuffernano1.readInt32())
                        {
                        case 0: // '\0'
                        case 1: // '\001'
                        case 2: // '\002'
                        case 3: // '\003'
                        case 4: // '\004'
                        case 5: // '\005'
                        case 6: // '\006'
                        case 7: // '\007'
                        case 8: // '\b'
                            stepstatechange.step = Integer.valueOf(j);
                            break;
                        }
                        break;

                    case 16: // '\020'
                        switch(j = codedinputbytebuffernano1.readInt32())
                        {
                        case 0: // '\0'
                        case 1: // '\001'
                        case 2: // '\002'
                        case 3: // '\003'
                        case 4: // '\004'
                            stepstatechange.previousStepState = Integer.valueOf(j);
                            break;
                        }
                        break;

                    case 24: // '\030'
                        switch(j = codedinputbytebuffernano1.readInt32())
                        {
                        default:
                            break;

                        case 0: // '\0'
                        case 1: // '\001'
                        case 2: // '\002'
                        case 3: // '\003'
                        case 4: // '\004'
                            stepstatechange.newStepState = Integer.valueOf(j);
                            break;
                        }
                        break;
                    }
                while(true);
            }

            public final volatile Object clone()
                throws CloneNotSupportedException
            {
                return clone();
            }

            private Integer step;
            private Integer previousStepState;
            private Integer newStepState;

            public StepStateChange()
            {
                StepStateChange stepstatechange;
                (stepstatechange = this).unknownFieldData = null;
                stepstatechange.cachedSize = -1;
            }
        }

        if(stepStateChange != null)
            cachedsize.stepStateChange = stepStateChange.clone();
        return cachedsize;
    }

    public final void writeTo(CodedOutputByteBufferNano codedoutputbytebuffernano)
        throws IOException
    {
        if(view != null)
            codedoutputbytebuffernano.writeMessage(1, view);
        if(stepStateChange != null)
            codedoutputbytebuffernano.writeMessage(2, stepStateChange);
        super.writeTo(codedoutputbytebuffernano);
    }

    protected final int computeSerializedSize()
    {
        int i = super.computeSerializedSize();
        if(view != null)
            i += CodedOutputByteBufferNano.computeMessageSize(1, view);
        if(stepStateChange != null)
            i += CodedOutputByteBufferNano.computeMessageSize(2, stepStateChange);
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

            case 10: // '\n'
                if(clone1.view == null)
                    clone1.view = new View();
                codedinputbytebuffernano1.readMessage(clone1.view);
                break;

            case 18: // '\022'
                if(clone1.stepStateChange == null)
                    clone1.stepStateChange = new StepStateChange();
                codedinputbytebuffernano1.readMessage(clone1.stepStateChange);
                break;
            }
        while(true);
    }

    public final volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    private View view;
    private StepStateChange stepStateChange;

    public StepStateChange()
    {
        StepStateChange stepstatechange;
        (stepstatechange = this).view = null;
        stepstatechange.stepStateChange = null;
        stepstatechange.unknownFieldData = null;
        stepstatechange.cachedSize = -1;
    }
}
