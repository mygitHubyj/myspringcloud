package com.feign;

import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystric implements FeignService {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}