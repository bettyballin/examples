import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class Temp309 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        System.out.println("CONFIGURED");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .requiresChannel()
                .anyRequest().requiresSecure();

        http
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .requiresClientCertificate()
                .forAllExchangeMatchers(new AntPathRequestMatcher("/api/**"));
    }
}