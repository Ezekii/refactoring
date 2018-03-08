package br.com.dxc.util;

/**
 * Classe de constantes comuns.
 * 
 * @author Franscielly Benvenutti Eccel
 * 
 */
public class Constantes {

	public static final String DESCRICAO_REGISTRO_ATIVO = "ATIVO";

	public static final String CAMINHO_PAGINA_INICIAL = "/exibir_pagina_inicial.do";

	public static final String CACHE_QUERY_SPACE = "";

	/**
	 * Constantes de Indexador
	 */
	public static final Integer INDEXADOR_CPMF = 1;

	/**
	 * Constante de Tamanho default de collection, necess�rio para evitar erro
	 * em update versioned do Hibernate + JBoss 4.x
	 */
	public static final Integer DEFAULT_COLLECTION_SIZE = 1000;

	/**
	 * A��es dos m�todos.
	 */
	public static final String ACAO = "acao";

	public static final String ACAO_ALTERAR = "alterar";

	public static final String ACAO_INCLUIR = "incluir";

	public static final String ACAO_EXCLUIR = "excluir";

	public static final String ACAO_EXIBIR = "exibir";

	public static final String ACAO_ENCERRAR = "encerrar";

	public static final String ACAO_PESQUISAR = "pesquisar";

	public static final String ACAO_CANCELAR = "cancelar";

	public static final String ACAO_CONFIGURAR = "configurar";

	public static final String ACAO_CONCILIAR = "conciliar";

	public static final String ACAO_LIBERAR = "liberar";

	public static final String ACAO_IMPORTAR = "importar";

	public static final String ACAO_AJUSTAR = "ajustar";

	public static final String ACAO_FECHAR = "fechar";

	public static final String ACAO_INATIVAR = "inativar";

	public static final String ACAO_REATIVAR = "reativar";

	public static final String ACAO_ABRIR = "abrir";

	public static final String ACAO_VINCULAR = "vincular";

	public static final String ACAO_CONFIGURAR_REQUISITOS = "configurarRequisitos";

	public static final String FWD_MANTER = "manter";

	public static final String FWD_INCLUIR = "incluir";

	public static final String FWD_ALTERAR = "alterar";

	public static final String FWD_EXIBIR = "exibir";

	public static final String FWD_INATIVAR = "inativar";
	
	public static final String FWD_PAGINA_INICIAL = "paginaInicial";

	public static final int TAMANHO_CPF = 11;

	public static final int TAMANHO_CNPJ_REDUZIDO = 8;

	public static final int TAMANHO_CNPJ = 14;

	public static final int TAMANHO_CONTRATO = 40;

	public static final String SQL_STATE_SERIALIZATION_FAILURE = "40001";

	public static final String SQL_STATE_DUPLICATE_KEY_VALUE_IOLATES = "23505";

	public static final String NUMERO_MAXIMO_TENTATIVAS_OBTER_NSU = "numero.maximo.tentativas.obter.nsu";

	public static final String VAZIO = "";

	/**
	 * Dom�nio Sim/N�o.
	 */
	public static final Integer DOMINIO_SIM_NAO = 19;
	public static final String REGISTRO_SIM = "1";
	public static final String REGISTRO_NAO = "2";
	public static final Integer ID_REGISTRO_SIM = 367;
	public static final Integer ID_REGISTRO_NAO = 368;

	public static final String SIM = "S";
	public static final String NAO = "N";

	public static final String SIM_DESCRICAO = "SIM";
	public static final String NAO_DESCRICAO = "N�O";

	public static final String PASTA_ARQUIVO_AGENDAMENTO = "pasta.arquivoAgendamento";

	public static final String PASTA_RELATORIOS_EXPIRADOS = "pasta.relatoriosExpirados";

	public static final String GRUPO_JOB_QUARTZ = "grupo_colmeia";

	public static final String NOME_JOB_QUARTZ = "nome";

	public static final String AGENDAMENTO_JOB_QUARTZ = "agendamento";

	public static final String SYSTEM_FILE_SEPARATOR = "file.separator";

	public static final String QUARTZ_DS_SQL = "quartz_ds_sql";

	public static final String XML_SIMPLETYPE_STRING = "string";

	public static final String XML_SIMPLETYPE_BOOLEAN = "boolena";

