import java.util.Arrays;
import org.springframework.web.cors.CorsConfiguration;

public class Temp1846 {
    public static void main(String[] args) {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(Arrays.asList("http://localhost:4200"));
        System.out.println("CORS configuration set with allowed origin patterns: " + configuration.getAllowedOriginPatterns());
    }
}