import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class Temp429 {
    public static void main(String[] args) {
        SavedRequestAwareAuthenticationSuccessHandler handler = new SavedRequestAwareAuthenticationSuccessHandler();
        System.out.println("Handler created: " + handler.toString());
    }
}