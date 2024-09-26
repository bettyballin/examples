import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Temp3689 {
    public static void main(String[] args) {
        Temp3689 temp = new Temp3689();
        HttpSessionEventPublisher publisher = temp.httpSessionEventPublisher();
        System.out.println("HttpSessionEventPublisher bean created: " + (publisher != null));
    }

    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }
}