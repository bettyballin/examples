import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

@EnableWebSecurity
public class Temp705 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .headers().addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
            .and()
            .authorizeRequests()
                // Allow OPTIONS requests to be anonymous
                .antMatchers(HttpMethod.OPTIONS, "/**").anonymous()
                // Disable anonymous authentication for all other requests
                .anyRequest().authenticated();
    }

    public static void main(String[] args) {
        // Spring Boot would normally be used to run the application
    }
}