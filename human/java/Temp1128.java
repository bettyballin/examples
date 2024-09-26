import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.saml.websso.WebSSOProfileConsumerImpl;
import org.springframework.security.saml.websso.SingleLogoutProfileImpl;

@Configuration
public class SAMLConfig {

    @Bean
    public WebSSOProfileConsumerImpl webSSOProfileConsumer() {
        WebSSOProfileConsumerImpl consumer = new WebSSOProfileConsumerImpl();
        consumer.setResponseSkew(600); // 10 minutes
        return consumer;
    }

    @Bean
    public SingleLogoutProfileImpl logoutProfile() {
        SingleLogoutProfileImpl logout = new SingleLogoutProfileImpl();
        logout.setResponseSkew(600); // 10 minutes
        return logout;
    }
}