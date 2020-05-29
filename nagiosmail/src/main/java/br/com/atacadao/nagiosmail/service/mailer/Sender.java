package br.com.atacadao.nagiosmail.service.mailer;

import java.util.Properties;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class Sender {
	
	
	public static JavaMailSender getMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		
		mailSender.setHost("10.113.80.147");
		mailSender.setPort(25);

		Properties mailProperties = new Properties();
		mailProperties.put("mail.smtp.auth", false);
		mailProperties.put("mail.smtp.starttls.enable", false);
		mailProperties.put("mail.debug", "false");// Prints out everything on screen

		mailSender.setJavaMailProperties(mailProperties);

		/*// Using gmail		
		  mailSender.setHost("smtp.gmail.com"); mailSender.setPort(587);
		  mailSender.setUsername("adrianomilitao@gmail.com");
		  mailSender.setPassword("militao150506");
		  
		  Properties javaMailProperties = new Properties();
		  javaMailProperties.put("mail.smtp.starttls.enable", "true");
		  javaMailProperties.put("mail.smtp.auth", "true");
		  javaMailProperties.put("mail.transport.protocol", "smtp");
		  javaMailProperties.put("mail.debug", "true");//Prints out everything on  screen
		  
		  mailSender.setJavaMailProperties(javaMailProperties);*/
		 

		return mailSender;
	}


}
