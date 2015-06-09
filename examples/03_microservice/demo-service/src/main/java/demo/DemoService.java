package demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.web.bind.annotation.*;

import com.google.common.net.MediaType;

import javax.ws.rs.*;

@SpringBootApplication
@EnableHystrix
@RestController
@EnableEurekaClient
@EnableCircuitBreaker
@EnableConfigurationProperties
@RequestMapping(value="/api")
public class DemoService {
	
	@Value("${spring.application.name}:${spring.application.instance_id:${random.value}}")
	private String instanceId;

    public static void main(String[] args) {
        SpringApplication.run(DemoService.class, args);
    }

    @RequestMapping(value="/hello")
    public String hello() {
    	System.out.println("+++ ["+instanceId+"] received /hello request!");
    	return "Hello World !";
    }

    @RequestMapping(value="/userInfo/{userId}")
    public String userInfo(@PathVariable("userId")String userId) {
        System.out.println("+++ ["+instanceId+"] received /userInfo request with userId="+userId+" !");
        String upper = "<null>";
        if (userId!=null) {
            upper = userId.toUpperCase();
        }
        return upper;
    }

}
