import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class Temp2351 {
    public static void main(String[] args) {
        try {
            InitialContext ctx = new InitialContext();
            Properties secretProps = (Properties) ctx.lookup("java:comp/env/secretProperties");
            String password = secretProps.getProperty("myapp_password");
            System.out.println("Password: " + password);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}