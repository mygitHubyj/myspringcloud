package com.controller;

import com.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {
    @Autowired
    HelloService helloService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name){
        //return this.helloService.hiService(name);
        return "hi";
    }
    /**
     * 自定义负载规则
     */

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(@RequestParam String name) {
        this.loadBalancerClient.choose("service-C");//随机访问策略
        return restTemplate.getForObject("http://service-C/hi?name="+name,String.class);

    }
}
