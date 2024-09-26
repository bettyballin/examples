import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1687 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Entry point for the application; Spring Boot applications typically start with SpringApplication.run()
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring()
            .antMatchers("/webjars/**", "/login**");
    }
}