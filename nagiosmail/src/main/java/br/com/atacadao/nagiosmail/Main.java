package br.com.atacadao.nagiosmail;

import java.util.Arrays;

import br.com.atacadao.nagiosmail.model.Correio;
import br.com.atacadao.nagiosmail.model.DadosDeEntrada;
import br.com.atacadao.nagiosmail.model.Email;
import br.com.atacadao.nagiosmail.model.Template;
import br.com.atacadao.nagiosmail.service.mail.Mailer;
import br.com.atacadao.nagiosmail.service.mail.Sender;

public class Main {

	public static void main(String[] args) {
		
		  Correio correio = new Mailer(Sender.getMailSender());	
		
			/*
			 * String[] vars = {"adrianomilitao@atacadao.com.br", "0",
			 * "template-host-1.html", "PROBLEM#NOTIFICATIONTYPE"};
			 */
			 

		try {
			
			DadosDeEntrada dados = new DadosDeEntrada(Arrays.asList(args));			
			
			Template template = new Template(dados.getTemplate(), dados.getMacros());				
			
			Email email = new Email(
					dados.getContatos(), dados.getSubject(), template);
			
			correio.send(email);	
			
			System.out.println("RESULTADO: Email enviado com sucesso!");
			System.out.println("DADOS: " + dados);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("RESULTADO: Erro no sistema - " + e);
		}
		
		

	}

}
