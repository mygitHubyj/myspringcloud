package com.yuj.demo.feignClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("hello-service")
public interface DcClient {
	  @GetMapping("/hello")
	   String consumer();
}
