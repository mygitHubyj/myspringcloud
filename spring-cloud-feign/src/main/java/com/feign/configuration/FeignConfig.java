package com.feign.configuration;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class FeignConfig {

    @Bean
    public Retryer feignRetryer() {
        System.out.print("执行自定义配置 FeignConfig . feignRetryer  ");
        return new Retryer.Default(100, TimeUnit.SECONDS.toMillis(1L), 5);
    }

}