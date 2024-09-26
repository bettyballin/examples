import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SomeClass16 {

    private EnvironmentConfig environmentConfig;

    @Autowired
    public SomeClass16(EnvironmentConfig environmentConfig) {
        this.environmentConfig = environmentConfig;
    }

    public UUID getHomeOrgUUID() {
        return UUID.fromString(environmentConfig.getHomeOrg());
    }
}

@Component
class EnvironmentConfig {

    @Autowired
    private org.springframework.core.env.Environment env;

    public String getHomeOrg() {
        return env.getProperty("home.org");
    }
}