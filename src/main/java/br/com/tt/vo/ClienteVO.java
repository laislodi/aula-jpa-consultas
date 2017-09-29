package br.com.tt.vo;

public class ClienteVO {
	private String nome;
	private String rua;

	public ClienteVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClienteVO(String nome, String rua) {
		super();
		this.nome = nome;
		this.rua = rua;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}
	
	@Override
	public String toString() {
		return this.nome + "  -  " + this.rua;
	}
}
