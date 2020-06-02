package br.com.atacadao.nagiosmail.model;

public class Macro {
	
	private String tipo;
	private String valor;
	
	
	public Macro() {		
	}
	
	public Macro(String tipo, String valor) {
		this.tipo = tipo;
		this.valor = valor;
	}	



	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Parametro [tipo=" + tipo + ", valor=" + valor + "]";
	}
	
	
	
	

}
