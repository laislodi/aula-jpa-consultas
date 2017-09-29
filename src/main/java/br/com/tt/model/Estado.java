package br.com.tt.model;

public enum Estado {
	AC("Acre"), AL("Alagoas"), AM("Amazonas"), AP("Amapá"), BA("Bahia"), CE("Ceará"),
	DF("Distrito Federal"), ES("Espírito Santo"), GO("Goiás"), MA("Maranhão"), MT ("Mato Grosso"), MS("Mato Grosso do Sul"), 
	MG("Minas Gerais"), PA("Pará"), PB("Paraíba"), PE("Pernambuco"), PI("Piauí"), PR("Paraná"), 
	RJ("Rio de Janeiro"), RS("Rio Grande do Sul"), RN("Rio Grande do Norte"), RO("Rondônia"), RR("Roraima"),SC("Santa Catarina"),
	SP("São Paulo"), SE("Sergipe"), TO("Tocantins");

	private String descricao;
	
	private Estado(String descricao) {
		this.descricao = descricao; 
	}
	
	public String getDescricao() {
		return descricao;
	} 
	
	
			
}
