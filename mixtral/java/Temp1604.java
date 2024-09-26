import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

public class Temp1604 extends WebSecurityConfigurerAdapter {
    private BasicAuthenticationEntryPoint jwtAuthEnticationEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // ...
        http.httpBasic()
            .realmName("Your Realm")
            .authenticationEntryPoint(jwtAuthEnticationEntryPoint)
            .and()
            .formLogin()
            .loginProcessingUrl("/api/v1/login");
        // ...
    }

    public static void main(String[] args) {
        // Application entry point
    }
}