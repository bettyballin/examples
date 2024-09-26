import org.springframework.context.annotation.Configuration;
import io.swagger.annotations.Api;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Sso;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * Note: Since Springfox Swagger2 is not compatible with Spring Security OAuth2,
 * either remove @EnableOAuth2Sso and @EnableResourceServer from this configuration class
 * or use Springfox Swagger3 or OpenAPI instead.
 * For demonstration purposes, the two annotations are commented out below.
 */

@EnableSwagger2
@Configuration
//@EnableOAuth2Sso 
//@EnableResourceServer  
public class SwaggerConfiguration {
    // Configuration code here
}