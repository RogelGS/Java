package com.mx.mailtest;

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

@SpringBootApplication
public class MailTestApplication implements CommandLineRunner {
	@Autowired
	private JavaMailSender libParaCorreo;

	public static void main(String[] args) {
		SpringApplication.run(MailTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//simpleEmail("rogel.gnz.snz@gmail.com", "Prueba de correo", "Esta es una prueba de Correo");
		String html = "";

		html += "<div>" +
					"<h1 style='font-size: 30px'>Probando html en el correo</h1>" +
					"<p>Esto es un pequeño parrafo</p>" +
				"</div>";
		fileEmail("rogel.gnz.snz@gmail.com", "Prueba con archivo", html, "D:\\Projects\\Java\\IntelliJ\\mail-test\\src\\main\\resources\\static\\imagen.jpg");
	}

	public void simpleEmail(String to, String subject, String body) {
		SimpleMailMessage crearEmail = new SimpleMailMessage();

		crearEmail.setFrom("rglgonzalezsanchez@gmail.com");
		crearEmail.setTo(to);
		crearEmail.setSubject(subject);
		crearEmail.setText(body);

		libParaCorreo.send(crearEmail);
	}

	public void fileEmail(String to, String subject, String body, String path) {
		MimeMessage mensajeArchivo = libParaCorreo.createMimeMessage();
		try{
			MimeMessageHelper ayudaEmail = new MimeMessageHelper(mensajeArchivo, true, "UTF-8");

			ayudaEmail.setFrom("rglgonzalezsanchez@gmail.com");
			ayudaEmail.setTo(to);
			ayudaEmail.addAttachment("prueba.jpg", new File(path));
			ayudaEmail.setSubject(subject);
			ayudaEmail.setSentDate(new Date());
			ayudaEmail.setText(body, true);
			//System.out.println("Entro");
			libParaCorreo.send(mensajeArchivo);
		} catch(Exception e) {

		}

	}
}
