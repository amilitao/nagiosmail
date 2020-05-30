package br.com.atacadao.nagiosmail;

import java.util.Arrays;

import br.com.atacadao.nagiosmail.model.Correio;
import br.com.atacadao.nagiosmail.model.DadosDeEntrada;
import br.com.atacadao.nagiosmail.model.Email;
import br.com.atacadao.nagiosmail.model.Template;

public class Main {

	// "-f", "srvnagiosprd",
	// "-t", "adrianomilitao@atacadao.com.br",
	// "-s", "Teste",
	// "-h", "template.html",
	// "-p", "var1:$VAR" };

	public static void main(String[] args) {
		
		String[] vars = {
		 "-f", "srvnagiosprd",
		 "-t", "adrianomilitao@atacadao.com.br",
		 "-s", "Teste",
		 "-h", "template.html",
		 "-p", "var1:$VAR" };

		DadosDeEntrada dados = new DadosDeEntrada(Arrays.asList(vars));
		Correio correio = new Correio();
		Email email = new Email();

		try {
			
			Template template = new Template(
					dados.getParametros("-h").get(0).getValor(), dados.getParametros("-p"));


			email.setFrom(dados.getParametros("-f").get(0).getValor());
			email.setTo(dados.getParametros("-t").get(0).getValor());
			email.setSubject(dados.getParametros("-s").get(0).getValor());
			email.setContent(template.getConteudoAlterado());

			correio.enviar(email);
			
			System.out.println("Enviado com sucesso");

		} catch (Exception e) {
			System.out.println("Erro no sistema: " + e);
		}
		
		

	}

}
