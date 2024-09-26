import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

public class Temp2790 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable() // Using JWT there is no need for CSRF-protection!
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().accessDeniedHandler(new AccessDeniedExceptionHandler())
                .and()
                .addFilter(new JwtAuthorizationFilter(authenticationManagerBean()));
    }

    private static class AccessDeniedExceptionHandler implements AccessDeniedHandler {
        @Override
        public void handle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, org.springframework.security.access.AccessDeniedException accessDeniedException) throws java.io.IOException, javax.servlet.ServletException {
            response.sendError(javax.servlet.http.HttpServletResponse.SC_FORBIDDEN, accessDeniedException.getMessage());
        }
    }

    private static class JwtAuthorizationFilter extends org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter {
        public JwtAuthorizationFilter(org.springframework.security.authentication.AuthenticationManager authenticationManager) {
            super.setAuthenticationManager(authenticationManager);
        }

        @Override
        protected boolean requiresAuthentication(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {
            return true;
        }

        @Override
        public org.springframework.security.core.Authentication attemptAuthentication(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {
            return null;
        }
    }

    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(Temp2790.class, args);
    }
}