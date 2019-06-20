package com.hotice0.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author HotIce0
 * @Create 2019-06-20 20:01
 */
@Aspect
@Order(100)
@Component
public class AspectLog {
    private final static Logger logger = LoggerFactory.getLogger(AspectLog.class);
    @Autowired
    HttpServletRequest request;

    @Pointcut("execution(* com.hotice0.demo.controller..*.*(..)))")
    public void needLogRequest(){ }

    @Before("needLogRequest()")
    public void loginAuth(JoinPoint joinPoint) throws Exception {
        System.out.println("AspectLog");
        logger.info("url={}, method={}, ip={}, class_method={}, args={}",
                request.getRequestURL(),
                request.getMethod(),
                request.getRemoteAddr(),
                joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName(),
                joinPoint.getArgs()
        );
//        logger.info();
//        logger.warn();
//        logger.error();
//        logger.debug();
//
//        request

    }
}
