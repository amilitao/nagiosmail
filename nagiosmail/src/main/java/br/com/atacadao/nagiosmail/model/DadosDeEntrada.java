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

	public String getTemplate() {
		
		String nameTemplate = "";
		
		if(dados.get(1).equals("host")) {
			nameTemplate = "template-host.html";
		}else if(dados.get(1).equals("service")) {
			nameTemplate = "template-service.html";
		}else {
			System.out.println("parametro incorreto");
		}
		
		return nameTemplate;
	}

	public List<Macro> getMacros() {

		List<Macro> lista = new ArrayList<Macro>();

		for (String s : dados.subList(2, dados.size())) {

			String[] m = s.split(":");
			lista.add(new Macro(m[0], m[1]));

		}

		return lista;
	}

	public String getSubject() {

		String var = "";

		for (Macro m : getMacros()) {
			if (m.getTipo().equals("NOTIFICATIONTYPE")) {
				var = m.getValor();
			}
		}

		return "Atenção: Notificação Nagios *** " + var;
	}

	@Override
	public String toString() {
		return "DadosDeEntrada [parametros=" + dados + "]";
	}

}
