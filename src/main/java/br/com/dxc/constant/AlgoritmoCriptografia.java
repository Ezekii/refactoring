package br.com.dxc.constant;

/**
 * Enum respons�vel em ter os tipos de criptografias que possam ser feitas no
 * colmeia.
 * 
 * @author Lucas Rocha.
 * 
 */
public enum AlgoritmoCriptografia {

	SHA256("SHA-256"), MD5("MD5");

	private String tipoCriptografia;

	private AlgoritmoCriptografia(String tipoCriptografia) {
		this.tipoCriptografia = tipoCriptografia;
	}

	public String getTipoCriptografia() {
		return tipoCriptografia;
	}

	public void setTipoCriptografia(String tipoCriptografia) {
		this.tipoCriptografia = tipoCriptografia;
	}

}
