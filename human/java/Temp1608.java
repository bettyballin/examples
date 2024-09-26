import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.Ssl;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;

@SpringBootApplication
public class SslApplication {

    public static void main(String[] args) {
        SpringApplication.run(SslApplication.class, args);
    }

    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> customizeTomcat() {
        return factory -> {
            factory.setPort(9090);
            Ssl ssl = new Ssl();
            ssl.setKeyStore(new ClassPathResource("keystore.jks").getPath());
            ssl.setKeyStorePassword("{password}");
            ssl.setKeyAlias("myalias");
            factory.setSsl(ssl);
        };
    }
}

// application.properties
// server.port=9090
// server.ssl.key-store=classpath:keystore.jks
// server.ssl.key-store-password={password}
// security.require-ssl=true