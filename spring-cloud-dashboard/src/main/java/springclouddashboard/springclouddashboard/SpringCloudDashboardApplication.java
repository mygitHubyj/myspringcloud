package springclouddashboard.springclouddashboard;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 在程序的入口ServiceHiApplication类，加上@EnableHystrix注解开启断路器，
 * 这个是必须的，并且需要在程序中声明断路点HystrixCommand；
 * 加上@EnableHystrixDashboard注解，开启HystrixDashboard
 */

/**
 * http://localhost:3333/hystrix 监控平台
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableHystrix
@EnableHystrixDashboard
public class SpringCloudDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudDashboardApplication.class, args);

	}

    @Value(value = "${server.port}")
    String port;
    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiError")
    public String home(@RequestParam String name) {
        return "hi "+name+",i am from port:" +port;
    }
    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
