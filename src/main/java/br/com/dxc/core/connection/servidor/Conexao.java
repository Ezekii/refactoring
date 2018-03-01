package br.com.dxc.core.connection.servidor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * JavaBean responsavel em manter as propriedades de uma conexão com um sistema
 * externo
 * 
 * @author Robson
 * 
 */
public class Conexao implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String tipo;

	private String usuario;

	private String senha;

	private String uri;

	private String porta;

	private String para;

	private String assunto;

	private String forma;

	private Map parametros;

	private List<Anexo> arquivos;

	private StringBuffer corpo;

	private String metodoChamado;

	private Integer connectionTimeout;

	private Integer readTimeout;

	/**
	 * Construtor padrão para uma conexão
	 * 
	 * @param id
	 * @param tipo
	 * @param usuario
	 * @param senha
	 * @param uri
	 * @param porta
	 * @param para
	 */
	public Conexao(String tipo, String usuario, String senha, String uri,
			String porta, String para) {
		super();
		this.tipo = tipo;
		this.usuario = usuario;
		this.senha = senha;
		this.uri = uri;
		this.porta = porta;
		this.para = para;

	}

	/**
	 * Construtor simples para conexoes socket
	 */
	public Conexao(String uri, String porta) {
		super();
		this.uri = uri;
		this.porta = porta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getPorta() {
		return porta;
	}

	public void setPorta(String porta) {
		this.porta = porta;
	}

	@Override
	public boolean equals(Object o) {
		if (this.id == null)
			return false;
		if (!(o instanceof Conexao))
			return false;

		return this.id.equals(((Conexao) o).id);
	}

	@Override
	public int hashCode() {
		return this.id == null ? System.identityHashCode(this) : this.id
				.hashCode();
	}

	@Override
	public String toString() {
		if (id != null)
			return "ID : " + id.toString() + " Tipo: " + tipo + " Uri:" + uri
					+ " Porta: " + porta + " " + " usuario:" + usuario;
		else
			return " IP (URI): " + uri + " Porta: " + porta;
	}

//	public int compareTo(Object o) {
//		long minhaChave = 0;
//		if (this.id != null)
//			minhaChave = ((Long) this.id).longValue();
//
//		long paramChave = 0;
//		if (((BaseVO) o).getChave() != null)
//			paramChave = ((Long) ((BaseVO) o).getChave()).longValue();
//
//		return (int) (minhaChave - paramChave);
//	}

	public String getPara() {
		return para;
	}

	public void setPara(String para) {
		this.para = para;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getForma() {
		return forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}

	public Map getParametros() {
		return parametros;
	}

	public void setParametros(Map parametros) {
		this.parametros = parametros;
	}

	public List<Anexo> getArquivos() {
		return arquivos;
	}

	public void setArquivos(List<Anexo> arquivos) {
		this.arquivos = arquivos;
	}

	public StringBuffer getCorpo() {
		return corpo;
	}

	public void setCorpo(StringBuffer corpo) {
		this.corpo = corpo;
	}

	public String getMetodoChamado() {
		return metodoChamado;
	}

	public void setMetodoChamado(String metodoChamado) {
		this.metodoChamado = metodoChamado;
	}

	public Integer getConnectionTimeout() {
		return connectionTimeout;
	}

	public void setConnectionTimeout(Integer connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}

	public Integer getReadTimeout() {
		return readTimeout;
	}

	public void setReadTimeout(Integer readTimeout) {
		this.readTimeout = readTimeout;
	}

}
