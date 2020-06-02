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
		
		
		  String[] vars = { 
		   "-t", "adrianomilitao@atacadao.com.br",
		   "-s", "Teste", 
		   "-h", "template-padrao.html", 
		   "-m", "NOTIFICATIONTYPE:PROBLEM", 
		   "-i", "logoatac:logo-atacadao.jpg"};
		 
		  
		 

		try {
			
			DadosDeEntrada dados = new DadosDeEntrada(Arrays.asList(vars));
			Correio correio = new Mailer(Sender.getMailSender());			

			String to = dados.get("-t").get(0);
			String subject = dados.get("-s").get(0);
			String html = dados.get("-h").get(0);
			List<String> macros = dados.get("-m");
			List<String> images = dados.get("-i");
			
			Template template = new Template(html, macros, images);		
			
			Email email = new Email(to, subject, template);
			
			correio.send(email);	
			
			System.out.println("RESULTADO: Email enviado com sucesso!");
			System.out.println("DADOS: " + dados);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("RESULTADO: Erro no sistema - " + e);
		}
		
		

	}

}
