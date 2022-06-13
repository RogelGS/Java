package com.mx.mailtest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfiguration {
    /*@Bean
    public JavaMailSender sender() {
        JavaMailSenderImpl jmsi = new JavaMailSenderImpl();
        jmsi.setHost("smtp.gmail.com");
        jmsi.setPort(587);

        jmsi.setUsername("rglgonzalezsanchez@gmail.com");
        jmsi.setPassword("12345rogelio");

        Properties props = jmsi.getJavaMailProperties();
        props.put("mail.transportprotocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return jmsi;
    }*/
}
