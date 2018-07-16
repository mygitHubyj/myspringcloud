package com.yuj.demo.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuj.demo.feignClient.DcClient;

@RestController
public class TestController {
	   @Autowired
	    DcClient dcClient;

	    @GetMapping("/consumer")
	    public String dc() {
	        return dcClient.consumer();
	    }
}
