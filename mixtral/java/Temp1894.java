import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1894 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // This is where you would normally start your Spring application
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                // Allow all requests for images and static resources
                .antMatchers("/styles.css", "/css/**", "/js/**", "/fonts/**", "/images/**").permitAll()
                
                // Permit access to home index pages without authentication
                .antMatchers("/home", "/index").permitAll()
                
                // Require USER role for all other requests
                .anyRequest().hasRole("USER")
            .and()
            // Configure login and logout (You should replace '....' with actual configurations)
            .formLogin()
                .loginPage("/login")
                .permitAll()
            .and()
            .logout()
                .permitAll();
    }
}