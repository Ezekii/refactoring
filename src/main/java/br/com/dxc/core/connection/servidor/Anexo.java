package br.com.dxc.core.connection.servidor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JavaBean responsável em manter a informação de um arquivo anexado a uma
 * conexão
 * 
 * @author Robson
 * 
 */
public class Anexo implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	public String nome;

	public byte[] arquivo;

	private static Logger log = LoggerFactory.getLogger(Anexo.class);

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public byte[] getArquivo() {
		return arquivo;
	}

	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
	}

	public int compareTo(Object arg0) {
		return 0;
	}

	@Override
	public int hashCode() {
		return System.identityHashCode(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	/**
	 * Anexa um file serializado da forma que o JMS permita enviar
	 * 
	 * @param file
	 * @throws ClassNotFoundException
	 */
	public void anexar(File file) throws Exception {
		InputStream in;
		try {
			in = new FileInputStream(file);
			byte[] data = new byte[in.available()];
			in.read(data);
			setArquivo(data);
		} catch (FileNotFoundException e) {
			log.error("ERRO_COLMEIA_INESPERADO: ", e);
			throw e;
		} catch (IOException e) {
			log.error("ERRO_COLMEIA_INESPERADO: ", e);
			throw e;
		}
	}

	public String toString() {
		return this.getNome();
	}

}
