package br.com.dxc.core.jms.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;



public abstract class BaseJMSReceiver {

	private static final Logger LOGGER = LoggerFactory.getLogger(BaseJMSReceiver.class);
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	String queue;
	
	public BaseJMSReceiver(String queue) {
		this.queue = queue;
	}
	
	/**
	 * Sobrescrever para realizar a lógica necessária
	 * 
	 * @param msg
	 */
	public abstract void execute(Message message);
	
	/**
	 * Recebe a mensagem do JMS
	 */
	public void receive() {
		Message message = (Message)jmsTemplate.receiveAndConvert(queue);
		
		if (message instanceof TextMessage)
			try {
				LOGGER.info("received message='{}', going to do something with this...", ((TextMessage) message).getText());
			} catch (JMSException e) {
				//TODO
				e.printStackTrace();
			}
		
		execute(message);
	}
}