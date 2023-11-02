package com.ecust.aspect;


import com.ecust.annotataion.AutoFill;

import com.ecust.constant.AutoFillConstant;
import com.ecust.constant.StatusConstant;
import com.ecust.context.BaseContext;
import com.ecust.enumope.OperationType;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 * @author solang
 * @date 2023-10-31 9:11
 */

@Component
@Aspect
public class AutoFillAspect {
    @Pointcut("@annotation(com.ecust.annotataion.AutoFill)")
    public void point(){
    }
    @Before("point()")
    public void before(JoinPoint joinPoint) throws Exception{
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        AutoFill autoFill = signature.getMethod().getAnnotation(AutoFill.class);

        OperationType operationType = autoFill.value();

        Object[] args = joinPoint.getArgs();
        if(args==null){
            return;
        }
        Object entity=args[0];

        if(operationType==OperationType.INSERT){
            Method setCreateTime = entity.getClass().getDeclaredMethod(AutoFillConstant.Set_Create_Time,LocalDateTime.class);
            Method setUpdateTime = entity.getClass().getDeclaredMethod(AutoFillConstant.Set_Update_Time,LocalDateTime.class);
            Method setCreateUser = entity.getClass().getDeclaredMethod(AutoFillConstant.Set_Create_User, Long.class);
            Method setUpdateUser = entity.getClass().getDeclaredMethod(AutoFillConstant.Set_Update_User, Long.class);
            Method setStatus = entity.getClass().getDeclaredMethod(AutoFillConstant.Set_Status, Integer.class);
            Method setPassword = entity.getClass().getDeclaredMethod(AutoFillConstant.Set_Password, String.class);

            setCreateTime.invoke(entity,LocalDateTime.now());
            setUpdateTime.invoke(entity,LocalDateTime.now());
            setCreateUser.invoke(entity, BaseContext.getCurrentId());
            setUpdateUser.invoke(entity,BaseContext.getCurrentId());
            setStatus.invoke(entity, StatusConstant.Status_Able);
            setPassword.invoke(entity,AutoFillConstant.Default_Password);

        }else if(operationType==OperationType.UPDATE){
            Method setUpdateTime = entity.getClass().getDeclaredMethod(AutoFillConstant.Set_Update_Time,LocalDateTime.class);
            Method setUpdateUser = entity.getClass().getDeclaredMethod(AutoFillConstant.Set_Update_User, Long.class);

            setUpdateTime.invoke(entity,LocalDateTime.now());
            setUpdateUser.invoke(entity,BaseContext.getCurrentId());

        }





    }
//    @Around("@annotation(com.ecust.annotataion.AutoFill2)")
//    public void around(ProceedingJoinPoint joinPoint){
//        System.out.println(555);
//        try {
//            joinPoint.proceed();
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//        System.out.println(777);
//
//    }
}
