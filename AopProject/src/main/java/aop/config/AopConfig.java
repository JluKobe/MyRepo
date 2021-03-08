package aop.config;

import aop.aspect.LogAspects;
import aop.calculator.Calculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AopConfig {

    @Bean
    public LogAspects logAspects() {
        return new LogAspects();
    }

    @Bean
    public Calculator calculator() {
        return new Calculator();
    }
}
