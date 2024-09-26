import java.util.Arrays;
import org.springframework.web.cors.CorsConfiguration;

public class CorsConfigExample {
    public static void main(String[] args) {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
    }
}