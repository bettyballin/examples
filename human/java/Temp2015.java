import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Temp2015 {
    public static void main(String[] args) {
        // For demonstration purpose, main method is not needed for Spring Beans
        Temp2015 temp = new Temp2015();
        AuthenticationFailureHandler handler = temp.getFailureHandler();
        System.out.println("Default Failure URL: " + ((SimpleUrlAuthenticationFailureHandler) handler).getDefaultFailureUrl());
    }

    @Bean
    public AuthenticationFailureHandler getFailureHandler() {
        SimpleUrlAuthenticationFailureHandler handler = new SimpleUrlAuthenticationFailureHandler();
        handler.setDefaultFailureUrl("/login.html");
        return handler;
    }
}