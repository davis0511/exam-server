package com.augmentum.common;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

import com.augmentum.exam.AppContext;

public class LogMethodTimeAspect {

    private final Logger logger = Logger.getLogger(LogMethodTimeAspect.class);

    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {

        long startTime = System.currentTimeMillis();
        Object returnValue = pjp.proceed();
        String methodName = pjp.getSignature().getName();
        long endTime = System.currentTimeMillis();

        StringBuilder builder = new StringBuilder();
        builder.append(AppContext.getAppContext().getUserName());
        builder.append(":");
        builder.append(pjp.getTarget().getClass().getSimpleName());
        builder.append(":");
        builder.append(methodName);
        builder.append(":");
        builder.append(endTime-startTime);

        logger.info(builder.toString());
        return returnValue;
    }
}
