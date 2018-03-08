package br.com.dxc.constant;

import java.math.BigDecimal;

/**
 * Classe de constantes comuns das usadas no modulo de Conta Corrente.
 * 
 * @author Franscielly Benvenutti Eccel
 * @author Ivan Roberto da Silva
 */
public class ConstantesContaCorrente {

	public static final String ACAO_RECEBER_BOLETOS = "receberBoletos";
	public static final String ACAO_RECEBER_ARRECADACOES = "receberArrecadacoes";

	public static final String ACAO_CONFIGURAR_BANCOS = "configurarBancos";
	public static final String ACAO_CONFIGURAR_LEITURA_CMC7 = "configurarLeituraCmc7";

	public static final String TRANSFERENCIA_CONTAS_MESMO_CPF_CNPJ = "1";
	public static final String TRANSFERENCIA_CONTAS_DIFERENTE_CPF_CNPJ = "2";

	public static final String TRANSFERENCIA_DE_CC_PARA_CI = "1";
	public static final String TRANSFERENCIA_DE_CC_PARA_CC = "2";
	public static final String TRANSFERENCIA_DE_CC_PARA_CCA = "3";
	public static final String TRANSFERENCIA_DE_CI_PARA_CC = "5";

	public static final Integer RETIRAR_CONTRA_ORDEM = 1;
	public static final Integer ATUALIZAR_CONTRA_ORDEM = 2;

	public static final Integer BANCO_CODIGO_BB = 1;
	public static final Integer BANCO_CODIGO_CONFESOL = 133;
	public static final Long ISPB_CONFESOL = 10398952L;

	public static final Integer PREFIXO_AGENCIA_CONFESOL = 1;
	public static final Long CONTA_CORRENTE_CHEQUES_IRREGULARES = 10L;
	public static final Integer DV_CONTA_CORRENTE_CHEQUES_IRREGULARES = 8;
	public static final Integer CAMARA_SIRC_SP = 18;

	public static final String CAMARA_PAG = "PAG";
	public static final String CAMARA_STR = "STR";

	public static final String DIGITO_VERIFICADOR_X = "X";

	/**
	 * Constantes de controle de cobranca online
	 */
	public static final String CODIGO_PROCEDIMENTO_BB = "7100";
	public static final String CODIGO_PROCEDIMENTO_BRADESCO = "1115";

	/**
	 * Codigos bancos
	 */
	public static final String BB = "001";
	public static final String BRADESCO = "237";

	/**
	 * Constante do dominio de Situa��o da Cesta de Servi�o.
	 */
	public static final Integer DOMINIO_SITUACAO_CESTA_SERVICO = 2002;
	public static final String REGISTRO_SITUACAO_CESTA_SERVICO_ATIVO = "1";
	public static final String REGISTRO_SITUACAO_CESTA_SERVICO_INATIVO = "2";

	/**
	 * Constantes de Tipo Arquivo - Dominio 2053
	 */
	public static final Integer ID_REGISTRO_TIPO_ARQUIVO_DAD604 = 4689;
	public static final Integer ID_REGISTRO_TIPO_ARQUIVO_DCD604 = 4690;
	public static final Integer ID_REGISTRO_TIPO_ARQUIVO_DAD614 = 4736;

	/**
	 * Constante do dominio Seguradora.
	 */
	public static final Integer DOMINIO_SEGURADORA = 2083;
	public static final String REGISTRO_SEGURADORA_PRESTAMISTA_BASER = "1";
	public static final String REGISTRO_SEGURADORA_SOLISEG = "2";
	public static final String REGISTRO_SEGURADORA_CENTRALSEG = "3";
	/**
	 * Situa��o da Solicita��o de Talon�rio de Cheques
	 */
	public static final Integer DOMINIO_SITUACAO_SOLICITACAO_TALONARIO_CHEQUES = 2010;
	public static final String REGISTRO_SITUACAO_SOLICITACAO_TALONARIO_CHEQUES_TODOS = "Todos";
	public static final String REGISTRO_SITUACAO_SOLICITACAO_TALONARIO_CHEQUES_PENDENTE = "1";
	public static final String REGISTRO_SITUACAO_SOLICITACAO_TALONARIO_CHEQUES_CONFECCIONADO = "2";
	public static final String REGISTRO_SITUACAO_SOLICITACAO_TALONARIO_CHEQUES_ENTREGUE = "3";
	public static final String REGISTRO_SITUACAO_SOLICITACAO_TALONARIO_IRREGULAR = "4";
	public static final String REGISTRO_SITUACAO_SOLICITACAO_TALONARIO_CHEQUES_ENVIADO_CONFECCAO_BB = "5";
	public static final String REGISTRO_SITUACAO_SOLICITACAO_TALONARIO_CHEQUES_CONFECCIONADO_BB = "6";
	public static final String REGISTRO_SITUACAO_SOLICITACAO_TALONARIO_INCORPORADO = "7";
	public static final Integer ID_REGISTRO_SITUACAO_SOLICITACAO_TALONARIO_INCORPORADO = 4381;

	/**
	 * Dominio da Situacao do Cheque
	 */
	public static final Integer DOMINIO_SITUACAO_CHEQUE = 2011;
	public static final String REGISTRO_SITUACAO_CHEQUE_DISPONIVEL = "1";
	public static final String REGISTRO_SITUACAO_CHEQUE_DEVOLVIDO = "3";
	public static final String REGISTRO_SITUACAO_CHEQUE_CONTRA_ORDEM_COM_OP = "4";
	public static final String REGISTRO_SITUACAO_CHEQUE_CONTRA_ORDEM_SEM_OP = "5";
	public static final String REGISTRO_SITUACAO_CHEQUE_CANCELADO = "6";
	public static final String REGISTRO_SITUACAO_CHEQUE_COMPENSADO = "7";
	public static final Integer ID_REGISTRO_SITUACAO_CHEQUE_COMPENSADO = 4189;
	public static final String REGISTRO_SITUACAO_CHEQUE_LIQUIDADO = "8";
	public static final Integer ID_REGISTRO_SITUACAO_CHEQUE_LIQUIDADO = 4190;
	public static final String REGISTRO_SITUACAO_CHEQUE_PAGO = "9";
	public static final Integer ID_REGISTRO_SITUACAO_CHEQUE_PAGO = 4191;
	public static final String REGISTRO_SITUACAO_CHEQUE_REGISTRADO_CCF = "10";
	public static final String REGISTRO_SITUACAO_CHEQUE_BAIXADO_CCF = "11";
	public static final String REGISTRO_SITUACAO_CHEQUE_EM_ALTERACAO = "12";
	public static final String REGISTRO_SITUACAO_CHEQUE_INFORMACAO_AUSENTE_MIGRACAO = "13";
	public static final String REGISTRO_SITUACAO_CHEQUE_BLOQUEADO = "14";
	public static final String REGISTRO_SITUACAO_CHEQUE_PAGO_COM_TARIFA_DE_ACATO = "15";
	public static final String REGISTRO_SITUACAO_CHEQUE_DEVOLUCAO_INCONDICIONAL = "16";
	public static final String REGISTRO_SITUACAO_CHEQUE_INCORPORADO = "17";
	public static final String REGISTRO_DESCRICAO_SITUACAO_CHEQUE_DEVOLVIDO = "DEVOLVIDO";

	/**
	 * Dominio da Situacao Movimento do Cheque
	 */
	public static final Integer DOMINIO_SITUACAO_MOVIMENTO_CHEQUE = 2065;
	public static final String REGISTRO_SITUACAO_MOVIMENTO_CHEQUE_REGISTRADO = "1";
	public static final String REGISTRO_SITUACAO_MOVIMENTO_CHEQUE_DEVOLUCAO_FORCADA_BB = "2";
	public static final String REGISTRO_SITUACAO_MOVIMENTO_CHEQUE_PAGAMENTO_FORCADO_BB = "3";
	public static final String REGISTRO_SITUACAO_MOVIMENTO_CHEQUE_CONCILIADO = "4";
	public static final String REGISTRO_SITUACAO_MOVIMENTO_CHEQUE_CANCELADO = "5";
	public static final String REGISTRO_SITUACAO_MOVIMENTO_CHEQUE_GERADO = "7";

	/**
	 * Dominio da Quantidade de Folhas Auto Atendimento
	 */
	public static final Integer DOMINIO_QUANTIDADE_FOLHAS_AUTO_ATENDIMENTO = 2074;
	public static final String REGISTRO_QUANTIDADE_FOLHAS_AUTO_ATENDIMENTO_4_FOLHAS = "1";
	public static final String REGISTRO_QUANTIDADE_FOLHAS_AUTO_ATENDIMENTO_8_FOLHAS = "2";
	public static final String REGISTRO_QUANTIDADE_FOLHAS_AUTO_ATENDIMENTO_12_FOLHAS = "3";
	public static final String REGISTRO_QUANTIDADE_FOLHAS_AUTO_ATENDIMENTO_16_FOLHAS = "4";
	public static final String REGISTRO_QUANTIDADE_FOLHAS_AUTO_ATENDIMENTO_20_FOLHAS = "5";

	/**
	 * Dominio da Situacao do Cheque Depositado
	 */
	public static final Integer DOMINIO_SITUACAO_CHEQUE_DEPOSITADO = 2036;
	public static final String REGISTRO_SITUACAO_CHEQUE_DEPOSITADO_BLOQUEADO = "1";
	public static final String REGISTRO_SITUACAO_CHEQUE_DEPOSITADO_LIBERADO = "2";
	public static final String REGISTRO_SITUACAO_CHEQUE_DEPOSITADO_DEVOLVIDO = "3";
	public static final String REGISTRO_SITUACAO_CHEQUE_DEPOSITADO_A_COMPENSAR = "4";
	public static final String REGISTRO_SITUACAO_CHEQUE_DEPOSITADO_CONCLUIDO = "5";
	public static final String REGISTRO_SITUACAO_CHEQUE_DEPOSITADO_CONFIRMADO = "6";

	/**
	 * Dominio da Situacao do Cheque na Compensacao
	 */
	public static final Integer DOMINIO_SITUACAO_CHEQUE_NA_COMPENSACAO = 2048;
	public static final String REGISTRO_SITUACAO_CHEQUE_COMPENSACAO_CUSTODIADO = "1";
	public static final String REGISTRO_SITUACAO_CHEQUE_COMPENSACAO_RECUSADO = "2";
	public static final String REGISTRO_SITUACAO_CHEQUE_COMPENSACAO_LIQUIDADO = "3";
	public static final String REGISTRO_SITUACAO_CHEQUE_COMPENSACAO_DESCONTADO = "4";
	public static final String REGISTRO_SITUACAO_CHEQUE_COMPENSACAO_DEVOLVIDO = "5";
	public static final String REGISTRO_SITUACAO_CHEQUE_COMPENSACAO_EXCLUIDO = "6";
	public static final String REGISTRO_SITUACAO_CHEQUE_COMPENSACAO_RECEBIDO_PELO_BB = "7";
	public static final String REGISTRO_SITUACAO_CHEQUE_COMPENSACAO_EM_COMPENSACAO = "8";

	
	/**
	 * Dom�nio Situa��o Situa��o AcessoIB
	 */
	public static final Integer DOMINIO_SITUACAO_ACESSO_IB = 2100;
	public static final String REGISTRO_SITUACAO_ACESSO_IB_ATIVO = "1";
	public static final String REGISTRO_SITUACAO_ACESSO_IB_BLOQUEADO = "2";
	
	/**
	 * Dominio Situacao Movimento Cesta Servico
	 */
	public static final Integer DOMINIO_SITUACAO_MOVIMENTO_CESTA_SERVICO = 2080;
	public static final String REGISTRO_SITUACAO_MOVIMENTO_CESTA_SERVICO_AGENDADO = "1";
	public static final String REGISTRO_SITUACAO_MOVIMENTO_CESTA_SERVICO_REGISTRADO = "2";
	public static final String REGISTRO_SITUACAO_MOVIMENTO_CESTA_SERVICO_ESTORNADO = "3";

	/**
	 * Dominio Situacao Liberacao de Dispositivos para Internet Banking
	 */
	public static final Integer DOMINIO_SITUACAO_ASSOCIADO_DISPOSITIVO = 2091;
	public static final String REGISTRO_SITUACAO_ASSOCIADO_DISPOSITIVO_ATIVO = "1";
	public static final String REGISTRO_SITUACAO_ASSOCIADO_DISPOSITIVO_INATIVO = "2";
	public static final String REGISTRO_SITUACAO_ASSOCIADO_DISPOSITIVO_EXCLUIDO = "3";
	public static final String REGISTRO_SITUACAO_ASSOCIADO_DISPOSITIVO_BLOQUEADO = "4";

	/**
	 * Dominio Motivo da Situacao do Dispositivo Internet Banking.
	 */
	public static final Integer DOMINIO_MOTIVO_SITUACAO_DISPOSITIVO = 2110;
	public static final String REGISTRO_MOTIVO_SITUACAO_DISPOSITIVO_BLOQUEADO_MANUALMENTE = "1";
	public static final String REGISTRO_MOTIVO_SITUACAO_DISPOSITIVO_MARCADO_SUSPEITO_MANUALMENTE = "2";
	public static final String REGISTRO_MOTIVO_SITUACAO_DISPOSITIVO_MARCADO_FRAUDADOR_MANUALMENTE = "3";
	public static final String REGISTRO_MOTIVO_SITUACAO_DISPOSITIVO_MARCADO_SUSPEITO_AUTOMATICAMENTE = "4";
	public static final String REGISTRO_MOTIVO_SITUACAO_DISPOSITIVO_MARCADO_FRAUDADOR_AUTOMATICAMENTE = "5";
	public static final String REGISTRO_MOTIVO_SITUACAO_DISPOSITIVO_CANCELADO_MANUALMENTE = "6";
	public static final String REGISTRO_MOTIVO_SITUACAO_DISPOSITIVO_ATIVADO_MANUALMENTE = "7";

	/**
	 * Dominio Situacao do Acesso de Dispositivos para Internet Banking
	 */
	public static final Integer DOMINIO_SITUACAO_ACESSO_DISPOSITIVO = 2102;
	public static final String REGISTRO_SITUACAO_ACESSO_DISPOSITIVO_TEMPO_INDETERMINADO = "1";
	public static final String REGISTRO_SITUACAO_ACESSO_DISPOSITIVO_POR_DIAS = "2";
	public static final String REGISTRO_SITUACAO_ACESSO_DISPOSITIVO_SOMENTE_UM = "3";

	/**
	 * Dominio Situacao Senha Eletronica
	 */
	public static final Integer DOMINIO_SITUACAO_SENHA_ELETRONICA = 2092;
	public static final String REGISTRO_SITUACAO_SENHA_ELETRONICA_ATIVA = "1";
	public static final String REGISTRO_SITUACAO_SENHA_ELETRONICA_BLOQUEADA = "2";
	public static final String REGISTRO_SITUACAO_SENHA_ELETRONICA_CANCELADA = "3";

	/**
	 * Dominio Situacao Associado Senha Eletronica
	 */
	public static final Integer DOMINIO_SITUACAO_ASSOCIADO_SENHA_ELETRONICA = 2093;
	public static final String REGISTRO_SITUACAO_ASSOCIADO_SENHA_ELETRONICA_SENHA_CADASTRADA = "1";
	public static final String REGISTRO_SITUACAO_ASSOCIADO_SENHA_ELETRONICA_SENHA_ALTERADA = "2";
	public static final String REGISTRO_SITUACAO_ASSOCIADO_SENHA_ELETRONICA_SENHA_BLOQUEADA = "3";
	public static final String REGISTRO_SITUACAO_ASSOCIADO_SENHA_ELETRONICA_SENHA_DESBLOQUEADA = "4";

	/**
	 * Dominio Tipo Transacao do Limite de Transacoes
	 */
	public static final Integer DOMINIO_TIPO_TRANSACAO = 2099;
	public static final String REGISTRO_TIPO_TRANSACAO_TRANSFERENCIA_ENTRE_CONTAS_CORRENTES = "1";
	public static final String REGISTRO_TIPO_TRANSACAO_TED = "2";
	public static final String REGISTRO_TIPO_TRANSACAO_DOC = "3";
	public static final String REGISTRO_TIPO_TRANSACAO_PAGAMENTO_BOLETO = "4";
	public static final String REGISTRO_TIPO_TRANSACAO_APLICACAO = "5";
	public static final String REGISTRO_TIPO_TRANSACAO_RESGATE_APLICACAO = "6";
	public static final String REGISTRO_TIPO_TRANSACAO_PAGAMENTO_ARRECADACAO = "7";
	public static final String REGISTRO_TIPO_TRANSACAO_EMPRESTIMO_LIBERACAO = "8";
	public static final String REGISTRO_TIPO_TRANSACAO_EMPRESTIMO_LIQUIDACAO = "9";
	public static final String REGISTRO_TIPO_TRANSACAO_RECARGA_CELULAR = "10";

	/**
	 * Dominio Situacao Limite de Transacao
	 */
	public static final Integer DOMINIO_SITUACAO_LIMITE_TRANSACAO = 2098;
	public static final String REGISTRO_SITUACAO_LIMITE_TRANSACAO_ATIVA = "1";
	public static final String REGISTRO_SITUACAO_LIMITE_TRANSACAO_INATIVA = "2";

	/**
	 * Dominio Tipo de Ocorrencia da Contra-ordem
	 */
	public static final Integer DOMINIO_TIPO_CONTRA_ORDEM = 2017;
	public static final String REGISTRO_TIPO_CONTRA_ORDEM_MOTIVO_28_CONTRA_ORDEM_COM_BOLETIM = "1";
	public static final String REGISTRO_TIPO_CONTRA_ORDEM_MOTIVO_21_SUSTADO_A_PEDIDO_DO_EMITENTE_SEM_BOLETIM = "2";
	public static final String REGISTRO_TIPO_CONTRA_ORDEM_MOTIVO_20_PERDIDO_OU_ROUBADO_EM_BRANCO_COM_BOLETIM = "3";
	public static final String REGISTRO_TIPO_CONTRA_ORDEM_MOTIVO_70_CONTRA_ORDEM_PROVISORIA = "4";
	public static final String REGISTRO_TIPO_CONTRA_ORDEM_MOTIVO_30_FURTO_OU_ROUBO_DE_MALOTES = "5";
	public static final String REGISTRO_TIPO_CONTRA_ORDEM_MOTIVO_25_CANCELAMENTO_DE_TALONARIO_POR_PARTE_DO_BANCO_SACADO = "6";

	/**
	 * Dominio Motivo de contra-ordem de cheque
	 */
	public static final Integer DOMINIO_MOTIVO_CONTRA_ORDEM = 2012;
	public static final String REGISTRO_MOTIVO_CONTRA_ORDEM_FOLHA_DE_CHEQUE_CANCELADA_POR_SOLICITACAO_DO_CORRENTISTA = "20";
	public static final String REGISTRO_MOTIVO_CONTRA_ORDEM_CONTRA_ORDEM_OU_OPOSICAO_AO_PAGAMENTO = "21";
	public static final String REGISTRO_MOTIVO_CONTRA_ORDEM_BLOQUEIO_JUDICIAL_OU_DETERMINACAO_DO_BACEN = "24";
	public static final String REGISTRO_MOTIVO_CONTRA_ORDEM_CANCELAMENTO_DE_TALONARIO_POR_PARTE_DO_BANCO_SACADO = "25";
	public static final String REGISTRO_MOTIVO_CONTRA_ORDEM_CONTRA_ORDEM_OPOSICAO_PAGAMENTO_MOTIVOS_DE_FURTO_OU_ROUBO = "28";
	public static final String REGISTRO_MOTIVO_CONTRA_ORDEM_FURTO_OU_ROUBO_DE_MALOTES = "30";
	public static final String REGISTRO_MOTIVO_CONTRA_ORDEM_CANCELAMENTO = "40";
	public static final String REGISTRO_MOTIVO_CONTRA_ORDEM_PROVISORIA = "70";
	public static final String REGISTRO_MOTIVO_CONTRA_ORDEM_CANCELAMENTO_DOS_CHEQUES_COM_ENTEGRA_AO_BANCO_EMITENTE = "99";

	/**
	 * Dominio da Situacao da Conta Corrente
	 */
	public static final Integer DOMINIO_TIPO_CONTA_CORRENTE = 2013;
	public static final String REGISTRO_TIPO_CONTA_CORRENTE_PF = "1";
	public static final String REGISTRO_TIPO_CONTA_CORRENTE_PJ = "2";

	/**
	 * Dominio da Situa��o da Conta Corrente
	 */
	public static final Integer DOMINIO_SITUACAO_CONTA_CORRENTE = 2014;
	public static final String REGISTRO_SITUACAO_CONTA_CORRENTE_ATIVA = "1";
	public static final String REGISTRO_SITUACAO_CONTA_CORRENTE_BLOQUEADA = "2";
	public static final String REGISTRO_SITUACAO_CONTA_CORRENTE_ENCERRADA = "3";
	public static final String REGISTRO_SITUACAO_CONTA_CORRENTE_INTEGRALIZAR = "4";
	public static final String REGISTRO_SITUACAO_CONTA_CORRENTE_EM_ENCERRAMENTO = "5";
	public static final String REGISTRO_SITUACAO_CONTA_CORRENTE_CONTA_INTEGRACAO_RECUSADA = "6";
	public static final Integer ID_REGISTRO_SITUACAO_CONTA_CORRENTE_ATIVA = 4072;
	public static final Integer ID_REGISTRO_SITUACAO_CONTA_CORRENTE_ENCERRADA = 4074;
	public static final Integer ID_REGISTRO_SITUACAO_CONTA_CORRENTE_INTEGRALIZAR = 4099;

	/**
	 * Dominio da Situa��o da Conta Capital
	 */
	public static final Integer DOMINIO_SITUACAO_CONTA_CAPITAL = 2056;
	public static final String REGISTRO_SITUACAO_CONTA_CAPITAL_ATIVA = "1";
	public static final String REGISTRO_SITUACAO_CONTA_CAPITAL_INATIVA = "2";

	/**
	 * Dominio da Situacao da Conta Banc�ria
	 */
	public static final Integer DOMINIO_SITUACAO_CONTA_BANCARIA = 2016;
	public static final String REGISTRO_SITUACAO_CONTA_BANCARIA_ATIVA = "1";
	public static final String REGISTRO_SITUACAO_CONTA_BANCARIA_INATIVA = "2";

	/**
	 * Constantes do Comando do Cheque COO406.
	 */
	public static final Integer COMANDO_CHEQUE_COO406_CONTRA_ORDEM_COM_OCORRENCIA_POLICIAL = 5;
	public static final Integer COMANDO_CHEQUE_COO406_CONTRA_ORDEM_SEM_OCORRENCIA_POLICIAL = 6;
	public static final Integer COMANDO_CHEQUE_COO406_BAIXA_CONTRA_ORDEM = 7;
	public static final Integer COMANDO_CHEQUE_COO406_CADASTRAR_CHEQUE_CONFECCIONADO_COOPERATIVA = 9;
	public static final Integer COMANDO_CHEQUE_BAIXADO = 2;
	public static final Integer COMANDO_CHEQUE_LIQUIDADO_NA_COOPERATIVA = 4;
	public static final Integer COMANDO_CHEQUE_BAIXADO_OU_LIQUIDADO_NA_COOPERATIVA = 8;
	public static final Integer CODIGO_COMANDO_CHEQUE_10 = 10;
	public static final Integer CODIGO_COMANDO_CHEQUE_50 = 50;

	/**
	 * Constantes do Motivo do Cheque COO406.
	 */
	public static final String MOTIVO_CHEQUE_COO406_A = "A";
	public static final String MOTIVO_CHEQUE_COO406_J = "J";
	public static final String MOTIVO_CHEQUE_COO406_P = "P";
	public static final String MOTIVO_CHEQUE_COO406_C = "C";

	/**
	 * Dominio da Situacao da Conta Bancaria
	 */
	public static final Integer DOMINIO_SITUACAO_LANCAMENTO = 2009;
	public static final String REGISTRO_SITUACAO_LANCAMENTO_ORIGINAL = "1";
	public static final String REGISTRO_SITUACAO_LANCAMENTO_ALTERADO = "2";
	public static final String REGISTRO_SITUACAO_LANCAMENTO_EXCLUIDO = "3";
	public static final String REGISTRO_SITUACAO_LANCAMENTO_POS_FECHAMENTO = "4";

	/**
	 * Dominio da Situacao SIRC
	 */
	public static final Integer DOMINIO_SITUACAO_SIRC = 2006;
	public static final String REGISTRO_SITUACAO_SIRC_ATIVO = "1";

	/**
	 * Dominio da Situacao Conta Corrente
	 */
	public static final Integer DOMINIO_CESTA_SERVICOS_BB = 2023;
	public static final String REGISTRO_CESTA_SERVICOS_BB_UM = "1";
	public static final String REGISTRO_CESTA_SERVICOS_BB_DOIS = "2";
	public static final String REGISTRO_CESTA_SERVICOS_BB_TRES = "3";

	/**
	 * Dominio da Situacao Conta Corrente
	 */
	public static final Integer DOMINIO_CATEGORIA_CONTA_CORRENTE = 2024;
	public static final String REGISTRO_CONTA_CORRENTE_PRINCIPAL = "1";
	public static final String REGISTRO_CONTA_CORRENTE_SECUNDARIA = "2";
	public static final String REGISTRO_CONTA_CORRENTE_COMPENSACAO_SPB = "3";

