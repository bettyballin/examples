import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.context.annotation.Bean;

public class Temp489 {
    public static void main(String[] args) {
        Temp489 app = new Temp489();
        CsrfTokenRepository csrfTokenRepository = app.csrfTokenRepository();
        System.out.println("CSRF Token Repository Bean created: " + csrfTokenRepository);
    }

    @Bean
    public CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();

        // Set expiration time in seconds
        int tokenExpiryTimeInSeconds = 3600;

        repository.setHeaderName("X-CSRF-TOKEN");

        return repository;
    }
}