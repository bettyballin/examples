import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;

public class Temp618 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        System.out.println("Spring Security Configuration");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                // A. Only authorized clients
                .antMatchers("/type-a").access("#oauth2.hasScope('READ_SOMETHING')")
                
                // B. Both authorized clients and users
                .antMatchers("/type-b").access("@customExpressionMethods.hasScopeOrUserRole('READ_SOMETHING_ELSE', 'ROLE_USER')")
                
                // C. Everything else is for authenticated users
                .anyRequest().authenticated()
                .and().httpBasic();
    }
}