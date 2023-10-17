package com.lcwa.Emailsender;

import java.io.File;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class GEmailSender {
	public boolean sendEmail(String to, String from, String subject, String text) {
        boolean flag = false;

        //logic
        //smtp properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.host", "smtp.gmail.com");

        final String username = "ajaypatil01007";
        final String password = "gsutmwuucmqbrypp";
        
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setFrom(new InternetAddress(from));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }
	
	public boolean imageSender(String to,String from,String subject,String text,File file) {
		boolean flag=false;
		
		Properties properties=new Properties();
		 properties.put("mail.smtp.auth", true);
	     properties.put("mail.smtp.starttls.enable", true);
	     properties.put("mail.smtp.port", "587");
	     properties.put("mail.smtp.host", "smtp.gmail.com");
	     

	        final String username = "ajaypatil01007";
	        final String password = "gsutmwuucmqbrypp";
	        
	        Session session=Session.getInstance(properties, new Authenticator() {

				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					// TODO Auto-generated method stub
					return new PasswordAuthentication(username, password);
				}       
	        });
	        try {
	        Message message=new MimeMessage(session);
	        message.setFrom(new InternetAddress(from));
	        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
	      
	        message.setSubject(subject);
	        MimeBodyPart m1=new MimeBodyPart();
	        m1.setText(text);
	        MimeBodyPart m2=new MimeBodyPart();
	        m2.attachFile(file);
	        MimeMultipart mimeMultipart=new MimeMultipart();
	        mimeMultipart.addBodyPart(m1);
	        mimeMultipart.addBodyPart(m2);
	        message.setContent(mimeMultipart);
	        
	        Transport.send(message);
	        flag=true;
	        }catch (Exception e) {
				// TODO: handle exception
	        	e.printStackTrace();
			}
	     
		return flag;
	}
	

}
