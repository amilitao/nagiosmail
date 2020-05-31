package br.com.atacadao.nagiosmail;

import java.util.Arrays;
import java.util.List;

import br.com.atacadao.nagiosmail.model.Correio;
import br.com.atacadao.nagiosmail.model.DadosDeEntrada;
import br.com.atacadao.nagiosmail.model.Email;
import br.com.atacadao.nagiosmail.model.Template;
import br.com.atacadao.nagiosmail.service.mailer.Mailer;
import br.com.atacadao.nagiosmail.service.mailer.Sender;

public class Main {

	public static void main(String[] args) {
		
		  String[] vars = { "-f", "srvnagiosprd", "-t",
		  "adrianomilitao@atacadao.com.br", "-s", "Teste", "-h", "template.html", "-p",
		  "var1:adriano", "-p", "var2:alves" }; 
		  
		 			

		try {
			
			DadosDeEntrada dados = new DadosDeEntrada(Arrays.asList(vars));
			Correio correio = new Mailer(Sender.getMailSender());
			
			String from = dados.get("-f").get(0);
			String to = dados.get("-t").get(0);
			String subject = dados.get("-s").get(0);
			String html = dados.get("-h").get(0);
			List<String> macros = dados.get("-m");
			List<String> images = dados.get("-i");
			
			Template template = new Template(html, macros, images);		
			
			Email email = new Email(from, to, subject, template);
			
			correio.send(email);	
			
			System.out.println("Email enviado!: " + email);
			System.out.println(" DADOS: " + dados);

		} catch (Exception e) {
			
			System.out.println("Erro no sistema: " + e);
		}
		
		

	}

}
