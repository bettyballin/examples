import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final LogoutSuccessHandler logoutSuccessHandler;

    public SecurityConfig(LogoutSuccessHandler logoutSuccessHandler) {
        this.logoutSuccessHandler = logoutSuccessHandler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .logout()
            .logoutSuccessHandler(logoutSuccessHandler)
            .and()
            .apply(new SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {
                @Override
                public void configure(HttpSecurity builder) throws Exception {
                    builder.getSharedObject(DefaultLoginPageGeneratingFilter.class).setLogoutSuccessUrl("/login?logout");
                }
            });
    }
}