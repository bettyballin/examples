import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {

        CustomOAuth2LogoutSuccessHandler customOAuth2LogoutSuccessHandler = new CustomOAuth2LogoutSuccessHandler();

        http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/Intranet/Booking").authenticated()
            .antMatchers("/**", "/Intranet/**").permitAll()
            .anyRequest().authenticated()
            .and().logout().logoutSuccessUrl("/")
            .addLogoutHandler(customOAuth2LogoutSuccessHandler)
            .and()
            .oauth2Login();
    }
}

class CustomOAuth2LogoutSuccessHandler implements LogoutHandler {
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        // Custom logout handling logic
    }
}