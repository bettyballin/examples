import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.core.Authentication;

@Configuration
public class CustomSecurityExpressionRoot extends SecurityExpressionRoot {

    @Autowired
    private EnvironmentConfig environmentConfig;

    public CustomSecurityExpressionRoot(Authentication authentication) {
        super(authentication);
    }

    public void setEnvironmentConfig(EnvironmentConfig environmentConfig) {
        this.environmentConfig = environmentConfig;
    }

    @Override
    public boolean equals(Object obj) {
        // Custom implementation that uses the environment variable value
        if (obj instanceof CustomSecurityExpressionRoot) {
            return super.equals(obj);
        }

        return false;
    }

    @Override
    public int hashCode() {
        // Custom implementation that uses the environment variable value
        return super.hashCode();
    }
}

class EnvironmentConfig {
    // Add properties and methods for EnvironmentConfig
}