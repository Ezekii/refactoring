package br.com.dxc;

import org.apache.activemq.junit.EmbeddedActiveMQBroker;
import org.junit.AfterClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.dxc.jms.producer.Sender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringJmsApplicationTest {

	private static ApplicationContext applicationContext;
	
	@Autowired
	void setContext(ApplicationContext applicationContext) {
		SpringJmsApplicationTest.applicationContext = applicationContext;
	}
	
	@AfterClass
	public static void afterClass() {
		((ConfigurableApplicationContext) applicationContext).close();
	}
	
	@ClassRule
	public static EmbeddedActiveMQBroker broker = new EmbeddedActiveMQBroker();
	
	@Autowired
	private Sender sender;
	
	@Test
	public void testReceive() throws Exception {
		sender.send("helloworld.q", "Daleee");
	}
}