import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .logout()
                .clearAuthentication(true)
                .invalidateHttpSession(false)
                .addLogoutHandler((request, response, authentication) ->
                    request.getSession().invalidate())
                .logoutSuccessHandler(new CustomLogoutSuccessHandler());
    }

    private static class CustomLogoutSuccessHandler implements org.springframework.security.web.authentication.logout.LogoutSuccessHandler {
        @Override
        public void onLogoutSuccess(javax.servlet.http.HttpServletRequest request,
                                    javax.servlet.http.HttpServletResponse response,
                                    org.springframework.security.core.Authentication authentication)
                throws java.io.IOException, javax.servlet.ServletException {
            response.setStatus(javax.servlet.http.HttpServletResponse.SC_OK);
            response.getWriter().flush();
        }
    }
}