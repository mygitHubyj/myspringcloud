package com.feign;

import com.feign.configuration.FeignConfig;
import org.springframework.cloud.netflix.feign.FeignClient;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "HELLO-SERVICE", fallback = SchedualServiceHiHystric.class,configuration = FeignConfig.class)
public interface FeignService {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
