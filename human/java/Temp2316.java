import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp2316 extends WebSecurityConfigurerAdapter {
    
    public static void main(String[] args) {
        System.out.println("Security configuration executed");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .antMatcher("/admin/**")
            .authorizeRequests()
            .anyRequest().authenticated()
            .anyRequest().hasRole("ADMIN")
            .and()
            .formLogin()
            .loginPage("/adminLogin")
            .loginProcessingUrl("/admin/postLogin")
            .defaultSuccessUrl("/admin/home")
            .failureUrl("/adminLogin?error")
            .and()
            .logout()
            .logoutUrl("/admin/logout")
            .logoutSuccessUrl("/home")
            .and()
            .csrf().disable();
    }
}