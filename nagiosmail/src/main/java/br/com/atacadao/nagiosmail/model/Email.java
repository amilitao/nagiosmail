package br.com.atacadao.nagiosmail.model;

import java.util.List;

public class Email {

	private String from = "srvnagiosprd@atacadao.com.br";
	private List<String> to;
	private String subject;
	private Template template;	

	public Email(List<String> to, String subject, Template template) {
		this.to = to;	
		this.subject = subject;
		this.template = template;		
		
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}	
	
	public List<String> getTo() {
		return to;
	}

	public void setTo(List<String> to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}	

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	@Override
	public String toString() {
		return "Email [from=" + from + ", to=" + to + ", subject=" + subject + ", template=" + template + "]";
	}	

	

	
}
