import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@SpringBootApplication
public class Temp1357Application extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(Temp1357Application.class, args);
    }

    @Bean
    public AuthenticationFailureHandler eventAuthenticationFailureHandler() {
        return new EventSendingAuthenticationFailureHandler();
    }

    @Autowired
    private AuthenticationFailureHandler eventAuthenticationFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .formLogin().failureHandler(eventAuthenticationFailureHandler)
                .and()
            .httpBasic();
    }
}

class EventSendingAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(javax.servlet.http.HttpServletRequest request,
                                        javax.servlet.http.HttpServletResponse response,
                                        org.springframework.security.core.AuthenticationException exception) 
                                        throws java.io.IOException, javax.servlet.ServletException {
        // Custom failure handling logic here
    }
}