package com.ecust.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author solang
 * @date 2023-10-31 9:11
 */

@Component
@Aspect
public class AutoFill2Aspect {
    @Pointcut("@annotation(com.ecust.annotataion.AutoFill2)")
    public void point(){
    }
//    @Before("point()")
//    public void before(JoinPoint joinPoint) throws Exception{
//        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
//        AutoFill2 autoFill2 = signature.getMethod().getAnnotation(AutoFill2.class);
//
//        OperationType operationType = autoFill2.value();
//        LocalDateTime now = LocalDateTime.now();
//
//
//        Object entity=new Student();
//
//
//        Method setName = entity.getClass().getDeclaredMethod("setName", String.class);
//        Method setAge = entity.getClass().getDeclaredMethod("setAge", Integer.class);
//        Method setTime = entity.getClass().getDeclaredMethod("setTime", LocalDateTime.class);
//        setName.invoke(entity,"小明");
//        setAge.invoke(entity,12);
//        setTime.invoke(entity,now);
//
//        System.out.println(entity);
//    }
    @Around("@annotation(com.ecust.annotataion.AutoFill2)")
    public void around(ProceedingJoinPoint joinPoint){
        System.out.println(555);
        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println(777);

    }
}
