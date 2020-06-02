package br.com.atacadao.nagiosmail.model;

public enum TipoNotificacao {
	
	PROBLEM("#FFBEBE"), RECOVERY("green"), ACKNOWLEDGEMENT("yellow"), FLAPPINGSTART(""), FLAPPINGSTOP(""), 
	FLAPPINGDISABLED(""), DOWNTIMESTART(""), DOWNTIMEEND(""), DOWNTIMECANCELLED("");

	private String cor;
	
	TipoNotificacao(String cor) {
		this.cor = cor;
	}

	public String getCor() {
		return cor;
	}	
	

}
