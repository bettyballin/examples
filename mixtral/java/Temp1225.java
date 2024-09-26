import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1225 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        System.out.println("Application started.");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // @formatter:off
        web
            .ignoring()
            .antMatchers("/v1.0/**", "/oauth/authorize")
            .and()
            .debug(true);

        WebSecurityConfigurerAdapter actuatorWebSecurity = new WebSecurityConfigurerAdapter() {
            @Override
            protected void configure(HttpSecurity http) throws Exception {
                // @formatter:off
                http
                    .antMatcher("/actuator/**")
                    .authorizeRequests().anyRequest().hasAuthority("R_0");
                // @formatter:on
            }
        };

        actuatorWebSecurity.configure(web);
    }
}