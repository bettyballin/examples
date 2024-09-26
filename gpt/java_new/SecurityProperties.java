import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "security")
public class SecurityProperties {
    private List<String> whitelistedIps = new ArrayList<>();

    public List<String> getWhitelistedIps() {
        return whitelistedIps;
    }

    public void setWhitelistedIps(List<String> whitelistedIps) {
        this.whitelistedIps = whitelistedIps;
    }
}