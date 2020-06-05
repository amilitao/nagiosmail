package br.com.atacadao.nagiosmail.model;

import java.util.ArrayList;
import java.util.List;

public class DadosDeEntrada {

	private List<String> dados;

	public DadosDeEntrada(List<String> dados) {

		this.dados = dados;

	}

	public List<String> getContatos() {

		List<String> lista = new ArrayList<>();
		String[] contatos = dados.get(0).split(",");

		for (String address : contatos) {
			lista.add(address.trim());
		}

		return lista;

	}

	public String getNomeTemplate() {
		return this.dados.get(2);
	}

	public List<Macro> getMacros() {

		List<Macro> lista = new ArrayList<Macro>();

		for (String s : dados.subList(3, dados.size())) {

			String[] m = s.split("#");
			lista.add(new Macro(m[0], m[1]));

		}

		return lista;
	}

	public String getSubject() {
		return this.dados.get(1);
	}

	/*
	 * private String getMacro(String str) {
	 * 
	 * String macro = "";
	 * 
	 * for (Macro m : getMacros()) { if (m.getTipo().equals(str)) { macro =
	 * m.getValor(); } }
	 * 
	 * return macro;
	 * 
	 * }
	 */
	@Override
	public String toString() {
		return "DadosDeEntrada [parametros=" + dados + "]";
	}

}
