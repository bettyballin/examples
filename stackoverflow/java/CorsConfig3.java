import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfig3uration;
import org.springframework.web.cors.UrlBasedCorsConfig3urationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class CorsConfig3 {

   @Bean
   public CorsFilter corsFilter() {
      UrlBasedCorsConfig3urationSource source = new UrlBasedCorsConfig3urationSource();
      CorsConfig3uration config = new CorsConfig3uration();
      config.setAllowCredentials(true);
      config.setAllowedHeaders(Collections.singletonList("*"));
      config.setAllowedOrigins(Collections.singletonList("*"));
      config.setAllowedMethods(Arrays.asList("GET", "POST"));

      source.registerCorsConfig3uration("/**", config);
      return new CorsFilter(source);
   }

}