import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Bean;

public class Temp1453 {

    public static void main(String[] args) {
        Temp1453 temp = new Temp1453();
        temp.adminOnlyMethod();
        temp.doSomething("user");
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void adminOnlyMethod() {
        System.out.println("Admin only method executed");
    }

    // Or with multiple roles
    @PreAuthorize("#username == authentication.name and hasAnyRole('ROLE1', 'ROLE2')")
    void doSomething(String username) {
        System.out.println("Do something method executed for user: " + username);
    }

    @EnableWebSecurity
    public static class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        @Bean
        @Override
        protected InMemoryUserDetailsManager configure(AuthenticationManagerBuilder auth) throws Exception {
            UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();

            UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("password")
                .roles("ADMIN")
                .build();

            return new InMemoryUserDetailsManager(user, admin);
        }
    }
}