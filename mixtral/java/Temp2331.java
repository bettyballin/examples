import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.http.HttpMethod;

public class Temp2331 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Application entry point
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                // Allow access to "/validate" without any role
                .antMatchers("/validate").permitAll()

                // Require USER or ADMIN roles for these endpoints
                .antMatchers(HttpMethod.POST, "/Registration", "/Confirmation")
                    .hasAnyRole("USER", "ADMIN")

                // Allow access to the root URL without any role
                .mvcMatchers("/").permitAll()

                // Require ADMIN role for all other requests
                .anyRequest().hasRole("ADMIN")
            .and()
            .formLogin()
                // Set the login page URL
                .loginPage("/login")

                // Redirect to "/validate" after successful authentication
                .defaultSuccessUrl("/validate", true)

                // Allow access without any role
                .permitAll()
            .and()
            .sessionManagement()
                // Set the invalid session URL
                .invalidSessionUrl("/login")
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
    }
}