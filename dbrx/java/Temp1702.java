import java.util.Arrays;
import java.util.List;

public class Temp1702 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
    }
}

class Configuration {
    private List<String> allowedOrigins;

    public void setAllowedOrigins(List<String> allowedOrigins) {
        this.allowedOrigins = allowedOrigins;
    }

    public List<String> getAllowedOrigins() {
        return allowedOrigins;
    }
}