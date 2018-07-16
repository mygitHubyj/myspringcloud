package springcloudribbon.springcloudribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.Clock;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@ComponentScan("com")
@EnableHystrix // 断路器
@EnableHystrixDashboard//断路器仪表盘
public class SpringCloudRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudRibbonApplication.class, args);
	}
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@Bean
	public IRule testRibbonRule(){
		System.out.print("testRibbonRule++++++++++++++++++++++++++++");
		return new RandomRule();//这里配置策略，和配置文件对应
	}

	/**
	 * 服务链路追踪(Spring Cloud Sleuth)必须要这个
	 * @return
	 * 使用zipkin涉及几个概念

	 Span:基本工作单元，一次链路调用(可以是RPC，DB等没有特定的限制)创建一个span，通过一个64位ID标识它，
	 span通过还有其他的数据，例如描述信息，时间戳，key-value对的(Annotation)tag信息，parent-id等,其中parent-id
	 可以表示span调用链路来源，通俗的理解span就是一次请求信息
	spring.sleuth.sampler.percentage=0.1

	在开发调试期间，通常会收集全部跟踪信息输出到远程仓库，我们可以将其值设置为1，或者也可以通过创建AlwaysSampler的Bean（它实现的isSampled方法始终返回true）来覆盖默认的PercentageBasedSampler策略，比如：
	 * @return
	 */
	@Bean
	public AlwaysSampler defaultSampler(){
		return new AlwaysSampler();
	}
//	@Autowired
//	RestTemplate restTemplate;
//	@RequestMapping(value = "/hi")
//	public String hi(@RequestParam String name){
//		return this.hiService(name);
//	}
//
//	public String hiService(String name) {
//		return this.restTemplate.getForObject("http://hello-service/hi?name="+name,String.class);
//	}
}
