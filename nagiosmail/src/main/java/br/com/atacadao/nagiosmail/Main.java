package br.com.atacadao.nagiosmail;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.atacadao.nagiosmail.service.CorreioService;
import br.com.atacadao.nagiosmail.service.impl.CorreioCsc;

public class Main {

	public static void main(String[] args) {
		

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				Main.class.getPackage().getName());

		CorreioService correio = applicationContext.getBean(CorreioCsc.class);
		
		correio.enviar(args);

		applicationContext.close();

	}

}
