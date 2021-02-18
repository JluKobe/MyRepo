package com;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//@NacosPropertySource(dataId = "exchange-config", groupId = "EXCHANGE", autoRefreshed = true)
@MapperScan(basePackages = "com.repository")
@RestController
public class Application {
    public static void main( String[] args )
    {
        SpringApplication.run(Application.class, args);
    }

//    @NacosValue(value = "${test}", autoRefreshed = true)
//    private String testProperties;
//
//    @GetMapping("/test")
//    public String test(){
//        return testProperties;
//    }
}
