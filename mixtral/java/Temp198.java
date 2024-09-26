import org.springframework.context.annotation.Bean;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

public class Temp198 {
    public static void main(String[] args) {
        Temp198 temp198 = new Temp198();
        HttpSessionSecurityContextRepository repository = temp198.httpSessionSecurityContextRepository();
        System.out.println("HttpSessionSecurityContextRepository bean created: " + repository);
    }

    @Bean
    public HttpSessionSecurityContextRepository httpSessionSecurityContextRepository() {
        return new HttpSessionSecurityContextRepository();
    }
}