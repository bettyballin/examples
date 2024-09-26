import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp2327 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Application entry point, this can be used to run the Spring application
        // Typically, you would use SpringApplication.run(Temp2327.class, args) for SpringBoot applications
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/script/**", "/css/**", "/getRegisterPage", "/user/signup").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/getLoginPage")
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/home", true)
                .permitAll();
    }
}