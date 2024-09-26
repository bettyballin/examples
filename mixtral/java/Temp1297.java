import java.io.IOException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

public class Temp1297 {
    
    private String userId;
    private String password;

    public static void main(String[] args) {
        // Sample call to the login method, if needed
        Temp1297 temp = new Temp1297();
        temp.userId = "sampleUser";
        temp.password = "samplePass";
        try {
            temp.login(null); // ActionEvent is not used in this example
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void login(ActionEvent e) throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();

        String url = "/spring-authentication/login";

        if (externalContext != null && externalContext.isResponseCommitted())
            return;

        try {
            externalContext.redirect(url + "?username=" + userId + "&password=" + password);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}