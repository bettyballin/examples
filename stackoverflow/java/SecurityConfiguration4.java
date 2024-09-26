import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class SecurityConfiguration4 {

    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
                .loginPage("/login").loginProcessingUrl("/login/validate")
                .defaultSuccessUrl("/").failureUrl("/login?error=true")
                .usernameParameter("username").passwordParameter("password")
                .and()
            .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout=true");
    }
}