import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        var context = SpringApplication.run(Application.class, args);
        B b = context.getBean(B.class);
        b.getA().print();
    }
}

@Configuration
class BConfig {
    @Bean
    public B b(A a) { // Autowired by Spring automatically
        return new B(a);
    }
}

@Component
class A {
    public void print() {
        System.out.println("Hello World");
    }
}

class B {
    private final A a;

    public B(A a) {
        this.a = a;
    }

    public A getA() {
        return a;
    }
}