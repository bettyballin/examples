import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1997 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Your main method implementation here, if needed
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String[] publicResources = new String[]{"/public/**", "/resources/**"}; // Define your public resources here

        http
            .csrf().disable()
            .authorizeRequests()
                // Public resources
                .antMatchers(publicResources).permitAll()

                // User access
                .antMatchers("/dashboard/**").hasAnyRole("USER", "DATA", "ADMIN")

                // Data access
                .antMatchers("/data/**").hasAnyRole("DATA", "ADMIN")

                // Admin access
                .antMatchers("/admin/**").hasRole("ADMIN")

            .anyRequest().authenticated();
    }
}