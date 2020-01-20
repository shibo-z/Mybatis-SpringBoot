package com.shibo.usersys.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 切面类
 */
@Component
@Aspect
public class LogComponent {
    private static final Logger logger = LoggerFactory.getLogger(LogComponent.class);
    /**
     * 定义切入点
     * 第一个'*'表示任意返回值
     * 然后是包名
     * 包名后的'..*.*'表示包及子包下的任意类的任意方法，'(..)'表示方法参数任意
     */
    @Pointcut("execution(* com.shibo.usersys.service..*.*(..))")
    public void pcl(){
        //啥都不用写
    }

    //前置通知 注解表示前置，参数选定切入点
    @Before(value = "pcl()")
    public void before(JoinPoint joinPoint){
        //方法名
        String name = joinPoint.getSignature().getName();
        // ...
        logger.info("AOP before : method name -->{}",name);
    }

    //后置通知
    @After(value = "pcl()")
    public void after(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        // ...
        logger.info("AOP after : method name -->{}",name);
    }

    /**
     * 返回通知 有返回值时触发
     * @param joinPoint
     * @param result 给返回值起个名字，在方法参数中接收
     */
    @AfterReturning(value = "pcl()",returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        String name = joinPoint.getSignature().getName();
        // ...
        logger.info("AOP afterReturning : method name -->{}",name);
        try {
            logger.info("AOP afterReturning : return -->{}",new ObjectMapper().writeValueAsString(result));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    //异常通知
    @AfterThrowing(value = "pcl()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e){
        String name = joinPoint.getSignature().getName();
        // ...
        logger.info("AOP afterThrowing : method name -->{}",name);
        logger.info("AOP afterThrowing : e.message -->{}",e.getMessage());
    }

    //环绕通知,上面四种的通知的综合
    @Around(value = "pcl()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws JsonProcessingException {
        //proceedingJoinPoint.proceed()之前，就是前置
        logger.info("AOP around : 前置代码");

        //相当于invoke(),执行此方法就相当于执行目标方法
        Object proceed = null;
        try {
            proceed = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            //对proceed()使用try-catch，就可以异常通知操作
            logger.info("AOP around : 异常通知代码 e.message-->{}", throwable.getMessage());
        }

        //通过返回值进行返回通知操作
        logger.info("AOP around :返回通知代码 return-->{}", new ObjectMapper().writeValueAsString(proceed));

        //proceedingJoinPoint.proceed()之后，就是后置
        logger.info("AOP around : 后置代码");

        //最后要返回这个返回值
        return proceed;
    }

}
