import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp2094 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        System.out.println("Temp2094 application started.");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .requestCache().requestCache(new CustomRequestCache())
            .and()
            .anonymous()
            .and()
            .authorizeRequests()
            .anyRequest().hasAnyAuthority(Role.getAllRoles());
    }

    // Placeholder for the Role class
    static class Role {
        static String[] getAllRoles() {
            return new String[] {"ROLE_USER", "ROLE_ADMIN"};
        }
    }

    // Placeholder for the CustomRequestCache class
    static class CustomRequestCache extends org.springframework.security.web.savedrequest.HttpSessionRequestCache {
        // Custom implementation if needed
    }
}