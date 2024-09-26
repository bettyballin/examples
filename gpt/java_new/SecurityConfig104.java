import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig104urerAdapter;
import org.springframework.security.web.authentication.session.SessionFixationConfigurer;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@EnableWebSecurity
public class SecurityConfig104 extends WebSecurityConfig104urerAdapter {

   @Override
   protected void configure(HttpSecurity http) throws Exception {
       http
           .sessionManagement()
               .invalidSessionUrl("/login?invalid-session=true")
               .maximumSessions(1)
               .maxSessionsPreventsLogin(true)
               .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
               .sessionFixation()
               .none()
               .and()
           .and()
           .authorizeRequests()
           .anyRequest().authenticated();
       // ... other configurations can be added here
   }

   // Other configuration methods can be added here
}

public class ReAuthenticationFilter extends OncePerRequestFilter {

   private static final long MAX_INACTIVE_SESSION_TIME = 15 * 60 * 1000; // 15 minutes in milliseconds

   @Override
   protected void doFilterInternal(HttpServletRequest request,
                                   HttpServletResponse response,
                                   FilterChain filterChain) throws ServletException, IOException {
       // Implement the internal filter logic here
       filterChain.doFilter(request, response);
   }

   // Other methods can be added here
}