	/**
	 * Dominio da Situacao Bloqueio de D�bitos
	 */
	public static final Integer DOMINIO_BLOQUEIO_DE_DEBITOS = 2105;
	public static final String REGISTRO_CONTA_CORRENTE_BLOQUEADO = "1";
	public static final String REGISTRO_CONTA_CORRENTE_DESBLOQUEADO = "2";
	public static final Integer REGISTRO_ID_CONTA_CORRENTE_DESBLOQUEADO = 4517;
	public static final String REGISTRO_CONTA_CORRENTE_DESBLOQUEAR = "3";
	public static final Integer REGISTRO_ID_CONTA_CORRENTE_DESBLOQUEAR = 4518;
	public static final String REGISTRO_CONTA_CORRENTE_BLOQUEADO_JUDICIAL = "4";

	/**
	 * Constante do dominio de Motivo de alteracao da situacao da conta corrente
	 */
	public static final Integer DOMINIO_MOTIVO_ALTERACAO_SITUACAO_CONTA_CORRENTE = 2026;
	public static final String REGISTRO_MOTIVO_ALTERACAO_SITUACAO_CONTA_CORRENTE_COMANDO = "1";
	public static final String REGISTRO_MOTIVO_ALTERACAO_SITUACAO_CONTA_CORRENTE_DATA_VENCIMENTO_EXPIRADA = "2";
	public static final String REGISTRO_MOTIVO_ALTERACAO_SITUACAO_CONTA_CORRENTE_SISTEMA = "3";

	public static final Integer DOMINIO_TIPO_TITULAR_CONTA_CORRENTE = 2033;
	public static final String REGISTRO_TIPO_TITULAR_CONTA_CORRENTE_PESSOA = "1";
	public static final String REGISTRO_TIPO_TITULAR_CONTA_CORRENTE_ASSOCIADO = "2";
	public static final String REGISTRO_TIPO_TITULAR_CONTA_CORRENTE_COMPOSICAO_FAMILIAR = "3";

	public static final Integer DOMINIO_TITULARIDADE_CONTA_CORRENTE = 2035;
	public static final String REGISTRO_TITULARIDADE_CONTA_CORRENTE_PRIMEIRO_TITULAR = "1";
	public static final String REGISTRO_TITULARIDADE_CONTA_CORRENTE_SEGUNDO_TITULAR = "2";
	public static final String REGISTRO_TITULARIDADE_CONTA_CORRENTE_TERCEIRO_TITULAR = "3";

	/**
	 * Dominio de tipo do extrato
	 */
	public static final Integer DOMINIO_TIPO_DO_EXTRATO = 2038;
	public static final String REGISTRO_TIPO_DO_EXTRATO_CONTA_CORRENTE = "1";
	public static final String REGISTRO_TIPO_DO_EXTRATO_CONTA_CAPITAL = "2";
	public static final String REGISTRO_TIPO_DO_EXTRATO_CONTA_INVESTIMENTO = "3";
	public static final String REGISTRO_TIPO_DO_EXTRATO_CAPTACOES = "4";
	public static final String REGISTRO_TIPO_DO_EXTRATO_CAPTACOES_CONSOLIDADAS = "5";

	/**
	 * Dominio Situacao Titular Conta Correnet
	 */
	public static final Integer DOMINIO_SITUACAO_TITULAR_CONTA_CORRENTE = 2039;
	public static final String REGISTRO_SITUACAO_TITULAR_CONTA_CORRENTE_ATIVO = "1";
	public static final String REGISTRO_SITUACAO_TITULAR_CONTA_CORRENTE_EXCLUIDO = "2";

	/**
	 * Dominio de periodo do extrato
	 */
	public static final Integer DOMINIO_PERIODO_DO_EXTRATO = 2037;
	public static final String REGISTRO_PERIODO_DO_EXTRATO_SEMANAL = "1";
	public static final String REGISTRO_PERIODO_DO_EXTRATO_MENSAL = "2";
	public static final String REGISTRO_PERIODO_DO_EXTRATO_PERIODO = "3";

	/**
	 * Dom�nio da Situacao do Caixa
	 */
	public static final Integer DOMINIO_SITUACAO_CAIXA = 2008;
	public static final String REGISTRO_SITUACAO_CAIXA_AUTORIZADA_ABERTURA = "1";
	public static final String REGISTRO_SITUACAO_CAIXA_ABERTO = "2";
	public static final String REGISTRO_SITUACAO_CAIXA_AUTORIZADO_FECHAMENTO = "3";
	public static final String REGISTRO_SITUACAO_CAIXA_FECHADO_COM_AJUSTES = "4";
	public static final String REGISTRO_SITUACAO_CAIXA_FECHADO = "5";
	public static final String REGISTRO_SITUACAO_CAIXA_FECHAMENTO_FORCADO = "6";
	public static final String REGISTRO_SITUACAO_CAIXA_FECHAMENTO_SEM_AUTORIZACAO = "7";

	/**
	 * Dom�nio da Situacao do Tipo de Caixa
	 */
	public static final Integer DOMINIO_TIPO_CAIXA = 2117;
	public static final String REGISTRO_TIPO_CAIXA_CAIXA = "1";
	public static final String REGISTRO_TIPO_CAIXA_ATM = "2";

	/**
	 * OPERACOES TESOURARIA / CAIXA / BANCO
	 */
	public static final Integer OPERACAO_TRANSFERENCIA_TESOURARIA_CAIXA = 1;
	public static final Integer OPERACAO_NUMERARIO_FINAL_CAIXA = 2;
	public static final Integer OPERACAO_DEPOSITO_EM_DINHEIRO = 3;
	public static final Integer OPERACAO_DEPOSITO_EM_CHEQUE = 4;
	public static final Integer OPERACAO_DEPOSITO_EM_CHEQUE_EM_OUTROS_BANCOS = 5;
	public static final Integer OPERACAO_TARIFA_CONTA_CORRENTE = 6;
	public static final Integer OPERACAO_JUROS_CHEQUE_ESPECIAL = 7;
	public static final Integer OPERACAO_TRANSFERENCIA_CONTA_CORRENTE_PARA_CONTA_CAPITAL = 8;
	public static final Integer OPERACAO_TRANSFERENCIA_CONTAS_MESMO_TITULAR = 9;
	public static final Integer OPERACAO_TRANSFERENCIA_ENTRE_CONTAS_INVESTIMENTO_MESMO_TITULAR = 10;
	public static final Integer OPERACAO_TRANSFERENCIA_CONTA_CORRENTE_PARA_CONTA_INVESTIMENTO = 11;
	public static final Integer OPERACAO_TRANSFERENCIA_CONTA_INVESTIMENTO_PARA_CONTA_CORRENTE = 12;
	public static final Integer OPERACAO_REVERSAO_REGISTRO_INICIAL_COTA_PARTE_PARA_CONTA_CORRENTE = 13;
	public static final Integer OPERACAO_RESGATE_CONTAS_CAPITAL = 14;
	public static final Integer OPERACAO_ADIANTAMENTO_VIAGENS = 16;
	public static final Integer OPERACAO_FECHAMENTO_CAIXA = 18;
	public static final Integer OPERACAO_RECOLHIMENTO_TESOURARIA = 20;
	public static final Integer OPERACAO_SUPRIMENTO_TESOURARIA = 21;
	public static final Integer OPERACAO_SUPRIMENTO_TESOURARIA_PAC = 22;
	public static final Integer OPERACAO_RECOLHIMENTO_TESOURARIA_PAC = 23;
	public static final Integer OPERACAO_REGISTRO_DE_FALTAS_CAIXA = 24;
	public static final Integer OPERACAO_REGISTRO_DE_SOBRAS_CAIXA = 26;
	public static final Integer OPERACAO_REGULARIZACAO_SOBRAS_CAIXA = 27;
	public static final Integer OPERACAO_RECOLHIMENTO_CHEQUES_TODOS = 28;
	public static final Integer OPERACAO_RECOLHIMENTO_CHEQUES_MENORES = 29;
	public static final Integer OPERACAO_RECOLHIMENTO_CHEQUES_MAIORES = 30;
	public static final Integer OPERACAO_RECOLHIMENTO_CHEQUES_NACIONAL = 31;
	public static final Integer OPERACAO_SAQUE_CHEQUE_CRESOL = 32;
	public static final Integer OPERACAO_SAQUE_CHEQUE_AVULSO = 33;
	public static final Integer OPERACAO_TRANSFERENCIA_CONTAS_TITULARIDADES_DIFERENTES = 34;
	public static final Integer OPERACAO_REGULARIZACAO_DIFERENCA_COM_REGISTRO_EM_PREJUIZO = 35;
	public static final Integer OPERACAO_REGULARIZACAO_DIFERENCA_COM_PAGAMENTO_PELO_RESPONSAVEL = 36;
	public static final Integer OPERACAO_DEVOLUCAO_CHEQUE = 43;
	public static final Integer OPERACAO_PARCELAS_EMPRESTIMOS = 48;
	public static final Integer OPERACAO_COMISSOES_DE_EMPRESTIMOS_E_FINANCIAMENTOS = 51;
	public static final Integer OPERACAO_PREMIO_SEGURO_PROAGRO = 54;
	public static final Integer OPERACAO_JUROS_EMPRESTIMOS_FINANCIAMENTOS = 56;
	public static final Integer OPERACAO_MULTA_EMPRESTIMOS_FINANCIAMENTOS = 57;
	public static final Integer OPERACAO_TARIFA_ALTERACOES_EMPRESTIMOS_FINANCIAMENTOS = 58;
	public static final Integer OPERACAO_LIBERACOES_CONTRATOS_ATRAVES_CREDITO_EM_CC = 59;
	public static final Integer OPERACAO_SUBSTITUIDO_PELO_1505_RECEBTO_EMPRESTIMO = 60;
	public static final Integer OPERACAO_TARIFA_EMISSAO_CCB = 61;
	public static final Integer OPERACAO_DEVOLUCAO_REGISTRO_INICIAL_COTAS_PARTE = 62;
	public static final Integer OPERACAO_REGISTRO_INICIAL_COTAS_CAPITAL = 63;
	public static final Integer OPERACAO_TARIFA_EMPRESTIMOS_FINANCIAMENTOS = 64;
	public static final Integer OPERACAO_DESPESAS_LAUDO_PERICIAL = 81;
	public static final Integer OPERACAO_REBATE_OPERACOES_RURAIS = 84;
	public static final Integer OPERACAO_SALDO_TRANSFERIDO_PREJUIZO_CC = 85;
	public static final Integer OPERACAO_TARIFA_ALIENACAO_VEICULO = 100;
	public static final Integer OPERACAO_ESTORNO_CHEQUE_DEPOSITADO_POR_CAIXA = 102;
	public static final Integer OPERACAO_EXCLUSAO_CCF = 106;
	public static final Integer OPERACAO_TARIFA_DE_EMISSAO_DE_TALONARIO = 107;
	public static final Integer OPERACAO_TARIFA_CHEQUE_SUPERIOR = 111;
	public static final Integer OPERACAO_TARIFA_CHEQUE_INFERIOR = 1111;
	public static final Integer OPERACAO_BB_RESGATE_CENTRALIZADA = 123;
	public static final Integer OPERACAO_TRANSFERENCIA_ENTRE_CONTAS = 135;
	public static final Integer OPERACAO_INTEGRALIZACAO_CAPITAL_PROCAPCRED = 144;
	public static final Integer CAPITALIZACAO_SOBRAS_EXERCICIO = 147;
	public static final Integer OPERACAO_JUROS_AO_CAPITAL = 148;
	public static final Integer OPERACAO_CREDITO_DOACAO_PAGAMENTOS_ACORDOS_OUTROS = 154;
	public static final Integer OPERACAO_PGTO_PARCELA_EMPRESTIMO_DEBITO_AUTOMATICO = 157;
	public static final Integer OPERACAO_PGTO_JUROS_EMPRESTIOMO_COMERCIAL_ROTATIVO_DEBITO_AUTOMATICO = 535;
	public static final Integer OPERACAO_CHEQUE_COMPENSADO = 160;
	public static final Integer OPERACAO_DESBLOQUEIO_CHEQUE_DEPOSITADO = 163;
	public static final Integer OPERACAO_DESBLOQUEIO_CHEQUE_DEPOSITADO_ONLINE = 563;
	public static final Integer OPERACAO_TRANSFERENCIA_CONTAS_BANCARIAS = 164;
	public static final Integer OPERACAO_DEPOSITO_CHEQUE_DESCONTADO = 199;
	public static final Integer OPERACA0_ENTREGA_TALONARIO_CHEQUE = 219;
	public static final Integer OPERACAO_PAGAMENTO_PARCELAS_CONTRATO_BRDE = 236;
	public static final Integer OPERACAO_PAGAMENTO_PARCELAS_EMPRESTIMOS_BNDES = 237;
	public static final Integer OPERACAO_LANCAMENTO_TARIFA_DE_CANCELAMENTO_DE_INCLUSAO_NO_CCF = 240;
	public static final Integer OPERACAO_DEBITO_TARIFA_ACATO_CHEQUE = 247;
	public static final Integer OPERACAO_PAGAMENTO_PARCELA_DESCONTO_CHEQUES = 248;
	public static final Integer OPERACAO_ALIVIO_COBAN_TITULOS_ACIMA_10_MIL = 264;
	public static final Integer OPERACAO_ESTORNO_PAGAMENTO_PARCELAS_CONTRATO = 267;
	public static final Integer REGISTRO_DEVOLUCAO_CHEQUE_DEPOSITADO_NAO_COMPENSADO = 289;
	public static final Integer OPERACAO_REAPRESENTACAO_CHEQUE_DESCONTADO = 299;
	public static final Integer OPERACAO_RESERVA_DE_VALORES_CONTAS_A_PAGAR = 316;
	public static final Integer OPERACAO_REBLOQUEIO_DE_CHEQUES_D = 363;
	public static final Integer OPERACAO_REBLOQUEIO_DE_CHEQUES_C = 364;
	public static final Integer OPERACAO_RATEIO_DE_PERDAS = 439;
	public static final Integer OPERACAO_SOBRA_OPERACOES_DESCONTO_CHEQUES = 440;
	public static final Integer OPERACAO_IOF_CARTAO_DE_CREDITO = 870;
	public static final Integer OPERACAO_AJUSTE_BLOQUEADO_CODIGO_INTEGRACAO = 997;
	public static final Integer OPERACAO_AJUSTE_BLOQUEADO_CODIGO_INTEGRACAO_C = 998;
	public static final Integer OPERACAO_APROVACAO_ASSOCIADO = 1501;
	public static final Integer OPERACAO_DESFILIACAO_ASSOCIADO = 1502;
	public static final Integer OPERACAO_USO_LIMITE_CONTA_CORRENTE = 1561;
	public static final Integer OPERACAO_AMORTIZACAO_USO_LIMITE_CONTA_CORRENTE = 1562;
	public static final Integer OPERACAO_EXCESSO_SOBRE_LIMITE = 1580;
	public static final Integer OPERACAO_ADIANTAMENTOS_A_DEPOSITANTES = 1581;
	public static final Integer OPERACAO_LANCAMENTO_LIMITE_CREDITO_A_LIBERAR = 1586;
	public static final Integer OPERACAO_AMORTIZACAO_LIMITE_CREDITO_A_LIBERAR = 1589;
	public static final Integer OPERACAO_USO_ADIANTAMENTO_A_DEPOSITANTES = 1620;
	public static final Integer OPERACAO_AMORTIZACAO_USO_ADIANTAMENTO_A_DEPOSITANTES = 1621;
	public static final Integer OPERACAO_DEBITO_AUTOMATICO_DISTRIBUICAO_PERDAS = 1655;
	public static final Integer OPERACAO_DEBITO_AUTOMATICO_DISTRIBUICAO_SOBRAS_CONTA_CORRENTE = 1656;
	public static final Integer OPERACAO_DEBITO_AUTOMATICO_DISTRIBUICAO_SOBRAS_CONTA_CAPITAL = 1657;
	public static final Integer OPERACAO_TED_NOSSA_REMESSA = 4000;
	public static final Integer OPERACAO_TED_NOSSA_REMESSA_BLOQUEIO_JUDICIAL = 4013;
	public static final Integer OPERACAO_TED_SUA_REMESSA = 4001;

	public static final Integer OPERACAO_BLOQUEIO_ORDEM_JUDICIAL_CONTA = 4014;
	public static final Integer OPERACAO_DESBLOQUEIO_ORDEM_JUDICIAL_CONTA = 4015;
	public static final Integer OPERACAO_BLOQUEIO_ORDEM_JUDICIAL_APLICACAO = 4016;
	public static final Integer OPERACAO_DESBLOQUEIO_ORDEM_JUDICIAL_APLICACAO = 4017;

	public static final Integer OPERACAO_NOSSA_REMESSA_BOLETO_RECEBIMENTO_TITULOS = 4024;
	public static final Integer OPERACAO_NOSSA_REMESSA_BOLETO_DEBITO_TITULOS = 4025;
	public static final Integer OPERACAO_NOSSA_REMESSA_BOLETO_DEBITO_TITULOS_IB = 4026;

	public static final Integer OPERACAO_CREDITO_TIB_SPB = 4101;
	public static final Integer OPERACAO_DEBITO_TIB_SPB = 4102;
	public static final Integer OPERACAO_DEBITO_RCO_CAMARAS_SPB = 4103;
	public static final Integer OPERACAO_DEBITO_RCO_CONFEDERACAO_SPB = 4104;
	public static final Integer OPERACAO_RENDAS_COM_CENTRALIZACAO_FINANCEIRA_SPB = 4210;
	
	public static final Integer OPERACAO_DEBITO_CHEQUE_SUA_REMESSA = 4127;
	public static final Integer OPERACAO_DEBITO_CHEQUE_SUA_REMESSA_VLB = 4128;
	public static final Integer OPERACAO_CREDITO_DEVOLUCAO_CHEQUE_SUA_REMESSA = 4129;
	public static final Integer OPERACAO_CREDITO_DEVOLUCAO_CHEQUE_SUA_REMESSA_VLB = 4130;

	public static final Integer OPERACAO_TARIFA_ALTERACAO_CCB = 7123;
	public static final Integer OPERACAO_DESPESAS_ATUALIZACAO_IMPOSTOS_DENUNCIA_ESPONTANIA = 8118;
	public static final Integer OPERACAO_LANCAMENTO_SUSTACAO_REVOGACAO_CHEQUES = 9126;
	public static final Integer OPERACAO_IRRF_SOBRE_REMUNERACAO_CAPITAL_SOCIAL_PJ = 91121;
	public static final Integer OPERACAO_IRRF_SOBRE_REMUNERACAO_CAPITAL_SOCIAL_PF = 91122;
	public static final Integer OPERACAO_DEBITO_TITULOS_E_CONVENIOS = 514;
	public static final Integer OPERACAO_SOBRA_OPERACOES_DESCONTO_TITULOS = 838;

	public static final Integer OPERACAO_DEBITO_RECARGA_DE_CELULAR = 4116;
	public static final Integer OPERACAO_DEBITO_RECARGA_LIQUIDA_A_PAGAR = 4117;
	public static final Integer OPERACAO_DEBITO_RECARGA_SPREAD_SOBRE_RECARGA_DE_CELULAR = 4118;
	public static final Integer OPERACAO_DEBITO_RECARGA_LIQUIDACAO_SERVICOS_DE_RECARGA = 4119;
	/**
	 * OPERACOES DO MULTI CANAL
	 */
	public static final Integer DEPOSITO_CHEQUES_REAPRESENTACAO_AUTOMATICA = 4011;
	public static final Integer OPERACAO_DEBITO_BOLETOS_INTERNET_BANKING = 4004;
	public static final Integer OPERACAO_DEBITO_ARRECADACOES_INTERNET_BANKING = 4005;

	/**
	 * PERIODOCIADADE DO DEBITO DE CMPF
	 */
	public static final Integer DOMINIO_PERIODICIDADE_DEBITO_CPMF = 2020;
	public static final String REGISTRO_PERIODICIDADE_DEBITO_CPMF_DIARIO = "1";
	public static final String REGISTRO_PERIODICIDADE_DEBITO_CPMF_SEMANAL = "2";
	public static final String REGISTRO_PERIODICIDADE_DEBITO_CPMF_DECENDIAL = "3";
	public static final String REGISTRO_PERIODICIDADE_DEBITO_CPMF_QUINZENAL = "4";
	public static final String REGISTRO_PERIODICIDADE_DEBITO_CPMF_MENSAL = "5";

	/**
	 * CODIGO INDEXADOR TIPO ALIQUOTA CPMF
	 */
	public static final Integer CODIGO_INDEXADOR_ALIQUOTA_CPMF = 1;

	/**
	 * Constante que define se os botoes da PAC devem aparecer na Tela de
	 * Tesouria
	 */
	public static final String EXIBE_BOTOES_PAC = "SIM";

	/**
	 * CONSTANTES PARA DEBITO E CREDITO LOG CAIXA
	 */
	public static final Integer LOG_CAIXA_DEBITO = 1;
	public static final Integer LOG_CAIXA_CREDITO = 2;

	/**
	 * Conta Corrente - Tal�o de cheques
	 */
	public static final String CONTA_CORRENTE_OPCAO_TALAO_CHEQUE_SIM = "1";
	public static final String CONTA_CORRENTE_OPCAO_TALAO_CHEQUE_NAO = "2";

	/**
	 * Conta Corrente - Integra��o BB
	 */
	public static final String CONTA_CORRENTE_OPCAO_INTEGRACAO_BB_SIM = "1";
	public static final String CONTA_CORRENTE_OPCAO_INTEGRACAO_BB_NAO = "2";

	/**
	 * Conta Corrente -CPMF
	 */
	public static final String CONTA_CORRENTE_OPCAO_CPMF_SIM = "1";
	public static final String CONTA_CORRENTE_OPCAO_CPMF_NAO = "2";

	/**
	 * Conta Corrente - Cheque Compe
	 */
	public static final String CONTA_CORRENTE_OPCAO_CHEQUE_COMPE_SIM = "1";
	public static final String CONTA_CORRENTE_OPCAO_CHEQUE_COMPE_NAO = "2";

	/**
	 * Conta Corrente - Tal�o de cheques titular
	 */
	public static final String CONTA_CORRENTE_OPCAO_TALAO_CHEQUE_TITULAR_SIM = "1";
	public static final String CONTA_CORRENTE_OPCAO_TALAO_CHEQUE_TITULAR_NAO = "2";

	/**
	 * Conta Corrente - Tal�o de cheques titular
	 */
	public static final String CONTA_CORRENTE_OPCAO_AUTORIZA_CONSULTAS_FINANCEIRAS_SIM = "1";
	public static final String CONTA_CORRENTE_OPCAO_AUTORIZA_CONSULTAS_FINANCEIRAS_NAO = "2";

	/**
	 * Conta Corrente- Situa��o Conta Integra��o BB
	 */
	public static final Integer DOMINIO_SITUACAO_CONTA_INTEGRACAO = 2034;
	public static final String REGISTRO_SITUACAO_CONTA_INTEGRACAO_EM_ATIVACAO = "1";
	public static final String REGISTRO_SITUACAO_CONTA_INTEGRACAO_ATIVO = "2";
	public static final String REGISTRO_SITUACAO_CONTA_INTEGRACAO_BLOQUEADO = "3";
	public static final String REGISTRO_SITUACAO_CONTA_INTEGRACAO_ENCERRADO = "4";
	public static final String REGISTRO_SITUACAO_CONTA_INTEGRACAO_EM_REATIVACAO = "5";
	public static final String REGISTRO_SITUACAO_CONTA_INTEGRACAO_EM_ENCERRAMENTO = "6";
	public static final String REGISTRO_SITUACAO_CONTA_INTEGRACAO_RECUSADA = "7";
	public static final String REGISTRO_SITUACAO_CONTA_INTEGRACAO_ATIVA_BANCO = "8";
	public static final Integer ID_REGISTRO_SITUACAO_CONTA_INTEGRACAO_ATIVO = 4140;

	public static final String DESCRICAO_RETORNO_509_CTA_ENCERRADA_PEDIDO_COOPERATIVA = "CTA ENCERRADA PEDIDO COOPERAT";

	public static final Integer SEQUENCIAL_DE_REMESSA_INCORRETO = 121;

	public static final String CONTA_CORRENTE_CATEGORIA_PRINCIPAL = "P";
	public static final String CONTA_CORRENTE_CATEGORIA_SECUNDARIA = "S";

	/**
	 * Constantes do dominio tipo da capitalizacao
	 */
	public static final Integer DOMINIO_TIPO_CAPITALIZACAO = 2084;
	public static final String REGISTRO_TIPO_CAPITALIZACAO_PERIODICO = "1";
	public static final String REGISTRO_TIPO_CAPITALIZACAO_COTA_UNICA = "2";

	/**
	 * Constantes do dominio periodicidade da capitalizacao
	 */

	public static final Integer DOMINIO_PERIODICIDADE_CAPITALIZACAO = 2085;
	public static final String REGISTRO_PERIODICIDADE_CAPITALIZACAO_MENSAL = "1";
	public static final String REGISTRO_PERIODICIDADE_CAPITALIZACAO_BIMESTRAL = "2";
	public static final String REGISTRO_PERIODICIDADE_CAPITALIZACAO_TRIMESTRAL = "3";
	public static final String REGISTRO_PERIODICIDADE_CAPITALIZACAO_SEMESTRAL = "4";
	public static final String REGISTRO_PERIODICIDADE_CAPITALIZACAO_ANUAL = "5";
	public static final String REGISTRO_PERIODICIDADE_DEFINIDO_NA_CONTRATACAO = "6";

	/**
	 * Constantes do dominio tipo termo capitalizacao
	 */

	public static final Integer DOMINIO_TIPO_TERMO_CAPITALIZACAO = 2086;
	public static final String REGISTRO_TIPO_TERMO_CAPITALIZACAO_ADESAO = "1";
	public static final String REGISTRO_TIPO_TERMO_CAPITALIZACAO_ENCERRAMENTO = "2";

	/**
	 * Constantes do dom�nio situacao da capitalizacao
	 */

