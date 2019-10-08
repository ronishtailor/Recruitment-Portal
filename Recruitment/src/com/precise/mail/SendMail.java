
package com.precise.mail;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
@Component
public class SendMail {

	private static Logger logger = Logger.getLogger(SendMail.class);

	Message msg;
	private Session session;
	String Subject = "";
	Properties p = new Properties();
	final String fromMail = "xyzjava1999";
	final String password = "rovish1999";

	public SendMail() {
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.port", "25");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.EnableSSL.enable", "true");
		p.setProperty("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		p.setProperty("mail.smtp.socketFactory.fallback", "false");
		p.setProperty("mail.smtp.port", "465");
		p.setProperty("mail.smtp.socketFactory.port", "465");
	}


	public String sendMail(String body, String email, String subject) {
		
	     Subject = subject;
		String msgsent = "";
		session = Session.getInstance(p, new SimpleMailAuthenticator(fromMail, password));
		try {
			msg = new MimeMessage(session);
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			msg.setSubject(Subject);
			msg.setFrom(new InternetAddress(fromMail));
			msg.setContent(body, "text/html");
			Transport.send(msg);
			msgsent = "Message Sent";
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("msgsent::" + msgsent);
		return msgsent;

	}
	
}
