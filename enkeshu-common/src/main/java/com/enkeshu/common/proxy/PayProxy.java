package com.enkeshu.common.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PayProxy implements InvocationHandler {

    public Object object;

    public PayProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(object, args);
        return invoke;
    }
}
