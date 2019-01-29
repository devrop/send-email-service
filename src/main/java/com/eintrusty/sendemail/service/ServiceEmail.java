package com.eintrusty.sendemail.service;

import java.util.Date;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eintrusty.sendemail.entity.ConfigEntity;
import com.eintrusty.sendemail.entity.TrackedEmail;
import com.eintrusty.sendemail.model.TrackedEmailDto;
import com.eintrusty.sendemail.repository.ConfigRepository;
import com.eintrusty.sendemail.repository.TrackedEmailRepository;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

@Service
@Transactional
public class ServiceEmail implements IServiceEmail {
	
	@Autowired
	ConfigRepository config;
	
	@Autowired
	TrackedEmailRepository emailRepo;

	@Override
	public int sendEmail(TrackedEmailDto dto) {
		// TODO Auto-generated method stub
		
		try {
			String emailTo = dto.getTo();  
			String hostEmail = emailTo.substring(emailTo.indexOf("@")+1, emailTo.indexOf("."));
			ConfigEntity configEmail = config.findOneByCondition(hostEmail);
			String[] value = configEmail.getValue().split(":");
			
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", value[0].trim() );
			props.put("mail.smtp.port", value[1].trim());

			Session session = Session.getInstance(props,
			 new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(dto.getUsernameFrom(), dto.getPasswordFrom());
				}
			  });

	
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(dto.getFrom()));
				message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(dto.getTo()));
				message.setSubject("Testing Subject");
				message.setText("Dear you,"
					+ "\n\n Thanks You!"
					+ "\n\n Something like thats");

				Transport.send(message);
				//save to database
				TrackedEmail track = new TrackedEmail();
				track.setTo(dto.getTo());
				track.setFrom(dto.getFrom());
				track.setCreatedDate(new Date());
				emailRepo.save(track);

				return 0;

		}catch(MessagingException e) {
			System.out.println("Error" + e);
			return 2;
		}
	}
	


}
