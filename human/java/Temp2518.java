import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@SpringBootApplication
public class Temp2518Application {

    public static void main(String[] args) {
        SpringApplication.run(Temp2518Application.class, args);
    }

    @Bean
    public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
        return new WebSecurityConfigurerAdapter() {
            @Override
            protected void configure(HttpSecurity http) throws Exception {
                http.csrf().disable()
                    .httpBasic().and()
                    .authorizeRequests()
                        .antMatchers("/admin/**").hasAuthority("ADMIN")
                        .antMatchers("/**").permitAll()
                        .anyRequest().authenticated()
                        .and()
                    .formLogin()
                        .loginPage("/adminLogin").failureUrl("/adminLogin?error=true")
                        .defaultSuccessUrl("/admin/dashboard")
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .and().logout()
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/adminLogin?logout=true")
                        .and().exceptionHandling()
                        .accessDeniedPage("/accessdenied");
            }
        };
    }
}