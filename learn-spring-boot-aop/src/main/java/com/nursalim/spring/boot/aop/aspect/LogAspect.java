package com.nursalim.spring.boot.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LogAspect {
    @Pointcut("target(com.nursalim.spring.boot.aop.service.HelloService)")
    public void helloServiceMethod() {
    }

    @Before("helloServiceMethod()")
    public void beforeHelloServiceMethod(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();

        log.info("Before {}.{} ", className, methodName);
    }

    @Around("helloServiceMethod()")
    public Object aroundHelloServiceMethod(ProceedingJoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();

        try {
            log.info("Around before {}.{}", className, methodName );
            return joinPoint.proceed(joinPoint.getArgs());
        } catch (Throwable throwable) {
            log.info("Around Error {}.{}", className, methodName );
            return throwable;
        } finally {
            log.info("Around Finally {}.{}", className, methodName );
        }
    }

    @Pointcut("execution(* com.nursalim.spring.boot.aop.service.HelloService.*(java.lang.String, java.lang.String))")
    public void pointCutHelloServiceStringParam() {
    }

    @Before("pointCutHelloServiceStringParam()")
    public void logStringParameter(JoinPoint joinPoint) {
        String value = (String) joinPoint.getArgs()[0];
        log.info("Execute method with parameter : {} ", value);
    }

    @Before("pointCutHelloServiceStringParam() && args(firstName, lastName)")
    public void logStringParameter2(String firstName, String lastName) {
        log.info("Execute method with parameter 2 : {} and {}", firstName, lastName);
    }

    @Pointcut("execution(* com.nursalim.spring.boot.aop.service.*.*(..))")
    public void pointCutServicePackage() {
    }

    @Pointcut("bean(*Service)")
    public void pointCutServiceBean() {
    }

    @Pointcut("execution(public * *(..))")
    public void pointCutPublicMethod() {

    }

    @Pointcut("pointCutServicePackage() && pointCutServiceBean() && pointCutPublicMethod()")
    public void publicMethodForService() {

    }

    @Before("publicMethodForService()")
    public void logAllServiceMethod() {
        log.info("Log for all service methods");
    }


}
