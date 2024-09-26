// The provided snippet appears to be configuration properties, not Java code.
// It is likely meant for an application.properties or application.yml file for a Spring Boot application.
// It cannot be directly refactored into Java code. However, to set these properties programmatically in Java,
// you could do something like the following in a Spring Boot application:

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;

@SpringBootApplication
public class SslApplication {

    public static void main(String[] args) {
        SpringApplication.run(SslApplication.class, args);
    }

    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> servletContainer() {
        return server -> {
            server.setPort(9090);
            server.getSsl().setKeyStore("classpath:keystore.jks");
            server.getSsl().setKeyStorePassword("{password}");
            server.getSsl().setEnabled(true);
        };
    }
}

// Note that "{password}