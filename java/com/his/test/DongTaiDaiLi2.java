package com.qhit.test;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DongTaiDaiLi2 implements MethodInterceptor {

    public Object getInstance(Object object){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("点菜中....");
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("付款中....");
        return o1;
    }
}
