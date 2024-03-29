package com.hu.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author : hudelin
 * @className :WebLogAspect
 * @description : 请求日志
 * @date: 2020-06-30 15:30
 */
@Order(8)
@Aspect
@Component
@Slf4j(topic = "WEB_LOG")
public class WebLogAspect {
//    private static final Logger log = LoggerFactory.getLogger("WEBLOG");

    //两个..代表所有子目录，最后括号里的两个..代表所有参数
    @Pointcut("execution( * com.hu.controller..*.*(..))")
    public void logPointCut() {
    }

    @Before("logPointCut()")
    public void logPointCut(JoinPoint joinPoint){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        log.info("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        log.info("请求地址 : {}" ,request.getRequestURL().toString());
        log.info("请求方式 : {}" ,request.getMethod());
        log.info("请求的方法 : {}" , joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("参数 : {}" , Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * returning的值和doAfterReturning的参数名一致
     * @param ret
     * @throws Throwable
     */
    @AfterReturning(returning = "ret", pointcut = "logPointCut()")
    public void logPointCut(Object ret) throws Throwable {
        // 处理完请求，返回内容
        log.info("返回值 : {}" ,ret);
    }

    @Around("logPointCut()")
    public Object logPointCut(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        // ob 为方法的返回值
        Object ob = pjp.proceed();
        log.info("耗时 : {}s" , (System.currentTimeMillis() - startTime)/1000);
        return ob;
    }
}
