package com.zidio_connection.Service;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.zidio_connection.DTO.EmailRequestDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailService {

	public void sendEmailWithAttachmentFile(EmailRequestDTO dto, File attachment) throws IOException {

		final String fromEmail = "your-email@gmail.com";
		final String password = "your-password";

		Properties props = new Properties();

		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getInstance(props, new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		});

		try {
			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(fromEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(dto.getTo()));
			message.setSubject(dto.getSubject());

			MimeBodyPart mesageBodyPart = new MimeBodyPart();
			mesageBodyPart.setText(dto.getBody());

			MimeBodyPart attachmentPart = new MimeBodyPart();
			attachmentPart.attachFile(attachment);

			MimeMultipart multipart = new MimeMultipart();
			multipart.addBodyPart(attachmentPart);
			multipart.addBodyPart(mesageBodyPart);

			message.setContent(multipart);
			Transport.send(message);
			System.out.println("Invoice sent to" + dto.getTo());

		} catch (MessagingException e) {
			throw new RuntimeException("Failed to send Email");
		}
	}

	@Autowired
	private JavaMailSender mailSender;

	public void sendEmail(EmailRequestDTO dto) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(dto.getTo());
		message.setSubject(dto.getSubject());
		message.setText(dto.getBody());
		mailSender.send(message);
	}
}
