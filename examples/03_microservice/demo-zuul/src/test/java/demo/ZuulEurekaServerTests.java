package demo;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ZuulEurekaServer.class)
public class ZuulEurekaServerTests {

	@Ignore
	@Test
	public void contextLoads() {
	}

}
