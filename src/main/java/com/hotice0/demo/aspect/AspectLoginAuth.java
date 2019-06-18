package com.hotice0.demo.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author HotIce0
 * @Create 2019-06-13 20:15
 */
@Aspect
@Component
public class AspectLoginAuth {
    @Autowired
    HttpServletRequest request;

    @Pointcut("@annotation(com.hotice0.demo.annotation.AnnotationLoginAuth)")
    public void needLoginAuthRequest(){ }
//    @Pointcut("execution(* com.hotice0.demo.controller..*.*(..)))")
//    public void needAuthRequest(){ }

    @Before("needLoginAuthRequest()")
    public void loginAuth() throws Exception {
        String username = (String) request.getSession().getAttribute("username");
        if (username == null) {
            // 用户未进行登录
            throw new Exception("用户未进行登录");
        }
    }
}
