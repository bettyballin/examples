import org.springframework.context.annotation.Bean;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

public class SecurityConfig162 {

    @Bean
    public LoginUrlAuthenticationEntryPoint loginUrlAuthenticationEntryPoint(){
        return new LoginUrlAuthenticationEntryPoint("/login");
    }
}