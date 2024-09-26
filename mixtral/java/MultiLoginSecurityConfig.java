import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class MultiLoginSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LDAPAuthProvider ldapAuthProvider;

    @Autowired
    private DatabaseAuthProvider databaseAuthProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter authFilter = new CustomAuthenticationFilter();

        // Set the providers for each user type
        ldapAuthProvider.setUserType("employee");
        databaseAuthProvider.setUserType("customer");

        authFilter.setAuthenticationManager(authentication -> {
            String userType = ((CustomAuthRequest) authentication).getUserType();
            if ("employee".equals(userType)) {
                return ldapAuthProvider.authenticate(authentication);
            } else {
                return databaseAuthProvider.authenticate(authentication);
            }
        });

        http.addFilterAt(authFilter, UsernamePasswordAuthenticationFilter.class)
            .authorizeRequests()
            // Add your authorization rules here
            .anyRequest().authenticated();
    }
}