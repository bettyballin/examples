import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;

public class Temp1618 {
    public static void main(String[] args) {
        Temp1618 temp = new Temp1618();
        AuthenticationSuccessHandler handler = temp.successHandler();
        // You can test the handler here
    }

    @Bean
    public AuthenticationSuccessHandler successHandler() {
        SavedRequestAwareAuthenticationSuccessHandler handler = new SavedRequestAwareAuthenticationSuccessHandler();
        // You can set additional properties here if needed

        return handler;
    }
}