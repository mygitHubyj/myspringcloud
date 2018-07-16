package com.yuj.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableEurekaClient
@RestController
public class SpringCloudEurekaConsumerApplication {
	@Autowired
	void setEnviroment(Environment env) {
		System.out.println("my-config.appName from env: " + env.getProperty("name"));
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaConsumerApplication.class, args);
	}

    @Value("${name}")
    private  String name;
    @Value("${age}")
    private  String age;
    @Value("${version}")
    private  String version="开发环境";

    @RequestMapping("/test")
    public String test(){
        return "你好，我是"+name+",年龄："+age+"岁。当前环境："+version;
    }
}
