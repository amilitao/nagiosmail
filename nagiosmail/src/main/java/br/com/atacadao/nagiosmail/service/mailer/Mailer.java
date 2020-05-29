package br.com.atacadao.nagiosmail.service.mailer;

import javax.mail.internet.MimeMessage;

import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import br.com.atacadao.nagiosmail.model.Email;

public class Mailer {

	private JavaMailSender javaMailSender = Sender.getMailSender();

	public void sendEmail(Email msg) {

		MimeMessagePreparator preparator = getContentWtihAttachementMessagePreparator(msg);

		try {

			javaMailSender.send(preparator);

		} catch (MailException ex) {
			System.out.println(ex.getMessage());

		}

	}

	public void sendEmailHtml(Email msg) {

		MimeMessagePreparator preparator = getContentWtihAttachementMessagePreparator(msg);

		try {

			preparator = getContentAsInlineResourceMessagePreparator(msg);
			javaMailSender.send(preparator);

		} catch (MailException ex) {
			System.out.println(ex.getMessage());

		}
	
	}

	private MimeMessagePreparator getContentWtihAttachementMessagePreparator(Email msg) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
				
				helper.setFrom(msg.getFrom());
				helper.setTo(msg.getTo());
				helper.setSubject(msg.getSubject());
				helper.setText(msg.getContent());

			}
		};
		return preparator;
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
				helper.setText(email.getContent(), true);

				helper.addInline("identifier1234", new ClassPathResource("/images/logo_atacadao.png"));
			}
		};
		return preparator;
	}

}