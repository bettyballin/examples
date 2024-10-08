import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Temp2940 {
    public static void main(String[] args) {
        // This is a configuration class, it won't actually run anything in the main method.
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                    .addMapping("/greeting-javaconfig")
                    .allowedOrigins("http://localhost:8080");
            }
        };
    }
}