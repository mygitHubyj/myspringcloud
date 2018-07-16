package springcloudservercolony.springcloudservercolony;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringCloudServerColonyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudServerColonyApplication.class, args);
	}
}
