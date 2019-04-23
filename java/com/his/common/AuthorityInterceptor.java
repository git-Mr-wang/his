package com.qhit.common;


import com.qhit.baseFunction.pojo.BaseFunction;
import com.qhit.baseUser.pojo.BaseUser;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component
@Aspect
public class AuthorityInterceptor {

    @Before("execution(* com.qhit.*.controller.*.*(..))")
    public void before(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        BaseUser user = (BaseUser) request.getSession().getAttribute("baseUserLogin");
        if (user!=null){
            String uri = request.getRequestURI();
            List<BaseFunction> baseFunctionList = user.getBaseFunctionList();
            boolean flag=false;
            for (BaseFunction b:baseFunctionList){
                if (b.getUrl()!=null&&uri.indexOf(b.getUrl())!=-1){
                    flag=true;
                }
            }
            request.setAttribute("quanxian",flag);
        }
    }
}