	public static final Integer DOMINIO_SITUACAO_CAPITALIZACAO = 2087;
	public static final String REGISTRO_SITUACAO_CAPITALIZACAO_ATIVO = "1";
	public static final String REGISTRO_SITUACAO_CAPITALIZACAO_BLOQUEADO = "2";


	/**
	 * Controle de acoes da tesouraria
	 */
	public static final String ACAO_RECOLHIMENTO = "recolhimento";
	public static final String ACAO_RECONTAGEM = "recontagem";
	public static final String ACAO_EXIBIR = "exibir";
	public static final String ACAO_SUPRIR = "suprir";
	public static final String ACAO_RECOLHER_PAC = "recolher_pac";
	public static final String ACAO_SUPRIR_PAC = "suprir_pac";
	public static final String ACAO_AUTORIZAR_ABERTURA_CAIXA = "autorizarAberturaCaixa";
	public static final String ACAO_AUTORIZAR_FECHAMENTO_CAIXA = "autorizarFechamentoCaixa";

	/**
	 * Dominio Forma Lancamento
	 */
	public static final Integer DOMINIO_FORMA_LANCAMENTO = 4028;
	public static final String REGISTRO_FORMA_LANCAMENTO_NORMAL = "1";
	public static final String REGISTRO_FORMA_LANCAMENTO_ESTORNO = "2";

	/**
	 * Dominio Tipo do Desdobramento
	 */
	public static final Integer DOMINIO_TIPO_DESDOBRAMENTO = 5000;
	public static final String REGISTRO_TIPO_DESDOBRAMENTO_PESSOA_FISICA = "1";
	public static final String REGISTRO_TIPO_DESDOBRAMENTO_PESSOA_JURIDICA = "2";
	public static final String REGISTRO_TIPO_DESDOBRAMENTO_BANCO_DO_BRASIL = "3";
	public static final String REGISTRO_TIPO_DESDOBRAMENTO_CAIXA_ECONOMICA_FEDERAL = "4";
	public static final String REGISTRO_TIPO_DESDOBRAMENTO_OUTROS_BANCOS_OFICIAIS = "5";
	public static final String REGISTRO_TIPO_DESDOBRAMENTO_DEMAIS_BANCOS = "6";
	public static final String REGISTRO_TIPO_DESDOBRAMENTO_SEM_DESDOBRAMENTO = "7";

	/**
	 * Constante do dominio de operacao de lancamento.
	 */
	public static final Integer DOMINIO_TIPO_OPERACAO_LANCAMENTO = 1033;
	public static final String REGISTRO_OPERACAO_LANCAMENTO_DEBITO = "1";
	public static final String REGISTRO_OPERACAO_LANCAMENTO_CREDITO = "2";

	/**
	 * Constante do dom�nio de conv�nio de cheque
	 */
	public static final Integer DOMINIO_TIPO_CONVENIO_CHEQUE = 2104;
	public static final String REGISTRO_TIPO_CONVENIO_CHEQUE_BANCO_DO_BRASIL = "1";
	public static final String REGISTRO_TIPO_CONVENIO_CHEQUE_COMPE_PRORPIA = "2";
	public static final String REGISTRO_TIPO_CONVENIO_CHEQUE_AMBOS = "3";

	/**
	 * Constante do dominio de operacao de lancamento.
	 */
	public static final Integer DOMINIO_LANCAMENTO_DEBITO_CREDITO = 2001;
	public static final String REGISTRO_LANCAMENTO_DEBITO_CREDITO_D = "1";
	public static final String REGISTRO_LANCAMENTO_DEBITO_CREDITO_C = "2";

	/**
	 * Ordem de Impress�o do talao de cheques
	 */
	public static final Integer ORDEM_IMPRESSAO_TALAO_PRIMEIRO = 1;
	public static final Integer ORDEM_IMPRESSAO_TALAO_SEGUNDO = 2;
	public static final Integer ORDEM_IMPRESSAO_TALAO_TERCEIRO = 3;

	public static final Integer VALOR_INICIAL_SEQUENCIA_NUMERO_CHEQUE = 1;
	public static final Integer VALOR_FINAL_SEQUENCIA_NUMERO_CHEQUE = 999999;
	public static final String VALOR_INICIAL_SEQUENCIA_SERIE = "AAA";
	public static final Integer LIMITE_DIARIO_CHEQUES = 9000;

	/**
	 * Dominio Classificacao do banco
	 */
	public static final Integer DOMINIO_CLASSIFICACAO_BANCO = 2040;
	public static final String REGISTRO_CLASSIFICACAO_BANCO_BANCO_DO_BRASIL = "1";
	public static final String REGISTRO_CLASSIFICACAO_BANCO_CAIXA_ECONOMICA = "2";
	public static final String REGISTRO_CLASSIFICACAO_BANCO_OUTROS_BANCOS_OFICIAIS = "3";
	public static final String REGISTRO_CLASSIFICACAO_BANCO_DEMAIS_BANCOS = "4";

	/**
	 * Numeros de bancos emiss�o cheque
	 */
	public static final String NUMERO_BANCO_DO_BRASIL_CHEQUE = "001";
	public static final String NUMERO_BANCO_COMPE_CHEQUE = "133";

	/**
	 * Constante do dominio de operacao de lancamento.
	 */
	public static final Integer DOMINIO_TIPO_CORRECAO = 2045;
	public static final String REGISTRO_TIPO_CORRECAO_OPERACOES = "1";
	public static final String REGISTRO_TIPO_CORRECAO_CONTA_INTEGRACAO = "2";
	public static final String REGISTRO_TIPO_CORRECAO_LANCAMENTO_PROPRIO_COOPERATIVA = "3";

	/**
	 * Constante do dominio de movimento de cheques
	 */
	public static final Integer DOMINIO_MOVIMENTO_CHEQUES = 2044;
	public static final String REGISTRO_MOVIMENTO_CHEQUES_MAIORES = "1";
	public static final String REGISTRO_MOVIMENTO_CHEQUES_MENORES = "2";
	public static final String REGISTRO_MOVIMENTO_CHEQUES_TODOS = "3";

	/**
	 * Dominio forma da operacao inter-cooperativas
	 */
	public static final Integer DOMINIO_FORMA_OPERACAO_INTER_COOPERATIVAS = 2046;
	public static final String REGISTRO_FORMA_OPERACAO_INTER_COOPERATIVAS_BENEFICIARIA = "1";
	public static final String REGISTRO_FORMA_OPERACAO_INTER_COOPERATIVAS_PAGADORA = "2";

	/**
	 * Dominio situacao da operacao inter-cooperativas
	 */
	public static final Integer DOMINIO_SITUACAO_OPERACAO_INTER_COOPERATIVAS = 2047;
	public static final String REGISTRO_SITUACAO_OPERACAO_INTER_COOPERATIVAS_REGISTRADA = "1";
	public static final String REGISTRO_SITUACAO_OPERACAO_INTER_COOPERATIVAS_ATRAZADA = "2";
	public static final String REGISTRO_SITUACAO_OPERACAO_INTER_COOPERATIVAS_FINALIZADA = "3";
	public static final String REGISTRO_SITUACAO_OPERACAO_INTER_COOPERATIVAS_PAGAMENTO_RECUSADO = "4";

	/**
	 * Dominio Forma de Pagamento
	 */
	public static final Integer DOMINIO_FORMA_PAGAMENTO = 2028;
	public static final String REGISTRO_FORMA_PAGAMENTO_DINHEIRO = "1";
	public static final String REGISTRO_FORMA_PAGAMENTO_CHEQUE = "2";
	public static final String REGISTRO_FORMA_PAGAMENTO_DEBITO_CONTA_CORRENTE = "3";

	/**
	 * Dominio Situacao do Recebimento
	 */
	public static final Integer DOMINIO_SITUACAO_RECEBIMENTO = 2029;
	public static final String REGISTRO_SITUACAO_RECEBIMENTO_RECEBIDO = "1";
	public static final String REGISTRO_SITUACAO_RECEBIMENTO_A_RECEBER = "2";
	public static final String REGISTRO_SITUACAO_RECEBIMENTO_ESTORNADO = "3";
	public static final String REGISTRO_SITUACAO_RECEBIMENTO_ALIVIO_EFETUADO = "4";
	public static final String REGISTRO_SITUACAO_RECEBIMENTO_INCLUSAO_CBF800 = "5";
	public static final String REGISTRO_SITUACAO_RECEBIMENTO_FINALIZADO = "6";
	public static final String REGISTRO_SITUACAO_RECEBIMENTO_ENVIADO_BB = "7";
	public static final String REGISTRO_SITUACAO_RECEBIMENTO_IMPRIMIR_COMPROVANTE = "8";
	public static final String REGISTRO_SITUACAO_RECEBIMENTO_ESTORNANDO = "9";
	public static final String REGISTRO_SITUACAO_RECEBIMENTO_SOLICITADO_BAIXA = "10";
	public static final String REGISTRO_SITUACAO_RECEBIMENTO_BAIXA_EFETUADA = "11";
	public static final String REGISTRO_SITUACAO_RECEBIMENTO_ERRO_COMUNICACAO = "12";
	public static final String REGISTRO_SITUACAO_RECEBIMENTO_ERRO_LAYOUT = "13";
	public static final Integer REGISTRO_SITUACAO_RECEBIMENTO_RECEBIDO_ID = 4127;
	public static final Integer REGISTRO_SITUACAO_RECEBIMENTO_A_RECEBER_ID = 4128;
	public static final Integer REGISTRO_SITUACAO_RECEBIMENTO_ESTORNADO_ID = 4129;
	public static final Integer REGISTRO_SITUACAO_RECEBIMENTO_ALIVIO_EFETUADO_ID = 4299;
	public static final Integer REGISTRO_SITUACAO_RECEBIMENTO_INCLUSAO_CBF800_ID = 4325;
	public static final Integer REGISTRO_SITUACAO_RECEBIMENTO_FINALIZADO_ID = 4329;
	public static final Integer REGISTRO_SITUACAO_RECEBIMENTO_ENVIADO_BB_ID = 4378;
	public static final Integer REGISTRO_SITUACAO_RECEBIMENTO_IMPRIMIR_COMPROVANTE_ID = 4379;
	public static final Integer REGISTRO_SITUACAO_RECEBIMENTO_ESTORNANDO_ID = 4380;
	public static final Integer REGISTRO_SITUACAO_RECEBIMENTO_SOLICITADO_BAIXA_ID = 4725;
	public static final Integer REGISTRO_SITUACAO_RECEBIMENTO_BAIXA_EFETUADA_ID = 4726;
	public static final Integer REGISTRO_SITUACAO_RECEBIMENTO_ERRO_COMUNICACAO_ID = 4727;
	public static final Integer REGISTRO_SITUACAO_RECEBIMENTO_ERRO_LAYOUT_ID = 4731;
	
	/**
	 * Dominio Tipo do Documento
	 */
	public static final Integer DOMINIO_TIPO_DOCUMENTO = 2030;
	public static final String REGISTRO_TIPO_DOCUMENTO_BOLETOS_BANCARIOS = "1";
	public static final String REGISTRO_TIPO_DOCUMENTO_ARRECADACOES = "2";

	/**
	 * Dominio Tipo Convenio do Recebimento
	 */
	public static final Integer DOMINIO_TIPO_CONVENIO_RECEBIMENTO = 2118;
	public static final String REGISTRO_TIPO_CONVENIO_RECEBIMENTO_GCB = "1";
	public static final String REGISTRO_TIPO_CONVENIO_RECEBIMENTO_NOSSA_REMESSA = "2";
	public static final Integer ID_REGISTRO_TIPO_CONVENIO_RECEBIMENTO_GCB = 4723;
	public static final Integer ID_REGISTRO_TIPO_CONVENIO_RECEBIMENTO_NOSSA_REMESSA = 4724;

	/**
	 * Operacoes Recebimentos
	 */
	public static final Integer OPERACAO_RECEBIMENTOS_TITULOS_COBAN = 46;
	public static final Integer OPERACAO_RECEBIMENTOS_TITULOS_COOPERATIVA = 47;
	public static final Integer OPERACAO_RECEBIMENTOS_CONVENIOS_COBAN = 49;
	public static final Integer OPERACAO_RECEBIMENTOS_CONVENIOS_COOPERATIVA = 50;

	public static final Integer OPERACAO_RECEBIMENTOS_REGISTRO_REPASSE_COBAN = 218;

	public static final String DESCRICAO_FALTA = "FALTA";
	public static final String DESCRICAO_SOBRA = "SOBRA";
	public static final String DESCRICAO_REGISTRADO_FECHAMENTO_COM_AJUSTE = "REGISTRADO FECHAMENTO C/ AJUSTE";

	/**
	 * Codigos de Alineas de devolucao de cheques
	 */
	public static final Integer CODIGO_ALINEA_DEVOLUCAO_FALTA_FUNDOS_PRIMEIRA_APRESENTACAO = 11;
	public static final Integer CODIGO_ALINEA_DEVOLUCAO_FALTA_FUNDOS_SEGUNDA_APRESENTACAO = 12;
	public static final Integer CODIGO_ALINEA_DEVOLUCAO_SITUACAO_CONTA_ENCERRADA = 13;
	public static final Integer CODIGO_ALINEA_DEVOLUCAO_SITUACAO_PRATICA_ESPURIA = 14;
	public static final Integer CODIGO_ALINEA_DEVOLUCAO_CHEQUE_SUSTADO_ROUBO = 20;
	// Devolvido anteriormente por 21, 22, 23, 24, 31, 34 n�o pass�vel de
	// reapresenta��o por persistir o motivo de devolu��o
	public static final Integer CODIGO_ALINEA_DEVOLUCAO_CONTRA_ORDEM_ESCRITA = 21;
	public static final Integer CODIGO_ALINEA_DEVOLUCAO_DIVERG_INSUF_DE_ASSINATURA = 22;
	public static final Integer CODIGO_ALINEA_DEVOLUCAO_CHEQUES_EMITIDOS_EM_DESACORDO_LEI_200 = 23;
	public static final Integer CODIGO_ALINEA_DEVOLUCAO_BLOQUEIO_JUDICIAL = 24;
	public static final Integer CODIGO_ALINEA_DEVOLUCAO_CANCELAMENTO_TALONARIO = 25;
	public static final Integer CODIGO_ALINEA_DEVOLUCAO_INOPERANCIA_TRANSPORTE = 26;
	public static final Integer CODIGO_ALINEA_DEVOLUCAO_FERIADO_MUNICIPAL_NAO_PREVISTO = 27;
	public static final Integer CODIGO_ALINEA_DEVOLUCAO_CHEQUE_SUSTADO_COM_BO = 28;
	public static final Integer CODIGO_ALINEA_DEVOLUCAO_CHEQUE_BLOQUEADO_AGENCIA = 29;
	public static final Integer CODIGO_ALINEA_DEVOLUCAO_FURTO_MALOTE = 30;

	public static final Integer CODIGO_ALINEA_DEVOLUCAO_ERRO_FORMAL = 31;
	public static final Integer CODIGO_ALINEA_DEVOLUCAO_IRREGUL_CARIMBO = 32;
	public static final Integer CODIGO_ALINEA_DEVOLUCAO_DIVERGENCIA_ENDOSSO = 33;

	public static final Integer CODIGO_ALINEA_DEVOLUCAO_CHEQUE_APRES_SEM_ENDOSSO_MANDATO = 34;
	public static final Integer CODIGO_ALINEA_DEVOLUCAO_CHEQUE_FURTADO = 35;
	public static final Integer CODIGO_ALINEA_DEVOLUCAO_REGISTRO_INCONSISTENTE = 37;

	public static final Integer CODIGO_ALINEA_DEVOLUCAO_IMAGEM_FORA_PADRAO = 39;
	public static final Integer CODIGO_ALINEA_DEVOLUCAO_MOEDA_INVALIDA = 40;
	public static final Integer CODIGO_ALINEA_DEVOLUCAO_CHEQUE_APRESENTADO = 41;
	public static final Integer CODIGO_ALINEA_DEVOLUCAO_CHEQUE_NAO_COMPENSAVEL = 42;

	public static final Integer CODIGO_ALINEA_DEVOLUCAO_DEVOLVIDO_ANTERIORMENTE = 43;

	public static final Integer CODIGO_ALINEA_DEVOLUCAO_CHEQUE_PRESCRITO = 44;
	public static final Integer CODIGO_ALINEA_DEVOLUCAO_CHEQUE_ENTIDADE_TESOURO = 45;
	public static final Integer CODIGO_ALINEA_DEVOLUCAO_DOC_NAO_COMPENSAVEL = 46;
	public static final Integer CODIGO_ALINEA_DEVOLUCAO_INCONSISTENCIA_DADOS_OBRIG = 47;

	// Preenchimento incorreto - 48
	public static final Integer CODIGO_ALINEA_DEVOLUCAO_PREENCHIMENTO_INCORRETO = 48;
	// Remessa nula - reapresenta��o de cheque pelos motivos: 12, 13, 14, 25,
	// 28, 35, 43, 44, 45.
	public static final Integer CODIGO_ALINEA_DEVOLUCAO_REMESSA_NULA_REAPRESENTACAO_OUTROS_MOTIVOS = 49;

	public static final Integer CODIGO_ALINEA_DEVOLUCAO_INFORM_FALTANTE = 59;
	public static final Integer CODIGO_ALINEA_DEVOLUCAO_INSTRU_INADEQUADO = 60;
	public static final Integer CODIGO_ALINEA_DEVOLUCAO_PAPEL_NAO_COMPENSAVEL = 61;
	public static final Integer CODIGO_ALINEA_DEVOLUCAO_ARQUIVO_LOG_NAO_PROCESSADO = 64;
	public static final Integer CODIGO_ALINEA_DEVOLUCAO_SUSTACAO_PROVISORIA = 70;
	public static final Integer CODIGO_ALINEA_DEVOLUCAO_INADIMPLEMENTO_CONTRATUAL = 71;
	public static final Integer CODIGO_ALINEA_DEVOLUCAO_CONTRATO_COMPE_ENCERRADO = 72;

	/**
	 * Codigo de Processamento do arquivo
	 */
	public static final String CODIGO_PROCESSAMENTO_ARQUIVO_PROCESSADO = "1";
	public static final String CODIGO_PROCESSAMENTO_ARQUIVO_RECUSA_TOTAL_HEADER_INVALIDO = "2";
	public static final String CODIGO_PROCESSAMENTO_ARQUIVO_RECUSA_TOTAL_TRAILER_INVALIDO_INEXISTENTE = "3";
	public static final String CODIGO_PROCESSAMENTO_ARQUIVO_RECUSA_PARCIAL_DETALHE = "4";
	public static final String CODIGO_PROCESSAMENTO_ARQUIVO_RECUSA_TOTAL_TIPO_REGISTRO_INEXISTENTE = "5";
	public static final String CODIGO_PROCESSAMENTO_ARQUIVO_RECUSA_TOTAL_SEQUENCIAL_INVALIDO = "6";
	public static final String CODIGO_PROCESSAMENTO_ARQUIVO_EM_PROCESSAMENTO = "7";
	public static final String CODIGO_PROCESSAMENTO_ARQUIVO_RECUSA_TOTAL_CONTEUDO_REMESSA_INVALIDA = "8";


	public static final Integer CODIGO_PROCESSAMENTO_ARQUIVO_COO_507_REMESSA_ACEITA_REGS_RECUSADOS = 136;

	public static final Integer DOMINIO_CODIGO_DEVOLUCAO_TRANSFERENCIA = 2103;
	public static final String REGISTRO_DEVOLUCAO_CONTA_DEST_ENCERRADA = "1";
	public static final String REGISTRO_DEVOLUCAO_AGENCIA_CONTA_DEST_INVALIDA = "2";
	public static final String REGISTRO_DEVOLUCAO_AUSENCIA_DIVERGENCIA_CPF_CNPJ = "3";
	public static final String REGISTRO_DEVOLUCAO_MENSAGEM_INVALIDA_PARA_O_TIPO_DE_TRANSACAO_OU_FINALIDADE = "4";
	public static final String REGISTRO_DEVOLUCAO_DIVERGENCIA_TITULARIDADE = "5";
	public static final String REGISTRO_DEVOLUCAO_TRANSFERENCIA_INSUFICIENTE_PARA_FINALIDADE_INDICADA = "6";
	public static final String REGISTRO_DEVOLUCAO_DIFERENCA_A_MAIOR = "7";
	public static final String REGISTRO_DEVOLUCAO_CODIGO_IDENTIFICADOR_DE_TRANSFERENCIA_INVALIDO = "8";
	public static final String REGISTRO_DEVOLUCAO_POR_FRAUDE = "9";
	public static final String REGISTRO_DEVOLUCAO_IDENTIFICACAO_DEPOSITO_JUDICIAL_INVALIDA = "15";
	public static final String REGISTRO_DEVOLUCAO_MENSAGEM_STR0020_PAG0116_FORA_HORARIO_DEFINIDO_NEGOCIO = "16";
	public static final String REGISTRO_DEVOLUCAO_NUMERO_DE_CONTRATO_INVALIDO = "17";
	public static final String REGISTRO_DEVOLUCAO_VALOR_EM_DUPLICIDADE = "18";
	public static final String REGISTRO_DEVOLUCAO_MOVIMNETACOES_FINANCEIRAS_LIGADAS_AO_TERRORISMO = "19";
	public static final String REGISTRO_DEVOLUCAO_DOCUMENTO_FGTS_NAO_APRENSENTADO_PARA_AUTENTICACAO = "20";
	public static final String REGISTRO_DEVOLUCAO_DE_PAGAMENTOS_EFETUADOS_PELO_TESOURO = "21";
	public static final String REGISTRO_DEVOLUCAO_DE_ORDEM_BANCARIA_PELO_AGENTE_FINANCEIRO = "22";
	public static final String REGISTRO_DEVOLUCAO_ERRO_NO_PREENCHIMENTO_DA_DEVOLUCAO = "23";
	public static final String REGISTRO_DEVOLUCAO_ERRO_NO_PREENCHIMENTO_DOCUMENTO_RECOLHIMENTO = "24";
	public static final String REGISTRO_DEVOLUCAO_ERRO_NO_PREENCHIMENTO_DO_DEPOSITO_DIRETO = "25";
	public static final String REGISTRO_DEVOLUCAO_PAGAMENTO_DE_TRIBUTOS_POR_SOLICITACAO_DA_IF = "26";
	public static final String REGISTRO_DEVOLUCAO_RECOLHIMENTO_A_MAIOR_AUTORIZADA_PELA_RFB = "27";
	public static final String REGISTRO_DEVOLUCAO_CREDITO_NAO_SACADO_DESCURSO_DE_PRAZO_ESTIPULADO = "28";
	public static final String REGISTRO_DEVOLUCAO_CODIGO_MOEDA_INVALIDO = "40";
	public static final String REGISTRO_DEVOLUCAO_BOLETO_PAGAMENTO_LIQUIDADO_POR_VALOR_A_MAIOR_OU_MENOR = "51";
	public static final String REGISTRO_DEVOLUCAO_BOLETO_PAGAMENTO_RECEBIDO_APOS_VENCIMENTO_SEM_JUROS_DEMAIS_ENCARGOS = "52";
	public static final String REGISTRO_DEVOLUCAO_APRESENTACAO_INDEVIDA = "53";
	public static final String REGISTRO_DEVOLUCAO_CODIGO_BARRAS_EM_DESACORDO_COM_AS_ESPECIFICACOES = "63";
	public static final String REGISTRO_DEVOLUCAO_REPASSE_EM_DUPLICIDADE_PELA_IF_RECEBEDORA_DE_BOLETOS_PAGAMENTO_LIQUIDADOS = "68";
	public static final String REGISTRO_DEVOLUCAO_BOLETOS_PAGAMENTO_LIQUIDADOS_EM_DUPLICIDADE_NO_MESMO_DIA = "69";
	public static final String REGISTRO_DEVOLUCAO_POR_SOLICITACAO_DE_CLIENTE_DA_IF_RECEBEDORA = "70";
	public static final String REGISTRO_DEVOLUCAO_BOLETO_PAGAMENTO_RECEBIDO_COM_DESCONTO_OU_ABATIMENTO_NAO_PREVISTO = "71";
	public static final String REGISTRO_DEVOLUCAO_PAGAMENTO_FRAUDADO = "72";
	public static final String REGISTRO_DEVOLUCAO_BENEFICIARIO_NAO_IDENTIFICADO = "73";
	public static final String REGISTRO_DEVOLUCAO_CPF_CNPJ_BENEFICIARIO_INVALIDO_OU_NAO_CONFERE_NA_BASE_DA_IF_DESTINATARIA = "74";
	public static final String REGISTRO_DEVOLUCAO_CPF_CNPJ_DO_PAGADOR_INVALIDO_OU_NAO_CONFERE_NA_DA_IF_DESTINATARIA = "75";
	public static final String REGISTRO_DEVOLUCAO_COPIA_NAO_ENCAMINHADA_PELA_IF_RECEBEDORA_NO_PRAZO_PREVISTO = "76";
	public static final String REGISTRO_DEVOLUCAO_BOLETO_EM_CARTORIO_OU_PROTESTADO = "77";
	public static final String REGISTRO_DEVOLUCAO_PORTABILIDADE_NAO_REGISTRADA_NA_CENTRAL_DE_TRANSFERENCIA_DE_CREDITO = "80";


