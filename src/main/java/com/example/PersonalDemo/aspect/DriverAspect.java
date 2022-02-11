package com.example.PersonalDemo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Map;

@Component
@Aspect
@Slf4j
public class DriverAspect {

    //serviceImpl下的所有方法执行前执行
    @Before("execution(* com.example.PersonalDemo.serviceImpl..*.*(..))")
    public void Before() {
        log.info("Before=========!");
    }

    //serviceImpl下的所有方法执行后执行
    @After("execution(* com.example.PersonalDemo.serviceImpl..*.*(..))")
    public void After() {
        log.info("After=========!");
    }




    @AfterReturning("execution(* com.example.PersonalDemo.serviceImpl..*.*(..))")
    public void AfterReturning() {
        log.info("AfterReturning=========!");
    }



//    @Around("execution(* com.example.springboot.serviceImpl..*.*(..))")
    public void Around(ProceedingJoinPoint pj) {
        try{
            log.info("AroundBefore=========!");
            pj.proceed();
            log.info("AroundAfter=========!");
        }catch (Throwable ab){
            ab.printStackTrace();
        }
    }

    @AfterThrowing("execution(* com.example.PersonalDemo.serviceImpl..*.*(..))")
    public void AfterThrowing(){
        log.info("AfterThrowing=========!");
    }






    @Pointcut("@annotation(com.example.PersonalDemo.aspect.OperLog)")
    public void operLogPoinCut() {
    }


    @AfterReturning(value = "operLogPoinCut()", returning = "keys")
    public void saveOperLog(JoinPoint joinPoint, Object keys) {
        // 从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 获取切入点所在的方法
        Method method = signature.getMethod();
        // 获取操作
        OperLog opLog = method.getAnnotation(OperLog.class);


        // 获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        // 获取请求的方法名
        String methodName = method.getName();
        methodName = className + "." + methodName;

        log.info("请求："+ opLog.operDesc()+";"+opLog.operModul() + ";" + opLog.operType()+ ";" +methodName);


        // 获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        // 从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        // 请求的参数
        Map<String, String[]> parameterMap = request.getParameterMap();

    }

}
