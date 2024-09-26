import java.util.Arrays;
import java.util.List;

class Config {
    private List<String> allowedMethods;

    public void setAllowedMethods(List<String> allowedMethods) {
        this.allowedMethods = allowedMethods;
    }

    public List<String> getAllowedMethods() {
        return allowedMethods;
    }
}

public class Temp2751 {
    public static void main(String[] args) {
        Config config = new Config();
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));

        // Print the allowed methods to verify
        System.out.println("Allowed Methods: " + config.getAllowedMethods());
    }
}