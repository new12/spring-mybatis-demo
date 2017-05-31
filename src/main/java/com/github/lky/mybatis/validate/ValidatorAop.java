package com.github.lky.mybatis.validate;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;
import java.util.Set;


/**
 * Created by longkeyu on 2017/5/8.
 */
@Aspect
@Component
public class ValidatorAop {

    private Logger log = LoggerFactory.getLogger(ValidatorAop.class);

    private Validator validator;

    public ValidatorAop(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Around(value = "com.github.lky.mybatis.validate.PointCutConfig.summaryPointCut()")
    public Object validate(ProceedingJoinPoint pjp) throws Throwable{
        Object[] args = pjp.getArgs();
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(args[0]);
        if (constraintViolations.size() > 0 ) {
            log.error("参数错误");
        }
        return pjp.proceed();
    }
}
