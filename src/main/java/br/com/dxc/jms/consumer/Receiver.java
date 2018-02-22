package br.com.dxc.jms.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;

public class Receiver {

	private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
	
	@JmsListener(destination = "${activemq.queue.helloworld}")
	public void receive(String message) {
		LOGGER.info("received message='{}', going to do something with this...", message);
	}
}