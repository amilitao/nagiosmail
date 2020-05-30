package br.com.atacadao.nagiosmail.model;

import br.com.atacadao.nagiosmail.service.mailer.Mailer;

public class Correio {
	
	private Mailer mailer = new Mailer();
	
	public void enviar(Email email) {
		mailer.sendEmail(email);
	}

}
