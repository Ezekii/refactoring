//package br.com.cresol.colmeia.core.jms;
//
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;
//import java.util.concurrent.Callable;
//import java.util.concurrent.Executors;
//import java.util.concurrent.TimeUnit;
//
//import javax.jms.Connection;
//import javax.jms.JMSException;
//import javax.jms.Message;
//import javax.jms.MessageConsumer;
//import javax.jms.MessageListener;
//import javax.jms.ObjectMessage;
//import javax.jms.Queue;
//import javax.jms.QueueConnection;
//import javax.jms.Session;
//import javax.jms.TextMessage;
//
//import net.jodah.failsafe.Failsafe;
//import net.jodah.failsafe.RetryPolicy;
//import net.jodah.failsafe.function.CheckedConsumer;
//
//import org.hornetq.api.core.TransportConfiguration;
//import org.hornetq.api.jms.HornetQJMSClient;
//import org.hornetq.api.jms.JMSFactoryType;
//import org.hornetq.core.remoting.impl.invm.InVMConnectorFactory;
//import org.hornetq.core.remoting.impl.netty.NettyConnectorFactory;
//import org.hornetq.core.remoting.impl.netty.TransportConstants;
//import org.hornetq.jms.client.HornetQConnectionFactory;
//import org.jboss.logging.Logger;
//
//import br.com.cresol.colmeia.administracao.ConstantesAdministracao;
//import br.com.cresol.colmeia.core.exception.ApplicationException;
//import br.com.cresol.colmeia.core.exception.ColmeiaException;
//import br.com.cresol.colmeia.core.mensagem.MensagemPadrao;
//import br.com.cresol.colmeia.core.util.FacadeUtil;
//import br.com.cresol.colmeia.core.util.HibernateUtil;
//import br.com.cresol.colmeia.generalidades.facade.CooperativaFacade;
//import br.com.cresol.colmeia.generalidades.vo.CooperativaVO;
//import br.com.cresol.colmeia.seguranca.facade.UsuarioGrupoUnidadeFacade;
//import br.com.cresol.colmeia.seguranca.vo.UsuarioVO;
//
//import com.google.gson.GsonBuilder;
//
///**
// * Classe que serve de base para os listeners de JMS do Colmeia
// * 
// * @author Evandro Pires da Silva
// * 
// */
//public abstract class BaseJMS implements MessageListener {
//
//	private static final long CODIGO_CONFEDERACAO = 90L;
//
//	private static final int RETRY_DELAY = 10;
//
//	private static final Logger LOGGER = Logger.getLogger(BaseJMS.class);
//
//	private static final Set<BaseJMS> LISTENERS_REGISTRADOS = new HashSet<BaseJMS>();
//
//	private MessageConsumer consumer;
//	private Connection connection = null;
//	private Session session = null;
//	private Queue fila;
//	private String queueName;
//	private String[] hosts;
//	private String usuario;
//	private String senha;
//
//	public BaseJMS(String queueName, String... hosts) {
//		this.queueName = queueName;
//		this.hosts = hosts;
//	}
//
//	public BaseJMS(String queueName, String usuario, String senha,
//			String... hosts) {
//		this.queueName = queueName;
//		this.usuario = usuario;
//		this.senha = senha;
//		this.hosts = hosts;
//	}
//
//	/**
//	 * Inicializa o Listener
//	 * 
//	 * @param properties
//	 * @throws ApplicationException
//	 */
//	@SuppressWarnings("unchecked")
//	public void iniciar() {
//		RetryPolicy retryPolicy = new RetryPolicy().retryOn(JMSException.class)
//				.withDelay(RETRY_DELAY, TimeUnit.SECONDS);
//
//		Failsafe.with(retryPolicy).with(Executors.newScheduledThreadPool(1))
//				.onRetry(new RetryConsumer(this.getClass()))
//				.get(new Conectar());
//	}
//
//	/**
//	 * Classe para rodar asincronamente e conectar na fila JMS
//	 * 
//	 * @author Evandro Pires da Silva
//	 * 
//	 */
//	private class Conectar implements Callable<Object> {
//
//		private static final int INITIAL_CONNECT_ATTEMPTS = 3;
//
//		@Override
//		public Object call() throws Exception {
//			HornetQConnectionFactory cf = HornetQJMSClient
//					.createConnectionFactoryWithoutHA(JMSFactoryType.CF,
//							getTransportConfiguration());
//
//			cf.setReconnectAttempts(-1);
//			cf.setInitialConnectAttempts(INITIAL_CONNECT_ATTEMPTS);
//			cf.setAutoGroup(true);
//
//			QueueConnection qc;
//			if (usuario != null && senha != null) {
//				connection = cf.createConnection(usuario, senha);
//				qc = cf.createQueueConnection(usuario, senha);
//			} else {
//				connection = cf.createConnection();
//				qc = cf.createQueueConnection();
//			}
//
//			session = qc.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
//			fila = session.createQueue(queueName);
//			consumer = session.createConsumer(fila);
//			consumer.setMessageListener(BaseJMS.this);
//
//			connection.start();
//			qc.start();
//
//			LISTENERS_REGISTRADOS.add(BaseJMS.this);
//			return null;
//		}
//	}
//
//	/**
//	 * Responsavel por tomar acoes quando ocorre um retry de conexao com uma
//	 * fila JMS
//	 * 
//	 * @author Evandro Pires da Silva
//	 * 
//	 */
//	private class RetryConsumer implements CheckedConsumer<JMSException> {
//
//		private Class<? extends BaseJMS> clazz;
//
//		public RetryConsumer(Class<? extends BaseJMS> clazz) {
//			this.clazz = clazz;
//		}
//
//		@Override
//		public void accept(JMSException e) throws Exception {
//			LOGGER.error("Tentativa de iniciar a fila falhou. "
//					+ clazz.getSimpleName() + ". " + e.getMessage());
//		}
//	}
//
//	/**
//	 * Sobrescrever para realizar a logica necessaria
//	 * 
//	 * @param msg
//	 */
//	public abstract void executar(Message msg);
//
//	/**
//	 * Recebe a mensagem do JMS
//	 */
//	public void onMessage(Message msg) {
//		try {
//			executar(msg);
//		} finally {
//			if (HibernateUtil.isCurrentTransaction()) {
//				tratarTransacaoAberta(msg);
//			}
//		}
//	}
//
//	/**
//	 * Realiza o tratamento quando a trasacao esta aberta
//	 * 
//	 * @param msg
//	 */
//	private void tratarTransacaoAberta(Message msg) {
//		HibernateUtil.forceRollback();
//
//		String conteudo = null;
//		try {
//			if (msg instanceof TextMessage) {
//				conteudo = ((TextMessage) msg).getText();
//			} else if (msg instanceof ObjectMessage) {
//				conteudo = new GsonBuilder().create().toJson(
//						((ObjectMessage) msg).getObject());
//			}
//		} catch (JMSException e) {
//			LOGGER.error(e.getMessage(), e);
//		} finally {
//			LOGGER.error(MensagemPadrao.getInstance().getMessage(
//					"transacao.aberta", new String[] { conteudo }));
//		}
//	}
//
//	private TransportConfiguration[] getTransportConfiguration() {
//		if (hosts == null || hosts.length == 0) {
//			return new TransportConfiguration[] { new TransportConfiguration(
//					InVMConnectorFactory.class.getName()) };
//		}
//
//		TransportConfiguration[] configs = new TransportConfiguration[hosts.length];
//		for (int pos = 0; pos < hosts.length; pos++) {
//			String[] host = hosts[pos].split(":");
//			String hostName = host[0];
//			String port = host[1];
//
//			Map<String, Object> params = new HashMap<String, Object>();
//			params.put(TransportConstants.HOST_PROP_NAME, hostName);
//			params.put(TransportConstants.PORT_PROP_NAME, Integer.valueOf(port));
//
//			TransportConfiguration transportConfiguration = new TransportConfiguration(
//					NettyConnectorFactory.class.getName(), params);
//
//			configs[pos] = transportConfiguration;
//		}
//
//		return configs;
//	}
//
//}
