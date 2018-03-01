package br.com.dxc.dto;

public class FaseExecucaoDTO {
	
	private String UsuarioTransmissao;
	private String EnderecoTransmissao;
	private String senha;
	private String porta;
	
	public String getUsuarioTransmissao() {
		return UsuarioTransmissao;
	}
	public void setUsuarioTransmissao(String usuarioTransmissao) {
		UsuarioTransmissao = usuarioTransmissao;
	}
	public String getEnderecoTransmissao() {
		return EnderecoTransmissao;
	}
	public void setEnderecoTransmissao(String enderecoTransmissao) {
		EnderecoTransmissao = enderecoTransmissao;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getPorta() {
		return porta;
	}
	public void setPorta(String porta) {
		this.porta = porta;
	}	
	
}
