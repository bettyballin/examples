import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class Temp1705 extends WebSecurityConfigurerAdapter {

    private AuthenticationSuccessHandler robotLoginSuccessHandler;
    private LogoutHandler robotLogoutSuccessHandler;

    public Temp1705(AuthenticationSuccessHandler loginSuccessHandler, LogoutHandler logoutSuccessHandler) {
        this.robotLoginSuccessHandler = loginSuccessHandler;
        this.robotLogoutSuccessHandler = logoutSuccessHandler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/", "/home").access("hasRole('USER')")
                .antMatchers("/admin/**").access("hasRole('ADMIN')")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .successHandler(robotLoginSuccessHandler)
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
                .and()
            .exceptionHandling()
                .accessDeniedPage("/Access_Denied")
                .and()
            .logout()
                .logoutUrl("/login?logout")
                .addLogoutHandler(robotLogoutSuccessHandler)
                .permitAll();
    }

    public static void main(String[] args) {
        // Application entry point
    }
}