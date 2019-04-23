package com.qhit.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect

public class Loginterceptor {
    @Before("execution(* com.qhit.*.controller.*.*(..))")
//    @After("execution(* com.qhit.*.controller.*.*(..))")
    public void before(JoinPoint jp){
//        System.out.println("开始执行");
        String className = jp.getTarget().getClass().getName();
        String methodName = jp.getSignature().getName();
        String args = Arrays.toString(jp.getArgs());
        System.out.println("开始执行类名："+className+"下的方法"+methodName+"，输入的参数是："+args);
        System.out.println();
    }
    @AfterReturning(returning = "result",value = "execution(* com.qhit.*.controller.*.*(..))")
    public void afterReturning(JoinPoint jp,Object result){
        String className = jp.getTarget().getClass().getName();
        String methodName = jp.getSignature().getName();
        String args = Arrays.toString(jp.getArgs());
        System.out.println("结束执行类名："+className+"下的方法"+methodName+"，返回的参数是："+args);
        System.out.println("结束执行类名"+result);
        System.out.println();
    }

}
