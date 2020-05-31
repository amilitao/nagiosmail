package br.com.atacadao.nagiosmail.model;

import java.util.ArrayList;
import java.util.List;

public class DadosDeEntrada {

	private List<Parametro> parametros = new ArrayList<Parametro>();

	public DadosDeEntrada(List<String> lista) {

		for (int s = 0; s < lista.size(); s += 2) {
			parametros.add(new Parametro(lista.get(s), lista.get(s + 1)));
		}

	}

	public List<String> get(String t) {

		List<String> procurados = new ArrayList<String>();

		for (Parametro p : parametros) {
			if (p.getTipo().equals(t)) {
				procurados.add(p.getValor());
			}
		}

		return procurados;
	}

	@Override
	public String toString() {
		return "DadosDeEntrada [parametros=" + parametros + "]";
	}

}
