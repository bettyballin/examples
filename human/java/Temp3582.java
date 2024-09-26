import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class CircularReferenceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CircularReferenceApplication.class, args);
    }
}

@Configuration
class AppConfig {

    @Bean
    public BeanA beanA(BeanB beanB) {
        return new BeanA(beanB);
    }

    @Bean
    public BeanB beanB(BeanA beanA) {
        return new BeanB(beanA);
    }
}

class BeanA {
    private final BeanB beanB;

    public BeanA(BeanB beanB) {
        this.beanB = beanB;
    }

    // getters, setters, and other methods
}

class BeanB {
    private final BeanA beanA;

    public BeanB(BeanA beanA) {
        this.beanA = beanA;
    }

    // getters, setters, and other methods
}

application.properties:

spring.main.allow-circular-references=true