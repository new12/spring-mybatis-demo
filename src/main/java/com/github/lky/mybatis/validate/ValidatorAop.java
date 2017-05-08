package com.github.lky.mybatis.validate;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;


/**
 * Created by longkeyu on 2017/5/8.
 */
@Aspect
@Component
public class ValidatorAop {

    private Validator validator;

    public ValidatorAop(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Around("execution(* com.github.lky.mybatis.service.impl.*.create(..))")
    public Object validate(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("work");
        return joinPoint.proceed();
    }
}
