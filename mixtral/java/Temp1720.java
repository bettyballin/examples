import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1720 extends WebSecurityConfigurerAdapter {
    
    private final LogoutSuccessHandler logoutSuccessHandler;
    private final LogoutHandler handler1;
    private final LogoutHandler handler2;

    public Temp1720(LogoutSuccessHandler logoutSuccessHandler, LogoutHandler handler1, LogoutHandler handler2) {
        this.logoutSuccessHandler = logoutSuccessHandler;
        this.handler1 = handler1;
        this.handler2 = handler2;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout.html"))
                .logoutSuccessHandler(logoutSuccessHandler)
                .addLogoutHandler(handler1)
                .addLogoutHandler(handler2)
                .permitAll();
    }

    public static void main(String[] args) {
        // Normally you would run this as a Spring Boot application
        // SpringApplication.run(Temp1720.class, args);
    }
}