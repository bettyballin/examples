import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp2187 extends WebSecurityConfigurerAdapter {
    private static final String REQUEST_MAPPING_AUTHENTICATEUSER = "/authenticateUser";

    public static void main(String[] args) {
        // This main method is just a placeholder.
        // The actual Spring Boot application would be run by the Spring Boot framework.
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(REQUEST_MAPPING_AUTHENTICATEUSER)
            .antMatchers("/heartBeat")
            .antMatchers("/subscribe/**");
    }
}