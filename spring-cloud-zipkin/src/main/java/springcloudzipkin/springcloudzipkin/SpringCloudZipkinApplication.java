package springcloudzipkin.springcloudzipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.EnableZipkinServer;

/**
 * 微服务架构上通过业务来划分服务的，通过REST调用，对外暴露的一个接口，
 * 可能需要很多个服务协同才能完成这个接口功能，如果链路上任何一个服务出现问题或者网络超时，
 * 都会形成导致接口调用失败。随着业务的不断扩张，服务之间互相调用会越来越复杂。
 * Spring Cloud Sleuth 主要功能就是在分布式系统中提供追踪解决方案，并且兼容支持了 zipkin
 */
@EnableEurekaClient
@SpringBootApplication
@EnableZipkinServer
public class SpringCloudZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZipkinApplication.class, args);
	}
}
