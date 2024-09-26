import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp2157 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Entry point for the application
        System.out.println("Security configuration loaded.");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                // First allow ADMIN_STAFF and ADMIN_MANAGER to access /admin/**
                .antMatchers("/home").hasRole("USER")
                .antMatchers("/edit-information/**").hasRole("USER")
                // Then restrict "/admin/employee" only for users with the role "ADMIN_MANAGER".
                .antMatchers("/admin/employee").hasRole("ADMIN_MANAGER")
                // Finally allow ADMIN_STAFF and ADMIN_MANAGER to access other /admin/** paths.
                .antMatchers("/admin/**").hasAnyRole("ADMIN_STAFF", "ADMIN_MANAGER");
        
        // Additional configuration can be added here
    }
}