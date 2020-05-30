package br.com.atacadao.nagiosmail;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.atacadao.nagiosmail.service.CorreioService;

public class Main {

	public static void main(String[] args) {
		

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				Main.class.getPackage().getName());

		String nomeDaClasse = "Csc";

		try {
			Class<?> classe = Class.forName("br.com.atacadao.nagiosmail.service.impl." + nomeDaClasse);

			CorreioService c = (CorreioService) classe.newInstance();

			CorreioService correio = applicationContext.getBean(c.getClass());

			correio.enviar(args);

		} catch (Exception e) {
			throw new RuntimeException("Encontrou erro " + e);
		}

		applicationContext.close();

	}

}
