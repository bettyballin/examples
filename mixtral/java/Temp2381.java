import org.springframework.boot.web.servlet.server.ServletServerContainerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Temp2381 {
    public static void main(String[] args) {
        Temp2381 temp = new Temp2381();
        ServletServerContainerFactoryBean container = temp.createWebSocketContainer();
        // Do something with the container if needed
    }

    @Bean
    public ServletServerContainerFactoryBean createWebSocketContainer() {
        return new ServletServerContainerFactoryBean();
    }
}