import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

public class Temp2980 {
    public static void main(String[] args) {
        Temp2980 temp = new Temp2980();
        try {
            AuthenticationManager manager = temp.authenticationManagerBean();
            System.out.println("Authentication Manager: " + manager);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        AuthenticationConfiguration configuration = new AuthenticationConfiguration();
        return configuration.getAuthenticationManager();
    }
}