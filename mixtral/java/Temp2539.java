import org.springframework.web.cors.CorsConfiguration;

public class Temp2539 {
    public static void main(String[] args) {
        CorsConfiguration config = new CorsConfiguration();
        
        config.addAllowedHeader("*");
        config.setAllowCredentials(true);
        config.setMaxAge(3600L);
        
        // Print the configuration to verify it's set correctly
        System.out.println("Allowed Headers: " + config.getAllowedHeaders());
        System.out.println("Allow Credentials: " + config.getAllowCredentials());
        System.out.println("Max Age: " + config.getMaxAge());
    }
}