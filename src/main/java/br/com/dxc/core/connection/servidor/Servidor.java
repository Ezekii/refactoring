package br.com.dxc.core.connection.servidor;

import java.net.URLConnection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Servidor {

	protected static Logger log = LoggerFactory.getLogger(Servidor.class);

	public static final String TIMEOUT = "timeout.conexao.https";

	/**
	 * Propriedade responsável em conter os parâmetros de conexão do servidor
	 */
	private Conexao conn;

	/**
	 * Método responsável em conectar à um servidor da conexão informada
	 * 
	 * @return Boolean
	 */
	public abstract Boolean conectar(Map parametros) throws Exception;

	/**
	 * Retorna se o servidor está conectado
	 * 
	 * @return Boolean
	 */
	public abstract Boolean isConectado();

	/**
	 * Método responsável em enviar uma informação à um servidor
	 * 
	 * @return String
	 * @throws Exception 
	 */
	public abstract String enviar(Map parametros) throws Exception;

	/**
	 * Método responsável em receber uma informação à um servidor
	 * 
	 * @return String
	 * @throws Exception 
	 */
	public abstract String receber(Map parametros) throws Exception;

	public void desconectar() {
	}

	public Conexao getConn() {
		return conn;
	}

	public void setConn(Conexao conn) {
		this.conn = conn;
	};

	public Servidor() {
	}

	public Servidor(Conexao conn) {
		setConn(conn);
	}

	/**
	 * Caso exista configuração de proxy, método abaixo utilizado para
	 * autenticar. Se conection != null, é setado user e pwd diretamente na
	 * conexao
	 * 
	 * @param conection
	 * @throws Exception
	 */
	protected void verificaProxy(URLConnection conection) throws Exception {
		new ProxyUtil().verificaProxy(conection);
	}
}