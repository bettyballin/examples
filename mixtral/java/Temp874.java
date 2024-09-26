import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Temp874 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        // Main method implementation
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // Your other configurations
            .and()
            .oauth2Login().successHandler(new CustomAuthenticationSuccessHandler());
        // Your other configurations
    }

    public static class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
        @Override
        protected String determineTargetUrl(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {
            String targetUrl = super.determineTargetUrl(request, response);
            return URLEncoder.encode(targetUrl, StandardCharsets.UTF_8);
        }
    }
}