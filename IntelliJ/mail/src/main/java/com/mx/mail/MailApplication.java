package com.mx.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class MailApplication implements CommandLineRunner {
	@Autowired
	private JavaMailSender emailSender;

	public static void main(String[] args) {
		SpringApplication.run(MailApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

	public void simpleTextMessage() {
		String bodyMessage = "Este es un test de correo ID=" + UUID.randomUUID().toString();

		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setFrom("rglgonzalezsanchez@gmail.com");
		smm.setTo("rogel.gnz.snz@gmail.com");
		smm.setSubject("Test");
		smm.setText(bodyMessage);

		emailSender.send(smm);
	}

	public void fileTextMessage() throws MessagingException {
		String bodyMessage = "Este es un test de correo ID=" + UUID.randomUUID().toString();
		MimeMessage mime = emailSender.createMimeMessage();
		MimeMessageHelper message = new MimeMessageHelper(mime, true, "UTF-8");

		message.setFrom("rglgonzalezsanchez@gmail.com");
		message.setTo("rogel.gnz.snz@gmail.com");
		message.addAttachment("test.png", new File(""));
		message.setSubject("Test");
		message.setSentDate(new Date());
		message.setText("<h1>"+ bodyMessage +"</h1>", true);
		this.emailSender.send(mime);
	}
}
