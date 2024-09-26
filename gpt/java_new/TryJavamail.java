import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class TryJavamail {
    public static void main(String[] args) {
        // Assuming setup code is correct and defines props
        Properties props = new Properties();
        props.put("mail.smtp.auth.mechanisms", "XOAUTH2");
        // ... (additional setup code)

        // Get an OAuth2 access token
        String accessToken = ""; // Replace with actual access token

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("", accessToken);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@example.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("to@example.com"));
            message.setSubject("Subject");
            message.setText("Body");

            Transport.send(message);
            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}