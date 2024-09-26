import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean
    public A filterA() {
        return new A();
    }
    
    @Bean
    public B filterB() {
        return new B();
    }
}