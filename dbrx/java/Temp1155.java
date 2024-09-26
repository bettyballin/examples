import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@EnableWebSecurity
public class Temp1155 extends WebSecurityConfigurerAdapter {

    private final AuthenticationSuccessHandler customAuthSuccessHandler;

    public Temp1155(AuthenticationSuccessHandler customAuthSuccessHandler) {
        this.customAuthSuccessHandler = customAuthSuccessHandler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.oauth2Login()
            .successHandler(customAuthSuccessHandler);
    }

    public static void main(String[] args) {
        // Application entry point
    }
}