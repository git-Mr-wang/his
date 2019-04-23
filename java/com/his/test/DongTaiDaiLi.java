package com.qhit.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DongTaiDaiLi implements InvocationHandler {

    private Object object;
    public Object band(Object o){
            this.object=o;
            return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("点菜中...");
        Object invoke = method.invoke(object, args);
        System.out.println("付款中..");
        return invoke;
    }
}
