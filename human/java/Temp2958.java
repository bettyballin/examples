import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Temp2958 {
    public static void main(String[] args) {
        // Main method can be used to run the Spring application if needed
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(
                                "https://example.com",
                                "https://www.example.com",
                                "http://192.168.1.12:3000",
                                "http://localhost:3000");
            }
        };
    }
}