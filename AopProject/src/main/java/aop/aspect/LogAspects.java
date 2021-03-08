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
        //前置通知:在我们执行目标方法之前运行(@Before)
        System.out.println("@Before 方法运行");
    }

    @After("pointCut()")
    public void logEnd() {
        //后置通知:在我们目标方法运行结束之后 ,不管有没有异常(@After)
        System.out.println("@After 方法结束");
    }

    @AfterReturning("pointCut()")
    public void logReturn() {
        //返回通知:在我们的目标方法正常返回值后运行(@AfterReturning)
        System.out.println("@AfterReturning 方法返回");
    }

    @AfterThrowing("pointCut()")
    public void logException() {
        //异常通知:在我们的目标方法出现异常后运行(@AfterThrowing)
        System.out.println("@AfterThrowing 方法异常");
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        //环绕通知:动态代理, 需要手动执行joinPoint.procced()
        //其实就是执行我们的目标方法执行之前相当于前置通知, 执行之后就相当于我们后置通知(@Around)
        System.out.println("@Around 执行目标方法之前");
        Object object = joinPoint.proceed();
        System.out.println("@Around 执行目标方法之后");

        return object;
    }
}
