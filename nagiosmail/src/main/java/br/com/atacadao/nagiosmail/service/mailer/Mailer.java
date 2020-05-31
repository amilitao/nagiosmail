package br.com.atacadao.nagiosmail.service.mailer;

import java.io.File;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
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

		try {

			preparator = getContentAsInlineResourceMessagePreparator(email);
			//javaMailSender.send(preparator);

		} catch (MailException ex) {
			System.out.println(ex.getMessage());

		}

	}

	private MimeMessagePreparator getContentAsInlineResourceMessagePreparator(Email email) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

				helper.setFrom(email.getFrom());
				helper.setTo(email.getTo());
				helper.setSubject(email.getSubject());

				// Add an inline resource.
				// use the true flag to indicate you need a multipart message
				helper.setText(email.getTemplate().getConteudo(), true);

				List<String> images = email.getTemplate().getImages();
				if (!images.isEmpty()) {

					for (String s : images) {

						String[] paramImages = s.split(":");

						FileSystemResource res = new FileSystemResource(
								new File("/usr/local/nagiosql/nagiosmail/images/" + paramImages[1]));
						helper.addInline(paramImages[0], res);

					}

				}

			}
		};
		return preparator;
	}

}
