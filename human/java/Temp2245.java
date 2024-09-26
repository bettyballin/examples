import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({MySecurityConfigurer.class, MyWebConfigurer.class})
public class MainConfig {
}

class MySecurityConfigurer {
    // Configuration details for security
}

class MyWebConfigurer {
    // Configuration details for web
}