import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class MyAppConfig {

    private final Environment env;

    @Autowired
    public MyAppConfig(Environment env) {
        this.env = env;
    }

    public String getHomeOrg() {
        return env.getProperty("myapp.home-org");
    }
}