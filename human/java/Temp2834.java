import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestHeaderRequestMatcher;
import org.springframework.security.web.util.matcher.AndRequestMatcher;

public class Temp2834 extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // This matches if the request has X-Operation-Name header and its value is forgot-password
        RequestHeaderRequestMatcher headerMatcher = new RequestHeaderRequestMatcher("X-Operation-Name", "forgot-password");

        // This matches if the request is POST to the /api/website-user
        AntPathRequestMatcher antRequestMatcher = new AntPathRequestMatcher("/api/website-user", HttpMethod.POST.name());

        // This matches if both of the above matches
        AndRequestMatcher andMatcher = new AndRequestMatcher(headerMatcher, antRequestMatcher);

        httpSecurity.authorizeRequests().requestMatchers(andMatcher).permitAll();
    }

    public static void main(String[] args) {
        // Spring Boot application would typically start here, but this is just a configuration class
    }
}