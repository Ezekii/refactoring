//package br.com.dxc.core.lock;
//
//import java.math.BigDecimal;
//import java.util.Random;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import br.com.cresol.colmeia.core.conf.AppConfig;
//import br.com.cresol.colmeia.core.constantes.Modulo;
//import br.com.cresol.colmeia.core.exception.ApplicationException;
//import br.com.cresol.colmeia.core.exception.ColmeiaException;
//import br.com.cresol.colmeia.core.logging.LogBuilder;
//import br.com.cresol.colmeia.dao.GenericaHibernateDAO.MetodoLock;
//
//public class ColmeiaAdvisoryLock {
//
//	private static final Logger LOG = LoggerFactory
//			.getLogger(ColmeiaAdvisoryLock.class);
//
//	private static final String SEPARADOR_PREFIXO = ",";
//	private static final String PREFIXOS_LOCK_INCONDICIONAL = "advisory.lock.incondicional.prefixos";
//	private static final String NUMERO_MAXIMO_TENTIVAS_LOCK = "advisory.lock.numero.maximo.tentativas";
//	private static final String INTERVALO_TEMPO_ENTRE_TENTIVAS_LOCK = "advisory.lock.intervalo.entre.tentativas";
//
//	public Boolean tryAcquireLock(MetodoLock metodoLock, Integer chave,
//			Integer numeroMaximoTentativas) throws ApplicationException,
//			ColmeiaException {
//		AdvisoryLockMethod advisoryLockMethod = new AdvisoryLockMethod();
//		advisoryLockMethod.setChaveInt(chave);
//		advisoryLockMethod.setMetodoLock(metodoLock);
//		return tryAcquireLock(advisoryLockMethod, numeroMaximoTentativas);
//	}
//	
//	public Boolean tryAcquireLock(Long chave, Integer numeroMaximoTentativas)
//			throws ApplicationException, ColmeiaException {
//
//		AdvisoryLockKey advisoryLockKey = new AdvisoryLockKey();
//		advisoryLockKey.setChaveLong(chave);
//		return tryAcquireLock(advisoryLockKey, numeroMaximoTentativas);
//
//	}
//	
//	private Boolean tryAcquireLock(AdvisoryLockStrategy strategy,
//			Integer numeroMaximoTentativas)
//			throws ApplicationException, ColmeiaException {
//
//		if (verificarSeLockIncondicional()) {
//			strategy.acquireLock();
//			return true;
//		}
//
//		if (!executarTentativasLock(strategy, numeroMaximoTentativas)) {
//			throw new ColmeiaException(Modulo.MODULO_PADRAO, 10022, null);
//		}
//		return true;
//
//	}
//
//	private Boolean executarTentativasLock(AdvisoryLockStrategy strategy,
//			Integer numeroMaximoTentativas)
//			throws ApplicationException {
//
//		if (numeroMaximoTentativas == null) {
//			numeroMaximoTentativas = Integer.valueOf(AppConfig
//					.getConfiguracao(NUMERO_MAXIMO_TENTIVAS_LOCK));
//		}
//		Integer intervaloEntreTentativas = Integer.valueOf(AppConfig
//				.getConfiguracao(INTERVALO_TEMPO_ENTRE_TENTIVAS_LOCK));
//
//		int total = 0;
//
//		while (total <= numeroMaximoTentativas) {
//			if (strategy.tryAcquireLock()) {
//				return true;
//			}
//			
//			LOG.trace(LogBuilder.create("Tentativa de lock")
//					.payload("numeroTentativa", total + 1)
//					.payload("chaveInt", strategy.getChaveInt())
//					.payload("chaveLong", strategy.getChaveLong())
//					.payload("metodoLock", strategy.getMetodoLock()).build());
//			
//			try {
//				Integer intervalo = new Random().nextInt(15);
//				Thread.sleep(intervaloEntreTentativas
//						+ new BigDecimal(intervalo).pow(2).longValue());
//			} catch (InterruptedException e) {
//				LOG.warn(LogBuilder
//						.create("Nao foi possivel interromper a tentativa de lock.")
//						.payload("chaveInt", strategy.getChaveInt())
//						.payload("chaveLong", strategy.getChaveLong())
//						.payload("metodoLock", strategy.getMetodoLock())
//						.build());
//			}
//			total++;
//		}
//		return false;
//	}
//
//	private boolean verificarSeLockIncondicional() {
//		String threadName = Thread.currentThread().getName();
//
//		String configuracaoPrefixo = AppConfig
//				.getConfiguracao(PREFIXOS_LOCK_INCONDICIONAL);
//
//		String[] prefixos = configuracaoPrefixo.split(SEPARADOR_PREFIXO);
//
//		for (String prefixo : prefixos) {
//			if (threadName.contains(prefixo)) {
//				return true;
//			}
//		}
//		return false;
//	}
//
//}
