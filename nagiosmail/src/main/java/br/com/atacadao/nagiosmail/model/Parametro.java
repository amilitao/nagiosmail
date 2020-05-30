package br.com.atacadao.nagiosmail.model;

public class Parametro {
	
	private String tipo;
	private String valor;
	
	
	public Parametro() {		
	}
	
	public Parametro(String tipo, String valor) {
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
