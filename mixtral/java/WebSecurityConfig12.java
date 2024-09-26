import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // ...

        http.formLogin()
            .failureHandler(customAuthFailureHandler());

        // ...

    }

    private AuthenticationFailureHandler customAuthFailureHandler(){
      CustomAuthenticationFailureHandler handler = new CustomAuthenticationFailureHandler();

      return handler;
  }
}

class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        // Custom logic for handling authentication failure
    }
}