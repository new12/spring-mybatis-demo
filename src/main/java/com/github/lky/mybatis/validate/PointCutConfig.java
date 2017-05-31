package com.github.lky.mybatis.validate;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by longkeyu on 2017/5/31.
 */
@Aspect
@Component
public class PointCutConfig {
    @Pointcut("execution(* com.github.lky.mybatis.service.impl.UserServiceImpl.create(..))")
    public void createPointCut(){
    }

    @Pointcut("execution(* com.github.lky.mybatis.service.impl.LogServiceImpl.record(..))")
    public void recordPointCut(){
    }
    @Pointcut("createPointCut() || recordPointCut()")
    public void summaryPointCut(){

    }
}
