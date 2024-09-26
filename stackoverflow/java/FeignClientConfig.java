import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import feign.auth.BasicAuthRequestInterceptor;

@Component
public class FeignClientConfig {

    private final LoginProperties loginProperties;

    @Autowired
    public FeignClientConfig(LoginProperties loginProperties) {
        this.loginProperties = loginProperties;
    }

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor(loginProperties.getUserName(), loginProperties.getPassword());
    }
}