	public static final Integer DOMINIO_SITUACAO_MOVIMENTO_DEVOLUCAO = 2041;
	public static final String REGISTRO_SITUACAO_MOVIMENTO_DEVOLUCAO_PENDENTE = "1";
	public static final String REGISTRO_SITUACAO_MOVIMENTO_DEVOLUCAO_FINALIZADO_NAO_CONCILIADO = "2";
	public static final String REGISTRO_SITUACAO_MOVIMENTO_DEVOLUCAO_GERADO = "3";
	public static final String REGISTRO_SITUACAO_MOVIMENTO_DEVOLUCAO_ENVIADO = "4";
	public static final String REGISTRO_SITUACAO_MOVIMENTO_DEVOLUCAO_PROCESSADO = "5";
	public static final String REGISTRO_SITUACAO_MOVIMENTO_DEVOLUCAO_PROCESSADO_PARCIALMENTE = "6";
	public static final String REGISTRO_SITUACAO_MOVIMENTO_DEVOLUCAO_RECUSADO = "7";
	public static final String REGISTRO_SITUACAO_MOVIMENTO_DEVOLUCAO_MOVIMENTO_CONCILIADO = "8";
	public static final String REGISTRO_SITUACAO_MOVIMENTO_DEVOLUCAO_CONCILIADO_COM_ALTERACAO = "9";
	public static final String REGISTRO_SITUACAO_MOVIMENTO_DEVOLUCAO_CANCELADO = "10";

	public static final Integer CODIGO_ALCADA_NUMERO_CHEQUES_ACIMA_LIMITE_PERMITIDO = 1681;
	public static final Integer CODIGO_ALCADA_LIBERACAO_TALONARIO = 1682;

	/**
	 * C�DIGOS DE HIST�RICOS.
	 */
	public static final Long CODIGO_HISTORICO_BB_144 = new Long("144");
	public static final Long CODIGO_HISTORICO_BB_229 = new Long("229");
	public static final Long CODIGO_HISTORICO_BB_729 = new Long("729");
	public static final Long CODIGO_HISTORICO_BB_631 = new Long("631");
	public static final Integer CODIGO_HISTORICO_BB_500 = 500;

	/**
	 * Dominio da Situacao do Cheque na Compensacao
	 */
	public static final Integer DOMINIO_SITUACAO_MOVIMENTO_DEVOLUCAO_COO_550 = 2042;
	public static final String DOMINIO_SITUACAO_MOVIMENTO_DEVOLUCAO_COO_550_REGISTRADO = "1";
	public static final String DOMINIO_SITUACAO_MOVIMENTO_DEVOLUCAO_COO_550_CONSOLIDADO = "2";
	public static final String DOMINIO_SITUACAO_MOVIMENTO_DEVOLUCAO_COO_550_NAO_CONSOLIDADO = "3";

	/**
	 * Movimento Estorno
	 */
	public static final int DOMINIO_MOVIMENTO_ESTORNO = 2049;
	public static final String REGISTRO_MOVIMENTO_ESTORNO_DO_DIA = "1";
	public static final String REGISTRO_MOVIMENTO_ESTORNO_ANTERIOR = "2";

	public static final Integer MOVIMENTO_ESTORNO_DO_DIA = 1;
	public static final Integer MOVIMENTO_ESTORNO_ANTERIOR = 2;

	public static final String DESCRICAO_ESTORNO = "ESTORNO";

	/**
	 * Tipo Movimenta��o
	 */
	public static final Integer DOMINIO_TIPO_MOVIMENTACAO = 2050;
	public static final Integer TIPO_MOVIMENTACAO_CONTA_CORRENTE = 1;
	public static final Integer TIPO_MOVIMENTACAO_CONTA_INVESTIMENTO = 2;
	public static final Integer TIPO_MOVIMENTACAO_CONTA_CAPITAL = 3;
	public static final Integer TIPO_MOVIMENTACAO_CAIXA = 4;
	public static final Integer TIPO_MOVIMENTACAO_CONTA_BANCO = 5;

	public static final Long CONTRATO_DE_ABERTURA_DE_CONTA_CORRENTE_PF = 1008L;
	public static final Long CONTRATO_DE_ABERTURA_DE_CONTA_CORRENTE_PJ = 1009L;

	/**
	 * Situa��o do arquivo BB
	 */
	public static final Integer DOMINIO_SITUACAO_DO_ARQUIVO_BB = 2052;
	public static final String REGISTRO_SITUACAO_DO_ARQUIVO_BB_REGISTRADO = "1";
	public static final String REGISTRO_SITUACAO_DO_ARQUIVO_BB_FINALIZADO = "2";
	public static final String REGISTRO_SITUACAO_DO_ARQUIVO_BB_INVALIDO = "3";
	public static final String REGISTRO_SITUACAO_DO_ARQUIVO_BB_IGNORAR = "4";
	public static final String REGISTRO_SITUACAO_DO_ARQUIVO_BB_REGISTRADO_ID = "4211";
	public static final Integer ID_REGISTRO_SITUACAO_DO_ARQUIVO_BB_REGISTRADO = 4211;
	public static final String REGISTRO_SITUACAO_DO_ARQUIVO_BB_FINALIZADO_ID = "4212";
	public static final Integer ID_REGISTRO_SITUACAO_DO_ARQUIVO_BB_FINALIZADO = 4212;
	public static final String REGISTRO_SITUACAO_DO_ARQUIVO_BB_INVALIDO_ID = "4298";
	public static final String REGISTRO_SITUACAO_DO_ARQUIVO_BB_PENDENTE_ID = "4281";

	/**
	 * Situa��o DAD
	 */
	public static final Integer DOMINIO_SITUACAO_DAD = 2112;
	public static final String REGISTRO_SITUACAO_DAD_SOLICITADO = "1";
	public static final String REGISTRO_SITUACAO_DAD_CANCELADO = "2";
	public static final String REGISTRO_SITUACAO_DAD_EFETIVADO = "3";
	public static final String REGISTRO_SITUACAO_DAD_CONSOLIDADO = "4";
	public static final String REGISTRO_SITUACAO_DAD_FINALIZADO = "5";
	public static final String REGISTRO_SITUACAO_DAD_PENDENTE = "6";


	/**
	 * Tipo de arquivos BB
	 */
	public static final Integer DOMINIO_ARQUIVOS_BB = 2053;
	public static final int REGISTRO_ARQUIVO_BB_CHEQUE_ENVIO = 100;
	public static final int REGISTRO_PEFIN_INCLUSAO_BAIXA_SERASA = 101;
	public static final int REGISTRO_PAGAMENTO_FATURA = 201;
	public static final int REGISTRO_ALTERACAO_CLIENTE = 202;
	public static final int REGISTRO_IMPORTACAO_CLIENTE = 203;
	public static final int REGISTRO_ARQUIVO_MOVIMENTO_DEB_CRE = 205;
	public static final int REGISTRO_ARQUIVO_BB_COO400 = 400;
	public static final int REGISTRO_ARQUIVO_BB_COO401 = 401;
	public static final int REGISTRO_ARQUIVO_BB_COO402 = 402;
	public static final int REGISTRO_ARQUIVO_BB_COO403 = 403;
	public static final int REGISTRO_ARQUIVO_BB_COO404 = 404;
	public static final int REGISTRO_ARQUIVO_BB_COO405 = 405;
	public static final int REGISTRO_ARQUIVO_BB_COO406 = 406;
	public static final int REGISTRO_ARQUIVO_BB_COO407 = 407;
	public static final int REGISTRO_ARQUIVO_BB_COO408 = 408;
	public static final int REGISTRO_ARQUIVO_BB_COO409 = 409;
	public static final int REGISTRO_ARQUIVO_BB_COO410 = 410;
	public static final int REGISTRO_ARQUIVO_BB_COO500 = 500;
	public static final int REGISTRO_ARQUIVO_BB_COO501 = 501;
	public static final int REGISTRO_ARQUIVO_BB_COO502 = 502;
	public static final int REGISTRO_ARQUIVO_BB_COO503 = 503;
	public static final int REGISTRO_ARQUIVO_BB_COO504 = 504;
	public static final int REGISTRO_ARQUIVO_BB_COO505 = 505;
	public static final int REGISTRO_ARQUIVO_BB_COO506 = 506;
	public static final int REGISTRO_ARQUIVO_BB_COO507 = 507;
	public static final int REGISTRO_ARQUIVO_BB_COO508 = 508;
	public static final int REGISTRO_ARQUIVO_BB_COO509 = 509;
	public static final int REGISTRO_ARQUIVO_BB_COO510 = 510;
	public static final int REGISTRO_ARQUIVO_BB_COO550 = 550;
	public static final int REGISTRO_ARQUIVO_BB_COO551 = 551;
	public static final int REGISTRO_ARQUIVO_BB_COO552 = 552;
	public static final int REGISTRO_ARQUIVO_BB_COO553 = 553;
	public static final int REGISTRO_ARQUIVO_BB_DEB558 = 558;
	public static final int REGISTRO_ARQUIVO_BB_COO598 = 598;
	public static final int REGISTRO_ARQUIVO_BB_COO599 = 599;
	public static final int REGISTRO_ARQUIVO_BB_CHEQUE_RETORNO = 600;
	public static final int REGISTRO_RETORNO_PEFIN_SERASA = 601;
	public static final int REGISTRO_REMESSA_INFORMATIVA_PEFIN_SERASA = 602;
	public static final int REGISTRO_ARQUIVO_EXTRATO_BANCARIO = 700;
	public static final int REGISTRO_ARQUIVO_EXTRATO_BANCARIO_BASER = 701;
	public static final int REGISTRO_ARQUIVO_EXTRATO_BANRISUL = 702;
	public static final String CODIGO_REGISTRO_ARQUIVO_EXTRATO_BANRISUL = "702";
	public static final int REGISTRO_ARQUIVO_EXTRATO_BRADESCO = 703;
	public static final String CODIGO_REGISTRO_ARQUIVO_EXTRATO_BRADESCO = "703";
	public static final int REGISTRO_ARQUIVO_CBF_800 = 800;
	public static final int REGISTRO_EXPORTACAO_FATURA_DEBITO_AUTOMATICO = 801;
	public static final int REGISTRO_EXPORTACAO_LANCAMENTO_DA_COMPE = 4000;
	public static final int REGISTRO_EXPORTACAO_FATURAS_CDC = 802;
	public static final int REGISTRO_PAGAMENTO_CREDENCIADA = 803;
	public static final int REGISTRO_ARQUIVO_EMBOSSING_CARTAO = 804;
	public static final int REGISTRO_ARQUIVO_RETORNO_MOVIMENTO_DEB_CRE = 805;
	public static final int REGISTRO_ARQUIVO_IMPORTACAO_MOVIMENTO_PROCESSADORA_CABAL = 806;
	public static final int REGISTRO_ARQUIVO_ENVIO_CADASTRO_CONTAS_CARTOES_CABAL = 807;
	public static final int REGISTRO_ARQUIVO_RECEBIMENTO_CADASTRO_CONTAS_CARTOES_CABAL = 808;
	public static final int REGISTRO_ARQUIVO_RECEBIMENTO_MOVIMENTOS_DEBITO_OFFLINE = 809;
	public static final int REGISTRO_ARQUIVO_ENVIAR_SALDOS_DEBITO_OFFLINE_CABAL = 810;
	public static final int REGISTRO_ARQUIVO_RECEBER_ARQUIVO_FATURAS = 811;
	public static final int REGISTRO_ARQUIVO_RECEBER_ARQUIVO_CARTAO_IOF = 813;
	public static final int REGISTRO_ARQUIVO_DVA604 = 901;
	public static final int REGISTRO_ARQUIVO_DVN604 = 902;
	public static final int REGISTRO_ARQUIVO_DVD604 = 903;
	public static final int REGISTRO_ARQUIVO_DVG604 = 904;
	public static final int REGISTRO_ARQUIVO_DAD604 = 905;
	public static final int REGISTRO_ARQUIVO_DCD604 = 906;
	public static final int REGISTRO_ARQUIVO_SSC607 = 907;
	public static final int REGISTRO_ARQUIVO_CCF607 = 908;
	public static final int REGISTRO_ARQUIVO_COB670 = 912;
	public static final int REGISTRO_ARQUIVO_COB605 = 910;
	public static final Integer ID_REGISTRO_ARQUIVO_COB605 = 4733;
	public static final int REGISTRO_ARQUIVO_DAD614 = 913;
	public static final int REGISTRO_ARQUIVO_RECEBER_POSICAO_CARTEIRA_CLASSIFICACAO_RISCO_PROCESSADORA_CABAL = 812;
	public static final int REGISTRO_ARQUIVO_DEVOLUCAO_COMPE = 4010;
	public static final String NOME_ARQUIVO_COO500 = "COO500";
	public static final String NOME_ARQUIVO_COO501 = "COO501";
	public static final String NOME_ARQUIVO_COO502 = "COO502";
	public static final String NOME_ARQUIVO_COO503 = "COO503";
	public static final String NOME_ARQUIVO_COO504 = "COO504";
	public static final String NOME_ARQUIVO_COO505 = "COO505";
	public static final String NOME_ARQUIVO_COO506 = "COO506";
	public static final String NOME_ARQUIVO_COO507 = "COO507";
	public static final String NOME_ARQUIVO_COO508 = "COO508";
	public static final String NOME_ARQUIVO_COO509 = "COO509";
	public static final String NOME_ARQUIVO_COO510 = "COO510";
	public static final String NOME_ARQUIVO_COO550 = "COO550";
	public static final String NOME_ARQUIVO_COO551 = "COO551";
	public static final String NOME_ARQUIVO_COO552 = "COO552";
	public static final String NOME_ARQUIVO_COO553 = "COO553";
	public static final String NOME_ARQUIVO_COO598 = "COO598";
	public static final String NOME_ARQUIVO_COO599 = "COO599";
	public static final String NOME_ARQUIVO_DEB558 = "DEB558";
	public static final String NOME_ARQUIVO_BBCHEQUE_RETORNO = "IEDCHQ";
	public static final String ARQUIVO_BBCHEQUE_RETORNO_SEGMENTO_N = "N";
	public static final String ARQUIVO_BBCHEQUE_RETORNO_SEGMENTO_O = "O";
	public static final String NOME_ARQUIVO_CBF800 = "CBF800";
	public static final String NOME_ARQUIVO_CSC6 = "CSC6";

	/**
	 * Prefixos dos arquivos da portal
	 */
	public static final String PREFIXO_EMBOSSING = "CAR";
	public static final String PREFIXO_FATURA_CDC = "CDC";
	public static final String PREFIXO_FATURA_CARTAO = "FAT";
	public static final String PREFIXO_RETORNO_MOVIMENTO_DEB_CRED = "RETMOVDEBCRED";

	/**
	 * Operacao
	 */
	public static final Integer DOMINIO_ALTERAR_CHEQUES = 2051;
	public static final String REGISTRO_ALTERAR_CHEQUES_EXCLUIR_CHEQUES_CCF = "1";
	public static final String REGISTRO_ALTERAR_CHEQUES_CANCELAR_CONTRA_ORDEM_CHEQUES = "2";
	public static final String REGISTRO_ALTERAR_CHEQUES_CANCELAR_CHEQUES = "3";
	public static final String REGISTRO_ALTERAR_CHEQUES_INCLUIR_CONTRA_ORDEM_CHEQUES = "4";
	public static final String REGISTRO_ALTERAR_CHEQUES_CONSULTAR_CHEQUES = "5";
	public static final String REGISTRO_ALTERAR_CHEQUES_REPROCESSAR_CHEQUES_IRREGULARES = "6";
	public static final String REGISTRO_ALTERAR_CHEQUES_ATIVAR_CHEQUES_CANCELADOS = "7";
	public static final String REGISTRO_ALTERAR_CHEQUES_CANCELAR_INCLUSAO_NO_CCF = "8";
	public static final String REGISTRO_ALTERAR_CHEQUES_SITUACAO = "9";
	public static final String REGISTRO_ALTERAR_CHEQUES_ALINEA = "10";

	/**
	 * Situacao Processamento
	 */
	public static final Integer DOMINIO_SITUACAO_PROCESSAMENTO = 3256;
	public static final String DOMINIO_SITUACAO_PROCESSAMENTO_REGISTRADO = "1";
	public static final String DOMINIO_SITUACAO_PROCESSAMENTO_NUMERO_SEQUENCIAL_REGISTRO = "2";
	public static final String DOMINIO_SITUACAO_PROCESSAMENTO_CODIGO_INTEGRACAO_COOPERADO = "3";
	public static final String DOMINIO_SITUACAO_PROCESSAMENTO_DIGITO_CODIGO_INTEGRACAO = "4";
	public static final String DOMINIO_SITUACAO_PROCESSAMENTO_NUMERO_INICIAL_CHEQUE = "5";
	public static final String DOMINIO_SITUACAO_PROCESSAMENTO_NUMERO_FINAL_CHEQUE = "6";
	public static final String DOMINIO_SITUACAO_PROCESSAMENTO_CODIGO_COMANDO_IRREGULAR = "7";
	public static final String DOMINIO_SITUACAO_PROCESSAMENTO_MOTIVO_CONTRA_ORDEM_IRREGULAR = "8";
	public static final String DOMINIO_SITUACAO_PROCESSAMENTO_NUMERO_CHEQUE = "9";
	public static final String DOMINIO_SITUACAO_PROCESSAMENTO_VALOR_CHEQUE = "10";
	public static final String DOMINIO_SITUACAO_PROCESSAMENTO_CODIGO_MOTIVO_DEVOLUCAO = "11";
	public static final String DOMINIO_SITUACAO_PROCESSAMENTO_DATA_DEVOLUCAO_CHEQUE = "12";
	public static final String DOMINIO_SITUACAO_PROCESSAMENTO_NOME_COOPERADO = "13";
	public static final String DOMINIO_SITUACAO_PROCESSAMENTO_NUMERO_SEQUENCIAL_TITULARIDADE_COOPERADO = "14";
	public static final String DOMINIO_SITUACAO_PROCESSAMENTO_DATA_INCLUSAO = "15";
	public static final String DOMINIO_SITUACAO_PROCESSAMENTO_SERIE_CHEQUE_TITULAR = "16";
	public static final String DOMINIO_SITUACAO_PROCESSAMENTO_TIPO_PESSOA_IRREGULAR = "17";
	public static final String DOMINIO_SITUACAO_PROCESSAMENTO_CPF_CNPJ_COOPERADO_IRREGULAR = "18";
	public static final String DOMINIO_SITUACAO_PROCESSAMENTO_FINALIZADO = "19";

	public static final Integer DOMINIO_SITUACAO_PROCESSAMENTO_506 = 2064;
	public static final String DOMINIO_SITUACAO_PROCESSAMENTO_506_NUMERO_SEQUENCIAL_REGISTRO = "1";
	public static final String DOMINIO_SITUACAO_PROCESSAMENTO_506_CODIGO_INTEGRACAO_COOPERADO = "2";
	public static final String DOMINIO_SITUACAO_PROCESSAMENTO_506_DIGITO_CODIGO_INTEGRACAO = "3";
	public static final String DOMINIO_SITUACAO_PROCESSAMENTO_506_NUMERO_INICIAL_CHEQUE = "4";
	public static final String DOMINIO_SITUACAO_PROCESSAMENTO_506_NUMERO_FINAL_CHEQUE = "5";
	public static final String DOMINIO_SITUACAO_PROCESSAMENTO_506_CODIGO_COMANDO_IRREGULAR = "6";
	public static final String DOMINIO_SITUACAO_PROCESSAMENTO_506_MOTIVO_CONTRA_ORDEM_IRREGULAR = "7";

	public static final Integer PROCEDIMENTO_ACIONADOR_IMPORTAR_MOVIMENTO_COMPENSAR = 1014;
	public static final Integer PROCEDIMENTO_ACIONADOR_GERAR_MOVIMENTO_DEVOLUCAO_CHEQUE = 1023;
	
	public static final Integer PROCEDIMENTO_ACIONADOR_COBRAR_TARIFA_CHEQUES_SUPERIORES = 1063;
	public static final Integer PROCEDIMENTO_FASE_ACIONADOR_COBRAR_TARIFA_CHEQUES_SUPERIORES = 10631;
	
	public static final Integer PROCEDIMENTO_ACIONADOR_COBRAR_TARIFA_CHEQUES_INFERIORES = 1118;
	public static final Integer PROCEDIMENTO_FASE_ACIONADOR_COBRAR_TARIFA_CHEQUES_INFERIORES = 11181;

	public static final Integer PROCEDIMENTO_ACIONADOR_EXPIRAR_CONTRAORDENS_PROVISORIAS = 1094;
	public static final Integer PROCEDIMENTO_FASE_ACIONADOR_EXPIRAR_CONTRAORDENS_PROVISORIAS = 10941;
	
	public static final Integer CODIGO_PROCEDIMENTO_ACIONADOR_ENVIAR_NOTIFICACAO_INCLUSAO_CCF = 1016;
	public static final Integer CODIGO_FASE_PROCEDIMENTO_ACIONADOR_ENVIAR_NOTIFICACAO_INCLUSAO_CCF = 10161;

	public static final Integer CODIGO_PROCEDIMENTO_ACIONADOR_RELATORIO_TERMO_ADESAO_CAPITALIZACAO_PROGRAMADA = 1103;
	public static final Integer CODIGO_FASE_ACIONADOR_RELATORIO_TERMO_ADESAO_CAPITALIZACAO_PROGRAMADA = 11031;

	public static final Integer CODIGO_PROCEDIMENTO_ACIONADOR_RELATORIO_TERMO_ENCERRAMENTO_CAPITALIZACAO_PROGRAMADA = 1104;
	public static final Integer CODIGO_FASE_ACIONADOR_RELATORIO_TERMO_ENCERRAMENTO_CAPITALIZACAO_PROGRAMADA = 11041;

	public static final Integer CODIGO_PROCEDIMENTO_ACIONADOR_ARQUIVO_BB_CHEQUE_ENVIO = 1054;
	public static final Integer CODIGO_FASE_PROCEDIMENTO_ACIONADOR_ARQUIVO_BB_CHEQUE_ENVIO_GERAR = 10541;
	public static final Integer CODIGO_FASE_PROCEDIMENTO_ACIONADOR_ARQUIVO_BB_CHEQUE_ENVIO_ATUALIZAR = 10542;

	public static final Integer DOMINIO_OPERACAO_CONTRA_ORDEM_CHEQUE = 2054;
	public static final String REGISTRO_OPERACAO_CONTRA_ORDEM_CHEQUE_CANCELAMENTO = "1";
	public static final String REGISTRO_OPERACAO_CONTRA_ORDEM_CHEQUE_INCLUSAO = "2";

	public static final Integer DOMINIO_SITUACAO_CONTRA_ORDEM_CHEQUE = 2055;
	public static final String REGISTRO_SITUACAO_CONTRA_ORDEM_CHEQUE_ATIVO = "1";
	public static final String REGISTRO_SITUACAO_CONTRA_ORDEM_CHEQUE_INATIVO = "2";
	public static final String REGISTRO_SITUACAO_CONTRA_ORDEM_CHEQUE_COMPENSADO = "7";
	
	
	public static final Integer PROCEDIMENTO_ACIONADOR_LANCAMENTO_COMPE = 1109;
	public static final Integer CODIGO_FASE_PROCEDIMENTO_ACIONADOR_LANCAMENTO_COMPE_IMPORTAR= 11091;
	public static final Integer CODIGO_FASE_PROCEDIMENTO_ACIONADOR_LANCAMENTO_COMPE_PROCESSAR = 11092;

	/**
	 * Dominio tipo da declaracao do movimento de numerario
	 */
	public static final Integer DOMINIO_TIPO_DA_DECLARACAO_DO_MOVIMENTO_DE_NUMERARIO = 2078;
	public static final String REGISTRO_SITUACAO_TIPO_DA_DECLARACAO_DO_MOVIMENTO_DE_NUMERARIO_SAQUE = "1";
	public static final String REGISTRO_SITUACAO_TIPO_DA_DECLARACAO_DO_MOVIMENTO_DE_NUMERARIO_DEPOSITO = "2";

	/**
	 * Dominio Situa��o do movimento banc�rio
	 */
	public static final Integer DOMINIO_SITUACAO_MOVIMENTO_BANCARIO = 2060;
	public static final String REGISTRO_SITUACAO_MOVIMENTO_BANCARIO_PENDENTE = "1";
	public static final String REGISTRO_SITUACAO_MOVIMENTO_BANCARIO_NAO_CONCILIADO = "2";
	public static final String REGISTRO_SITUACAO_MOVIMENTO_BANCARIO_CONCILIADO = "3";
	public static final String REGISTRO_SITUACAO_MOVIMENTO_BANCARIO_ESTORNADO = "4";
	public static final String REGISTRO_SITUACAO_MOVIMENTO_BANCARIO_ESTORNO = "5";
	public static final String REGISTRO_SITUACAO_MOVIMENTO_BANCARIO_TRANSFERENCIA = "6";
	public static final String REGISTRO_SITUACAO_MOVIMENTO_BANCARIO_FINALIZADO = "7";
	public static final String REGISTRO_SITUACAO_MOVIMENTO_BANCARIO_LANCADO = "8";
	public static final String REGISTRO_SITUACAO_MOVIMENTO_BANCARIO_REGISTRADO = "9";
	public static final String REGISTRO_SITUACAO_MOVIMENTO_BANCARIO_HISTORICO_INVALIDO = "10";
	public static final Integer REGISTRO_SITUACAO_MOVIMENTO_BANCARIO_TRANSFERENCIA_ID = 4294;
	public static final Integer REGISTRO_SITUACAO_MOVIMENTO_BANCARIO_ESTORNADO_ID = 4292;
	public static final Integer REGISTRO_SITUACAO_MOVIMENTO_BANCARIO_ESTORNO_ID = 4293;
	public static final Integer REGISTRO_SITUACAO_MOVIMENTO_BANCARIO_NAO_CONCILIADO_ID = 4282;
	public static final Integer REGISTRO_SITUACAO_MOVIMENTO_BANCARIO_PENDENTE_ID = 4281;
	public static final Integer REGISTRO_SITUACAO_MOVIMENTO_BANCARIO_FINALIZADO_ID = 4326;
	public static final Integer REGISTRO_SITUACAO_MOVIMENTO_BANCARIO_HISTORICO_INVALIDO_ID = 4377;

