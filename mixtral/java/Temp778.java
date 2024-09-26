import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Temp778 {
    public static void main(String[] args) {
        String access_token = "your_access_token_here";

        GoogleCredential cred = new GoogleCredential().setAccessToken(access_token);

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(props, null);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@example.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("to@example.com"));
            message.setSubject("subject");
            message.setContent("<html><body>Hello World!</body></html>", "text/html");

            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", "username", "password");

            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}