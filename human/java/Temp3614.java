import javax.faces.context.FacesContext;
import java.io.IOException;

public class Temp3614 {

    private UserAuthService userAuthService = new UserAuthService();

    public static void main(String[] args) {
        Temp3614 temp = new Temp3614();
        temp.logout();
    }

    public void logout() {
        userAuthService.logout();
        try {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml?faces-redirect=true");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class UserAuthService {
    public void logout() {
        // Simulate logout logic
        System.out.println("User logged out.");
    }
}

// Mocking FacesContext class for this example
class FacesContext {

    private static FacesContext instance = new FacesContext();

    public static FacesContext getCurrentInstance() {
        return instance;
    }

    public ExternalContext getExternalContext() {
        return new ExternalContext();
    }

    // Mocking ExternalContext class for this example
    class ExternalContext {
        public void invalidateSession() {
            // Simulate session invalidation
            System.out.println("Session invalidated.");
        }

        public void redirect(String url) throws IOException {
            // Simulate redirection
            System.out.println("Redirecting to " + url);
        }
    }
}