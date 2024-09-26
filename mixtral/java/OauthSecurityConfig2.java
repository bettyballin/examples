import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class OauthSecurityConfig implements WebMvcConfigurer {

    @Autowired
    private CustomOauthService customOauthService;

    // Add your configuration methods here
}

class CustomOauthService {
    // Define your service methods here
}