import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
import org.springframework.security.web.util.matcher.RequestHeaderRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
public class SecurityConfig {

    @Configuration
    public static class ApiBasicAuth extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            RequestMatcher requestMatcher = new RequestHeaderRequestMatcher("Authorization");

            http.requestMatcher(requestMatcher).authorizeRequests()
                .antMatchers("/api/**").authenticated()
                .and()
                .httpBasic(); // Basic auth configuration
        }
    }

    @Configuration
    public static class ApiSSOAuth extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {

            RequestMatcher requestMatcher = new NegatedRequestMatcher(new RequestHeaderRequestMatcher("Authorization"));

            http.requestMatcher(requestMatcher).authorizeRequests()
                .antMatchers("/api/**").authenticated()
                .and()
                .oauth2Login(); // SSO auth configuration
        }
    }
}