	/**
	 * Dom�nio Destino do Lan�amento
	 */
	public static final Integer DOMINIO_DESTINO_LANCAMENTO = 2061;
	public static final String REGISTRO_DESTINO_LANCAMENTO_TESOURARIA = "1";
	public static final String REGISTRO_DESTINO_LANCAMENTO_CONTAS_BANCARIAS = "2";
	public static final String REGISTRO_DESTINO_LANCAMENTO_CONTAS_ASSOCIADO = "3";
	public static final String REGISTRO_DESTINO_LANCAMENTO_DESPESAS_TARIFA = "4";
	public static final String REGISTRO_DESTINO_LANCAMENTO_RECEITAS_DIVERSAS = "5";

	/**
	 * Dom�nio Situa��o do Banco
	 */
	public static final Integer DOMINIO_SITUACAO_BANCO = 2062;
	public static final String REGISTRO_SITUACAO_BANCO_ATIVO = "1";
	public static final String REGISTRO_SITUACAO_BANCO_INATIVO = "2";

	/**
	 * Dominio de Finalidade da Ted
	 */
	public static final Integer DOMINIO_REGISTRO_FINALIDADE_CLIENTE_TED = 1118;
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_DE_IMPOSTOS_TRIBUTOS_E_TAXAS = "1";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_A_CONCESSIONARIAS_DE_SERVICO_PUBLICO = "2";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTOS_DE_DIVIDENDOS = "3";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_DE_SALARIOS = "4";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_DE_FORNECEDORES = "5";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_DE_HONORARIOS = "6";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_DE_ALUGUEIS_E_TAXAS_DE_CONDOMINIO = "7";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_DE_DUPLICATAS_E_TITULOS = "8";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_DE_MENSALIDADE_ESCOLAR = "9";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_CREDITO_EM_CONTA = "10";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_A_CORRETORAS = "11";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_DE_BOLETO_BANCARIO_EM_CARTORIO = "12";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_DE_TARIFAS_PELA_PRESTACAO_DE_SERVICOS_DE_ARRECADACAO_DE_CONVENIOS = "13";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_REPASSE_DE_VALORES_REFERENTES_A_TITULOS_LIQUIDADOS_EM_CARTORIOS_DE_PROTESTO = "14";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_LIQUIDACAO_FINANCEIRA_DE_OPERADORA_DE_CARTAO = "15";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_OPERACOES_SEGURO_HABITACIONAL_SFH = "18";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_OPERACOES_DO_FDS_CAIXA = "19";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_DE_ACORDO_EXECUCAO_JUDICIAL = "27";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_LIQUIDACAO_DE_EMPRESTIMOS_CONSIGNADOS = "28";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_DE_BOLSA_AUXILIO = "29";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_REMUNERACAO_A_COOPERADO = "30";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_DE_PREBENDA_REMUNERACAO_A_PADRES_E_SACERDOTES = "31";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_DE_JUROS_SOBRE_CAPITAL_PROPRIO = "33";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_DE_RENDIMENTOS_OU_AMORTIZACAO_S_COTAS_EOU_DEBENTURES = "34";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_TAXA_DE_SERVICO = "35";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_DE_JUROS_EOU_AMORTIZACAO_DE_TITULOS_DEPOSITADOS_EM_GARANTIA_NAS_CAMARAS = "37";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_ESTORNO_OU_RESTITUICAO_DIVERSOS = "38";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_DE_VALE_TRANSPORTE = "39";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_SIMPLES_NACIONAL = "40";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_REPASSE_DE_VALORES_PARA_O_FUNDEB = "41";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_REPASSE_DE_VALORES_DE_CONVENIO_CENTRALIZADO = "42";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PATROCINIO_COM_INCENTIVO_FISCAL = "43";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_DOACAO_COM_INCENTIVO_FISCAL = "44";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_TRANSFERENCIA_DE_CONTA_CORRENTE_DE_INSTITUICAO_NAO_BANCARIA_PARA_SUA_CONTA_DE_LIQUIDACAO = "45";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_DE_RESCISAO_DE_CONTRATO_DE_TRABALHO = "47";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_REEMBOLSO_DE_DESPESAS_COM_ESTRUTURACAO_DE_OPERACOES_DE_RENDA_FIXA_E_VARIAVEL = "50";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_COMPRA_DE_MOEDA_ESTRANGEIRA_PELO_FSB_FUNDO_SOBERANO_DO_BRASIL = "97";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_DEPOSITO_JUDICIAL = "100";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PENSAO_ALIMENTICIA = "101";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_CESSAO_DE_CREDITOS_LIQ_PRINC_POR_AQUIS_CRED_OU_DIREITOS_CREDITORIOS_OU_FLX_DE_CX_GA_POR_CRED_POR_ORDEM_CLIENTE_PJ_FIN = "103";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_CESSAO_DE_CREDITOS_LIQ_PRINC_POR_AQUIS_CRED_OU_DIREITOS_CREDITORIOS_POR_ORDEM_DE_FIDC_OU_CIA_SECURITIZADORA = "104";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_CESSAO_DE_CREDITOS_REPASSE_CONTRATUAL_DE_FLUXO_DE_CAIXA_OU_DE_RECEBIVEIS_PAGOS_POR_ORDEM_DE_CLIENTE_PJ_FINANCEIRA = "107";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_CESSAO_DE_CREDITOS_REPASSE_CONTR_DE_FLX_DE_CX_OU_DE_RECEBIVEIS_PGS_ANTECIPADAMENTE_POR_ORDEM_DE_CLIENTE_PJ_FIN = "108";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_CESSAO_DE_CREDITOS_AJUSTES_DIVERSOS = "109";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_TRANSFERENCIA_ENTRE_CONTAS_DE_MESMA_TITULARIDADE = "110";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_CREDITO_PARA_INVESTIDOR_EM_CLIENTE_DA_IF_CREDITADA = "111";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_DEBITO_DE_INVESTIDOR_EM_CLIENTE_DA_IF_DEBITADA = "112";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_DE_OPERACOES_DE_CREDITO_POR_CLIENTE = "113";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_RESGATE_DE_APLICACAO_FINANCEIRA_DE_CLIENTE_PARA_CONTA_DE_SUA_TITULARIDADE = "114";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_APLICACAO_FINANCEIRA_EM_NOME_DO_CLIENTE_REMETENTE = "117";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_CESSAO_DE_CREDITOS_LIQ_PRINC_POR_REC_CRED_OU_DIREITOS_CREDITORIOS_OU_FLX_DE_CX_GA_POR_CRED_POR_ORDEM_CLIENTE_PJ_FIN = "123";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_CESSAO_DE_CREDITOS_LIQ_PRINC_POR_REC_CRED_OU_DIREITOS_CREDITORIOS_POR_ORDEM_DE_FIDC_OU_CIA_SECURITIZADORA = "124";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_FGCOOP_RECOLHIMENTO_FUNDO_GARANTIDOR_DO_COOPERATIVISMO_DE_CREDITO = "131";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_FGCOOP_DEVOLUCAO_DE_RECOLHIMENTO_A_MAIOR = "132";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_TRANSFERENCIA_INTERNACIONAL_EM_REAIS = "200";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_AJUSTE_POSICAO_MERCADO_FUTURO = "201";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_REPASSE_DE_VALORES_DO_BNDES = "202";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_LIQUIDACAO_DE_COMPROMISSOS_JUNTO_AO_BNDES = "203";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_OPERACOES_DE_COMPRA_E_VENDA_DE_ACOES_BOLSAS_DE_VALORES_E_MERCADO_DE_BALCAO = "204";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_CONTRATOS_REFERENCIADOS_EM_ACOES_OU_INDICES_DE_ACOES_BOLSAS_DE_VALORES_DE_MERCADORIAS_E_DE_FUTUROS = "205";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_OPERACAO_DE_CAMBIO_NAO_INTERBANCARIA = "206";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_OPERACOES_NO_MERCADO_DE_RENDA_FIXA_E_DE_RENDA_VARIAVEL_COM_UTILIZACAO_DE_INTERMEDIARIO = "207";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_OPERACAO_DE_CAMBIO_MERCADO_INTERBANCARIO_INSTITUICOES_SEM_CONTA_RESERVAS_BANCARIAS = "208";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_DE_OPERACOES_COM_IDENTIFICACAO_DE_DESTINATARIO_FINAL = "209";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_RESTITUICAO_DE_IMPOSTO_DE_RENDA = "300";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_ORDEM_BANCARIA_DO_TESOURO_OBT = "301";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_DE_MULTAS_AO_BACEN_POR_ATRASOS_DE_IMPORTACAO = "302";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_RESTITUICAO_DE_TRIBUTOS_RFB = "303";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_RESTITUICAO_DE_PREMIOS_DE_SEGUROS = "500";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_DE_INDENIZACAO_DE_SINISTRO_DE_SEGURO = "501";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_DE_PREMIO_DE_CO_SEGURO = "502";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_DE_INDENIZACAO_DE_SINISTRO_DE_CO_SEGURO = "504";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_DE_PREMIO_DE_RESSEGURO = "505";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_DE_INDENIZACAO_DE_SINISTRO_DE_RESSEGURO = "507";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_RESTITUICAO_DE_INDENIZACAO_DE_SINISTRO_DE_RESSEGURO = "508";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_DE_DESPESAS_COM_SINISTROS = "509";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_DE_INSPECOESVISTORIAS_PREVIAS = "510";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_DE_RESGATE_DE_TITULO_DA_CAPITALIZACAO = "511";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_DE_SORTEIO_DE_TITULO_DE_CAPITALIZACAO = "512";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_DE_DEVOLUCAO_DE_MENSALIDADE_DE_TITULO_DE_CAPITALIZACAO = "513";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_RESTITUICAO_DE_CONTRIBUICAO_DE_PLANO_PREVIDENCIARIO = "514";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_DE_BENEFICIO_PREVIDENCIARIO_DE_PECULIO = "515";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_DE_BENEFICIO_PREVIDENCIARIO_DE_PENSAO = "516";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_DE_BENEFICIO_PREVIDENCIARIO_DE_APOSENTADORIA = "517";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_DE_RESGATE_PREVIDENCIARIO = "518";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_DE_COMISSAO_DE_CORRETAGEM = "519";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_PAGAMENTO_DE_TRANSFERENCIASPORTABILIDADE_DE_RESERVA_DE_SEGUROPREVIDENCIA = "520";
	public static final String REGISTRO_FINALIDADE_CLIENTE_TED_OUTROS = "99999";
	
	/**
	 * Dom�nio FINALIADE DOC/TED
	 */
	public static final Integer DOMINIO_REGISTRO_FINALIDADE_DOC_TED = 2059;
	public static final String REGISTRO_FINALIDADE_DOC_TED_CREDITO_EM_CONTA_CORRENTE = "1";
	public static final String REGISTRO_FINALIDADE_DOC_TED_PAGAMENTO_DE_ALUGUEL_CONDOMINIOS = "2";
	public static final String REGISTRO_FINALIDADE_DOC_TED_PAGAMENTO_DE_DUPLICATAS_TITULOS = "3";
	public static final String REGISTRO_FINALIDADE_DOC_TED_PAGAMENTO_DE_DIVIDENDOS = "4";
	public static final String REGISTRO_FINALIDADE_DOC_TED_PAGAMENTO_MENSALIDADE_ESCOLARES = "5";
	public static final String REGISTRO_FINALIDADE_DOC_TED_PAGAMENTO_SALARIOS = "6";
	public static final String REGISTRO_FINALIDADE_DOC_TED_PAGAMENTO_FORNECEDORES_HONORARIOS = "7";
	public static final String REGISTRO_FINALIDADE_DOC_TED_OPERACAO_CAMBIO_FUNDOS_BOLSA_DE_VALORES = "8";
	public static final String REGISTRO_FINALIDADE_DOC_TED_REPASSE_DE_ARRECADACAO_PAGAMENTO_DE_TRIBUTOS = "9";
	public static final String REGISTRO_FINALIDADE_DOC_TED_TRANSFERENCIA_INTERNACIONAL_EM_REAIS = "10";
	public static final String REGISTRO_FINALIDADE_DOC_TED_CREDITO_EM_CONTA_DE_POUPANCA = "11";
	public static final String REGISTRO_FINALIDADE_DOC_TED_OUTROS = "12";

	/**
	 * Dom�nio Semestre
	 */
	public static final Integer DOMINIO_SEMESTRE = 2068;
	public static final String REGISTRO_PRIMEIRO_SEMESTRE = "1";
	public static final String REGISTRO_SEGUNDO_SEMESTRE = "2";

	/**
	 * Dom�nio Tipo de Declara��o
	 */
	public static final Integer DOMINIO_TIPO_DECLARACAO = 2069;
	public static final String REGISTRO_TIPO_DECLARACAO_NORMAL = "0";
	public static final String REGISTRO_TIPO_DECLARACAO_RETIFICADORA = "1";

	/**
	 * Dom�nio Situa��o do CBF 800 no sistema
	 */
	public static final Integer DOMINIO_SITUACAO_CBF800 = 2066;
	public static final String REGISTRO_SITUACAO_CBF800_INEXISTENTE_NO_SISTEMA = "1";
	public static final String REGISTRO_SITUACAO_CBF800_CONCILIADO = "2";
	public static final String REGISTRO_SITUACAO_CBF800_PENDENTE = "3";
	public static final String REGISTRO_SITUACAO_CBF800_FINALIZADO = "4";
	public static final String REGISTRO_SITUACAO_CBF800_VALOR_IRREGULAR = "5";

	/**
	 * Dom�nio Tipo do Cheque
	 */
	public static final Integer DOMINIO_TIPO_CHEQUE = 2073;
	public static final String REGISTRO_TIPO_CHEQUE_CONFECCIONADO_COOPERATIVA = "001";
	public static final String REGISTRO_TIPO_CHEQUE_COMUM_COOPERATIVO = "060";
	public static final String REGISTRO_TIPO_CHEQUE_ESP_COOPERATIVO = "145";
	public static final String REGISTRO_TIPO_CHEQUE_FROM_A4_COOPERATIVO = "991";
	public static final String REGISTRO_TIPO_CHEQUE_FROM_CONT_COOPERATIVA_2_VIAS = "993";
	public static final String REGISTRO_TIPO_CHEQUE_FROM_CONT_COOPERATIVA_1_VIA = "998";
	public static final String REGISTRO_TIPO_CHEQUE_COMPE_PROPRIA = "999";

	public static final Integer NUMERO_DE_DIAS_SESSENTA = 60;

	/**
	 * Atualiza��o efetuada no Coo405
	 */
	public static final Integer COO405_OPERACAO_ALTERA_INTEGRACAO = 1;
	@Deprecated
	public static final Integer COO405_OPERACAO_ENCERRA_INTEGRACAO = 2;
	public static final Integer COO405_OPERACAO_INCLUI_TITULAR = 3;
	public static final Integer COO405_OPERACAO_ALTERA_TITULAR = 4;
	public static final Integer COO405_OPERACAO_EXCLUI_TITULAR = 5;

	/**
	 * Atualiza��o efetuada no Coo410
	 */
	public static final Integer COO410_OPERACAO_CADASTRO_PF_TITULAR = 1;
	public static final Integer COO410_OPERACAO_CADASTRO_PF_ADICIONAL = 2;
	public static final Integer COO410_OPERACAO_ALTERA_LIMITE = 3;
	public static final Integer COO410_OPERACAO_BLOQUEIO_DESBLOQUEIO_ENCERRAMENTO = 4;
	public static final Integer COO410_OPERACAO_CONSULTA_SALDO_CONTA_CARTAO = 5;
	public static final Integer COO410_OPERACAO_ENCERRAMENTO = 3;
	public static final Integer COO410_OPERACAO_DESBLOQUEIO = 2;

	/**
	 * Indicador de solicita��o ou n�o de bloqueio/desbloqueio no Coo405
	 */
	public static final Integer COO405_INDICADOR_SOLICITACAO_NAO = 0;
	public static final Integer COO405_INDICADOR_SOLICITACAO_BLOQUEIO = 1;
	public static final Integer COO405_INDICADOR_SOLICITACAO_DESBLOQUEIO = 2;

	public static final Integer ARQUIVO_EXTRATO_BANCARIO_SALDO = 999;
	public static final Integer ARQUIVO_EXTRATO_BANCARIO_SALDO_ANTERIOR = 000;

	public static final Integer LANCAMENTO_MANUAL_DEB558 = 0;
	public static final Integer LANCAMENTO_MANUAL_CONTA_BANCARIA = 1;

	public static final BigDecimal VALOR_LIMITE_LAVAGEM_DINHEIRO = new BigDecimal(
			"10000");

	public static final BigDecimal VALOR_LIMITE_CHEQUE_COMPE_NORMAIS = new BigDecimal(
			"249999.99");

	public static final String SITUACAO_CONTA_BB = "C";

	public static final String VIRGULA_ESPACO = ", ";

	/**
	 * Dom�nio Disponibilidade
	 */
	public static final Integer DOMINIO_DISPONIBILIDADE = 2063;
	public static final String REGISTRO_DISPONIBILIDADE_BANCO = "1";
	public static final String REGISTRO_DISPONIBILIDADE_CAIXA = "2";
	public static final String REGISTRO_DISPONIBILIDADE_TESOURARIA = "3";

	/**
	 * Dom�nio Situa��o do Limite Devedor
	 */
	public static final Integer DOMINIO_SITUACAO_LIMITE_DEVEDOR = 2067;
	public static final String REGISTRO_SITUACAO_LIMITE_DEVEDOR_ATIVO = "1";
	public static final String REGISTRO_SITUACAO_LIMITE_DEVEDOR_CANCELADO = "2";
	public static final Integer REGISTRO_ID_SITUACAO_LIMITE_DEVEDOR_ATIVO = 4327;
	public static final Integer REGISTRO_ID_SITUACAO_LIMITE_DEVEDOR_CANCELADO = 4328;

	/**
	 * Dominio Tipo do Movimento do Arquivo
	 */
	public static final Integer DOMINIO_TIPO_MOVIMENTO_ARQUIVO = 2070;
	public static final String REGISTRO_TIPO_MOVIMENTO_ARQUIVO_ENVIO = "1";
	public static final String REGISTRO_TIPO_MOVIMENTO_ARQUIVO_RETORNO = "2";

	/**
	 * Dominio Convenios Arquivo
	 */
	public static final Integer DOMINIO_CONVENIOS_ARQUIVO = 2071;
	public static final String REGISTRO_CONVENIOS_ARQUIVO_BANCO_DO_BRASIL = "1";
	public static final String REGISTRO_CONVENIOS_ARQUIVO_PORTAL_CARD = "2";
	public static final String REGISTRO_CONVENIOS_ARQUIVO_COBAN = "3";
	public static final String REGISTRO_CONVENIOS_ARQUIVO_ABBC = "4";

	public static final Integer DOMINIO_SITUACAO_CONTROLE_ARQUIVO = 2072;
	public static final String REGISTRO_SITUACAO_CONTROLE_ARQUIVO_AGUARDANDO_GERACAO = "1";
	public static final String REGISTRO_SITUACAO_CONTROLE_ARQUIVO_GERADO = "2";
	public static final String REGISTRO_SITUACAO_CONTROLE_ARQUIVO_ENVIADO = "3";
	public static final String REGISTRO_SITUACAO_CONTROLE_ARQUIVO_RECEBIDO = "4";
	public static final String REGISTRO_SITUACAO_CONTROLE_ARQUIVO_ERRO = "5";
	public static final String REGISTRO_SITUACAO_CONTROLE_ARQUIVO_AGUARDANDO_IMPORTACAO = "6";
	public static final String REGISTRO_SITUACAO_CONTROLE_ARQUIVO_IMPORTADO = "7";

	/**
	 * Dom�nio Tipo da Conta Banco.
	 */
	public static final Integer DOMINIO_TIPO_CONTA_BANCO = 3205;
	public static final String REGISTRO_TIPO_CONTA_BANCO_CONVENIO_DEB558 = "1";
	public static final String REGISTRO_TIPO_CONTA_BANCO_MOVIMENTO = "2";
	public static final String REGISTRO_TIPO_CONTA_BANCO_DEPOSITO = "3";
	public static final String REGISTRO_TIPO_CONTA_BANCO_CONVENIO_CRESOL = "4";

	/**
	 * Dominio Campos ordenacao DEB558
	 */
	public static final Integer DOMINIO_CAMPOS_DEB_558 = 2079;
	public static final String REGISTRO_CAMPOS_DEB_558_CONTA_CORRENTE = "1";
	public static final String REGISTRO_CAMPOS_DEB_558_CONTA_INTEGRACAO = "2";
	public static final String REGISTRO_CAMPOS_DEB_558_HISTORICO_BB = "3";
	public static final String REGISTRO_CAMPOS_DEB_558_CODIGO_OPERACAO = "4";
	public static final String REGISTRO_CAMPOS_DEB_558_DOCUMENTO = "5";
	public static final String REGISTRO_CAMPOS_DEB_558_VALOR = "6";
	public static final String REGISTRO_CAMPOS_DEB_558_DEBITO = "7";
	public static final String REGISTRO_CAMPOS_DEB_558_CREDITO = "8";

	/**
	 * Dominio Dia do Debito da Cesta
	 */
	public static final Integer DOMINIO_DIA_DEBITO_CESTA = 2081;
	public static final String REGISTRO_DIA_DEBITO_CESTA_CINCO = "1";
	public static final String REGISTRO_DIA_DEBITO_CESTA_DEZ = "2";
	public static final String REGISTRO_DIA_DEBITO_CESTA_QUINZE = "3";
	public static final String REGISTRO_DIA_DEBITO_CESTA_VINTE = "4";
	public static final String REGISTRO_DIA_DEBITO_CESTA_VINTE_CINCO = "5";

	/**
	 * Dominio FINALIDADE CLIENTE TED
	 */
	public static final Integer DOMINIO_FINALIDADE_CLIENTE_TED = 1118;

	/**
	 * Dominio SITUACAO DA TED NOSSA REMESSA
	 */
	public static final Integer DOMINIO_SITUACAO_TED_NOSSA_REMESSA = 1119;
	public static final String REGISTRO_SITUACAO_TED_NOSSA_REMESSA_EM_APROVACAO = "1";
	public static final String REGISTRO_SITUACAO_TED_NOSSA_REMESSA_ENVIADA = "2";
	public static final String REGISTRO_SITUACAO_TED_NOSSA_REMESSA_REGISTRADA = "3";
	public static final String REGISTRO_SITUACAO_TED_NOSSA_REMESSA_RECUSADA = "4";
	public static final String REGISTRO_SITUACAO_TED_NOSSA_REMESSA_CANCELADA = "5";
	public static final String REGISTRO_SITUACAO_TED_NOSSA_REMESSA_ERRO = "6";
	public static final String REGISTRO_SITUACAO_TED_NOSSA_REMESSA_INSUFICIENCIA_DE_SALDO = "7";

	/**
	 * Dominio SITUACAO DA TED SUA REMESSA
	 */
	public static final Integer DOMINIO_SITUACAO_TED_SUA_REMESSA = 1120;
	public static final String REGISTRO_SITUACAO_TED_SUA_REMESSA_REGISTRADA = "1";
	public static final String REGISTRO_SITUACAO_TED_SUA_REMESSA_RECUSADA = "2";
	public static final String REGISTRO_SITUACAO_TED_SUA_REMESSA_CANCELADA = "3";
	public static final String REGISTRO_SITUACAO_TED_SUA_REMESSA_ERRO = "4";

	/**
	 * Dominio SITUACAO ESPECIAL PARA DOCUMENTO DIMOF
	 */
	public static final Integer DOMINIO_SITUACAO_ESPECIAL_PARA_DOCUMENTO_DIMOF = 2082;
	public static final String REGISTRO_SITUACAO_ESPECIAL_PARA_DOCUMENTO_DIMOF_NAO_SE_APLICA = "1";
	public static final String REGISTRO_SITUACAO_ESPECIAL_PARA_DOCUMENTO_DIMOF_EXTINCAO = "2";
	public static final String REGISTRO_SITUACAO_ESPECIAL_PARA_DOCUMENTO_DIMOF_FUSAO = "3";
	public static final String REGISTRO_SITUACAO_ESPECIAL_PARA_DOCUMENTO_DIMOF_INCORPORACAO_INCORPORADA = "4";
	public static final String REGISTRO_SITUACAO_ESPECIAL_PARA_DOCUMENTO_DIMOF_CISAO_TOTAL = "5";

	/**
	 * Dominio SITUACAO DOCUMENTO ASSOCIADO
	 */
	public static final Integer DOMINIO_SITUACAO_DOCUMENTO_ASSOCIADO = 2088;
	public static final String REGISTRO_SITUACAO_DOCUMENTO_ASSOCIADO_UPLOAD_REALIZADO = "1";
	public static final String REGISTRO_SITUACAO_DOCUMENTO_ASSOCIADO_TRANSFERINDO_DOCUMENTO = "2";
	public static final String REGISTRO_SITUACAO_DOCUMENTO_ASSOCIADO_PROCESSANDO_DOCUMENTO = "3";
	public static final String REGISTRO_SITUACAO_DOCUMENTO_ASSOCIADO_OCORREU_ERRO = "4";
	public static final String REGISTRO_SITUACAO_DOCUMENTO_ASSOCIADO_PROCESSAMENTO_DOCUMENTO_CONCLUIDO = "5";
	
	/**
	 * Dominio SITUACAO TIPO HORARIO TED
	 */
	public static final Integer DOMINIO_TIPO_HORARIO_TED = 2089;
	public static final String REGISTRO_TIPO_HORARIO_AGENCIA = "1";
	public static final String REGISTRO_TIPO_HORARIO_OFICINA = "2";
	public static final String REGISTRO_TIPO_HORARIO_EXTERNO = "3";

