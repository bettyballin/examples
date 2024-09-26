import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class Temp1832 implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://myui.com", "https://myui.com");
    }

    public static void main(String[] args) {
        // Spring Boot application context would call the addCorsMappings method
        // This main method is just to satisfy the Java entry point requirements.
    }
}