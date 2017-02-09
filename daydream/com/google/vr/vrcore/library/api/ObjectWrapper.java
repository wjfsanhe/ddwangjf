// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ObjectWrapper.java

package com.google.vr.vrcore.library.api;

import java.lang.reflect.Field;

// Referenced classes of package com.google.vr.vrcore.library.api:
//            IObjectWrapper

public final class ObjectWrapper extends IObjectWrapper.Stub
{

    private ObjectWrapper(Object obj)
    {
        wrappedObject = obj;
    }

    public static IObjectWrapper wrap(Object obj)
    {
        return new ObjectWrapper(obj);
    }

    public static Object unwrap(IObjectWrapper iobjectwrapper, Class class1)
    {
        android.os.IBinder ibinder;
        Field field;
        if(iobjectwrapper instanceof ObjectWrapper)
            return ((ObjectWrapper)iobjectwrapper).wrappedObject;
        Class class2;
        Field afield[];
        if((afield = (class2 = (ibinder = iobjectwrapper.asBinder()).getClass()).getDeclaredFields()).length != 1)
            break MISSING_BLOCK_LABEL_144;
        if((field = afield[0]).isAccessible())
            break MISSING_BLOCK_LABEL_134;
        field.setAccessible(true);
        Object obj;
        obj = field.get(ibinder);
        if(!class1.isInstance(obj))
            throw new IllegalArgumentException("remoteBinder is the wrong class.");
        return class1.cast(obj);
        Object obj1;
        obj1;
        throw new IllegalArgumentException("Binder object is null.", ((Throwable) (obj1)));
        obj1;
        throw new IllegalArgumentException("remoteBinder is the wrong class.", ((Throwable) (obj1)));
        obj1;
        throw new IllegalArgumentException("Could not access the field in remoteBinder.", ((Throwable) (obj1)));
        throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
        throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
    }

    private final Object wrappedObject;
}
