package br.com.dxc.core.jms.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

public class JMSSender {

	private static final Logger LOGGER = LoggerFactory.getLogger(JMSSender.class);

	@Autowired
	private JmsTemplate jmsTemplate;

	public void send(String destination, String message) {
		LOGGER.info("sending message='{}' to destination='{}'", message, destination);
		jmsTemplate.convertAndSend(destination, message);
	}
}