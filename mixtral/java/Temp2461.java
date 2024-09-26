import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Temp2461 {

    public static void main(String[] args) {
        SpringApplication.run(Temp2461.class, args);
    }

    @EnableWebSecurity
    public class WebSecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http.authorizeHttpRequests(auth -> auth
                .mvcMatchers("/").access((authentication) -> {
                    String remoteAddress = ((WebAuthenticationDetails) authentication.getDetails()).getRemoteAddress();

                    if ("127.0.0.1".equals(remoteAddress))
                        return true;

                    throw new AccessDeniedException("Access denied");
                })
            );

            return http.build();
        }
    }
}