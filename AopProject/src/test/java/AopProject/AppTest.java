package AopProject;

import static org.junit.Assert.assertTrue;

import aop.calculator.Calculator;
import aop.config.AopConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testAopCalculator() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        Calculator calculator = context.getBean(Calculator.class);
        int result = calculator.add(1, 123);
        System.out.println("result : " + result);
        context.close();
    }
}
