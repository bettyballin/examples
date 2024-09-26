import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.method.DelegatingMethodSecurityMetadataSource;
import org.springframework.security.access.method.MethodSecurityMetadataSource;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.ExpressionBasedAnnotationAttributeFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .apply(new SpringSecurityConfiguration());
    }

    @Bean
    public MethodSecurityMetadataSource methodSecurityMetadataSource() {
        return new DelegatingMethodSecurityMetadataSource(
                new ExpressionBasedAnnotationAttributeFactory(new DefaultMethodSecurityExpressionHandler()));
    }

    // Dummy SpringSecurityConfiguration to make the code executable
    public static class SpringSecurityConfiguration implements org.springframework.security.config.annotation.SecurityConfigurer<org.springframework.security.config.annotation.web.builders.HttpSecurity, org.springframework.security.config.annotation.web.builders.WebSecurity> {
        @Override
        public void configure(HttpSecurity http) throws Exception {
            // Custom security configuration goes here
        }

        @Override
        public void init(HttpSecurity http) throws Exception {

        }
    }
}