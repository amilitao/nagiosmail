package br.com.atacadao.nagiosmail.model;

public class Email {

	private String from;
	private String to;
	private String subject;
	private Template template;

	public Email(String from, String to, String subject, Template template) {
		this.from = from;
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

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
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
		return "Email [from=" + from + ", to=" + to + ", subject=" + subject + "]";
	}

}
