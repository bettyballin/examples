import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class SecurityConfig124 {
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/admin/employee").hasRole("ADMIN_MANAGER")
            .antMatchers("/admin/**").hasAnyRole("ADMIN_STAFF","ADMIN_MANAGER");
            // ... other configurations
    }
}