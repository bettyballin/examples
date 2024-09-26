import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.logging.Logger;

public class Temp1502 {
    private static final Logger log = Logger.getLogger(Temp1502.class.getName());
    private String username = "testUser"; // Example username
    private String password = "testPass"; // Example password
    private String originalURL = "http://example.com"; // Example URL

    public static void main(String[] args) {
        Temp1502 temp1502 = new Temp1502();
        temp1502.login();
    }

    public void login() {
        log.info("Login attempt");

        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();

        try {
            request.login(username, password);
            log.info("Login successful");
            externalContext.redirect(originalURL);
        } catch (ServletException e) {
            // Handle unknown username/password in request.login().
            context.addMessage(null, new FacesMessage("Unknown login"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}