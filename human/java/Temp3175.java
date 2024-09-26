import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.session.CookieWebSessionIdResolver;
import org.springframework.web.server.session.WebSessionIdResolver;

@SpringBootApplication
public class Temp3175 {
    public static void main(String[] args) {
        SpringApplication.run(Temp3175.class, args);
    }

    @Bean
    public WebSessionIdResolver webSessionIdResolver() {
        CookieWebSessionIdResolver resolver = new CookieWebSessionIdResolver();
        resolver.setCookieName("SESSION");
        resolver.addCookieInitializer((builder) -> {
            builder.path("/")
                    .httpOnly(true)
                    .secure(true)
                    .sameSite("None");
        });
        return resolver;
    }
}