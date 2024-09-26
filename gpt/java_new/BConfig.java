import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AConfig.class)
public class BConfig {

    @Bean
    public B b(A a) {
        B bean = new B();
        bean.setA(a);
        return bean;
    }
}