package demo;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.*;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.*;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableFeignClients
@EnableCircuitBreaker
@EnableConfigurationProperties
@RestController
public class DemoUI {
	
	@Value("${spring.application.name}:${spring.application.instance_id:${random.value}}")
	private String instanceId;

    @Autowired
    private DemoServiceClient client;

    public static void main(String[] args) {
        SpringApplication.run(DemoUI.class, args);
    }
    
    @RequestMapping(value="/hello")
    public String hello() {
    	System.out.println("+++ ["+instanceId+"] received /hello request!");
    	return "Hello World !";
    }

    @RequestMapping(value="/hello/{userId}")
    public String hello(@PathVariable("userId")String userId) {
        System.out.println("+++ ["+instanceId+"] received /hello request!");
        String name = client.getUserInfo(userId);
        return "Hello "+name+" !";
    }


    @FeignClient(url = "http://localhost:8080/demoservice")
    interface DemoServiceClient {
        @RequestMapping(method = RequestMethod.GET, value = "/api/userInfo/{userId}")
        String getUserInfo(@RequestParam("userId") String userId);

    }

}
