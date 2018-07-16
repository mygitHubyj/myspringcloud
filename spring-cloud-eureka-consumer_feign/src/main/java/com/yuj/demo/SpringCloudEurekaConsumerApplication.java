package com.yuj.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
@EnableFeignClients
@EnableDiscoveryClient//初始化RestTemplate，用来真正发起REST请求。@EnableDiscoveryClient注解用来将当前应用加入到服务治理体系中。
@SpringBootApplication
public class SpringCloudEurekaConsumerApplication {
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaConsumerApplication.class, args);
	}


    @RequestMapping("/test")
    public String test(){
        return "你好，我是";
    }
}
