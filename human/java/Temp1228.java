import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;

public class Temp1228 {
    public static void main(String[] args) {
        Temp1228 temp = new Temp1228();
        DefaultAuthenticationEventPublisher publisher = temp.defaultAuthenticationEventPublisher();
        System.out.println("DefaultAuthenticationEventPublisher created: " + (publisher != null));
    }

    @Bean
    public DefaultAuthenticationEventPublisher defaultAuthenticationEventPublisher(){
        return new DefaultAuthenticationEventPublisher();
    }
}