package com.qhit.common;


import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;

@Component
@Aspect

public class ExceptionInterceptor {

    @AfterThrowing(value = "execution(* com.qhit.*.controller.*.*(..))",throwing="e")
    public void handlerException(Exception e){
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw,true));
        String s = sw.toString();
        String[] arr = s.split("\r\n");
        int length=arr.length>4?4:arr.length;
        for (int i=0;i<length;i++){
            System.out.println(arr[i]);
        }
    }

}