	/**
	 * Dominio TIPO DE OPERA��O DO LAN�AMENTO
	 */
	public static final Integer DOMINIO_TIPO_OPERACAO_LANCAMENTO_COBRANCA = 2094;
	public static final String REGISTRO_TIPO_OPERACAO_LANCAMENTO_COBRANCA_D = "1";
	public static final String REGISTRO_TIPO_OPERACAO_LANCAMENTO_COBRANCA_C = "2";

	/**
	 * Dominio FORMA DE LANCAMENTO
	 */
	public static final Integer DOMINIO_FORMA_LANCAMENTO_COBRANCA = 2108;
	public static final String REGISTRO_FORMA_LANCAMENTO_COBRANCA_BB_COOPERADO = "1";
	public static final String REGISTRO_FORMA_LANCAMENTO_COBRANCA_BRADESCO_COOPERADO = "2";
	public static final String REGISTRO_FORMA_LANCAMENTO_COBRANCA_BRADESCO_COOPERARATIVA = "3";

	/**
	 * Dominio SITUA��O LAN�AMENTO BOLETO
	 */
	public static final Integer DOMINIO_SITUACAO_LANCAMENTO_BOLETO = 2095;
	public static final String REGISTRO_SITUACAO_LANCAMENTO_BOLETO_PENDENTE = "1";
	public static final String REGISTRO_SITUACAO_LANCAMENTO_BOLETO_LANCADO = "2";
	public static final String REGISTRO_SITUACAO_LANCAMENTO_BOLETO_CANCELADO = "3";
	public static final String REGISTRO_SITUACAO_LANCAMENTO_DUPLICATA_NAO_ENCONTRADA = "4";

	/**
	 * Dominio TIPO DE RELACIONAMENTO
	 */
	public static final Integer DOMINIO_TIPO_RELACIONAMENTO = 2096;
	public static final String REGISTRO_TIPO_RELACIONAMENTO_COBRANCA_BOLETO = "1";

	/**
	 * Dominio SITUA��O CONFIGURA��O COBRAN�A
	 */
	public static final Integer DOMINIO_SITUACAO_CONFIGURACAO_COBRANCA = 2097;
	public static final String REGISTRO_SITUACAO_CONFIGURACAO_COBRANCA_ATIVADA = "1";
	public static final String REGISTRO_SITUACAO_CONFIGURACAO_COBRANCA_DESATIVADA = "2";

	/**
	 * Dominio OPERA��ES DE COBRAN�A
	 */
	public static final Integer DOMINIO_OPERACOES_COBRANCA = 2101;
	public static final String COMPLEMENTO_OPERACOES_COBRANCA_REMESSA_CARTORIO = "23";
	public static final String COMPLEMENTO_OPERACOES_COBRANCA_DEBITO_TARIFA_CUSTAS = "28";

	/**
	 * Constante para diferenciar se um recebimento de contas � do tipo DARF.
	 */
	public static final String COMPROVANTE_RECEBIMENTO_ARRECADACOES_TIPO_DARF = "F1140";
	public static final int POSICAO_INICIAL_VALIDACAO_COMPROVANTE_DARF = 231;
	public static final int POSICAO_FINAL_VALIDACAO_COMPROVANTE_DARF = 236;

	/**
	 * Constante tempor�ria para o combo de descri��es de alinea da tela de
	 * configura��o devolu��o n�o abrir scroll lateral.
	 */
	public static final Integer TAMANHO_LIMITE_COMBO_ALINEA_DEVOLUCAO = 78;

	/**
	 * Constante para a consulta do relat�rio GCC-REL-009-001.
	 */
	public static final String SQL_REL_LAVAGEM_DINHEIRO_MOVIMENTOS_DIARIO_MENSAL = "select descricao, "
			+ "data_lancamento as datalancamento, "
			+ "nome_associado as nomeassociado,  "
			+ "cpf_cnpf as documento, "
			+ "mcc_nro_conta_destino as nroconta, "
			+ "dv_conta as dvconta, "
			+ "valor, "
			+ "deposito, "
			+ "saque "
			+ "from ( "
			+ "select descricao, "
			+ "data_lancamento, "
			+ "nome_associado, "
			+ "cpf_cnpf, "
			+ "mcc_nro_conta_destino, "
			+ "dv_conta, "
			+ "valor, "
			+ "sum(valor_deposito) as deposito, "
			+ "sum(valor_saque) as saque "
			+ "from ( "
			+ "select 'Contas com dep�sitos em dinheiro com soma di�ria superior a R$ 10.000,00' as descricao, "
			+ "cast(m.mcc_dt_hora_movimento as date) as data_lancamento, "
			+ "p.pes_nome as nome_associado, "
			+ "p.pes_nro_documento as cpf_cnpf, "
			+ "m.mcc_nro_conta_destino, "
			+ "cc.cct_dv_conta_corrente as dv_conta, "
			+ "sum( "
			+ "		 case "
			+ "when m.mcc_origem_lancamento IN ('S','C') then m.mcc_valor "
			+ "when m.mcc_origem_lancamento  = 'X' then - m.mcc_valor  "
			+ "end ) as valor , "
			+ "0 as valor_deposito,  "
			+ "0 as valor_saque "
			+ "from colmeia.tb_gcc_movimento_cc m "
			+ "join colmeia.tb_gcc_conta_corrente cc on m.mcc_cod_cooperativa_origem "
			+ "= cc.cct_cod_cooperativa and m.mcc_nro_conta_origem = cc.cct_nro_conta "
			+ "join colmeia.tb_gen_associado a on cc.cct_cod_cooperativa = "
			+ "a.ass_cod_cooperativa and cc.cct_matr_associado = a.ass_matr_associado "
			+ "join colmeia.tb_gen_pessoa p on a.ass_nro_documento = p.pes_nro_documento "
			+ "where m.mcc_cod_cooperativa_destino =  :codigoCooperativa "
			+ "and m.mcc_origem_lancamento in ('C', 'S', 'X') "
			+ "and m.mcc_cod_operacao_cc in (3, 88) "
			+ "and to_char(m.mcc_dt_hora_movimento, 'yyyymm') = :dataFormatoAnoMes "
			+ "group by "
			+ "cast(m.mcc_dt_hora_movimento as date), "
			+ "p.pes_nome, "
			+ "p.pes_nro_documento, "
			+ "m.mcc_nro_conta_destino, "
			+ "cc.cct_dv_conta_corrente "
			+ "UNION "
			+ "select 'Movimento de conta corrente mensal superior a R$ 10.000,00' as descricao, "
			+ "null, "
			+ "p.pes_nome as nome_associado, "
			+ "p.pes_nro_documento as cpf_cnpf, "
			+ "m.mcc_nro_conta_destino, "
			+ "cc.cct_dv_conta_corrente as dv_conta, "
			+ "sum( case "
			+ "		 when m.mcc_origem_lancamento IN ('S','C') then m.mcc_valor "
			+ "when m.mcc_origem_lancamento  = 'X' then - m.mcc_valor "
			+ "end ) as valor , "
			+ "sum( case "
			+ "when m.mcc_origem_lancamento IN ('S','C') then m.mcc_valor "
			+ "when m.mcc_origem_lancamento  = 'X' then - m.mcc_valor "
			+ "end ) as valor_deposito, "
			+ "0 as valor_saque "
			+ "from "
			+ "colmeia.tb_gcc_movimento_cc m "
			+ "join colmeia.tb_gcc_conta_corrente cc on m.mcc_cod_cooperativa_origem "
			+ "= cc.cct_cod_cooperativa and m.mcc_nro_conta_origem = cc.cct_nro_conta "
			+ "join colmeia.tb_gen_associado a on cc.cct_cod_cooperativa = "
			+ "a.ass_cod_cooperativa and cc.cct_matr_associado = a.ass_matr_associado "
			+ "join colmeia.tb_gen_pessoa p on a.ass_nro_documento = p.pes_nro_documento "
			+ "where m.mcc_cod_cooperativa_destino =  :codigoCooperativa "
			+ "	 and m.mcc_origem_lancamento in ('C', 'S', 'X') "
			+ "and m.mcc_cod_operacao_cc in (3, 88) "
			+ "and to_char(m.mcc_dt_hora_movimento, 'yyyymm') = :dataFormatoAnoMes "
			+ "group by "
			+ "p.pes_nome, "
			+ "p.pes_nro_documento, "
			+ "m.mcc_nro_conta_destino, "
			+ "cc.cct_dv_conta_corrente "
			+ "UNION "
			+ "select 'Movimento de conta corrente mensal superior a R$ 10.000,00' as descricao, "
			+ "null, "
			+ "p.pes_nome as nome_associado, "
			+ "p.pes_nro_documento as cpf_cnpf, "
			+ "m.mcc_nro_conta_destino, "
			+ "cc.cct_dv_conta_corrente as dv_conta, "
			+ "sum( "
			+ "case "
			+ "when m.mcc_origem_lancamento IN ('S','C') then m.mcc_valor "
			+ "when m.mcc_origem_lancamento  = 'X' then - m.mcc_valor "
			+ "end ) as valor , "
			+ "0 as valor_deposito,  "
			+ "sum(  "
			+ "case "
			+ "when m.mcc_origem_lancamento IN ('S','C') then m.mcc_valor "
			+ "when m.mcc_origem_lancamento  = 'X' then - m.mcc_valor  "
			+ "end ) as valor_saque  "
			+ "from "
			+ "colmeia.tb_gcc_movimento_cc m "
			+ "join colmeia.tb_gcc_conta_corrente cc on m.mcc_cod_cooperativa_origem "
			+ "= cc.cct_cod_cooperativa and m.mcc_nro_conta_origem = cc.cct_nro_conta "
			+ "join colmeia.tb_gen_associado a on cc.cct_cod_cooperativa = "
			+ "a.ass_cod_cooperativa and cc.cct_matr_associado = a.ass_matr_associado "
			+ "join colmeia.tb_gen_pessoa p on a.ass_nro_documento = p.pes_nro_documento "
			+ "where m.mcc_cod_cooperativa_destino = :codigoCooperativa "
			+ "and m.mcc_origem_lancamento in ('C', 'S', 'X') "
			+ "and m.mcc_cod_operacao_cc in (32, 33)  "
			+ "and to_char(m.mcc_dt_hora_movimento, 'yyyymm') = :dataFormatoAnoMes "
			+ "group by  "
			+ "p.pes_nome,  "
			+ "p.pes_nro_documento, "
			+ "mcc_nro_conta_destino, "
			+ "cc.cct_dv_conta_corrente "
			+ ") as foo  "
			+ "group by descricao, data_lancamento, nome_associado, cpf_cnpf, mcc_nro_conta_destino, dv_conta, valor "
			+ ") as zoo  "
			+ "where valor >= 10000 or deposito >= 10000 or saque >= 10000 "
			+ "order by  descricao, data_lancamento, nroconta ";

	/**
	 * Constante para a consulta do relat�rio GCC-REL-002-010-001-004
	 */
	public static final String SQL_SALDO_DIARIO_CONTRATO_LIMITE = " select "
			+ " CAST(cct_nro_conta AS text) ||'-'|| CAST(cct_dv_conta_corrente AS text) as conta, "
			+ " CASE WHEN pes_tipo_pessoa=3 THEN fn_reg_descricao(3) ELSE fn_reg_descricao(4) END AS \"tipoPessoa\","
			+ " pes_nome as associado, "
			+ " csp_nome AS pac, "
			+ " ass_cod_pac as \"codPac\", "
			+ " scc_vl_limite AS \"valorLimite\", "
			+ " scc_vl_uso_limite AS \"usoLimite\", "
			+ " scc_vl_limite-scc_vl_uso_limite AS \"sobraLimite\" "
			+ " FROM tb_gcc_saldo_cc saldo "
			+ " JOIN( "
			+ " SELECT scc_cod_cooperativa,scc_nro_conta,max(scc_data) AS scc_data "
			+ " FROM tb_gcc_saldo_cc max_scc "
			+ " WHERE max_scc.scc_data <= :dataBase "
			+ " AND max_scc.scc_cod_cooperativa = :codigoCooperativa "
			+ " GROUP BY max_scc.scc_nro_conta, max_scc.scc_cod_cooperativa) as max_saldo "
			+ " ON (max_saldo.scc_cod_cooperativa, max_saldo.scc_nro_conta, max_saldo.scc_data) = "
			+ " (saldo.scc_cod_cooperativa, saldo.scc_nro_conta, saldo.scc_data) "
			+ " JOIN tb_gcc_conta_corrente "
			+ " ON (saldo.scc_cod_cooperativa, saldo.scc_nro_conta) = (cct_cod_cooperativa, cct_nro_conta) "
			+ " JOIN tb_gen_associado "
			+ " ON (cct_cod_cooperativa, cct_matr_associado) = (ass_cod_cooperativa, ass_matr_associado) "
			+ " JOIN tb_gen_pessoa "
			+ " ON (pes_nro_documento = ass_nro_documento) "
			+ " LEFT JOIN tb_gen_coo_singular_pac "
			+ " ON (ass_cod_cooperativa, ass_cod_pac) = (csp_cod_cooperativa, csp_cod_pac) "
			+ " WHERE saldo.scc_vl_limite > 0 "
			+ " AND saldo.scc_data <= :dataBase "
			+ " AND saldo.scc_cod_cooperativa = :codigoCooperativa ";

	public static final String SQL_SALDO_DIARIO_CONTRATO_LIMITE_ORDER_BY = " order by \"codPac\" NULLS FIRST, \"tipoPessoa\", conta ";

	public static final String SQL_RELATORIO_MOVIMENTO_CONTRATO_LIMITE = " select a.nro_conta as nroconta, "
			+ " a.dv_conta as dvconta,  "
			+ " a.nome,  "
			+ " a.cod_limite as codlimite, "
			+ " a.data_limite as datalimite,  "
			+ " a.valor as valorlimite,  "
			+ " b.lid_valor as valoranterior, "
			+ " (select scc_vl_saldo_disponivel as saldo_disponivel "
			+ " from tb_gcc_saldo_cc scc "
			+ " where scc.scc_nro_conta = a.nro_conta "
			+ " and scc.scc_cod_cooperativa = a.cod_cooperativa "
			+ " and scc.scc_data = (select max(sccTmp.scc_data) "
			+ " from tb_gcc_saldo_cc sccTmp "
			+ " where sccTmp.scc_nro_conta = a.nro_conta "
			+ " and sccTmp.scc_cod_cooperativa = a.cod_cooperativa "
			+ " and sccTmp.scc_data <= a.data_limite)) as saldo "
			+ " from "
			+ " (SELECT l.lid_limite_devedor as cod_limite, "
			+ " cc.cct_nro_conta as nro_conta, "
			+ " l.lid_cod_cooperativa as cod_cooperativa, "
			+ " cc.cct_dv_conta_corrente as dv_conta, "
			+ " p.pes_nome as nome, "
			+ " l.lid_limite_devedor,  "
			+ " l.lid_data as data_limite, "
			+ " l.lid_valor as valor "
			+ " FROM "
			+ " colmeia.tb_gcc_limite_devedor l "
			+ " join colmeia.tb_gcc_conta_corrente cc on l.lid_cod_cooperativa = cc.cct_cod_cooperativa and l.lid_nro_conta = cc.cct_nro_conta "
			+ " join colmeia.tb_gen_associado a on cc.cct_cod_coo_associado = a.ass_cod_cooperativa and cc.cct_matr_associado = a.ass_matr_associado "
			+ " join colmeia.tb_gen_pessoa p on a.ass_nro_documento = p.pes_nro_documento "
			+ " left join colmeia.tb_gen_coo_singular_pac pa on (cc.cct_cod_cooperativa_pac, cc.cct_cod_pac) = (pa.csp_cod_cooperativa, pa.csp_cod_pac) "
			+ " where l.lid_cod_cooperativa = :codigoCooperativa ";

	public static final String SQL_RELATORIO_MOVIMENTO_CONTRATO_LIMITE_CONTINUACAO = " and l.lid_data between :dataInicial  and  :dataFinal "
			+ " ) as a "
			+ " join ( "
			+ "  select lim.lid_limite_devedor, lim.lid_cod_cooperativa as cod_cooperativa, lim.lid_nro_conta as nro_conta, lim.lid_data, lim.lid_valor "
			+ " from tb_gcc_limite_devedor lim "
			+ " where lim.lid_limite_devedor = (select max(lid_limite_devedor) from tb_gcc_limite_devedor where lid_data < :dataInicial and lid_nro_conta = lim.lid_nro_conta and lid_cod_cooperativa = lim.lid_cod_cooperativa) "
			+ " ) as b USING (cod_cooperativa, nro_conta) "
			+ " order by a.nro_conta, a.data_limite, a.cod_limite,a.nome ";

	public static final String SQL_RELATORIO_CONFERENCIA_COBRANCA_COBAN = " SELECT "
			+ " cast(coalesce(csp_nome, 'SEDE') as varchar) || ' - ' || cast(coalesce(rec_loja,0) as varchar) as unidade_loja, "
			+ " 'CAIXA: ' || cast(ccx_posicao_caixa as text) as posicao_caixa, "
			+ " rec_convenio as convenio, "
			+ " rec_cod_cooperativa as codigo_cooperativa, "
			+ " rec_dt_movimento as data_movimento, "
			+ " rec_linha_capturada as linha_capturada, "
			+ " fn_reg_descricao(rec_tipo_documento) as tipo_documento, "
			+ " rec_vl_receber as valor, "
			+ " rec_cod_operacao as cod_operacao, "
			+ " par_descricao as descricao_operacao "
			+ " FROM "
			+ " colmeia.tb_gcc_recebimento "
			+ " join tb_gcc_log_caixa on (lcx_nsu = rec_nsu) "
			+ " join tb_gcc_controle_caixa on (ccx_cod_controle_caixa = lcx_cod_controle_caixa) "
			+ " join tb_gfe_parametro on (par_cod_cooperativa = rec_cod_cooperativa "
			+ " and par_cod_operacao = rec_cod_operacao) "
			+ " left join tb_gen_coo_singular_pac on (rec_cod_cooperativa, rec_cod_pac) = (csp_cod_cooperativa, csp_cod_pac)"
			+ " where rec_cod_cooperativa = :cooperativa ";

	public static final String SQL_RELATORIO_CONFERENCIA_COBRANCA_COBAN_ORDER_BY = " and rec_dt_movimento between :dataInicial and :dataFinal "
			+ " and (lcx_situacao <> 2101 and lcx_origem_lancamento <> 'X') "
			+ " order by rec_dt_movimento, unidade_loja, rec_cod_operacao, fn_reg_descricao(rec_tipo_documento), ccx_posicao_caixa, rec_vl_receber ";

	public static final String SQL_LOG_DEB558_LANCAMENTOS = " select "
			+ "deb_dt_lancamento as datalancamento, "
			+ "cast(deb_nro_conta_integracao as VARCHAR) || '-' || cast(deb_dv_conta_integracao as VARCHAR) as codigointegracao, "
			+ "deb_descr_historico_bb as descricao, "
			+ "deb_nro_doc_lancado as numerodocumento, "
			+ "deb_vl_operacao as valor, "
			+ "case when deb_cod_historico_bb < 500 then 'D' else 'C' end as dc "
			+ "from tb_gcc_deb558_header left join tb_gcc_deb558_detalhe_tipo2 on deh_cod_serial = deb_cod_serial_header "
			+ "where deh_cod_cooperativa = :codigoCooperativa "
			+ "and deh_dt_arquivo = :dataLancamento "
			+ "order by datalancamento, codigointegracao ";

	public static final String SQL_RELATORIO_MOVIMENTO_DIARIO_CAPITAL = "SELECT "
			+ " cast(lcp_dt_hora_movimento as date) as datamovimento, "
			+ " cast(cct_nro_conta as text)||'-'||cast(cct_dv_conta_corrente as text) as conta, "
			+ " pes_nome as nome, "
			+ " par_cod_operacao as operacao, "
			+ " case when lcp_origem_lancamento='X' then 'ESTORNO '||par_descricao "
			+ " else par_descricao "
			+ " end as descricaooperacao, "
			+ " case when lcp_debito_credito = 4001 then -lcp_valor "
			+ " else lcp_valor "
			+ " end as valor, "
			+ " (select reg_descricao from tb_gen_registro where reg_id_registro=pes_tipo_pessoa) as tipopessoa, "
			+ " to_char (lcp_dt_hora_movimento, 'dd/MM/YYYY') as dataformatada "
			+ " FROM "
			+ "  tb_gen_pessoa "
			+ "  join tb_gen_associado on (ass_nro_documento = pes_nro_documento) "
			+ "  join tb_gcc_conta_corrente on (ass_matr_associado = cct_matr_associado AND ass_cod_cooperativa=cct_cod_coo_associado) "
			+ "  join tb_gcc_conta_capital on (cct_nro_conta = con_nro_conta AND cct_cod_cooperativa = con_cod_cooperativa) "
			+ "  join tb_gcc_movimento_conta_capital on (con_nro_conta=lcp_nro_conta_capital AND con_cod_cooperativa=lcp_cod_cooperativa) "
			+ "  join tb_gfe_parametro on (lcp_cod_operacao=par_cod_operacao and lcp_cod_cooperativa_operacao=par_cod_cooperativa) "
			+ " WHERE "
			+ " lcp_valor <> 0 "
			+ " AND ass_cod_cooperativa= :codigoCooperativa "
			+ " AND cast(lcp_dt_hora_movimento as date) between :dataInicial AND :dataFinal ";

	/**
	 * Consulta para o relatorio GFE-REL-032-008-001 R1 - SQL do associado
	 */
	public static final String SQL_RELATORIO_SITUACAO_INDIVIDUAL_ASSOCIADO = "select p.pes_nome as nome, "
			+ "fn_reg_descricao(p.pes_tipo_pessoa) as tipopessoa, "
			+ "cc.cct_cod_cooperativa as agencia, "
			+ "cast(cc.cct_nro_conta as text) || cast(cc.cct_dv_conta_corrente as text) as conta, "
			+ "a.ass_matr_associado as matricula, "
			+ "a.ass_nro_documento as documento, "
			+ "cast (ce.logradouro as text) ||'-'|| cast(desc_bairro as text) as endereco, "
			+ "a.ass_dt_inclusao as admissao, "
			+ "a.ass_dt_desfilia as desligamento,  "
			+ "sc.scc_vl_saldo_disponivel as saldocc, "
			+ "li.lid_valor as limite, "
			+ "sca.sca_vl_integra - sca.sca_vl_resg as capitalizado, "
			+ "r.reg_cod_registro as codtipopessoa "
			+ "from tb_gcc_conta_corrente cc, tb_gen_associado a, tb_gen_pessoa p, tb_gen_endereco_associado ea, "
			+ "vw_cep_cidade_endereco ce, tb_gcc_saldo_cc sc, tb_gcc_limite_devedor li, tb_gcc_saldo_conta_capital sca, tb_gen_registro r  "
			+ "where cc.cct_matr_associado = a.ass_matr_associado "
			+ "and cc.cct_cod_cooperativa = a.ass_cod_cooperativa "
			+ "and a.ass_nro_documento = p.pes_nro_documento "
			+ "and a.ass_cod_cooperativa = ea.ena_cod_cooperativa "
			+ "and a.ass_matr_associado = ea.ena_matr_associado "
			+ "and ea.ena_cep = ce.cep "
			+ "and ea.ena_cod_endereco = ce.cod_generico "
			+ "and sc.scc_nro_conta = cc.cct_nro_conta "
			+ "and sc.scc_cod_cooperativa = cc.cct_cod_cooperativa "
			+ "and p.pes_tipo_pessoa = r.reg_id_registro "
			+ "and sc.scc_data = (select max(scc_data) "
			+ "from tb_gcc_saldo_cc saldo "
			+ "where saldo.scc_nro_conta = cc.cct_nro_conta "
			+ "and saldo.scc_cod_cooperativa = cc.cct_cod_cooperativa) "
			+ "and li.lid_nro_conta = cc.cct_nro_conta "
			+ "and li.lid_cod_cooperativa = cc.cct_cod_cooperativa "
			+ "and li.lid_limite_devedor = (select max(lid_limite_devedor) "
			+ "from tb_gcc_limite_devedor limite "
			+ "where limite.lid_nro_conta = cc.cct_nro_conta "
			+ "and limite.lid_cod_cooperativa = cc.cct_cod_cooperativa) "
			+ "and sca.sca_nro_conta_capital = cc.cct_nro_conta "
			+ "and sca.sca_cod_cooperativa = cc.cct_cod_cooperativa "
			+ "and sca.sca_dt_saldo = (select max(sca_dt_saldo)  "
			+ "from tb_gcc_saldo_conta_capital capital "
			+ "where capital.sca_nro_conta_capital = cc.cct_nro_conta "
			+ "and capital.sca_cod_cooperativa = cc.cct_cod_cooperativa) "
			+ "and cc.cct_cod_cooperativa = :codigoCooperativa "
			+ "and cc.cct_nro_conta = :conta ";

	/**
	 * Consulta para o relatorio GFE-REL-032-008-001 R4 - SQL de cheques
	 */
	public static final String SQL_RELATORIO_SITUACAO_INDIVIDUAL_CHEQUES = "select fn_reg_descricao(cheque.chc_situacao) as situacao, "
			+ "count(*) as quantidade "
			+ "from tb_gcc_cheque_cresol cheque "
			+ "join (select * from tb_gcc_talonario_cheque) as talonario "
			+ "on cheque.chc_cod_talonario = talonario.tch_cod_talonario "
			+ "where cheque.chc_situacao in (select reg_id_registro from tb_gen_registro where reg_cod_dominio = 2011) "
			+ "and talonario.tch_cod_cooperativa = (:codigoCooperativa) "
			+ "and talonario.tch_nro_conta = (:conta)  "
			+ "group by cheque.chc_situacao " + "order by 1 ";

