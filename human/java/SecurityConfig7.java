import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.rememberme.RememberMeAuthenticationProvider;
import org.springframework.security.authentication.rememberme.RememberMeAuthenticationFilter;
import org.springframework.security.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        AuthenticationProvider rememberMeAuthenticationProvider = rememberMeAuthenticationProvider();
        TokenBasedRememberMeServices tokenBasedRememberMeServices = tokenBasedRememberMeServices();

        List<AuthenticationProvider> authenticationProviders = new ArrayList<>(2);
        authenticationProviders.add(rememberMeAuthenticationProvider);
        authenticationProviders.add(customAuthenticationProvider);
        AuthenticationManager authenticationManager = authenticationManager(authenticationProviders);

        http
                .csrf().disable()
                .headers().disable()
                .addFilter(new RememberMeAuthenticationFilter(authenticationManager, tokenBasedRememberMeServices))
                .rememberMe().rememberMeServices(tokenBasedRememberMeServices)
                .and()
                .authorizeRequests()
                .antMatchers("/js/**", "/css/**", "/img/**", "/login", "/processLogin").permitAll()
                .antMatchers("/index.jsp", "/index.html", "/index").hasRole("USER")
                .antMatchers("/admin", "/admin.html", "/admin.jsp", "/js/saic/jswe/admin/**").hasRole("ADMIN")
                .and()
                .formLogin().loginProcessingUrl("/processLogin").loginPage("/login").usernameParameter("username").passwordParameter("password").permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/login")
                .and()
                .logout().permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**", "/css/**", "/img/**");
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(List<AuthenticationProvider> authenticationProviders) {
        return new ProviderManager(authenticationProviders);
    }

    @Bean
    public TokenBasedRememberMeServices tokenBasedRememberMeServices() {
        return new TokenBasedRememberMeServices("testKey", userDetailsService);
    }

    @Bean
    public AuthenticationProvider rememberMeAuthenticationProvider() {
        return new RememberMeAuthenticationProvider("testKey");
    }

    protected void registerAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
}

class CustomUserDetailsService implements UserDetailsService {
    // Implementation details
}

class CustomAuthenticationProvider implements AuthenticationProvider {
    // Implementation details
}