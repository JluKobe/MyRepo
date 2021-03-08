package aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

//日志切面类
@Aspect
public class LogAspects {

    @Pointcut("execution(public int aop.calculator.Calculator.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void logStart() {
        System.out.println("@Before 方法运行");
    }

    @After("pointCut()")
    public void logEnd() {
        System.out.println("@After 方法结束");
    }

    @AfterReturning("pointCut()")
    public void logReturn() {
        System.out.println("@AfterReturning 方法返回");
    }

    @AfterThrowing("pointCut()")
    public void logException() {
        System.out.println("@AfterThrowing 方法异常");
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("@Around 执行目标方法之前");
        Object object = proceedingJoinPoint.proceed();
        System.out.println("@Around 执行目标方法之后");

        return object;
    }
}
