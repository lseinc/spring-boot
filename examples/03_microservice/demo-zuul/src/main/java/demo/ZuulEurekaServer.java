package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableAutoConfiguration
@EnableZuulProxy
@EnableHystrix
@EnableTurbine
@EnableEurekaServer
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableConfigurationProperties
public class ZuulEurekaServer {

    public static void main(String[] args) {
        SpringApplication.run(ZuulEurekaServer.class, args);
    }
}
