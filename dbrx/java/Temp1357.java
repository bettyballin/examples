import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;

public class Temp1357 {
    public static void main(String[] args) {
        Temp1357 temp = new Temp1357();
        CorsConfiguration config = temp.corsConfiguration();
        System.out.println("CORS Configuration: " + config);
    }

    @Bean
    public CorsConfiguration corsConfiguration() {
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:4200");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        return config;
    }
}