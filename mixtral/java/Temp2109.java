import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.server.ServerAccessDeniedHandler;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class Temp2109 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(Temp2109.class, args);
    }

    @Bean
    public ServerAccessDeniedHandler serverAccessDeniedHandler() {
        return (swe e) -> Mono.fromRunnable(() -> e.getResponse().setStatusCode(HttpStatus.FORBIDDEN));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .exceptionHandling()
                .accessDeniedHandler((request, response, accessDeniedException) -> {
                    serverAccessDeniedHandler().handle(request, response, accessDeniedException);
                });
    }
}