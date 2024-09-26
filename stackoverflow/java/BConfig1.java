import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AConfig.class)
public class BConfig1 {

    private final A a;

    @Autowired
    public BConfig1(A a) {
        this.a = a;
    }

    @Bean
    public B b() {
        B b = new B();
        b.setA(a);
        return b;
    }
}