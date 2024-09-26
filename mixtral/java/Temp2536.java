import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

public class Temp2536 extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf()
            // Use this if you are not submitting forms via AJAX
            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
            
        // Or use this for handling CSRF tokens in ajax requests
        /*
        .csrfTokenRepository(new HttpSessionCsrfTokenRepository() {
            @Override
            public void saveToken(HttpServletRequest request, String token) throws IOException {
                // Save the CSRF Token in a cookie
                final Optional<Cookie> csrfCookie = getCsrfCookie(request);

                if (csrfCookie.isPresent()) {
                    super.saveToken(request, token);
                    request.changeSessionId();
                    // Update the CSRF Token in a cookie
                    csrfCookie.get().setValue(token);
                } else {
                    super.saveToken(request, token);
                }
            }

            private Optional<Cookie> getCsrfCookie(HttpServletRequest request) throws IOException {
                final Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if ("CSRF-TOKEN".equals(cookie.getName())) {
                            return Optional.of(cookie);
                        }
                    }
                }
                return Optional.empty();
            }
        });
        */
    }

    public static void main(String[] args) {
        // Your main method implementation, if needed
    }
}