package br.com.atacadao.nagiosmail;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.atacadao.nagiosmail.model.Email;
import br.com.atacadao.nagiosmail.model.Template;
import br.com.atacadao.nagiosmail.service.mailer.Mailer;

public class Main {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				Main.class.getPackage().getName());		

		String[] v = {"from","to","subject","template-csc.html", "var1:$VAR"};
		args = v;		
		
		Email email = applicationContext.getBean(Email.class);
		Mailer mailer = applicationContext.getBean(Mailer.class);			
	
		
		email.setFrom(args[0]);
		email.setTo(args[1]);
		email.setSubject(args[2]);
		
		Template template = new Template(args[3]);		
		
		try {			
			
			template.adicionaValores(args);
			email.setContent(template.getConteudo());
			
		} catch (IOException e) {			
			System.out.println(e.getMessage());
		}	


		//mailer.sendEmailHtml(email);

		applicationContext.close();

	}

}
