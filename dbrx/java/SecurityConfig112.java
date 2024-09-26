import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatcher(new RequestHeaderRequestMatcher("ppauth"))
            .authorizeRequests()
            .anyRequest().authenticated().and()
            .requestMatcher(AnyRequestMatcher.INSTANCE)
            .authorizeRequests()
            .anyRequest().authenticated();
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

    private AnyRequestMatcher() {
    }

    @Override
    public boolean matches(HttpServletRequest request) {
        return true;
    }
}