	public static final String XML_SIMPLETYPE_FLOAT = "float";

	public static final String XML_SIMPLETYPE_DECIMAL = "decimal";

	public static final String XML_SIMPLETYPE_DURATION = "duration";

	public static final String XML_SIMPLETYPE_TIME = "time";

	public static final String XML_SIMPLETYPE_DATETIME = "datetime";

	public static final String XML_SIMPLETYPE_DATE = "date";

	public static final String XML_SIMPLETYPE_GYEARMONTH = "gYearmonth";

	public static final String XML_SIMPLETYPE_GYEAR = "gyear";

	public static final String XML_SIMPLETYPE_GMONTHDAY = "gmonthday";

	public static final String XML_SIMPLETYPE_GDAY = "gday";

	public static final String XML_SIMPLETYPE_GMONTH = "gmonth";

	public static final String XML_SIMPLETYPE_HEXBINARY = "hexbinary";

	public static final String XML_SIMPLETYPE_BASE64BINARY = "base64binary";

	public static final String XML_SIMPLETYPE_ANYURI = "anyuri";

	public static final String XML_SIMPLETYPE_QNAME = "qname";

	public static final String XML_SIMPLETYPE_NOTATION = "notation";

	public static final String PASTA_RELATORIOS = "pasta.relatorios";

	public static final String PASTA_ARQUIVO_TEXTO = "pasta.arquivoTxt";

	public static final String PASTA_ARQUIVO_DOC = "pasta.arquivoDoc";

	public static final String PASTA_ARQUIVO_XLS = "pasta.arquivoXls";

	public static final String PASTA_ARQUIVO_XML = "pasta.arquivoXml";

	public static final String PASTA_ARQUIVO_CSV = "pasta.arquivoCsv";

	public static final String PASTA_ARQUIVO_TEMPORARIO = "pasta.arquivoTemporario.zip";

	public static final String PASTA_ARQUIVO_ZIP = "pasta.arquivoZip";

	public static final String PASTA_SHELL = "pasta.shell";

	public static final String PASTA_SHELL_TXT = "pasta.shell.txt";

	public static final String PASTA_RELATORIOS_COMPILADOS = "pasta.relatorios.compilados";

	public static final String PASTA_RELATORIOS_GERADOS = "pasta.relatorios.gerados";

	public static final String PASTA_DOCUMENTOS_ASSINATURA_ASSOCIADO = "pasta.documentos.assinatura.associado";

	public static final String SUBREPORT_DIR = "SUBREPORT_DIR";

	public static final String BLOQUEAR_DOWNLOAD = "bloquearDownload";

	/**
	 * Constantes para shells chamadas pelo sistema
	 */
	public static final String SHELL_LIMPA_ARQUIVOS = "expira_relatorios_colmeia.sh";

	/**
	 * Constante para e-mail que deve ser usado em caso de cancelamento de
	 * execu��o do fluxo
	 */
	public static final String EMAIL_PRODUCAO = "email.producao";

	/**
	 * Constante para o tipo da ordenacao do resultado da busca
	 */
	public static final Integer TIPO_ORDENACAO_BUSCA_CRESCENTE = 1;
	public static final Integer TIPO_ORDENACAO_BUSCA_DECRESCENTE = 2;

	/**
	 * Constante para os sockets
	 */
	public static final String SOCKET_POOL_TAMANHO = "socket.pool.tamanho";
	public static final String SOCKET_POOL_IDLE_MILIS = "socket.pool.idlemilis";
	public static final String SOCKET_POOL_TAMANHO_IDLE = "socket.pool.tamanho.idle";
	public static final String SOCKET_POOL_SERVIDOR_IP = "socket.pool.servidor.ip";
	public static final String SOCKET_POOL_SERVIDOR_PORTA = "socket.pool.servidor.porta";
	public static final String SOCKET_TIMEOUT = "socket.timeout";

	/**
	 * Constante de erro inesperado do Colmeia
	 */
	public static final String ERRO_COLMEIA_INESPERADO = "ERRO_COLMEIA_INESPERADO: ";

	public static final String SIGLA_SISTEMA_COLMEIA = "CLM";

	public static final int DEZ_MEGA_BYTE_EM_BYTES = 10485760;
}
