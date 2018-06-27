package com.capgemini.krk.aop;

import com.capgemini.krk.config.DbContext;
import com.capgemini.krk.config.DbContextEnum;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class DbAspect {

    @Around(value = "execution(* com.capgemini.krk.services.*.*.*(..))")
    public Object execute(ProceedingJoinPoint pjp) throws Throwable {
        try {
            Object result = pjp.proceed();
            return result;
        } catch (Exception e) {
            DbContext.setContext(DbContextEnum.DB2);
            throw e;
        }
    }

}
