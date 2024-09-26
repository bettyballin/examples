import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

public class Temp2548 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Entry point for the Java application if needed
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        RequestMatcher csrfRequestMatcher = new RequestMatcher() {
            @Override
            public boolean matches(HttpServletRequest request) {
                return !request.getMethod().equalsIgnoreCase("POST") ||
                        (request.getContentType() != null &&
                                request.getContentType().contains("application/json"));
            }
        };

        http
            .csrf(c -> c
                .requireCsrfProtectionMatcher(csrfRequestMatcher)
                .ignoringAntMatchers("/api/**")
            );
    }
}