	public static final String SQL_RELATORIO_DISTRIBUICAO_CAPITAL_FAIXA_VALORES = "select faixa, id_faixa, coalesce(valor, 0.00) as valor, "
			+ "quantidade, coalesce(valor_medio, 0.00) as valor_medio "
			+ "from ( select 'Menos de 100' as faixa, 0 as id_faixa, sum(scc.sca_vl_integra - scc.sca_vl_resg) as valor, "
			+ "count(*) as quantidade, avg(scc.sca_vl_integra - scc.sca_vl_resg) as valor_medio "
			+ "from tb_gcc_saldo_conta_capital scc join tb_gcc_conta_corrente "
			+ "on (sca_cod_cooperativa=cct_cod_cooperativa and sca_nro_conta_capital=cct_nro_conta) "
			+ "join tb_gen_associado "
			+ "on (ass_matr_associado=cct_matr_associado and ass_cod_cooperativa=cct_cod_cooperativa) "
			+ "join (select max(sca_dt_saldo) as data,sca_nro_conta_capital as conta, sca_cod_cooperativa as coop "
			+ "from tb_gcc_saldo_conta_capital "
			+ "where sca_dt_saldo <= :dataAte "
			+ "group by sca_nro_conta_capital, sca_cod_cooperativa) as scc_max "
			+ "on (scc_max.data=scc.sca_dt_saldo and scc_max.conta= sca_nro_conta_capital and scc_max.coop =scc.sca_cod_cooperativa) "
			+ "where scc.sca_cod_cooperativa = :codCooperativa "
			+ "and (scc.sca_vl_integra - scc.sca_vl_resg) < 100.00 and cct_categ_conta=4115 and ass_situacao IN (929, 375, 377, 378, 379) "
			+ "UNION "
			+ "select 'De 100 a 300' as faixa, 1 as id_faixa, sum(scc.sca_vl_integra - scc.sca_vl_resg) as valor, "
			+ "count(*) as quantidade, avg(scc.sca_vl_integra - scc.sca_vl_resg) as valor_medio "
			+ "from tb_gcc_saldo_conta_capital scc join tb_gcc_conta_corrente "
			+ "on (sca_cod_cooperativa=cct_cod_cooperativa and sca_nro_conta_capital=cct_nro_conta) "
			+ "join tb_gen_associado on (ass_matr_associado=cct_matr_associado and ass_cod_cooperativa=cct_cod_cooperativa) "
			+ "join (select max(sca_dt_saldo) as data,sca_nro_conta_capital as conta, sca_cod_cooperativa as coop "
			+ "from tb_gcc_saldo_conta_capital "
			+ "where sca_dt_saldo <= :dataAte "
			+ "group by sca_nro_conta_capital, sca_cod_cooperativa) as scc_max "
			+ "on (scc_max.data=scc.sca_dt_saldo and scc_max.conta= sca_nro_conta_capital and scc_max.coop =scc.sca_cod_cooperativa) "
			+ "where scc.sca_cod_cooperativa = :codCooperativa "
			+ "and  (scc.sca_vl_integra - scc.sca_vl_resg) >= 100.00 "
			+ "and (scc.sca_vl_integra - scc.sca_vl_resg) < 300.00  and cct_categ_conta=4115 and ass_situacao IN (929, 375, 377, 378, 379) "
			+ "UNION "
			+ "select 'De 300 a 500' as faixa, 2 as id_faixa, sum(scc.sca_vl_integra - scc.sca_vl_resg) as valor, "
			+ "count(*) as quantidade, avg(scc.sca_vl_integra - scc.sca_vl_resg) as valor_medio "
			+ "from tb_gcc_saldo_conta_capital scc join tb_gcc_conta_corrente "
			+ "on (sca_cod_cooperativa=cct_cod_cooperativa and sca_nro_conta_capital=cct_nro_conta) "
			+ "join tb_gen_associado on (ass_matr_associado=cct_matr_associado and ass_cod_cooperativa=cct_cod_cooperativa) "
			+ "join (select max(sca_dt_saldo) as data,sca_nro_conta_capital as conta, sca_cod_cooperativa as coop from tb_gcc_saldo_conta_capital "
			+ "where sca_dt_saldo <= :dataAte group by sca_nro_conta_capital, sca_cod_cooperativa) as scc_max "
			+ "on (scc_max.data=scc.sca_dt_saldo and scc_max.conta= sca_nro_conta_capital and scc_max.coop =scc.sca_cod_cooperativa) "
			+ "where scc.sca_cod_cooperativa = :codCooperativa "
			+ "and (scc.sca_vl_integra - scc.sca_vl_resg) >= 300.00 and (scc.sca_vl_integra - scc.sca_vl_resg) < 500.00  "
			+ "and cct_categ_conta=4115 and ass_situacao IN (929, 375, 377, 378, 379) "
			+ "UNION "
			+ "select 'De 500 a 700' as faixa, 3 as id_faixa, sum(scc.sca_vl_integra - scc.sca_vl_resg) as valor, "
			+ "count(*) as quantidade, avg(scc.sca_vl_integra - scc.sca_vl_resg) as valor_medio from tb_gcc_saldo_conta_capital scc "
			+ "join tb_gcc_conta_corrente on (sca_cod_cooperativa=cct_cod_cooperativa and sca_nro_conta_capital=cct_nro_conta) "
			+ "join tb_gen_associado on (ass_matr_associado=cct_matr_associado and ass_cod_cooperativa=cct_cod_cooperativa) "
			+ "join (select max(sca_dt_saldo) as data,sca_nro_conta_capital as conta, sca_cod_cooperativa as coop "
			+ "from tb_gcc_saldo_conta_capital where sca_dt_saldo <= :dataAte "
			+ "group by sca_nro_conta_capital, sca_cod_cooperativa) as scc_max "
			+ "on (scc_max.data=scc.sca_dt_saldo and scc_max.conta= sca_nro_conta_capital and scc_max.coop =scc.sca_cod_cooperativa) "
			+ "where scc.sca_cod_cooperativa = :codCooperativa and (scc.sca_vl_integra - scc.sca_vl_resg) >= 500.00 "
			+ "and (scc.sca_vl_integra - scc.sca_vl_resg) < 700.00  and cct_categ_conta=4115 "
			+ "and ass_situacao IN (929, 375, 377, 378, 379) "
			+ "UNION "
			+ "select 'De 700 a 1.000' as faixa, 4 as id_faixa, sum(scc.sca_vl_integra - scc.sca_vl_resg) as valor, "
			+ "count(*) as quantidade, avg(scc.sca_vl_integra - scc.sca_vl_resg) as valor_medio from tb_gcc_saldo_conta_capital scc "
			+ "join tb_gcc_conta_corrente on (sca_cod_cooperativa=cct_cod_cooperativa and sca_nro_conta_capital=cct_nro_conta) "
			+ "join tb_gen_associado on (ass_matr_associado=cct_matr_associado and ass_cod_cooperativa=cct_cod_cooperativa) "
			+ "join (select max(sca_dt_saldo) as data,sca_nro_conta_capital as conta, sca_cod_cooperativa as coop from tb_gcc_saldo_conta_capital "
			+ "where sca_dt_saldo <= :dataAte group by sca_nro_conta_capital, sca_cod_cooperativa) as scc_max "
			+ "on (scc_max.data=scc.sca_dt_saldo and scc_max.conta= sca_nro_conta_capital and scc_max.coop =scc.sca_cod_cooperativa) "
			+ "where scc.sca_cod_cooperativa = :codCooperativa "
			+ "and  (scc.sca_vl_integra - scc.sca_vl_resg) >= 700.00 and (scc.sca_vl_integra - scc.sca_vl_resg) < 1000.00  "
			+ "and cct_categ_conta=4115 and ass_situacao IN (929, 375, 377, 378, 379) "
			+ "UNION "
			+ "select 'Mais de 1.000' as faixa, 5 as id_faixa, sum(scc.sca_vl_integra - scc.sca_vl_resg) as valor, count(*) as quantidade, "
			+ "avg(scc.sca_vl_integra - scc.sca_vl_resg) as valor_medio "
			+ "from tb_gcc_saldo_conta_capital scc join tb_gcc_conta_corrente "
			+ "on (sca_cod_cooperativa=cct_cod_cooperativa and sca_nro_conta_capital=cct_nro_conta) "
			+ "join tb_gen_associado on (ass_matr_associado=cct_matr_associado and ass_cod_cooperativa=cct_cod_cooperativa) "
			+ "join (select max(sca_dt_saldo) as data,sca_nro_conta_capital as conta, sca_cod_cooperativa as coop from tb_gcc_saldo_conta_capital "
			+ "where sca_dt_saldo <= :dataAte group by sca_nro_conta_capital, sca_cod_cooperativa) as scc_max "
			+ "on (scc_max.data=scc.sca_dt_saldo and scc_max.conta= sca_nro_conta_capital and scc_max.coop =scc.sca_cod_cooperativa) "
			+ "where scc.sca_cod_cooperativa = :codCooperativa and "
			+ "(scc.sca_vl_integra - scc.sca_vl_resg) >= 1000.00 and cct_categ_conta=4115 and ass_situacao IN (929, 375, 377, 378, 379)) as q "
			+ "order by q.id_faixa, q.valor_medio";

	public static String SQL_RELATORIO_EXTRATO_ANUAL_TARIFAS = "select cc.cct_nro_conta as \"nroConta\", "
			+ "cc.cct_dv_conta_corrente as \"dvConta\", "
			+ "s.scc_cod_cooperativa as \"codCooperativa\", p.pes_nome as \"nomeAssociado\", p.pes_nro_documento as \"nroDocumento\", p.pes_tipo_pessoa as \"tipoPessoa\", "
			+ "(ARRAY['JANEIRO','FEVEREIRO','MAR�O','ABRIL', 'MAIO', 'JUNHO', 'JULHO', 'AGOSTO', 'SETEMBRO', 'OUTUBRO', 'NOVEMBRO', 'DEZEMBRO'])[EXTRACT(MONTH FROM s.scc_data)] as mes, "
			+ "s.scc_data as data, (case when mcc_debito_credito = 4001 then mov.mcc_valor else -mov.mcc_valor end) as \"valorLancamento\", mov.mcc_cod_operacao_cc as \"codOperacao\", case when mcc_debito_credito = 4002 then 'ESTORNO ' || par_descricao else par_descricao end as \"descricaoOperacao\" "
			+ "from tb_gcc_movimento_cc mov "
			+ "join tb_gfe_mod_conta_corrente mod ON (mod.mcc_cod_cooperativa = mov.mcc_cod_cooperativa_cc and mod.mcc_cod_operacao = mov.mcc_cod_operacao_cc) "
			+ "join tb_gfe_parametro par ON (mod.mcc_cod_cooperativa = par.par_cod_cooperativa and mod.mcc_cod_operacao = par.par_cod_operacao) "
			+ "join tb_gcc_saldo_cc s ON (mov.mcc_cod_saldo_cc = s.scc_cod_saldo_cc) "
			+ "join tb_gcc_conta_corrente cc ON (cc.cct_cod_cooperativa=s.scc_cod_cooperativa and  cc.cct_nro_conta=s.scc_nro_conta) "
			+ "join tb_gen_associado a ON (cc.cct_matr_associado = a.ass_matr_associado and cc.cct_cod_cooperativa = a.ass_cod_cooperativa) "
			+ "join tb_gen_pessoa p ON (a.ass_nro_documento = p.pes_nro_documento) "
			+ "where (mcc_incide_tarifa =7379 or mov.mcc_cod_operacao_cc=7122) "
			+ "and cct_cod_cooperativa = :codigoCooperativa "
			+ "and EXTRACT (YEAR FROM s.scc_data) = :ano "
			+ "and s.scc_nro_conta = :contaCorrente "
			+ "order by s.scc_data,mov.mcc_valor ";

	/**
	 * Query respons�vel pela consultas dos movimentos de cheque do rel
	 * GCC-REL-001-080-005.
	 * 
	 */
	public static String SQL_EXTRATO_ANUAL_DESPESAS_CHEQUES = "select * from ("
			+ "select scc_nro_conta as \"numeroConta\", mcc_cod_operacao_cc as \"codigoOperacao\", "
			+ "op.descricao_operacao as \"descricaoOperacao\", "
			+ "sum (case when mcc_debito_credito=4001 then mcc_valor else -mcc_valor end) as valor, "
			+ "cast (date_trunc('month', scc_data) as DATE) as mes, "
			+ "cast('CHEQUE ESPECIAL/ADIANTAMENTO A DEPOSITANTE' as TEXT) as produto "
			+ "from tb_gcc_saldo_cc "
			+ "join tb_gcc_movimento_cc on (scc_cod_saldo_cc = mcc_cod_saldo_cc) "
			+ "join (select column1 as cod_operacao, column2 as descricao_operacao "
			+ "from ( values (65, 'MULTA SOBRE SALDO DEVEDOR'),(66,'IOF SOBRE SALDO DEVEDOR'), "
			+ "(68,'JUROS SOBRE ADTO DEPOSITANTE'),(104,'JUROS DE CHEQUE ESPECIAL')) as operacoes) op "
			+ "on (mcc_cod_operacao_cc = op.cod_operacao) "
			+ "join tb_gcc_parametro_cc_cooperativa ON (scc_cod_cooperativa = ccc_cod_cooperativa) "
			+ "where mcc_cod_operacao_cc in (104,68,66,65) and scc_cod_cooperativa= :codigoCooperativa  and scc_nro_conta = :numeroConta "
			+ "and EXTRACT (YEAR FROM scc_data) =  :ano "
			+ "and scc_data >= ccc_dt_implantacao_sistema "
			+ "group by scc_nro_conta, mcc_cod_operacao_cc, op.descricao_operacao, date_trunc('month', scc_data) "
			+ "order by mcc_cod_operacao_cc, date_trunc('month', scc_data), op.descricao_operacao"
			+ ") as foo where foo.valor <> 0";

	/**
	 * Query respons�vel pela consultas dos movimentos de emprestimos do rel
	 * GCC-REL-001-080-005.
	 * 
	 */
	public static String SQL_EXTRATO_ANUAL_DESPESAS_EMPRESTIMOS = "select * from ("
			+ "select epr_nro_conta as \"numeroConta\", "
			+ "trn_cod_oper_central as \"codigoOperacao\", op.descricao_operacao as \"descricaoOperacao\", "
			+ "sum(case when (trn_tipo_movimento=2074 and trn_cod_oper_central <> 37 "
			+ "or trn_tipo_movimento=2075 and trn_cod_oper_central = 37) "
			+ "then -trn_vl_operacao else trn_vl_operacao end) as valor, "
			+ "cast(date_trunc('month', trn_dt_movimento) as DATE)as mes, "
			+ "fn_reg_descricao(mem_complemento_finalidade) as produto, "
			+ "epr_nro_contrato as \"numeroContrato\", "
			+ "epr_dt_inicial as \"dataContrato\", "
			+ "epr_valor_contrato as \"valorContrato\" "
			+ "from tb_gco_transitoria "
			+ "join tb_gfe_transitoria_emprestimo on (trn_cod_transitoria=tem_cod_transitoria) "
			+ "join tb_gfe_parametro on (trn_cod_oper_central=par_cod_operacao and trn_cod_coo_central=par_cod_cooperativa) "
			+ "join tb_gfe_emprestimo on (trn_nro_documento=epr_nro_contrato) "
			+ "join tb_gfe_modalidade_emprestimo on (epr_cod_operacao=mem_cod_operacao and epr_fonte_recurso=mem_fonte_recurso and epr_ano_referencia=mem_ano_referencia and epr_cod_coo_modalidade=mem_cod_cooperativa) "
			+ "join (select column1 as cod_operacao, column2 as descricao_operacao "
			+ "      from ( values (37,'IOF'), (1507,'JUROS'), (1509,'CORRE��O MONET�RIA'), (1512,'MULTA'), (1515,'JUROS DE MORA'), (1618,'JUROS DA CARENCIA')) as operacoes) op "
			+ "on (trn_cod_oper_central = op.cod_operacao) "
			+ "join tb_gcc_parametro_cc_cooperativa ON (epr_cod_cooperativa = ccc_cod_cooperativa) "
			+ "where trn_cod_oper_central in (37,1507,1509,1512,1515,1618) "
			+ "and epr_cod_cooperativa= :codigoCooperativa and epr_nro_conta = :numeroConta and mem_cod_operacao<>2005 "
			+ "and  EXTRACT (YEAR FROM trn_dt_movimento) = :ano "
			+ "and trn_dt_movimento >=  ccc_dt_implantacao_sistema "
			+ "group by epr_nro_conta, epr_nro_contrato, epr_dt_inicial, trn_cod_oper_central, op.descricao_operacao, date_trunc('month', trn_dt_movimento), mem_complemento_finalidade, epr_valor_contrato "
			+ "order by epr_nro_contrato, trn_cod_oper_central, date_trunc('month', trn_dt_movimento), op.descricao_operacao "
			+ ") as foo where foo.valor <> 0";

	public static String SQL_CHEQUES_GERAR_MOVIMENTO_PROPRIA_DEVOLUCAO = "with "
			+ "ultimo_limite_por_conta as ( "
			+ "select lid_cod_cooperativa, lid_nro_conta, max(lid_data) as lid_data "
			+ "  from tb_gcc_limite_devedor "
			+ " where lid_cod_cooperativa = :codigoCooperativa "
			+ "   and lid_situacao = 4327 "
			+ " group by lid_cod_cooperativa, lid_nro_conta "
			+ "), "
			+ "ultimo_historico_alinea_cheque as ( "
			+ "select had_cod_talonario, had_nro_cheque,had_cod_alinea, max(had_dt_alinea) as dt_alinea "
			+ "  from tb_gcc_historico_alinea_devolucao "
			+ "  join tb_gcc_talonario_cheque on (had_cod_talonario = tch_cod_talonario) "
			+ " where tch_cod_cooperativa = :codigoCooperativa "
			+ " group by had_cod_talonario, had_nro_cheque, had_cod_alinea "
			+ "), "
			+ "saldo_cheques as ( "
			+ "select distinct on (scc_cod_cooperativa, scc_nro_conta, chc_cod_talonario, chc_nro_cheque) "
			+ "       cheque.chc_cod_talonario, "
			+ "       cheque.chc_nro_cheque, "
			+ "       cheque.chc_valor, "
			+ "       cct_nro_conta, "
			+ "       fn_reg_cod_registro(cct_situacao) as situacao_conta, "
			+ "       fn_reg_cod_registro(coh_situacao) as situacao_contra_ordem, "
			+ "       coalesce (lid_valor, 0.0) as valor_limite, "
			+ "       scc_vl_saldo_disponivel, "
			+ "       had_cod_alinea, dt_alinea "
			+ "  from tb_gcc_cheque_cresol as cheque "
			+ "  join tb_gcc_talonario_cheque on (tch_cod_talonario = cheque.chc_cod_talonario) "
			+ "  join tb_gcc_conta_corrente on (tch_nro_conta = cct_nro_conta and tch_cod_cooperativa = cct_cod_cooperativa) "
			+ "  join tb_gcc_saldo_cc on (cct_cod_cooperativa, cct_nro_conta) = (scc_cod_cooperativa, scc_nro_conta) "
			+ "  left join tb_gcc_contra_ordem_cheque on (coh_cod_talonario = cheque.chc_cod_talonario and coh_nro_cheque = cheque.chc_nro_cheque) "
			+ "  left join ultimo_historico_alinea_cheque on (had_cod_talonario = chc_cod_talonario and had_nro_cheque = cheque.chc_nro_cheque) "
			+ "  left join ultimo_limite_por_conta on (cct_cod_cooperativa, cct_nro_conta) = (lid_cod_cooperativa, lid_nro_conta) "
			+ "  left join tb_gcc_limite_devedor using (lid_cod_cooperativa, lid_nro_conta, lid_data) "
			+ " where cheque.chc_dt_movimento_cheque = :dataMovimento "
			+ " and cheque.chc_situacao = 4189 "
			+ " and cct_cod_cooperativa = :codigoCooperativa "
			+ " order by scc_cod_cooperativa, scc_nro_conta, chc_cod_talonario, chc_nro_cheque, chc_valor, "
			+ " scc_data desc, dt_alinea desc, case when coh_situacao = 4237 then 0 else 1 end, cheque.chc_dt_movimento_cheque "
			+ "), "
			+ "saldo_devedor_cheques_processados as ( "
			+ "select chc_cod_talonario, "
			+ "       chc_nro_cheque, "
			+ "       situacao_conta, "
			+ "       situacao_contra_ordem, "
			+ "       cct_nro_conta, "
			+ "       had_cod_alinea, "
			+ "       dt_alinea, "
			+ "       valor_limite + scc_vl_saldo_disponivel - sum (chc_valor) "
			+ "		over (partition by cct_nro_conta order by chc_valor) as saldo_processado "
			+ "  from saldo_cheques "
			+ "  where (valor_limite + scc_vl_saldo_disponivel) < 0 "
			+ ") "
			+ "select * "
			+ "  from saldo_devedor_cheques_processados "
			+ " where saldo_processado < 0 "
			+ " order by cct_nro_conta, chc_cod_talonario, chc_nro_cheque";

	public static final String CONSULTA_CHEQUES_MANTER_CONTA_CORRENTE_CAMPOS = "select chc_serie as serie, "
			+ "chc_cod_talonario as \"codigoTalonario\", chc_nro_cheque as \"numeroCheque\", "
			+ "cif_nro_conta_integracao as \"codContaIntegracao\","
			+ "cif_dv_conta_integracao as\"dvCodContaIntegracao\","
			+ "chc_valor as \"valorCheque\", chc_dt_situacao as \"dataSituacao\", "
			+ "fn_reg_descricao(chc_situacao) as \"descricaoSituacaoCheque\", "
			+ "situacao_pro_descricao as \"descricaoSituacaoProcessamento\", "
			+ "coalesce (cmq_cod_comando_cheque, 0) as \"codigoComandoCheque\", "
			+ "cif_nro_conta as \"numeroConta\", cif_cod_cooperativa as \"codigoCooperativa\", concat((case when ban_cod_banco = 1 then concat(\'00\',cast(ban_cod_banco as text)) else cast(ban_cod_banco as text)   end), \'-\',ban_razao_social) as \"banco\" ";

	public static final String CONSULTA_CHEQUES_MANTER_CONTA_CORRENTE_CAMPOS_COMPE = "select chc_serie as serie, "
			+ "chc_cod_talonario as \"codigoTalonario\", chc_nro_cheque as \"numeroCheque\", "
			+ "tch_nro_conta_cc as \"codContaIntegracao\","
			+ "cast(cct_dv_conta_corrente as text) as\"dvCodContaIntegracao\","
			+ "chc_valor as \"valorCheque\", chc_dt_situacao as \"dataSituacao\", "
			+ "fn_reg_descricao(chc_situacao) as \"descricaoSituacaoCheque\", "
			+ "situacao_pro_descricao as \"descricaoSituacaoProcessamento\", "
			+ "coalesce (cmq_cod_comando_cheque, 0) as \"codigoComandoCheque\", "
			+ "tch_nro_conta_cc as \"numeroConta\", tch_cod_cooperativa_cc as \"codigoCooperativa\", concat((case when ban_cod_banco = 1 then concat(\'00\',cast(ban_cod_banco as text)) else cast(ban_cod_banco as text)   end), \'-\',ban_razao_social) as \"banco\" ";

	public static final String JOIN_CHEQUES_MANTER_CONTA_CORRENTE_CAMPOS = " from tb_gcc_cheque_cresol "
			+ "	 join tb_gcc_talonario_cheque on (tch_cod_talonario = chc_cod_talonario AND tch_banco <> 133) "
			+ "	 join tb_gcc_conta_integracao_bb on (cif_cod_cooperativa = tch_cod_cooperativa and "
			+ "					   cif_nro_conta = tch_nro_conta and "
			+ "					   cif_sequencial_conta_integracao = tch_sequencial_conta_integracao) "
			+ "	 left join controle_movimento_cheque_mais_recente on (chc_cod_talonario = cmq_cod_talonario and "
			+ "							 chc_nro_cheque = cmq_nro_cheque) "
			+ "  join tb_gen_registro regChc on (regChc.reg_id_registro = chc_situacao) left join tb_gcc_banco on (tch_banco = ban_cod_banco)";

	public static final String JOIN_CHEQUES_MANTER_CONTA_CORRENTE_CAMPOS_COMPE = " from tb_gcc_cheque_cresol "
			+ "	 join tb_gcc_talonario_cheque on (tch_cod_talonario = chc_cod_talonario AND tch_banco = 133) "
			+ "	 join tb_gcc_conta_corrente on (tch_cod_cooperativa_cc,tch_nro_conta_cc) = (cct_cod_cooperativa,cct_nro_conta) "
			+ "	 left join controle_movimento_cheque_mais_recente on (chc_cod_talonario = cmq_cod_talonario and "
			+ "							 chc_nro_cheque = cmq_nro_cheque) "
			+ "  join tb_gen_registro regChc on (regChc.reg_id_registro = chc_situacao) left join tb_gcc_banco on (tch_banco = ban_cod_banco)";

	public static final String JOIN_CONTRA_ORDEM_CHEQUES_MANTER_CONTA_CORRENTE_CAMPOS = " join contra_ordem_cheque_mais_atual ON (coh_nro_cheque = chc_nro_cheque and coh_cod_talonario = chc_cod_talonario) "
			+ " left join tb_gen_registro regCoh on (regCoh.reg_id_registro = coh_situacao) ";

	public static final String LEFT_JOIN_CONTRA_ORDEM_CHEQUES_MANTER_CONTA_CORRENTE_CAMPOS = " left join contra_ordem_cheque_mais_atual ON (coh_nro_cheque = chc_nro_cheque and coh_cod_talonario = chc_cod_talonario) "
			+ " left join tb_gen_registro regCoh on (regCoh.reg_id_registro = coh_situacao) ";

