import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.oauth2.jwt.JwtDecoder;

@Configuration(proxyBeanMethods = false)
@Import({AadPropertiesConfiguration.class})
public class AadAutoConfiguration {

  @Bean
  @ConditionalOnMissingBean(JwtDecoder.class)
  public JwtDecoder jwtDecoder(
      RestTemplateBuilder restTemplateBuilder,
      AadAuthenticationProperties aadAuthenticationProperties) {
    AadResourceServerConfiguration configuration =
        new AadResourceServerConfiguration(restTemplateBuilder);
    return configuration.jwtDecoder(aadAuthenticationProperties);
  }
}