import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Configuration
public class AppConfig {

    @Bean
    public ShiroConfig shiroConfig() throws IOException {
        ShiroConfig config = new ShiroConfig();

        // Add the [main] section from shiro.ini
        config.addSection("main", readFile(new ClassPathResource("shiro.ini").getFile().getPath()));

        return config;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterChain() throws IOException {
        ShiroFilterFactoryBean factory = new ShiroFilterFactoryBean();

        // Set the custom ShiroConfig
        factory.setShiroConfig(shiroConfig());

        return factory;
    }

    private String readFile(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}

class ShiroConfig {
    public void addSection(String section, String content) {
        // Implementation of addSection
        System.out.println("Adding section: " + section + " with content: " + content);
    }
}