	public static String JOIN_HIST_MOVIMENTO_DEVOLUCAO_ALINEA_DIFERENTE_DOZE = "join historico_movimento_devolucao_alinea_diferente_doze "
			+ "on (chc_cod_talonario = hmd_cod_talonario and chc_nro_cheque = hmd_nro_cheque) ";

	public static String JOIN_HIST_ALINEA_DEVOLUCAO_MAIS_RECENTE_ALINEA_DOZE_TREZE = "join historico_alinea_devolucao_mais_recente_alinea_doze_treze "
			+ "on (chc_cod_talonario = hmd_cod_talonario and chc_nro_cheque = hmd_nro_cheque) ";

	public static String SQL_PESQUISA_CHEQUES_HISTORICO_ALINEA = "SELECT DISTINCT "
			+ "                 chc_cod_talonario, "
			+ "                 cast (chc_nro_cheque as integer), "
			+ "                 cast (tch_cod_cooperativa as int8), "
			+ "                 cast (tch_nro_conta as int8), "
			+ "                 max(historico.hmd_cod_alinea) "
			+ " FROM tb_gcc_cheque_cresol "
			+ " JOIN tb_gcc_talonario_cheque ON (tch_cod_talonario = chc_cod_talonario) "
			+ " JOIN tb_gcc_historico_movimento_devolucao AS historico ON (historico.hmd_cod_talonario = chc_cod_talonario "
			+ "                                                            AND historico.hmd_nro_cheque = chc_nro_cheque) "
			+ " JOIN tb_gcc_movimento_devolucao ON(mde_cod_movimento_devolucao = hmd_cod_movimento_devolucao) "
			+ " JOIN tb_gen_registro ON (reg_id_registro = chc_situacao) "
			+ " WHERE historico.hmd_cod_alinea IN (12, "
			+ "                                    13, "
			+ "                                    14) "
			+ "   AND cast(mde_dt_movimento as date) = :dataAlinea "
			+ "   AND chc_situacao = 4063 "
			+ "   AND hmd_situacao_cheque = 4063 "
			+ "   AND hmd_situacao_movimento_cheque IN(4317, "
			+ "                                        4315) "
			+ "   AND tch_cod_cooperativa = :codigoCooperativa "
			+ " GROUP BY chc_cod_talonario, "
			+ "          chc_nro_cheque, "
			+ "          tch_cod_cooperativa, "
			+ "          tch_nro_conta "
			+ " ORDER BY tch_cod_cooperativa, tch_nro_conta";

	public static String CONSULTA_CHEQUES_OPERACIONALIZAR_COMPENSACAO_IRREGULAR = "select cast (foo.chc_cod_talonario as int8), "
			+ "cast (foo.chc_nro_cheque as integer) "
			+ "  from ( "
			+ "select distinct on (chc_cod_talonario, chc_nro_cheque) "
			+ "chc_cod_talonario, "
			+ "chc_nro_cheque, "
			+ "count(contra_ordem) "
			+ "over (partition by contra_ordem.coh_cod_talonario, contra_ordem.coh_nro_cheque) "
			+ "as quantidade_contra_ordem_cheques, "
			+ "count (historico) "
			+ "over (partition by historico.had_cod_talonario, historico.had_nro_cheque) as quantidade_alineas_cheque, "
			+ "max(historico.had_cod_historico_alinea) "
			+ "over (partition by historico.had_cod_talonario, historico.had_nro_cheque "
			+ "order by historico.had_cod_historico_alinea desc) as had_cod_historico_alinea, "
			+ "historico.had_cod_alinea as alinea_mais_recente "
			+ "from tb_gcc_cheque_cresol "
			+ "join tb_gcc_talonario_cheque on (tch_cod_talonario = chc_cod_talonario) "
			+ "left join tb_gcc_contra_ordem_cheque contra_ordem on (contra_ordem.coh_cod_talonario = chc_cod_talonario and "
			+ "			contra_ordem.coh_nro_cheque = chc_nro_cheque) "
			+ "join tb_gcc_historico_alinea_devolucao historico on (historico.had_cod_talonario = chc_cod_talonario and "
			+ "			historico.had_nro_cheque = chc_nro_cheque) "
			+ "where tch_cod_cooperativa = :codigoCooperativa "
			+ "and chc_dt_situacao = :dataMovimento "
			+ ") as foo "
			+ "where foo.quantidade_contra_ordem_cheques = 0 "
			+ "and foo.quantidade_alineas_cheque > 0 "
			+ "and foo.alinea_mais_recente not in (:listaAlineasDiferenes) ";

	public static String SQL_VALIDA_MOVIMENTO_DEVOLUCAO_NAO_EXISTENTE = "with alinea_mais_recente as ( "
			+ "	select distinct on (had_cod_talonario, had_nro_cheque) "
			+ "	had_cod_talonario as cod_talonario_alinea_mais_recente, "
			+ "	had_nro_cheque as nro_cheque_alinea_mais_recente, "
			+ "	had_cod_alinea as alinea_mais_recente, "
			+ "	max(had_cod_historico_alinea) "
			+ "		over (partition by had_cod_talonario, had_nro_cheque order by had_cod_historico_alinea desc) "
			+ "	from tb_gcc_historico_alinea_devolucao "
			+ "       join tb_gcc_talonario_cheque on (tch_cod_talonario = had_cod_talonario) "
			+ "        join tb_gcc_conta_integracao_bb on (cif_cod_cooperativa = tch_cod_cooperativa and "
			+ "					   cif_nro_conta = tch_nro_conta and "
			+ "					   cif_sequencial_conta_integracao = tch_sequencial_conta_integracao) "
			+ "	where tch_cod_cooperativa = :codigoCooperativa "
			+ "	and cif_nro_conta_integracao = :numeroContaIntegracao "
			+ " and had_nro_cheque = :numeroCheque "
			+ ") "
			+ "select not EXISTS ( "
			+ "select hmd_cod_historico is null from tb_gcc_historico_movimento_devolucao "
			+ "	join tb_gcc_movimento_devolucao on (mde_cod_movimento_devolucao = hmd_cod_movimento_devolucao) "
			+ "	join tb_gcc_talonario_cheque on (tch_cod_talonario = hmd_cod_talonario) "
			+ "	join tb_gcc_conta_integracao_bb on (cif_cod_cooperativa = tch_cod_cooperativa and "
			+ "					   cif_nro_conta = tch_nro_conta and "
			+ "					   cif_sequencial_conta_integracao = tch_sequencial_conta_integracao) "
			+ "	left join alinea_mais_recente on (cod_talonario_alinea_mais_recente = hmd_cod_talonario and "
			+ "					  nro_cheque_alinea_mais_recente = hmd_nro_cheque) "
			+ "	where hmd_nro_cheque = :numeroCheque "
			+ "	and cast(mde_dt_movimento as date) = :dataMovimento "
			+ "	and cif_nro_conta_integracao = :numeroContaIntegracao "
			+ "	and tch_cod_cooperativa = :codigoCooperativa "
			+ "	and alinea_mais_recente = :codigoAlinea) ";
	
	public static String SQL_PESQUISA_ESTORNO_MOVIMENTO_CC = "select "
			+ " distinct"     
			+ " cast(mcc_nsu as int8) as nsu,"
			+ " cast(mcc_dt_hora_movimento as date) as data,"
			+ " mcc_cod_operacao_cc as \"codigoOperacao\","
			+ " case" 
			+ " when mcc_valor = sum(mcc_valor) over (partition by  mcc_nsu,cast(mcc_dt_hora_movimento as date)) then par_descricao"
			+ " else mcc_desc_contrapartida" 
			+ " end as descricao,"
			+ " mcc_valor as valor,"
			+ " fn_reg_cod_registro(mcc_debito) as \"codigoRegistroDebito\","
			+ " fn_reg_cod_registro(mcc_credito) as \"codigoRegistroCredito\" "
			+ " from colmeia.tb_gcc_conta_corrente" 
			+ " join colmeia.tb_gen_associado on (cct_matr_associado, cct_cod_coo_associado) = (ass_matr_associado, ass_cod_cooperativa)"
			+ " join colmeia.tb_gcc_saldo_cc on (scc_cod_cooperativa, scc_nro_conta) = (cct_cod_cooperativa, cct_nro_conta)"
			+ " join colmeia.tb_gcc_movimento_cc mov on (mcc_cod_saldo_cc) = (scc_cod_saldo_cc)"
			+ " join colmeia.tb_gfe_mod_conta_corrente mod on (mov.mcc_cod_cooperativa_cc, mov.mcc_cod_operacao_cc) = (mod.mcc_cod_cooperativa, mod.mcc_cod_operacao)"
			+ " join colmeia.tb_gfe_parametro on (mov.mcc_cod_cooperativa_cc, mov.mcc_cod_operacao_cc) = (par_cod_cooperativa, par_cod_operacao)"
			+ " left join colmeia.tb_gcc_controle_caixa on (ccx_cod_controle_caixa) = (mcc_cod_controle_caixa)" 
			+ " left join colmeia.tb_gen_registro sit_controle_caixa on (sit_controle_caixa.reg_id_registro = ccx_situacao_caixa)" 
			+ " join colmeia.tb_gen_registro sit_movimento on (sit_movimento.reg_id_registro = mcc_situacao)" 
			+ " where cast(scc_data as date) = :data"
			+ " and mcc_origem_lancamento <> :origem"  
			+ " and sit_movimento.reg_cod_registro <> :situacao"
			+ " and mcc_cod_operacao_cc <> :operacaoResgate" 
			+ " and mcc_cod_operacao not in (4000, 4001)"
			+ " and (mcc_cod_controle_caixa is null or sit_controle_caixa.reg_cod_registro not in (:situacaoCaixaFechadoAjuste,"
			+ " :situacaoCaixaFechado, :situacaoCaixaFechamentoForcado, :situacaoCaixaFechamentoSemAutorizacao, :situacaoAutorizadoFechamento)) ";

	public static String SQL_PESQUISA_ESTORNO_CONTA_INVESTIMENTO = "select "
			+ "distinct "
			+ " cast(mci_nsu as int8) as nsu, "
			+ "cast (mci_dt_hora_movimento as date) as data, "
			+ "mci_cod_operacao_cc as \"codigoOperacao\", "
			+ "case when mci_valor = sum(mci_valor) over (partition by mci_nsu, cast(mci_dt_hora_movimento as date)) "
			+ "    then par_descricao "
			+ "	else mcc_desc_contrapartida end as descricao, "
			+ "sum(mci_valor) over (partition by mci_nsu, cast(mci_dt_hora_movimento as date)) as valor "
			+ "	, fn_reg_cod_registro(mcc_debito) as \"codigoRegistroDebito\" "
			+ "	, fn_reg_cod_registro(mcc_credito) as \"codigoRegistroCredito\" "
			+ "from tb_gcc_movimento_conta_invest "
			+ "join tb_gfe_mod_conta_corrente on (mcc_cod_operacao = mci_cod_operacao_cc and "
			+ "				  mcc_cod_cooperativa= mci_cod_cooperativa_cc) "
			+ "join tb_gfe_parametro on (par_cod_operacao = mci_cod_operacao_cc and "
			+ "				  par_cod_cooperativa = mci_cod_cooperativa_cc) "
			+ "join tb_gen_registro sit_movimento on (sit_movimento.reg_id_registro = mci_situacao) "
			+ "where cast (mci_dt_hora_movimento as date) = :data "
			+ "and mci_origem_lancamento <> :origem "
			+ "and mci_cod_operacao_cc <> :operacaoResgate "
			+ "and sit_movimento.reg_cod_registro <> :situacao ";

	public static String SQL_PESQUISA_ESTORNO_CONTA_CAPITAL = "select distinct "
			+ "cast (lcp_nsu as int8) as nsu, "
			+ "cast (lcp_dt_hora_movimento as date) as data, "
			+ "lcp_cod_operacao as \"codigoOperacao\", "
			+ "case when lcp_valor = sum(lcp_valor) over (partition by lcp_nsu, cast(lcp_dt_hora_movimento as date)) "
			+ "    then par_descricao "
			+ "	else mcc_desc_contrapartida end as descricao, "
			+ "sum(lcp_valor) over (partition by lcp_nsu, cast(lcp_dt_hora_movimento as date)) as valor "
			+ "	, fn_reg_cod_registro(mcc_debito) as \"codigoRegistroDebito\" "
			+ "	, fn_reg_cod_registro(mcc_credito) as \"codigoRegistroCredito\" "
			+ "from tb_gcc_movimento_conta_capital "
			+ "join tb_gfe_mod_conta_corrente on (mcc_cod_operacao = lcp_cod_operacao and "
			+ "				  mcc_cod_cooperativa= lcp_cod_cooperativa_operacao) "
			+ "join tb_gfe_parametro on (par_cod_operacao = lcp_cod_operacao and "
			+ "				  par_cod_cooperativa = lcp_cod_cooperativa_operacao) "
			+ "join tb_gen_registro sit_movimento on (sit_movimento.reg_id_registro = lcp_situacao) "
			+ "where cast (lcp_dt_hora_movimento as date) = :data "
			+ "and lcp_origem_lancamento <> :origem "
			+ "and lcp_cod_operacao <> :operacaoResgate "
			+ "and sit_movimento.reg_cod_registro <> :situacao ";

	public static String SQL_PESQUISA_ESTORNO_LOG_CAIXA = "select distinct "
			+ "cast(lcx_nsu as int8) as nsu, "
			+ "cast (lcx_dt_hora_movimento as date) as data, "
			+ "lcx_cod_operacao as \"codigoOperacao\", "
			+ "case when lcx_valor = sum(lcx_valor) over (partition by lcx_nsu, cast(lcx_dt_hora_movimento as date)) "
			+ "    then par_descricao "
			+ "	else mcc_desc_contrapartida end as descricao, "
			+ "sum(lcx_valor) over (partition by lcx_nsu, cast(lcx_dt_hora_movimento as date)) as valor "
			+ "	, fn_reg_cod_registro(mcc_debito) as \"codigoRegistroDebito\" "
			+ "	, fn_reg_cod_registro(mcc_credito) as \"codigoRegistroCredito\" "
			+ "from tb_gcc_log_caixa "
			+ "join tb_gfe_mod_conta_corrente on (mcc_cod_operacao = lcx_cod_operacao and "
			+ "				  mcc_cod_cooperativa= lcx_cod_coo_modalidade) "
			+ "join tb_gfe_parametro on (par_cod_operacao = lcx_cod_operacao and "
			+ "				  par_cod_cooperativa = lcx_cod_coo_modalidade) "
			+ "join tb_gen_registro sit_movimento "
			+ "			on (sit_movimento.reg_id_registro = lcx_situacao) "
			+ "left join tb_gcc_controle_caixa "
			+ "			on (ccx_cod_controle_caixa = lcx_cod_controle_caixa) "
			+ "left join tb_gen_registro sit_controle_caixa "
			+ "			on (sit_controle_caixa.reg_id_registro = ccx_situacao_caixa) "
			+ "where cast (lcx_dt_hora_movimento as date) = :data "
			+ "and lcx_origem_lancamento <> :origem "
			+ "and lcx_cod_operacao <> :operacaoResgate "
			+ "and sit_movimento.reg_cod_registro <> :situacao "
			+ "and (lcx_cod_controle_caixa is null or sit_controle_caixa.reg_cod_registro not in (:situacaoCaixaFechadoAjuste,"
			+ " :situacaoCaixaFechado, :situacaoCaixaFechamentoForcado, :situacaoCaixaFechamentoSemAutorizacao, :situacaoAutorizadoFechamento)) ";

	public static String SQL_PESQUISA_ESTORNO_SALDO_CONTA_BANCO = "select distinct "
			+ "cast(lcb_nsu as int8) as nsu, "
			+ "cast (lcb_dt_hora_movimento as date) as data, "
			+ "lcb_cod_operacao as \"codigoOperacao\", "
			+ "mcc_desc_contrapartida as descricao, "
			+ "lcb_valor as valor "
			+ "	, fn_reg_cod_registro(mcc_debito) as \"codigoRegistroDebito\" "
			+ "	, fn_reg_cod_registro(mcc_credito) as \"codigoRegistroCredito\" "
			+ "from tb_gcc_log_saldo_conta_banco "
			+ "join tb_gfe_mod_conta_corrente on (mcc_cod_operacao = lcb_cod_operacao and "
			+ "				  mcc_cod_cooperativa= lcb_cod_cooperativa) "
			+ "join tb_gen_registro sit_movimento "
			+ "			on (sit_movimento.reg_id_registro = lcb_situacao) "
			+ "join tb_gcc_saldo_conta_banco on (scb_cod_sld_conta_banco = lcb_cod_sldcontabanco) "
			+ "join tb_gcc_conta_bancaria on (scb_cod_conta = cba_cod_conta) "
			+ "where cast(lcb_dt_hora_movimento as date) = :data "
			+ "and sit_movimento.reg_cod_registro <> :situacao "
			+ "and lcb_cod_operacao <> :operacaoResgate "
			+ "and lcb_origem_lancamento <> :origem ";

	public static String SQL_RELATORIO_DESENQUADRAMENTO_CAPITAL = ""
			+ "	select matricula, "
			+ "       conta, "
			+ "       dvConta as  \"dvConta\", "
			+ "       nome, "
			+ "       situacao, "
			+ "       valorEmprestimos as \"valorEmprestimos\", "
			+ "       valorLimiteCheque as \"valorLimiteCheque\", "
			+ "       valorIntegralizado as \"valorIntegralizado\", "
			+ "       ceil(case when valorIntegralizarMulti <= 0.00 then valorIntegralizar else valorIntegralizarMulti end) as \"valorAIntegralizar\", "
			+ "       saldoContaCorrente as \"saldoContaCorrente\" , "
			+ "       multiplicador "
			+ "  from ( "
			+ " select a.ass_matr_associado as matricula, "
			+ "       fn_reg_descricao(a.ass_situacao) as situacao, "
			+ "       cc.cct_nro_conta as conta, "
			+ "       cc.cct_dv_conta_corrente as dvConta, "
			+ "       p.pes_nome as nome, "
			+ "  cast(saldo_capital.valor_integralizado as numeric(17,2)) as valorIntegralizado, "
			+ "       cast(GREATEST((c.coo_valor_cota * coo_qtd_quota_minima) - saldo_capital.valor_integralizado, 0.00) as numeric(17,2)) as valorIntegralizar, "
			+ "       cast(saldo_corrente.scc_vl_saldo_disponivel as numeric(17,2)) as saldoContaCorrente, "
			+ "       cast(saldo_corrente.valor_limite_cheque as numeric(17,2)) as valorLimiteCheque, "
			+ "       cast(saldo_emprestimo.valor_emprestimos as numeric(17,2)) + cast(valor_uso_adiantamento as numeric(17,2)) as valorEmprestimos, "
			+ "       cast((((saldo_emprestimo.valor_emprestimos + cast(valor_uso_adiantamento as numeric(17,2))) / cmo_indice_multiplicacao) -  saldo_capital.valor_integralizado) as numeric(17,2)) as valorIntegralizarMulti , "
			+ "       cmo_indice_multiplicacao as multiplicador "
			+ "  from tb_gen_associado a "
			+ "  join tb_gen_pessoa p on (a.ass_nro_documento = p.pes_nro_documento) "
			+ "  join tb_gen_cooperativa c on (a.ass_cod_cooperativa = c.coo_cod_cooperativa) "
			+ "  join tb_gfe_conf_margem_operacional mo "
			+ "    on (cmo_cod_cooperativa = case when (select cmo_cod_cooperativa from tb_gfe_conf_margem_operacional where cmo_cod_cooperativa=c.coo_cod_cooperativa) is not null then (select cmo_cod_cooperativa from tb_gfe_conf_margem_operacional where cmo_cod_cooperativa=c.coo_cod_cooperativa) "
			+ "    else (select coo_cooperativa_superior from tb_gen_cooperativa where coo_cod_cooperativa = (select coo_cooperativa_superior from tb_gen_cooperativa where coo_cod_cooperativa=c.coo_cod_cooperativa)) end) "
			+ "  join tb_gcc_conta_corrente cc on (a.ass_cod_cooperativa = cc.cct_cod_coo_associado AND a.ass_matr_associado = cc.cct_matr_associado)  "
			+ "  left join tb_gen_coo_singular_pac pa on (cc.cct_cod_cooperativa_pac, cc.cct_cod_pac) = (pa.csp_cod_cooperativa, pa.csp_cod_pac)  "
			+ "  join (select sca_nro_conta_capital,  "
			+ "               sca_cod_cooperativa, "
			+ "               (sca_vl_integra - sca_vl_resg) as valor_integralizado "
			+ "          from tb_gcc_saldo_conta_capital "
			+ "          join (select scc.sca_nro_conta_capital,  "
			+ "                       scc.sca_cod_cooperativa, "
			+ "                       max(scc.sca_dt_saldo) as sca_dt_saldo "
			+ "                  from tb_gcc_saldo_conta_capital scc  "
			+ "                 where scc.sca_dt_saldo <= :dataAte "
			+ "                   and scc.sca_cod_cooperativa = :codCooperativa "
			+ "                 group by scc.sca_nro_conta_capital, scc.sca_cod_cooperativa) a "
			+ "                 using (sca_nro_conta_capital, sca_cod_cooperativa, sca_dt_saldo)) as saldo_capital "
			+ "                    on (cc.cct_nro_conta = saldo_capital.sca_nro_conta_capital  "
			+ "                    and cc.cct_cod_cooperativa = saldo_capital.sca_cod_cooperativa) "
			+ "  join (select scc_nro_conta,  "
			+ "		       scc_cod_cooperativa, "
			+ "	       scc_vl_saldo_disponivel, "
			+ "		   scc_vl_limite as valor_limite_cheque, "
			+ "	       scc_vl_uso_adiantamento as valor_uso_adiantamento "
			+ "	  from tb_gcc_saldo_cc "
			+ "	  join (select scc_nro_conta, "
			+ "	               scc_cod_cooperativa, "
			+ "	               max(scc_data) as scc_data "
			+ "	          from tb_gcc_saldo_cc "
			+ "	         where scc_cod_cooperativa = :codCooperativa "
			+ "	           and scc_data <= :dataAte "
			+ "	         group by scc_nro_conta, scc_cod_cooperativa ) a "
			+ "	         using (scc_nro_conta, scc_cod_cooperativa, scc_data)) saldo_corrente "
			+ "	            on (cc.cct_nro_conta = saldo_corrente.scc_nro_conta "
			+ "	           and cc.cct_cod_cooperativa = saldo_corrente.scc_cod_cooperativa) "
			+ "  join (select cod_cooperativa_associado, "
			+ "       matricula_associado, "
			+ "       sum(valor_emprestimo) as valor_emprestimos "
			+ "   from (select cct_cod_cooperativa as cod_cooperativa_associado, epr_cod_operacao, "
			+ "                cct_matr_associado as matricula_associado, "
			+ "		sum(case "
			+ "			when trn_tipo_movimento=2075 and trn_cod_oper_central not in (1577,1578,1579) then -trn_vl_operacao "
			+ "			when trn_tipo_movimento=2074 and trn_cod_oper_central not in (1577,1578,1579) then trn_vl_operacao "
			+ "			when trn_tipo_movimento=2074 and trn_cod_oper_central in (1577,1578,1579) then -trn_vl_operacao "
			+ "			when trn_tipo_movimento=2075 and trn_cod_oper_central in (1577,1578,1579) then trn_vl_operacao "
			+ "		end) as valor_emprestimo "
			+ "		FROM "
			+ "			colmeia.tb_gfe_parcelas_emprestimo "
			+ "			join tb_gfe_emprestimo on (pae_nro_contrato=epr_nro_contrato) "
			+ "			join tb_gfe_parametro p on (par_cod_cooperativa = epr_cod_coo_modalidade and par_cod_operacao = epr_cod_operacao) "
			+ "			join tb_gfe_transitoria_emprestimo on (tem_nro_contrato=pae_nro_contrato and tem_nro_parcela=pae_nro_parcela) "
			+ "			join tb_gco_transitoria on (tem_cod_transitoria=trn_cod_transitoria) "
			+ "			join tb_gcc_conta_corrente on (cct_cod_cooperativa=epr_cod_cooperativa and epr_nro_conta=cct_nro_conta) "
			+ "			left join tb_gen_coo_singular_pac on (cct_cod_cooperativa_pac, cct_cod_pac) = (csp_cod_cooperativa, csp_cod_pac) "
			+ "			join tb_gen_associado a on a.ass_matr_associado = cct_matr_associado and a.ass_cod_cooperativa = cct_cod_coo_associado "
			+ "			join tb_gen_pessoa pes on pes.pes_nro_documento = a.ass_nro_documento "
			+ "		where trn_dt_movimento <= ( cast(:dataAte  as date) ) "
			+ "			and epr_situacao not in (6519,6520,6523,6525,6526,6527,6528,6530,6535,6538,6541,6543,6544,6660,6661,6662,6669,6670,6672,6790,7209,7457) "
			+ "			and not (pae_nro_parcela between 99950 and 99984) "
			+ "			and not (pae_nro_parcela between 99986 and 99998) "
			+ "			and not (pae_nro_parcela=99985 and trn_cod_oper_central not in (1577,1578,1579)) "
			+ "			and not (pae_nro_parcela=99999 and epr_cod_operacao not in (2005)) "
			+ "			and trn_cod_oper_central in (1503,1504,1505,1506,1507,1508,1509,1510,1511,1512,1513,1514,1515,1516,1617,1618,1619,1553,1561,1562,1606,1577,1578,1579) "
			+ "			and not (trn_cod_oper_central in (1504,1514,1508,1617,1618,1510,1619,1511,1513,1553,1516,1506) and trn_situacao in (2067,2068)) "
			+ "			and trn_cod_coo_mov=:codCooperativa ";

}