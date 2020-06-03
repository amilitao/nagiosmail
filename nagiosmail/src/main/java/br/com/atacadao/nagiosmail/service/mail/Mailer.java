package br.com.atacadao.nagiosmail.service.mail;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import br.com.atacadao.nagiosmail.model.Correio;
import br.com.atacadao.nagiosmail.model.Email;

public class Mailer implements Correio {

	private JavaMailSender javaMailSender;

	public Mailer(JavaMailSender mailSender) {
		this.javaMailSender = mailSender;
	}

	@Override
	public void send(Email email) {

		MimeMessagePreparator preparator;

		preparator = getContentAsInlineResourceMessagePreparator(email);
		javaMailSender.send(preparator);

	}

	private MimeMessagePreparator getContentAsInlineResourceMessagePreparator(Email email) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {

				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

				helper.setFrom(email.getFrom());

				for (String to : email.getTo()) {
					helper.addTo(to);
				}

				helper.setSubject(email.getSubject());

				// Add an inline resource.
				// use the true flag to indicate you need a multipart message
				helper.setText(email.getTemplate().getHtml(), true);

				// adicionando imagens ao html
				String[] img = email.getTemplate().getImages();
				if (img != null) {
					for (String name : img) {

						FileSystemResource res = new FileSystemResource(
								new File("/usr/local/nagiosql/nagiosmail/images/" + name));

						helper.addInline(name, res);

					}
				}
			}
		};

		return preparator;
	}

}
