package br.com.atacadao.nagiosmail.service.impl;

import org.springframework.stereotype.Service;

import br.com.atacadao.nagiosmail.model.Email;
import br.com.atacadao.nagiosmail.service.CorreioService;
import br.com.atacadao.nagiosmail.service.mailer.Mailer;

@Service
public class Csc implements CorreioService {

	@Override
	public void enviar(String[] args) {

		Mailer mailer = new Mailer();
		Email email = new Email();

		email.setFrom("adrianomilitao@atacadao.com.br");
		email.setTo("adrianomilitao@gmail.com");
		email.setSubject("teste");
		email.setContent(
				
				"<html>" + 
				"<body>" + 
						"<p>" + "conteudo adicionado" + "</p><img src='cid:identifier1234'>"+ 
				"</body>" + 
				"</html>");

		mailer.sendEmailHtml(email);

	}

}
