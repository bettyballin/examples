import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;

@Named
@SessionScoped
public class MyBean implements Serializable {

    @Inject
    private AuthenticationPropagator auth;

    public void login() {
        // Perform programmatic login using EJB interceptor
        try {
            auth.authenticate(null);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

}

// Dummy AuthenticationPropagator class for demonstration purposes
@javax.enterprise.context.Dependent
public class AuthenticationPropagator {
    public void authenticate(Object credentials) throws Exception {
        // Authentication logic
        System.out.println("Authentication successful");
    }
}