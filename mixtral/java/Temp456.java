import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

public class Temp456 {

    private Session session;

    public static void main(String[] args) {
        Temp456 temp = new Temp456();
        temp.getSession();
    }

    private void getSession() {
        Properties properties = new Properties();

        // Set other mail server settings here

        String emailPassword = System.getenv("EMAIL_PASSWORD");

        this.session = Session.getDefaultInstance(properties,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("xxx@outlook.com", emailPassword);
                }
            });
    }
}