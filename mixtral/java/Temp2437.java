import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@SpringBootApplication
public class Temp2437Application {

    public static void main(String[] args) {
        SpringApplication.run(Temp2437Application.class, args);
    }

    @Bean
    public CustomAuthFailureHandler authenticationFailureHandler() {
        return new CustomAuthFailureHandler();
    }

    @Bean
    public LogoutSuccessHandler customLogoutSuccessHandler() {
        return new CustomLogoutSuccessHandler();
    }

    @EnableWebSecurity
    public static class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        private final CustomAuthFailureHandler customAuthFailureHandler;
        private final LogoutSuccessHandler customLogoutSuccessHandler;

        public WebSecurityConfig(CustomAuthFailureHandler customAuthFailureHandler, LogoutSuccessHandler customLogoutSuccessHandler) {
            this.customAuthFailureHandler = customAuthFailureHandler;
            this.customLogoutSuccessHandler = customLogoutSuccessHandler;
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login.html")
                    .failureUrl("/login.html?error=true")
                    .failureHandler(customAuthFailureHandler)
                    .permitAll()
                    .and()
                .logout()
                    .permitAll()
                    .deleteCookies("JSESSIONID")
                    .logoutSuccessHandler(customLogoutSuccessHandler);
        }
    }

    public static class CustomAuthFailureHandler implements AuthenticationFailureHandler {
        // Implement your custom logic here
    }

    public static class CustomLogoutSuccessHandler implements LogoutSuccessHandler {
        // Implement your custom logic here
    }
}