import org.springframework.context.annotation.Bean;
import org.springframework.security.saml.websso.WebSSOProfileConsumer;
import org.springframework.security.saml.websso.WebSSOProfileConsumerImpl;

public class Config {

    @Bean
    public WebSSOProfileConsumer webSSOProfileConsumer() {
        WebSSOProfileConsumerImpl webSSOProfileConsumer = new WebSSOProfileConsumerImpl();
        webSSOProfileConsumer.setMaxAuthenticationAge(600); // 10 minutes in seconds
        return webSSOProfileConsumer;
    }
}