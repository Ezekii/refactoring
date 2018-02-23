//package br.com.dxc.old;
//
//import javax.jms.Message;
//import javax.jms.TextMessage;
//
//import org.jboss.logging.Logger;
//
//import br.com.cresol.colmeia.administracao.ConstantesAdministracao;
//import br.com.cresol.colmeia.contacorrente.facade.AssinaturaFacade;
//import br.com.cresol.colmeia.core.exception.ApplicationException;
//import br.com.cresol.colmeia.core.exception.ColmeiaException;
//import br.com.cresol.colmeia.core.jms.BaseJMS;
//import br.com.cresol.colmeia.core.logging.LogBuilder;
//import br.com.cresol.colmeia.core.util.FacadeUtil;
//import br.com.cresol.colmeia.core.util.HibernateUtil;
//import br.com.cresol.colmeia.financeiro.facade.SicFacade;
//import br.com.cresol.colmeia.financeiro.rest.bean.AtualizaEmprestimoBean;
//import br.com.cresol.colmeia.financeiro.rest.bean.BloqueioDesbloqueioPgpafBean;
//import br.com.cresol.colmeia.financeiro.rest.bean.CancelaPropostaBean;
//import br.com.cresol.colmeia.financeiro.rest.bean.ConfesolServicosBean;
//import br.com.cresol.colmeia.financeiro.rest.bean.ImagemBean;
//import br.com.cresol.colmeia.financeiro.rest.bean.LiberacaoPropostaBean;
//import br.com.cresol.colmeia.financeiro.rest.bean.SicBean;
//import br.com.cresol.colmeia.financeiro.rest.bean.SinistroProagroBean;
//import br.com.cresol.colmeia.seguranca.facade.SegurancaFacade;
//import br.com.cresol.colmeia.seguranca.vo.UsuarioVO;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//
///**
// * Listener JMS para ler a fila do Confesol Servicos
// * 
// * @author Evandro Pires da Silva
// */
//public class ConfesolServicosListener extends BaseJMS {
//
//	private static final String QUEUE_NAME = "confesolServicos";
//	private static final String PROCESSO_ATUALIZAR_EMPRESTIMO = "Atualizar Empréstimo";
//	private static final String PROCESSO_CANCELAR_EMPRESTIMO = "Cancelar Proposta";
//	private static final String PROCESSO_LIBERAR_EMPRESTIMO = "Liberar Proposta";
//	private static final Logger LOGGER = Logger
//			.getLogger(ConfesolServicosListener.class);
//
//	public ConfesolServicosListener() {
//		super(QUEUE_NAME);
//	}
//
//	public void executar(Message msg) {
//		try {
//			if (msg instanceof TextMessage) {
//				String solicitacao = ((TextMessage) msg).getText();
//				solicitacao = new String(solicitacao.getBytes("ISO-8859-1"),
//						"ISO-8859-1");
//
//				Gson gson = new GsonBuilder().create();
//				ConfesolServicosBean bean = gson.fromJson(solicitacao,
//						ConfesolServicosBean.class);
//				processarMensagem(bean);
//			}
//		} catch (ColmeiaException e) { // NOSONAR
//			// excecao de negocio, nao deve relancar
//			LOGGER.info(e.getMessage());
//		} catch (Exception e) {
//			LOGGER.error(e.getMessage(), e);
//		}
//	}
//
//	public void processarMensagem(ConfesolServicosBean bean)
//			throws ColmeiaException, ApplicationException {
//		if (bean.getSicBean() != null) {
//			this.processarMensagemSic(bean.getSicBean());
//		} else if (bean.getImagemBean() != null) {
//			this.processarMensagemImagem(bean.getImagemBean());
//		}
//	}
//
//	/**
//	 * Processa as mensagens referentes ao documento de assinatura do associado.
//	 * 
//	 * @param bean
//	 * @throws ColmeiaException
//	 * @throws ApplicationException
//	 */
//	private void processarMensagemImagem(ImagemBean imagemBean)
//			throws ColmeiaException, ApplicationException {
//		AssinaturaFacade assinaturaFacade = AssinaturaFacade.newInstance(this
//				.obterFacadeUtil());
//
//		assinaturaFacade
//				.atualizarDocumentoAssinaturaAssociadoRetorno(imagemBean);
//	}
//
//	/**
//	 * Processa as mensagens referentes ao sic.
//	 * 
//	 * @param bean
//	 * @throws ColmeiaException
//	 * @throws ApplicationException
//	 */
//	private void processarMensagemSic(SicBean bean) throws ColmeiaException,
//			ApplicationException {
//		SicFacade facade = SicFacade.newInstance(obterFacadeUtil());
//		if (bean.getAtualizar() != null) {
//			for (AtualizaEmprestimoBean atualiza : bean.getAtualizar()) {
//				facade.atualizarEmprestimo(atualiza);
//				validarTransacaoAberta(PROCESSO_ATUALIZAR_EMPRESTIMO, atualiza);
//			}
//		} else if (bean.getCancelar() != null) {
//			for (CancelaPropostaBean cancela : bean.getCancelar()) {
//				facade.cancelarEmprestimo(cancela);
//				validarTransacaoAberta(PROCESSO_CANCELAR_EMPRESTIMO, cancela);
//			}
//		} else if (bean.getLiberar() != null) {
//			for (LiberacaoPropostaBean libera : bean.getLiberar()) {
//				facade.liberarProposta(libera);
//				validarTransacaoAberta(PROCESSO_LIBERAR_EMPRESTIMO, libera);
//			}
//		} else if (bean.getBloqueioDesbloqueio() != null) {
//			BloqueioDesbloqueioPgpafBean bloqueioDesbloqueioPgpafBean = bean
//					.getBloqueioDesbloqueio();
//			facade.processarBloqueioDesbloqueioDescontosPgpaf(
//					bloqueioDesbloqueioPgpafBean.getNumeroContrato(),
//					bloqueioDesbloqueioPgpafBean.getProcesso());
//		} else if (bean.getSinistroProagro() != null) {
//			SinistroProagroBean sinistroProagroBean = bean.getSinistroProagro();
//			facade.processarRegistroSinistroProagro(
//					sinistroProagroBean.getNumeroContrato(),
//					sinistroProagroBean.getProcesso(),
//					sinistroProagroBean.getValorRessarcimentoFinanciamento(),
//					sinistroProagroBean.getValorRessarcimentoRecProprios(),
//					sinistroProagroBean.getValorCustasVistoria(),
//					sinistroProagroBean.getRecursosPropriosServicos(),
//					sinistroProagroBean.getValorParcelaInvestimento(),
//					sinistroProagroBean.getDescontoJuros(),
//					sinistroProagroBean.getDescontoCapital());
//		}
//	}
//
//	/**
//	 * Valida se tem transacao aberta e forca o rollback
//	 * 
//	 * @param bean
//	 */
//	private void validarTransacaoAberta(String msg, Object proposta) {
//
//		if (HibernateUtil.isCurrentTransaction()) {
//			HibernateUtil.forceRollback();
//			String json = new GsonBuilder().create().toJson(proposta);
//
//			try {
//				LOGGER.error(LogBuilder
//						.create("SIC - Existe transacao aberta ao final do laço")
//						.payload("processo", msg).payload("objeto", json)
//						.build());
//
//			} catch (Exception e) {
//				LOGGER.error(e.getMessage(), e);
//			}
//		}
//	}
//
//	/**
//	 * Monta um FacadeUtil
//	 * 
//	 * @param codigoCooperativa
//	 * @return
//	 * @throws ColmeiaException
//	 * @throws ApplicationException
//	 */
//	protected FacadeUtil obterFacadeUtil() throws ColmeiaException,
//			ApplicationException {
//		UsuarioVO usuarioVO = new SegurancaFacade(null)
//				.carregarUsuario(ConstantesAdministracao.USUARIO_GEA);
//
//		FacadeUtil facade = new FacadeUtil();
//		facade.setUsuarioGEA(true);
//		facade.setUsuarioVO(usuarioVO);
//		facade.setCodUsuario(usuarioVO.getCodusuario());
//		facade.setUsuario(usuarioVO.getLoginusuario());
//		facade.setUsuarioAgendamento(usuarioVO.getLoginusuario());
//		return facade;
//	}
//
//}
