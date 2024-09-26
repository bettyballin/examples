import java.util.Arrays;
import java.util.List;

public class Temp1847 {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT"));
    }
}

class Configuration {
    private List<String> allowedMethods;

    public void setAllowedMethods(List<String> allowedMethods) {
        this.allowedMethods = allowedMethods;
    }
}