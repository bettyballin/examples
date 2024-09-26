import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        // Register resources and providers
        register(new SpringComponentProvider());
        
        // Enable CORS (optional, can be customized)
        register(CORSFilter.class);
    }
}

// Dummy class to make the code executable, you should use the actual implementation
class SpringComponentProvider {}

// Dummy CORS Filter class
class CORSFilter {}