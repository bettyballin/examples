import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Your security configurations go here
        http.csrf().disable();
    }

    @Bean
    public ServletContextInitializer servletContainer() {
        return new ServletContextInitializer() {

            @Override
            public void onStartup(ServletContext servletContext) throws ServletException {
                servletContext.setInitParameter("server.ssl.client-auth", "need");
                servletContext.setInitParameter("server.ssl.key-store", "/path/to/your/keystore.jks"); 
                servletContext.setInitParameter("server.ssl.key-store-password", "password");  
                servletContext.setInitParameter("server.ssl.key-store-type", "JKS");  
                servletContext.setInitParameter("server.ssl.trust-store", "/path/to/your/truststore.jks");  
                servletContext.setInitParameter("server.ssl.trust-store-password", "password");  
                servletContext.setInitParameter("server.ssl.trust-store-type", "JKS");  
            }
        };
    }

}