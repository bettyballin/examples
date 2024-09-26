import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Temp3039 {
    public static void main(String[] args) {
        Temp3039 temp = new Temp3039();
        AuthenticationSuccessHandler handler = temp.mySuccessHandler();
        System.out.println("Handler created: " + handler.getClass().getName());
    }

    @Bean
    public AuthenticationSuccessHandler mySuccessHandler() {
        return new MyCustomAuthenticationSuccessHandler();
    }

    class MyCustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
        @Override
        public void onAuthenticationSuccess(javax.servlet.http.HttpServletRequest request,
                                            javax.servlet.http.HttpServletResponse response,
                                            org.springframework.security.core.Authentication authentication)
                throws java.io.IOException, javax.servlet.ServletException {
            // Custom success handling logic
        }
    }
}