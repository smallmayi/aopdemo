package com.aop.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Configuration
@Aspect
public class CtrlAop {
   //环绕aop
    //execution表达式 此表达式表示扫描controller下所有类的所有方法都执行此aop
    //@Around("execution (* com.beyondli.controller..*.*(..))")

    @Pointcut("execution(public * com.aop.ctrl..*.*(..))")
    public void webLog(){
        //不执行
        System.out.println("aaa");
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        System.out.println("dobefore");

    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        System.out.println("after");
    }
    @Around("webLog()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around-1");
        proceedingJoinPoint.proceed(); //可以加参数
        System.out.println("around-2");

    }

}

