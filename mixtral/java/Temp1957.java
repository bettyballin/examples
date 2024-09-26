import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

public class Temp1957 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        System.out.println("Security configuration example");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .logout().addLogoutHandler((request, response, authentication) ->
                SecurityContextHolder.clearContext())
            .logoutSuccessHandler(new CustomLogoutSuccessHandler()).permitAll();
    }

    private static class CustomLogoutSuccessHandler implements LogoutSuccessHandler {
        @Override
        public void onLogoutSuccess(javax.servlet.http.HttpServletRequest request,
                                    javax.servlet.http.HttpServletResponse response, 
                                    org.springframework.security.core.Authentication authentication) 
                                    throws java.io.IOException, javax.servlet.ServletException {
            // Custom logout success logic
            response.getWriter().write("Logout successful!");
        }
    }
}