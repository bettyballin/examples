import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import java.util.Arrays;
import java.util.List;

@Configuration
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Bean
    public CustomFilter tokenAuthFilter() throws Exception {
        List<String> pathsToSkip = Arrays.asList("/admin/login");

        final CustomFilter customFilter = new CustomFilter(pathsToSkip);

        customFilter.setAuthenticationManager(authentication -> {
            String username = authentication.getName();

            if (username != null) {
                return new PreAuthenticatedAuthenticationToken(
                        userDetailsService.loadUserByUsername(username),
                        null,
                        userDetailsService.loadUserByUsername(username).getAuthorities()
                );
            }
            return null;
        });

        return customFilter;
    }

    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilter(tokenAuthFilter())
            .authorizeRequests()
            .antMatchers("/admin/login").permitAll()
            .anyRequest().authenticated();
    }
}



import org.springframework.security.core.userdetails.UserDetailsService;

public class CustomUserDetailService implements UserDetailsService {
    @Override
    public CustomUserDetails loadUserByUsername(String username) {
        // Your custom logic to load user by username
    }
}



import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CustomFilter extends AbstractPreAuthenticatedProcessingFilter {

    private final List<String> pathsToSkip;

    public CustomFilter(List<String> pathsToSkip) {
        this.pathsToSkip = pathsToSkip;
    }

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        if (pathsToSkip.contains(requestURI)) {
            return null;
        }
        // Your custom logic to extract token or principal
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        // Your custom logic to extract credentials
    }
}