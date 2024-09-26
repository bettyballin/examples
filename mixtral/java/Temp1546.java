import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

public class Temp1546 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // This is just to avoid compilation errors, main method in Spring Security configuration class is not typical
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .logout()
                .addLogoutHandler((request, response, authentication) -> {})
                .logoutSuccessHandler(new CustomLogoutSuccessHandler());
    }

    private static class CustomLogoutSuccessHandler implements LogoutSuccessHandler {
        @Override
        public void onLogoutSuccess(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, org.springframework.security.core.Authentication authentication) throws java.io.IOException, javax.servlet.ServletException {
            // Custom logic for logout success
        }
    }
}