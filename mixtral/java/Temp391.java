import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;

@EnableWebSecurity
public class Temp391 {

    public static void main(String[] args) {
        System.out.println("Main method executed");
    }

    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
            .inMemory()
                .withClient("web")
                .secret("<your_client_secret>");
                // Add other required configurations here
    }
}