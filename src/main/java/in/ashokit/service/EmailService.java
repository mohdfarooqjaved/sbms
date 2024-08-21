package in.ashokit.service;


import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;
	
	public void sendEmail(String subject,String body,String to)
	{
		try {
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setSubject(subject);
		msg.setText(body);
		msg.setTo(to);
		mailSender.send(msg);
		}
		catch(Exception e) {}
	}
	
	public void sendEmail1(String subject,String body,String to)
	{
		try {
			MimeMessage minemessage=mailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(minemessage,true);
			helper.setSubject(subject);
			helper.setText(body,true); //indicate that vody contain some html tag 
			helper.setTo(to);
			helper.setBcc("javed.farooq786@gmail.com");
			helper.setCc("javed.farooq786@gmail.com");
			helper.addAttachment("Report",new File("D:\\saba Document\\saba_Aadhar.pdf"));
			mailSender.send(minemessage);
		}
		catch(Exception e) {}
	}
	
}
