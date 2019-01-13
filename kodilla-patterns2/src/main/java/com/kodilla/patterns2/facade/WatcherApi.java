package com.kodilla.patterns2.facade;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WatcherApi {
    private static final Logger LOGGER = LoggerFactory.getLogger(com.kodilla.patterns2.aop.calculator.Watcher.class);
    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))"+ "&& args(theNumber) && target(o)")
    public void logEvent(Long theNumber, Object o){
        LOGGER.info("Class: " + o.getClass().getName() + ", Args: " + theNumber);
    }
    @Around("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public Object measureTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
            Object result = null;
        try{
            long begin = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            LOGGER.info("Time consumed: " + (end-begin) + "[ms]");
        }catch(Throwable throwable){
            LOGGER.error(throwable.getMessage());
        }
        return result;
    }
    @Before("execution(* com.kodilla.patterns2.facade.ShopService.openOrder(..))"+ "&& args(userId) && target(o)")
    public void logEvent2(long userId, Object o){
        LOGGER.info("Class: " + o.getClass().getName() + ", userId: " + userId);
    }
}
