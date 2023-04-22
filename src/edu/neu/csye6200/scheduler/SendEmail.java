package edu.neu.csye6200.scheduler;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * @author eraricamehra
 *
 */
public class SendEmail {

	Session session = null;
	MimeMessage mimeMessage = null;

	public void send(List<String> emailIds) {
		setupServer();
		createEmail(emailIds);
		String from = "******@gmail.com";
		String password = "******";
		String host = "smtp.gmail.com";
		try {
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, password);
			transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
			transport.close();
			System.out.println("Success");
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	public void setupServer() {
		Properties properties = System.getProperties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		session = Session.getDefaultInstance(properties);
	}

	public MimeMessage createEmail(List<String> emailIds) {
		String subject = "Reminder: Daycare";
		String body = "Dear Parent/Gaurdian, \n Your ward is due for their annual registration renewal. \n Sincerely, \n Daycare ";

		try {
			mimeMessage = new MimeMessage(session);
			for (String e : emailIds)
				mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(e));
			mimeMessage.setSubject(subject);
			mimeMessage.setText(body);
			return mimeMessage;
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return mimeMessage;

	}

}
