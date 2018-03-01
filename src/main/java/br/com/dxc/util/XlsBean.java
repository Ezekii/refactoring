package br.com.dxc.util;

/**
 * Classe respons�vel por ter o dado de uma determinada linha do arquivo e a
 * número da célula(coluna) que o mesmo deve ser incluído.
 * 
 * @author Lucas Rocha.
 */
public class XlsBean {

	private Object dado;

	private Integer celulaArquivo;

	private Integer linhaArquivo;

	public Object getDado() {
		return dado;
	}

	public void setDado(Object dado) {
		this.dado = dado;
	}

	public Integer getCelulaArquivo() {
		return celulaArquivo;
	}

	public void setCelulaArquivo(Integer celulaArquivo) {
		this.celulaArquivo = celulaArquivo;
	}

	public Integer getLinhaArquivo() {
		return linhaArquivo;
	}

	public void setLinhaArquivo(Integer linhaArquivo) {
		this.linhaArquivo = linhaArquivo;
	}
}