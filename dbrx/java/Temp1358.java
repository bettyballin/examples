import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

@SpringBootApplication
public class Temp1358 {

    public static void main(String[] args) {
        SpringApplication.run(Temp1358.class, args);
    }

    @Bean
    public FilterRegistrationBean(corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(Arrays.asList("*"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("*"));
        corsConfiguration.setAllowedMethods(Arrays.asList("*"));
        
        source.registerCorsConfiguration("/**", corsConfiguration);

        CorsFilter filter = new CorsFilter(source);
        FilterRegistrationBean bean = new FilterRegistrationBean<>(filter);
        bean.setOrder(0);
        return bean;
    }
}