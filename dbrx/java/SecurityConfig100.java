import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.util.StringUtils;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatcher(new RequestHeaderRequestMatcher("ppauth"))
            .authorizeRequests()
                // your SSO configuration here
                .anyRequest().authenticated(); // example: require authentication for any request

        http.requestMatcher(new AnyRequestMatcher())
            .authorizeRequests()
                // basic auth config here
                .anyRequest().authenticated(); // example: require authentication for any request
    }
}

class RequestHeaderRequestMatcher implements RequestMatcher {

    private final String headerName;

    public RequestHeaderRequestMatcher(String headerName) {
        this.headerName = headerName;
    }

    @Override
    public boolean matches(HttpServletRequest request) {
        return StringUtils.hasText(request.getHeader(headerName));
    } 
}

class AnyRequestMatcher implements RequestMatcher {
    public static final AnyRequestMatcher INSTANCE = new AnyRequestMatcher();

    private AnyRequestMatcher() {}

    @Override
    public boolean matches(HttpServletRequest request) {
        return true;
    }
}