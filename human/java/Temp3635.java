import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Temp3635 {
    public static void main(String[] args) {
        Temp3635 temp = new Temp3635();
        LoginUrlAuthenticationEntryPoint entryPoint = temp.instance();
        System.out.println("Login URL: " + entryPoint.getLoginFormUrl());
    }

    @Bean
    public LoginUrlAuthenticationEntryPoint instance() {
        return new LoginUrlAuthenticationEntryPoint("/login");
    }
}