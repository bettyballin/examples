import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;

@SpringBootApplication
public class Temp2407 {

    public static void main(String[] args) {
        SpringApplication.run(Temp2407.class, args);
    }

    @Bean
    public AuthenticationEntryPoint consoleAuthenticationEntryPoint() {
        return new Http403ForbiddenEntryPoint();
    }

    @EnableWebSecurity
    public static class SecurityConfig extends WebSecurityConfigurerAdapter {

        private final AuthenticationEntryPoint consoleAuthenticationEntryPoint;

        public SecurityConfig(AuthenticationEntryPoint consoleAuthenticationEntryPoint) {
            this.consoleAuthenticationEntryPoint = consoleAuthenticationEntryPoint;
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .antMatcher("/console/**")
                .httpBasic().and()
                .exceptionHandling().authenticationEntryPoint(consoleAuthenticationEntryPoint).and()
                .authorizeRequests().antMatchers("/console/**").authenticated()
                .antMatchers(HttpMethod.GET,
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js").permitAll()
                .anyRequest().authenticated().and()
                .formLogin().defaultSuccessUrl("/console/home")
                .loginPage("/console/login").permitAll().and()
                .logout().permitAll().and()
                .csrf().disable();
        }
    }
}